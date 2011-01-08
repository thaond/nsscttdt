package com.sgs.portlet.documentlevelsend.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class PmlEdmLevelSendDisplayTerms extends DisplayTerms{
	public static final String PMLEDMLEVELSEND_NAME = "pmlEdmLevelSendName";

	protected String pmlEdmLevelSendName;
	public PmlEdmLevelSendDisplayTerms(RenderRequest renderRequest) {
		super(renderRequest);
		pmlEdmLevelSendName = ParamUtil.getString(renderRequest, PMLEDMLEVELSEND_NAME);
	}
	
	public String getPmlEdmLevelSendName() {
		return pmlEdmLevelSendName;
	}
	public void setPmlEdmLevelSendName(String pmlEdmLevelSendName) {
		this.pmlEdmLevelSendName = pmlEdmLevelSendName;
	}

}
