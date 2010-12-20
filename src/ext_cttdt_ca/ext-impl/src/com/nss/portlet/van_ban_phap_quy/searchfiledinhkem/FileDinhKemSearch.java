package com.nss.portlet.van_ban_phap_quy.searchfiledinhkem;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.nss.portlet.van_ban_phap_quy.model.FileDinhKem;

public class FileDinhKemSearch extends SearchContainer<FileDinhKem>{
	static List<String> headerNames = new ArrayList<String>();
	static{
		headerNames.add("stt");
		headerNames.add("tieu-de");
		headerNames.add("mo-ta");
		headerNames.add("kich-thuoc");
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	public FileDinhKemSearch(PortletRequest portletRequest, PortletURL iteratorURL) {
		super(
			portletRequest, new FileDinhKemDisplayTerms(portletRequest),
			new FileDinhKemSearchTerms(portletRequest), DEFAULT_CUR_PARAM,
			DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
	}
}
