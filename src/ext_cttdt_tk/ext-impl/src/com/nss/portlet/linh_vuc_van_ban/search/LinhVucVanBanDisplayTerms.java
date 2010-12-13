package com.nss.portlet.linh_vuc_van_ban.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class LinhVucVanBanDisplayTerms extends DisplayTerms {

	public static final String TEN_LINH_VUC_VB = "tenLinhVucVanBan";
	public static final String MO_TA = "moTa";
	
	protected String tenLinhVucVanBan;
	protected String moTa;
	
	public LinhVucVanBanDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);
		tenLinhVucVanBan = ParamUtil.getString(portletRequest, TEN_LINH_VUC_VB);
		moTa = ParamUtil.getString(portletRequest, MO_TA);
	}

	public String getTenLinhVucVanBan() {
		return tenLinhVucVanBan;
	}

	public void setTenLinhVucVanBan(String tenLinhVucVanBan) {
		this.tenLinhVucVanBan = tenLinhVucVanBan;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

}
