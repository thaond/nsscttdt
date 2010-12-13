package com.nss.portlet.co_quan_ban_hanh.search;

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
import com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh;
import com.nss.portlet.co_quan_ban_hanh.util.CoQuanBanHanhSearchUtil;

public class CoQuanBanHanhSearch extends SearchContainer<CoQuanBanHanh>{
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static{
		headerNames.add("STT");
		headerNames.add("ten-co-quan-ban-hanh");
		headerNames.add("mo-ta");
		headerNames.add("active");
		headerNames.add("edit");
		headerNames.add("delete");
		
		orderableHeaders.put("ten-co-quan-ban-hanh", "tenCoQuanBanHanh");
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public CoQuanBanHanhSearch(RenderRequest renderRequest, PortletURL iteratorURL){
			super(renderRequest, new CoQuanBanHanhDisplayTerms(renderRequest), new CoQuanBanHanhSearchTerms(renderRequest),
					DEFAULT_CUR_PARAM,DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
			
			CoQuanBanHanhDisplayTerms displayTerms = (CoQuanBanHanhDisplayTerms)getDisplayTerms();
			
			iteratorURL.setParameter(CoQuanBanHanhDisplayTerms.TEN_CO_QUAN_BAN_HANH, displayTerms.getTenCoQuanBanHanh());
			iteratorURL.setParameter(CoQuanBanHanhDisplayTerms.MO_TA, displayTerms.getMoTa());
			
			try {
				PortalPreferences preferences =
					PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

				String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
				String orderByType = ParamUtil.getString(renderRequest, "orderByType");

				String portletName = "NSS_CO_QUAN_BAN_HANH";
				
				if (Validator.isNotNull(orderByCol) &&
					Validator.isNotNull(orderByType)) {

					preferences.setValue(portletName, "coQuanBanHanh-order-by-col", orderByCol);
					preferences.setValue(portletName, "coQuanBanHanh-order-by-type", orderByType);
				}
				
				else {
					orderByCol = preferences.getValue(portletName, "coQuanBanHanh-order-by-col", "tenCoQuanBanHanh");
					orderByType = preferences.getValue(portletName, "coQuanBanHanh-order-by-type", "asc");
				}

				OrderByComparator orderByComparator = CoQuanBanHanhSearchUtil.getCoQuanBanHanhOrderByComparator(orderByCol, orderByType);

				setOrderableHeaders(orderableHeaders);
				setOrderByCol(orderByCol);
				setOrderByType(orderByType);
				setOrderByComparator(orderByComparator);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
		
		private static Log _log = LogFactoryUtil.getLog(CoQuanBanHanhSearch.class);
}
