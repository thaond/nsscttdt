package com.nss.portlet.agency.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class AgencyDisplayTerms extends DisplayTerms{
	public static final String MA = "ma";
	public static final String HO = "ho";
	public static final String TEN = "ten";
	public static final String TENCOQUAN = "tenCoQuan";
	
	protected String ma;
	protected String ho;
	protected String ten;
	protected String tenCoQuan;
	
	public AgencyDisplayTerms(RenderRequest renderRequest) {
		super(renderRequest);
		ma = ParamUtil.getString(renderRequest, MA);
		ho = ParamUtil.getString(renderRequest, HO);
		ten = ParamUtil.getString(renderRequest, TEN);
		tenCoQuan = ParamUtil.getString(renderRequest, TENCOQUAN);
		
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

	public String getTenCoQuan() {
		return tenCoQuan;
	}

	public void setTenCoQuan(String tenCoQuan) {
		this.tenCoQuan = tenCoQuan;
	}

	public String getHo() {
		return ho;
	}

	public void setHo(String ho) {
		this.ho = ho;
	}

	
}
