package com.nss.portlet.managementworkflowjournal.service.persistence;

import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle;
import com.nss.portlet.managementworkflowjournal.model.impl.WorkflowJournalArticleImpl;

public class WorkflowJournalArticleFinderImpl extends BasePersistenceImpl implements WorkflowJournalArticleFinder{
	public static String GET_WORKFLOW_JOURNALARTICAL_BY_PROCESSDEFINITION = WorkflowJournalArticleFinder.class.getName()+ ".GET_WORKFLOW_JOURNALARTICAL_BY_PROCESSDEFINITION";
	
	public WorkflowJournalArticle getWorkflowJournalArticleByProcessDefinition(long processDefinitionId ,int start, int end) throws SystemException{
		WorkflowJournalArticle workflowJournalArticle = null;
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_WORKFLOW_JOURNALARTICAL_BY_PROCESSDEFINITION);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("nss_workflow_journal_article",  WorkflowJournalArticleImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(processDefinitionId);
			List<WorkflowJournalArticle> journalArticles = (List<WorkflowJournalArticle>) QueryUtil.list(query, getDialect(), start, end);
			if(journalArticles.size()>0){
				workflowJournalArticle = journalArticles.get(0);
			}
			return workflowJournalArticle;
		} catch (Exception e) {
			throw new SystemException();
		}finally{
			closeSession(session);
		}
	}
}
