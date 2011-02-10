package com.sgs.portlet.holiday_calendar.uitl;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.holiday_calendar.model.HolidayCalendar;

public class HolidayCalendarDateCreateComparator extends OrderByComparator {

	private static final long serialVersionUID = 1L;

	public static String ORDER_BY_ASC = "holidayCalendarDateCreate ASC";

	public static String ORDER_BY_DESC = "holidayCalendarDateCreate DESC";

	private boolean _asc;

	public HolidayCalendarDateCreateComparator() {
		this(false);
	}

	public HolidayCalendarDateCreateComparator(boolean asc) {
		this._asc = asc;
	}

	public int compare(Object o1, Object o2) {
		HolidayCalendar hc1 = (HolidayCalendar) o1;
		HolidayCalendar hc2 = (HolidayCalendar) o2;

		int value = hc1.getHolidayCalendarDateCreate().compareTo(hc2.getHolidayCalendarDateCreate());

		if (this._asc) {
			return value;
		} else {
			return -value;
		}
	}

	public String getOrderBy() {
		if (_asc) {
			return ORDER_BY_ASC;
		} else {
			return ORDER_BY_DESC;
		}
	}
}
