package com.sgs.portlet.document.receipt.service.persistence;

import java.util.Iterator;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

public class PmlEdmDocumentReceiptExtendFinderImpl extends BasePersistenceImpl
		implements PmlEdmDocumentReceiptExtendFinder {

	/**
	 * Lay ve chi so lon nhat cua lan gia han dua vao ma so van ban den
	 * 
	 * @param documentReceiptId Ma so van ban den
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public int getMaxOrderNoByDocumentReceiptId(long documentReceiptId) throws Exception {
		
		Session session = null;
		try {
			session = openSession();

			String sql = "SELECT MAX(extendorderno) AS COUNT_VALUE ";
			sql += " FROM pml_edm_documentreceiptextend ";
			sql += " WHERE documentreceiptid = " + documentReceiptId;

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
		} 
		catch (Exception e) {
			throw new SystemException(e);
		} 
		finally {
			closeSession(session);
		}
	}
}
