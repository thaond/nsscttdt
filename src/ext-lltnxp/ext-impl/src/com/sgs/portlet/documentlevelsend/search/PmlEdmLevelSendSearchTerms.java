package com.sgs.portlet.documentlevelsend.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.util.ParamUtil;

public class PmlEdmLevelSendSearchTerms extends PmlEdmLevelSendDisplayTerms{

	public PmlEdmLevelSendSearchTerms(RenderRequest renderRequest) {
		super(renderRequest);
		pmlEdmLevelSendName = ParamUtil.getString(renderRequest, PMLEDMLEVELSEND_NAME);
	}

}
