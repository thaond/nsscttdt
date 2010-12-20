package com.nss.portlet.necessary_info.search;

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
import com.nss.portlet.necessary_info.model.ThongTinCanThiet;
import com.nss.portlet.necessary_info.util.ThongTinCanThietSearchUtil;

public class ThongTinCanThietSearch extends SearchContainer<ThongTinCanThiet> {
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static{
		headerNames.add("STT");
		headerNames.add("ten-thong-tin-can-thiet");
		headerNames.add("hinh");
		headerNames.add("mo-ta");
		headerNames.add("thu-tu-website");
		headerNames.add("target");
		headerNames.add("active");
		headerNames.add("edit");
		headerNames.add("delete");
		
		orderableHeaders.put("ten-thong-tin-can-thiet", "tenThongTinCanThiet");
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public ThongTinCanThietSearch(RenderRequest renderRequest, PortletURL iteratorURL){
			super(renderRequest, new ThongTinCanThietDisplayTerms(renderRequest), new ThongTinCanThietSearchTerms(renderRequest),
					DEFAULT_CUR_PARAM,DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
			
			ThongTinCanThietDisplayTerms displayTerms = (ThongTinCanThietDisplayTerms)getDisplayTerms();
			
			iteratorURL.setParameter(ThongTinCanThietDisplayTerms.TEN_THONG_TIN_CAN_THIET, displayTerms.getTenThongTinCanThiet());
			iteratorURL.setParameter(ThongTinCanThietDisplayTerms.MO_TA, displayTerms.getMoTa());
			
			try {
				PortalPreferences preferences =
					PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

				String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
				String orderByType = ParamUtil.getString(renderRequest, "orderByType");

				String portletName = "NSS_NECESSARY_INFO";
				
				if (Validator.isNotNull(orderByCol) &&
					Validator.isNotNull(orderByType)) {

					preferences.setValue(portletName, "thongTinCanThiet-order-by-col", orderByCol);
					preferences.setValue(portletName, "thongTinCanThiet-order-by-type", orderByType);
				}
				
				else {
					orderByCol = preferences.getValue(portletName, "thongTinCanThiet-order-by-col", "tenThongTinCanThiet");
					orderByType = preferences.getValue(portletName, "thongTinCanThiet-order-by-type", "asc");
				}

				OrderByComparator orderByComparator = ThongTinCanThietSearchUtil.getThongTinCanThietOrderByComparator(orderByCol, orderByType);

				setOrderableHeaders(orderableHeaders);
				setOrderByCol(orderByCol);
				setOrderByType(orderByType);
				setOrderByComparator(orderByComparator);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
		
		private static Log _log = LogFactoryUtil.getLog(ThongTinCanThietSearch.class);
}
