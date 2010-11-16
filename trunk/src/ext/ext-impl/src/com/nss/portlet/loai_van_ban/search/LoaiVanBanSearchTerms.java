package com.nss.portlet.loai_van_ban.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class LoaiVanBanSearchTerms extends LoaiVanBanDisplayTerms {

	public LoaiVanBanSearchTerms(PortletRequest portletRequest) {
		super(portletRequest);
		tenLoaiVanBan = DAOParamUtil.getLike(portletRequest, TEN_LOAI_VB);
		moTa = DAOParamUtil.getLike(portletRequest, MO_TA);
	}

}
