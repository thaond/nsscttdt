package com.sgs.portlet.loaivanbannoibo.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class LoaiVanBanNoiBoSearchTerms extends LoaiVanBanNoiBoDisplayTerms{

	public LoaiVanBanNoiBoSearchTerms(RenderRequest request) {
		super(request);
		kyHieuLoaiVanBanNoiBo = DAOParamUtil.getLike(request, KYHIEULOAIVANBANNOIBO);
		tenLoaiVanBanNoiBo = DAOParamUtil.getLike(request, TENLOAIVANBANNOIBO);
	}
}
