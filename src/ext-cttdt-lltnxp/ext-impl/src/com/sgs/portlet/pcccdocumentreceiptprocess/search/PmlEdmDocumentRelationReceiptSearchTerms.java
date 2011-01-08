package com.sgs.portlet.pcccdocumentreceiptprocess.search;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

import javax.portlet.RenderRequest;

public class PmlEdmDocumentRelationReceiptSearchTerms extends PmlEdmDocumentRelationReceiptDisplayTerms {

	public PmlEdmDocumentRelationReceiptSearchTerms(RenderRequest renderRequest) {
		super(renderRequest);

		soNoiBo = DAOParamUtil.getLike(renderRequest, SONOIBO, true);
		soHieuGoc = DAOParamUtil.getLike(renderRequest, SOHIEUGOC, true);
		noiPhatHanh = DAOParamUtil.getLike(renderRequest, NOIPHATHANH, true);
		ngayPhatHanhTu = DAOParamUtil.getString(renderRequest, NGAYPHATHANHTU);
		ngayPhatHanhDen = DAOParamUtil.getString(renderRequest, NGAYPHATHANHDEN);
		trichYeu = DAOParamUtil.getLike(renderRequest, TRICHYEU, true);
	}

	public void setSoNoiBo(String soNoiBo) {
		this.soNoiBo = soNoiBo;
	}

	public void setSoHieuGoc(String soHieuGoc) {
		this.soHieuGoc = soHieuGoc;
	}

	public void setNoiPhatHanh(String noiPhatHanh) {
		this.noiPhatHanh = noiPhatHanh;
	}

	public void setNgayPhatHanhTu(String ngayPhatHanhTu) {
		this.ngayPhatHanhTu = ngayPhatHanhTu;
	}

	public void setNgayPhatHanhDen(String ngayPhatHanhDen) {
		this.ngayPhatHanhDen = ngayPhatHanhDen;
	}

	public void setTrichYeu(String trichYeu) {
		this.trichYeu = trichYeu;
	}
}