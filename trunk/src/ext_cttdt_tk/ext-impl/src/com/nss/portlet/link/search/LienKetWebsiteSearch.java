package com.nss.portlet.link.search;

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
import com.nss.portlet.link.model.LienKetWebsite;
import com.nss.portlet.link.util.LienKetWebsiteSearchUtil;

public class LienKetWebsiteSearch extends SearchContainer<LienKetWebsite> {
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static{
		headerNames.add("STT");
		headerNames.add("ten-website");
		headerNames.add("hinh");
		headerNames.add("mo-ta");
		headerNames.add("loai-website");
		headerNames.add("thu-tu-website");
		headerNames.add("target");
		headerNames.add("active");
		headerNames.add("edit");
		headerNames.add("delete");
		
		orderableHeaders.put("ten-website", "tenwebsite");
		orderableHeaders.put("thu-tu-website", "thuTuwebsite");
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public LienKetWebsiteSearch(RenderRequest renderRequest, PortletURL iteratorURL){
		super(renderRequest, new LienKetWebsiteDisplayTerms(renderRequest), new LienKetWebsiteSearchTerms(renderRequest),
				DEFAULT_CUR_PARAM,DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
		
		LienKetWebsiteDisplayTerms displayTerms = (LienKetWebsiteDisplayTerms)getDisplayTerms();
		
		iteratorURL.setParameter(LienKetWebsiteDisplayTerms.TEN_WEBSITE, displayTerms.getTenWebsite());
		iteratorURL.setParameter(LienKetWebsiteDisplayTerms.MO_TA, displayTerms.getMoTa());
		
		try {
			PortalPreferences preferences =
				PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

			String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
			String orderByType = ParamUtil.getString(renderRequest, "orderByType");

			String portletName = "NSS_LINK";
			
			if (Validator.isNotNull(orderByCol) &&
				Validator.isNotNull(orderByType)) {

				preferences.setValue(portletName, "lienketwebsite-order-by-col", orderByCol);
				preferences.setValue(portletName, "lienketwebsite-order-by-type", orderByType);
			}
			
			else {
				orderByCol = preferences.getValue(portletName, "lienketwebsite-order-by-col", "tenwebsite");
				orderByType = preferences.getValue(portletName, "lienketwebsite-order-by-type", "asc");
			}

			OrderByComparator orderByComparator = LienKetWebsiteSearchUtil.getLienKetWebsiteOrderByComparator(orderByCol, orderByType);

			setOrderableHeaders(orderableHeaders);
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}
	
	private static Log _log = LogFactoryUtil.getLog(LienKetWebsiteSearch.class);
}
