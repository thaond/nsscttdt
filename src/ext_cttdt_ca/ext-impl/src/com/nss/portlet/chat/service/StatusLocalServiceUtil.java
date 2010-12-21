package com.nss.portlet.chat.service;


/**
 * <a href="StatusLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.chat.service.StatusLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.chat.service.StatusLocalService
 *
 */
public class StatusLocalServiceUtil {
    private static StatusLocalService _service;

    public static com.nss.portlet.chat.model.Status addStatus(
        com.nss.portlet.chat.model.Status status)
        throws com.liferay.portal.SystemException {
        return getService().addStatus(status);
    }

    public static com.nss.portlet.chat.model.Status createStatus(long statusId) {
        return getService().createStatus(statusId);
    }

    public static void deleteStatus(long statusId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteStatus(statusId);
    }

    public static void deleteStatus(com.nss.portlet.chat.model.Status status)
        throws com.liferay.portal.SystemException {
        getService().deleteStatus(status);
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

    public static com.nss.portlet.chat.model.Status getStatus(long statusId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getStatus(statusId);
    }

    public static java.util.List<com.nss.portlet.chat.model.Status> getStatuses(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getStatuses(start, end);
    }

    public static int getStatusesCount()
        throws com.liferay.portal.SystemException {
        return getService().getStatusesCount();
    }

    public static com.nss.portlet.chat.model.Status updateStatus(
        com.nss.portlet.chat.model.Status status)
        throws com.liferay.portal.SystemException {
        return getService().updateStatus(status);
    }

    public static com.nss.portlet.chat.model.Status updateStatus(
        com.nss.portlet.chat.model.Status status, boolean merge)
        throws com.liferay.portal.SystemException {
        return getService().updateStatus(status, merge);
    }

    public static java.util.List<Object[]> getAllStatuses(long userId,
        long modifiedDate, int start, int end)
        throws com.liferay.portal.SystemException {
        return getService().getAllStatuses(userId, modifiedDate, start, end);
    }

    public static java.util.List<Object[]> getGroupStatuses(long userId,
        long modifiedDate, int start, int end)
        throws com.liferay.portal.SystemException {
        return getService().getGroupStatuses(userId, modifiedDate, start, end);
    }

    public static java.util.List<Object[]> getSocialStatuses(long userId,
        int type, long modifiedDate, int start, int end)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getSocialStatuses(userId, type, modifiedDate, start, end);
    }

    public static com.nss.portlet.chat.model.Status getUserStatus(long userId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getUserStatus(userId);
    }

    public static com.nss.portlet.chat.model.Status updateStatus(long userId,
        long modifiedDate)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().updateStatus(userId, modifiedDate);
    }

    public static com.nss.portlet.chat.model.Status updateStatus(long userId,
        long modifiedDate, int online, int awake,
        java.lang.String activePanelId, java.lang.String message, int playSound)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .updateStatus(userId, modifiedDate, online, awake,
            activePanelId, message, playSound);
    }

    public static StatusLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("StatusLocalService is not set");
        }

        return _service;
    }

    public void setService(StatusLocalService service) {
        _service = service;
    }
}
