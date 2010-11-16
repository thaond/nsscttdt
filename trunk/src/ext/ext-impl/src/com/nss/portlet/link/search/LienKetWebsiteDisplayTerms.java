package com.nss.portlet.link.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class LienKetWebsiteDisplayTerms extends DisplayTerms {
	public static final String TEN_WEBSITE = "tenWebsite";
	public static final String MO_TA = "moTa";
	
	protected String tenWebsite;
	protected String moTa;
	
	public LienKetWebsiteDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);
		tenWebsite = ParamUtil.getString(portletRequest, TEN_WEBSITE);
		moTa = ParamUtil.getString(portletRequest, MO_TA);
	}

	public String getTenWebsite() {
		return tenWebsite;
	}

	public void setTenWebsite(String tenWebsite) {
		this.tenWebsite = tenWebsite;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

}
