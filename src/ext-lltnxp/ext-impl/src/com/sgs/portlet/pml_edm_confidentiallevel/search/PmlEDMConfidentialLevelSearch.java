package com.sgs.portlet.pml_edm_confidentiallevel.search;

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
import com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel;
import com.sgs.portlet.pml_edm_confidentiallevel.util.PmlEDMConfidentialLevelSearchUtil;

public class PmlEDMConfidentialLevelSearch extends SearchContainer<PmlEdmConfidentialLevel>{
	static List<String> headernames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static{
		headernames.add("pccc-TN-stt");
		headernames.add("pml_edm_confidential_level_id");
		headernames.add("pml_edm_confidential_level_name");
		headernames.add("muc-do-do-mat");
		headernames.add("limit-view");
		headernames.add("participate-process");
		headernames.add("edit"); // Sua
		headernames.add("delete"); // Xoa
		
		orderableHeaders.put("pml_edm_confidential_level_name", "pml_edm_confidential_level_name");
		orderableHeaders.put("muc-do-do-mat", "muc-do-do-mat");
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public PmlEDMConfidentialLevelSearch(RenderRequest renderRequest, PortletURL iteratorURL){
		super(renderRequest, new PmlEDMConfidentialLevelDisplayTerms (renderRequest),
				new PmlEDMConfidentialLevelSearchTerms(renderRequest),
				DEFAULT_CUR_PARAM, DEFAULT_DELTA,
				iteratorURL, headernames, EMPTY_RESULTS_MESSAGE);
				
		PmlEDMConfidentialLevelDisplayTerms displayTerms = (PmlEDMConfidentialLevelDisplayTerms)getDisplayTerms();
		
		iteratorURL.setParameter(PmlEDMConfidentialLevelDisplayTerms.PMLEDMCONFIDENTIALLEVEL_NAME, displayTerms.getPmlEDMConfidentialLevelName());
		try {
			PortalPreferences preferences =
				PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

			String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
			String orderByType = ParamUtil.getString(renderRequest, "orderByType");

			String portletName = "SGS_PML_EDM_CONFIDENTIALLEVEL";
			
			if (Validator.isNotNull(orderByCol) &&
				Validator.isNotNull(orderByType)) {

				preferences.setValue(portletName, "pmledmconfidentiallevelworks-order-by-col",	orderByCol);
				preferences.setValue(portletName, "pmledmconfidentiallevelworks-order-by-type", orderByType);
			}
			
			else {
				orderByCol = preferences.getValue(portletName, "pmledmconfidentiallevelworks-order-by-col", "pml_edm_confidential_level_name");
				orderByType = preferences.getValue(portletName, "pmledmconfidentiallevelworks-order-by-type", "asc");
			}

			OrderByComparator orderByComparator = PmlEDMConfidentialLevelSearchUtil.getPmlEDMConfidentialLevelOrderByComparator(orderByCol, orderByType);

			setOrderableHeaders(orderableHeaders);
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}
	
	private final Log _log = LogFactoryUtil.getLog(PmlEDMConfidentialLevelSearch.class);
}
