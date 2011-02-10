package com.sgs.portlet.holiday_calendar_index.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class HolidayCalendarIndexSearchTerms extends HolidayCalendarIndexDisplayTerms {
	
	public HolidayCalendarIndexSearchTerms(RenderRequest renderRequest) {
		super(renderRequest);
		holidayCalendarCode = DAOParamUtil.getLike(renderRequest, HOLIDAYCALENDARCODE);
		holidayCalendarTitle = DAOParamUtil.getLike(renderRequest, HOLIDAYCALENDARTITLE);
		dateFrom = DAOParamUtil.getString(renderRequest, DATEFROM);
		dateTo = DAOParamUtil.getString(renderRequest, DATETO);
	}
}