package com.ext.portlet.meetingcalendar.service;


/**
 * <a href="MeetingCalendarService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.ext.portlet.meetingcalendar.service.impl.MeetingCalendarServiceImpl</code>.
 * Modify methods in that class and rerun ServiceBuilder to populate this class
 * and all other generated classes.
 * </p>
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.ext.portlet.meetingcalendar.service.MeetingCalendarServiceUtil
 *
 */
public interface MeetingCalendarService {
    public com.liferay.portlet.calendar.model.CalEvent addEvent(long plid,
        java.lang.String title, java.lang.String description,
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
            com.liferay.portal.SystemException;

    public com.liferay.portlet.calendar.model.CalEvent addEvent(long plid,
        long userId, java.lang.String title, java.lang.String description,
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
            com.liferay.portal.SystemException;

    public void deleteEvent(long plid, long eventId)
        throws java.rmi.RemoteException, com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.liferay.portlet.calendar.model.CalEvent getEvent(long eventId)
        throws java.rmi.RemoteException, com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.liferay.portlet.calendar.model.CalEvent updateEvent(
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
            com.liferay.portal.SystemException;

    public com.liferay.portlet.calendar.model.CalEvent updateEvent(long plid,
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
            com.liferay.portal.SystemException;
}
