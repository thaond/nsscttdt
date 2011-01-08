package com.sgs.portlet.deleteprocessinstance.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;
import com.liferay.portal.kernel.util.ParamUtil;

public class DeleteDocumentSendUnpublishSearchTerms extends DeleteDocumentSendUnpublishDisplayTerms{

	public DeleteDocumentSendUnpublishSearchTerms(RenderRequest renderRequest) {
		super(renderRequest);
		loaiVB = ParamUtil.getLong(renderRequest, LOAIVB);
		nguoiKy = DAOParamUtil.getLike(renderRequest, NGUOIKY);
	}

}
