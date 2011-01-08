package com.ext.portlet.meetingcalendar.service;


/**
 * <a href="MeetingCalComponentLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.ext.portlet.meetingcalendar.service.MeetingCalComponentLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.ext.portlet.meetingcalendar.service.MeetingCalComponentLocalService
 *
 */
public class MeetingCalComponentLocalServiceUtil {
    private static MeetingCalComponentLocalService _service;

    public static com.ext.portlet.meetingcalendar.model.MeetingCalComponent addMeetingCalComponent(
        com.ext.portlet.meetingcalendar.model.MeetingCalComponent meetingCalComponent)
        throws com.liferay.portal.SystemException {
        return getService().addMeetingCalComponent(meetingCalComponent);
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingCalComponent createMeetingCalComponent(
        long mcalId) {
        return getService().createMeetingCalComponent(mcalId);
    }

    public static void deleteMeetingCalComponent(long mcalId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteMeetingCalComponent(mcalId);
    }

    public static void deleteMeetingCalComponent(
        com.ext.portlet.meetingcalendar.model.MeetingCalComponent meetingCalComponent)
        throws com.liferay.portal.SystemException {
        getService().deleteMeetingCalComponent(meetingCalComponent);
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

    public static com.ext.portlet.meetingcalendar.model.MeetingCalComponent getMeetingCalComponent(
        long mcalId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getMeetingCalComponent(mcalId);
    }

    public static java.util.List<com.ext.portlet.meetingcalendar.model.MeetingCalComponent> getMeetingCalComponents(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getMeetingCalComponents(start, end);
    }

    public static int getMeetingCalComponentsCount()
        throws com.liferay.portal.SystemException {
        return getService().getMeetingCalComponentsCount();
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingCalComponent updateMeetingCalComponent(
        com.ext.portlet.meetingcalendar.model.MeetingCalComponent meetingCalComponent)
        throws com.liferay.portal.SystemException {
        return getService().updateMeetingCalComponent(meetingCalComponent);
    }

    public static void addMCalComponent(long mcalId, java.lang.String[] orgIds,
        java.util.Date startDate)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().addMCalComponent(mcalId, orgIds, startDate);
    }

    public static void updateMCalComponent(long mcalId,
        java.lang.String[] orgIds, java.util.Date startDate)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().updateMCalComponent(mcalId, orgIds, startDate);
    }

    public static void deleteMCalComponent(long mcalId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteMCalComponent(mcalId);
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingCalComponent getBymcalId(
        long mcalId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getBymcalId(mcalId);
    }

    public static java.util.List<com.ext.portlet.meetingcalendar.model.MeetingCalComponent> getByG_SD(
        long groupId, java.util.Calendar cal)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getByG_SD(groupId, cal);
    }

    public static MeetingCalComponentLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "MeetingCalComponentLocalService is not set");
        }

        return _service;
    }

    public void setService(MeetingCalComponentLocalService service) {
        _service = service;
    }
}
