package com.nss.portlet.phone_book.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class DetailBookSearchTerms extends DetailBookDisplayTerms {

	public DetailBookSearchTerms(PortletRequest portletRequest) {
		super(portletRequest);
		detailBookCode = DAOParamUtil.getLike(portletRequest, CODE);
		detailBookName = DAOParamUtil.getLike(portletRequest, NAME);
		detailDescription = DAOParamUtil.getLike(portletRequest, DESCRIPTION);
	}
}
