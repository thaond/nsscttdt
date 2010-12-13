package com.nss.portlet.thong_tin_lien_quan.search;

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
import com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan;
import com.nss.portlet.thong_tin_lien_quan.util.ThongTinLienQuanSearchUtil;

public class ThongTinLienQuanSearch extends SearchContainer<ThongTinLienQuan> {
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static{
		headerNames.add("STT");
		headerNames.add("ten-thong-tin-lien-quan");
		headerNames.add("hinh");
		headerNames.add("mo-ta");
		headerNames.add("thu-tu-website");
		headerNames.add("target");
		headerNames.add("active");
		headerNames.add("edit");
		headerNames.add("delete");
		
		orderableHeaders.put("ten-thong-tin-lien-quan", "tenThongTinLienQuan");
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public ThongTinLienQuanSearch(RenderRequest renderRequest, PortletURL iteratorURL){
			super(renderRequest, new ThongTinLienQuanDisplayTerms(renderRequest), new ThongTinLienQuanSearchTerms(renderRequest),
					DEFAULT_CUR_PARAM,DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
			
			ThongTinLienQuanDisplayTerms displayTerms = (ThongTinLienQuanDisplayTerms)getDisplayTerms();
			
			iteratorURL.setParameter(ThongTinLienQuanDisplayTerms.TEN_THONG_TIN_LIEN_QUAN, displayTerms.getTenThongTinLienQuan());
			iteratorURL.setParameter(ThongTinLienQuanDisplayTerms.MO_TA, displayTerms.getMoTa());
			
			try {
				PortalPreferences preferences =
					PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

				String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
				String orderByType = ParamUtil.getString(renderRequest, "orderByType");

				String portletName = "NSS_THONG_TIN_LIEN_QUAN";
				
				if (Validator.isNotNull(orderByCol) &&
					Validator.isNotNull(orderByType)) {

					preferences.setValue(portletName, "thongTinLienQuan-order-by-col", orderByCol);
					preferences.setValue(portletName, "thongTinLienQuan-order-by-type", orderByType);
				}
				
				else {
					orderByCol = preferences.getValue(portletName, "thongTinLienQuan-order-by-col", "tenThongTinLienQuan");
					orderByType = preferences.getValue(portletName, "thongTinLienQuan-order-by-type", "asc");
				}

				OrderByComparator orderByComparator = ThongTinLienQuanSearchUtil.getThongTinLienQuanOrderByComparator(orderByCol, orderByType);

				setOrderableHeaders(orderableHeaders);
				setOrderByCol(orderByCol);
				setOrderByType(orderByType);
				setOrderByComparator(orderByComparator);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
		
		private static Log _log = LogFactoryUtil.getLog(ThongTinLienQuanSearch.class);
}
