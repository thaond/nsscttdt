package com.nss.portlet.necessary_info.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class ThongTinCanThietSearchTerms extends ThongTinCanThietDisplayTerms{

	public ThongTinCanThietSearchTerms(PortletRequest portletRequest) {
		super(portletRequest);
		tenThongTinCanThiet = DAOParamUtil.getLike(portletRequest, TEN_THONG_TIN_CAN_THIET);
		moTa = DAOParamUtil.getLike(portletRequest, MO_TA);
	}

}
