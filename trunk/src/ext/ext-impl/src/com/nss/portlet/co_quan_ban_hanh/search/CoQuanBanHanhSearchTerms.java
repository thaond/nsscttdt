package com.nss.portlet.co_quan_ban_hanh.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class CoQuanBanHanhSearchTerms extends CoQuanBanHanhDisplayTerms{

	public CoQuanBanHanhSearchTerms(PortletRequest portletRequest) {
		super(portletRequest);
		tenCoQuanBanHanh = DAOParamUtil.getLike(portletRequest, TEN_CO_QUAN_BAN_HANH);
		moTa = DAOParamUtil.getLike(portletRequest, MO_TA);
	}

}
