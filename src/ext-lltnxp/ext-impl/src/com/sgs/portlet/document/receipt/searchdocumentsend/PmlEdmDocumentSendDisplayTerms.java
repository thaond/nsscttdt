package com.sgs.portlet.document.receipt.searchdocumentsend;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class PmlEdmDocumentSendDisplayTerms extends DisplayTerms {
	
	public static final String SO_PHAT_HANH = "soPhatHanh";
	public static final String LOAI_CONG_VAN = "loaiCongVan";
	public static final String TRA_LOI_CONG_VAN_SO = "traLoiCongVanSo";
	public static final String PHONG_SOAN_THAO = "phongSoanThao";
	public static final String NOI_NHAN = "noiNhan";
	public static final String NGUOI_KY = "nguoiKy";
	public static final String TU_NGAY = "tuNgay";
	public static final String DEN_NGAY = "denNgay";
	public static final String SO_HSCV = "soHSCV";
	public static final String TRICH_YEU = "trichYeu";
	public static final String NUMOFDOCREF = "numofdocref";
	public static final String NGUOI_SOAN_THAO = "nguoiSoanThao";

	public static final String NUMOFDIRECTOR = "numOfDirector";
	
	protected String soPhatHanh;
	protected long loaiCongVan;
	protected String traLoiCongVanSo;
	protected String phongSoanThao;
	protected String noiNhan;
	protected String nguoiKy;
	protected String tuNgay;
	protected String denNgay;
	protected long soHSCV;
	protected String trichYeu;
	protected long nguoiSoanThao;

	protected int numOfDirector;
	
	public PmlEdmDocumentSendDisplayTerms(RenderRequest renderRequest) {
		super(renderRequest);
		
		soPhatHanh = ParamUtil.getString(renderRequest, SO_PHAT_HANH);
		loaiCongVan = ParamUtil.getLong(renderRequest, LOAI_CONG_VAN);
		traLoiCongVanSo = ParamUtil.getString(renderRequest, TRA_LOI_CONG_VAN_SO);
		phongSoanThao = ParamUtil.getString(renderRequest, PHONG_SOAN_THAO);
		noiNhan = ParamUtil.getString(renderRequest, NOI_NHAN);
		nguoiKy = ParamUtil.getString(renderRequest, NGUOI_KY);
		tuNgay = ParamUtil.getString(renderRequest, TU_NGAY);
		denNgay = ParamUtil .getString(renderRequest, DEN_NGAY);
		soHSCV = ParamUtil.getLong(renderRequest, SO_HSCV);
		trichYeu = ParamUtil.getString(renderRequest, TRICH_YEU);
		nguoiSoanThao = ParamUtil.getLong(renderRequest, NGUOI_SOAN_THAO);
		
		numOfDirector = ParamUtil.getInteger(renderRequest, NUMOFDIRECTOR);
	}

	public String getSoPhatHanh() {
		return soPhatHanh;
	}

	public void setSoPhatHanh(String soPhatHanh) {
		this.soPhatHanh = soPhatHanh;
	}

	public long getLoaiCongVan() {
		return loaiCongVan;
	}

	public void setLoaiCongVan(long loaiCongVan) {
		this.loaiCongVan = loaiCongVan;
	}

	public String getTraLoiCongVanSo() {
		return traLoiCongVanSo;
	}

	public void setTraLoiCongVanSo(String traLoiCongVanSo) {
		this.traLoiCongVanSo = traLoiCongVanSo;
	}

	public String getPhongSoanThao() {
		return phongSoanThao;
	}

	public void setPhongSoanThao(String phongSoanThao) {
		this.phongSoanThao = phongSoanThao;
	}

	public String getNoiNhan() {
		return noiNhan;
	}

	public void setNoiNhan(String noiNhan) {
		this.noiNhan = noiNhan;
	}

	public String getNguoiKy() {
		return nguoiKy;
	}

	public void setNguoiKy(String nguoiKy) {
		this.nguoiKy = nguoiKy;
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

	public long getSoHSCV() {
		return soHSCV;
	}

	public void setSoHSCV(long soHSCV) {
		this.soHSCV = soHSCV;
	}

	public String getTrichYeu() {
		return trichYeu;
	}

	public void setTrichYeu(String trichYeu) {
		this.trichYeu = trichYeu;
	}
	
	public long getNguoiSoanThao() {
		return nguoiSoanThao;
	}

	public void setNguoiSoanThao(long nguoiSoanThao) {
		this.nguoiSoanThao = nguoiSoanThao;
	}

	public int getNumOfDirector() {
		return numOfDirector;
	}

	public void setNumOfDirector(int numOfDirector) {
		this.numOfDirector = numOfDirector;
	}
}
