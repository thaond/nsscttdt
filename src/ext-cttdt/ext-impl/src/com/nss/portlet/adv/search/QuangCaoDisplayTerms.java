package com.nss.portlet.adv.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class QuangCaoDisplayTerms extends DisplayTerms {
	public static final String TEN_QUANG_CAO = "tenQuangCao";
	public static final String MO_TA = "moTa";
	
	protected String tenQuangCao;
	protected String moTa;
	public QuangCaoDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);
		tenQuangCao = ParamUtil.getString(portletRequest, TEN_QUANG_CAO);
		moTa = ParamUtil.getString(portletRequest, MO_TA);
	}
	public String getTenQuangCao() {
		return tenQuangCao;
	}
	public void setTenQuangCao(String tenQuangCao) {
		this.tenQuangCao = tenQuangCao;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

}
