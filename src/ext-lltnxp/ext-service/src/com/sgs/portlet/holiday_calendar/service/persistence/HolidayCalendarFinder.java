package com.sgs.portlet.holiday_calendar.service.persistence;

public interface HolidayCalendarFinder {
    public int count_holiday_calendar_test(
        java.lang.String holidayCalendarCodes,
        java.lang.String holidayCalendarTitles, java.lang.String dateFrom,
        java.lang.String dateTo, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public int count_holiday_calendar_test(
        java.lang.String[] holidayCalendarCodes,
        java.lang.String[] holidayCalendarTitles, java.lang.String dateFrom,
        java.lang.String dateTo, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.holiday_calendar.model.HolidayCalendar> find_holiday_calendar_test(
        java.lang.String holidayCalendarCodes,
        java.lang.String holidayCalendarTitles, java.lang.String dateFrom,
        java.lang.String dateTo, int start, int end, boolean andOperator,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.holiday_calendar.model.HolidayCalendar> find_holiday_calendar_test(
        java.lang.String[] holidayCalendarCodes,
        java.lang.String[] holidayCalendarTitles, java.lang.String dateFrom,
        java.lang.String dateTo, boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;
}
