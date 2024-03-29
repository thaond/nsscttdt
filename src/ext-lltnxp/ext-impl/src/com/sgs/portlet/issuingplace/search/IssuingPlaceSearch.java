package com.sgs.portlet.issuingplace.search;

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
import com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace;
import com.sgs.portlet.issuingplace.util.IssuingPlaceUtil;

public class IssuingPlaceSearch extends SearchContainer<PmlEdmIssuingPlace>{
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static{
		headerNames.add("STT");
		headerNames.add("recordtype.code");
		headerNames.add("issuing-place-ten-don-vi-lien-quan");
		headerNames.add("pccc-TN-ghichu");
		headerNames.add("add-cap-gui");
		headerNames.add("");
//		headerNames.add("edit");
//		headerNames.add("delete");
		
		orderableHeaders.put("recordtype.code", "code");
		orderableHeaders.put("issuing-place-ten-don-vi-lien-quan", "name");
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public IssuingPlaceSearch(RenderRequest renderRequest, PortletURL iteratorURL){
			super(renderRequest, new IssuingPlaceDisplayTerms(renderRequest), new IssuingPlaceSearchTerms(renderRequest),
					DEFAULT_CUR_PARAM,DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
			
			IssuingPlaceDisplayTerms displayTerms = (IssuingPlaceDisplayTerms)getDisplayTerms();
			
			iteratorURL.setParameter(IssuingPlaceDisplayTerms.MA, displayTerms.getCode());
			iteratorURL.setParameter(IssuingPlaceDisplayTerms.NAME, displayTerms.getName());
			
			try {
				PortalPreferences preferences =
					PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

				String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
				String orderByType = ParamUtil.getString(renderRequest, "orderByType");

				String portletName = "SGS_ISSUINGPLACE";
				
				if (Validator.isNotNull(orderByCol) &&
					Validator.isNotNull(orderByType)) {

					preferences.setValue(portletName, "IssuingPlace-order-by-col", orderByCol);
					preferences.setValue(portletName, "IssuingPlace-order-by-type", orderByType);
				}
				
				else {
					orderByCol = preferences.getValue(portletName, "IssuingPlace-order-by-col", "code");
					orderByType = preferences.getValue(portletName, "IssuingPlace-order-by-type", "asc");
				}

				OrderByComparator orderByComparator = IssuingPlaceUtil.getIssuingPlaceByComparator(orderByCol, orderByType);

				setOrderableHeaders(orderableHeaders);
				setOrderByCol(orderByCol);
				setOrderByType(orderByType);
				setOrderByComparator(orderByComparator);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
		
		private static Log _log = LogFactoryUtil.getLog(IssuingPlaceSearch.class);

}
