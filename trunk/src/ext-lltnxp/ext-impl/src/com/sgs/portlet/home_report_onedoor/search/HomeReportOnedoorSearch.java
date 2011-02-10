package com.sgs.portlet.home_report_onedoor.search;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.sgs.portlet.pmluser.model.PmlUser;

public class HomeReportOnedoorSearch extends SearchContainer<PmlUser> {
	
	static List<String> headernames = new ArrayList<String>();
	static{
		headernames.add("STT");
		headernames.add("ho-ten");
		headernames.add("ton-truoc");
		headernames.add("hs-chuyen-den");
		headernames.add("hs-da-giai-quyet");
		headernames.add("hs-ton-dong");
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public HomeReportOnedoorSearch(RenderRequest renderRequest, PortletURL iteratorURL) {
		super(renderRequest, new HomeReportOnedoorDisplayTerms(renderRequest), new HomeReportOnedoorSearchTerms(renderRequest),
				DEFAULT_CUR_PARAM, DEFAULT_DELTA, iteratorURL, headernames, EMPTY_RESULTS_MESSAGE);
		
		HomeReportOnedoorDisplayTerms displayTerms = (HomeReportOnedoorDisplayTerms)getDisplayTerms();
		iteratorURL.setParameter(HomeReportOnedoorDisplayTerms.FROMDATE, displayTerms.getFromDate());
		iteratorURL.setParameter(HomeReportOnedoorDisplayTerms.TODATE, displayTerms.getToDate());
	}
}
