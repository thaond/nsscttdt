package com.sgs.portlet.document_manager.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class DocumentManagerSearchTerms extends DocumentManagerDisplayTerms {
	
	public DocumentManagerSearchTerms(RenderRequest renderRequest) {
		super(renderRequest);
		documentManagerCode = DAOParamUtil.getLike(renderRequest, DOCUMENTMANAGERCODE);
		documentManagerCategory = DAOParamUtil.getLike(renderRequest, DOCUMENTMANAGERCATEGORY);
		documentManagerDescription = DAOParamUtil.getLike(renderRequest, DOCUMENTMANAGERDESCRIPTION);
		documentManagerTitle = DAOParamUtil.getLike(renderRequest, DOCUMENTMANAGERTITLE);
		dateFrom = DAOParamUtil.getString(renderRequest, DATEFROM);
		dateTo = DAOParamUtil.getString(renderRequest, DATETO);
	}
}

