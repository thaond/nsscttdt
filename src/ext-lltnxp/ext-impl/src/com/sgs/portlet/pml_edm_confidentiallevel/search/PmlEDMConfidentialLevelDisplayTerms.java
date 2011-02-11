package com.sgs.portlet.pml_edm_confidentiallevel.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class PmlEDMConfidentialLevelDisplayTerms extends DisplayTerms{
	public static final String PMLEDMCONFIDENTIALLEVEL_NAME = "pmlEDMConfidentialLevelName";
	
	protected String pmlEDMConfidentialLevelName;
	public PmlEDMConfidentialLevelDisplayTerms(RenderRequest renderRequest) {
		super(renderRequest);
		pmlEDMConfidentialLevelName = ParamUtil.getString(renderRequest, PMLEDMCONFIDENTIALLEVEL_NAME);
	}
	
	public String getPmlEDMConfidentialLevelName() {
		return pmlEDMConfidentialLevelName;
	}
	public void setPmlEDMConfidentialLevelName(String pmlEDMConfidentialLevelName) {
		this.pmlEDMConfidentialLevelName = pmlEDMConfidentialLevelName;
	}

}
