package com.sgs.portlet.documentlevelsend.search;

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
import com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend;
import com.sgs.portlet.documentlevelsend.util.PmlEdmLevelSendSearchUtil;


public class PmlEdmLevelSendSearch extends SearchContainer<PmlEdmLevelSend>{
	static List<String> headernames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static{
		headernames.add("sgs_onedoor_no.");
//		headernames.add("recordtype.code");
		headernames.add("document.level");
		headernames.add("");
		
		orderableHeaders.put("document.level", "document.level");
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public PmlEdmLevelSendSearch(RenderRequest renderRequest, PortletURL iteratorURL){
		super(renderRequest, new PmlEdmLevelSendDisplayTerms (renderRequest),
				new PmlEdmLevelSendSearchTerms(renderRequest),
				DEFAULT_CUR_PARAM, DEFAULT_DELTA,
				iteratorURL, headernames, EMPTY_RESULTS_MESSAGE);
				
		PmlEdmLevelSendDisplayTerms displayTerms = (PmlEdmLevelSendDisplayTerms)getDisplayTerms();
		
		iteratorURL.setParameter(PmlEdmLevelSendDisplayTerms.PMLEDMLEVELSEND_NAME, displayTerms.getPmlEdmLevelSendName());
		try {
			PortalPreferences preferences =
				PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

			String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
			String orderByType = ParamUtil.getString(renderRequest, "orderByType");

			String portletName = "SGS_DOCUMENTLEVELSEND";
			
			if (Validator.isNotNull(orderByCol) &&
				Validator.isNotNull(orderByType)) {

				preferences.setValue(portletName, "pmledmlevelsendworks-order-by-col",	orderByCol);
				preferences.setValue(portletName, "pmledmlevelsendworks-order-by-type", orderByType);
			}
			
			else {
				orderByCol = preferences.getValue(portletName, "pmledmlevelsendworks-order-by-col", "document.level");
				orderByType = preferences.getValue(portletName, "pmledmlevelsendworks-order-by-type", "asc");
			}

			OrderByComparator orderByComparator = PmlEdmLevelSendSearchUtil.getPmlEdmLevelSendOrderByComparator(orderByCol, orderByType);

			setOrderableHeaders(orderableHeaders);
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}
	
	private final Log _log = LogFactoryUtil.getLog(PmlEdmLevelSendSearch.class);
}
