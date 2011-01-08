package com.sgs.portlet.country.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class CountrySearchTerms extends CountryDisplayTerms{

	public CountrySearchTerms(RenderRequest renderRequest) {
		super(renderRequest);
		ma = DAOParamUtil.getLike(renderRequest, MA);
		ten = DAOParamUtil.getLike(renderRequest, TEN);
		mota = DAOParamUtil.getLike(renderRequest, MOTA);
	}

}
