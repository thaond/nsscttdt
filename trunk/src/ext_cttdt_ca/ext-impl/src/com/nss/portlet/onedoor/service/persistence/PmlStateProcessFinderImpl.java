/**
 * Dinh nghia cac ham de tuong tac hibernate
 * 
 * @author XUAN CONG
 */
package com.nss.portlet.onedoor.service.persistence;

import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.nss.portlet.onedoor.model.PmlStateProcess;
import com.nss.portlet.onedoor.model.impl.PmlStateProcessImpl;

public class PmlStateProcessFinderImpl extends BasePersistenceImpl
		implements PmlStateProcessFinder {

	/**
	 * Ham lay ve danh sach trang thai dua vao danh sach ma so
	 * 
	 * @param stateProcessIds Danh sach ma so trang thai
	 * @return
	 * @throws Exception
	 */
	public List<PmlStateProcess> findByStateProcessIds(
			List<Long> stateProcessIds) throws Exception {
		Session session = null;

		try {
			session = openSession();

			String sql = "SELECT DISTINCT(sp.*) ";
			sql += "FROM pml_stateprocess sp ";
			sql += "WHERE 1 = 0 ";
			
			// Duyet list de parse dieu kien loc du lieu
			for (Long stateProcessId : stateProcessIds) {
				sql += " OR stateprocessid = " + String.valueOf(stateProcessId.longValue());
			}
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlStateProcess",
					PmlStateProcessImpl.class);

			return (List<PmlStateProcess>) QueryUtil.list(q,
					getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
}
