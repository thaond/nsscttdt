package com.sgs.portlet.organizationexternal.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class OrganizationExternalSearchTerms extends OrganizationExternalDisplayTerms{

	public OrganizationExternalSearchTerms(RenderRequest renderRequest) {
		super(renderRequest);
		ma = DAOParamUtil.getLike(renderRequest, MA);
		ten = DAOParamUtil.getLike(renderRequest, TEN);
	}
}
