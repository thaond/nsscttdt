package com.sgs.portlet.pmlstreet.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class StreetSearchTerms extends StreetDisplayTerms{
	public StreetSearchTerms(RenderRequest renderRequest) {
		super(renderRequest);
		ten = DAOParamUtil.getLike(renderRequest, TEN);
	}

}
