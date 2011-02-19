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
import com.sgs.portlet.sovanbannoibo.model.SoVanBanNoiBo;
import com.sgs.portlet.sovanbannoibo.util.SoVanBanNoiBoSearchUtil;

public class SoVanBanNoiBoSearch extends SearchContainer<SoVanBanNoiBo>{
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	
	static{
		headerNames.add("stt");
		headerNames.add("ma-so-van-ban-noi-bo");
		headerNames.add("ten-so-van-ban-noi-bo");
		headerNames.add("config-loai-van-ban-noi-bo");
		headerNames.add("config-phong-ban");
		headerNames.add("edit");
		headerNames.add("delete");
		
		orderableHeaders.put("ma-so-van-ban-noi-bo", "maSoVanBanNoiBo");
		orderableHeaders.put("ten-so-van-ban-noi-bo", "tenSoVanBanNoiBo");
	}

	public static final String EMPTY_RESULTS_MESSAGE = "no-so-van-ban-noi-bo-were-found";
	
	public SoVanBanNoiBoSearch(RenderRequest renderRequest, PortletURL iteratorURL){
			super(renderRequest, new SoVanBanNoiBoDisplayTerms(renderRequest), new SoVanBanNoiBoSearchTerms(renderRequest),
						DEFAULT_CUR_PARAM,DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
			
			SoVanBanNoiBoDisplayTerms displayTerms = (SoVanBanNoiBoDisplayTerms)getDisplayTerms();
			
			iteratorURL.setParameter(SoVanBanNoiBoDisplayTerms.MASOVANBANNOIBO, displayTerms.getMaSoVanBanNoiBo());
			iteratorURL.setParameter(SoVanBanNoiBoDisplayTerms.TENSOVANBANNOIBO, displayTerms.getTenSoVanBanNoiBo());
			
			try {
				PortalPreferences preferences = PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

				String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
				String orderByType = ParamUtil.getString(renderRequest, "orderByType");

				String portletName = "SGS_SOVANBANNOIBO";
				
				if (Validator.isNotNull(orderByCol) && Validator.isNotNull(orderByType)) {
					preferences.setValue(portletName, "so-van-ban-noi-bo-order-by-col", orderByCol);
					preferences.setValue(portletName, "so-van-ban-noi-bo-order-by-type", orderByType);
				} else {
					orderByCol = preferences.getValue(portletName, "so-van-ban-noi-bo-order-by-col", "maSoVanBanNoiBo");
					orderByType = preferences.getValue(portletName, "so-van-ban-noi-bo-order-by-type", "asc");
				}

				OrderByComparator orderByComparator = SoVanBanNoiBoSearchUtil.getSoVanBanNoiBoOrderByComparator(orderByCol, orderByType);

				setOrderableHeaders(orderableHeaders);
				setOrderByCol(orderByCol);
				setOrderByType(orderByType);
				setOrderByComparator(orderByComparator);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
		
		private static Log _log = LogFactoryUtil.getLog(SoVanBanNoiBoSearch.class);
}
