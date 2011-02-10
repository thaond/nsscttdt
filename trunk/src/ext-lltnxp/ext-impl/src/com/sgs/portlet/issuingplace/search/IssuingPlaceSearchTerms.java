package com.sgs.portlet.issuingplace.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class IssuingPlaceSearchTerms extends IssuingPlaceDisplayTerms{

	public IssuingPlaceSearchTerms(RenderRequest renderRequest) {
		super(renderRequest);
		code = DAOParamUtil.getLike(renderRequest, MA);
		name = DAOParamUtil.getLike(renderRequest, NAME);
	}

}
