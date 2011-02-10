package com.sgs.portlet.holiday_calendar.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class HolidayCalendarDisplayTerms extends DisplayTerms {
	
	public static final String HOLIDAYCALENDARCODE = "holidayCalendarCode";
	public static final String HOLIDAYCALENDARTITLE = "holidayCalendarTitle";
	public static final String DATEFROM = "dateFrom";
	public static final String DATETO = "dateTo";

	protected String holidayCalendarCode;
	protected String holidayCalendarTitle;
	protected String dateFrom;
	protected String dateTo;

	public HolidayCalendarDisplayTerms(RenderRequest renderRequest) {
		super(renderRequest);
		holidayCalendarCode = ParamUtil.getString(renderRequest, HOLIDAYCALENDARCODE);
		holidayCalendarTitle = ParamUtil.getString(renderRequest, HOLIDAYCALENDARTITLE);
		dateFrom = ParamUtil.getString(renderRequest, DATEFROM);
		dateTo = ParamUtil.getString(renderRequest, DATETO);

	}
	public String getHolidayCalendarCode() {
		return holidayCalendarCode;
	}

	public void setHolidayCalendarCode(String holidayCalendarCode) {
		this.holidayCalendarCode = holidayCalendarCode;
	}

	public String getHolidayCalendarTitle() {
		return holidayCalendarTitle;
	}

	public void setHolidayCalendarTitle(String holidayCalendarTitle) {
		this.holidayCalendarTitle = holidayCalendarTitle;
	}
	public String getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}
	public String getDateTo() {
		return dateTo;
	}
	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}
	
}
