package com.nss.portlet.phone_book.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class ContactBookSearchTerms extends ContactBookDisplayTerms {

	public ContactBookSearchTerms(PortletRequest portletRequest) {
		super(portletRequest);
		contactBookCode = DAOParamUtil.getLike(portletRequest, CODE);
		contactBookName = DAOParamUtil.getLike(portletRequest, NAME);
		contactDescription = DAOParamUtil.getLike(portletRequest, DESCRIPTION);
	}
}
