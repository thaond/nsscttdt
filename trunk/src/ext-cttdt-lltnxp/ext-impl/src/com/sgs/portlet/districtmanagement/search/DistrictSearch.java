package com.sgs.portlet.districtmanagement.search;

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
import com.sgs.portlet.districtmanagement.model.District;
import com.sgs.portlet.districtmanagement.util.DistrictUtil;

public class DistrictSearch extends SearchContainer<District>{
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static{
		headerNames.add("STT");
		headerNames.add("districtmanagement.code");
		headerNames.add("districtmanagement.name");
		headerNames.add("districtmanagement.description");
		headerNames.add("citymanagement.name");
		headerNames.add("districtmanagement.active");
		headerNames.add("districtmanagement.edit");
		headerNames.add("districtmanagement.delete");
		
		orderableHeaders.put("districtmanagement.code", "ma");
		orderableHeaders.put("districtmanagement.name", "ten");
		orderableHeaders.put("citymanagement.name", "tenTinh");
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public DistrictSearch(RenderRequest renderRequest, PortletURL iteratorURL){
		super(renderRequest, new DistrictDisplayTerms(renderRequest), new DistrictSearchTerms(renderRequest),
				DEFAULT_CUR_PARAM,DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
		
		DistrictDisplayTerms displayTerms = (DistrictDisplayTerms) getDisplayTerms();
		
		iteratorURL.setParameter(DistrictDisplayTerms.MA, displayTerms.getMa());
		iteratorURL.setParameter(DistrictDisplayTerms.TEN, displayTerms.getTen());
		iteratorURL.setParameter(DistrictDisplayTerms.MOTA, displayTerms.getMota());
		
		try {
			PortalPreferences preferences =
				PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

			String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
			String orderByType = ParamUtil.getString(renderRequest, "orderByType");

			String portletName = "SGS_DISTRICTMANAGEMENT";
			
			if (Validator.isNotNull(orderByCol) &&
				Validator.isNotNull(orderByType)) {

				preferences.setValue(portletName, "district-order-by-col", orderByCol);
				preferences.setValue(portletName, "district-order-by-type", orderByType);
			}
			
			else {
				orderByCol = preferences.getValue(portletName, "district-order-by-col", "ma");
				orderByType = preferences.getValue(portletName, "district-order-by-type", "asc");
			}

			OrderByComparator orderByComparator = DistrictUtil.getDistrictOrderByComparator(orderByCol, orderByType);

			setOrderableHeaders(orderableHeaders);
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error(e);
		}
		 
	}
	private static Log _log = LogFactoryUtil.getLog(DistrictSearch.class);
	

}
