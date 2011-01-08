package com.ext.portlet.processtype.service.persistence;

import java.util.List;

import com.ext.portlet.processtype.model.ProcessType;
import com.ext.portlet.processtype.model.impl.ProcessTypeImpl;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

/**
 * @author phmphuc
 */

@SuppressWarnings("unchecked")
public class ProcessTypeFinderImpl extends BasePersistenceImpl implements ProcessTypeFinder {
	
	/**
	 * 05/06/2010
	 * lay danh sach Cach thuc xu ly dua vao documentid
	 */
	
	public List<ProcessType> getListProcessType(long documentReceiptId) throws Exception {
		Session session = null;
		try {
			session = openSession();

			String sql = "SELECT pt.* " +
						 "FROM pml_saveprocesstype sp, pml_processtype pt " +
						 "WHERE sp.flagprocesstype = pt.processtypeid AND sp.docid = " + documentReceiptId;
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_processtype", ProcessTypeImpl.class);

			return (List<ProcessType>) QueryUtil.list(q, getDialect(), -1, -1);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

}
