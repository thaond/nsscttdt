package com.sgs.portlet.country.search;

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
import com.sgs.portlet.country.model.Country;
import com.sgs.portlet.country.util.CountryUtil;

public class CountrySearch extends SearchContainer<Country>{
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static{
		headerNames.add("STT");
		headerNames.add("countryCode");
		headerNames.add("countryName");
		headerNames.add("description");
		headerNames.add("active.");
		headerNames.add("edit");
		headerNames.add("delete");
		
		orderableHeaders.put("countryCode", "ma");
		orderableHeaders.put("countryName", "ten");
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public CountrySearch(RenderRequest renderRequest, PortletURL iteratorURL){
		super(renderRequest, new CountryDisplayTerms(renderRequest), new CountrySearchTerms(renderRequest),
				DEFAULT_CUR_PARAM,DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
		
		CountryDisplayTerms displayTerms = (CountryDisplayTerms) getDisplayTerms();
		
		iteratorURL.setParameter(CountryDisplayTerms.MA, displayTerms.getMa());
		iteratorURL.setParameter(CountryDisplayTerms.TEN, displayTerms.getTen());
		iteratorURL.setParameter(CountryDisplayTerms.MOTA, displayTerms.getMota());
		
		try {
			PortalPreferences preferences =
				PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

			String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
			String orderByType = ParamUtil.getString(renderRequest, "orderByType");

			String portletName = "SGS_COUNTRY";
			
			if (Validator.isNotNull(orderByCol) &&
				Validator.isNotNull(orderByType)) {

				preferences.setValue(portletName, "country-order-by-col", orderByCol);
				preferences.setValue(portletName, "country-order-by-type", orderByType);
			}
			
			else {
				orderByCol = preferences.getValue(portletName, "country-order-by-col", "ma");
				orderByType = preferences.getValue(portletName, "country-order-by-type", "asc");
			}

			OrderByComparator orderByComparator = CountryUtil.getCountryOrderByComparator(orderByCol, orderByType);

			setOrderableHeaders(orderableHeaders);
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error(e);
		}
		 
	}
	private static Log _log = LogFactoryUtil.getLog(CountrySearch.class);
}
