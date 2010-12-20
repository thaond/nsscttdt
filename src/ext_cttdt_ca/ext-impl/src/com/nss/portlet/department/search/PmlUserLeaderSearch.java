/**
 * 
 */
package com.nss.portlet.department.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.nss.portlet.department.model.PmlUser;

public class PmlUserLeaderSearch extends SearchContainer<PmlUser>{
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static{
		headerNames.add("STT");
		headerNames.add("name");
		headerNames.add("position_");
		headerNames.add("uu-tien");
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public PmlUserLeaderSearch(RenderRequest renderRequest, PortletURL iteratorURL){
			super(renderRequest, null, null, DEFAULT_CUR_PARAM,DEFAULT_DELTA, 
					iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
	}
			
}

