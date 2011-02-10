package com.sgs.portlet.documentprocessmanagement.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class DocumentWorkflowDisplayTerms extends DisplayTerms {
	public static final String DOCUMENTWORKFLOWNAME = "documentWorkflowName";
	public static final String DESCRIPTION = "description";
	
	protected String documentWorkflowName;
	protected String description;
	public DocumentWorkflowDisplayTerms(RenderRequest renderRequest) {
		super(renderRequest);
		documentWorkflowName = ParamUtil.getString(renderRequest, DOCUMENTWORKFLOWNAME);
		description = ParamUtil.getString(renderRequest, DESCRIPTION);
	}
	
	public String getDocumentWorkflowName() {
		return documentWorkflowName;
	}
	public void setDocumentWorkflowName(String documentWorkflowName) {
		this.documentWorkflowName = documentWorkflowName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
