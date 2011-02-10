/**
 * 
 */
package com.sgs.portlet.departmentleader.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sgs.portlet.pmluser.model.PmlUser;

/**
 * @author minhnv
 *
 */
public class PmlUserLeaderSearch extends SearchContainer<PmlUser>{
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static{
		headerNames.add("pccc-TN-stt");
		headerNames.add("name");
		headerNames.add("receipt.position");
		headerNames.add("receipt.uutien");
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public PmlUserLeaderSearch(RenderRequest renderRequest, PortletURL iteratorURL){
			super(renderRequest, null, null, DEFAULT_CUR_PARAM,DEFAULT_DELTA, 
					iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
	}
			
		private static Log _log = LogFactoryUtil.getLog(PmlUserLeaderSearch.class);
}

