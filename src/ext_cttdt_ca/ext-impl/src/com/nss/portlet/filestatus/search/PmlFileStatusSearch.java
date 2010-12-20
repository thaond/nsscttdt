package com.nss.portlet.filestatus.search;

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
import com.nss.portlet.filestatus.util.PmlFileStatusUtil;
import com.nss.portlet.onedoor.model.PmlFileStatus;
/*
 * @author Yen
 */
public class PmlFileStatusSearch extends SearchContainer<PmlFileStatus> {
	
	static List<String> headernames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static{
		headernames.add("STT");
		headernames.add("pml_edm_file_status_code");
		headernames.add("pml_edm_file_status_name");
		headernames.add("pml_edm_file_status_description");
		headernames.add("document_action");
		headernames.add("edit");
		headernames.add("delete");
		
		orderableHeaders.put("pml_edm_file_status_code", "orderFilestatuscode");
		orderableHeaders.put("pml_edm_file_status_name", "orderFilestatusname");
		
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public PmlFileStatusSearch(RenderRequest renderRequest, PortletURL iteratorURL){
		super(renderRequest, new PmlFileStatusDisplayTerms(renderRequest), new PmlFileStatusSearchTerms(renderRequest),
				DEFAULT_CUR_PARAM, DEFAULT_DELTA, iteratorURL, headernames, EMPTY_RESULTS_MESSAGE);
		
		PmlFileStatusDisplayTerms displayTerms = (PmlFileStatusDisplayTerms) getDisplayTerms();
		iteratorURL.setParameter(PmlFileStatusDisplayTerms.FILESTATUS_CODE, displayTerms.getFilestatuscode());
		iteratorURL.setParameter(PmlFileStatusDisplayTerms.FILESTATUS_NAME, displayTerms.getFilestatusname());
		
		try {
			 PortalPreferences preferences = PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);
			 
			 String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
			 String orderByType = ParamUtil.getString(renderRequest, "orderByType");
			 
			 if(Validator.isNotNull(orderByCol)&& Validator.isNotNull(orderByType)){
				 
				 preferences.setValue("NSS_PMLEDM_FILESTATUS", "pmlFilestatus-order-by-type",orderByCol);
				 preferences.setValue("NSS_PMLEDM_FILESTATUS", "pmlFilestatus-order-by-type",orderByType);
			 }else{
				 preferences.setValue("NSS_PMLEDM_FILESTATUS", "pmlFilestatus-order-by-column", "orderFilestatuscode");
				 preferences.setValue("NSS_PMLEDM_FILESTATUS", "pmlFilestatus-order-by-type", "asc");
			 }
			 OrderByComparator orderByComparator = PmlFileStatusUtil.getPmlFileStatusOrderByComparator(orderByCol, orderByType);
				setOrderableHeaders(orderableHeaders);
				setOrderByCol(orderByCol);
				setOrderByType(orderByType);
				setOrderByComparator(orderByComparator);

		} catch (Exception e) {
			_log.error(e);
		}
	}
	
	private Log _log = LogFactoryUtil.getLog(PmlFileStatusSearch.class);
}
