package com.sgs.portlet.sovanbannoibo.search;

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
import com.sgs.portlet.loaivanbannoibo.model.LoaiVanBanNoiBo;
import com.sgs.portlet.loaivanbannoibo.util.LoaiVanBanNoiBoSearchUtil;

public class LoaiVanBanNoiBoSearch extends SearchContainer<LoaiVanBanNoiBo> {
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	
	static{
		headerNames.add("stt");
		headerNames.add("ky-hieu-loai-van-ban-noi-bo");
		headerNames.add("ten-loai-van-ban-noi-bo");
		
		orderableHeaders.put("ky-hieu-loai-van-ban-noi-bo", "kyHieuLoaiVanBanNoiBo");
		orderableHeaders.put("ten-loai-van-ban-noi-bo", "tenLoaiVanBanNoiBo");
	}

	public static final String EMPTY_RESULTS_MESSAGE = "no-loai-van-ban-noi-bo-were-found";
	
	public LoaiVanBanNoiBoSearch(RenderRequest renderRequest, PortletURL iteratorURL){
			super(renderRequest, new LoaiVanBanNoiBoDisplayTerms(renderRequest), new LoaiVanBanNoiBoSearchTerms(renderRequest),
						DEFAULT_CUR_PARAM,DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
			
			LoaiVanBanNoiBoDisplayTerms displayTerms = (LoaiVanBanNoiBoDisplayTerms)getDisplayTerms();
			
			iteratorURL.setParameter(LoaiVanBanNoiBoDisplayTerms.KYHIEULOAIVANBANNOIBO, displayTerms.getKyHieuLoaiVanBanNoiBo());
			iteratorURL.setParameter(LoaiVanBanNoiBoDisplayTerms.TENLOAIVANBANNOIBO, displayTerms.getTenLoaiVanBanNoiBo());
			
			try {
				PortalPreferences preferences = PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

				String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
				String orderByType = ParamUtil.getString(renderRequest, "orderByType");

				String portletName = "SGS_LOAIVANBANNOIBO";
				
				if (Validator.isNotNull(orderByCol) && Validator.isNotNull(orderByType)) {
					preferences.setValue(portletName, "loai-van-ban-noi-bo-order-by-col", orderByCol);
					preferences.setValue(portletName, "loai-van-ban-noi-bo-order-by-type", orderByType);
				} else {
					orderByCol = preferences.getValue(portletName, "loai-van-ban-noi-bo-order-by-col", "kyHieuLoaiVanBanNoiBo");
					orderByType = preferences.getValue(portletName, "loai-van-ban-noi-bo-order-by-type", "asc");
				}

				OrderByComparator orderByComparator = LoaiVanBanNoiBoSearchUtil.getLoaiVanBanNoiBoOrderByComparator(orderByCol, orderByType);

				setOrderableHeaders(orderableHeaders);
				setOrderByCol(orderByCol);
				setOrderByType(orderByType);
				setOrderByComparator(orderByComparator);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
		
		private static Log _log = LogFactoryUtil.getLog(LoaiVanBanNoiBoSearch.class);
}
