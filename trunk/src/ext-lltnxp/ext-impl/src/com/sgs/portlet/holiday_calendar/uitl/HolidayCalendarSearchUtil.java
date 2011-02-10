package com.sgs.portlet.holiday_calendar.uitl;

import com.liferay.portal.kernel.util.OrderByComparator;

public class HolidayCalendarSearchUtil {

	public static OrderByComparator getHolidayCalendarOrderByComparator(String orderByCol, String orderByType) {
		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals("holidayCalendarCode")) {
			orderByComparator = new HolidayCalendarCodeComparator(orderByAsc);
		} else if (orderByCol.equals("holidayCalendarDateCreate")) {
			orderByComparator = new HolidayCalendarDateCreateComparator(orderByAsc);
		}  else if (orderByCol.equals("holidayCalendarTitle")) {
			orderByComparator = new HolidayCalendarTitleComparator(orderByAsc);
		}

		return orderByComparator;
	}
}
