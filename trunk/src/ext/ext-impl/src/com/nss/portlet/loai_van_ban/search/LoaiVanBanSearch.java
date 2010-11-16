package com.nss.portlet.loai_van_ban.search;

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
import com.nss.portlet.loai_van_ban.model.LoaiVanBan;
import com.nss.portlet.loai_van_ban.util.LoaiVanBanSearchUtil;

public class LoaiVanBanSearch extends SearchContainer<LoaiVanBan>{
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static{
		headerNames.add("STT");
		headerNames.add("ten-loai-van-ban");
		headerNames.add("mo-ta");
		headerNames.add("active");
		headerNames.add("edit");
		headerNames.add("delete");
		
		orderableHeaders.put("ten-loai-van-ban", "tenLoaiVanBan");
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public LoaiVanBanSearch(RenderRequest renderRequest, PortletURL iteratorURL){
			super(renderRequest, new LoaiVanBanDisplayTerms(renderRequest), new LoaiVanBanSearchTerms(renderRequest),
					DEFAULT_CUR_PARAM,DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
			
			LoaiVanBanDisplayTerms displayTerms = (LoaiVanBanDisplayTerms)getDisplayTerms();
			
			iteratorURL.setParameter(LoaiVanBanDisplayTerms.TEN_LOAI_VB, displayTerms.getTenLoaiVanBan());
			iteratorURL.setParameter(LoaiVanBanDisplayTerms.MO_TA, displayTerms.getMoTa());
			
			try {
				PortalPreferences preferences =
					PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

				String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
				String orderByType = ParamUtil.getString(renderRequest, "orderByType");

				String portletName = "NSS_LOAI_VAN_BAN";
				
				if (Validator.isNotNull(orderByCol) &&
					Validator.isNotNull(orderByType)) {

					preferences.setValue(portletName, "loaiVanBan-order-by-col", orderByCol);
					preferences.setValue(portletName, "loaiVanBan-order-by-type", orderByType);
				}
				
				else {
					orderByCol = preferences.getValue(portletName, "loaiVanBan-order-by-col", "tenLoaiVanBan");
					orderByType = preferences.getValue(portletName, "loaiVanBan-order-by-type", "asc");
				}

				OrderByComparator orderByComparator = LoaiVanBanSearchUtil.getLoaiVanBanOrderByComparator(orderByCol, orderByType);

				setOrderableHeaders(orderableHeaders);
				setOrderByCol(orderByCol);
				setOrderByType(orderByType);
				setOrderByComparator(orderByComparator);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
		
		private static Log _log = LogFactoryUtil.getLog(LoaiVanBanSearch.class);
}
