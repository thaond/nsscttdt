package com.sgs.portlet.pcccdocumentrecordto.search;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

import javax.portlet.RenderRequest;

/**
 *
 * @author XUANCONG
 *
 */
public class DocumentRecordToSearchTerms extends DocumentRecordToDisplayTerms {

	public DocumentRecordToSearchTerms(RenderRequest renderRequest) {
		super(renderRequest);

		soNoiBo = DAOParamUtil.getLike(renderRequest, SONOIBO, true);
		soHieuGoc = DAOParamUtil.getLike(renderRequest, SOHIEUGOC, true);
		ngayPHDay = DAOParamUtil.getInteger(renderRequest, NGAYPHDAY);
		ngayPHMonth = DAOParamUtil.getInteger(renderRequest, NGAYPHMONTH);
		ngayPHYear = DAOParamUtil.getInteger(renderRequest, NGAYPHYEAR);
		capGui = DAOParamUtil.getLong(renderRequest, CAPGUI);
		noiPhatHanh = DAOParamUtil.getLike(renderRequest, NOIPHATHANH, true);
		uuTien = DAOParamUtil.getString(renderRequest, UUTIEN);
		ngayDenDay = DAOParamUtil.getInteger(renderRequest, NGAYDENDAY);
		ngayDenMonth = DAOParamUtil.getInteger(renderRequest, NGAYDENMONTH);
		ngayDenYear = DAOParamUtil.getInteger(renderRequest, NGAYDENYEAR);
		loaiVB = DAOParamUtil.getLong(renderRequest, LOAIVB);
		phongBan = DAOParamUtil.getString(renderRequest, PHONGBAN);
		trichYeu = DAOParamUtil.getLike(renderRequest, TRICHYEU, true);
	}

	public void setSoNoiBo(String soNoiBo) {
		this.soNoiBo = soNoiBo;
	}

	public void setSoHieuGoc(String soHieuGoc) {
		this.soHieuGoc = soHieuGoc;
	}

	public void setNgayPHDay(int ngayPHDay) {
		this.ngayPHDay = ngayPHDay;
	}

	public void setNgayPHMonth(int ngayPHMonth) {
		this.ngayPHMonth = ngayPHMonth;
	}

	public void setNgayPHYear(int ngayPHYear) {
		this.ngayPHYear = ngayPHYear;
	}

	public void setCapGui(long capGui) {
		this.capGui = capGui;
	}

	public void setNoiPhatHanh(String noiPhatHanh) {
		this.noiPhatHanh = noiPhatHanh;
	}

	public void setUuTien(String uuTien) {
		this.uuTien = uuTien;
	}
	
	public void setNgayDenDay(int ngayDenDay) {
		this.ngayDenDay = ngayDenDay;
	}

	public void setNgayDenMonth(int ngayDenMonth) {
		this.ngayDenMonth = ngayDenMonth;
	}

	public void setNgayDenYear(int ngayDenYear) {
		this.ngayDenYear = ngayDenYear;
	}

	public void setLoaiVB(long loaiVB) {
		this.loaiVB = loaiVB;
	}

	public void setPhongBan(String phongBan) {
		this.phongBan = phongBan;
	}
	
	public void setTrichYeu(String trichYeu) {
		this.trichYeu = trichYeu;
	}
}