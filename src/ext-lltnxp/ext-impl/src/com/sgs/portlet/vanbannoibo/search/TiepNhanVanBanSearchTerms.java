package com.sgs.portlet.vanbannoibo.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.util.ParamUtil;

public class TiepNhanVanBanSearchTerms extends TiepNhanVanBanDisplayTerms{

	public TiepNhanVanBanSearchTerms(RenderRequest req) {
		super(req);
		loaiVanBanNoiBo = ParamUtil.getLong(req, LOAIVANBANNOIBO);
		ngayTao = ParamUtil.getString(req, NGAYTAO);
		ngayKy = ParamUtil.getString(req, NGAYKY);
		trichYeu = ParamUtil.getString(req, TRICHYEU);	
		nguoiKy = ParamUtil.getLong(req, NGUOIKY);
		ghiChu = ParamUtil.getString(req, GHICHU);
		soVanBanNoiBo = ParamUtil.getString(req, SOVANBANNOIBO);
		soPhatSinhTheoNam = ParamUtil.getString(req, SOPHATSINHTHEONAM);
	}
}
