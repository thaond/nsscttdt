package com.nss.portlet.van_ban_phap_quy_display.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.PortalPreferences;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy;
import com.nss.portlet.van_ban_phap_quy_display.util.VanBanPhapQuySearchUtil;

public class VanBanPhapQuySearch extends SearchContainer<VanBanPhapQuy>{
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static{
		headerNames.add("stt");
		headerNames.add("ky-hieu-van-ban");
		headerNames.add("ngay-ban-hanh");
		headerNames.add("tom-tat");
		headerNames.add("download");
		
		orderableHeaders.put("ky-hieu-van-ban", "kyHieuVanBan");
		orderableHeaders.put("ngay-ban-hanh", "ngayBanHanh");
	}	

	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";

	public VanBanPhapQuySearch(PortletRequest portletRequest, PortletURL iteratorURL) {
		super(
			portletRequest, new VanBanPhapQuyDisplayTerms(portletRequest),
			new VanBanPhapQuySearchTerms(portletRequest), DEFAULT_CUR_PARAM,
			DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);

		VanBanPhapQuyDisplayTerms displayTerms = (VanBanPhapQuyDisplayTerms)getDisplayTerms();

		iteratorURL.setParameter(VanBanPhapQuyDisplayTerms.KY_HIEU_VAN_BAN, displayTerms.getKyHieuVanBan());
		iteratorURL.setParameter(VanBanPhapQuyDisplayTerms.TOM_TAT, displayTerms.getTomTat());
		iteratorURL.setParameter(VanBanPhapQuyDisplayTerms.NGUOI_KY, displayTerms.getNguoiKy());
		
		iteratorURL.setParameter(VanBanPhapQuyDisplayTerms.LOAI_VAN_BAN, displayTerms.getLoaiVanBan());
		iteratorURL.setParameter(VanBanPhapQuyDisplayTerms.LINH_VUC_VAN_BAN, displayTerms.getLinhVucVanBan());
		iteratorURL.setParameter(VanBanPhapQuyDisplayTerms.CO_QUAN_BAN_HANH, displayTerms.getCoQuanBanHanh());
		
		iteratorURL.setParameter(VanBanPhapQuyDisplayTerms.MA_LOAI_VAN_BAN, String.valueOf(displayTerms.getMaLoaiVanBan()));
		iteratorURL.setParameter(VanBanPhapQuyDisplayTerms.MA_LINH_VUC_VAN_BAN, String.valueOf(displayTerms.getMaLinhVucVanBan()));
		iteratorURL.setParameter(VanBanPhapQuyDisplayTerms.MA_CO_QUAN_BAN_HANH, String.valueOf(displayTerms.getMaCoQuanBanHanh()));
		
		iteratorURL.setParameter(VanBanPhapQuyDisplayTerms.TU_NGAY, displayTerms.getTuNgay());
		iteratorURL.setParameter(VanBanPhapQuyDisplayTerms.DEN_NGAY, displayTerms.getDenNgay());

		try {
			PortalPreferences preferences =
				PortletPreferencesFactoryUtil.getPortalPreferences(
					portletRequest);

			String orderByCol = ParamUtil.getString(
				portletRequest, "orderByCol");
			String orderByType = ParamUtil.getString(
				portletRequest, "orderByType");

			String portletName = "NSS_VAN_BAN_PHAP_QUY_DISPLAY";
			
			if (Validator.isNotNull(orderByCol) &&
				Validator.isNotNull(orderByType)) {

				preferences.setValue(
						portletName, "vanbanphapquydisplay-order-by-col",
					orderByCol);
				preferences.setValue(
						portletName, "vanbanphapquydisplay-order-by-type",
					orderByType);
			}
			else {
				orderByCol = preferences.getValue(
						portletName, "vanbanphapquydisplay-order-by-col", "ngayBanHanh");
				orderByType = preferences.getValue(
						portletName, "vanbanphapquydisplay-order-by-type", "asc");
			}

			OrderByComparator orderByComparator = 
				VanBanPhapQuySearchUtil.getVanBanPhapQuyOrderByComparator(
					orderByCol, orderByType);

			setOrderableHeaders(orderableHeaders);
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(VanBanPhapQuySearch.class);
}
