package com.sgs.portlet.signer.search;

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
import com.liferay.portal.model.User;
import com.liferay.portlet.PortalPreferences;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.sgs.portlet.signer.util.UserUtil;

public class UserSearch extends SearchContainer<User>{
	/**
	 * headernames : so cot hien thi
	 * orderableHeaders: sap xep tang hoac giam theo lastname hoac firstname
	 */
	static List<String> headernames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static{
		headernames.add("ho");
		headernames.add("ten-lot");
		headernames.add("ten");
		headernames.add("chuc-vu");
		
		orderableHeaders.put("ho", "orderLastname");
		orderableHeaders.put("ten", "orderFirstname");
		
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public UserSearch(RenderRequest renderRequest, PortletURL iteratorURL){
		super(renderRequest, new UserDisplayTerms(renderRequest), 
				new UserSearchTerms(renderRequest),
				DEFAULT_CUR_PARAM, DEFAULT_DELTA, iteratorURL, headernames, EMPTY_RESULTS_MESSAGE);
		
		UserDisplayTerms displayTerms = (UserDisplayTerms) getDisplayTerms();
		iteratorURL.setParameter(UserDisplayTerms.LASTNAME, displayTerms.getLastName());
		iteratorURL.setParameter(UserDisplayTerms.FIRSTNAME, displayTerms.getFirstName());
		
		try {
			 PortalPreferences preferences = PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);
			 
			 String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
			 String orderByType = ParamUtil.getString(renderRequest, "orderByType");
			 
			 if(Validator.isNotNull(orderByCol)&& Validator.isNotNull(orderByType)){
				 
				 preferences.setValue("SGS_SIGNER", "signer-order-by-type",orderByCol);
				 preferences.setValue("SGS_SIGNER", "signer-order-by-type",orderByType);
			 }else{
				 preferences.setValue("SGS_SIGNER", "signer-order-by-column", "orderLastname");
				 preferences.setValue("SGS_SIGNER", "signer-order-by-type", "asc");
			 }
			 OrderByComparator orderByComparator = UserUtil.getSignerOrderByComparator(orderByCol, orderByType);
				setOrderableHeaders(orderableHeaders);
				setOrderByCol(orderByCol);
				setOrderByType(orderByType);
				setOrderByComparator(orderByComparator);

		} catch (Exception e) {
			_log.error(e);
		}
	}
	
	private Log _log = LogFactoryUtil.getLog(UserSearch.class);
}
