package com.nss.portlet.nss_don_vi_thu_tuc.search;

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
import com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc;
import com.nss.portlet.nss_don_vi_thu_tuc.util.DonViThuTucSearchUtil;

public class DonViThuTucSearch extends SearchContainer<DonViThuTuc>{
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	
	static{
		headerNames.add("STT");
		headerNames.add("ten-don-vi-thu-tuc");
		headerNames.add("cap-don-vi-thu-tuc");
		headerNames.add("mo-ta");
		headerNames.add("active");
		headerNames.add("edit");
		headerNames.add("delete");
		
		orderableHeaders.put("ten-don-vi-thu-tuc", "tenDonViThuTuc");
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public DonViThuTucSearch(RenderRequest renderRequest, PortletURL iteratorURL){
			super(renderRequest, new DonViThuTucDisplayTerms(renderRequest), new DonViThuTucSearchTerms(renderRequest),
					DEFAULT_CUR_PARAM,DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
			
			DonViThuTucDisplayTerms displayTerms = (DonViThuTucDisplayTerms)getDisplayTerms();
			
			iteratorURL.setParameter(DonViThuTucDisplayTerms.TEN_DON_VI_THU_TUC, displayTerms.getTenDonViThuTuc());
			iteratorURL.setParameter(DonViThuTucDisplayTerms.MO_TA, displayTerms.getMoTa());
			
			try {
				PortalPreferences preferences = PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

				String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
				String orderByType = ParamUtil.getString(renderRequest, "orderByType");

				String portletName = "NSS_NSS_DON_VI_THU_TUC";
				
				if (Validator.isNotNull(orderByCol) &&
					Validator.isNotNull(orderByType)) {

					preferences.setValue(portletName, "donViThuTuc-order-by-col", orderByCol);
					preferences.setValue(portletName, "donViThuTuc-order-by-type", orderByType);
				}
				
				else {
					orderByCol = preferences.getValue(portletName, "donViThuTuc-order-by-col", "tenDonViThuTuc");
					orderByType = preferences.getValue(portletName, "donViThuTuc-order-by-type", "asc");
				}

				OrderByComparator orderByComparator = DonViThuTucSearchUtil.getDonViThuTucOrderByComparator(orderByCol, orderByType);

				setOrderableHeaders(orderableHeaders);
				setOrderByCol(orderByCol);
				setOrderByType(orderByType);
				setOrderByComparator(orderByComparator);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
		
		private static Log _log = LogFactoryUtil.getLog(DonViThuTucSearch.class);
}
