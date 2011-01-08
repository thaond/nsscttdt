package com.sgs.portlet.documentrecord.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class DocumentRecordDisplayTerms extends DisplayTerms{
	
	public static final String LOAI_SO_CV = "loaiSoCV";
	public static final String SO_PB = "so";
	
	protected String loaiSoCV;
	protected String soPB;
	
	public DocumentRecordDisplayTerms(RenderRequest renderRequest) {
		super(renderRequest);
		loaiSoCV = ParamUtil.getString(renderRequest, LOAI_SO_CV);
		soPB = ParamUtil.getString(renderRequest, SO_PB);
	}

	public String getLoaiSoCV() {
		return loaiSoCV;
	}

	public void setLoaiSoCV(String loaiSoCV) {
		this.loaiSoCV = loaiSoCV;
	}

	public String getSoPB() {
		return soPB;
	}

	public void setSoPB(String soPB) {
		this.soPB = soPB;
	}
	
}
