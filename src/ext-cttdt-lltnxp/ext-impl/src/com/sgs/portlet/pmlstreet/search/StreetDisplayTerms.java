package com.sgs.portlet.pmlstreet.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class StreetDisplayTerms extends DisplayTerms {
	public static final String TEN = "tenDuong";
	
	protected String ten;
	

	public StreetDisplayTerms(RenderRequest renderRequest) {
		super(renderRequest);
		ten = ParamUtil.getString(renderRequest, TEN);
	}
	
	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}
}
