package com.sgs.portlet.career.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class CareerSearchTerms extends CareerDisplayTerms {

	public CareerSearchTerms(RenderRequest renderRequest) {
		super(renderRequest);
		ma = DAOParamUtil.getLike(renderRequest, MA);
		ten = DAOParamUtil.getLike(renderRequest, TEN);
		mota = DAOParamUtil.getLike(renderRequest, MOTA);
	}


}
