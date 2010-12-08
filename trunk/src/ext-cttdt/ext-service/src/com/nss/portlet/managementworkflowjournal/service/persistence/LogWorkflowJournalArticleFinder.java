package com.nss.portlet.managementworkflowjournal.service.persistence;

public interface LogWorkflowJournalArticleFinder {
    public java.util.List<com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle> getAllLog(
        long resourcePrimkey) throws com.liferay.portal.SystemException;

    public com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle getLogBy_R_T(
        long resourcePrimkey) throws com.liferay.portal.SystemException;
}
