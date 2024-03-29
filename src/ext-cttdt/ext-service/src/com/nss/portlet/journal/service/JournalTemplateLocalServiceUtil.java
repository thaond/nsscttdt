package com.nss.portlet.journal.service;


/**
 * <a href="JournalTemplateLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.journal.service.JournalTemplateLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.journal.service.JournalTemplateLocalService
 *
 */
public class JournalTemplateLocalServiceUtil {
    private static JournalTemplateLocalService _service;

    public static com.nss.portlet.journal.model.JournalTemplate addJournalTemplate(
        com.nss.portlet.journal.model.JournalTemplate journalTemplate)
        throws com.liferay.portal.SystemException {
        return getService().addJournalTemplate(journalTemplate);
    }

    public static com.nss.portlet.journal.model.JournalTemplate createJournalTemplate(
        long id) {
        return getService().createJournalTemplate(id);
    }

    public static void deleteJournalTemplate(long id)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteJournalTemplate(id);
    }

    public static void deleteJournalTemplate(
        com.nss.portlet.journal.model.JournalTemplate journalTemplate)
        throws com.liferay.portal.SystemException {
        getService().deleteJournalTemplate(journalTemplate);
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

    public static com.nss.portlet.journal.model.JournalTemplate getJournalTemplate(
        long id)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getJournalTemplate(id);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalTemplate> getJournalTemplates(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getJournalTemplates(start, end);
    }

    public static int getJournalTemplatesCount()
        throws com.liferay.portal.SystemException {
        return getService().getJournalTemplatesCount();
    }

    public static com.nss.portlet.journal.model.JournalTemplate updateJournalTemplate(
        com.nss.portlet.journal.model.JournalTemplate journalTemplate)
        throws com.liferay.portal.SystemException {
        return getService().updateJournalTemplate(journalTemplate);
    }

    public static com.nss.portlet.journal.model.JournalTemplate updateJournalTemplate(
        com.nss.portlet.journal.model.JournalTemplate journalTemplate,
        boolean merge) throws com.liferay.portal.SystemException {
        return getService().updateJournalTemplate(journalTemplate, merge);
    }

    public static com.nss.portlet.journal.model.JournalTemplate addTemplate(
        long userId, long groupId, java.lang.String templateId,
        boolean autoTemplateId, java.lang.String structureId,
        java.lang.String name, java.lang.String description,
        java.lang.String xsl, boolean formatXsl, java.lang.String langType,
        boolean cacheable, boolean smallImage, java.lang.String smallImageURL,
        java.io.File smallFile,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .addTemplate(userId, groupId, templateId, autoTemplateId,
            structureId, name, description, xsl, formatXsl, langType,
            cacheable, smallImage, smallImageURL, smallFile, serviceContext);
    }

    public static com.nss.portlet.journal.model.JournalTemplate addTemplate(
        java.lang.String uuid, long userId, long groupId,
        java.lang.String templateId, boolean autoTemplateId,
        java.lang.String structureId, java.lang.String name,
        java.lang.String description, java.lang.String xsl, boolean formatXsl,
        java.lang.String langType, boolean cacheable, boolean smallImage,
        java.lang.String smallImageURL, java.io.File smallFile,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .addTemplate(uuid, userId, groupId, templateId,
            autoTemplateId, structureId, name, description, xsl, formatXsl,
            langType, cacheable, smallImage, smallImageURL, smallFile,
            serviceContext);
    }

    public static void addTemplateResources(long groupId,
        java.lang.String templateId, boolean addCommunityPermissions,
        boolean addGuestPermissions)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService()
            .addTemplateResources(groupId, templateId, addCommunityPermissions,
            addGuestPermissions);
    }

    public static void addTemplateResources(
        com.nss.portlet.journal.model.JournalTemplate template,
        boolean addCommunityPermissions, boolean addGuestPermissions)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService()
            .addTemplateResources(template, addCommunityPermissions,
            addGuestPermissions);
    }

    public static void addTemplateResources(long groupId,
        java.lang.String templateId, java.lang.String[] communityPermissions,
        java.lang.String[] guestPermissions)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService()
            .addTemplateResources(groupId, templateId, communityPermissions,
            guestPermissions);
    }

    public static void addTemplateResources(
        com.nss.portlet.journal.model.JournalTemplate template,
        java.lang.String[] communityPermissions,
        java.lang.String[] guestPermissions)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService()
            .addTemplateResources(template, communityPermissions,
            guestPermissions);
    }

    public static void checkNewLine(long groupId, java.lang.String templateId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().checkNewLine(groupId, templateId);
    }

    public static com.nss.portlet.journal.model.JournalTemplate copyTemplate(
        long userId, long groupId, java.lang.String oldTemplateId,
        java.lang.String newTemplateId, boolean autoTemplateId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .copyTemplate(userId, groupId, oldTemplateId, newTemplateId,
            autoTemplateId);
    }

    public static void deleteTemplate(long groupId, java.lang.String templateId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteTemplate(groupId, templateId);
    }

    public static void deleteTemplate(
        com.nss.portlet.journal.model.JournalTemplate template)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteTemplate(template);
    }

    public static void deleteTemplates(long groupId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteTemplates(groupId);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalTemplate> getStructureTemplates(
        long groupId, java.lang.String structureId)
        throws com.liferay.portal.SystemException {
        return getService().getStructureTemplates(groupId, structureId);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalTemplate> getStructureTemplates(
        long groupId, java.lang.String structureId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getStructureTemplates(groupId, structureId, start, end);
    }

    public static int getStructureTemplatesCount(long groupId,
        java.lang.String structureId) throws com.liferay.portal.SystemException {
        return getService().getStructureTemplatesCount(groupId, structureId);
    }

    public static com.nss.portlet.journal.model.JournalTemplate getTemplate(
        long id)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getTemplate(id);
    }

    public static com.nss.portlet.journal.model.JournalTemplate getTemplate(
        long groupId, java.lang.String templateId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getTemplate(groupId, templateId);
    }

    public static com.nss.portlet.journal.model.JournalTemplate getTemplateBySmallImageId(
        long smallImageId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getTemplateBySmallImageId(smallImageId);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalTemplate> getTemplates()
        throws com.liferay.portal.SystemException {
        return getService().getTemplates();
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalTemplate> getTemplates(
        long groupId) throws com.liferay.portal.SystemException {
        return getService().getTemplates(groupId);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalTemplate> getTemplates(
        long groupId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getService().getTemplates(groupId, start, end);
    }

    public static int getTemplatesCount(long groupId)
        throws com.liferay.portal.SystemException {
        return getService().getTemplatesCount(groupId);
    }

    public static boolean hasTemplate(long groupId, java.lang.String templateId)
        throws com.liferay.portal.SystemException {
        return getService().hasTemplate(groupId, templateId);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalTemplate> search(
        long companyId, long groupId, java.lang.String keywords,
        java.lang.String structureId, java.lang.String structureIdComparator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .search(companyId, groupId, keywords, structureId,
            structureIdComparator, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalTemplate> search(
        long companyId, long groupId, java.lang.String templateId,
        java.lang.String structureId, java.lang.String structureIdComparator,
        java.lang.String name, java.lang.String description,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .search(companyId, groupId, templateId, structureId,
            structureIdComparator, name, description, andOperator, start, end,
            obc);
    }

    public static int searchCount(long companyId, long groupId,
        java.lang.String keywords, java.lang.String structureId,
        java.lang.String structureIdComparator)
        throws com.liferay.portal.SystemException {
        return getService()
                   .searchCount(companyId, groupId, keywords, structureId,
            structureIdComparator);
    }

    public static int searchCount(long companyId, long groupId,
        java.lang.String templateId, java.lang.String structureId,
        java.lang.String structureIdComparator, java.lang.String name,
        java.lang.String description, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getService()
                   .searchCount(companyId, groupId, templateId, structureId,
            structureIdComparator, name, description, andOperator);
    }

    public static com.nss.portlet.journal.model.JournalTemplate updateTemplate(
        long groupId, java.lang.String templateId,
        java.lang.String structureId, java.lang.String name,
        java.lang.String description, java.lang.String xsl, boolean formatXsl,
        java.lang.String langType, boolean cacheable, boolean smallImage,
        java.lang.String smallImageURL, java.io.File smallFile,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .updateTemplate(groupId, templateId, structureId, name,
            description, xsl, formatXsl, langType, cacheable, smallImage,
            smallImageURL, smallFile, serviceContext);
    }

    public static JournalTemplateLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("JournalTemplateLocalService is not set");
        }

        return _service;
    }

    public void setService(JournalTemplateLocalService service) {
        _service = service;
    }
}
