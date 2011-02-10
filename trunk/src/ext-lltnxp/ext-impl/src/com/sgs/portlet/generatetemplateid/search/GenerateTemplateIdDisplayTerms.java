package com.sgs.portlet.generatetemplateid.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class GenerateTemplateIdDisplayTerms extends DisplayTerms{
	public static final String DINHDANG = "dinhDang";
	public static final String MOTA = "moTa";
	
	protected String dinhDang;
	protected String moTa;
	
	public GenerateTemplateIdDisplayTerms(RenderRequest renderRequest) {
		super(renderRequest);
		dinhDang = ParamUtil.getString(renderRequest, DINHDANG);
		moTa = ParamUtil.getString(renderRequest, MOTA);
	}

	public String getDinhDang() {
		return dinhDang;
	}

	public void setDinhDang(String dinhDang) {
		this.dinhDang = dinhDang;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	
}
