package com.nss.portlet.phone_book.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class DetailBookDisplayTerms extends DisplayTerms{
	public static final String CODE = "detailBookCode";
	public static final String NAME = "detailBookName";
	public static final String DESCRIPTION = "detailDescription";
	
	protected String detailBookCode;
	protected String detailBookName;
	protected String detailDescription;

	public DetailBookDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);
		detailBookCode = ParamUtil.getString(portletRequest, CODE);
		detailBookName = ParamUtil.getString(portletRequest, NAME);
		detailDescription = ParamUtil.getString(portletRequest, DESCRIPTION);
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
}
