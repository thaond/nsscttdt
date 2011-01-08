package com.ext.portlet.meetingcalendar.service.http;

import com.ext.portlet.meetingcalendar.service.MeetingCalendarServiceUtil;


/**
 * <a href="MeetingCalendarServiceJSON.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides a JSON utility for the
 * <code>com.ext.portlet.meetingcalendar.service.MeetingCalendarServiceUtil</code>
 * service utility. The static methods of this class calls the same methods of
 * the service utility. However, the signatures are different because it is
 * difficult for JSON to support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to a
 * <code>com.liferay.portal.kernel.json.JSONArray</code>. If the method in the
 * service utility returns a <code>com.ext.portlet.meetingcalendar.model.MeetingCalendar</code>,
 * that is translated to a
 * <code>com.liferay.portal.kernel.json.JSONObject</code>. Methods that JSON
 * cannot safely use are skipped. The logic for the translation is encapsulated
 * in <code>com.ext.portlet.meetingcalendar.service.http.MeetingCalendarJSONSerializer</code>.
 * </p>
 *
 * <p>
 * This allows you to call the the backend services directly from JavaScript.
 * See <code>portal-web/docroot/html/portlet/tags_admin/unpacked.js</code> for a
 * reference of how that portlet uses the generated JavaScript in
 * <code>portal-web/docroot/html/js/service.js</code> to call the backend
 * services directly from JavaScript.
 * </p>
 *
 * <p>
 * The JSON utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.ext.portlet.meetingcalendar.service.MeetingCalendarServiceUtil
 * @see com.ext.portlet.meetingcalendar.service.http.MeetingCalendarJSONSerializer
 *
 */
public class MeetingCalendarServiceJSON {
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
        throws java.rmi.RemoteException, com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        com.liferay.portlet.calendar.model.CalEvent returnValue = MeetingCalendarServiceUtil.addEvent(plid,
                title, description, startDateMonth, startDateDay,
                startDateYear, startDateHour, startDateMinute, endDateMonth,
                endDateDay, endDateYear, durationHour, durationMinute, allDay,
                timeZoneSensitive, type, repeating, recurrence, remindBy,
                firstReminder, secondReminder, communityPermissions,
                guestPermissions, morning, afternoon, evening, prior);

        return returnValue;
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
        throws java.rmi.RemoteException, com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        com.liferay.portlet.calendar.model.CalEvent returnValue = MeetingCalendarServiceUtil.addEvent(plid,
                userId, title, description, startDateMonth, startDateDay,
                startDateYear, startDateHour, startDateMinute, endDateMonth,
                endDateDay, endDateYear, durationHour, durationMinute, allDay,
                timeZoneSensitive, type, repeating, recurrence, remindBy,
                firstReminder, secondReminder, communityPermissions,
                guestPermissions, morning, afternoon, evening, prior);

        return returnValue;
    }

    public static void deleteEvent(long plid, long eventId)
        throws java.rmi.RemoteException, com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        MeetingCalendarServiceUtil.deleteEvent(plid, eventId);
    }

    public static com.liferay.portlet.calendar.model.CalEvent getEvent(
        long eventId)
        throws java.rmi.RemoteException, com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        com.liferay.portlet.calendar.model.CalEvent returnValue = MeetingCalendarServiceUtil.getEvent(eventId);

        return returnValue;
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
        throws java.rmi.RemoteException, com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        com.liferay.portlet.calendar.model.CalEvent returnValue = MeetingCalendarServiceUtil.updateEvent(eventId,
                title, description, startDateMonth, startDateDay,
                startDateYear, startDateHour, startDateMinute, endDateMonth,
                endDateDay, endDateYear, durationHour, durationMinute, allDay,
                timeZoneSensitive, type, repeating, recurrence, remindBy,
                firstReminder, secondReminder, morning, afternoon, evening,
                prior);

        return returnValue;
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
        throws java.rmi.RemoteException, com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        com.liferay.portlet.calendar.model.CalEvent returnValue = MeetingCalendarServiceUtil.updateEvent(plid,
                eventId, title, description, startDateMonth, startDateDay,
                startDateYear, startDateHour, startDateMinute, endDateMonth,
                endDateDay, endDateYear, durationHour, durationMinute, allDay,
                timeZoneSensitive, type, repeating, recurrence, remindBy,
                firstReminder, secondReminder, morning, afternoon, evening,
                prior);

        return returnValue;
    }
}
