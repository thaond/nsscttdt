package com.sgs.portlet.holiday_calendar.service.persistence;

public class HolidayCalendarFinderUtil {
    private static HolidayCalendarFinder _finder;

    public static int count_holiday_calendar_test(
        java.lang.String holidayCalendarCodes,
        java.lang.String holidayCalendarTitles, java.lang.String dateFrom,
        java.lang.String dateTo, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .count_holiday_calendar_test(holidayCalendarCodes,
            holidayCalendarTitles, dateFrom, dateTo, andOperator);
    }

    public static int count_holiday_calendar_test(
        java.lang.String[] holidayCalendarCodes,
        java.lang.String[] holidayCalendarTitles, java.lang.String dateFrom,
        java.lang.String dateTo, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .count_holiday_calendar_test(holidayCalendarCodes,
            holidayCalendarTitles, dateFrom, dateTo, andOperator);
    }

    public static java.util.List<com.sgs.portlet.holiday_calendar.model.HolidayCalendar> find_holiday_calendar_test(
        java.lang.String holidayCalendarCodes,
        java.lang.String holidayCalendarTitles, java.lang.String dateFrom,
        java.lang.String dateTo, int start, int end, boolean andOperator,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .find_holiday_calendar_test(holidayCalendarCodes,
            holidayCalendarTitles, dateFrom, dateTo, start, end, andOperator,
            obc);
    }

    public static java.util.List<com.sgs.portlet.holiday_calendar.model.HolidayCalendar> find_holiday_calendar_test(
        java.lang.String[] holidayCalendarCodes,
        java.lang.String[] holidayCalendarTitles, java.lang.String dateFrom,
        java.lang.String dateTo, boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .find_holiday_calendar_test(holidayCalendarCodes,
            holidayCalendarTitles, dateFrom, dateTo, andOperator, start, end,
            obc);
    }

    public static HolidayCalendarFinder getFinder() {
        return _finder;
    }

    public void setFinder(HolidayCalendarFinder finder) {
        _finder = finder;
    }
}
