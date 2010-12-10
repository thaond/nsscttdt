package com.nss.portlet.onedoorreport_tinhhinhthulyhosocapso.search;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.nss.portlet.department.model.Department;

public class HoSoCapSoSearch extends SearchContainer<Department>{
	static List<String> headernames = new ArrayList<String>();
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public HoSoCapSoSearch(RenderRequest renderRequest, PortletURL iteratorURL){
		super(renderRequest, new HoSoCapSoDisplayTerms(renderRequest), new HoSoCapSoSearchTerms(renderRequest),
				DEFAULT_CUR_PARAM, DEFAULT_DELTA, iteratorURL, headernames, EMPTY_RESULTS_MESSAGE);
		
	}

}
