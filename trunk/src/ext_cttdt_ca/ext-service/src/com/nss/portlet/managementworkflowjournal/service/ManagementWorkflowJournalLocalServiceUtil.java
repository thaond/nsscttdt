package com.nss.portlet.managementworkflowjournal.service;


/**
 * <a href="ManagementWorkflowJournalLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.managementworkflowjournal.service.ManagementWorkflowJournalLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.managementworkflowjournal.service.ManagementWorkflowJournalLocalService
 *
 */
public class ManagementWorkflowJournalLocalServiceUtil {
    private static ManagementWorkflowJournalLocalService _service;

    public static com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal addManagementWorkflowJournal(
        com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal managementWorkflowJournal)
        throws com.liferay.portal.SystemException {
        return getService()
                   .addManagementWorkflowJournal(managementWorkflowJournal);
    }

    public static com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal createManagementWorkflowJournal(
        long managementWorkflowJournalId) {
        return getService()
                   .createManagementWorkflowJournal(managementWorkflowJournalId);
    }

    public static void deleteManagementWorkflowJournal(
        long managementWorkflowJournalId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteManagementWorkflowJournal(managementWorkflowJournalId);
    }

    public static void deleteManagementWorkflowJournal(
        com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal managementWorkflowJournal)
        throws com.liferay.portal.SystemException {
        getService().deleteManagementWorkflowJournal(managementWorkflowJournal);
    }

    public static java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    public static java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    public static com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal getManagementWorkflowJournal(
        long managementWorkflowJournalId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .getManagementWorkflowJournal(managementWorkflowJournalId);
    }

    public static java.util.List<com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal> getManagementWorkflowJournals(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getManagementWorkflowJournals(start, end);
    }

    public static int getManagementWorkflowJournalsCount()
        throws com.liferay.portal.SystemException {
        return getService().getManagementWorkflowJournalsCount();
    }

    public static com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal updateManagementWorkflowJournal(
        com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal managementWorkflowJournal)
        throws com.liferay.portal.SystemException {
        return getService()
                   .updateManagementWorkflowJournal(managementWorkflowJournal);
    }

    public static com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal updateManagementWorkflowJournal(
        com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal managementWorkflowJournal,
        boolean merge) throws com.liferay.portal.SystemException {
        return getService()
                   .updateManagementWorkflowJournal(managementWorkflowJournal,
            merge);
    }

    public static com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal getDateFromBetweenDateTo(
        java.sql.Timestamp now) throws com.liferay.portal.SystemException {
        return getService().getDateFromBetweenDateTo(now);
    }

    public static int searchCount(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getService().searchCount(keywords);
    }

    public static java.util.List<com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal> search(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().search(keywords, start, end, obc);
    }

    public static int searchCount(java.lang.String workflowName, int version,
        boolean andOperator) throws com.liferay.portal.SystemException {
        return getService().searchCount(workflowName, version, andOperator);
    }

    public static java.util.List<com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal> search(
        java.lang.String workflowName, int version, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .search(workflowName, version, andOperator, start, end, obc);
    }

    public static ManagementWorkflowJournalLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "ManagementWorkflowJournalLocalService is not set");
        }

        return _service;
    }

    public void setService(ManagementWorkflowJournalLocalService service) {
        _service = service;
    }
}
