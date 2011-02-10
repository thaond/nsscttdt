package com.sgs.portlet.delegate.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate;

public class PmlDelegateSearch extends SearchContainer<PmlDelegate>{
	
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static{
		headerNames.add("STT");
		headerNames.add("delegate-nguoiuyquyen");
		headerNames.add("delegate-nguoiduocuyquyen");
		headerNames.add("delegate-loaihoso");
		headerNames.add("delegate-ngaybatdauuyquyen");
		headerNames.add("delegate-ngayketthucuyquyen");
		headerNames.add("delegate-ngayhuyuyquyen");
		headerNames.add("delete-huyuyquyen");
		
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public PmlDelegateSearch(RenderRequest renderRequest, PortletURL iteratorURL) {
		super(renderRequest, new PmlDelegateDisplayTerms(renderRequest), new PmlDelegateSearchTerms(renderRequest),
				DEFAULT_CUR_PARAM,DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
	}

}
