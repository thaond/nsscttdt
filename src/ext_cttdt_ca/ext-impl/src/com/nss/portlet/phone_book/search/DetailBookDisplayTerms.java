package com.nss.portlet.phone_book.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class DetailBookDisplayTerms extends DisplayTerms{
	public static final String CODE = "detailBookCode";
	public static final String NAME = "detailBookName";
	public static final String DESCRIPTION = "detailDescription";
	public static final String ZIP = "zip";
	public static final String INTERNAL = "internal";
	public static final String HOME = "home";
	public static final String MOBILE = "mobile";
	public static final String EMAIL = "email";
	
	protected String detailBookCode;
	protected String detailBookName;
	protected String detailDescription;
	protected String zip;
	protected String internal;
	protected String home;
	protected String mobile;
	protected String email;

	public DetailBookDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);
		detailBookCode = ParamUtil.getString(portletRequest, CODE);
		detailBookName = ParamUtil.getString(portletRequest, NAME);
		detailDescription = ParamUtil.getString(portletRequest, DESCRIPTION);
		zip = ParamUtil.getString(portletRequest,ZIP);
		internal = ParamUtil.getString(portletRequest,INTERNAL);
		home = ParamUtil.getString(portletRequest,HOME);
		mobile = ParamUtil.getString(portletRequest,MOBILE);
		email = ParamUtil.getString(portletRequest,EMAIL);
	}

	public String getDetailBookCode() {
		return detailBookCode;
	}

	public void setDetailBookCode(String detailBookCode) {
		this.detailBookCode = detailBookCode;
	}

	public String getDetailBookName() {
		return detailBookName;
	}

	public void setDetailBookName(String detailBookName) {
		this.detailBookName = detailBookName;
	}

	public String getDetailDescription() {
		return detailDescription;
	}

	public void setDetailDescription(String detailDescription) {
		this.detailDescription = detailDescription;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getInternal() {
		return internal;
	}

	public void setInternal(String internal) {
		this.internal = internal;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
