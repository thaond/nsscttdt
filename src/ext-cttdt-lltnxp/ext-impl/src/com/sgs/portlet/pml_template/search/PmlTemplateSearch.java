package com.sgs.portlet.pml_template.search;

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
import com.sgs.portlet.pml_template.model.PmlTemplate;
import com.sgs.portlet.pml_template.util.PmlTemplateSearchUtil;

public class PmlTemplateSearch extends SearchContainer<PmlTemplate> {
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static{
		headerNames.add("STT");
		headerNames.add("ma-bieu-mau");
		headerNames.add("ten-bieu-mau");
		headerNames.add("so-van-ban");
		headerNames.add("ngay-ban-hanh");
		headerNames.add("phong-ban-hanh");
		headerNames.add("edit");
		headerNames.add("delete");
		
		orderableHeaders.put("ma-bieu-mau", "maBieuMau");
		orderableHeaders.put("ten-bieu-mau", "tenBieuMau");
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public PmlTemplateSearch(RenderRequest renderRequest, PortletURL iteratorURL){
		super(renderRequest, new PmlTemplateDisplayTerms(renderRequest), new PmlTemplateSearchTerms(renderRequest),
				DEFAULT_CUR_PARAM,DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
		
		try {
			PortalPreferences preferences =
				PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

			String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
			String orderByType = ParamUtil.getString(renderRequest, "orderByType");

			String portletName = "SGS_PML_TEMPLATE";
			
			if (Validator.isNotNull(orderByCol) &&
				Validator.isNotNull(orderByType)) {

				preferences.setValue(portletName, "pmlTemplate-order-by-col", orderByCol);
				preferences.setValue(portletName, "pmlTemplate-order-by-type", orderByType);
			}
			
			else {
				orderByCol = preferences.getValue(portletName, "pmlTemplate-order-by-col", "tenBieuMau");
				orderByType = preferences.getValue(portletName, "pmlTemplate-order-by-type", "asc");
			}

			OrderByComparator orderByComparator = PmlTemplateSearchUtil.getPmlTemplateOrderByComparator(orderByCol, orderByType);

			setOrderableHeaders(orderableHeaders);
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}
	
	private static Log _log = LogFactoryUtil.getLog(PmlTemplateSearch.class);
}
