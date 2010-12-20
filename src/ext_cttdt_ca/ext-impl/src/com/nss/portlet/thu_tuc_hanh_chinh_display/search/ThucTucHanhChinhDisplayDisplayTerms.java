package com.nss.portlet.thu_tuc_hanh_chinh_display.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class ThucTucHanhChinhDisplayDisplayTerms extends DisplayTerms{
	public static final String TEN_THU_TUC_HANH_CHINH = "tenThuTucHanhChinh";
	public static final String LINH_VUC_THU_TUC = "linhVucThuTuc";
	public static final String CAP_DON_VI_THU_TUC = "capDonViThuTuc";
	public static final String DON_VI_THU_TUC = "donViThuTuc";
	
	protected String tenThuTucHanhChinh;
	protected long linhVucThuTuc;
	protected long capDonViThuTuc;
	protected long donViThuTuc;
	
	public ThucTucHanhChinhDisplayDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);
		tenThuTucHanhChinh = ParamUtil.getString(portletRequest, TEN_THU_TUC_HANH_CHINH);
		linhVucThuTuc = ParamUtil.getLong(portletRequest, LINH_VUC_THU_TUC);
		capDonViThuTuc = ParamUtil.getLong(portletRequest, CAP_DON_VI_THU_TUC, 1);
		donViThuTuc = ParamUtil.getLong(portletRequest, DON_VI_THU_TUC);
	}

	public String getTenThuTucHanhChinh() {
		return tenThuTucHanhChinh;
	}

	public void setTenThuTucHanhChinh(String tenThuTucHanhChinh) {
		this.tenThuTucHanhChinh = tenThuTucHanhChinh;
	}

	public long getLinhVucThuTuc() {
		return linhVucThuTuc;
	}

	public void setLinhVucThuTuc(long linhVucThuTuc) {
		this.linhVucThuTuc = linhVucThuTuc;
	}

	public long getDonViThuTuc() {
		return donViThuTuc;
	}

	public void setDonViThuTuc(long donViThuTuc) {
		this.donViThuTuc = donViThuTuc;
	}

	public long getCapDonViThuTuc() {
		return capDonViThuTuc;
	}

	public void setCapDonViThuTuc(long capDonViThuTuc) {
		this.capDonViThuTuc = capDonViThuTuc;
	}

}
