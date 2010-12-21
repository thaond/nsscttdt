package com.nss.portlet.managementworkflowjournal.service.persistence;

public interface WorkflowJournalArticleFinder {
    public com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle getWorkflowJournalArticleByProcessDefinition(
        long processDefinitionId, int start, int end)
        throws com.liferay.portal.SystemException;
}
