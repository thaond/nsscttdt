package com.sgs.portlet.issuingplace.search;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend;

public class LevelSendSearch extends SearchContainer<PmlEdmLevelSend>{
	static List<String> headerNames = new ArrayList<String>();
	static{
		headerNames.add("STT");
		headerNames.add("document.level");
		
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public LevelSendSearch(RenderRequest renderRequest, PortletURL iteratorURL) {
		super(renderRequest, new LevelSendDisplayTerms(renderRequest), new LevelSendSearchTerms(renderRequest),
				DEFAULT_CUR_PARAM,DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
	}
}
