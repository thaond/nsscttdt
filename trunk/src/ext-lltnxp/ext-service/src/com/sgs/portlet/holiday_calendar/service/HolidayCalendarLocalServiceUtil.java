package com.sgs.portlet.holiday_calendar.service;


/**
 * <a href="HolidayCalendarLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.holiday_calendar.service.HolidayCalendarLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.holiday_calendar.service.HolidayCalendarLocalService
 *
 */
public class HolidayCalendarLocalServiceUtil {
    private static HolidayCalendarLocalService _service;

    public static com.sgs.portlet.holiday_calendar.model.HolidayCalendar addHolidayCalendar(
        com.sgs.portlet.holiday_calendar.model.HolidayCalendar holidayCalendar)
        throws com.liferay.portal.SystemException {
        return getService().addHolidayCalendar(holidayCalendar);
    }

    public static com.sgs.portlet.holiday_calendar.model.HolidayCalendar createHolidayCalendar(
        long holidayCalendarId) {
        return getService().createHolidayCalendar(holidayCalendarId);
    }

    public static void deleteHolidayCalendar(long holidayCalendarId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteHolidayCalendar(holidayCalendarId);
    }

    public static void deleteHolidayCalendar(
        com.sgs.portlet.holiday_calendar.model.HolidayCalendar holidayCalendar)
        throws com.liferay.portal.SystemException {
        getService().deleteHolidayCalendar(holidayCalendar);
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

    public static com.sgs.portlet.holiday_calendar.model.HolidayCalendar getHolidayCalendar(
        long holidayCalendarId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getHolidayCalendar(holidayCalendarId);
    }

    public static java.util.List<com.sgs.portlet.holiday_calendar.model.HolidayCalendar> getHolidayCalendars(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getHolidayCalendars(start, end);
    }

    public static int getHolidayCalendarsCount()
        throws com.liferay.portal.SystemException {
        return getService().getHolidayCalendarsCount();
    }

    public static com.sgs.portlet.holiday_calendar.model.HolidayCalendar updateHolidayCalendar(
        com.sgs.portlet.holiday_calendar.model.HolidayCalendar holidayCalendar)
        throws com.liferay.portal.SystemException {
        return getService().updateHolidayCalendar(holidayCalendar);
    }

    public static java.util.List<com.sgs.portlet.holiday_calendar.model.AttactFileHoliday> getAttactFileHolidays(
        long holidayCalendarId) throws com.liferay.portal.SystemException {
        return getService().getAttactFileHolidays(holidayCalendarId);
    }

    public static int countHolidayCalendarTest(
        java.lang.String holidayCalendarCodes,
        java.lang.String holidayCalendarTitles, java.lang.String dateFrom,
        java.lang.String dateTo, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getService()
                   .countHolidayCalendarTest(holidayCalendarCodes,
            holidayCalendarTitles, dateFrom, dateTo, andOperator);
    }

    public static java.util.List<com.sgs.portlet.holiday_calendar.model.HolidayCalendar> findHolidayCalendarTest(
        java.lang.String holidayCalendarCodes,
        java.lang.String holidayCalendarTitles, java.lang.String dateFrom,
        java.lang.String dateTo, int start, int end, boolean andOperator,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .findHolidayCalendarTest(holidayCalendarCodes,
            holidayCalendarTitles, dateFrom, dateTo, start, end, andOperator,
            obc);
    }

    public static HolidayCalendarLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("HolidayCalendarLocalService is not set");
        }

        return _service;
    }

    public void setService(HolidayCalendarLocalService service) {
        _service = service;
    }
}
