package com.nss.portlet.nss_don_vi_thu_tuc.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class DonViThuTucSearchTerms extends DonViThuTucDisplayTerms {

	public DonViThuTucSearchTerms(PortletRequest portletRequest) {
		super(portletRequest);
		
		tenDonViThuTuc = DAOParamUtil.getLike(portletRequest, TEN_DON_VI_THU_TUC);
		moTa = DAOParamUtil.getLike(portletRequest, MO_TA);
	}

}
