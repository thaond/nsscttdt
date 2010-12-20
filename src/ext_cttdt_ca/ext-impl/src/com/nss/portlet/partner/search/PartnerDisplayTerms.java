package com.nss.portlet.partner.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class PartnerDisplayTerms extends DisplayTerms {
	public static final String TEN_PARTNER = "tenPartner";
	public static final String MO_TA_PARTNER = "moTaPartner";
	
	protected String tenPartner;
	protected String moTaPartner;
	
	public PartnerDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);
		tenPartner = ParamUtil.getString(portletRequest, TEN_PARTNER);
		moTaPartner = ParamUtil.getString(portletRequest, MO_TA_PARTNER);
	}

	public String getTenPartner() {
		return tenPartner;
	}

	public void setTenPartner(String tenPartner) {
		this.tenPartner = tenPartner;
	}

	public String getMoTaPartner() {
		return moTaPartner;
	}

	public void setMoTaPartner(String moTaPartner) {
		this.moTaPartner = moTaPartner;
	}

}
