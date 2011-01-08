package com.sgs.portlet.document.receipt.searchdocumentsend;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.util.ParamUtil;

public class PmlEdmDocumentSendSearchTerms extends PmlEdmDocumentSendDisplayTerms {

	public PmlEdmDocumentSendSearchTerms(RenderRequest renderRequest) {
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
}
