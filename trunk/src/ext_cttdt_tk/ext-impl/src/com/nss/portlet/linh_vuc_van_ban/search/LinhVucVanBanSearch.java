package com.nss.portlet.linh_vuc_van_ban.search;

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
import com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan;
import com.nss.portlet.linh_vuc_van_ban.util.LinhVucVanBanSearchUtil;

public class LinhVucVanBanSearch extends SearchContainer<LinhVucVanBan> {
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static{
		headerNames.add("STT");
		headerNames.add("ten-linh-vuc-van-ban");
		headerNames.add("mo-ta");
		headerNames.add("active");
		headerNames.add("edit");
		headerNames.add("delete");
		
		orderableHeaders.put("ten-linh-vuc-van-ban", "tenLinhVucVanBan");
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public LinhVucVanBanSearch(RenderRequest renderRequest, PortletURL iteratorURL){
			super(renderRequest, new LinhVucVanBanDisplayTerms(renderRequest), new LinhVucVanBanSearchTerms(renderRequest),
					DEFAULT_CUR_PARAM,DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
			
			LinhVucVanBanDisplayTerms displayTerms = (LinhVucVanBanDisplayTerms)getDisplayTerms();
			
			iteratorURL.setParameter(LinhVucVanBanDisplayTerms.TEN_LINH_VUC_VB, displayTerms.getTenLinhVucVanBan());
			iteratorURL.setParameter(LinhVucVanBanDisplayTerms.MO_TA, displayTerms.getMoTa());
			
			try {
				PortalPreferences preferences =
					PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

				String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
				String orderByType = ParamUtil.getString(renderRequest, "orderByType");

				String portletName = "NSS_LINH_VUC_VAN_BAN";
				
				if (Validator.isNotNull(orderByCol) &&
					Validator.isNotNull(orderByType)) {

					preferences.setValue(portletName, "linhVucVanBan-order-by-col", orderByCol);
					preferences.setValue(portletName, "linhVucVanBan-order-by-type", orderByType);
				}
				
				else {
					orderByCol = preferences.getValue(portletName, "linhVucVanBan-order-by-col", "tenLinhVucVanBan");
					orderByType = preferences.getValue(portletName, "linhVucVanBan-order-by-type", "asc");
				}

				OrderByComparator orderByComparator = LinhVucVanBanSearchUtil.getLinhVucVanBanOrderByComparator(orderByCol, orderByType);

				setOrderableHeaders(orderableHeaders);
				setOrderByCol(orderByCol);
				setOrderByType(orderByType);
				setOrderByComparator(orderByComparator);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
		
		private static Log _log = LogFactoryUtil.getLog(LinhVucVanBanSearch.class);
}
