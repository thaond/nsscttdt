package com.nss.portlet.managementworkflowjournal.service.persistence;

public interface ManagementWorkflowJournalFinder {
    public java.util.List<com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal> getDateFromBetweenDateTo(
        java.sql.Timestamp now) throws com.liferay.portal.SystemException;

    public int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int countManagementWorkflowJournal(java.lang.String workflowName,
        int version, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public int countManagementWorkflowJournal(
        java.lang.String[] workflowNames, int version, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal> findManagementWorkflowJournal(
        java.lang.String workflowName, int version, int start, int end,
        boolean andOperator,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal> findManagementWorkflowJournal(
        java.lang.String[] workflowNames, int version, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;
}
