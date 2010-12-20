package com.nss.portlet.managementworkflowjournal.service.persistence;

import java.sql.Timestamp;
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
import com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal;
import com.nss.portlet.managementworkflowjournal.model.impl.ManagementWorkflowJournalImpl;

public class ManagementWorkflowJournalFinderImpl extends BasePersistenceImpl implements ManagementWorkflowJournalFinder{
	public static String COUNTBY_WORKFLOWNAME_VERSION = ManagementWorkflowJournalFinder.class.getName()+ ".countBy_WORKFLOWNAME_VERSION";
	public static String FINDBY_WORKFLOWNAME_VERSION = ManagementWorkflowJournalFinder.class.getName()+ ".findBy_WORKFLOWNAME_VERSION";
	public static String GETBY_DATEFROM_BETWEEN_DATETO = ManagementWorkflowJournalFinder.class.getName()+ ".getBy_DATEFROM_BETWEEN_DATETO";
	
	
	public List<ManagementWorkflowJournal> getDateFromBetweenDateTo(Timestamp now ) throws SystemException{
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GETBY_DATEFROM_BETWEEN_DATETO);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("nss_quan_ly_quy_trinh_duyet_tin", ManagementWorkflowJournalImpl.class);
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(now);
			return (List<ManagementWorkflowJournal>) QueryUtil.list(q, getDialect(), -1, -1);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	
	public int countByKeywords(String keywords) throws SystemException {
		String[] workflowNames = null;

		boolean andOperator = false;
		if (Validator.isNotNull(keywords)) {
			workflowNames = CustomSQLUtil.keywords(keywords);
		} else {
			andOperator = true;
		}

		return countManagementWorkflowJournal(workflowNames, 0, andOperator);
	}

	public int countManagementWorkflowJournal(String workflowName, int version,  boolean andOperator) throws SystemException {
		return countManagementWorkflowJournal(new String[] { workflowName },version, andOperator);

	}

	public int countManagementWorkflowJournal(String[] workflowNames, int version,  boolean andOperator) throws SystemException {
		workflowNames = CustomSQLUtil.keywords(workflowNames);
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNTBY_WORKFLOWNAME_VERSION);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(nss_quan_ly_quy_trinh_duyet_tin.workflowname)", StringPool.LIKE, false, workflowNames);
			if (version == 0) {
				sql = sql.replace(" (nss_quan_ly_quy_trinh_duyet_tin.version_ = ?)", "(nss_quan_ly_quy_trinh_duyet_tin.version_ >= ?)");
			}
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(workflowNames, 2);
			qpos.add(version);

			Iterator<Long> iter = q.list().iterator();
			if (iter.hasNext()) {
				Long count = iter.next();
				if (count != null) {
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

	public List<ManagementWorkflowJournal> findByKeywords(String keywords, int start, int end,
			OrderByComparator obc) throws SystemException {

		String[] workflowNames = null;

		boolean andOperator = false;
		if (Validator.isNotNull(keywords)) {
			workflowNames = CustomSQLUtil.keywords(keywords, true);
		} else {
			andOperator = true;
		}

		return findManagementWorkflowJournal(workflowNames, 0, andOperator, start, end, obc);
	}

	public List<ManagementWorkflowJournal> findManagementWorkflowJournal(String workflowName, int version, int start, int end, boolean andOperator,
			OrderByComparator obc) throws SystemException {
		return findManagementWorkflowJournal(new String[] { workflowName },version, andOperator, start, end, obc);
	}

	public List<ManagementWorkflowJournal> findManagementWorkflowJournal(String[] workflowNames,
			int version, boolean andOperator,
			int start, int end, OrderByComparator obc) throws SystemException {
		workflowNames = CustomSQLUtil.keywords(workflowNames);
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FINDBY_WORKFLOWNAME_VERSION);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(nss_quan_ly_quy_trinh_duyet_tin.workflowname)",	StringPool.LIKE, false, workflowNames);
			if (version == 0) {
				sql = sql.replace(" (nss_quan_ly_quy_trinh_duyet_tin.version_ = ?)", "(nss_quan_ly_quy_trinh_duyet_tin.version_ >= ?)");
			}
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("nss_quan_ly_quy_trinh_duyet_tin", ManagementWorkflowJournalImpl.class);
			QueryPos qpos = QueryPos.getInstance(q);
			
			qpos.add(workflowNames, 2);
			qpos.add(version);
			return (List<ManagementWorkflowJournal>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			e.printStackTrace();
			throw new SystemException();
		} finally {
			closeSession(session);
		}
	}
}
