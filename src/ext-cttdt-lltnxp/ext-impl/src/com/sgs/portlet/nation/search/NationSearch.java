package com.sgs.portlet.nation.search;

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
import com.sgs.portlet.nation.model.Nation;
import com.sgs.portlet.nation.util.NationUtil;

public class NationSearch extends SearchContainer<Nation>{
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static{
		headerNames.add("STT");
		headerNames.add("code.");
		headerNames.add("name.");
		headerNames.add("country.");
		headerNames.add("description.");
		headerNames.add("active.");
		headerNames.add("edit");
		headerNames.add("delete");
		
		orderableHeaders.put("code.", "ma");
		orderableHeaders.put("name.", "ten");
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public NationSearch(RenderRequest renderRequest, PortletURL iteratorURL){
		super(renderRequest, new NationDisplayTerms(renderRequest), new NationSearchTerms(renderRequest),
				DEFAULT_CUR_PARAM,DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
		
		NationDisplayTerms displayTerms = (NationDisplayTerms) getDisplayTerms();
		
		iteratorURL.setParameter(NationDisplayTerms.MA, displayTerms.getMa());
		iteratorURL.setParameter(NationDisplayTerms.TEN, displayTerms.getTen());
		iteratorURL.setParameter(NationDisplayTerms.MOTA, displayTerms.getMota());
		
		try {
			PortalPreferences preferences =
				PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

			String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
			String orderByType = ParamUtil.getString(renderRequest, "orderByType");

			String portletName = "SGS_NATION";
			
			if (Validator.isNotNull(orderByCol) &&
				Validator.isNotNull(orderByType)) {

				preferences.setValue(portletName, "nation-order-by-col", orderByCol);
				preferences.setValue(portletName, "nation-order-by-type", orderByType);
			}
			
			else {
				orderByCol = preferences.getValue(portletName, "nation-order-by-col", "ma");
				orderByType = preferences.getValue(portletName, "nation-order-by-type", "asc");
			}

			OrderByComparator orderByComparator = NationUtil.getNationOrderByComparator(orderByCol, orderByType);

			setOrderableHeaders(orderableHeaders);
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error(e);
		}
		 
	}
	private static Log _log = LogFactoryUtil.getLog(NationSearch.class);
	
}
