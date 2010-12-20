package com.nss.portlet.linh_vuc_van_ban.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class LinhVucVanBanSearchTerms extends LinhVucVanBanDisplayTerms {

	public LinhVucVanBanSearchTerms(PortletRequest portletRequest) {
		super(portletRequest);
		tenLinhVucVanBan = DAOParamUtil.getLike(portletRequest, TEN_LINH_VUC_VB);
		moTa = DAOParamUtil.getLike(portletRequest, MO_TA);
	}

}
