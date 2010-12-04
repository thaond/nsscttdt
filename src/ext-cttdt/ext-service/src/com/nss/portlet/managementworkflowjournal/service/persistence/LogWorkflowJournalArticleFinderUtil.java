package com.nss.portlet.managementworkflowjournal.service.persistence;

public class LogWorkflowJournalArticleFinderUtil {
    private static LogWorkflowJournalArticleFinder _finder;

    public static com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle getLogBy_R_T(
        long resourcePrimkey) throws com.liferay.portal.SystemException {
        return getFinder().getLogBy_R_T(resourcePrimkey);
    }

    public static LogWorkflowJournalArticleFinder getFinder() {
        return _finder;
    }

    public void setFinder(LogWorkflowJournalArticleFinder finder) {
        _finder = finder;
    }
}
