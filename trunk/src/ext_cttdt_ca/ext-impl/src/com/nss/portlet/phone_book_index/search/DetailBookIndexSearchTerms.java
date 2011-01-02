package com.nss.portlet.phone_book_index.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class DetailBookIndexSearchTerms extends DetailBookIndexDisplayTerms {

	public DetailBookIndexSearchTerms(PortletRequest portletRequest) {
		super(portletRequest);
		detailBookCode = DAOParamUtil.getLike(portletRequest, CODE);
		detailBookName = DAOParamUtil.getLike(portletRequest, NAME);
		detailDescription = DAOParamUtil.getLike(portletRequest, DESCRIPTION);
		zip = DAOParamUtil.getLike(portletRequest,ZIP);
		internal = DAOParamUtil.getLike(portletRequest,INTERNAL);
		home = DAOParamUtil.getLike(portletRequest,HOME);
		mobile = DAOParamUtil.getLike(portletRequest,MOBILE);
		email = DAOParamUtil.getLike(portletRequest, EMAIL);
	}
}

