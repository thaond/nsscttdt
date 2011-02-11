package com.sgs.portlet.holiday_calendar.service;


/**
 * <a href="HolidayCalendarLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.holiday_calendar.service.impl.HolidayCalendarLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.holiday_calendar.service.HolidayCalendarLocalServiceUtil
 *
 */
public interface HolidayCalendarLocalService {
    public com.sgs.portlet.holiday_calendar.model.HolidayCalendar addHolidayCalendar(
        com.sgs.portlet.holiday_calendar.model.HolidayCalendar holidayCalendar)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.holiday_calendar.model.HolidayCalendar createHolidayCalendar(
        long holidayCalendarId);

    public void deleteHolidayCalendar(long holidayCalendarId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteHolidayCalendar(
        com.sgs.portlet.holiday_calendar.model.HolidayCalendar holidayCalendar)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.holiday_calendar.model.HolidayCalendar getHolidayCalendar(
        long holidayCalendarId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.holiday_calendar.model.HolidayCalendar> getHolidayCalendars(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getHolidayCalendarsCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.holiday_calendar.model.HolidayCalendar updateHolidayCalendar(
        com.sgs.portlet.holiday_calendar.model.HolidayCalendar holidayCalendar)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.holiday_calendar.model.AttactFileHoliday> getAttactFileHolidays(
        long holidayCalendarId) throws com.liferay.portal.SystemException;

    public int countHolidayCalendarTest(java.lang.String holidayCalendarCodes,
        java.lang.String holidayCalendarTitles, java.lang.String dateFrom,
        java.lang.String dateTo, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.holiday_calendar.model.HolidayCalendar> findHolidayCalendarTest(
        java.lang.String holidayCalendarCodes,
        java.lang.String holidayCalendarTitles, java.lang.String dateFrom,
        java.lang.String dateTo, int start, int end, boolean andOperator,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;
}
