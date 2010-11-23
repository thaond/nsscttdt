package com.nss.portlet.loai_van_ban.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class LoaiVanBanDisplayTerms extends DisplayTerms{
	public static final String TEN_LOAI_VB = "tenLoaiVanBan";
	public static final String MO_TA = "moTa";
	
	protected String tenLoaiVanBan;
	protected String moTa;
	
	public LoaiVanBanDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);
		tenLoaiVanBan = ParamUtil.getString(portletRequest, TEN_LOAI_VB);
		moTa = ParamUtil.getString(portletRequest, MO_TA);
	}

	public String getTenLoaiVanBan() {
		return tenLoaiVanBan;
	}

	public void setTenLoaiVanBan(String tenLoaiVanBan) {
		this.tenLoaiVanBan = tenLoaiVanBan;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	
	
	
}
