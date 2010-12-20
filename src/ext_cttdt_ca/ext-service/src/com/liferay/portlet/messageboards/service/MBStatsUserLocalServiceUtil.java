package com.liferay.portlet.messageboards.service;


/**
 * <a href="MBStatsUserLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.liferay.portlet.messageboards.service.MBStatsUserLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.liferay.portlet.messageboards.service.MBStatsUserLocalService
 *
 */
public class MBStatsUserLocalServiceUtil {
    private static MBStatsUserLocalService _service;

    public static com.liferay.portlet.messageboards.model.MBStatsUser addMBStatsUser(
        com.liferay.portlet.messageboards.model.MBStatsUser mbStatsUser)
        throws com.liferay.portal.SystemException {
        return getService().addMBStatsUser(mbStatsUser);
    }

    public static com.liferay.portlet.messageboards.model.MBStatsUser createMBStatsUser(
        long statsUserId) {
        return getService().createMBStatsUser(statsUserId);
    }

    public static void deleteMBStatsUser(long statsUserId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteMBStatsUser(statsUserId);
    }

    public static void deleteMBStatsUser(
        com.liferay.portlet.messageboards.model.MBStatsUser mbStatsUser)
        throws com.liferay.portal.SystemException {
        getService().deleteMBStatsUser(mbStatsUser);
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

    public static com.liferay.portlet.messageboards.model.MBStatsUser getMBStatsUser(
        long statsUserId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getMBStatsUser(statsUserId);
    }

    public static java.util.List<com.liferay.portlet.messageboards.model.MBStatsUser> getMBStatsUsers(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getMBStatsUsers(start, end);
    }

    public static int getMBStatsUsersCount()
        throws com.liferay.portal.SystemException {
        return getService().getMBStatsUsersCount();
    }

    public static com.liferay.portlet.messageboards.model.MBStatsUser updateMBStatsUser(
        com.liferay.portlet.messageboards.model.MBStatsUser mbStatsUser)
        throws com.liferay.portal.SystemException {
        return getService().updateMBStatsUser(mbStatsUser);
    }

    public static com.liferay.portlet.messageboards.model.MBStatsUser updateMBStatsUser(
        com.liferay.portlet.messageboards.model.MBStatsUser mbStatsUser,
        boolean merge) throws com.liferay.portal.SystemException {
        return getService().updateMBStatsUser(mbStatsUser, merge);
    }

    public static com.liferay.portlet.messageboards.model.MBStatsUser addStatsUser(
        long groupId, long userId) throws com.liferay.portal.SystemException {
        return getService().addStatsUser(groupId, userId);
    }

    public static void deleteStatsUserByGroupId(long groupId)
        throws com.liferay.portal.SystemException {
        getService().deleteStatsUserByGroupId(groupId);
    }

    public static void deleteStatsUserByUserId(long userId)
        throws com.liferay.portal.SystemException {
        getService().deleteStatsUserByUserId(userId);
    }

    public static com.liferay.portlet.messageboards.model.MBStatsUser getStatsUser(
        long groupId, long userId) throws com.liferay.portal.SystemException {
        return getService().getStatsUser(groupId, userId);
    }

    public static java.util.List<com.liferay.portlet.messageboards.model.MBStatsUser> getStatsUsers(
        long groupId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getService().getStatsUsers(groupId, start, end);
    }

    public static int getStatsUsersCount(long groupId)
        throws com.liferay.portal.SystemException {
        return getService().getStatsUsersCount(groupId);
    }

    public static com.liferay.portlet.messageboards.model.MBStatsUser updateStatsUser(
        long groupId, long userId) throws com.liferay.portal.SystemException {
        return getService().updateStatsUser(groupId, userId);
    }

    public static com.liferay.portlet.messageboards.model.MBStatsUser updateStatsUser(
        long groupId, long userId, java.util.Date lastPostDate)
        throws com.liferay.portal.SystemException {
        return getService().updateStatsUser(groupId, userId, lastPostDate);
    }

    public static MBStatsUserLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("MBStatsUserLocalService is not set");
        }

        return _service;
    }

    public void setService(MBStatsUserLocalService service) {
        _service = service;
    }
}
