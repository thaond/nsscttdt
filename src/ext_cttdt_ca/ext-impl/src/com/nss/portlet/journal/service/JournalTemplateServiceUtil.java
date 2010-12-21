package com.nss.portlet.journal.service;


/**
 * <a href="JournalTemplateServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.journal.service.JournalTemplateService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.journal.service.JournalTemplateService
 *
 */
public class JournalTemplateServiceUtil {
    private static JournalTemplateService _service;

    public static com.nss.portlet.journal.model.JournalTemplate addTemplate(
        long groupId, java.lang.String templateId, boolean autoTemplateId,
        java.lang.String structureId, java.lang.String name,
        java.lang.String description, java.lang.String xsl, boolean formatXsl,
        java.lang.String langType, boolean cacheable,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .addTemplate(groupId, templateId, autoTemplateId,
            structureId, name, description, xsl, formatXsl, langType,
            cacheable, serviceContext);
    }

    public static com.nss.portlet.journal.model.JournalTemplate addTemplate(
        long groupId, java.lang.String templateId, boolean autoTemplateId,
        java.lang.String structureId, java.lang.String name,
        java.lang.String description, java.lang.String xsl, boolean formatXsl,
        java.lang.String langType, boolean cacheable, boolean smallImage,
        java.lang.String smallImageURL, java.io.File smallFile,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .addTemplate(groupId, templateId, autoTemplateId,
            structureId, name, description, xsl, formatXsl, langType,
            cacheable, smallImage, smallImageURL, smallFile, serviceContext);
    }

    public static com.nss.portlet.journal.model.JournalTemplate copyTemplate(
        long groupId, java.lang.String oldTemplateId,
        java.lang.String newTemplateId, boolean autoTemplateId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .copyTemplate(groupId, oldTemplateId, newTemplateId,
            autoTemplateId);
    }

    public static void deleteTemplate(long groupId, java.lang.String templateId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteTemplate(groupId, templateId);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalTemplate> getStructureTemplates(
        long groupId, java.lang.String structureId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getStructureTemplates(groupId, structureId);
    }

    public static com.nss.portlet.journal.model.JournalTemplate getTemplate(
        long groupId, java.lang.String templateId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getTemplate(groupId, templateId);
    }

    public static com.nss.portlet.journal.model.JournalTemplate updateTemplate(
        long groupId, java.lang.String templateId,
        java.lang.String structureId, java.lang.String name,
        java.lang.String description, java.lang.String xsl, boolean formatXsl,
        java.lang.String langType, boolean cacheable,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .updateTemplate(groupId, templateId, structureId, name,
            description, xsl, formatXsl, langType, cacheable, serviceContext);
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

    public static JournalTemplateService getService() {
        if (_service == null) {
            throw new RuntimeException("JournalTemplateService is not set");
        }

        return _service;
    }

    public void setService(JournalTemplateService service) {
        _service = service;
    }
}
