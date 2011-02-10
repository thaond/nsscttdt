package com.sgs.portlet.organizationexternal.search;

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
import com.sgs.portlet.organizationexternal.model.OrganizationExternal;
import com.sgs.portlet.organizationexternal.util.OrganizationExternalUtil;

public class OrganizationExternalSearch extends SearchContainer<OrganizationExternal> {
	
	static List<String> headernames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static{
		headernames.add("STT");
		headernames.add("ma-to-chuc");
		headernames.add("ten-to-chuc");
		headernames.add("la-don-vi-cua-minh");
		headernames.add("edit");
		headernames.add("delete");
		
		orderableHeaders.put("ma-to-chuc", "ma");
		orderableHeaders.put("ten-to-chuc", "ten");
		
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public OrganizationExternalSearch( RenderRequest renderRequest, PortletURL iteratorURL) {
		super(renderRequest, new OrganizationExternalDisplayTerms(renderRequest), new OrganizationExternalSearchTerms(renderRequest),
				DEFAULT_CUR_PARAM, 10, iteratorURL, headernames, EMPTY_RESULTS_MESSAGE);
		
		OrganizationExternalDisplayTerms displayTerms = (OrganizationExternalDisplayTerms) getDisplayTerms();
		
		iteratorURL.setParameter(OrganizationExternalDisplayTerms.MA, displayTerms.getMa());
		iteratorURL.setParameter(OrganizationExternalDisplayTerms.TEN, displayTerms.getTen());
		
		try {
			 PortalPreferences preferences = PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);
			 
			 String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
			 String orderByType = ParamUtil.getString(renderRequest, "orderByType");
			 
			 String portletName = "SGS_ORGANIZATIONEXTERNAL";
			
			 if(Validator.isNotNull(orderByCol)&& Validator.isNotNull(orderByType)){
				 preferences.setValue(portletName, "organizationexternal-order-by-type",orderByCol);
				 preferences.setValue(portletName, "organizationexternal-order-by-type",orderByType);
			 }
			 else{
				 preferences.setValue(portletName, "organizationexternal-order-by-column", "ma");
				 preferences.setValue(portletName, "organizationexternal-order-by-type", "asc");
			 }
			 
			 OrderByComparator orderByComparator = OrganizationExternalUtil.getOrgExternalOrderByComparator(orderByCol, orderByType);
				setOrderableHeaders(orderableHeaders);
				setOrderByCol(orderByCol);
				setOrderByType(orderByType);
				setOrderByComparator(orderByComparator);

		} catch (Exception e) {
			_log.error(e);
		}
	}
	
	private Log _log = LogFactoryUtil.getLog(OrganizationExternalSearch.class);
}
