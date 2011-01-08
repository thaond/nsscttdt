package com.sgs.portlet.pcccdocumentreceiptprocess.search;

import com.liferay.portal.kernel.dao.search.SearchContainer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;

public class PmlEdmDocumentRelationReceiptSearch extends SearchContainer<Long> {

	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();

	static {
		headerNames.add("pccc-TN-stt");
		headerNames.add("pccc-cvdtn-sohieu");
		headerNames.add("pccc-cvdtn-soCVden");
		headerNames.add("pccc-cvdtn-noiphathanh");
		headerNames.add("pccc-cvdtn-trichyeu");

		// Order by
	}

	public static final String EMPTY_RESULTS_MESSAGE = "no-have-data";

	public PmlEdmDocumentRelationReceiptSearch(RenderRequest renderRequest, PortletURL iteratorURL) {
		super(
			renderRequest, new PmlEdmDocumentRelationReceiptDisplayTerms(renderRequest),
			new PmlEdmDocumentRelationReceiptSearchTerms(renderRequest), DEFAULT_CUR_PARAM,
			DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);

		PmlEdmDocumentRelationReceiptDisplayTerms displayTerms =
			(PmlEdmDocumentRelationReceiptDisplayTerms)getDisplayTerms();

		iteratorURL.setParameter(
				PmlEdmDocumentRelationReceiptDisplayTerms.SONOIBO, displayTerms.getSoNoiBo());
		iteratorURL.setParameter(
				PmlEdmDocumentRelationReceiptDisplayTerms.SOHIEUGOC, displayTerms.getSoHieuGoc());
		iteratorURL.setParameter(
				PmlEdmDocumentRelationReceiptDisplayTerms.NOIPHATHANH, displayTerms.getNoiPhatHanh());
		iteratorURL.setParameter(
				PmlEdmDocumentRelationReceiptDisplayTerms.NGAYPHATHANHTU, displayTerms.getNgayPhatHanhTu());
		iteratorURL.setParameter(
				PmlEdmDocumentRelationReceiptDisplayTerms.NGAYPHATHANHDEN, displayTerms.getNgayPhatHanhDen());
		iteratorURL.setParameter(
				PmlEdmDocumentRelationReceiptDisplayTerms.TRICHYEU, displayTerms.getTrichYeu());
	}
}