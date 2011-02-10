package com.sgs.portlet.holiday_calendar.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.PortalPreferences;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.sgs.portlet.holiday_calendar.model.HolidayCalendar;
import com.sgs.portlet.holiday_calendar.uitl.HolidayCalendarSearchUtil;

public class HolidayCalendarSearch extends SearchContainer<HolidayCalendar>{
	
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	
	static{
		headerNames.add("stt");
		headerNames.add("holiday-calendar-code");
		headerNames.add("holiday-calendar-date-create");
		headerNames.add("holiday-calendar-title");
		headerNames.add("download");
		headerNames.add("edit");
		headerNames.add("delete");
		
		orderableHeaders.put("holiday-calendar-code", "holidayCalendarCode");
		orderableHeaders.put("holiday-calendar-date-create", "holidayCalendarDateCreate");
		orderableHeaders.put("holiday-calendar-title", "holidayCalendarTitle");
	}

	public static final String EMPTY_RESULTS_MESSAGE = "no-holiday-calendar-were-found";
	
	public HolidayCalendarSearch(RenderRequest renderRequest, PortletURL iteratorURL){
			super(renderRequest, new HolidayCalendarDisplayTerms(renderRequest), new HolidayCalendarSearchTerms(renderRequest),
						DEFAULT_CUR_PARAM,DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
			
			HolidayCalendarDisplayTerms displayTerms = (HolidayCalendarDisplayTerms)getDisplayTerms();
			
			iteratorURL.setParameter(HolidayCalendarDisplayTerms.DATEFROM, displayTerms.getDateFrom());
			iteratorURL.setParameter(HolidayCalendarDisplayTerms.DATETO, displayTerms.getDateTo());
			iteratorURL.setParameter(HolidayCalendarDisplayTerms.HOLIDAYCALENDARCODE, displayTerms.getHolidayCalendarCode());
			iteratorURL.setParameter(HolidayCalendarDisplayTerms.HOLIDAYCALENDARTITLE, displayTerms.getHolidayCalendarTitle());
			
			try {
				PortalPreferences preferences = PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

				String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
				String orderByType = ParamUtil.getString(renderRequest, "orderByType");

				String portletName = "SGS_HOLIDAY_CALENDAR";
				
				if (Validator.isNotNull(orderByCol) && Validator.isNotNull(orderByType)) {
					preferences.setValue(portletName, "holiday-calendar-order-by-col", orderByCol);
					preferences.setValue(portletName, "holiday-calendar-order-by-type", orderByType);
				} else {
					orderByCol = preferences.getValue(portletName, "holiday-calendar-order-by-col", "holidayCalendarCode");
					orderByType = preferences.getValue(portletName, "holiday-calendar-order-by-type", "asc");
				}

				OrderByComparator orderByComparator = HolidayCalendarSearchUtil.getHolidayCalendarOrderByComparator(orderByCol, orderByType);

				setOrderableHeaders(orderableHeaders);
				setOrderByCol(orderByCol);
				setOrderByType(orderByType);
				setOrderByComparator(orderByComparator);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
		
		private static Log _log = LogFactoryUtil.getLog(HolidayCalendarSearch.class);
}
