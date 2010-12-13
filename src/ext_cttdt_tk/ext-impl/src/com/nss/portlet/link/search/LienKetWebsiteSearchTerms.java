package com.nss.portlet.link.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class LienKetWebsiteSearchTerms extends LienKetWebsiteDisplayTerms{

	public LienKetWebsiteSearchTerms(PortletRequest portletRequest) {
		super(portletRequest);
		tenWebsite = DAOParamUtil.getLike(portletRequest, TEN_WEBSITE);
		moTa = DAOParamUtil.getLike(portletRequest, MO_TA);
	}

}
