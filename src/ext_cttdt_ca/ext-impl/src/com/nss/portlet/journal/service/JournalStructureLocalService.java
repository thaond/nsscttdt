package com.nss.portlet.journal.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="JournalStructureLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.nss.portlet.journal.service.impl.JournalStructureLocalServiceImpl</code>.
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
 * @see com.nss.portlet.journal.service.JournalStructureLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface JournalStructureLocalService {
    public com.nss.portlet.journal.model.JournalStructure addJournalStructure(
        com.nss.portlet.journal.model.JournalStructure journalStructure)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalStructure createJournalStructure(
        long id);

    public void deleteJournalStructure(long id)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteJournalStructure(
        com.nss.portlet.journal.model.JournalStructure journalStructure)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.journal.model.JournalStructure getJournalStructure(
        long id)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.journal.model.JournalStructure> getJournalStructures(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getJournalStructuresCount()
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalStructure updateJournalStructure(
        com.nss.portlet.journal.model.JournalStructure journalStructure)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalStructure updateJournalStructure(
        com.nss.portlet.journal.model.JournalStructure journalStructure,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalStructure addStructure(
        long userId, long groupId, java.lang.String structureId,
        boolean autoStructureId, java.lang.String parentStructureId,
        java.lang.String name, java.lang.String description,
        java.lang.String xsd,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalStructure addStructure(
        java.lang.String uuid, long userId, long groupId,
        java.lang.String structureId, boolean autoStructureId,
        java.lang.String parentStructureId, java.lang.String name,
        java.lang.String description, java.lang.String xsd,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void addStructureResources(long groupId,
        java.lang.String structureId, boolean addCommunityPermissions,
        boolean addGuestPermissions)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void addStructureResources(
        com.nss.portlet.journal.model.JournalStructure structure,
        boolean addCommunityPermissions, boolean addGuestPermissions)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void addStructureResources(long groupId,
        java.lang.String structureId, java.lang.String[] communityPermissions,
        java.lang.String[] guestPermissions)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void addStructureResources(
        com.nss.portlet.journal.model.JournalStructure structure,
        java.lang.String[] communityPermissions,
        java.lang.String[] guestPermissions)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void checkNewLine(long groupId, java.lang.String structureId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalStructure copyStructure(
        long userId, long groupId, java.lang.String oldStructureId,
        java.lang.String newStructureId, boolean autoStructureId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void deleteStructure(long groupId, java.lang.String structureId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void deleteStructure(
        com.nss.portlet.journal.model.JournalStructure structure)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void deleteStructures(long groupId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.journal.model.JournalStructure getStructure(long id)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.journal.model.JournalStructure getStructure(
        long groupId, java.lang.String structureId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.journal.model.JournalStructure> getStructures()
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.journal.model.JournalStructure> getStructures(
        long groupId) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.journal.model.JournalStructure> getStructures(
        long groupId, int start, int end)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getStructuresCount(long groupId)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.journal.model.JournalStructure> search(
        long companyId, long groupId, java.lang.String keywords, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.journal.model.JournalStructure> search(
        long companyId, long groupId, java.lang.String structureId,
        java.lang.String name, java.lang.String description,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int searchCount(long companyId, long groupId,
        java.lang.String keywords) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int searchCount(long companyId, long groupId,
        java.lang.String structureId, java.lang.String name,
        java.lang.String description, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalStructure updateStructure(
        long groupId, java.lang.String structureId,
        java.lang.String parentStructureId, java.lang.String name,
        java.lang.String description, java.lang.String xsd,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;
}
