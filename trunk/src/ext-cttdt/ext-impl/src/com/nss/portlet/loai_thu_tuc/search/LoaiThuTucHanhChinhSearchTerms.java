package com.nss.portlet.loai_thu_tuc.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class LoaiThuTucHanhChinhSearchTerms extends LoaiThuTucHanhChinhDisplayTerms {

	public LoaiThuTucHanhChinhSearchTerms(PortletRequest portletRequest) {
		super(portletRequest);
		tenLoaiThuTucHanhChinh = DAOParamUtil.getLike(portletRequest, TEN_LOAI_THU_TUC);
		moTa = DAOParamUtil.getLike(portletRequest, MO_TA);
	}

}
