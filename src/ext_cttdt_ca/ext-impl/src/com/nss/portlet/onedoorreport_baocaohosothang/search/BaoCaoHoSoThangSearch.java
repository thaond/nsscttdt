package com.nss.portlet.onedoorreport_baocaohosothang.search;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.nss.portlet.filetype.model.PmlFileType;

public class BaoCaoHoSoThangSearch extends SearchContainer<PmlFileType>{
static List<String> headernames = new ArrayList<String>();
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public BaoCaoHoSoThangSearch(RenderRequest renderRequest, PortletURL iteratorURL){
		super(renderRequest, new BaoCaoHoSoThangDisplayTerms(renderRequest), new BaoCaoHoSoThangSearchTerms(renderRequest),
				DEFAULT_CUR_PARAM, DEFAULT_DELTA, iteratorURL, headernames, EMPTY_RESULTS_MESSAGE);
		
		BaoCaoHoSoThangDisplayTerms displayTerms = (BaoCaoHoSoThangDisplayTerms)getDisplayTerms();
		iteratorURL.setParameter(BaoCaoHoSoThangDisplayTerms.TUNGAY, displayTerms.getFromDate());
		iteratorURL.setParameter(BaoCaoHoSoThangDisplayTerms.DENNGAY, displayTerms.getToDate());
		
	}
}
