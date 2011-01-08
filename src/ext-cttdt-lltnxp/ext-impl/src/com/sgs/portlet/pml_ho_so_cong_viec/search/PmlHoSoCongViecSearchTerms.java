package com.sgs.portlet.pml_ho_so_cong_viec.search;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.RenderRequest;

/**
 * <a href="PmlHoSoCongViecSearchTerms.java.html"><b><i>View Source</i></b></a>
 *
 * @author XUANCONG
 *
 */
public class PmlHoSoCongViecSearchTerms extends PmlHoSoCongViecDisplayTerms {

	public PmlHoSoCongViecSearchTerms(RenderRequest renderRequest) {
		super(renderRequest);

		soHieuHSCV = DAOParamUtil.getLike(renderRequest, SOHIEUHSCV, false);
		tieuDe = DAOParamUtil.getLike(renderRequest, TIEUDE, false);
		idLinhVuc = ParamUtil.getString(renderRequest, IDLINHVUC);
		vanDeLienQuan = DAOParamUtil.getLike(renderRequest, VANDELIENQUAN, false);
		idDoQuanTrong = ParamUtil.getLong(renderRequest, IDDOQUANTRONG);
		idTrangThaiHSCV = ParamUtil.getLong(renderRequest, IDTRANGTHAIHSCV);
		tomTatNoiDung = DAOParamUtil.getLike(renderRequest, TOMTATNOIDUNG, false);
		hoatDong = DAOParamUtil.getString(renderRequest, HOATDONG);
		if (hoatDong == null) {
			hoatDong = "0";
		}
		else if (hoatDong.equals("on")) {
			hoatDong = "1";
		}
	}

	public void setSoHieuHSCV(String soHieuHSCV) {
		this.soHieuHSCV = soHieuHSCV;
	}

	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}

	public void setIdLinhVuc(String idLinhVuc) {
		this.idLinhVuc = idLinhVuc;
	}

	public void setVanDeLienQuan(String vanDeLienQuan) {
		this.vanDeLienQuan = vanDeLienQuan;
	}

	public void setIdDoQuanTrong(long idDoQuanTrong) {
		this.idDoQuanTrong = idDoQuanTrong;
	}

	public void setIdTrangThaiHSCV(long idTrangThaiHSCV) {
		this.idTrangThaiHSCV = idTrangThaiHSCV;
	}

	public void setTomTatNoiDung(String tomTatNoiDung) {
		this.tomTatNoiDung = tomTatNoiDung;
	}

	public void setHoatDong(String hoatDong) {
		this.hoatDong = hoatDong;
	}
}