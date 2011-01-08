package com.sgs.portlet.wardsmanagement.search;

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
import com.sgs.portlet.wardsmanagement.model.Wards;
import com.sgs.portlet.wardsmanagement.util.WardUtil;

public class WardSearch extends SearchContainer<Wards>{
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static{
		headerNames.add("STT");
		headerNames.add("wardsmanagement.code");
		headerNames.add("wardsmanagement.name");
		headerNames.add("wardsmanagement.description");
		headerNames.add("districtmanagement.name");
		headerNames.add("wardsmanagement.active");
		headerNames.add("wardsmanagement.edit");
		headerNames.add("wardsmanagement.delete");
		
		orderableHeaders.put("wardsmanagement.code", "ma");
		orderableHeaders.put("wardsmanagement.name", "ten");
		orderableHeaders.put("districtmanagement.name", "quan");
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public WardSearch(RenderRequest renderRequest, PortletURL iteratorURL){
		super(renderRequest, new WardDisplayTerms(renderRequest), new WardSearchTerms(renderRequest),
				DEFAULT_CUR_PARAM,DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
		
		WardDisplayTerms displayTerms = (WardDisplayTerms) getDisplayTerms();
		
		iteratorURL.setParameter(WardDisplayTerms.MA, displayTerms.getMa());
		iteratorURL.setParameter(WardDisplayTerms.TEN, displayTerms.getTen());
		iteratorURL.setParameter(WardDisplayTerms.MOTA, displayTerms.getMota());
		
		try {
			PortalPreferences preferences =
				PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

			String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
			String orderByType = ParamUtil.getString(renderRequest, "orderByType");

			String portletName = "SGS_WARDSMANAGEMENT";
			
			if (Validator.isNotNull(orderByCol) &&
				Validator.isNotNull(orderByType)) {

				preferences.setValue(portletName, "wards-order-by-col", orderByCol);
				preferences.setValue(portletName, "wards-order-by-type", orderByType);
			}
			
			else {
				orderByCol = preferences.getValue(portletName, "wards-order-by-col", "ma");
				orderByType = preferences.getValue(portletName, "wards-order-by-type", "asc");
			}

			OrderByComparator orderByComparator = WardUtil.getWardOrderByComparator(orderByCol, orderByType);
			setOrderableHeaders(orderableHeaders);
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error(e);
		}
		 
	}
	private static Log _log = LogFactoryUtil.getLog(WardSearch.class);
}
