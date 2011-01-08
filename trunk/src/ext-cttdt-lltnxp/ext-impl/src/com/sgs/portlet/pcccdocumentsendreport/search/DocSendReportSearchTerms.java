package com.sgs.portlet.pcccdocumentsendreport.search;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

import javax.portlet.RenderRequest;

/**
 *
 * @author XUANCONG
 *
 */
public class DocSendReportSearchTerms extends DocSendReportDisplayTerms {

	public DocSendReportSearchTerms(RenderRequest renderRequest) {
		super(renderRequest);

		soPH = DAOParamUtil.getLike(renderRequest, SOPH, true);
		ngayPHMonth = DAOParamUtil.getInteger(renderRequest, NGAYPHMONTH);
		ngayPHYear = DAOParamUtil.getInteger(renderRequest, NGAYPHYEAR);
		phongST = DAOParamUtil.getString(renderRequest, PHONGST);
		noiNhan = DAOParamUtil.getLike(renderRequest, NOINHAN, true);
		loaiVB = DAOParamUtil.getLong(renderRequest, LOAIVB);
		nguoiKy = DAOParamUtil.getLike(renderRequest, NGUOIKY, true);
		nguoiST = DAOParamUtil.getLong(renderRequest, NGUOIST);
		trichYeu = DAOParamUtil.getLike(renderRequest, TRICHYEU, true);
		vanBanPH = DAOParamUtil.getString(renderRequest, VANBANPH);
	}

	public void setSoPH(String soPH) {
		this.soPH = soPH;
	}

	public void setNgayPHMonth(int ngayPHMonth) {
		this.ngayPHMonth = ngayPHMonth;
	}

	public void setNgayPHYear(int ngayPHYear) {
		this.ngayPHYear = ngayPHYear;
	}

	public void setPhongST(String phongST) {
		this.phongST = phongST;
	}

	public void setNoiNhan(String noiNhan) {
		this.noiNhan = noiNhan;
	}

	public void setLoaiVB(long loaiVB) {
		this.loaiVB = loaiVB;
	}

	public void setNguoiKy(String nguoiKy) {
		this.nguoiKy = nguoiKy;
	}

	public void setNguoiST(long nguoiST) {
		this.nguoiST = nguoiST;
	}
	
	public void setTrichYeu(String trichYeu) {
		this.trichYeu = trichYeu;
	}
	
	public void setVanBanPH(String vanBanPH) {
		this.vanBanPH = vanBanPH;
	}
}