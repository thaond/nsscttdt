package com.nss.portlet.adv.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class QuangCaoSearchTerms extends QuangCaoDisplayTerms{

	public QuangCaoSearchTerms(PortletRequest portletRequest) {
		super(portletRequest);
		tenQuangCao = DAOParamUtil.getLike(portletRequest, TEN_QUANG_CAO);
		moTa = DAOParamUtil.getLike(portletRequest, MO_TA);
	}

}
