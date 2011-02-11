/**
 * 
 */
package com.sgs.portlet.workflow_admin.search;

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
import com.sgs.portlet.onedoor.model.PmlWorkflow;
import com.sgs.portlet.workflow_admin.util.OneDoorWorkflowUtil;

/**
 * @author canhminh
 *
 */
public class OneDoorWorkflowSearch extends SearchContainer<PmlWorkflow> {
	
	static List<String> headernames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static{
		headernames.add("STT");
		headernames.add("sgs_filetype_filetypeName");
		headernames.add("sgs_onedoor_workflowadmin_workflow");
		headernames.add("sgs_onedoor_workflowadmin_version");
		headernames.add("sgs_startDate");
		headernames.add("sgs_endDate");
		headernames.add("sgs_field_delete");
		
		orderableHeaders.put("sgs_filetype_filetypeName", "sgs_filetype_filetypeName");
		
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public OneDoorWorkflowSearch(RenderRequest renderRequest, PortletURL iteratorURL){
		super(renderRequest, new OneDoorWorkflowDisplayTerms(renderRequest), 
				new OneDoorWorkflowSearchTems(renderRequest),
				DEFAULT_CUR_PARAM, DEFAULT_DELTA, iteratorURL, headernames, EMPTY_RESULTS_MESSAGE);
		
		OneDoorWorkflowDisplayTerms displayTerms = (OneDoorWorkflowDisplayTerms) getDisplayTerms();
		iteratorURL.setParameter(OneDoorWorkflowDisplayTerms.FILETYPENAME, displayTerms.getFileTypeName());
		iteratorURL.setParameter(OneDoorWorkflowDisplayTerms.WORKFLOWNAME, displayTerms.getWorkflowName());
		
		try {
			 PortalPreferences preferences = PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);
			 
			 String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
			 String orderByType = ParamUtil.getString(renderRequest, "orderByType");
			 
			 if(Validator.isNotNull(orderByCol)&& Validator.isNotNull(orderByType)){
				 
				 preferences.setValue("SGS_WORKFLOW_ADMIN", "onedoorworkflow-order-by-column",orderByCol);
				 preferences.setValue("SGS_WORKFLOW_ADMIN", "onedoorworkflow-order-by-type",orderByType);
			 }else{
				 preferences.setValue("SGS_WORKFLOW_ADMIN", "onedoorworkflow-order-by-column", "sgs_filetype_filetypeName");
				 preferences.setValue("SGS_WORKFLOW_ADMIN", "onedoorworkflow-order-by-type", "asc");
			 }
			 
			 OrderByComparator orderByComparator = OneDoorWorkflowUtil.getOneDoorWorkflowOrderByComparator(orderByCol, orderByType);
				setOrderableHeaders(orderableHeaders);
				setOrderByCol(orderByCol);
				setOrderByType(orderByType);
				setOrderByComparator(orderByComparator);

		} catch (Exception e) {
			_log.error(e);
		}
	}
	
	private final Log _log = LogFactoryUtil.getLog(OneDoorWorkflowSearch.class);
}
