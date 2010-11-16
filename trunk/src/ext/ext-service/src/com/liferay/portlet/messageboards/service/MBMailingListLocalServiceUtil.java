package com.liferay.portlet.messageboards.service;


/**
 * <a href="MBMailingListLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.liferay.portlet.messageboards.service.MBMailingListLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.liferay.portlet.messageboards.service.MBMailingListLocalService
 *
 */
public class MBMailingListLocalServiceUtil {
    private static MBMailingListLocalService _service;

    public static com.liferay.portlet.messageboards.model.MBMailingList addMBMailingList(
        com.liferay.portlet.messageboards.model.MBMailingList mbMailingList)
        throws com.liferay.portal.SystemException {
        return getService().addMBMailingList(mbMailingList);
    }

    public static com.liferay.portlet.messageboards.model.MBMailingList createMBMailingList(
        long mailingListId) {
        return getService().createMBMailingList(mailingListId);
    }

    public static void deleteMBMailingList(long mailingListId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteMBMailingList(mailingListId);
    }

    public static void deleteMBMailingList(
        com.liferay.portlet.messageboards.model.MBMailingList mbMailingList)
        throws com.liferay.portal.SystemException {
        getService().deleteMBMailingList(mbMailingList);
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

    public static com.liferay.portlet.messageboards.model.MBMailingList getMBMailingList(
        long mailingListId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getMBMailingList(mailingListId);
    }

    public static java.util.List<com.liferay.portlet.messageboards.model.MBMailingList> getMBMailingLists(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getMBMailingLists(start, end);
    }

    public static int getMBMailingListsCount()
        throws com.liferay.portal.SystemException {
        return getService().getMBMailingListsCount();
    }

    public static com.liferay.portlet.messageboards.model.MBMailingList updateMBMailingList(
        com.liferay.portlet.messageboards.model.MBMailingList mbMailingList)
        throws com.liferay.portal.SystemException {
        return getService().updateMBMailingList(mbMailingList);
    }

    public static com.liferay.portlet.messageboards.model.MBMailingList updateMBMailingList(
        com.liferay.portlet.messageboards.model.MBMailingList mbMailingList,
        boolean merge) throws com.liferay.portal.SystemException {
        return getService().updateMBMailingList(mbMailingList, merge);
    }

    public static com.liferay.portlet.messageboards.model.MBMailingList addMailingList(
        java.lang.String uuid, long userId, long categoryId,
        java.lang.String emailAddress, java.lang.String inProtocol,
        java.lang.String inServerName, int inServerPort, boolean inUseSSL,
        java.lang.String inUserName, java.lang.String inPassword,
        int inReadInterval, java.lang.String outEmailAddress,
        boolean outCustom, java.lang.String outServerName, int outServerPort,
        boolean outUseSSL, java.lang.String outUserName,
        java.lang.String outPassword, boolean active)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .addMailingList(uuid, userId, categoryId, emailAddress,
            inProtocol, inServerName, inServerPort, inUseSSL, inUserName,
            inPassword, inReadInterval, outEmailAddress, outCustom,
            outServerName, outServerPort, outUseSSL, outUserName, outPassword,
            active);
    }

    public static void deleteCategoryMailingList(long categoryId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteCategoryMailingList(categoryId);
    }

    public static void deleteMailingList(long mailingListId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteMailingList(mailingListId);
    }

    public static void deleteMailingList(
        com.liferay.portlet.messageboards.model.MBMailingList mailingList)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteMailingList(mailingList);
    }

    public static com.liferay.portlet.messageboards.model.MBMailingList getCategoryMailingList(
        long categoryId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getCategoryMailingList(categoryId);
    }

    public static com.liferay.portlet.messageboards.model.MBMailingList updateMailingList(
        long mailingListId, java.lang.String emailAddress,
        java.lang.String inProtocol, java.lang.String inServerName,
        int inServerPort, boolean inUseSSL, java.lang.String inUserName,
        java.lang.String inPassword, int inReadInterval,
        java.lang.String outEmailAddress, boolean outCustom,
        java.lang.String outServerName, int outServerPort, boolean outUseSSL,
        java.lang.String outUserName, java.lang.String outPassword,
        boolean active)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .updateMailingList(mailingListId, emailAddress, inProtocol,
            inServerName, inServerPort, inUseSSL, inUserName, inPassword,
            inReadInterval, outEmailAddress, outCustom, outServerName,
            outServerPort, outUseSSL, outUserName, outPassword, active);
    }

    public static MBMailingListLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("MBMailingListLocalService is not set");
        }

        return _service;
    }

    public void setService(MBMailingListLocalService service) {
        _service = service;
    }
}
