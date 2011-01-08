package com.ext.portlet.meetingcalendar.service;


/**
 * <a href="MeetingCalendarLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.ext.portlet.meetingcalendar.service.MeetingCalendarLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.ext.portlet.meetingcalendar.service.MeetingCalendarLocalService
 *
 */
public class MeetingCalendarLocalServiceUtil {
    private static MeetingCalendarLocalService _service;

    public static com.ext.portlet.meetingcalendar.model.MeetingCalendar addMeetingCalendar(
        com.ext.portlet.meetingcalendar.model.MeetingCalendar meetingCalendar)
        throws com.liferay.portal.SystemException {
        return getService().addMeetingCalendar(meetingCalendar);
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingCalendar createMeetingCalendar(
        long mcalId) {
        return getService().createMeetingCalendar(mcalId);
    }

    public static void deleteMeetingCalendar(long mcalId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteMeetingCalendar(mcalId);
    }

    public static void deleteMeetingCalendar(
        com.ext.portlet.meetingcalendar.model.MeetingCalendar meetingCalendar)
        throws com.liferay.portal.SystemException {
        getService().deleteMeetingCalendar(meetingCalendar);
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

    public static com.ext.portlet.meetingcalendar.model.MeetingCalendar getMeetingCalendar(
        long mcalId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getMeetingCalendar(mcalId);
    }

    public static java.util.List<com.ext.portlet.meetingcalendar.model.MeetingCalendar> getMeetingCalendars(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getMeetingCalendars(start, end);
    }

    public static int getMeetingCalendarsCount()
        throws com.liferay.portal.SystemException {
        return getService().getMeetingCalendarsCount();
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingCalendar updateMeetingCalendar(
        com.ext.portlet.meetingcalendar.model.MeetingCalendar meetingCalendar)
        throws com.liferay.portal.SystemException {
        return getService().updateMeetingCalendar(meetingCalendar);
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingCalendar getMCalById(
        long Id)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getMCalById(Id);
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingCalendar addMCal(
        java.lang.String place, java.lang.String place_diff,
        java.lang.String component, java.lang.String note,
        com.liferay.portlet.calendar.model.CalEvent calevent,
        boolean repeatWeek,
        com.liferay.portal.kernel.util.ObjectValuePair<String, byte[]> file,
        java.lang.String fileName, boolean morning, boolean afternoon,
        boolean evening, boolean prior)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .addMCal(place, place_diff, component, note, calevent,
            repeatWeek, file, fileName, morning, afternoon, evening, prior);
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingCalendar addMCal(
        java.lang.String place, java.lang.String place_diff,
        java.lang.String component, java.lang.String note,
        com.liferay.portlet.calendar.model.CalEvent calevent, int state,
        boolean repeatWeek,
        com.liferay.portal.kernel.util.ObjectValuePair<String, byte[]> file,
        java.lang.String fileName, boolean morning, boolean afternoon,
        boolean evening, boolean prior)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .addMCal(place, place_diff, component, note, calevent,
            state, repeatWeek, file, fileName, morning, afternoon, evening,
            prior);
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingCalendar approveMCal(
        long userApproved, long mcalId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().approveMCal(userApproved, mcalId);
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingCalendar deleteMCal(
        long mcalId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().deleteMCal(mcalId);
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingCalendar updateMCal(
        long mcalId, java.lang.String place, java.lang.String place_diff,
        java.lang.String component, java.lang.String note, boolean repeatWeek,
        com.liferay.portal.kernel.util.ObjectValuePair<String, byte[]> file,
        boolean morning, boolean afternoon, boolean evening, boolean prior)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .updateMCal(mcalId, place, place_diff, component, note,
            repeatWeek, file, morning, afternoon, evening, prior);
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingCalendar updateMCal(
        long mcalId, java.lang.String place, java.lang.String place_diff,
        java.lang.String component, java.lang.String note, int state,
        boolean repeatWeek,
        com.liferay.portal.kernel.util.ObjectValuePair<String, byte[]> file,
        boolean morning, boolean afternoon, boolean evening, boolean prior)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .updateMCal(mcalId, place, place_diff, component, note,
            state, repeatWeek, file, morning, afternoon, evening, prior);
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingCalendar cancelMCal(
        long mcalId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().cancelMCal(mcalId);
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingCalendar moveMCal(
        long oldMcalId, long newMcalId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().moveMCal(oldMcalId, newMcalId);
    }

    public static int countBySD_D_S_C(java.util.Date startDateGT,
        java.util.Date startDateLT, java.lang.String description,
        java.lang.String sponsor, java.lang.String component,
        boolean andOperator) throws com.liferay.portal.SystemException {
        return getService()
                   .countBySD_D_S_C(startDateGT, startDateLT, description,
            sponsor, component, andOperator);
    }

    public static int countBySD_D_S_C_S(java.util.Date startDateGT,
        java.util.Date startDateLT, java.lang.String description,
        java.lang.String sponsor, java.lang.String component, int state,
        boolean andOperator) throws com.liferay.portal.SystemException {
        return getService()
                   .countBySD_D_S_C_S(startDateGT, startDateLT, description,
            sponsor, component, state, andOperator);
    }

    public static java.util.List<com.liferay.portlet.calendar.model.CalEvent> searchBySD_D_S_C(
        java.util.Date startDateGT, java.util.Date startDateLT,
        java.lang.String description, java.lang.String sponsor,
        java.lang.String component, boolean andOperator, int begin, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .searchBySD_D_S_C(startDateGT, startDateLT, description,
            sponsor, component, andOperator, begin, end, obc);
    }

    public static java.util.List<com.liferay.portlet.calendar.model.CalEvent> searchBySD_D_S_C_S(
        java.util.Date startDateGT, java.util.Date startDateLT,
        java.lang.String description, java.lang.String sponsor,
        java.lang.String component, int state, boolean andOperator, int begin,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .searchBySD_D_S_C_S(startDateGT, startDateLT, description,
            sponsor, component, state, andOperator, begin, end, obc);
    }

    public static java.lang.String getDirName() {
        return getService().getDirName();
    }

    public static void updateOrder(long mcalId, int stt)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().updateOrder(mcalId, stt);
    }

    public static java.util.List<com.ext.portlet.meetingcalendar.model.MeetingCalendar> getByG_SD(
        long groupId, java.util.Calendar cal, java.lang.String eventType)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getByG_SD(groupId, cal, eventType);
    }

    public static com.ext.portlet.meetingcalendar.model.MeetingCalendar FindPrimaryKey(
        long mdweekId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().FindPrimaryKey(mdweekId);
    }

    public static MeetingCalendarLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("MeetingCalendarLocalService is not set");
        }

        return _service;
    }

    public void setService(MeetingCalendarLocalService service) {
        _service = service;
    }
}
