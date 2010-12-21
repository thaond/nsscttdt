package com.liferay.portlet.messageboards.service;


/**
 * <a href="MBCategoryServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.liferay.portlet.messageboards.service.MBCategoryService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.liferay.portlet.messageboards.service.MBCategoryService
 *
 */
public class MBCategoryServiceUtil {
    private static MBCategoryService _service;

    public static com.liferay.portlet.messageboards.model.MBCategory addCategory(
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
            com.liferay.portal.SystemException {
        return getService()
                   .addCategory(parentCategoryId, name, description,
            emailAddress, inProtocol, inServerName, inServerPort, inUseSSL,
            inUserName, inPassword, inReadInterval, outEmailAddress, outCustom,
            outServerName, outServerPort, outUseSSL, outUserName, outPassword,
            mailingListActive, serviceContext);
    }

    public static com.liferay.portlet.messageboards.model.MBCategory addCategory(
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
            com.liferay.portal.SystemException {
        return getService()
                   .addCategory(parentCategoryId, name, description, order,
            emailAddress, inProtocol, inServerName, inServerPort, inUseSSL,
            inUserName, inPassword, inReadInterval, outEmailAddress, outCustom,
            outServerName, outServerPort, outUseSSL, outUserName, outPassword,
            mailingListActive, serviceContext, file);
    }

    public static com.liferay.portlet.messageboards.model.MBCategory updateCategory(
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
            com.liferay.portal.SystemException {
        return getService()
                   .updateCategory(categoryId, parentCategoryId, name,
            description, order, emailAddress, inProtocol, inServerName,
            inServerPort, inUseSSL, inUserName, inPassword, inReadInterval,
            outEmailAddress, outCustom, outServerName, outServerPort,
            outUseSSL, outUserName, outPassword, mailingListActive,
            mergeWithParentCategory);
    }

    public static void deleteCategory(long categoryId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteCategory(categoryId);
    }

    public static com.liferay.portlet.messageboards.model.MBCategory getCategory(
        long categoryId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getCategory(categoryId);
    }

    public static java.util.List<com.liferay.portlet.messageboards.model.MBCategory> getCategories(
        long groupId, long parentCategoryId, int start, int end)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getCategories(groupId, parentCategoryId, start, end);
    }

    public static int getCategoriesCount(long groupId, long parentCategoryId)
        throws com.liferay.portal.SystemException {
        return getService().getCategoriesCount(groupId, parentCategoryId);
    }

    public static void subscribeCategory(long categoryId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().subscribeCategory(categoryId);
    }

    public static void unsubscribeCategory(long categoryId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().unsubscribeCategory(categoryId);
    }

    public static com.liferay.portlet.messageboards.model.MBCategory updateCategory(
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
            com.liferay.portal.SystemException {
        return getService()
                   .updateCategory(categoryId, parentCategoryId, name,
            description, emailAddress, inProtocol, inServerName, inServerPort,
            inUseSSL, inUserName, inPassword, inReadInterval, outEmailAddress,
            outCustom, outServerName, outServerPort, outUseSSL, outUserName,
            outPassword, mailingListActive, mergeWithParentCategory);
    }

    public static MBCategoryService getService() {
        if (_service == null) {
            throw new RuntimeException("MBCategoryService is not set");
        }

        return _service;
    }

    public void setService(MBCategoryService service) {
        _service = service;
    }
}
