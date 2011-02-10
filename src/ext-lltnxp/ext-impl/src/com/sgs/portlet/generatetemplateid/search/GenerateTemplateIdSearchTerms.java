package com.sgs.portlet.generatetemplateid.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class GenerateTemplateIdSearchTerms extends GenerateTemplateIdDisplayTerms{

	public GenerateTemplateIdSearchTerms(RenderRequest renderRequest) {
		super(renderRequest);
		dinhDang = DAOParamUtil.getLike(renderRequest, DINHDANG);
		moTa = DAOParamUtil.getLike(renderRequest, MOTA);
	}

}
