package com.sgs.portlet.pmluser.service.persistence;

import java.util.Iterator;
import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.model.impl.UserImpl;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.pmluser.service.persistence.PmlUserFinder;
import com.sgs.portlet.pmluser.model.impl.PmlUserImpl;

@SuppressWarnings("unchecked")
public class PmlUserFinderImpl extends BasePersistenceImpl implements PmlUserFinder {
	//Yenlt 05/04/2010
		
	public List<PmlUser> findListUserByDepartment (String departmentsId, int start, int end, OrderByComparator obc) throws SystemException{
			
		Session session = null;
		
		try{
			session = openSession();
			
			String sql = "SELECT * ";
			
			sql += " FROM pml_user";
			
			sql += " WHERE departmentsid = '" + departmentsId + "'";
			
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
			SQLQuery q = session.createSQLQuery(sql);
			
			q.addEntity("pml_user", PmlUserImpl.class);
			
			return (List<PmlUser>)QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public int countListUserByDepartments(String departmentsId) throws SystemException{
		Session session = null;
		
		try{
			session = openSession();
			
			String sql = "SELECT COUNT(*) AS COUNT_VALUE ";
			
			sql += " FROM pml_user";
			
			sql += " WHERE departmentsid = '" + departmentsId + "'";
			
			SQLQuery q = session.createSQLQuery(sql);
			
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			
			Iterator<Long> iter = q.list().iterator();
			
			if(iter.hasNext()){
				Long count = iter.next();
				if(count!= null){
					return count.intValue();
				}
			}
			return 0;
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	//minh 20100204
	public static String COUNT_BY_PMLUSER = PmlUserFinder.class.getName() + ".countByPmlUser";
	public static String FIND_BY_PMLUSER = PmlUserFinder.class.getName()+ ".findByPmlUser";	
	
	public int countByKeywords(String keywords) throws SystemException{
		String[] screenNames = null;
		String[] lastNames = null;		
		String[] middleNames = null;		
		String[] firstNames = null;		
		//String[] postionNames = null;
		String positionId = null;
		boolean andOperator = false;
		if(Validator.isNotNull(keywords)){
			screenNames = CustomSQLUtil.keywords(keywords, true);
			lastNames = CustomSQLUtil.keywords(keywords, true);		
			middleNames = CustomSQLUtil.keywords(keywords, true);		
			firstNames = CustomSQLUtil.keywords(keywords, true);		
			//postionNames = CustomSQLUtil.keywords(keywords, true);
		}
		else{
			andOperator = true;
		}
		
		//return countByPmlUser(screenNames, lastNames, middleNames, firstNames, postionNames, andOperator);
		return countByPmlUser(screenNames, lastNames, middleNames, firstNames, positionId, andOperator);
	}
	
	/* Tim theo ma so chuc vu chu ko phai ten chuc vu
	public int countByPmlUser(String screenName, String lastName,
			String middleName, String firstName, String postionName,
			boolean andOperator) throws SystemException{
		return countByPmlUser(new String[]{screenName}, new String[]{lastName}, 
				new String[]{middleName}, new String[]{firstName},
				new String[]{postionName}, andOperator);
	}
	*/
	
	public int countByPmlUser(String screenName, String lastName,
			String middleName, String firstName, String positionId,
			boolean andOperator) throws SystemException{
		
		return countByPmlUser(new String[]{screenName}, new String[]{lastName}, 
				new String[]{middleName}, new String[]{firstName},
				positionId, andOperator);
	}	

	/* Tim theo ma so chuc vu thay vi ten chuc vu
	public int countByPmlUser(String[]screenNames,
			String[] lastNames, String[] middleNames,
			String[] firstNames, String[] postionNames,
			boolean andOperator) throws SystemException {
	*/
	public int countByPmlUser(String[]screenNames,
			String[] lastNames, String[] middleNames,
			String[] firstNames, String positionId,
			boolean andOperator) throws SystemException {
		screenNames = CustomSQLUtil.keywords(screenNames, true);
		lastNames = CustomSQLUtil.keywords(lastNames, true);
		middleNames = CustomSQLUtil.keywords(middleNames, true);
		firstNames = CustomSQLUtil.keywords(firstNames, true);
		//postionNames = CustomSQLUtil.keywords(postionNames, true);
		if (positionId != null) {
			positionId = positionId.toLowerCase();
		}
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_BY_PMLUSER);
			
			//sql = CustomSQLUtil.replaceKeywords(sql, "lower(pml_position.positionname)", StringPool.LIKE, false, postionNames);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(pml_user.positionid)", StringPool.EQUAL, false, new String[]{positionId});
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(pml_user.screenname)", StringPool.LIKE, false, screenNames);			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(pml_user.lastname)", StringPool.LIKE, false, lastNames);			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(pml_user.middlename)", StringPool.LIKE, false, middleNames);			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(pml_user.firstname)", StringPool.LIKE, true, firstNames);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(new String[]{positionId}, 2);
			qpos.add(screenNames, 2);
			qpos.add(lastNames, 2);
			qpos.add(middleNames, 2);
			qpos.add(firstNames, 2);
			
			Iterator<Long> iter = q.list().iterator();
			if(iter.hasNext()){
				Long count = iter.next();
				if(count!= null){
					return count.intValue();
				}
			}
			return 0;
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}	
	
	public List<PmlUser> findByKeywords(String keywords, int start, int end, OrderByComparator obc) 
	throws SystemException{
		String[] screenNames = null;
		String[] lastNames = null;		
		String[] middleNames = null;		
		String[] firstNames = null;		
		//String[] postionNames = null;
		String positionId = null;
		boolean andOperator = false;
		if(Validator.isNotNull(keywords)){
			screenNames = CustomSQLUtil.keywords(keywords, true);
			lastNames = CustomSQLUtil.keywords(keywords, true);		
			middleNames = CustomSQLUtil.keywords(keywords, true);		
			firstNames = CustomSQLUtil.keywords(keywords, true);		
			//postionNames = CustomSQLUtil.keywords(keywords, true);		
		}
		else{
			andOperator = true;
		}		
		
		//return findByPmlUser(screenNames, lastNames, middleNames, firstNames, postionNames, andOperator, start, end, obc);
		return findByPmlUser(screenNames, lastNames, middleNames, firstNames, positionId, andOperator, start, end, obc);
	}

	/* Thay tim theo ten vi tri bang tim theo ma so vi tri
	public List<PmlUser> findByPmlUser(String screenName, String lastName,
			String middleName, String firstName, String postionName,
			boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException{
		return findByPmlUser(new String[]{screenName}, new String[]{lastName}, 
				new String[]{middleName}, new String[]{firstName},
				new String[]{postionName}, andOperator, start, end, obc);
	}
	*/
	
	public List<PmlUser> findByPmlUser(String screenName, String lastName,
			String middleName, String firstName, String positionId,
			boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException{
		return findByPmlUser(new String[]{screenName}, new String[]{lastName}, 
				new String[]{middleName}, new String[]{firstName},
				positionId, andOperator, start, end, obc);
	}

	/* Thay tim bang ma so vi tri cho ten vi tri
	public List<PmlUser> findByPmlUser(String[]screenNames,
			String[] lastNames, String[] middleNames,
			String[] firstNames, String[] postionNames,
			boolean andOperator, int start, int end,
			OrderByComparator obc) throws SystemException {
	*/
	public List<PmlUser> findByPmlUser(String[]screenNames,
			String[] lastNames, String[] middleNames,
			String[] firstNames, String positionId,
			boolean andOperator, int start, int end,
			OrderByComparator obc) throws SystemException {
		
		screenNames = CustomSQLUtil.keywords(screenNames, true);
		lastNames = CustomSQLUtil.keywords(lastNames, true);
		middleNames = CustomSQLUtil.keywords(middleNames, true);
		firstNames = CustomSQLUtil.keywords(firstNames, true);
		//postionNames = CustomSQLUtil.keywords(postionNames, true);
		if (positionId != null) {
			positionId = positionId.toLowerCase();
		}
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_PMLUSER);
			
			//sql = CustomSQLUtil.replaceKeywords(sql, "lower(pml_position.positionname)", StringPool.LIKE, false, postionNames);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(pml_user.positionid)", StringPool.EQUAL, false, new String[]{positionId});
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(pml_user.screenname)", StringPool.LIKE, false, screenNames);			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(pml_user.lastname)", StringPool.LIKE, false, lastNames);			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(pml_user.middlename)", StringPool.LIKE, false, middleNames);			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(pml_user.firstname)", StringPool.LIKE, true, firstNames);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_user", PmlUserImpl.class);
			
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(new String[]{positionId}, 2);
			qpos.add(screenNames, 2);
			qpos.add(lastNames, 2);
			qpos.add(middleNames, 2);
			qpos.add(firstNames, 2);
			
