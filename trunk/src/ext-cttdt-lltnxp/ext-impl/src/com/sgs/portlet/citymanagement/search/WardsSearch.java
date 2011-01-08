package com.sgs.portlet.citymanagement.search;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.sgs.portlet.wardsmanagement.model.Wards;

public class WardsSearch extends SearchContainer<Wards>{
	static List<String> headernames = new ArrayList<String>();
	static{
		headernames.add("STT");
		headernames.add("wardsmanagement.code");
		headernames.add("wardsmanagement.name");
		headernames.add("description");
		headernames.add("");
		
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public WardsSearch(RenderRequest renderRequest, PortletURL iteratorURL){
		super(renderRequest, new WardsDisplayTerms(renderRequest), new WardsSearchTerms(renderRequest),
				DEFAULT_CUR_PARAM, DEFAULT_DELTA, iteratorURL, headernames, EMPTY_RESULTS_MESSAGE);
	}

}
