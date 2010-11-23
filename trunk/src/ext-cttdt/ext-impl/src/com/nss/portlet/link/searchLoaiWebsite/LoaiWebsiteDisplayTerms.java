package com.nss.portlet.link.searchLoaiWebsite;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class LoaiWebsiteDisplayTerms extends DisplayTerms{
	public static final String TEN_LOAI_WEBSITE = "tenLoaiWebsite";
	public static final String MO_TA_LOAI = "moTaLoai";
	
	protected String tenLoaiWebsite;
	protected String moTaLoai;
	
	public LoaiWebsiteDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);
		tenLoaiWebsite = ParamUtil.getString(portletRequest, TEN_LOAI_WEBSITE);
		moTaLoai = ParamUtil.getString(portletRequest, MO_TA_LOAI);
	}

	public String getTenLoaiWebsite() {
		return tenLoaiWebsite;
	}

	public void setTenLoaiWebsite(String tenLoaiWebsite) {
		this.tenLoaiWebsite = tenLoaiWebsite;
	}

	public String getMoTaLoai() {
		return moTaLoai;
	}

	public void setMoTaLoai(String moTaLoai) {
		this.moTaLoai = moTaLoai;
	}


}
