package com.liferay.portlet.messageboards.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="MBCategoryLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.liferay.portlet.messageboards.service.impl.MBCategoryLocalServiceImpl</code>.
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
 * @see com.liferay.portlet.messageboards.service.MBCategoryLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface MBCategoryLocalService {
    public com.liferay.portlet.messageboards.model.MBCategory addMBCategory(
        com.liferay.portlet.messageboards.model.MBCategory mbCategory)
        throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBCategory createMBCategory(
        long categoryId);

    public void deleteMBCategory(long categoryId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteMBCategory(
        com.liferay.portlet.messageboards.model.MBCategory mbCategory)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portlet.messageboards.model.MBCategory getMBCategory(
        long categoryId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.liferay.portlet.messageboards.model.MBCategory> getMBCategories(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getMBCategoriesCount() throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBCategory updateMBCategory(
        com.liferay.portlet.messageboards.model.MBCategory mbCategory)
        throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBCategory updateMBCategory(
        com.liferay.portlet.messageboards.model.MBCategory mbCategory,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBCategory addCategory(
        long userId, long parentCategoryId, java.lang.String name,
        java.lang.String description, java.lang.String emailAddress,
        java.lang.String inProtocol, java.lang.String inServerName,
        int inServerPort, boolean inUseSSL, java.lang.String inUserName,
        java.lang.String inPassword, int inReadInterval,
        java.lang.String outEmailAddress, boolean outCustom,
        java.lang.String outServerName, int outServerPort, boolean outUseSSL,
        java.lang.String outUserName, java.lang.String outPassword,
        boolean mailingListActive,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBCategory addCategory(
        long userId, long parentCategoryId, java.lang.String name,
        java.lang.String description, int thuTu, java.lang.String emailAddress,
        java.lang.String inProtocol, java.lang.String inServerName,
        int inServerPort, boolean inUseSSL, java.lang.String inUserName,
        java.lang.String inPassword, int inReadInterval,
        java.lang.String outEmailAddress, boolean outCustom,
        java.lang.String outServerName, int outServerPort, boolean outUseSSL,
        java.lang.String outUserName, java.lang.String outPassword,
        boolean mailingListActive,
        com.liferay.portal.service.ServiceContext serviceContext,
        java.io.File file)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBCategory addCategory(
        java.lang.String uuid, long userId, long parentCategoryId,
        java.lang.String name, java.lang.String description, int order,
        java.lang.String emailAddress, java.lang.String inProtocol,
        java.lang.String inServerName, int inServerPort, boolean inUseSSL,
        java.lang.String inUserName, java.lang.String inPassword,
        int inReadInterval, java.lang.String outEmailAddress,
        boolean outCustom, java.lang.String outServerName, int outServerPort,
        boolean outUseSSL, java.lang.String outUserName,
        java.lang.String outPassword, boolean mailingListActive,
        com.liferay.portal.service.ServiceContext serviceContext,
        java.io.File file)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBCategory updateCategory(
        long categoryId, long parentCategoryId, java.lang.String name,
        java.lang.String description, int order, java.lang.String emailAddress,
        java.lang.String inProtocol, java.lang.String inServerName,
        int inServerPort, boolean inUseSSL, java.lang.String inUserName,
        java.lang.String inPassword, int inReadInterval,
        java.lang.String outEmailAddress, boolean outCustom,
        java.lang.String outServerName, int outServerPort, boolean outUseSSL,
        java.lang.String outUserName, java.lang.String outPassword,
        boolean mailingListActive, boolean mergeWithParentCategory)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBCategory addCategory(
        java.lang.String uuid, long userId, long parentCategoryId,
        java.lang.String name, java.lang.String description,
        java.lang.String emailAddress, java.lang.String inProtocol,
        java.lang.String inServerName, int inServerPort, boolean inUseSSL,
        java.lang.String inUserName, java.lang.String inPassword,
        int inReadInterval, java.lang.String outEmailAddress,
        boolean outCustom, java.lang.String outServerName, int outServerPort,
        boolean outUseSSL, java.lang.String outUserName,
        java.lang.String outPassword, boolean mailingListActive,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void addCategoryResources(long categoryId,
        boolean addCommunityPermissions, boolean addGuestPermissions)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void addCategoryResources(
        com.liferay.portlet.messageboards.model.MBCategory category,
        boolean addCommunityPermissions, boolean addGuestPermissions)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void addCategoryResources(long categoryId,
        java.lang.String[] communityPermissions,
        java.lang.String[] guestPermissions)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void addCategoryResources(
        com.liferay.portlet.messageboards.model.MBCategory category,
        java.lang.String[] communityPermissions,
        java.lang.String[] guestPermissions)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void deleteCategories(long groupId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void deleteCategory(long categoryId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void deleteCategory(
        com.liferay.portlet.messageboards.model.MBCategory category)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.liferay.portlet.messageboards.model.MBCategory> getCategories(
        long groupId) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.liferay.portlet.messageboards.model.MBCategory> getCategories(
        long groupId, long parentCategoryId)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.liferay.portlet.messageboards.model.MBCategory> getCategories(
        long groupId, long parentCategoryId, int start, int end)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getCategoriesCount(long groupId)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getCategoriesCount(long groupId, long parentCategoryId)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portlet.messageboards.model.MBCategory getCategory(
        long categoryId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public void getSubcategoryIds(java.util.List<Long> categoryIds,
        long groupId, long categoryId)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.liferay.portlet.messageboards.model.MBCategory> getSubscribedCategories(
        long groupId, long userId, int start, int end)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getSubscribedCategoriesCount(long groupId, long userId)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portlet.messageboards.model.MBCategory getSystemCategory()
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public void reIndex(java.lang.String[] ids)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portal.kernel.search.Hits search(long companyId,
        long groupId, long[] categoryIds, long threadId,
        java.lang.String keywords, int start, int end)
        throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBCategory updateCategory(
        long categoryId, long parentCategoryId, java.lang.String name,
        java.lang.String description, java.lang.String emailAddress,
        java.lang.String inProtocol, java.lang.String inServerName,
        int inServerPort, boolean inUseSSL, java.lang.String inUserName,
        java.lang.String inPassword, int inReadInterval,
        java.lang.String outEmailAddress, boolean outCustom,
        java.lang.String outServerName, int outServerPort, boolean outUseSSL,
        java.lang.String outUserName, java.lang.String outPassword,
        boolean mailingListActive, boolean mergeWithParentCategory)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void subscribeCategory(long userId, long categoryId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void unsubscribeCategory(long userId, long categoryId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;
}
