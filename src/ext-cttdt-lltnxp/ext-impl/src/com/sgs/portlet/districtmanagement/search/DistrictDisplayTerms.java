package com.sgs.portlet.districtmanagement.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class DistrictDisplayTerms  extends DisplayTerms{
	public static final String MA = "ma";
	public static final String TEN = "ten";
	public static final String MOTA = "mota";
	
	protected String ma;
	protected String ten;
	protected String mota;
	
	public DistrictDisplayTerms(RenderRequest renderRequest) {
		super(renderRequest);
		ma = ParamUtil.getString(renderRequest, MA);
		ten = ParamUtil.getString(renderRequest, TEN);
		mota = ParamUtil.getString(renderRequest, MOTA);
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

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}


}
