/**
 * 
 */

package com.nss.portlet.managementworkflowjournal.service.persistence;

import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle;
import com.nss.portlet.managementworkflowjournal.model.impl.LogWorkflowJournalArticleImpl;

/**
 * @author Tu
 */
public class LogWorkflowJournalArticleFinderImpl extends BasePersistenceImpl
	implements LogWorkflowJournalArticleFinder {

	public static String GET_LOG_WORKFLOW_JOURNAL_ARTICLE_BY_R_T =
		LogWorkflowJournalArticleFinder.class.getName() +
			".GET_LOG_WORKFLOW_JOURNAL_ARTICLE_BY_R_T";

	public LogWorkflowJournalArticle getLogBy_R_T(long resourcePrimkey)
		throws SystemException {

		LogWorkflowJournalArticle result = null;
		Session session = null;
		try {
			session = openSession();
			String sql =
				CustomSQLUtil.get(GET_LOG_WORKFLOW_JOURNAL_ARTICLE_BY_R_T);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(
				"log_workflow_journal_article",
				LogWorkflowJournalArticleImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(resourcePrimkey);
			List<LogWorkflowJournalArticle> list =
				(List<LogWorkflowJournalArticle>) QueryUtil.list(
					query, getDialect(), -1, -1);
			if (list.size() > 0) {
				result = list.get(0);
			}
			return result;
		}
		catch (Exception e) {
			throw new SystemException();
		}
		finally {
			closeSession(session);
		}
	}
}
