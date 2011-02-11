package com.ext.portlet.meetingcalendar.service;


/**
 * <a href="MeetingCalendarLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.ext.portlet.meetingcalendar.service.impl.MeetingCalendarLocalServiceImpl</code>.
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
 * @see com.ext.portlet.meetingcalendar.service.MeetingCalendarLocalServiceUtil
 *
 */
public interface MeetingCalendarLocalService {
    public com.ext.portlet.meetingcalendar.model.MeetingCalendar addMeetingCalendar(
        com.ext.portlet.meetingcalendar.model.MeetingCalendar meetingCalendar)
        throws com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.MeetingCalendar createMeetingCalendar(
        long mcalId);

    public void deleteMeetingCalendar(long mcalId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteMeetingCalendar(
        com.ext.portlet.meetingcalendar.model.MeetingCalendar meetingCalendar)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.MeetingCalendar getMeetingCalendar(
        long mcalId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.ext.portlet.meetingcalendar.model.MeetingCalendar> getMeetingCalendars(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getMeetingCalendarsCount()
        throws com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.MeetingCalendar updateMeetingCalendar(
        com.ext.portlet.meetingcalendar.model.MeetingCalendar meetingCalendar)
        throws com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.MeetingCalendar getMCalById(
        long Id)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.MeetingCalendar addMCal(
        java.lang.String place, java.lang.String place_diff,
        java.lang.String component, java.lang.String note,
        com.liferay.portlet.calendar.model.CalEvent calevent,
        boolean repeatWeek,
        com.liferay.portal.kernel.util.ObjectValuePair<String, byte[]> file,
        java.lang.String fileName, boolean morning, boolean afternoon,
        boolean evening, boolean prior)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.MeetingCalendar addMCal(
        java.lang.String place, java.lang.String place_diff,
        java.lang.String component, java.lang.String note,
        com.liferay.portlet.calendar.model.CalEvent calevent, int state,
        boolean repeatWeek,
        com.liferay.portal.kernel.util.ObjectValuePair<String, byte[]> file,
        java.lang.String fileName, boolean morning, boolean afternoon,
        boolean evening, boolean prior)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.MeetingCalendar approveMCal(
        long userApproved, long mcalId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.MeetingCalendar deleteMCal(
        long mcalId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.MeetingCalendar updateMCal(
        long mcalId, java.lang.String place, java.lang.String place_diff,
        java.lang.String component, java.lang.String note, boolean repeatWeek,
        com.liferay.portal.kernel.util.ObjectValuePair<String, byte[]> file,
        boolean morning, boolean afternoon, boolean evening, boolean prior)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.MeetingCalendar updateMCal(
        long mcalId, java.lang.String place, java.lang.String place_diff,
        java.lang.String component, java.lang.String note, int state,
        boolean repeatWeek,
        com.liferay.portal.kernel.util.ObjectValuePair<String, byte[]> file,
        boolean morning, boolean afternoon, boolean evening, boolean prior)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.MeetingCalendar cancelMCal(
        long mcalId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.MeetingCalendar moveMCal(
        long oldMcalId, long newMcalId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public int countBySD_D_S_C(java.util.Date startDateGT,
        java.util.Date startDateLT, java.lang.String description,
        java.lang.String sponsor, java.lang.String component,
        boolean andOperator) throws com.liferay.portal.SystemException;

    public int countBySD_D_S_C_S(java.util.Date startDateGT,
        java.util.Date startDateLT, java.lang.String description,
        java.lang.String sponsor, java.lang.String component, int state,
        boolean andOperator) throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.calendar.model.CalEvent> searchBySD_D_S_C(
        java.util.Date startDateGT, java.util.Date startDateLT,
        java.lang.String description, java.lang.String sponsor,
        java.lang.String component, boolean andOperator, int begin, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.calendar.model.CalEvent> searchBySD_D_S_C_S(
        java.util.Date startDateGT, java.util.Date startDateLT,
        java.lang.String description, java.lang.String sponsor,
        java.lang.String component, int state, boolean andOperator, int begin,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.lang.String getDirName();

    public void updateOrder(long mcalId, int stt)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public java.util.List<com.ext.portlet.meetingcalendar.model.MeetingCalendar> getByG_SD(
        long groupId, java.util.Calendar cal, java.lang.String eventType)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.MeetingCalendar FindPrimaryKey(
        long mdweekId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;
}
