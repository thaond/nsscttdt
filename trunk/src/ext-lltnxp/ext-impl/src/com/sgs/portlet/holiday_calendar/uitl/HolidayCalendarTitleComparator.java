package com.sgs.portlet.holiday_calendar.uitl;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.holiday_calendar.model.HolidayCalendar;

public class HolidayCalendarTitleComparator extends OrderByComparator {

	private static final long serialVersionUID = 1L;

	public static String ORDER_BY_ASC = "holidayCalendarTitle ASC";

	public static String ORDER_BY_DESC = "holidayCalendarTitle DESC";

	private boolean _asc;

	public HolidayCalendarTitleComparator() {
		this(false);
	}

	public HolidayCalendarTitleComparator(boolean asc) {
		this._asc = asc;
	}

	public int compare(Object o1, Object o2) {
		HolidayCalendar hc1 = (HolidayCalendar) o1;
		HolidayCalendar hc2 = (HolidayCalendar) o2;

		int value = hc1.getHolidayCalendarTitle().compareTo(hc2.getHolidayCalendarTitle());

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
