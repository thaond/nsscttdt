package com.nss.portlet.managementworkflowjournal.service.persistence;

public interface LogWorkflowJournalArticleFinder {
    public com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle getLogBy_R_T(
        long resourcePrimkey) throws com.liferay.portal.SystemException;
}
