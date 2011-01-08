package com.ext.portlet.meetingcalendar.service;


/**
 * <a href="MeetingCalendarServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.ext.portlet.meetingcalendar.service.MeetingCalendarService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.ext.portlet.meetingcalendar.service.MeetingCalendarService
 *
 */
public class MeetingCalendarServiceUtil {
    private static MeetingCalendarService _service;

    public static com.liferay.portlet.calendar.model.CalEvent addEvent(
        long plid, java.lang.String title, java.lang.String description,
        int startDateMonth, int startDateDay, int startDateYear,
        int startDateHour, int startDateMinute, int endDateMonth,
        int endDateDay, int endDateYear, int durationHour, int durationMinute,
        boolean allDay, boolean timeZoneSensitive, java.lang.String type,
        boolean repeating,
        com.liferay.portal.kernel.cal.TZSRecurrence recurrence,
        java.lang.String remindBy, int firstReminder, int secondReminder,
        java.lang.String[] communityPermissions,
        java.lang.String[] guestPermissions, boolean morning,
        boolean afternoon, boolean evening, boolean prior)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException, java.rmi.RemoteException {
        return getService()
                   .addEvent(plid, title, description, startDateMonth,
            startDateDay, startDateYear, startDateHour, startDateMinute,
            endDateMonth, endDateDay, endDateYear, durationHour,
            durationMinute, allDay, timeZoneSensitive, type, repeating,
            recurrence, remindBy, firstReminder, secondReminder,
            communityPermissions, guestPermissions, morning, afternoon,
            evening, prior);
    }

    public static com.liferay.portlet.calendar.model.CalEvent addEvent(
        long plid, long userId, java.lang.String title,
        java.lang.String description, int startDateMonth, int startDateDay,
        int startDateYear, int startDateHour, int startDateMinute,
        int endDateMonth, int endDateDay, int endDateYear, int durationHour,
        int durationMinute, boolean allDay, boolean timeZoneSensitive,
        java.lang.String type, boolean repeating,
        com.liferay.portal.kernel.cal.TZSRecurrence recurrence,
        java.lang.String remindBy, int firstReminder, int secondReminder,
        java.lang.String[] communityPermissions,
        java.lang.String[] guestPermissions, boolean morning,
        boolean afternoon, boolean evening, boolean prior)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException, java.rmi.RemoteException {
        return getService()
                   .addEvent(plid, userId, title, description, startDateMonth,
            startDateDay, startDateYear, startDateHour, startDateMinute,
            endDateMonth, endDateDay, endDateYear, durationHour,
            durationMinute, allDay, timeZoneSensitive, type, repeating,
            recurrence, remindBy, firstReminder, secondReminder,
            communityPermissions, guestPermissions, morning, afternoon,
            evening, prior);
    }

    public static void deleteEvent(long plid, long eventId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException, java.rmi.RemoteException {
        getService().deleteEvent(plid, eventId);
    }

    public static com.liferay.portlet.calendar.model.CalEvent getEvent(
        long eventId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException, java.rmi.RemoteException {
        return getService().getEvent(eventId);
    }

    public static com.liferay.portlet.calendar.model.CalEvent updateEvent(
        long eventId, java.lang.String title, java.lang.String description,
        int startDateMonth, int startDateDay, int startDateYear,
        int startDateHour, int startDateMinute, int endDateMonth,
        int endDateDay, int endDateYear, int durationHour, int durationMinute,
        boolean allDay, boolean timeZoneSensitive, java.lang.String type,
        boolean repeating,
        com.liferay.portal.kernel.cal.TZSRecurrence recurrence,
        java.lang.String remindBy, int firstReminder, int secondReminder,
        boolean morning, boolean afternoon, boolean evening, boolean prior)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException, java.rmi.RemoteException {
        return getService()
                   .updateEvent(eventId, title, description, startDateMonth,
            startDateDay, startDateYear, startDateHour, startDateMinute,
            endDateMonth, endDateDay, endDateYear, durationHour,
            durationMinute, allDay, timeZoneSensitive, type, repeating,
            recurrence, remindBy, firstReminder, secondReminder, morning,
            afternoon, evening, prior);
    }

    public static com.liferay.portlet.calendar.model.CalEvent updateEvent(
        long plid, long eventId, java.lang.String title,
        java.lang.String description, int startDateMonth, int startDateDay,
        int startDateYear, int startDateHour, int startDateMinute,
        int endDateMonth, int endDateDay, int endDateYear, int durationHour,
        int durationMinute, boolean allDay, boolean timeZoneSensitive,
        java.lang.String type, boolean repeating,
        com.liferay.portal.kernel.cal.TZSRecurrence recurrence,
        java.lang.String remindBy, int firstReminder, int secondReminder,
        boolean morning, boolean afternoon, boolean evening, boolean prior)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException, java.rmi.RemoteException {
        return getService()
                   .updateEvent(plid, eventId, title, description,
            startDateMonth, startDateDay, startDateYear, startDateHour,
            startDateMinute, endDateMonth, endDateDay, endDateYear,
            durationHour, durationMinute, allDay, timeZoneSensitive, type,
            repeating, recurrence, remindBy, firstReminder, secondReminder,
            morning, afternoon, evening, prior);
    }

    public static MeetingCalendarService getService() {
        if (_service == null) {
            throw new RuntimeException("MeetingCalendarService is not set");
        }

        return _service;
    }

    public void setService(MeetingCalendarService service) {
        _service = service;
    }
}
