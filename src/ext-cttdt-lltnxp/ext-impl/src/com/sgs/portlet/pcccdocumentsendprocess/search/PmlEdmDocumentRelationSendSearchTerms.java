package com.sgs.portlet.pcccdocumentsendprocess.search;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

import javax.portlet.RenderRequest;

public class PmlEdmDocumentRelationSendSearchTerms extends PmlEdmDocumentRelationSendDisplayTerms {

	public PmlEdmDocumentRelationSendSearchTerms(RenderRequest renderRequest) {
		super(renderRequest);

		soPhatHanh = DAOParamUtil.getLike(renderRequest, SOPHATHANH, true);
		phongSoanThao = DAOParamUtil.getLike(renderRequest, PHONGSOANTHAO, true);
		noiNhan = DAOParamUtil.getLike(renderRequest, NOINHAN, true);
		trichYeu = DAOParamUtil.getLike(renderRequest, TRICHYEU, true);
	}

	public void setSoPhatHanh(String soPhatHanh) {
		this.soPhatHanh = soPhatHanh;
	}

	public void setPhongSoanThao(String phongSoanThao) {
		this.phongSoanThao = phongSoanThao;
	}

	public void setNoiNhan(String noiNhan) {
		this.noiNhan = noiNhan;
	}

	public void setTrichYeu(String trichYeu) {
		this.trichYeu = trichYeu;
	}
}