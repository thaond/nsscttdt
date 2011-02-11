package com.sgs.portlet.pml_ho_so_cong_viec.search;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class PmlEdmDocumentReceiptDisplayTerms extends DisplayTerms {
	public static final String DOCUMENT_REFERENCE = "documentReference";
	public static final String BRIEF_CONTENT = "briefContent";
	public static final String FROM_DATE = "fromDate";
	public static final String TO_DATE = "toDate";

	protected String documentReference;
	protected String briefContent;
	protected Date fromDate;
	protected Date toDate;

	public PmlEdmDocumentReceiptDisplayTerms(RenderRequest renderRequest) {
		super(renderRequest);

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		documentReference = ParamUtil.getString(renderRequest,
				DOCUMENT_REFERENCE);
		briefContent = ParamUtil.getString(renderRequest, BRIEF_CONTENT);
		fromDate = ParamUtil.getDate(renderRequest, FROM_DATE, df, null);
		toDate = ParamUtil.getDate(renderRequest, TO_DATE, df, null);

	}

	public String getDocumentReference() {
		return documentReference;
	}

	public void setDocumentReference(String documentReference) {
		this.documentReference = documentReference;
	}

	public String getBriefContent() {
		return briefContent;
	}

	public void setBriefContent(String briefContent) {
		this.briefContent = briefContent;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

}
