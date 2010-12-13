package com.nss.portlet.filestatus.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class PmlFileStatusSearchTerms extends PmlFileStatusDisplayTerms{

	public PmlFileStatusSearchTerms(RenderRequest renderRequest) {
		super(renderRequest);
		filestatuscode = DAOParamUtil.getLike(renderRequest, FILESTATUS_CODE);
		filestatusname = DAOParamUtil.getLike(renderRequest, FILESTATUS_NAME);
	}


}
