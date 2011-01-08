package com.sgs.portlet.onedoorpcccreport_baocaohosothangluyke.search;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.sgs.portlet.department.model.Department;

public class BaoCaoHoSoLuyKeSearch extends SearchContainer<Department>{
static List<String> headernames = new ArrayList<String>();
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public BaoCaoHoSoLuyKeSearch(RenderRequest renderRequest, PortletURL iteratorURL){
		super(renderRequest, new BaoCaoHoSoLuyKeDisplayTerms(renderRequest), new BaoCaoHoSoLuyKeSearchTerms(renderRequest),
				DEFAULT_CUR_PARAM, DEFAULT_DELTA, iteratorURL, headernames, EMPTY_RESULTS_MESSAGE);
		
		BaoCaoHoSoLuyKeDisplayTerms displayTerms = (BaoCaoHoSoLuyKeDisplayTerms)getDisplayTerms();
		iteratorURL.setParameter(BaoCaoHoSoLuyKeDisplayTerms.TUNGAY, displayTerms.getFromDate());
		iteratorURL.setParameter(BaoCaoHoSoLuyKeDisplayTerms.DENNGAY, displayTerms.getToDate());
	}
}
