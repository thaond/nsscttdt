package com.sgs.portlet.vanbannoibo.search;

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
import com.sgs.portlet.vanbannoibo.model.VanBanNoiBo;

public class TiepNhanVanBanSearch extends SearchContainer<VanBanNoiBo>{
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	
	static{
		headerNames.add("stt");
		headerNames.add("holiday-calendar-code");
		headerNames.add("holiday-calendar-date-create");
		headerNames.add("holiday-calendar-title");
		headerNames.add("download");
		headerNames.add("edit");
		headerNames.add("delete");
		
		orderableHeaders.put("holiday-calendar-code", "holidayCalendarCode");
		orderableHeaders.put("holiday-calendar-date-create", "holidayCalendarDateCreate");
		orderableHeaders.put("holiday-calendar-title", "holidayCalendarTitle");
	}

	public static final String EMPTY_RESULTS_MESSAGE = "no-van-were-found";
	
	public TiepNhanVanBanSearch(RenderRequest renderRequest, PortletURL iteratorURL){
		super(renderRequest, new TiepNhanVanBanDisplayTerms(renderRequest), new TiepNhanVanBanSearchTerms(renderRequest),
					DEFAULT_CUR_PARAM,DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
		
		TiepNhanVanBanDisplayTerms displayTerms = (TiepNhanVanBanDisplayTerms)getDisplayTerms();
		
		iteratorURL.setParameter(TiepNhanVanBanDisplayTerms.LOAIVANBANNOIBO, String.valueOf(displayTerms.getLoaiVanBanNoiBo()));
		iteratorURL.setParameter(TiepNhanVanBanDisplayTerms.NGAYTAO, displayTerms.getNgayTao());
		iteratorURL.setParameter(TiepNhanVanBanDisplayTerms.NGAYKY, displayTerms.getNgayKy());
		iteratorURL.setParameter(TiepNhanVanBanDisplayTerms.TRICHYEU, displayTerms.getTrichYeu());
		iteratorURL.setParameter(TiepNhanVanBanDisplayTerms.NGUOIKY, String.valueOf(displayTerms.getNguoiKy()));
		iteratorURL.setParameter(TiepNhanVanBanDisplayTerms.GHICHU, displayTerms.getGhiChu());
		iteratorURL.setParameter(TiepNhanVanBanDisplayTerms.SOVANBANNOIBO, displayTerms.getSoVanBanNoiBo());
		iteratorURL.setParameter(TiepNhanVanBanDisplayTerms.SOPHATSINHTHEONAM, displayTerms.getSoPhatSinhTheoNam());
		
		try {
			PortalPreferences preferences = PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

			String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
			String orderByType = ParamUtil.getString(renderRequest, "orderByType");

			String portletName = "SGS_VANBANNOIBO";
			
			if (Validator.isNotNull(orderByCol) && Validator.isNotNull(orderByType)) {
				preferences.setValue(portletName, "tiep-nhan-van-ban-order-by-col", orderByCol);
				preferences.setValue(portletName, "tiep-nhan-van-ban-order-by-type", orderByType);
			} else {
				orderByCol = preferences.getValue(portletName, "tiep-nhan-van-ban-order-by-col", "holidayCalendarCode");
				orderByType = preferences.getValue(portletName, "tiep-nhan-van-ban-order-by-type", "asc");
			}

			OrderByComparator orderByComparator = VanBanNoiBoSearchUtil.getHolidayCalendarOrderByComparator(orderByCol, orderByType);

			setOrderableHeaders(orderableHeaders);
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}
	
	private static Log _log = LogFactoryUtil.getLog(TiepNhanVanBanSearch.class);
}
