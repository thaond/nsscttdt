package com.liferay.portlet.messageboards.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="MBCategoryService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.liferay.portlet.messageboards.service.impl.MBCategoryServiceImpl</code>.
 * Modify methods in that class and rerun ServiceBuilder to populate this class
 * and all other generated classes.
 * </p>
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.liferay.portlet.messageboards.service.MBCategoryServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface MBCategoryService {
    public com.liferay.portlet.messageboards.model.MBCategory addCategory(
        long parentCategoryId, java.lang.String name,
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
        long parentCategoryId, java.lang.String name,
        java.lang.String description, int order, java.lang.String emailAddress,
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

    public void deleteCategory(long categoryId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portlet.messageboards.model.MBCategory getCategory(
        long categoryId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.liferay.portlet.messageboards.model.MBCategory> getCategories(
        long groupId, long parentCategoryId, int start, int end)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getCategoriesCount(long groupId, long parentCategoryId)
        throws com.liferay.portal.SystemException;

    public void subscribeCategory(long categoryId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void unsubscribeCategory(long categoryId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

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
}
