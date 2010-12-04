package com.nss.portlet.journalworkflow.service;


/**
 * <a href="JournalProcessDefinitionLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.journalworkflow.service.JournalProcessDefinitionLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.journalworkflow.service.JournalProcessDefinitionLocalService
 *
 */
public class JournalProcessDefinitionLocalServiceUtil {
    private static JournalProcessDefinitionLocalService _service;

    public static com.nss.portlet.journalworkflow.model.JournalProcessDefinition addJournalProcessDefinition(
        com.nss.portlet.journalworkflow.model.JournalProcessDefinition journalProcessDefinition)
        throws com.liferay.portal.SystemException {
        return getService().addJournalProcessDefinition(journalProcessDefinition);
    }

    public static com.nss.portlet.journalworkflow.model.JournalProcessDefinition createJournalProcessDefinition(
        long journalProcessDefinitionId) {
        return getService()
                   .createJournalProcessDefinition(journalProcessDefinitionId);
    }

    public static void deleteJournalProcessDefinition(
        long journalProcessDefinitionId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteJournalProcessDefinition(journalProcessDefinitionId);
    }

    public static void deleteJournalProcessDefinition(
        com.nss.portlet.journalworkflow.model.JournalProcessDefinition journalProcessDefinition)
        throws com.liferay.portal.SystemException {
        getService().deleteJournalProcessDefinition(journalProcessDefinition);
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

    public static com.nss.portlet.journalworkflow.model.JournalProcessDefinition getJournalProcessDefinition(
        long journalProcessDefinitionId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .getJournalProcessDefinition(journalProcessDefinitionId);
    }

    public static java.util.List<com.nss.portlet.journalworkflow.model.JournalProcessDefinition> getJournalProcessDefinitions(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getJournalProcessDefinitions(start, end);
    }

    public static int getJournalProcessDefinitionsCount()
        throws com.liferay.portal.SystemException {
        return getService().getJournalProcessDefinitionsCount();
    }

    public static com.nss.portlet.journalworkflow.model.JournalProcessDefinition updateJournalProcessDefinition(
        com.nss.portlet.journalworkflow.model.JournalProcessDefinition journalProcessDefinition)
        throws com.liferay.portal.SystemException {
        return getService()
                   .updateJournalProcessDefinition(journalProcessDefinition);
    }

    public static com.nss.portlet.journalworkflow.model.JournalProcessDefinition updateJournalProcessDefinition(
        com.nss.portlet.journalworkflow.model.JournalProcessDefinition journalProcessDefinition,
        boolean merge) throws com.liferay.portal.SystemException {
        return getService()
                   .updateJournalProcessDefinition(journalProcessDefinition,
            merge);
    }

    public static com.nss.portlet.journalworkflow.model.JournalProcessDefinition addJPD(
        com.nss.portlet.journalworkflow.model.JournalProcessDefinition jPD) {
        return getService().addJPD(jPD);
    }

    public static java.util.List<com.liferay.portlet.tags.model.TagsEntry> getListTagsEntry(
        long vocabularyId) {
        return getService().getListTagsEntry(vocabularyId);
    }

    public static JournalProcessDefinitionLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "JournalProcessDefinitionLocalService is not set");
        }

        return _service;
    }

    public void setService(JournalProcessDefinitionLocalService service) {
        _service = service;
    }
}
