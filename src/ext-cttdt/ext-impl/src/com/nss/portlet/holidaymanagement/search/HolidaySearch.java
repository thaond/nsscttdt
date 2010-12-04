package com.nss.portlet.holidaymanagement.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.nss.portlet.holidaymanagement.model.PmlHoliday;

public class HolidaySearch extends SearchContainer<PmlHoliday>{
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static{
		headerNames.add("STT");
		headerNames.add("holiday-kieu-ngay-nghi");
		headerNames.add("holiday-ngay-nghi");
		headerNames.add("edit");
		headerNames.add("delete");
		
		orderableHeaders.put("holiday-kieu-ngay-nghi", "kieuNgayNghi");
		orderableHeaders.put("holiday-ngay-nghi", "ngayNghi");
		
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public HolidaySearch(RenderRequest renderRequest, PortletURL iteratorURL) {
		super(renderRequest, new HolidayDisplayTerms(renderRequest), new HolidaySearchTerms(renderRequest),
				DEFAULT_CUR_PARAM, DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
	}

}
