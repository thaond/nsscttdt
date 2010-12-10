package com.nss.portlet.department.service.persistence;

import java.util.Iterator;
import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.User;
import com.liferay.portal.model.impl.UserImpl;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.nss.portlet.department.model.PmlUser;
import com.nss.portlet.department.model.impl.PmlUserImpl;

public class PmlUserFinderImpl extends BasePersistenceImpl implements PmlUserFinder{
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
	
	/**
	 * PHAN QUYEN THEO DOI HS 
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
