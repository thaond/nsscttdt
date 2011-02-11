package com.ext.portlet.meetingcalendar.service;


/**
 * <a href="RoomResourceLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.ext.portlet.meetingcalendar.service.impl.RoomResourceLocalServiceImpl</code>.
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
 * @see com.ext.portlet.meetingcalendar.service.RoomResourceLocalServiceUtil
 *
 */
public interface RoomResourceLocalService {
    public com.ext.portlet.meetingcalendar.model.RoomResource addRoomResource(
        com.ext.portlet.meetingcalendar.model.RoomResource roomResource)
        throws com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.RoomResource createRoomResource(
        long roomId);

    public void deleteRoomResource(long roomId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteRoomResource(
        com.ext.portlet.meetingcalendar.model.RoomResource roomResource)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.RoomResource getRoomResource(
        long roomId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.ext.portlet.meetingcalendar.model.RoomResource> getRoomResources(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getRoomResourcesCount()
        throws com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.RoomResource updateRoomResource(
        com.ext.portlet.meetingcalendar.model.RoomResource roomResource)
        throws com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.RoomResource updateRoomResource(
        int roomId, long companyId, long userId, java.lang.String roomName,
        java.lang.String description)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;
}
