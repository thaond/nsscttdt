package com.sgs.portlet.pcccdocumentreceiptprocess.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;
import com.liferay.portal.kernel.util.ParamUtil;

public class PcccDocumentReceiptProcessSearchTerms extends PcccDocumentReceiptProcessSearchDisplayTerms {

	public PcccDocumentReceiptProcessSearchTerms(RenderRequest renderRequest) {
		super(renderRequest);
		capgui =  DAOParamUtil.getInteger(renderRequest, CAPGUI);
		loaisocongvan = ParamUtil.getInteger(renderRequest, LOAISOCONGVAN, 0);
	}

}
