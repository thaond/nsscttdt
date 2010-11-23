package com.nss.portlet.linh_vuc_thu_tuc.search;

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
import com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh;
import com.nss.portlet.linh_vuc_thu_tuc.util.LinhVucThuTucHanhChinhSearchUtil;

public class LinhVucThuTucHanhChinhSearch extends SearchContainer<LinhVucThuTucHanhChinh>{
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	
	static{
		headerNames.add("STT");
		headerNames.add("ten-linh-vuc-thu-tuc-hanh-chinh");
		headerNames.add("ten-loai-thu-tuc");
		headerNames.add("mo-ta");
		headerNames.add("active");
		headerNames.add("edit");
		headerNames.add("delete");
		
		orderableHeaders.put("ten-linh-vuc-thu-tuc-hanh-chinh", "tenLinhVucThuTucHanhChinh");
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public LinhVucThuTucHanhChinhSearch(RenderRequest renderRequest, PortletURL iteratorURL){
			super(renderRequest, new LinhVucThuTucHanhChinhDisplayTerms(renderRequest), new LinhVucThuTucHanhChinhSearchTerms(renderRequest),
					DEFAULT_CUR_PARAM,DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
			
			LinhVucThuTucHanhChinhDisplayTerms displayTerms = (LinhVucThuTucHanhChinhDisplayTerms)getDisplayTerms();
			
			iteratorURL.setParameter(LinhVucThuTucHanhChinhDisplayTerms.TEN_LINH_VUC_THU_TUC, displayTerms.getTenLinhVucThuTuc());
			iteratorURL.setParameter(LinhVucThuTucHanhChinhDisplayTerms.MO_TA, displayTerms.getMoTa());
			
			try {
				PortalPreferences preferences = PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

				String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
				String orderByType = ParamUtil.getString(renderRequest, "orderByType");

				String portletName = "NSS_LINH_VUC_THU_TUC_HANH_CHINH";
				
				if (Validator.isNotNull(orderByCol) &&
					Validator.isNotNull(orderByType)) {

					preferences.setValue(portletName, "linhVucHanhChinhThuTuc-order-by-col", orderByCol);
					preferences.setValue(portletName, "linhVucHanhChinhThuTuc-order-by-type", orderByType);
				}
				
				else {
					orderByCol = preferences.getValue(portletName, "linhVucHanhChinhThuTuc-order-by-col", "tenLinhVucThuTucHanhChinh");
					orderByType = preferences.getValue(portletName, "linhVucHanhChinhThuTuc-order-by-type", "asc");
				}

				OrderByComparator orderByComparator = LinhVucThuTucHanhChinhSearchUtil.getLinhVucThuTucHanhChinhOrderByComparator(orderByCol, orderByType);

				setOrderableHeaders(orderableHeaders);
				setOrderByCol(orderByCol);
				setOrderByType(orderByType);
				setOrderByComparator(orderByComparator);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
		
		private static Log _log = LogFactoryUtil.getLog(LinhVucThuTucHanhChinhSearch.class);
}
