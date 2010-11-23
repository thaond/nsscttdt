package com.nss.portlet.loai_thu_tuc.search;

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
import com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh;
import com.nss.portlet.loai_thu_tuc.util.LoaiThuTucHanhChinhSearchUtil;

public class LoaiThuTucHanhChinhSearch extends SearchContainer<LoaiThuTucHanhChinh>{
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static{
		headerNames.add("STT");
		headerNames.add("ten-loai-thu-tuc");
		headerNames.add("mo-ta");
		headerNames.add("active");
		headerNames.add("edit");
		headerNames.add("delete");
		
		orderableHeaders.put("ten-loai-thu-tuc", "tenLoaiThuTucHanhChinh");
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public LoaiThuTucHanhChinhSearch(RenderRequest renderRequest, PortletURL iteratorURL){
			super(renderRequest, new LoaiThuTucHanhChinhDisplayTerms(renderRequest), new LoaiThuTucHanhChinhSearchTerms(renderRequest),
					DEFAULT_CUR_PARAM,DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
			
			LoaiThuTucHanhChinhDisplayTerms displayTerms = (LoaiThuTucHanhChinhDisplayTerms)getDisplayTerms();
			
			iteratorURL.setParameter(LoaiThuTucHanhChinhDisplayTerms.TEN_LOAI_THU_TUC, displayTerms.getTenLoaiThuTucHanhChinh());
			iteratorURL.setParameter(LoaiThuTucHanhChinhDisplayTerms.MO_TA, displayTerms.getMoTa());
			
			try {
				PortalPreferences preferences =
					PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

				String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
				String orderByType = ParamUtil.getString(renderRequest, "orderByType");

				String portletName = "NSS_LOAI_THU_TUC";
				
				if (Validator.isNotNull(orderByCol) &&
					Validator.isNotNull(orderByType)) {

					preferences.setValue(portletName, "loaiThuTucHanhChinh-order-by-col", orderByCol);
					preferences.setValue(portletName, "loaiThuTucHanhChinh-order-by-type", orderByType);
				}
				
				else {
					orderByCol = preferences.getValue(portletName, "loaiThuTucHanhChinh-order-by-col", "tenLoaiThuTucHanhChinh");
					orderByType = preferences.getValue(portletName, "loaiThuTucHanhChinh-order-by-type", "asc");
				}

				OrderByComparator orderByComparator = LoaiThuTucHanhChinhSearchUtil.getLoaiThuTucHanhChinhOrderByComparator(orderByCol, orderByType);

				setOrderableHeaders(orderableHeaders);
				setOrderByCol(orderByCol);
				setOrderByType(orderByType);
				setOrderByComparator(orderByComparator);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
		
		private static Log _log = LogFactoryUtil.getLog(LoaiThuTucHanhChinhSearch.class);
}
