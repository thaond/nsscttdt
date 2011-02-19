package com.sgs.portlet.department.service.persistence;

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
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.department.model.impl.DepartmentImpl;

/**
 * @author phmphuc
 */
public class DepartmentFinderImpl extends BasePersistenceImpl implements DepartmentFinder {
	
	public static String COUNT_BY_PMLDEPARTMENT = DepartmentFinder.class.getName() + ".countByPmlDepartment";
	public static String FIND_BY_PMLDEPARTMENT = DepartmentFinder.class.getName()+ ".findByPmlDepartment";
	
	//yenlt 05/04/2010
	
	public List<Department> findDepartments (String departmentsId, int start, int end, OrderByComparator obc) throws SystemException{
		
		Session session = null;
		
		try{
			session = openSession();
			
			String sql = "SELECT * ";
			
			sql += " FROM pml_departments";
			
			if ("tatca".equals(departmentsId)) {
				sql += "";
			} 
			else {
				sql += " WHERE departmentsid = '" + departmentsId + "'";
			}
			
			sql += " ORDER BY departmentsname ASC";
			
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
			SQLQuery q = session.createSQLQuery(sql);
			
			q.addEntity("pml_departments", DepartmentImpl.class);
			
			return (List<Department>)QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public int countDepartments(String departmentsId) throws SystemException{
		Session session = null;
		
		try{
			session = openSession();
			
			String sql = "SELECT COUNT(*) AS COUNT_VALUE ";
			
			sql += " FROM pml_departments";
			
			if ("tatca".equals(departmentsId)) {
				sql += "";
			}
			else {
				sql += " WHERE departmentsid = '" + departmentsId + "'";
			}
			
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
	//end
	// minh 20100204
	
	public int countByKeywords(String keywords) throws SystemException{
		String[] pmlDepartmentCodes = null;
		String[] pmlDepartmentNames = null;		
		String[] pmlDepartmentAbbreviateNames = null;		
		boolean andOperator = false;
		if(Validator.isNotNull(keywords)){
			pmlDepartmentCodes = CustomSQLUtil.keywords(keywords, true);
			pmlDepartmentNames = CustomSQLUtil.keywords(keywords, true);		
			pmlDepartmentAbbreviateNames = CustomSQLUtil.keywords(keywords, true);		
		}else{
			andOperator = true;
		}
		
		return countByPmlDepartment(pmlDepartmentCodes, pmlDepartmentNames, pmlDepartmentAbbreviateNames, andOperator);
	}
	
	public int countByPmlDepartment(String pmlDepartmentCode, String pmlDepartmentName,
			String pmlDepartmentAbbreviateName,
			boolean andOperator) throws SystemException{
		return countByPmlDepartment(new String[]{pmlDepartmentCode}, new String[]{pmlDepartmentName},
				new String[]{pmlDepartmentAbbreviateName},  andOperator);
	}
	
	
	public int countByPmlDepartment(String[] pmlDepartmentCodes, String[] pmlDepartmentNames, 
			String[] pmlDepartmentAbbreviateNames,
			boolean andOperator) throws SystemException {
		pmlDepartmentCodes = CustomSQLUtil.keywords(pmlDepartmentCodes, true);
		pmlDepartmentNames = CustomSQLUtil.keywords(pmlDepartmentNames, true);
		pmlDepartmentAbbreviateNames = CustomSQLUtil.keywords(pmlDepartmentAbbreviateNames, true);
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_BY_PMLDEPARTMENT);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(pml_departments.departmentscode)", StringPool.LIKE, false, pmlDepartmentCodes);			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(pml_departments.departmentsname)", StringPool.LIKE, false, pmlDepartmentNames);			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(pml_departments.abbreviatename)", StringPool.LIKE, true, pmlDepartmentAbbreviateNames);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(pmlDepartmentCodes, 2);
			qpos.add(pmlDepartmentNames, 2);
			qpos.add(pmlDepartmentAbbreviateNames, 2);
			
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

	
	public List<Department> findByKeywords(String keywords, int start, int end, OrderByComparator obc) throws SystemException{
		String[] pmlDepartmentCodes = null;
		String[] pmlDepartmentNames = null;		
		String[] pmlDepartmentAbbreviateNames = null;	
		boolean andOperator = false;
		if(Validator.isNotNull(keywords)){
			pmlDepartmentCodes = CustomSQLUtil.keywords(keywords, true);
			pmlDepartmentNames = CustomSQLUtil.keywords(keywords, true);		
			pmlDepartmentAbbreviateNames = CustomSQLUtil.keywords(keywords, true);		
		}else{
			andOperator = true;
		}
		
		return findByPmlDepartment(pmlDepartmentCodes, pmlDepartmentNames, pmlDepartmentAbbreviateNames, andOperator, start, end, obc);
	}

	public List<Department> findByPmlDepartment(String pmlDepartmentCode, String pmlDepartmentName,
			String pmlDepartmentAbbreviateName, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException{
		return findByPmlDepartment(new String[]{pmlDepartmentCode}, new String[]{pmlDepartmentName},
				new String[]{pmlDepartmentAbbreviateName}, andOperator, start, end, obc);
	}
	
	public List<Department> findByPmlDepartment(String[] pmlDepartmentCodes, String[] pmlDepartmentNames, 
			String[] pmlDepartmentAbbreviateNames,
			boolean andOperator, int start, int end,
			OrderByComparator obc) throws SystemException {
		
		pmlDepartmentCodes = CustomSQLUtil.keywords(pmlDepartmentCodes, true);
		pmlDepartmentNames = CustomSQLUtil.keywords(pmlDepartmentNames, true);
		pmlDepartmentAbbreviateNames = CustomSQLUtil.keywords(pmlDepartmentAbbreviateNames, true);
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_PMLDEPARTMENT);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(pml_departments.departmentscode)", StringPool.LIKE, false, pmlDepartmentCodes);			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(pml_departments.departmentsname)", StringPool.LIKE, false, pmlDepartmentNames);			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(pml_departments.abbreviatename)", StringPool.LIKE, true, pmlDepartmentAbbreviateNames);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_departments", DepartmentImpl.class);
			
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(pmlDepartmentCodes,2);
			qpos.add(pmlDepartmentNames,2);
			qpos.add(pmlDepartmentAbbreviateNames,2);
			
			return (List<Department>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}
	// end 
	
	/**
	 * phmphuc 12/04/2010
	 * lay danh sach phong ban chinh
	 */
	public List<Department> findDepartmentsByDepartmentParentId() throws SystemException{
		
		Session session = null;
		
		try{
			session = openSession();
			
			String sql = " SELECT *";
			
			sql += " FROM pml_departments";
			
			sql += " WHERE (departmentsparentid is null OR departmentsparentid = '" + "')";
			
			sql += " ORDER BY departmentsname ASC";
			
			SQLQuery q = session.createSQLQuery(sql);
			
			q.addEntity("pml_departments", DepartmentImpl.class);
			
			return (List<Department>)QueryUtil.list(q, getDialect(), -1, -1);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	/**
	 * @author phmphuc
	 * lay danh sach phong ban chinh
	 */
	public List<Department> findDepartmentsByDepartmentParentId(int start, int end) throws SystemException{
		
		Session session = null;
		
		try{
			session = openSession();
			
			String sql = " SELECT *";
			
			sql += " FROM pml_departments";
			
			sql += " WHERE (departmentsparentid is null OR departmentsparentid = '" + "')";
			
			SQLQuery q = session.createSQLQuery(sql);
			
			q.addEntity("pml_departments", DepartmentImpl.class);
			
			return (List<Department>)QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public int countTinhHinhThuLyCongVanPhongBan() throws Exception {

		Session session = null;

		try {
			session = openSession();

			String sql = "SELECT COUNT(DISTINCT(departmentsid)) AS COUNT_VALUE";
			sql += " FROM pml_departments";
			sql += " WHERE (departmentsparentid is null OR departmentsparentid = '" + "')";

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
	
	public List<Department> findDepartmentsByCodeForValidate(String departmentsCode) throws SystemException{
		
		Session session = null;
		
		try{
			session = openSession();
			
			String sql = " SELECT *";
			
			sql += " FROM pml_departments";
			
			sql += " WHERE lower(departmentscode) like '" + departmentsCode.toLowerCase() + "'";
			
			SQLQuery q = session.createSQLQuery(sql);
			
			q.addEntity("pml_departments", DepartmentImpl.class);
			
			return (List<Department>)QueryUtil.list(q, getDialect(), -1, -1);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
}
