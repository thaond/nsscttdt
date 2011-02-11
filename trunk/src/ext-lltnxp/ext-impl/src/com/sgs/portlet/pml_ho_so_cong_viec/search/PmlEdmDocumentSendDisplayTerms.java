package com.sgs.portlet.pml_ho_so_cong_viec.search;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class PmlEdmDocumentSendDisplayTerms extends DisplayTerms {
	public static final String DOCUMENT_SEND_REFERENCE = "documentSendReference";
	public static final String DOCUMENT_SEND_BRIEF_CONTENT = "documentSendBriefContent";
	public static final String DOCUMENT_SEND_FROM_DATE = "documentSendFromDate";
	public static final String DOCUMENT_SEND_TO_DATE = "documentSendToDate";

	protected String documentSendReference;
	protected String documentSendBriefContent;
	protected Date documentSendFromDate;
	protected Date documentSendToDate;

	public PmlEdmDocumentSendDisplayTerms(RenderRequest renderRequest) {
		super(renderRequest);

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		documentSendReference = ParamUtil.getString(renderRequest,
				DOCUMENT_SEND_REFERENCE);
		documentSendBriefContent = ParamUtil.getString(renderRequest,
				DOCUMENT_SEND_BRIEF_CONTENT);
		documentSendFromDate = ParamUtil.getDate(renderRequest,
				DOCUMENT_SEND_FROM_DATE, df, null);
		documentSendToDate = ParamUtil.getDate(renderRequest,
				DOCUMENT_SEND_TO_DATE, df, null);
	}

	public String getDocumentSendReference() {
		return documentSendReference;
	}

	public void setDocumentSendReference(String documentSendReference) {
		this.documentSendReference = documentSendReference;
	}

	public String getDocumentSendBriefContent() {
		return documentSendBriefContent;
	}

	public void setDocumentSendBriefContent(String documentSendBriefContent) {
		this.documentSendBriefContent = documentSendBriefContent;
	}

	public Date getDocumentSendFromDate() {
		return documentSendFromDate;
	}

	public void setDocumentSendFromDate(Date documentSendFromDate) {
		this.documentSendFromDate = documentSendFromDate;
	}

	public Date getDocumentSendToDate() {
		return documentSendToDate;
	}

	public void setDocumentSendToDate(Date documentSendToDate) {
		this.documentSendToDate = documentSendToDate;
	}

}
