package com.sgs.portlet.citymanagement.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class CitySearchTerms extends CityDisplayTerms{

	public CitySearchTerms(RenderRequest renderRequest) {
		super(renderRequest);
		ma = DAOParamUtil.getLike(renderRequest, MA);
		ten = DAOParamUtil.getLike(renderRequest, TEN);
	}

}
