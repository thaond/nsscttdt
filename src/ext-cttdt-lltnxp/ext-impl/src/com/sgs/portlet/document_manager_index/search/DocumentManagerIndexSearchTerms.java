package com.sgs.portlet.document_manager_index.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class DocumentManagerIndexSearchTerms extends DocumentManagerIndexDisplayTerms {
	
	public DocumentManagerIndexSearchTerms(RenderRequest renderRequest) {
		super(renderRequest);
		documentManagerCode = DAOParamUtil.getLike(renderRequest, DOCUMENTMANAGERCODE);
		documentManagerCategory = DAOParamUtil.getLike(renderRequest, DOCUMENTMANAGERCATEGORY);
		documentManagerDescription = DAOParamUtil.getLike(renderRequest, DOCUMENTMANAGERDESCRIPTION);
		documentManagerTitle = DAOParamUtil.getLike(renderRequest, DOCUMENTMANAGERTITLE);
	}
}