package com.sgs.portlet.sovanbannoibo.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class SoVanBanNoiBoSearchTerms extends SoVanBanNoiBoDisplayTerms{

	public SoVanBanNoiBoSearchTerms(RenderRequest request) {
		super(request);
		maSoVanBanNoiBo = DAOParamUtil.getLike(request, MASOVANBANNOIBO);
		tenSoVanBanNoiBo = DAOParamUtil.getLike(request, TENSOVANBANNOIBO);
	}
}
