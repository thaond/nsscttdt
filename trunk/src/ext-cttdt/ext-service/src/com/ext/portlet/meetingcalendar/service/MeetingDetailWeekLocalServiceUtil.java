package com.ext.portlet.meetingcalendar.service;


/**
 * <a href="MeetingDetailWeekLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.ext.portlet.meetingcalendar.service.MeetingDetailWeekLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.ext.portlet.meetingcalendar.service.MeetingDetailWeekLocalService
 *
 */
public class MeetingDetailWeekLocalServiceUtil {
    private static MeetingDetailWeekLocalService _service;

    public static com.ext.portlet.meetingcalendar.model.MeetingDetailWeek addMeetingDetailWeek(
        com.ext.portlet.meetingcalendar.model.MeetingDetailWeek meetingDetailWeek)
        throws com.liferay.portal.SystemException {
        return getService().addMeetingDetailWeek(meetingDetailWeek);
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingDetailWeek createMeetingDetailWeek(
        long mdweekId) {
        return getService().createMeetingDetailWeek(mdweekId);
    }

    public static void deleteMeetingDetailWeek(long mdweekId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteMeetingDetailWeek(mdweekId);
    }

    public static void deleteMeetingDetailWeek(
        com.ext.portlet.meetingcalendar.model.MeetingDetailWeek meetingDetailWeek)
        throws com.liferay.portal.SystemException {
        getService().deleteMeetingDetailWeek(meetingDetailWeek);
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

    public static com.ext.portlet.meetingcalendar.model.MeetingDetailWeek getMeetingDetailWeek(
        long mdweekId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getMeetingDetailWeek(mdweekId);
    }

    public static java.util.List<com.ext.portlet.meetingcalendar.model.MeetingDetailWeek> getMeetingDetailWeeks(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getMeetingDetailWeeks(start, end);
    }

    public static int getMeetingDetailWeeksCount()
        throws com.liferay.portal.SystemException {
        return getService().getMeetingDetailWeeksCount();
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingDetailWeek updateMeetingDetailWeek(
        com.ext.portlet.meetingcalendar.model.MeetingDetailWeek meetingDetailWeek)
        throws com.liferay.portal.SystemException {
        return getService().updateMeetingDetailWeek(meetingDetailWeek);
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingDetailWeek updateMeetingDetailWeek(
        com.ext.portlet.meetingcalendar.model.MeetingDetailWeek meetingDetailWeek,
        boolean merge) throws com.liferay.portal.SystemException {
        return getService().updateMeetingDetailWeek(meetingDetailWeek, merge);
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingDetailWeek addMeetingDetailWeek(
        long userId, java.lang.String focus, java.lang.String note,
        java.lang.String receive, int weekOfYear, int year)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .addMeetingDetailWeek(userId, focus, note, receive,
            weekOfYear, year);
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingDetailWeek updateMeetingDetailWeek(
        long mdweekId, long userId, java.lang.String focus,
        java.lang.String note, java.lang.String receive, int weekOfYear,
        int year)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .updateMeetingDetailWeek(mdweekId, userId, focus, note,
            receive, weekOfYear, year);
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingDetailWeek FindPrimaryKey(
        long mdweekId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().FindPrimaryKey(mdweekId);
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingDetailWeek getWeekYear(
        int week, int year)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getWeekYear(week, year);
    }

    public static MeetingDetailWeekLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "MeetingDetailWeekLocalService is not set");
        }

        return _service;
    }

    public void setService(MeetingDetailWeekLocalService service) {
        _service = service;
    }
}
