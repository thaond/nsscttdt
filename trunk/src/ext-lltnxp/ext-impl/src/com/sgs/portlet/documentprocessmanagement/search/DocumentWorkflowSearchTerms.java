package com.sgs.portlet.documentprocessmanagement.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class DocumentWorkflowSearchTerms extends DocumentWorkflowDisplayTerms {

	public DocumentWorkflowSearchTerms(RenderRequest renderRequest) {
		super(renderRequest);
		documentWorkflowName = DAOParamUtil.getLike(renderRequest, DOCUMENTWORKFLOWNAME);
		description = DAOParamUtil.getLike(renderRequest, DESCRIPTION);
	}
}
