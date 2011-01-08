package com.sgs.portlet.pml_edm_docconfuser.service.persistence;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.sgs.portlet.document.model.PmlDocumentReceiptLog;
import com.sgs.portlet.document.model.PmlDocumentSendLog;
import com.sgs.portlet.document.model.impl.PmlDocumentReceiptLogImpl;
import com.sgs.portlet.document.model.impl.PmlDocumentSendLogImpl;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.pmluser.model.impl.PmlUserImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="PmlEdmDocConfUserFinderImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author XUANCONG
 *
 */
public class PmlEdmDocConfUserFinderImpl
	extends BasePersistenceImpl implements PmlEdmDocConfUserFinder {

	/**
	 * Get all receipt document log by the list of received document id
	 * @param recDocIdList ArrayList of received document id
	 * @return List of received document log
	 * @throws SystemException
	 */
	public List<PmlDocumentReceiptLog> findAllRecDocLogByDocIdList(
			ArrayList<Long> recDocIdList)
		throws SystemException {

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("SELECT pml_documentreceipt_log.* FROM pml_documentreceipt_log ");
			query.append("INNER JOIN pml_edm_documentreceipt ON ");
			query.append("pml_edm_documentreceipt.documentreceiptid = ");
			query.append("pml_documentreceipt_log.documentreceiptid ");
			query.append("WHERE (1=0) ");

			if (!recDocIdList.isEmpty() && (recDocIdList.size() > 0)) {

				for (int i = 0; i < recDocIdList.size(); i++) {
					query.append("OR pml_documentreceipt_log.documentreceiptid = ? ");
				}
			}

			SQLQuery q = session.createSQLQuery(query.toString());

			q.addEntity("PmlDocumentReceiptLog", PmlDocumentReceiptLogImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			if (!recDocIdList.isEmpty() && (recDocIdList.size() > 0)) {
				for (int i = 0; i < recDocIdList.size(); i++) {
					qPos.add(recDocIdList.get(i));
				}
			}

			return (List<PmlDocumentReceiptLog>)QueryUtil.list(
					q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Get all send document log by the list of sent document id
	 * @param senDocIdList ArrayList of sent document id
	 * @return List of sent document log
	 * @throws SystemException
	 */
	public List<PmlDocumentSendLog> findAllSendDocLogByDocIdList(
			ArrayList<Long> senDocIdList)
		throws SystemException {

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("SELECT pml_documentsend_log.* FROM pml_documentsend_log ");
			query.append("INNER JOIN pml_edm_documentsend ON ");
			query.append("pml_edm_documentsend.documentsendid = ");
			query.append("pml_documentsend_log.documentsendid ");
			query.append("WHERE (1=0) ");

			if (!senDocIdList.isEmpty() && (senDocIdList.size() > 0)) {

				for (int i = 0; i < senDocIdList.size(); i++) {
					query.append("OR pml_documentsend_log.documentsendid = ? ");
				}
			}

			SQLQuery q = session.createSQLQuery(query.toString());

			q.addEntity("PmlDocumentSendLog", PmlDocumentSendLogImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			if (!senDocIdList.isEmpty() && (senDocIdList.size() > 0)) {
				for (int i = 0; i < senDocIdList.size(); i++) {
					qPos.add(senDocIdList.get(i));
				}
			}

			return (List<PmlDocumentSendLog>)QueryUtil.list(
					q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}
	
	public List<PmlUser> findAllDepByUserIdList(
			ArrayList<Long> userIdList) 
	throws SystemException {

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append("SELECT pml_user.* FROM pml_user ");
			query.append("INNER JOIN user_ ON ");
			query.append("pml_user.userid = user_.userid ");
			query.append("INNER JOIN pml_departments ON ");
			query.append("pml_user.departmentsid = pml_departments.departmentsid ");
			query.append("WHERE (1=0) ");

			if (!userIdList.isEmpty() && (userIdList.size() > 0)) {

				for (int i = 0; i < userIdList.size(); i++) {
					query.append("OR pml_user.userid = ? ");
				}
			}

			SQLQuery q = session.createSQLQuery(query.toString());

			//xuancong close q.addEntity("User", UserImpl.class);
			q.addEntity("pml_user", PmlUserImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			if (!userIdList.isEmpty() && (userIdList.size() > 0)) {
				for (int i = 0; i < userIdList.size(); i++) {
					qPos.add(userIdList.get(i));
				}
			}

			return (List<PmlUser>)QueryUtil.list(
					q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}
}