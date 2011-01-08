package com.sgs.portlet.citymanagement.search;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.sgs.portlet.districtmanagement.model.District;

public class DistrictSearch extends SearchContainer<District>{
	static List<String> headernames = new ArrayList<String>();
	static{
		headernames.add("STT");
		headernames.add("districtmanagement.code");
		headernames.add("districtmanagement.name");
		headernames.add("description");
		headernames.add("");
		
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public DistrictSearch(RenderRequest renderRequest, PortletURL iteratorURL){
		super(renderRequest, new DistrictDisplayTerms(renderRequest), new DistrictSearchTerms(renderRequest),
				DEFAULT_CUR_PARAM, DEFAULT_DELTA, iteratorURL, headernames, EMPTY_RESULTS_MESSAGE);
	}

}
