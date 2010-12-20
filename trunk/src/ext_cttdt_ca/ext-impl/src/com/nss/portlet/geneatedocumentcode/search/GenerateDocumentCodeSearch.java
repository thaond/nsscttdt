package com.nss.portlet.geneatedocumentcode.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.nss.portlet.generatetemplateid.model.IdGenerated;

public class GenerateDocumentCodeSearch extends SearchContainer<IdGenerated>{
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static{
		headerNames.add("STT");
		headerNames.add("year");
		headerNames.add("number");
		headerNames.add("temple");
		headerNames.add("edit");
		headerNames.add("delete");
		
		orderableHeaders.put("number", "number");
		orderableHeaders.put("temple", "temple");
		
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public GenerateDocumentCodeSearch(RenderRequest renderRequest, PortletURL iteratorURL) {
		super(renderRequest, new GenerateDocumentCodeDisplayTerms(renderRequest), new GenerateDocumentCodeSearchTerms(renderRequest),
				DEFAULT_CUR_PARAM, DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
	}

}
