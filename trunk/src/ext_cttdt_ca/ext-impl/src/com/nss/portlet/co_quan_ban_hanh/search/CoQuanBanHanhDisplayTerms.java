package com.nss.portlet.co_quan_ban_hanh.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class CoQuanBanHanhDisplayTerms extends DisplayTerms{
	public static final String TEN_CO_QUAN_BAN_HANH = "tenCoQuanBanHanh";
	public static final String MO_TA = "moTa";
	
	protected String tenCoQuanBanHanh;
	protected String moTa;
	
	public CoQuanBanHanhDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);
		tenCoQuanBanHanh = ParamUtil.getString(portletRequest, TEN_CO_QUAN_BAN_HANH);
		moTa = ParamUtil.getString(portletRequest, MO_TA);
	}

	public String getTenCoQuanBanHanh() {
		return tenCoQuanBanHanh;
	}

	public void setTenCoQuanBanHanh(String tenCoQuanBanHanh) {
		this.tenCoQuanBanHanh = tenCoQuanBanHanh;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	
	

}
