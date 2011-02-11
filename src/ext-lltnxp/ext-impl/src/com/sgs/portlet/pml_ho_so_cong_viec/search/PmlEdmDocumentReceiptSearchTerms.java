package com.sgs.portlet.pml_ho_so_cong_viec.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class PmlEdmDocumentReceiptSearchTerms extends
		PmlEdmDocumentReceiptDisplayTerms {

	public PmlEdmDocumentReceiptSearchTerms(RenderRequest renderRequest) {
		super(renderRequest);

		documentReference = DAOParamUtil.getLike(renderRequest,
				DOCUMENT_REFERENCE);
		briefContent = DAOParamUtil.getLike(renderRequest, BRIEF_CONTENT);
	}

}
