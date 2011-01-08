package com.sgs.portlet.pml_edm_confidentiallevel.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.util.ParamUtil;

public class PmlEDMConfidentialLevelSearchTerms extends PmlEDMConfidentialLevelDisplayTerms {

	public PmlEDMConfidentialLevelSearchTerms(RenderRequest renderRequest) {
		super(renderRequest);
		pmlEDMConfidentialLevelName = ParamUtil.getString(renderRequest, PMLEDMCONFIDENTIALLEVEL_NAME);
	}

}
