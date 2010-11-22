package com.nss.portlet.image_signer.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class UserSearchTerms extends UserDisplayTerms {

	public UserSearchTerms(PortletRequest portletRequest) {
		super(portletRequest);
		firstname = DAOParamUtil.getLike(portletRequest, FIRSTNAME);
		middlename = DAOParamUtil.getLike(portletRequest, MIDDLENAME);
		lastname = DAOParamUtil.getLike(portletRequest, LASTNAME);
	}
}
