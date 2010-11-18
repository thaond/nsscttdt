package com.ext.portlet.meetingcalendar.service.http;

import com.ext.portlet.meetingcalendar.service.MeetingCalendarServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;


/**
 * <a href="MeetingCalendarServiceSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides a SOAP utility for the
 * <code>com.ext.portlet.meetingcalendar.service.MeetingCalendarServiceUtil</code> service
 * utility. The static methods of this class calls the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.ext.portlet.meetingcalendar.model.MeetingCalendarSoap</code>. If the method in the
 * service utility returns a <code>com.ext.portlet.meetingcalendar.model.MeetingCalendar</code>,
 * that is translated to a <code>com.ext.portlet.meetingcalendar.model.MeetingCalendarSoap</code>.
 * Methods that SOAP cannot safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at
 * http://localhost:8080/tunnel-web/secure/axis. Set the property
 * <code>tunnel.servlet.hosts.allowed</code> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.ext.portlet.meetingcalendar.model.MeetingCalendarSoap
 * @see com.ext.portlet.meetingcalendar.service.MeetingCalendarServiceUtil
 * @see com.ext.portlet.meetingcalendar.service.http.MeetingCalendarServiceHttp
 *
 */
public class MeetingCalendarServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(MeetingCalendarServiceSoap.class);

    public static com.liferay.portlet.calendar.model.CalEvent addEvent(
        long plid, java.lang.String title, java.lang.String description,
        int startDateMonth, int startDateDay, int startDateYear,
        int startDateHour, int startDateMinute, int endDateMonth,
        int endDateDay, int endDateYear, int durationHour, int durationMinute,
        boolean allDay, boolean timeZoneSensitive, java.lang.String type,
        boolean repeating,
        com.liferay.portal.kernel.cal.TZSRecurrence recurrence, int remindBy,
        int firstReminder, int secondReminder,
        java.lang.String[] communityPermissions,
        java.lang.String[] guestPermissions, boolean morning,
        boolean afternoon, boolean evening, boolean prior,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.liferay.portlet.calendar.model.CalEvent returnValue = MeetingCalendarServiceUtil.addEvent(plid,
                    title, description, startDateMonth, startDateDay,
                    startDateYear, startDateHour, startDateMinute,
                    endDateMonth, endDateDay, endDateYear, durationHour,
                    durationMinute, allDay, timeZoneSensitive, type, repeating,
                    recurrence, remindBy, firstReminder, secondReminder,
                    communityPermissions, guestPermissions, morning, afternoon,
                    evening, prior, serviceContext);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.liferay.portlet.calendar.model.CalEvent addEvent(
        long plid, long userId, java.lang.String title,
        java.lang.String description, int startDateMonth, int startDateDay,
        int startDateYear, int startDateHour, int startDateMinute,
        int endDateMonth, int endDateDay, int endDateYear, int durationHour,
        int durationMinute, boolean allDay, boolean timeZoneSensitive,
        java.lang.String type, boolean repeating,
        com.liferay.portal.kernel.cal.TZSRecurrence recurrence, int remindBy,
        int firstReminder, int secondReminder,
        java.lang.String[] communityPermissions,
        java.lang.String[] guestPermissions, boolean morning,
        boolean afternoon, boolean evening, boolean prior,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.liferay.portlet.calendar.model.CalEvent returnValue = MeetingCalendarServiceUtil.addEvent(plid,
                    userId, title, description, startDateMonth, startDateDay,
                    startDateYear, startDateHour, startDateMinute,
                    endDateMonth, endDateDay, endDateYear, durationHour,
                    durationMinute, allDay, timeZoneSensitive, type, repeating,
                    recurrence, remindBy, firstReminder, secondReminder,
                    communityPermissions, guestPermissions, morning, afternoon,
                    evening, prior, serviceContext);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static void deleteEvent(long plid, long eventId)
        throws RemoteException {
        try {
            MeetingCalendarServiceUtil.deleteEvent(plid, eventId);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.liferay.portlet.calendar.model.CalEvent getEvent(
        long eventId) throws RemoteException {
        try {
            com.liferay.portlet.calendar.model.CalEvent returnValue = MeetingCalendarServiceUtil.getEvent(eventId);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.liferay.portlet.calendar.model.CalEvent updateEvent(
        long eventId, java.lang.String title, java.lang.String description,
        int startDateMonth, int startDateDay, int startDateYear,
        int startDateHour, int startDateMinute, int endDateMonth,
        int endDateDay, int endDateYear, int durationHour, int durationMinute,
        boolean allDay, boolean timeZoneSensitive, java.lang.String type,
        boolean repeating,
        com.liferay.portal.kernel.cal.TZSRecurrence recurrence, int remindBy,
        int firstReminder, int secondReminder, boolean morning,
        boolean afternoon, boolean evening, boolean prior,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.liferay.portlet.calendar.model.CalEvent returnValue = MeetingCalendarServiceUtil.updateEvent(eventId,
                    title, description, startDateMonth, startDateDay,
                    startDateYear, startDateHour, startDateMinute,
                    endDateMonth, endDateDay, endDateYear, durationHour,
                    durationMinute, allDay, timeZoneSensitive, type, repeating,
                    recurrence, remindBy, firstReminder, secondReminder,
                    morning, afternoon, evening, prior, serviceContext);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.liferay.portlet.calendar.model.CalEvent updateEvent(
        long plid, long eventId, java.lang.String title,
        java.lang.String description, int startDateMonth, int startDateDay,
        int startDateYear, int startDateHour, int startDateMinute,
        int endDateMonth, int endDateDay, int endDateYear, int durationHour,
        int durationMinute, boolean allDay, boolean timeZoneSensitive,
        java.lang.String type, boolean repeating,
        com.liferay.portal.kernel.cal.TZSRecurrence recurrence, int remindBy,
        int firstReminder, int secondReminder, boolean morning,
        boolean afternoon, boolean evening, boolean prior,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.liferay.portlet.calendar.model.CalEvent returnValue = MeetingCalendarServiceUtil.updateEvent(plid,
                    eventId, title, description, startDateMonth, startDateDay,
                    startDateYear, startDateHour, startDateMinute,
                    endDateMonth, endDateDay, endDateYear, durationHour,
                    durationMinute, allDay, timeZoneSensitive, type, repeating,
                    recurrence, remindBy, firstReminder, secondReminder,
                    morning, afternoon, evening, prior, serviceContext);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
