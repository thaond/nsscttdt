package com.sgs.portlet.pcccdocumentreceiptprocess.search;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;
import javax.portlet.RenderRequest;

public class PmlEdmDocumentRelationReceiptDisplayTerms extends DisplayTerms {
	
	public static final String SOHIEUGOC = "soHieuGoc";
	public static final String SONOIBO = "soNoiBo";
	public static final String NOIPHATHANH = "noiPhatHanh";
	public static final String NGAYPHATHANHTU = "ngayPhatHanhTu";
	public static final String NGAYPHATHANHDEN = "ngayPhatHanhDen";
	public static final String TRICHYEU = "trichYeu";

	public PmlEdmDocumentRelationReceiptDisplayTerms(RenderRequest renderRequest) {
		super(renderRequest);

		soNoiBo = ParamUtil.getString(renderRequest, SONOIBO);
		soHieuGoc = ParamUtil.getString(renderRequest, SOHIEUGOC);
		noiPhatHanh = ParamUtil.getString(renderRequest, NOIPHATHANH);
		ngayPhatHanhTu = ParamUtil.getString(renderRequest, NGAYPHATHANHTU);
		ngayPhatHanhDen = ParamUtil.getString(renderRequest, NGAYPHATHANHDEN);
		trichYeu = ParamUtil.getString(renderRequest, TRICHYEU);
	}

	public String getSoNoiBo() {
		return soNoiBo;
	}

	public String getSoHieuGoc() {
		return soHieuGoc;
	}

	public String getNoiPhatHanh() {
		return noiPhatHanh;
	}

	public String getNgayPhatHanhTu() {
		return ngayPhatHanhTu;
	}

	public String getNgayPhatHanhDen() {
		return ngayPhatHanhDen;
	}

	public String getTrichYeu() {
		return trichYeu;
	}

	protected String soNoiBo;
	protected String soHieuGoc;
	protected String noiPhatHanh;
	protected String ngayPhatHanhTu;
	protected String ngayPhatHanhDen;
	protected String trichYeu;
}