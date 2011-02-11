package com.ext.portlet.meetingcalendar.service;


/**
 * <a href="RoomResourceLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.ext.portlet.meetingcalendar.service.RoomResourceLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.ext.portlet.meetingcalendar.service.RoomResourceLocalService
 *
 */
public class RoomResourceLocalServiceUtil {
    private static RoomResourceLocalService _service;

    public static com.ext.portlet.meetingcalendar.model.RoomResource addRoomResource(
        com.ext.portlet.meetingcalendar.model.RoomResource roomResource)
        throws com.liferay.portal.SystemException {
        return getService().addRoomResource(roomResource);
    }

    public static com.ext.portlet.meetingcalendar.model.RoomResource createRoomResource(
        long roomId) {
        return getService().createRoomResource(roomId);
    }

    public static void deleteRoomResource(long roomId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteRoomResource(roomId);
    }

    public static void deleteRoomResource(
        com.ext.portlet.meetingcalendar.model.RoomResource roomResource)
        throws com.liferay.portal.SystemException {
        getService().deleteRoomResource(roomResource);
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

    public static com.ext.portlet.meetingcalendar.model.RoomResource getRoomResource(
        long roomId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getRoomResource(roomId);
    }

    public static java.util.List<com.ext.portlet.meetingcalendar.model.RoomResource> getRoomResources(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getRoomResources(start, end);
    }

    public static int getRoomResourcesCount()
        throws com.liferay.portal.SystemException {
        return getService().getRoomResourcesCount();
    }

    public static com.ext.portlet.meetingcalendar.model.RoomResource updateRoomResource(
        com.ext.portlet.meetingcalendar.model.RoomResource roomResource)
        throws com.liferay.portal.SystemException {
        return getService().updateRoomResource(roomResource);
    }

    public static com.ext.portlet.meetingcalendar.model.RoomResource updateRoomResource(
        int roomId, long companyId, long userId, java.lang.String roomName,
        java.lang.String description)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .updateRoomResource(roomId, companyId, userId, roomName,
            description);
    }

    public static RoomResourceLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("RoomResourceLocalService is not set");
        }

        return _service;
    }

    public void setService(RoomResourceLocalService service) {
        _service = service;
    }
}
