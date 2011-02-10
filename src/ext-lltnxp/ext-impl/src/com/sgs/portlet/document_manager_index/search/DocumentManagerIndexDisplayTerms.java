package com.sgs.portlet.document_manager_index.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class DocumentManagerIndexDisplayTerms extends DisplayTerms {
	public static final String DOCUMENTMANAGERCODE = "documentManagerCode";
	public static final String DOCUMENTMANAGERCATEGORY = "documentManagerCategory";
	public static final String DOCUMENTMANAGERDESCRIPTION = "documentManagerDescription";
	public static final String DOCUMENTMANAGERTITLE = "documentManagerTitle";
	public static final String DATEFROM = "dateFrom";
	public static final String DATETO = "dateTo";

	protected String documentManagerCode;
	protected String documentManagerCategory;
	protected String documentManagerDescription;
	protected String documentManagerTitle;
	protected String dateFrom;
	protected String dateTo;

	public DocumentManagerIndexDisplayTerms(RenderRequest renderRequest) {
		super(renderRequest);
		documentManagerCode = ParamUtil.getString(renderRequest, DOCUMENTMANAGERCODE);
		documentManagerCategory = ParamUtil.getString(renderRequest, DOCUMENTMANAGERCATEGORY);
		documentManagerDescription = ParamUtil.getString(renderRequest, DOCUMENTMANAGERDESCRIPTION);
		documentManagerTitle = ParamUtil.getString(renderRequest, DOCUMENTMANAGERTITLE);
		dateFrom = ParamUtil.getString(renderRequest, DATEFROM);
		dateTo = ParamUtil.getString(renderRequest, DATETO);
	}
	
	public String getDocumentManagerCode() {
		return documentManagerCode;
	}

	public void setDocumentManagerCode(String documentManagerCode) {
		this.documentManagerCode = documentManagerCode;
	}

	public String getDocumentManagerDescription() {
		return documentManagerDescription;
	}

	public void setDocumentManagerDescription(String documentManagerDescription) {
		this.documentManagerDescription = documentManagerDescription;
	}

	public String getDocumentManagerTitle() {
		return documentManagerTitle;
	}

	public void setDocumentManagerTitle(String documentManagerDateTitle) {
		this.documentManagerTitle = documentManagerDateTitle;
	}

	public String getDocumentManagerCategory() {
		return documentManagerCategory;
	}

	public void setDocumentManagerCategory(String documentManagerCategory) {
		this.documentManagerCategory = documentManagerCategory;
	}
	public String getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}

	public String getDateTo() {
		return dateTo;
	}

	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}
}
