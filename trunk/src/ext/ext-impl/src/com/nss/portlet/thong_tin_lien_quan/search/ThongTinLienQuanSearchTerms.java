package com.nss.portlet.thong_tin_lien_quan.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class ThongTinLienQuanSearchTerms extends ThongTinLienQuanDisplayTerms{

	public ThongTinLienQuanSearchTerms(PortletRequest portletRequest) {
		super(portletRequest);
		tenThongTinLienQuan = DAOParamUtil.getLike(portletRequest, TEN_THONG_TIN_LIEN_QUAN);
		moTa = DAOParamUtil.getLike(portletRequest, MO_TA);
	}

}
