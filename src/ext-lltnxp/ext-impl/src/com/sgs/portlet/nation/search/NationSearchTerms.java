package com.sgs.portlet.nation.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class NationSearchTerms extends NationDisplayTerms {

	public NationSearchTerms(RenderRequest renderRequest) {
		super(renderRequest);
		ma = DAOParamUtil.getLike(renderRequest, MA);
		ten = DAOParamUtil.getLike(renderRequest, TEN);
		mota = DAOParamUtil.getLike(renderRequest, MOTA);
	}

}
