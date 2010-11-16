package com.nss.portlet.partner.search;

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
import com.nss.portlet.partner.model.Partner;
import com.nss.portlet.partner.util.PartnerSearchUtil;

public class PartnerSearch extends SearchContainer<Partner> {
	
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	
	static{
		headerNames.add("STT");
		headerNames.add("ten-partner");
		headerNames.add("hinh");
		headerNames.add("mo-ta");
		headerNames.add("thu-tu-partner");
		headerNames.add("target");
		headerNames.add("active");
		headerNames.add("edit");
		headerNames.add("delete");
		
		orderableHeaders.put("ten-partner", "tenPartner");
		orderableHeaders.put("thu-tu-partner", "thuTuPartner");
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public PartnerSearch(RenderRequest renderRequest, PortletURL iteratorURL){
		super(renderRequest, new PartnerDisplayTerms(renderRequest), new PartnerSearchTerms(renderRequest),
				DEFAULT_CUR_PARAM,DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
		
		PartnerDisplayTerms displayTerms = (PartnerDisplayTerms)getDisplayTerms();
		
		iteratorURL.setParameter(PartnerDisplayTerms.TEN_PARTNER, displayTerms.getTenPartner());
		iteratorURL.setParameter(PartnerDisplayTerms.MO_TA_PARTNER, displayTerms.getMoTaPartner());
		
		try {
			PortalPreferences preferences =
				PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

			String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
			String orderByType = ParamUtil.getString(renderRequest, "orderByType");

			String portletName = "NSS_PARTNER";
			
			if (Validator.isNotNull(orderByCol) &&
				Validator.isNotNull(orderByType)) {

				preferences.setValue(portletName, "partner-order-by-col", orderByCol);
				preferences.setValue(portletName, "partner-order-by-type", orderByType);
			}
			
			else {
				orderByCol = preferences.getValue(portletName, "partner-order-by-col", "tenPartner");
				orderByType = preferences.getValue(portletName, "partner-order-by-type", "asc");
			}

			OrderByComparator orderByComparator = PartnerSearchUtil.getPartnerOrderByComparator(orderByCol, orderByType);

			setOrderableHeaders(orderableHeaders);
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}
	
	private static Log _log = LogFactoryUtil.getLog(PartnerSearch.class);
}
