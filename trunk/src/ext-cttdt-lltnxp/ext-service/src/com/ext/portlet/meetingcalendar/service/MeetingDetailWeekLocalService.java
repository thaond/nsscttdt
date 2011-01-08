package com.ext.portlet.meetingcalendar.service;


/**
 * <a href="MeetingDetailWeekLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.ext.portlet.meetingcalendar.service.impl.MeetingDetailWeekLocalServiceImpl</code>.
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
 * @see com.ext.portlet.meetingcalendar.service.MeetingDetailWeekLocalServiceUtil
 *
 */
public interface MeetingDetailWeekLocalService {
    public com.ext.portlet.meetingcalendar.model.MeetingDetailWeek addMeetingDetailWeek(
        com.ext.portlet.meetingcalendar.model.MeetingDetailWeek meetingDetailWeek)
        throws com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.MeetingDetailWeek createMeetingDetailWeek(
        long mdweekId);

    public void deleteMeetingDetailWeek(long mdweekId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteMeetingDetailWeek(
        com.ext.portlet.meetingcalendar.model.MeetingDetailWeek meetingDetailWeek)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.MeetingDetailWeek getMeetingDetailWeek(
        long mdweekId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.ext.portlet.meetingcalendar.model.MeetingDetailWeek> getMeetingDetailWeeks(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getMeetingDetailWeeksCount()
        throws com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.MeetingDetailWeek updateMeetingDetailWeek(
        com.ext.portlet.meetingcalendar.model.MeetingDetailWeek meetingDetailWeek)
        throws com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.MeetingDetailWeek addMeetingDetailWeek(
        long userId, java.lang.String focus, java.lang.String note,
        java.lang.String receive, int weekOfYear, int year)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.MeetingDetailWeek updateMeetingDetailWeek(
        long mdweekId, long userId, java.lang.String focus,
        java.lang.String note, java.lang.String receive, int weekOfYear,
        int year)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.MeetingDetailWeek FindPrimaryKey(
        long mdweekId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.MeetingDetailWeek getWeekYear(
        int week, int year)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;
}
