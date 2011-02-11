package com.sgs.portlet.position.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class PositionDisplayTerms extends DisplayTerms {

	public static final String MA = "ma";
	public static final String TEN = "ten";
	public static final String MOTA = "moTa";

	protected String ma;
	protected String ten;
	protected String moTa;

	public PositionDisplayTerms(RenderRequest renderRequest) {
		super(renderRequest);
		ma = ParamUtil.getString(renderRequest, MA);
		ten = ParamUtil.getString(renderRequest, TEN);
		moTa = ParamUtil.getString(renderRequest, MOTA);

	}

	public String getMa() {
		return ma;
	}

	public void setMa(String ma) {
		this.ma = ma;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

}
