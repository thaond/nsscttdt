package com.nss.portlet.nss_don_vi_thu_tuc.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class DonViThuTucDisplayTerms extends DisplayTerms {
	public static final String TEN_DON_VI_THU_TUC = "tenDonViThuTuc";
	public static final String MO_TA = "moTa";
	
	protected String tenDonViThuTuc;
	protected String moTa;
	
	public DonViThuTucDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);
	
		tenDonViThuTuc = ParamUtil.getString(portletRequest, TEN_DON_VI_THU_TUC);
		moTa = ParamUtil.getString(portletRequest, MO_TA);
	}

	public String getTenDonViThuTuc() {
		return tenDonViThuTuc;
	}

	public void setTenDonViThuTuc(String tenDonViThuTuc) {
		this.tenDonViThuTuc = tenDonViThuTuc;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	
}
