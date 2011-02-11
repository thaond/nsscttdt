package com.ext.portlet.meetingcalendar.service;


/**
 * <a href="RoomResourceServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.ext.portlet.meetingcalendar.service.RoomResourceService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.ext.portlet.meetingcalendar.service.RoomResourceService
 *
 */
public class RoomResourceServiceUtil {
    private static RoomResourceService _service;

    public static com.ext.portlet.meetingcalendar.model.RoomResource updateResource(
        int roomId, java.lang.String roomName, java.lang.String description)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException, java.rmi.RemoteException {
        return getService().updateResource(roomId, roomName, description);
    }

    public static java.util.List<com.ext.portlet.meetingcalendar.model.RoomResource> getRoomResources()
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException, java.rmi.RemoteException {
        return getService().getRoomResources();
    }

    public static void deleteRoomResource(long roomId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException, java.rmi.RemoteException {
        getService().deleteRoomResource(roomId);
    }

    public static RoomResourceService getService() {
        if (_service == null) {
            throw new RuntimeException("RoomResourceService is not set");
        }

        return _service;
    }

    public void setService(RoomResourceService service) {
        _service = service;
    }
}
