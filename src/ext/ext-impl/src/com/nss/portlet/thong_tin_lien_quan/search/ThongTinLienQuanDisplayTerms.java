package com.nss.portlet.thong_tin_lien_quan.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class ThongTinLienQuanDisplayTerms extends DisplayTerms {
	public static final String TEN_THONG_TIN_LIEN_QUAN = "tenThongTinLienQuan";
	public static final String MO_TA = "moTa";
	
	protected String tenThongTinLienQuan;
	protected String moTa;
	
	public ThongTinLienQuanDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);
		tenThongTinLienQuan = ParamUtil.getString(portletRequest, TEN_THONG_TIN_LIEN_QUAN);
		moTa = ParamUtil.getString(portletRequest, MO_TA);
	}

	public String getTenThongTinLienQuan() {
		return tenThongTinLienQuan;
	}

	public void setTenThongTinLienQuan(String tenThongTinLienQuan) {
		this.tenThongTinLienQuan = tenThongTinLienQuan;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

}
