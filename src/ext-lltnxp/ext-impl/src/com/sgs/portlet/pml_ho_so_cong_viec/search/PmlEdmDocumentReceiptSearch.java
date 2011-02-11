package com.sgs.portlet.pml_ho_so_cong_viec.search;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;

public class PmlEdmDocumentReceiptSearch extends
		SearchContainer<PmlEdmDocumentReceipt> {
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();

	static {
		headerNames.add("STT");
		headerNames.add("so-hieu");
		headerNames.add("date");
		headerNames.add("trich-yeu");
		headerNames.add("toan-van");

		// Order by
		orderableHeaders.put("so-hieu", "so-hieu");
		orderableHeaders.put("trich-yeu", "trich-yeu");
	}

	public static final String EMPTY_RESULTS_MESSAGE = "no-pml-edm-document-receipt-were-found";

	public PmlEdmDocumentReceiptSearch(RenderRequest renderRequest,
			PortletURL iteratorURL) {
		super(renderRequest, new PmlEdmDocumentReceiptDisplayTerms(
				renderRequest), new PmlEdmDocumentReceiptSearchTerms(
				renderRequest), DEFAULT_CUR_PARAM, DEFAULT_DELTA, iteratorURL,
				headerNames, EMPTY_RESULTS_MESSAGE);

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		PmlEdmDocumentReceiptDisplayTerms displayTerms = (PmlEdmDocumentReceiptDisplayTerms) getDisplayTerms();
		iteratorURL.setParameter(
				PmlEdmDocumentReceiptDisplayTerms.DOCUMENT_REFERENCE,
				displayTerms.getDocumentReference());
		iteratorURL.setParameter(
				PmlEdmDocumentReceiptDisplayTerms.BRIEF_CONTENT,
				displayTerms.getBriefContent());
		iteratorURL.setParameter(
				PmlEdmDocumentReceiptDisplayTerms.FROM_DATE,
				displayTerms.getFromDate() == null ? "" : df
						.format(displayTerms.getFromDate()));
		iteratorURL.setParameter(
				PmlEdmDocumentReceiptDisplayTerms.TO_DATE,
				displayTerms.getToDate() == null ? "" : df.format(displayTerms
						.getToDate()));
	}
}
