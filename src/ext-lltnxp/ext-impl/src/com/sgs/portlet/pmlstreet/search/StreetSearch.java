package com.sgs.portlet.pmlstreet.search;


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
import com.sgs.portlet.pmlstreet.model.PmlStreet;
import com.sgs.portlet.pmlstreet.util.PmlStreetUtil;

public class StreetSearch extends SearchContainer<PmlStreet>{
	static List<String> headernames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static{
		headernames.add("STT");
		headernames.add("ma_duong");
		headernames.add("ten_duong");
		headernames.add("");
		
		orderableHeaders.put("ten_duong", "tenDuong");
		
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public StreetSearch(RenderRequest renderRequest, PortletURL iteratorURL){
		super(renderRequest, new StreetDisplayTerms(renderRequest), new StreetSearchTerms(renderRequest),
				DEFAULT_CUR_PARAM, DEFAULT_DELTA, iteratorURL, headernames, EMPTY_RESULTS_MESSAGE);
		
		StreetDisplayTerms displayTerms = (StreetDisplayTerms) getDisplayTerms();
		
		iteratorURL.setParameter(StreetDisplayTerms.TEN, displayTerms.getTen());
		
		try {
			 PortalPreferences preferences = PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);
			 
			 String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
			 String orderByType = ParamUtil.getString(renderRequest, "orderByType");
			 
			 if(Validator.isNotNull(orderByCol)&& Validator.isNotNull(orderByType)){
				 
				 preferences.setValue("SGS_PMLSTREET", "street-order-by-column",orderByCol);
				 preferences.setValue("SGS_PMLSTREET", "street-order-by-type",orderByType);
			 }else{
				 preferences.setValue("SGS_PMLSTREET", "street-order-by-column", "tenDuong");
				 preferences.setValue("SGS_PMLSTREET", "street-order-by-type", "asc");
			 }
			 OrderByComparator orderByComparator = PmlStreetUtil.getStreetOrderByComparator(orderByCol, orderByType);
				setOrderableHeaders(orderableHeaders);
				setOrderByCol(orderByCol);
				setOrderByType(orderByType);
				setOrderByComparator(orderByComparator);

		} catch (Exception e) {
			_log.error(e);
		}
	}
	
	private Log _log = LogFactoryUtil.getLog(StreetSearch.class);
}