			return (List<PmlUser>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}
	//end
	
	/**
	 * phmphuc 16/04/2010
	 * lay danh sach user theo phong ban chinh
	 */
	public List<PmlUser> findUserListByDepartmentId(String departmentsId, 
			int start, int end, OrderByComparator obc) throws SystemException{
		
		Session session = null;

		try {
			session = openSession();

			String sql = " SELECT *";
			
			sql += " FROM pml_user";
			
			if (departmentsId.equals("chonphongban")) {
				sql += 	" WHERE screenname is not null AND screenname not like '' AND active = 'true'";
			}
			else {
				sql += 	" WHERE departmentsid in" +
						" (SELECT departmentsid FROM pml_departments" +
						" WHERE departmentsid = '" + departmentsId + "' OR departmentsparentid = '" + departmentsId + "')";
			}
			
			sql += " ORDER BY firstname, middlename, lastname";
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_user", PmlUserImpl.class);

			return (List<PmlUser>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public int countUserListByDepartmentId(String departmentsId) throws Exception {

		Session session = null;

		try {
			session = openSession();

			String sql = "SELECT COUNT(DISTINCT(userid)) AS COUNT_VALUE";
			
			sql += " FROM pml_user";
			
			if (departmentsId.equals("chonphongban")) {
				sql += 	" WHERE screenname is not null AND screenname not like '' AND active = 'true'";
			}
			else {
				sql += 	" WHERE departmentsid in" +
						" (SELECT departmentsid FROM pml_departments" +
						" WHERE departmentsid = '" + departmentsId + "' OR departmentsparentid = '" + departmentsId + "')";
			}
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			Long count = null;

			Iterator<Long> itr = q.list().iterator();

			if (itr.hasNext()) {
				count = itr.next();
			}

			if (count == null) {
				count = new Long(0);
			}

			return count.intValue();
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public int countTinhHinhThuLyCongVanChuyenVien(String departmentId) throws Exception {

		Session session = null;

		try {
			session = openSession();

			String sql = "SELECT COUNT(DISTINCT(userid)) AS COUNT_VALUE";
			
			sql += " FROM pml_user";
			
			sql += 	" WHERE departmentsid in" +
					" (SELECT departmentsid FROM pml_departments" +
					" WHERE departmentsid = '" + departmentId + "' OR departmentsparentid = '" + departmentId + "')";
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			Long count = null;

			Iterator<Long> itr = q.list().iterator();

			if (itr.hasNext()) {
				count = itr.next();
			}

			if (count == null) {
				count = new Long(0);
			}

			return count.intValue();
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}
	
	/**
	 * phmphuc 31/05/2010
	 * lay danh sach user theo phong ban - danh muc phong ban
	 */
	public List<PmlUser> findUserListByDepartment(String departmentsId, int start, int end) throws SystemException{
		
		Session session = null;

		try {
			session = openSession();

			String sql = " SELECT *";
			
			sql += " FROM pml_user";
			
			sql += " WHERE departmentsid = '" + departmentsId + "'"; 

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlUser", PmlUserImpl.class);

			return (List<PmlUser>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public int countUserListByDepartment(String departmentsId) throws Exception {

		Session session = null;

		try {
			session = openSession();

			String sql = "SELECT COUNT(DISTINCT(userid)) AS COUNT_VALUE";
			
			sql += " FROM pml_user";
			
			sql += " WHERE departmentsid = '" + departmentsId + "'";

			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			Long count = null;

			Iterator<Long> itr = q.list().iterator();

			if (itr.hasNext()) {
				count = itr.next();
			}

			if (count == null) {
				count = new Long(0);
			}

			return count.intValue();
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}
	// end
	
	/**
	 * PHAN QUYEN THEO DOI HS 18/10/2010
	 * @throws SystemException 
	 */
	
	public List<User> listUserTheoDoiHoSo(int start, int end, OrderByComparator obc) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			String sql = "SELECT user_.*";
			sql += " FROM user_ LEFT JOIN pml_user";
			sql += " ON user_.userid = pml_user.userid ";
			
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("user_", UserImpl.class);

			return (List<User>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public int countUserTheoDoiHoSo() throws SystemException {
		Session session = null;
		
		try {
			session = openSession();
			
			String sql = "SELECT COUNT(*) AS COUNT_VALUE ";
			sql += " FROM user_ LEFT JOIN pml_user";
			sql += " ON user_.userid = pml_user.userid ";
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			Long count = null;

			Iterator<Long> itr = q.list().iterator();

			if (itr.hasNext()) {
				count = itr.next();
			}

			if (count == null) {
				count = new Long(0);
			}

			return count.intValue();
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
}