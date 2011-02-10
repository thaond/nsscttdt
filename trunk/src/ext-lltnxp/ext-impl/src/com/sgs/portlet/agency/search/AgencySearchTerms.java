package com.sgs.portlet.agency.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class AgencySearchTerms extends AgencyDisplayTerms{

	public AgencySearchTerms(RenderRequest renderRequest) {
		super(renderRequest);
		ma = DAOParamUtil.getLike(renderRequest, MA);
		ho = DAOParamUtil.getLike(renderRequest, HO);
		ten = DAOParamUtil.getLike(renderRequest, TEN);
		tenCoQuan = DAOParamUtil.getLike(renderRequest, TENCOQUAN);
	}

}
