package com.sgs.portlet.pml_template_display.search;

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

public class PmlTemplateDisplaySearch extends SearchContainer<PmlTemplate>{
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static{
		headerNames.add("STT");
		headerNames.add("ma-bieu-mau");
		headerNames.add("ten-bieu-mau");
		headerNames.add("so-van-ban");
		headerNames.add("ngay-ban-hanh");
		headerNames.add("phong-ban-hanh");
		
		orderableHeaders.put("ma-bieu-mau", "maBieuMau");
		orderableHeaders.put("ten-bieu-mau", "tenBieuMau");
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	public PmlTemplateDisplaySearch(RenderRequest renderRequest, PortletURL iteratorURL){
		super(renderRequest, new PmlTemplateDisplayDisplay(renderRequest), new PmlTemplateDisplaySearchTerms(renderRequest),
				DEFAULT_CUR_PARAM,DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
		
		try {
			PortalPreferences preferences =
				PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

			String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
			String orderByType = ParamUtil.getString(renderRequest, "orderByType");

			String portletName = "SGS_PML_TEMPLATE_DISPLAY";
			
			if (Validator.isNotNull(orderByCol) &&
				Validator.isNotNull(orderByType)) {

				preferences.setValue(portletName, "pmlTemplateDisplay-order-by-col", orderByCol);
				preferences.setValue(portletName, "pmlTemplateDisplay-order-by-type", orderByType);
			}
			
			else {
				orderByCol = preferences.getValue(portletName, "pmlTemplateDisplay-order-by-col", "tenBieuMau");
				orderByType = preferences.getValue(portletName, "pmlTemplateDisplay-order-by-type", "asc");
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
	
	private static Log _log = LogFactoryUtil.getLog(PmlTemplateDisplaySearch.class);
}
