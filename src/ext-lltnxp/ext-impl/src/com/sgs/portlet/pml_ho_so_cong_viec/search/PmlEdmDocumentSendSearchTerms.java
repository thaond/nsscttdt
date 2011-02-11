package com.sgs.portlet.pml_ho_so_cong_viec.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class PmlEdmDocumentSendSearchTerms extends
		PmlEdmDocumentSendDisplayTerms {

	public PmlEdmDocumentSendSearchTerms(RenderRequest renderRequest) {
		super(renderRequest);

		documentSendReference = DAOParamUtil.getLike(renderRequest,
				DOCUMENT_SEND_REFERENCE);
		documentSendBriefContent = DAOParamUtil.getLike(renderRequest,
				DOCUMENT_SEND_BRIEF_CONTENT);
	}

}
