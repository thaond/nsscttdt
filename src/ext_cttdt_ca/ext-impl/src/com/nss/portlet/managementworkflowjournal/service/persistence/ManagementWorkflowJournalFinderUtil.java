package com.nss.portlet.managementworkflowjournal.service.persistence;

public class ManagementWorkflowJournalFinderUtil {
    private static ManagementWorkflowJournalFinder _finder;

    public static java.util.List<com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal> getDateFromBetweenDateTo(
        java.sql.Timestamp now) throws com.liferay.portal.SystemException {
        return getFinder().getDateFromBetweenDateTo(now);
    }

    public static int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getFinder().countByKeywords(keywords);
    }

    public static int countManagementWorkflowJournal(
        java.lang.String workflowName, int version, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countManagementWorkflowJournal(workflowName, version,
            andOperator);
    }

    public static int countManagementWorkflowJournal(
        java.lang.String[] workflowNames, int version, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countManagementWorkflowJournal(workflowNames, version,
            andOperator);
    }

    public static java.util.List<com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder().findByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal> findManagementWorkflowJournal(
        java.lang.String workflowName, int version, int start, int end,
        boolean andOperator,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findManagementWorkflowJournal(workflowName, version, start,
            end, andOperator, obc);
    }

    public static java.util.List<com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal> findManagementWorkflowJournal(
        java.lang.String[] workflowNames, int version, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findManagementWorkflowJournal(workflowNames, version,
            andOperator, start, end, obc);
    }

    public static ManagementWorkflowJournalFinder getFinder() {
        return _finder;
    }

    public void setFinder(ManagementWorkflowJournalFinder finder) {
        _finder = finder;
    }
}
