package com.sgs.portlet.documentprocessmanagement.search;

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
import com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow;
import com.sgs.portlet.documentprocessmanagement.util.DocumentWorkflowUtil;

public class DocumentWorkflowSearch extends SearchContainer<PmlManageWorkDocumentFlow> {
	static List<String> headernames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static{
		headernames.add("STT");
		headernames.add("sgs_onedoor_workflowadmin_workflow");
		headernames.add("loai-quy-trinh");
		headernames.add("sgs_onedoor_workflowadmin_version");
		headernames.add("description");
		headernames.add("sgs_startDate");
		headernames.add("sgs_endDate");
		headernames.add("sgs_field_delete");
		
		orderableHeaders.put("sgs_onedoor_workflowadmin_workflow", "sgs_onedoor_workflowadmin_workflow");
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public DocumentWorkflowSearch(RenderRequest renderRequest, PortletURL iteratorURL){
		super(renderRequest, new DocumentWorkflowDisplayTerms(renderRequest), 
				new DocumentWorkflowSearchTerms(renderRequest),
				DEFAULT_CUR_PARAM, DEFAULT_DELTA, iteratorURL, headernames, EMPTY_RESULTS_MESSAGE);
		
		DocumentWorkflowDisplayTerms displayTerms = (DocumentWorkflowDisplayTerms) getDisplayTerms();
		iteratorURL.setParameter(DocumentWorkflowDisplayTerms.DOCUMENTWORKFLOWNAME, displayTerms.getDocumentWorkflowName());
		iteratorURL.setParameter(DocumentWorkflowDisplayTerms.DESCRIPTION, displayTerms.getDescription());
		
		try {
			 PortalPreferences preferences = PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);
			 
			 String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
			 String orderByType = ParamUtil.getString(renderRequest, "orderByType");
			 
			 if(Validator.isNotNull(orderByCol)&& Validator.isNotNull(orderByType)){
				 
				 preferences.setValue("SGS_DOCUMENTPROCESSMANAGEMENT", "documentworkflow-order-by-column",orderByCol);
				 preferences.setValue("SGS_DOCUMENTPROCESSMANAGEMENT", "documentworkflow-order-by-type",orderByType);
			 }else{
				 preferences.setValue("SGS_DOCUMENTPROCESSMANAGEMENT", "documentworkflow-order-by-column", "sgs_onedoor_workflowadmin_workflow");
				 preferences.setValue("SGS_DOCUMENTPROCESSMANAGEMENT", "documentworkflow-order-by-type", "asc");
			 }
			 
			 OrderByComparator orderByComparator = DocumentWorkflowUtil.getDocumentWorkflowOrderByComparator(orderByCol, orderByType);
				setOrderableHeaders(orderableHeaders);
				setOrderByCol(orderByCol);
				setOrderByType(orderByType);
				setOrderByComparator(orderByComparator);

		} catch (Exception e) {
			_log.error(e);
		}
	}
	
	private final Log _log = LogFactoryUtil.getLog(DocumentWorkflowSearch.class);
}
