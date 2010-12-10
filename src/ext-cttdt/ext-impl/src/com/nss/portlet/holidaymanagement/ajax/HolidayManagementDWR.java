package com.nss.portlet.holidaymanagement.ajax;

import com.nss.portlet.holidaymanagement.service.PmlHolidayLocalServiceUtil;

public class HolidayManagementDWR {
	public int countHolidayByValue(String holidayValue) {
		return PmlHolidayLocalServiceUtil.countHolidayByValue(holidayValue);
	}
	
}
