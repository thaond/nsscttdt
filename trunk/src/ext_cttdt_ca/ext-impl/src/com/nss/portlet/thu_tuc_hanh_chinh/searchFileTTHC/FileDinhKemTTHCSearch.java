package com.nss.portlet.thu_tuc_hanh_chinh.searchFileTTHC;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC;

public class FileDinhKemTTHCSearch extends SearchContainer<FileDinhKemTTHC>{
	static List<String> headerNames = new ArrayList<String>();
	static{
		headerNames.add("stt");
		headerNames.add("tieu-de");
		headerNames.add("mo-ta");
		headerNames.add("kich-thuoc");
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	public FileDinhKemTTHCSearch(PortletRequest portletRequest, PortletURL iteratorURL) {
		super(
			portletRequest, new FileDinhKemTTHCDisplayTerms(portletRequest),
			new FileDinhKemTTHCSearchTerms(portletRequest), DEFAULT_CUR_PARAM,
			DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
	}
}
