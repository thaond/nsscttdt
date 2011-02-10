package com.sgs.portlet.citymanagement.search;

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
import com.sgs.portlet.citymanagement.model.City;
import com.sgs.portlet.citymanagement.util.CitySearchUtil;

public class CitySearch extends SearchContainer<City>{
	static List<String> headernames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	
	static{
		headernames.add("STT");
		headernames.add("citymanagement.code");
		headernames.add("citymanagement.name");
		headernames.add("description");
		headernames.add("");
		
		orderableHeaders.put("citymanagement.code", "ma");
		orderableHeaders.put("citymanagement.name", "ten");
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public CitySearch(RenderRequest renderRequest, PortletURL iteratorURL){
		super(renderRequest, new CityDisplayTerms(renderRequest), new CitySearchTerms(renderRequest),
				DEFAULT_CUR_PARAM, DEFAULT_DELTA, iteratorURL, headernames, EMPTY_RESULTS_MESSAGE);
		
		CityDisplayTerms displayTerms = (CityDisplayTerms)getDisplayTerms();
		iteratorURL.setParameter(CityDisplayTerms.MA, displayTerms.getMa());
		iteratorURL.setParameter(CityDisplayTerms.TEN, displayTerms.getTen());
		
		try {
			PortalPreferences preferences =
				PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

			String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
			String orderByType = ParamUtil.getString(renderRequest, "orderByType");

			String portletName = "SGS_CITYMANAGEMENT";
			
			if (Validator.isNotNull(orderByCol) &&
				Validator.isNotNull(orderByType)) {

				preferences.setValue(portletName, "city-order-by-col", orderByCol);
				preferences.setValue(portletName, "city-order-by-type", orderByType);
			}
			
			else {
				orderByCol = preferences.getValue(portletName, "city-order-by-col", "tenLanhDao");
				orderByType = preferences.getValue(portletName, "city-order-by-type", "asc");
			}

			OrderByComparator orderByComparator = CitySearchUtil.getCityOrderByComparator(orderByCol, orderByType);

			setOrderableHeaders(orderableHeaders);
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}
	
	private static Log _log = LogFactoryUtil.getLog(CitySearch.class);

}
