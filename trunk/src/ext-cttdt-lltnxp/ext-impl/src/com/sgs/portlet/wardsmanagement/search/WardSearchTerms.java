package com.sgs.portlet.wardsmanagement.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class WardSearchTerms extends WardDisplayTerms{

	public WardSearchTerms(RenderRequest renderRequest) {
		super(renderRequest);
		ma = DAOParamUtil.getLike(renderRequest, MA);
		ten = DAOParamUtil.getLike(renderRequest, TEN);
		mota = DAOParamUtil.getLike(renderRequest, MOTA);
	}

}
