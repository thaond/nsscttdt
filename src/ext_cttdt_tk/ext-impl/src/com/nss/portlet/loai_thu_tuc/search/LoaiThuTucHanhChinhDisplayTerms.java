package com.nss.portlet.loai_thu_tuc.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class LoaiThuTucHanhChinhDisplayTerms extends DisplayTerms{
	public static final String TEN_LOAI_THU_TUC = "tenLoaiThuTucHanhChinh";
	public static final String MO_TA = "moTa";
	
	protected String tenLoaiThuTucHanhChinh;
	protected String moTa;
	
	public LoaiThuTucHanhChinhDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);
		tenLoaiThuTucHanhChinh = ParamUtil.getString(portletRequest, TEN_LOAI_THU_TUC);
		moTa = ParamUtil.getString(portletRequest, MO_TA);
	}

	public String getTenLoaiThuTucHanhChinh() {
		return tenLoaiThuTucHanhChinh;
	}

	public void setTenLoaiThuTucHanhChinh(String tenLoaiThuTucHanhChinh) {
		this.tenLoaiThuTucHanhChinh = tenLoaiThuTucHanhChinh;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

}
