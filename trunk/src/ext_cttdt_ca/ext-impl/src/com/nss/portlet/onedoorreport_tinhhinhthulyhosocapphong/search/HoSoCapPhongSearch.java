package com.nss.portlet.onedoorreport_tinhhinhthulyhosocapphong.search;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.nss.portlet.department.model.PmlUser;

public class HoSoCapPhongSearch extends SearchContainer<PmlUser>{
	static List<String> headernames = new ArrayList<String>();
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public HoSoCapPhongSearch(RenderRequest renderRequest, PortletURL iteratorURL){
		super(renderRequest, new HoSoCapPhongDisplayTerms(renderRequest), new HoSoCapPhongSearchTerms(renderRequest),
				DEFAULT_CUR_PARAM, DEFAULT_DELTA, iteratorURL, headernames, EMPTY_RESULTS_MESSAGE);
		
	}
}
