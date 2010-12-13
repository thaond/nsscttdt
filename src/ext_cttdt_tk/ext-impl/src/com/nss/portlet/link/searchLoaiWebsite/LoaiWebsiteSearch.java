package com.nss.portlet.link.searchLoaiWebsite;

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
import com.nss.portlet.link.model.LoaiWebsite;
import com.nss.portlet.link.util.LoaiWebsiteSearchUtil;

public class LoaiWebsiteSearch extends SearchContainer<LoaiWebsite> {
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static{
		headerNames.add("STT");
		headerNames.add("ten-loai-website");
		headerNames.add("mo-ta");
		headerNames.add("active");
		headerNames.add("edit");
		headerNames.add("delete");
		
		orderableHeaders.put("ten-loai-website", "tenloaiwebsite");
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public LoaiWebsiteSearch(RenderRequest renderRequest, PortletURL iteratorURL){
		super(renderRequest, new LoaiWebsiteDisplayTerms(renderRequest), new LoaiWebsiteSearchTerms(renderRequest),
				DEFAULT_CUR_PARAM,DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
		
		LoaiWebsiteDisplayTerms displayTerms = (LoaiWebsiteDisplayTerms)getDisplayTerms();
		
		iteratorURL.setParameter(LoaiWebsiteDisplayTerms.TEN_LOAI_WEBSITE, displayTerms.getTenLoaiWebsite());
		iteratorURL.setParameter(LoaiWebsiteDisplayTerms.MO_TA_LOAI, displayTerms.getMoTaLoai());
		
		try {
			PortalPreferences preferences =
				PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

			String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
			String orderByType = ParamUtil.getString(renderRequest, "orderByType");

			String portletName = "NSS_LINK";
			
			if (Validator.isNotNull(orderByCol) &&
				Validator.isNotNull(orderByType)) {

				preferences.setValue(portletName, "loaiwebsite-order-by-col", orderByCol);
				preferences.setValue(portletName, "loaiwebsite-order-by-type", orderByType);
			}
			
			else {
				orderByCol = preferences.getValue(portletName, "loaiwebsite-order-by-col", "tenloaiwebsite");
				orderByType = preferences.getValue(portletName, "loaiwebsite-order-by-type", "asc");
			}

			OrderByComparator orderByComparator = LoaiWebsiteSearchUtil.getLoaiWebsiteOrderByComparator(orderByCol, orderByType);

			setOrderableHeaders(orderableHeaders);
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}
	
	private static Log _log = LogFactoryUtil.getLog(LoaiWebsiteSearch.class);
}
