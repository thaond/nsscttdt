package com.nss.portlet.linh_vuc_thu_tuc.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class LinhVucThuTucHanhChinhDisplayTerms extends DisplayTerms {
	public static final String TEN_LINH_VUC_THU_TUC = "tenLinhVucThuTuc";
	public static final String MO_TA = "moTa";
	
	protected String tenLinhVucThuTuc;
	protected String moTa;
	
	public LinhVucThuTucHanhChinhDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);
	
		tenLinhVucThuTuc = ParamUtil.getString(portletRequest, TEN_LINH_VUC_THU_TUC);
		moTa = ParamUtil.getString(portletRequest, MO_TA);
	}

	public String getTenLinhVucThuTuc() {
		return tenLinhVucThuTuc;
	}

	public void setTenLinhVucThuTuc(String tenLinhVucThuTuc) {
		this.tenLinhVucThuTuc = tenLinhVucThuTuc;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	
}
