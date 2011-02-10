/**
 * 
 */
package com.sgs.portlet.document.receipt.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.util.ParamUtil;

/**
 * @author DienNH
 *
 */
public class PmlEdmDocumentReceiptSearchTerms extends PmlEdmDocumentReceiptDisplayTerms {

	/**
	 * 
	 */
	public PmlEdmDocumentReceiptSearchTerms(RenderRequest req) {
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
	}

}
