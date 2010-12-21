package com.nss.portlet.journal.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="JournalTemplateLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.nss.portlet.journal.service.impl.JournalTemplateLocalServiceImpl</code>.
 * Modify methods in that class and rerun ServiceBuilder to populate this class
 * and all other generated classes.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.journal.service.JournalTemplateLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface JournalTemplateLocalService {
    public com.nss.portlet.journal.model.JournalTemplate addJournalTemplate(
        com.nss.portlet.journal.model.JournalTemplate journalTemplate)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalTemplate createJournalTemplate(
        long id);

    public void deleteJournalTemplate(long id)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteJournalTemplate(
        com.nss.portlet.journal.model.JournalTemplate journalTemplate)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.journal.model.JournalTemplate getJournalTemplate(
        long id)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.journal.model.JournalTemplate> getJournalTemplates(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getJournalTemplatesCount()
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalTemplate updateJournalTemplate(
        com.nss.portlet.journal.model.JournalTemplate journalTemplate)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalTemplate updateJournalTemplate(
        com.nss.portlet.journal.model.JournalTemplate journalTemplate,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalTemplate addTemplate(
        long userId, long groupId, java.lang.String templateId,
        boolean autoTemplateId, java.lang.String structureId,
        java.lang.String name, java.lang.String description,
        java.lang.String xsl, boolean formatXsl, java.lang.String langType,
        boolean cacheable, boolean smallImage, java.lang.String smallImageURL,
        java.io.File smallFile,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalTemplate addTemplate(
        java.lang.String uuid, long userId, long groupId,
        java.lang.String templateId, boolean autoTemplateId,
        java.lang.String structureId, java.lang.String name,
        java.lang.String description, java.lang.String xsl, boolean formatXsl,
        java.lang.String langType, boolean cacheable, boolean smallImage,
        java.lang.String smallImageURL, java.io.File smallFile,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void addTemplateResources(long groupId, java.lang.String templateId,
        boolean addCommunityPermissions, boolean addGuestPermissions)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void addTemplateResources(
        com.nss.portlet.journal.model.JournalTemplate template,
        boolean addCommunityPermissions, boolean addGuestPermissions)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void addTemplateResources(long groupId, java.lang.String templateId,
        java.lang.String[] communityPermissions,
        java.lang.String[] guestPermissions)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void addTemplateResources(
        com.nss.portlet.journal.model.JournalTemplate template,
        java.lang.String[] communityPermissions,
        java.lang.String[] guestPermissions)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void checkNewLine(long groupId, java.lang.String templateId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalTemplate copyTemplate(
        long userId, long groupId, java.lang.String oldTemplateId,
        java.lang.String newTemplateId, boolean autoTemplateId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void deleteTemplate(long groupId, java.lang.String templateId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void deleteTemplate(
        com.nss.portlet.journal.model.JournalTemplate template)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void deleteTemplates(long groupId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.journal.model.JournalTemplate> getStructureTemplates(
        long groupId, java.lang.String structureId)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.journal.model.JournalTemplate> getStructureTemplates(
        long groupId, java.lang.String structureId, int start, int end)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getStructureTemplatesCount(long groupId,
        java.lang.String structureId) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.journal.model.JournalTemplate getTemplate(long id)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.journal.model.JournalTemplate getTemplate(
        long groupId, java.lang.String templateId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.journal.model.JournalTemplate getTemplateBySmallImageId(
        long smallImageId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.journal.model.JournalTemplate> getTemplates()
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.journal.model.JournalTemplate> getTemplates(
        long groupId) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.journal.model.JournalTemplate> getTemplates(
        long groupId, int start, int end)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getTemplatesCount(long groupId)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public boolean hasTemplate(long groupId, java.lang.String templateId)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.journal.model.JournalTemplate> search(
        long companyId, long groupId, java.lang.String keywords,
        java.lang.String structureId, java.lang.String structureIdComparator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.journal.model.JournalTemplate> search(
        long companyId, long groupId, java.lang.String templateId,
        java.lang.String structureId, java.lang.String structureIdComparator,
        java.lang.String name, java.lang.String description,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int searchCount(long companyId, long groupId,
        java.lang.String keywords, java.lang.String structureId,
        java.lang.String structureIdComparator)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int searchCount(long companyId, long groupId,
        java.lang.String templateId, java.lang.String structureId,
        java.lang.String structureIdComparator, java.lang.String name,
        java.lang.String description, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalTemplate updateTemplate(
        long groupId, java.lang.String templateId,
        java.lang.String structureId, java.lang.String name,
        java.lang.String description, java.lang.String xsl, boolean formatXsl,
        java.lang.String langType, boolean cacheable, boolean smallImage,
        java.lang.String smallImageURL, java.io.File smallFile,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;
}
