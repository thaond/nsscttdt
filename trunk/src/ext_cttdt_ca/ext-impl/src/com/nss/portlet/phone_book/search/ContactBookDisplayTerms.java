package com.nss.portlet.phone_book.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class ContactBookDisplayTerms extends DisplayTerms{
	public static final String CODE = "contactBookCode";
	public static final String NAME = "contactBookName";
	public static final String DESCRIPTION = "contactDescription";
	
	protected String contactBookCode;
	protected String contactBookName;
	protected String contactDescription;

	public ContactBookDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);
		contactBookCode = ParamUtil.getString(portletRequest, CODE);
		contactBookName = ParamUtil.getString(portletRequest, NAME);
		contactDescription = ParamUtil.getString(portletRequest, DESCRIPTION);
	}

	public String getContactBookCode() {
		return contactBookCode;
	}

	public void setContactBookCode(String contactBookCode) {
		this.contactBookCode = contactBookCode;
	}

	public String getContactBookName() {
		return contactBookName;
	}

	public void setContactBookName(String contactBookName) {
		this.contactBookName = contactBookName;
	}

	public String getContactDescription() {
		return contactDescription;
	}

	public void setContactDescription(String contactDescription) {
		this.contactDescription = contactDescription;
	}

}
