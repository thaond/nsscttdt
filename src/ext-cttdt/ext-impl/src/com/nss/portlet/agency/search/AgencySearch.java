package com.nss.portlet.agency.search;

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
import com.nss.portlet.agency.model.Agency;
import com.nss.portlet.agency.util.AgencyUtil;

public class AgencySearch extends SearchContainer<Agency>{
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static{
		headerNames.add("STT");
		headerNames.add("ten-nguoi-lanh-dao");
		headerNames.add("agency.code");
		headerNames.add("ten-co-quan");
		headerNames.add("description");
		headerNames.add("agency.active");
		headerNames.add("edit");
		headerNames.add("delete");
		
		orderableHeaders.put("ten-nguoi-lanh-dao", "tenLanhDao");
		orderableHeaders.put("agency.code", "ma");
		orderableHeaders.put("ten-co-quan", "tenCoQuan");
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public AgencySearch(RenderRequest renderRequest, PortletURL iteratorURL){
			super(renderRequest, new AgencyDisplayTerms(renderRequest), new AgencySearchTerms(renderRequest),
					DEFAULT_CUR_PARAM,DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
			
			AgencyDisplayTerms displayTerms = (AgencyDisplayTerms)getDisplayTerms();
			
			iteratorURL.setParameter(AgencyDisplayTerms.MA, displayTerms.getMa());
			iteratorURL.setParameter(AgencyDisplayTerms.HO, displayTerms.getHo());
			iteratorURL.setParameter(AgencyDisplayTerms.TEN, displayTerms.getTen());
			iteratorURL.setParameter(AgencyDisplayTerms.TENCOQUAN, displayTerms.getTenCoQuan());
			
			try {
				PortalPreferences preferences =
					PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

				String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
				String orderByType = ParamUtil.getString(renderRequest, "orderByType");

				String portletName = "NSS_AGENCY";
				
				if (Validator.isNotNull(orderByCol) &&
					Validator.isNotNull(orderByType)) {

					preferences.setValue(portletName, "agency-order-by-col", orderByCol);
					preferences.setValue(portletName, "agency-order-by-type", orderByType);
				}
				
				else {
					orderByCol = preferences.getValue(portletName, "agency-order-by-col", "tenLanhDao");
					orderByType = preferences.getValue(portletName, "agency-order-by-type", "asc");
				}

				OrderByComparator orderByComparator = AgencyUtil.getAgencyOrderByComparator(orderByCol, orderByType);

				setOrderableHeaders(orderableHeaders);
				setOrderByCol(orderByCol);
				setOrderByType(orderByType);
				setOrderByComparator(orderByComparator);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
		
		private static Log _log = LogFactoryUtil.getLog(AgencySearch.class);
}
