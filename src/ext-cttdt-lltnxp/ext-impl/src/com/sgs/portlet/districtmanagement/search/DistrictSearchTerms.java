package com.sgs.portlet.districtmanagement.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class DistrictSearchTerms extends DistrictDisplayTerms{

	public DistrictSearchTerms(RenderRequest renderRequest) {
		super(renderRequest);
		ma = DAOParamUtil.getLike(renderRequest, MA);
		ten = DAOParamUtil.getLike(renderRequest, TEN);
		mota = DAOParamUtil.getLike(renderRequest, MOTA);
	}
}
