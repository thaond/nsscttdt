package com.nss.portlet.link.searchLoaiWebsite;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class LoaiWebsiteSearchTerms extends LoaiWebsiteDisplayTerms{

	public LoaiWebsiteSearchTerms(PortletRequest portletRequest) {
		super(portletRequest);
		tenLoaiWebsite = DAOParamUtil.getLike(portletRequest, TEN_LOAI_WEBSITE);
		moTaLoai = DAOParamUtil.getLike(portletRequest, MO_TA_LOAI);
	}

}
