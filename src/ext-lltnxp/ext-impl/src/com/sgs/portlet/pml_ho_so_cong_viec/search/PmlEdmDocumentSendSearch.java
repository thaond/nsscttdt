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
import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;

public class PmlEdmDocumentSendSearch extends
		SearchContainer<PmlEdmDocumentSend> {

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

	public static final String EMPTY_RESULTS_MESSAGE = "no-pml-edm-document-send-were-found";

	public PmlEdmDocumentSendSearch(RenderRequest renderRequest,
			PortletURL iteratorURL) {
		super(renderRequest, new PmlEdmDocumentSendDisplayTerms(renderRequest),
				new PmlEdmDocumentSendSearchTerms(renderRequest),
				DEFAULT_CUR_PARAM, DEFAULT_DELTA, iteratorURL, headerNames,
				EMPTY_RESULTS_MESSAGE);

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		PmlEdmDocumentSendDisplayTerms displayTerms = (PmlEdmDocumentSendDisplayTerms) getDisplayTerms();
		iteratorURL.setParameter(
				PmlEdmDocumentSendDisplayTerms.DOCUMENT_SEND_REFERENCE,
				displayTerms.getDocumentSendReference());
		iteratorURL.setParameter(
				PmlEdmDocumentSendDisplayTerms.DOCUMENT_SEND_BRIEF_CONTENT,
				displayTerms.getDocumentSendBriefContent());
		iteratorURL.setParameter(
				PmlEdmDocumentSendDisplayTerms.DOCUMENT_SEND_FROM_DATE,
				displayTerms.getDocumentSendFromDate() == null ? "" : df
						.format(displayTerms.getDocumentSendFromDate()));
		iteratorURL.setParameter(
				PmlEdmDocumentSendDisplayTerms.DOCUMENT_SEND_TO_DATE,
				displayTerms.getDocumentSendToDate() == null ? "" : df
						.format(displayTerms.getDocumentSendToDate()));
	}

}
