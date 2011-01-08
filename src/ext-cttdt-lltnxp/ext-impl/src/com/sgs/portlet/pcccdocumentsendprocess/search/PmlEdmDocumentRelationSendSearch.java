package com.sgs.portlet.pcccdocumentsendprocess.search;

import com.liferay.portal.kernel.dao.search.SearchContainer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;

public class PmlEdmDocumentRelationSendSearch extends SearchContainer<Long> {

	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();

	static {
		headerNames.add("pccc-TN-stt");
		headerNames.add("receipt.docref");
		headerNames.add("receipt.creator");
		headerNames.add("receipt.department");
		headerNames.add("receipt.receiveplace");
		headerNames.add("pccc-cvdtn-trichyeu");

		// Order by
	}

	public static final String EMPTY_RESULTS_MESSAGE = "no-have-data";

	public PmlEdmDocumentRelationSendSearch(RenderRequest renderRequest, PortletURL iteratorURL) {
		super(
			renderRequest, new PmlEdmDocumentRelationSendDisplayTerms(renderRequest),
			new PmlEdmDocumentRelationSendSearchTerms(renderRequest), DEFAULT_CUR_PARAM,
			DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);

		PmlEdmDocumentRelationSendDisplayTerms displayTerms =
			(PmlEdmDocumentRelationSendDisplayTerms)getDisplayTerms();

		iteratorURL.setParameter(
				PmlEdmDocumentRelationSendDisplayTerms.SOPHATHANH, displayTerms.getSoPhatHanh());
		iteratorURL.setParameter(
				PmlEdmDocumentRelationSendDisplayTerms.PHONGSOANTHAO, displayTerms.getPhongSoanThao());
		iteratorURL.setParameter(
				PmlEdmDocumentRelationSendDisplayTerms.NOINHAN, displayTerms.getNoiNhan());
		iteratorURL.setParameter(
				PmlEdmDocumentRelationSendDisplayTerms.TRICHYEU, displayTerms.getTrichYeu());
	}
}