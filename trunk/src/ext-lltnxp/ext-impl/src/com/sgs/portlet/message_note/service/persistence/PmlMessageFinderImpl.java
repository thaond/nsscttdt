package com.sgs.portlet.message_note.service.persistence;

import java.util.Iterator;
import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.sgs.portlet.message_note.model.PmlMessage;
import com.sgs.portlet.message_note.model.impl.PmlMessageImpl;

@SuppressWarnings("unchecked")
public class PmlMessageFinderImpl extends BasePersistenceImpl implements PmlMessageFinder {
	
	// dem tong so luong van ban ma touser nhan duoc, ko can biet do la vb den hay di
	public int getTotalDocumentByUser(List<Long> fromUserList, long toUserId) throws Exception {

		String fromUserString = "";
		if (fromUserList.size() != 0) {
			for (int i = 0; i < fromUserList.size()-1; i ++) {
				fromUserString += fromUserList.get(i) + ", ";
			}
			fromUserString += fromUserList.get(fromUserList.size()-1);
		}
		else {
			fromUserString += "0";
		}
		
		Session session = null;
		try {
			session = openSession();

			String sql = "SELECT COUNT(fromuserid) AS COUNT_VALUE FROM pml_message_note";
			sql += " WHERE fromuserid in (" + fromUserString + ") AND touserid = " + toUserId;
			sql += " AND isalert = false";
			
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
	
	// lay danh sach van ban ma touser nhan duoc, phan biet nguoi gui va loai vb den/di
	public List<PmlMessage> getDocumentListByUser(long fromUserId, long toUserId, Class clazz) throws Exception {

		Session session = null;
		try {
			session = openSession();

			String sql = "SELECT * FROM pml_message_note";
			sql += " WHERE fromuserid = " + fromUserId + " AND touserid = " + toUserId;
			sql += " AND objecttype like '" + clazz.getName() + "'";
			sql += " AND isalert = false";
			
			SQLQuery q = session.createSQLQuery(sql);
			
			q.addEntity("pml_message_note", PmlMessageImpl.class);
			
			return (List<PmlMessage>)QueryUtil.list(q, getDialect(), -1, -1);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
}