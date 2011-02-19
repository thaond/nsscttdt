/**
 * 
 */
package com.sgs.portlet.document.receipt.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

/**
 * @author DienNH
 * 
 */
public class PmlEdmDocumentReceiptDisplayTerms extends DisplayTerms {

	public static final String SO_CV_DEN = "socvden";
	public static final String SO_VAO_SO = "sovaoso";
	public static final String TU_NGAY = "tungay";
	public static final String DEN_NGAY = "denngay";
	public static final String SO_HSCV = "sohscv";
	public static final String LOAI_CV = "loaicv";
	public static final String NOI_PHAT_HANH = "noiphathanh";
	public static final String TRANG_THAI = "trangthai";
	public static final String NGUOI_KY = "nguoiky";
	public static final String NGUOI_KY_ORDER = "nguoiky_order";
	public static final String TRICH_YEU = "trichyeu";
	public static final String GENERALORDERNO = "generalorderno";
	public static final String SOVANBAN = "sovanban";

	/**
	 * 
	 */
	public PmlEdmDocumentReceiptDisplayTerms(RenderRequest req) {
		// TODO Auto-generated constructor stub
		super(req);

		soCVDen = ParamUtil.getString(req, SO_CV_DEN);
		soVaoSo = ParamUtil.getString(req, SO_VAO_SO);
		tuNgay = ParamUtil.getString(req, TU_NGAY);
		denNgay = ParamUtil.getString(req, DEN_NGAY);
		soHSCV = ParamUtil.getLong(req, SO_HSCV);
		loaiCV = ParamUtil.getLong(req, LOAI_CV);
		noiPhatHanh = ParamUtil.getString(req, NOI_PHAT_HANH);
		trangThai = ParamUtil.getLong(req, TRANG_THAI);
		nguoiKy = ParamUtil.getString(req, NGUOI_KY);
		trichYeu = ParamUtil.getString(req, TRICH_YEU);
		soVanBan = ParamUtil.getInteger(req, SOVANBAN);
	}

	public String getSoCVDen() {
		return soCVDen;
	}

	public void setSoCVDen(String soCVDen) {
		this.soCVDen = soCVDen;
	}

	public String getSoVaoSo() {
		return soVaoSo;
	}

	public void setSoVaoSo(String soVaoSo) {
		this.soVaoSo = soVaoSo;
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

	public long getLoaiCV() {
		return loaiCV;
	}

	public void setLoaiCV(long loaiCV) {
		this.loaiCV = loaiCV;
	}

	public String getNoiPhatHanh() {
		return noiPhatHanh;
	}

	public void setNoiPhatHanh(String noiPhatHanh) {
		this.noiPhatHanh = noiPhatHanh;
	}

	public long getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(long trangThai) {
		this.trangThai = trangThai;
	}

	public String getNguoiKy() {
		return nguoiKy;
	}

	public void setNguoiKy(String nguoiKy) {
		this.nguoiKy = nguoiKy;
	}

	public String getTrichYeu() {
		return trichYeu;
	}

	public void setTrichYeu(String trichYeu) {
		this.trichYeu = trichYeu;
	}

	public int getSoVanBan() {
		return soVanBan;
	}

	public void setSoVanBan(int soVanBan) {
		this.soVanBan = soVanBan;
	}

	protected String soCVDen;
	protected String soVaoSo;
	protected String tuNgay;
	protected String denNgay;
	protected long soHSCV;
	protected long loaiCV;
	protected String noiPhatHanh;
	protected long trangThai;
	protected String nguoiKy;
	protected String trichYeu;
	protected int soVanBan;
}
