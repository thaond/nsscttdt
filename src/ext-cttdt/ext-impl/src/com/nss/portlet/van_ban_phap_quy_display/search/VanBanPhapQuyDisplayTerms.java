package com.nss.portlet.van_ban_phap_quy_display.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class VanBanPhapQuyDisplayTerms extends DisplayTerms{

	public static final String KY_HIEU_VAN_BAN = "kyHieuVanBan";
	public static final String TOM_TAT = "tomTat";
	public static final String NGUOI_KY = "nguoiKy";
	
	public static final String MA_LOAI_VAN_BAN = "maLoaiVanBan";
	public static final String MA_LINH_VUC_VAN_BAN = "maLinhVucVanBan";
	public static final String MA_CO_QUAN_BAN_HANH = "maCoQuanBanHanh";
	
	public static final String LOAI_VAN_BAN = "loaiVanBan";
	public static final String LINH_VUC_VAN_BAN = "linhVucVanBan";
	public static final String CO_QUAN_BAN_HANH = "coQuanBanHanh";
	
	public static final String TU_NGAY = "tuNgay";
	public static final String DEN_NGAY = "denNgay";
	
	protected String kyHieuVanBan;
	protected String tomTat;
	protected String nguoiKy;
	
	protected long maLoaiVanBan;
	protected long maLinhVucVanBan;
	protected long maCoQuanBanHanh;
	
	protected String coQuanBanHanh;
	protected String loaiVanBan;
	protected String linhVucVanBan;
	
	protected String tuNgay;
	protected String denNgay;
	
	public VanBanPhapQuyDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);
		kyHieuVanBan = ParamUtil.getString(portletRequest, KY_HIEU_VAN_BAN);
		tomTat = ParamUtil.getString(portletRequest, TOM_TAT);
		nguoiKy = ParamUtil.getString(portletRequest, NGUOI_KY);
		
		maLoaiVanBan = ParamUtil.getLong(portletRequest, MA_LOAI_VAN_BAN);
		maLinhVucVanBan = ParamUtil.getLong(portletRequest, MA_LINH_VUC_VAN_BAN);
		maCoQuanBanHanh = ParamUtil.getLong(portletRequest, MA_CO_QUAN_BAN_HANH);
		
		loaiVanBan = ParamUtil.getString(portletRequest, LOAI_VAN_BAN);
		linhVucVanBan = ParamUtil.getString(portletRequest, LINH_VUC_VAN_BAN);
		coQuanBanHanh = ParamUtil.getString(portletRequest, CO_QUAN_BAN_HANH);
		
		
		tuNgay = ParamUtil.getString(portletRequest, TU_NGAY);
		denNgay = ParamUtil.getString(portletRequest, DEN_NGAY);
	}

	public String getKyHieuVanBan() {
		return kyHieuVanBan;
	}

	public String getNguoiKy() {
		return nguoiKy;
	}

	public void setNguoiKy(String nguoiKy) {
		this.nguoiKy = nguoiKy;
	}

	public void setKyHieuVanBan(String kyHieuVanBan) {
		this.kyHieuVanBan = kyHieuVanBan;
	}

	public String getTomTat() {
		return tomTat;
	}

	public void setTomTat(String tomTat) {
		this.tomTat = tomTat;
	}

	public String getTuNgay() {
		return tuNgay;
	}

	public void setTuNgay(String tuNgay) {
		this.tuNgay = tuNgay;
	}

	public String getDenNgay() {
		return denNgay;
	}

	public void setDenNgay(String denNgay) {
		this.denNgay = denNgay;
	}

	public String getLinhVucVanBan() {
		return linhVucVanBan;
	}

	public long getMaLoaiVanBan() {
		return maLoaiVanBan;
	}

	public void setMaLoaiVanBan(long maLoaiVanBan) {
		this.maLoaiVanBan = maLoaiVanBan;
	}

	public long getMaLinhVucVanBan() {
		return maLinhVucVanBan;
	}

	public void setMaLinhVucVanBan(long maLinhVucVanBan) {
		this.maLinhVucVanBan = maLinhVucVanBan;
	}

	public long getMaCoQuanBanHanh() {
		return maCoQuanBanHanh;
	}

	public void setMaCoQuanBanHanh(long maCoQuanBanHanh) {
		this.maCoQuanBanHanh = maCoQuanBanHanh;
	}

	public void setLinhVucVanBan(String linhVucVanBan) {
		this.linhVucVanBan = linhVucVanBan;
	}

	public String getCoQuanBanHanh() {
		return coQuanBanHanh;
	}

	public void setCoQuanBanHanh(String coQuanBanHanh) {
		this.coQuanBanHanh = coQuanBanHanh;
	}

	public String getLoaiVanBan() {
		return loaiVanBan;
	}

	public void setLoaiVanBan(String loaiVanBan) {
		this.loaiVanBan = loaiVanBan;
	}
}
