package com.sgs.portlet.holiday_calendar.service.impl;

import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.holiday_calendar.model.AttactFileHoliday;
import com.sgs.portlet.holiday_calendar.model.HolidayCalendar;
import com.sgs.portlet.holiday_calendar.service.base.HolidayCalendarLocalServiceBaseImpl;


public class HolidayCalendarLocalServiceImpl extends HolidayCalendarLocalServiceBaseImpl {
	
	public List<AttactFileHoliday> getAttactFileHolidays(long holidayCalendarId) throws SystemException{
		return holidayCalendarPersistence.getAttactFileHolidaies(holidayCalendarId);
	}
	
	public int countHolidayCalendarTest(String holidayCalendarCodes, String holidayCalendarTitles, String dateFrom, String dateTo, boolean andOperator) throws SystemException{
		return holidayCalendarFinder.count_holiday_calendar_test(holidayCalendarCodes, holidayCalendarTitles, dateFrom, dateTo, andOperator);
	}
	
	public List<HolidayCalendar> findHolidayCalendarTest(String holidayCalendarCodes, String holidayCalendarTitles, String dateFrom, String dateTo, int start, int end, boolean andOperator, OrderByComparator obc) throws SystemException{
		return holidayCalendarFinder.find_holiday_calendar_test(holidayCalendarCodes, holidayCalendarTitles, dateFrom, dateTo, start, end, andOperator, obc);
	}
}
