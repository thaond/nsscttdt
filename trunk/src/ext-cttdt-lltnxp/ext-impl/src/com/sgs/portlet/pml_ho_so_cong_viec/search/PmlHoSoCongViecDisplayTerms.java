package com.sgs.portlet.pml_ho_so_cong_viec.search;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.Date;

import javax.portlet.RenderRequest;

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
		}
		else if (hoatDong.equals("on")) {
			hoatDong = "1";
		}
	}

	public String getSoHieuHSCV() {
		return soHieuHSCV;
	}

	public String getTieuDe() {
		return tieuDe;
	}

	public Date getNgayMoHSCV() {
		return ngayMoHSCV;
	}

	public String getIdLinhVuc() {
		return idLinhVuc;
	}

	public String getVanDeLienQuan() {
		return vanDeLienQuan;
	}

	public long getIdDoQuanTrong() {
		return idDoQuanTrong;
	}

	public long getIdTrangThaiHSCV() {
		return idTrangThaiHSCV;
	}

	public String getTomTatNoiDung() {
		return tomTatNoiDung;
	}

	public String getHoatDong() {
		return hoatDong;
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