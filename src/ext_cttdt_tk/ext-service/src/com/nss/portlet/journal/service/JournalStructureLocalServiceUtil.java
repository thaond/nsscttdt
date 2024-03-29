package com.nss.portlet.journal.service;


/**
 * <a href="JournalStructureLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.journal.service.JournalStructureLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.journal.service.JournalStructureLocalService
 *
 */
public class JournalStructureLocalServiceUtil {
    private static JournalStructureLocalService _service;

    public static com.nss.portlet.journal.model.JournalStructure addJournalStructure(
        com.nss.portlet.journal.model.JournalStructure journalStructure)
        throws com.liferay.portal.SystemException {
        return getService().addJournalStructure(journalStructure);
    }

    public static com.nss.portlet.journal.model.JournalStructure createJournalStructure(
        long id) {
        return getService().createJournalStructure(id);
    }

    public static void deleteJournalStructure(long id)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteJournalStructure(id);
    }

    public static void deleteJournalStructure(
        com.nss.portlet.journal.model.JournalStructure journalStructure)
        throws com.liferay.portal.SystemException {
        getService().deleteJournalStructure(journalStructure);
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

    public static com.nss.portlet.journal.model.JournalStructure getJournalStructure(
        long id)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getJournalStructure(id);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalStructure> getJournalStructures(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getJournalStructures(start, end);
    }

    public static int getJournalStructuresCount()
        throws com.liferay.portal.SystemException {
        return getService().getJournalStructuresCount();
    }

    public static com.nss.portlet.journal.model.JournalStructure updateJournalStructure(
        com.nss.portlet.journal.model.JournalStructure journalStructure)
        throws com.liferay.portal.SystemException {
        return getService().updateJournalStructure(journalStructure);
    }

    public static com.nss.portlet.journal.model.JournalStructure updateJournalStructure(
        com.nss.portlet.journal.model.JournalStructure journalStructure,
        boolean merge) throws com.liferay.portal.SystemException {
        return getService().updateJournalStructure(journalStructure, merge);
    }

    public static com.nss.portlet.journal.model.JournalStructure addStructure(
        long userId, long groupId, java.lang.String structureId,
        boolean autoStructureId, java.lang.String parentStructureId,
        java.lang.String name, java.lang.String description,
        java.lang.String xsd,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .addStructure(userId, groupId, structureId, autoStructureId,
            parentStructureId, name, description, xsd, serviceContext);
    }

    public static com.nss.portlet.journal.model.JournalStructure addStructure(
        java.lang.String uuid, long userId, long groupId,
        java.lang.String structureId, boolean autoStructureId,
        java.lang.String parentStructureId, java.lang.String name,
        java.lang.String description, java.lang.String xsd,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .addStructure(uuid, userId, groupId, structureId,
            autoStructureId, parentStructureId, name, description, xsd,
            serviceContext);
    }

    public static void addStructureResources(long groupId,
        java.lang.String structureId, boolean addCommunityPermissions,
        boolean addGuestPermissions)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService()
            .addStructureResources(groupId, structureId,
            addCommunityPermissions, addGuestPermissions);
    }

    public static void addStructureResources(
        com.nss.portlet.journal.model.JournalStructure structure,
        boolean addCommunityPermissions, boolean addGuestPermissions)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService()
            .addStructureResources(structure, addCommunityPermissions,
            addGuestPermissions);
    }

    public static void addStructureResources(long groupId,
        java.lang.String structureId, java.lang.String[] communityPermissions,
        java.lang.String[] guestPermissions)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService()
            .addStructureResources(groupId, structureId, communityPermissions,
            guestPermissions);
    }

    public static void addStructureResources(
        com.nss.portlet.journal.model.JournalStructure structure,
        java.lang.String[] communityPermissions,
        java.lang.String[] guestPermissions)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService()
            .addStructureResources(structure, communityPermissions,
            guestPermissions);
    }

    public static void checkNewLine(long groupId, java.lang.String structureId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().checkNewLine(groupId, structureId);
    }

    public static com.nss.portlet.journal.model.JournalStructure copyStructure(
        long userId, long groupId, java.lang.String oldStructureId,
        java.lang.String newStructureId, boolean autoStructureId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .copyStructure(userId, groupId, oldStructureId,
            newStructureId, autoStructureId);
    }

    public static void deleteStructure(long groupId,
        java.lang.String structureId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteStructure(groupId, structureId);
    }

    public static void deleteStructure(
        com.nss.portlet.journal.model.JournalStructure structure)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteStructure(structure);
    }

    public static void deleteStructures(long groupId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteStructures(groupId);
    }

    public static com.nss.portlet.journal.model.JournalStructure getStructure(
        long id)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getStructure(id);
    }

    public static com.nss.portlet.journal.model.JournalStructure getStructure(
        long groupId, java.lang.String structureId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getStructure(groupId, structureId);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalStructure> getStructures()
        throws com.liferay.portal.SystemException {
        return getService().getStructures();
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalStructure> getStructures(
        long groupId) throws com.liferay.portal.SystemException {
        return getService().getStructures(groupId);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalStructure> getStructures(
        long groupId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getService().getStructures(groupId, start, end);
    }

    public static int getStructuresCount(long groupId)
        throws com.liferay.portal.SystemException {
        return getService().getStructuresCount(groupId);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalStructure> search(
        long companyId, long groupId, java.lang.String keywords, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().search(companyId, groupId, keywords, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalStructure> search(
        long companyId, long groupId, java.lang.String structureId,
        java.lang.String name, java.lang.String description,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .search(companyId, groupId, structureId, name, description,
            andOperator, start, end, obc);
    }

    public static int searchCount(long companyId, long groupId,
        java.lang.String keywords) throws com.liferay.portal.SystemException {
        return getService().searchCount(companyId, groupId, keywords);
    }

    public static int searchCount(long companyId, long groupId,
        java.lang.String structureId, java.lang.String name,
        java.lang.String description, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getService()
                   .searchCount(companyId, groupId, structureId, name,
            description, andOperator);
    }

    public static com.nss.portlet.journal.model.JournalStructure updateStructure(
        long groupId, java.lang.String structureId,
        java.lang.String parentStructureId, java.lang.String name,
        java.lang.String description, java.lang.String xsd,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .updateStructure(groupId, structureId, parentStructureId,
            name, description, xsd, serviceContext);
    }

    public static JournalStructureLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "JournalStructureLocalService is not set");
        }

        return _service;
    }

    public void setService(JournalStructureLocalService service) {
        _service = service;
    }
}
