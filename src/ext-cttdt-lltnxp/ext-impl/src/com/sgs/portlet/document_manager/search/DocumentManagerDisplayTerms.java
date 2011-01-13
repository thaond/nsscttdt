package com.sgs.portlet.document_manager.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class DocumentManagerDisplayTerms extends DisplayTerms {
	public static final String DOCUMENTMANAGERCODE = "documentManagerCode";
	public static final String DOCUMENTMANAGERDESCRIPTION = "documentManagerDescription";
	public static final String DOCUMENTMANAGERTITLE = "documentManagerDateTitle";

	protected String documentManagerCode;
	protected String documentManagerDescription;
	protected String documentManagerTitle;

	public DocumentManagerDisplayTerms(RenderRequest renderRequest) {
		super(renderRequest);
		documentManagerCode = ParamUtil.getString(renderRequest, DOCUMENTMANAGERCODE);
		documentManagerDescription = ParamUtil.getString(renderRequest, DOCUMENTMANAGERDESCRIPTION);
		documentManagerTitle = ParamUtil.getString(renderRequest, DOCUMENTMANAGERTITLE);

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
}