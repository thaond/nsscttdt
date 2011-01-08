package com.sgs.portlet.pcccdocumentsendprocess.search;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;
import javax.portlet.RenderRequest;

public class PmlEdmDocumentRelationSendDisplayTerms extends DisplayTerms {
	
	public static final String SOPHATHANH = "soPhatHanh";
	public static final String PHONGSOANTHAO = "phongSoanThao";
	public static final String NOINHAN = "noiNhan";
	public static final String TRICHYEU = "trichYeu";

	public PmlEdmDocumentRelationSendDisplayTerms(RenderRequest renderRequest) {
		super(renderRequest);

		soPhatHanh = ParamUtil.getString(renderRequest, SOPHATHANH);
		phongSoanThao = ParamUtil.getString(renderRequest, PHONGSOANTHAO);
		noiNhan = ParamUtil.getString(renderRequest, NOINHAN);
		trichYeu = ParamUtil.getString(renderRequest, TRICHYEU);
	}

	public String getSoPhatHanh() {
		return soPhatHanh;
	}

	public String getPhongSoanThao() {
		return phongSoanThao;
	}

	public String getNoiNhan() {
		return noiNhan;
	}

	public String getTrichYeu() {
		return trichYeu;
	}

	protected String soPhatHanh;
	protected String phongSoanThao;
	protected String noiNhan;
	protected String trichYeu;
}