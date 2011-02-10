package com.sgs.portlet.citymanagement.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class CityDisplayTerms extends DisplayTerms{
	public static final String MA = "ma";
	public static final String TEN = "ten";
	
	protected String ma;
	protected String ten;
	
	public CityDisplayTerms(RenderRequest renderRequest) {
		super(renderRequest);
		ma = ParamUtil.getString(renderRequest, MA);
		ten = ParamUtil.getString(renderRequest, TEN);
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


}
