package com.sgs.portlet.loaivanbannoibo.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class LoaiVanBanNoiBoDisplayTerms extends DisplayTerms{
	
	public static final String KYHIEULOAIVANBANNOIBO = "kyHieuLoaiVanBanNoiBo";
	public static final String TENLOAIVANBANNOIBO = "tenLoaiVanBanNoiBo";
	
	protected String kyHieuLoaiVanBanNoiBo;
	protected String tenLoaiVanBanNoiBo;

	public LoaiVanBanNoiBoDisplayTerms(RenderRequest request) {
		super(request);
		kyHieuLoaiVanBanNoiBo = ParamUtil.getString(request, KYHIEULOAIVANBANNOIBO);
		tenLoaiVanBanNoiBo = ParamUtil.getString(request, TENLOAIVANBANNOIBO);
	}

	public String getKyHieuLoaiVanBanNoiBo() {
		return kyHieuLoaiVanBanNoiBo;
	}

	public void setKyHieuLoaiVanBanNoiBo(String kyHieuLoaiVanBanNoiBo) {
		this.kyHieuLoaiVanBanNoiBo = kyHieuLoaiVanBanNoiBo;
	}

	public String getTenLoaiVanBanNoiBo() {
		return tenLoaiVanBanNoiBo;
	}

	public void setTenLoaiVanBanNoiBo(String tenLoaiVanBanNoiBo) {
		this.tenLoaiVanBanNoiBo = tenLoaiVanBanNoiBo;
	}
}
