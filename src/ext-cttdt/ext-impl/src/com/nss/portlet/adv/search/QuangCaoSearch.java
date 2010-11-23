package com.nss.portlet.adv.search;

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
import com.nss.portlet.adv.model.QuangCao;
import com.nss.portlet.adv.util.QuangCaoSearchUtil;

public class QuangCaoSearch extends SearchContainer<QuangCao>{
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static{
		headerNames.add("STT");
		headerNames.add("ten-quang-cao");
		headerNames.add("hinh");
		headerNames.add("mo-ta");
		headerNames.add("thu-tu-website");
		headerNames.add("target");
		headerNames.add("active");
		headerNames.add("edit");
		headerNames.add("delete");
		
		orderableHeaders.put("ten-quang-cao", "tenQuangCao");
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public QuangCaoSearch(RenderRequest renderRequest, PortletURL iteratorURL){
			super(renderRequest, new QuangCaoDisplayTerms(renderRequest), new QuangCaoSearchTerms(renderRequest),
					DEFAULT_CUR_PARAM,DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
			
			QuangCaoDisplayTerms displayTerms = (QuangCaoDisplayTerms)getDisplayTerms();
			
			iteratorURL.setParameter(QuangCaoDisplayTerms.TEN_QUANG_CAO, displayTerms.getTenQuangCao());
			iteratorURL.setParameter(QuangCaoDisplayTerms.MO_TA, displayTerms.getMoTa());
			
			try {
				PortalPreferences preferences =
					PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

				String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
				String orderByType = ParamUtil.getString(renderRequest, "orderByType");

				String portletName = "NSS_ADV";
				
				if (Validator.isNotNull(orderByCol) &&
					Validator.isNotNull(orderByType)) {

					preferences.setValue(portletName, "quangCao-order-by-col", orderByCol);
					preferences.setValue(portletName, "quangCao-order-by-type", orderByType);
				}
				
				else {
					orderByCol = preferences.getValue(portletName, "quangCao-order-by-col", "tenQuangCao");
					orderByType = preferences.getValue(portletName, "quangCao-order-by-type", "asc");
				}

				OrderByComparator orderByComparator = QuangCaoSearchUtil.getQuangCaoOrderByComparator(orderByCol, orderByType);

				setOrderableHeaders(orderableHeaders);
				setOrderByCol(orderByCol);
				setOrderByType(orderByType);
				setOrderByComparator(orderByComparator);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
		
		private static Log _log = LogFactoryUtil.getLog(QuangCaoSearch.class);
}
