package com.nss.portlet.generatetemplateid.search;

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
import com.nss.portlet.generatetemplateid.model.IdTemplate;
import com.nss.portlet.generatetemplateid.util.GenerateTemplateIdUtil;

public class GenerateTemplateIdSearch extends SearchContainer<IdTemplate>{
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static{
		headerNames.add("STT");
		headerNames.add("dinh-dang");
		headerNames.add("description");
		headerNames.add("edit");
		headerNames.add("delete");
		
		orderableHeaders.put("dinh-dang", "code");
		orderableHeaders.put("description", "description");
		
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public GenerateTemplateIdSearch(RenderRequest renderRequest, PortletURL iteratorURL) {
		super(renderRequest, new GenerateTemplateIdDisplayTerms(renderRequest), new GenerateTemplateIdSearchTerms(renderRequest),
				DEFAULT_CUR_PARAM, DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
		
		GenerateTemplateIdDisplayTerms displayTerms = (GenerateTemplateIdDisplayTerms)getDisplayTerms();
		
		iteratorURL.setParameter(GenerateTemplateIdDisplayTerms.DINHDANG, displayTerms.getDinhDang());
		iteratorURL.setParameter(GenerateTemplateIdDisplayTerms.MOTA, displayTerms.getMoTa());
		
		try {
			PortalPreferences preferences =
				PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

			String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
			String orderByType = ParamUtil.getString(renderRequest, "orderByType");

			String portletName = "NSS_GENERATETEMPLATEID";
			
			if (Validator.isNotNull(orderByCol) &&
				Validator.isNotNull(orderByType)) {

				preferences.setValue(portletName, "idtemplate-order-by-col", orderByCol);
				preferences.setValue(portletName, "idtemplate-order-by-type", orderByType);
			}
			
			else {
				orderByCol = preferences.getValue(portletName, "idtemplate-order-by-col", "code");
				orderByType = preferences.getValue(portletName, "idtemplate-order-by-type", "asc");
			}

			OrderByComparator orderByComparator = GenerateTemplateIdUtil.getGenerateTemplateIdOrderByComparator(orderByCol, orderByType);

			setOrderableHeaders(orderableHeaders);
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}
	
	private static Log _log = LogFactoryUtil.getLog(GenerateTemplateIdSearch.class);

}
