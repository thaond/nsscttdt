package com.nss.portlet.managementworkflowjournal.service.persistence;

public class WorkflowJournalArticleFinderUtil {
    private static WorkflowJournalArticleFinder _finder;

    public static com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle getWorkflowJournalArticleByProcessDefinition(
        long processDefinitionId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .getWorkflowJournalArticleByProcessDefinition(processDefinitionId,
            start, end);
    }

    public static WorkflowJournalArticleFinder getFinder() {
        return _finder;
    }

    public void setFinder(WorkflowJournalArticleFinder finder) {
        _finder = finder;
    }
}
