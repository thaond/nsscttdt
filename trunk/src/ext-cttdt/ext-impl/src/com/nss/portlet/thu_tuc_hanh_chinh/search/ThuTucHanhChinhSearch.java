package com.nss.portlet.thu_tuc_hanh_chinh.search;

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
import com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh;
import com.nss.portlet.thu_tuc_hanh_chinh.util.ThuTucHanhChinhSearchUtil;

public class ThuTucHanhChinhSearch extends SearchContainer<ThuTucHanhChinh>{
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static{
		headerNames.add("STT");
		headerNames.add("ten-thu-tuc-hanh-chinh");
		headerNames.add("co-quan-thuc-hien");
		headerNames.add("download");
		headerNames.add("active");
		headerNames.add("edit");
		headerNames.add("delete");
		
		orderableHeaders.put("ten-thu-tuc-hanh-chinh", "tenThuTucHanhChinh");
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public ThuTucHanhChinhSearch(RenderRequest renderRequest, PortletURL iteratorURL){
			super(renderRequest, new ThuTucHanhChinhDisplayTerms(renderRequest), new ThuTucHanhChinhSearchTerms(renderRequest),
					DEFAULT_CUR_PARAM,DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
			
			ThuTucHanhChinhDisplayTerms displayTerms = (ThuTucHanhChinhDisplayTerms)getDisplayTerms();
			
			iteratorURL.setParameter(ThuTucHanhChinhDisplayTerms.TEN_THU_TUC_HANH_CHINH, displayTerms.getTenThuTucHanhChinh());
			iteratorURL.setParameter(ThuTucHanhChinhDisplayTerms.LINH_VUC_THU_TUC, String.valueOf(displayTerms.getLinhVucThuTuc()));
			iteratorURL.setParameter(ThuTucHanhChinhDisplayTerms.CAP_DON_VI_THU_TUC, String.valueOf(displayTerms.getCapDonViThuTuc()));
			iteratorURL.setParameter(ThuTucHanhChinhDisplayTerms.DON_VI_THU_TUC, String.valueOf(displayTerms.getDonViThuTuc()));
			
			try {
				PortalPreferences preferences =
					PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

				String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
				String orderByType = ParamUtil.getString(renderRequest, "orderByType");

				String portletName = "NSS_THU_TUC_HANH_CHINH";
				
				if (Validator.isNotNull(orderByCol) &&
					Validator.isNotNull(orderByType)) {

					preferences.setValue(portletName, "thuTucHanhChinh-order-by-col", orderByCol);
					preferences.setValue(portletName, "thuTucHanhChinh-order-by-type", orderByType);
				}
				
				else {
					orderByCol = preferences.getValue(portletName, "thuTucHanhChinh-order-by-col", "tenThuTucHanhChinh");
					orderByType = preferences.getValue(portletName, "thuTucHanhChinh-order-by-type", "asc");
				}

				OrderByComparator orderByComparator = ThuTucHanhChinhSearchUtil.getThuTucHanhChinhOrderByComparator(orderByCol, orderByType);

				setOrderableHeaders(orderableHeaders);
				setOrderByCol(orderByCol);
				setOrderByType(orderByType);
				setOrderByComparator(orderByComparator);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
		
		private static Log _log = LogFactoryUtil.getLog(ThuTucHanhChinhSearch.class);
}
