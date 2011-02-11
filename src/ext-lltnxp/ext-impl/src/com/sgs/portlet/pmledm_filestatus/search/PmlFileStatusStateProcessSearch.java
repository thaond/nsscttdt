package com.sgs.portlet.pmledm_filestatus.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess;

public class PmlFileStatusStateProcessSearch extends SearchContainer<PmlFileStatusStateProcess> {
	
	static List<String> headernames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static{
		headernames.add("STT");
		headernames.add("pml_edm_file_status_code");
		headernames.add("pml_edm_file_state_code");
		headernames.add("pml_edm_file_state_name");
		headernames.add("edit");
		headernames.add("delete");
		
		orderableHeaders.put("pml_edm_file_state_code", "pml_edm_file_state_code");
		orderableHeaders.put("pml_edm_file_status_name", "pml_edm_file_state_name");
		
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public PmlFileStatusStateProcessSearch(RenderRequest renderRequest, PortletURL iteratorURL){
		super(renderRequest, new PmlFileStatusStateProcessDisplayTerms(renderRequest), new PmlFileStatusStateProcessSearchTerms(renderRequest),
				DEFAULT_CUR_PARAM, DEFAULT_DELTA, iteratorURL, headernames, EMPTY_RESULTS_MESSAGE);
		
	}
	
	private Log _log = LogFactoryUtil.getLog(PmlFileStatusStateProcessSearch.class);
}
