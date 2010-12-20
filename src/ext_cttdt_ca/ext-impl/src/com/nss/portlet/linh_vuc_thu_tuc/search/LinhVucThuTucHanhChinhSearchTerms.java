package com.nss.portlet.linh_vuc_thu_tuc.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class LinhVucThuTucHanhChinhSearchTerms extends LinhVucThuTucHanhChinhDisplayTerms {

	public LinhVucThuTucHanhChinhSearchTerms(PortletRequest portletRequest) {
		super(portletRequest);
		
		tenLinhVucThuTuc = DAOParamUtil.getLike(portletRequest, TEN_LINH_VUC_THU_TUC);
		moTa = DAOParamUtil.getLike(portletRequest, MO_TA);
	}

}
