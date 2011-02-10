package com.sgs.portlet.career.search;

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
import com.sgs.portlet.career.model.Career;
import com.sgs.portlet.career.util.CareerUtil;

public class CareerSearch extends SearchContainer<Career>{
	static List<String> headernames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static{
		headernames.add("STT");
		headernames.add("code.");
		headernames.add("name.");
		headernames.add("description.");
		headernames.add("active.");
		headernames.add("edit");
		headernames.add("delete");
		
		orderableHeaders.put("code.", "ma");
		orderableHeaders.put("name.", "ten");
		
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public CareerSearch(RenderRequest renderRequest, PortletURL iteratorURL){
		super(renderRequest, new CareerDisplayTerms(renderRequest), new CareerSearchTerms(renderRequest),
				DEFAULT_CUR_PARAM, DEFAULT_DELTA, iteratorURL, headernames, EMPTY_RESULTS_MESSAGE);
		
		CareerDisplayTerms displayTerms = (CareerDisplayTerms) getDisplayTerms();
		
		iteratorURL.setParameter(CareerDisplayTerms.MA, displayTerms.getMa());
		iteratorURL.setParameter(CareerDisplayTerms.TEN, displayTerms.getTen());
		iteratorURL.setParameter(CareerDisplayTerms.MOTA, displayTerms.getMota());
		
		try {
			 PortalPreferences preferences = PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);
			 
			 String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
			 String orderByType = ParamUtil.getString(renderRequest, "orderByType");
			 
			 if(Validator.isNotNull(orderByCol)&& Validator.isNotNull(orderByType)){
				 
				 preferences.setValue("SGS_CAREER", "career-order-by-type",orderByCol);
				 preferences.setValue("SGS_CAREER", "career-order-by-type",orderByType);
			 }else{
				 preferences.setValue("SGS_CAREER", "career-order-by-column", "ma");
				 preferences.setValue("SGS_CAREER", "career-order-by-type", "asc");
			 }
			 OrderByComparator orderByComparator = CareerUtil.getCareerOrderByComparator(orderByCol, orderByType);
				setOrderableHeaders(orderableHeaders);
				setOrderByCol(orderByCol);
				setOrderByType(orderByType);
				setOrderByComparator(orderByComparator);

		} catch (Exception e) {
			_log.error(e);
		}
	}
	
	private Log _log = LogFactoryUtil.getLog(CareerSearch.class);
}
