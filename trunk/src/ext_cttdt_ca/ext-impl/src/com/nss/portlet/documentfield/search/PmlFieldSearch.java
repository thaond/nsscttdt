/**
 * 
 */
package com.nss.portlet.documentfield.search;

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
import com.nss.portlet.documentfield.model.PmlField;
import com.nss.portlet.documentfield.util.PmlFieldSearchUtil;

public class PmlFieldSearch extends SearchContainer<PmlField> {
	static List<String> headernames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static{
		headernames.add("STT");
		headernames.add("field.code");
		headernames.add("field.name");
		headernames.add("field.department");
		headernames.add("field.desc");		
		headernames.add("edit");
		headernames.add("delete");
		
		orderableHeaders.put("field.code", "field.code");
		orderableHeaders.put("field.name", "field.name");		
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public PmlFieldSearch(RenderRequest renderRequest, PortletURL iteratorURL){
		super(renderRequest, new PmlFieldDisplayTerms(renderRequest), 
				new PmlFieldSearchTerms(renderRequest),
				DEFAULT_CUR_PARAM, DEFAULT_DELTA, iteratorURL, headernames, EMPTY_RESULTS_MESSAGE);
		
		PmlFieldDisplayTerms displayTerms = (PmlFieldDisplayTerms) getDisplayTerms();
		iteratorURL.setParameter(PmlFieldDisplayTerms.MA_PHAN_LOAI, displayTerms.getMaPhanLoai());
		iteratorURL.setParameter(PmlFieldDisplayTerms.TEN_PHAN_LOAI, displayTerms.getTenPhanLoai());
		
		try {
			 PortalPreferences preferences = PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);
			 
			 String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
			 String orderByType = ParamUtil.getString(renderRequest, "orderByType");
			 
			 if(Validator.isNotNull(orderByCol)&& Validator.isNotNull(orderByType)){
				 
				 preferences.setValue("NSS_DOCUMENTFIELD", "pmlfield-order-by-column",orderByCol);
				 preferences.setValue("NSS_DOCUMENTFIELD", "pmlfield-order-by-type",orderByType);
			 }else{
				 preferences.setValue("NSS_DOCUMENTFIELD", "pmlfield-order-by-column", "field.code");
				 preferences.setValue("NSS_DOCUMENTFIELD", "pmlfield-order-by-type", "asc");
			 }
			 
			 OrderByComparator orderByComparator = PmlFieldSearchUtil.getPmlFieldOrderByComparator(orderByCol, orderByType);
				setOrderableHeaders(orderableHeaders);
				setOrderByCol(orderByCol);
				setOrderByType(orderByType);
				setOrderByComparator(orderByComparator);

		} catch (Exception e) {
			_log.error(e);
		}
	}
	
	private final Log _log = LogFactoryUtil.getLog(PmlFieldSearch.class);
}
