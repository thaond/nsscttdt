package com.sgs.portlet.geneatedocumentcode.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.sgs.portlet.generatetemplateid.model.IdGenerated;

public class GenerateDocumentCodeSearch extends SearchContainer<IdGenerated>{
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static{
		headerNames.add("STT");
		headerNames.add("year");
		headerNames.add("number");
		headerNames.add("temple");
		headerNames.add("edit");
		headerNames.add("delete");
		
		orderableHeaders.put("number", "number");
		orderableHeaders.put("temple", "temple");
		
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public GenerateDocumentCodeSearch(RenderRequest renderRequest, PortletURL iteratorURL) {
		super(renderRequest, new GenerateDocumentCodeDisplayTerms(renderRequest), new GenerateDocumentCodeSearchTerms(renderRequest),
				DEFAULT_CUR_PARAM, DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
//		try {
//			PortalPreferences preferences =
//				PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);
//
//			String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
//			String orderByType = ParamUtil.getString(renderRequest, "orderByType");
//
//			String portletName = "SGS_GENERATETEMPLATEID";
//			
//			if (Validator.isNotNull(orderByCol) &&
//				Validator.isNotNull(orderByType)) {
//
//				preferences.setValue(portletName, "idgenerate-order-by-col", orderByCol);
//				preferences.setValue(portletName, "idgenerate-order-by-type", orderByType);
//			}
//			
//			else {
//				orderByCol = preferences.getValue(portletName, "idgenerate-order-by-col", "curvalue");
//				orderByType = preferences.getValue(portletName, "idgenerate-order-by-type", "asc");
//			}
//
//			OrderByComparator orderByComparator = GenerateTemplateIdUtil.getGenerateTemplateIdOrderByComparator(orderByCol, orderByType);
//
//			setOrderableHeaders(orderableHeaders);
//			setOrderByCol(orderByCol);
//			setOrderByType(orderByType);
//			setOrderByComparator(orderByComparator);
//		}
//		catch (Exception e) {
//			_log.error(e);
//		}
	}
	
//	private static Log _log = LogFactoryUtil.getLog(GenerateDocumentCodeSearch.class);


}
