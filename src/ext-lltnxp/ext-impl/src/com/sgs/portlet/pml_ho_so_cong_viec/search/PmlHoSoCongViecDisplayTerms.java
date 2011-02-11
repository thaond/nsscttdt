package com.sgs.portlet.pml_ho_so_cong_viec.search;

import java.util.Date;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

/**
 * <a href="PmlHoSoCongViecDisplayTerms.java.html"><b><i>View Source</i></b></a>
 * 
 * @author XUANCONG
 * 
 */
public class PmlHoSoCongViecDisplayTerms extends DisplayTerms {

	public static final String SOHIEUHSCV = "soHieuHSCV";

	public static final String TIEUDE = "tieuDe";

	public static final String NGAYMOHSCV = "ngayMoHSCV";

	public static final String IDLINHVUC = "idLinhVuc";

	public static final String VANDELIENQUAN = "vanDeLienQuan";

	public static final String IDDOQUANTRONG = "idDoQuanTrong";

	public static final String IDTRANGTHAIHSCV = "idTrangThaiHSCV";

	public static final String TOMTATNOIDUNG = "tomTatNoiDung";

	public static final String HOATDONG = "hoatDong";

	public PmlHoSoCongViecDisplayTerms(RenderRequest renderRequest) {
		super(renderRequest);

		soHieuHSCV = ParamUtil.getString(renderRequest, SOHIEUHSCV);
		tieuDe = ParamUtil.getString(renderRequest, TIEUDE);
		// Con thieu ngay
		idLinhVuc = ParamUtil.getString(renderRequest, IDLINHVUC);
		vanDeLienQuan = ParamUtil.getString(renderRequest, VANDELIENQUAN);
		idDoQuanTrong = ParamUtil.getLong(renderRequest, IDDOQUANTRONG);
		idTrangThaiHSCV = ParamUtil.getLong(renderRequest, IDTRANGTHAIHSCV);
		tomTatNoiDung = ParamUtil.getString(renderRequest, TOMTATNOIDUNG);
		hoatDong = ParamUtil.getString(renderRequest, HOATDONG);

		if (hoatDong == null) {
			hoatDong = "0";
		} else if (hoatDong.equals("on")) {
			hoatDong = "1";
		}
	}

	public String getSoHieuHSCV() {
		return soHieuHSCV;
	}

	public void setSoHieuHSCV(String soHieuHSCV) {
		this.soHieuHSCV = soHieuHSCV;
	}

	public String getTieuDe() {
		return tieuDe;
	}

	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}

	public Date getNgayMoHSCV() {
		return ngayMoHSCV;
	}

	public void setNgayMoHSCV(Date ngayMoHSCV) {
		this.ngayMoHSCV = ngayMoHSCV;
	}

	public String getIdLinhVuc() {
		return idLinhVuc;
	}

	public void setIdLinhVuc(String idLinhVuc) {
		this.idLinhVuc = idLinhVuc;
	}

	public String getVanDeLienQuan() {
		return vanDeLienQuan;
	}

	public void setVanDeLienQuan(String vanDeLienQuan) {
		this.vanDeLienQuan = vanDeLienQuan;
	}

	public long getIdDoQuanTrong() {
		return idDoQuanTrong;
	}

	public void setIdDoQuanTrong(long idDoQuanTrong) {
		this.idDoQuanTrong = idDoQuanTrong;
	}

	public long getIdTrangThaiHSCV() {
		return idTrangThaiHSCV;
	}

	public void setIdTrangThaiHSCV(long idTrangThaiHSCV) {
		this.idTrangThaiHSCV = idTrangThaiHSCV;
	}

	public String getTomTatNoiDung() {
		return tomTatNoiDung;
	}

	public void setTomTatNoiDung(String tomTatNoiDung) {
		this.tomTatNoiDung = tomTatNoiDung;
	}

	public String getHoatDong() {
		return hoatDong;
	}

	public void setHoatDong(String hoatDong) {
		this.hoatDong = hoatDong;
	}

	protected String soHieuHSCV;
	protected String tieuDe;
	protected Date ngayMoHSCV;
	protected String idLinhVuc;
	protected String vanDeLienQuan;
	protected long idDoQuanTrong;
	protected long idTrangThaiHSCV;
	protected String tomTatNoiDung;
	protected String hoatDong;
}