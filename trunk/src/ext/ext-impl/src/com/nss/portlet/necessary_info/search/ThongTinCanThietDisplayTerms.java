package com.nss.portlet.necessary_info.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class ThongTinCanThietDisplayTerms extends DisplayTerms {
	public static final String TEN_THONG_TIN_CAN_THIET = "tenThongTinCanThiet";
	public static final String MO_TA = "moTa";
	
	protected String tenThongTinCanThiet;
	protected String moTa;
	
	public ThongTinCanThietDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);
		tenThongTinCanThiet = ParamUtil.getString(portletRequest, TEN_THONG_TIN_CAN_THIET);
		moTa = ParamUtil.getString(portletRequest, MO_TA);
	}

	public String getTenThongTinCanThiet() {
		return tenThongTinCanThiet;
	}

	public void setTenThongTinCanThiet(String tenThongTinCanThiet) {
		this.tenThongTinCanThiet = tenThongTinCanThiet;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

}
