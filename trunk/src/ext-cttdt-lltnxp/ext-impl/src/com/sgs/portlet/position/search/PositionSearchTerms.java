package com.sgs.portlet.position.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class PositionSearchTerms extends PositionDisplayTerms {
	
	public PositionSearchTerms(RenderRequest renderRequest) {
		super(renderRequest);
		ma = DAOParamUtil.getLike(renderRequest, MA);
		ten = DAOParamUtil.getLike(renderRequest, TEN);
		moTa = DAOParamUtil.getLike(renderRequest, MOTA);
	}

}
