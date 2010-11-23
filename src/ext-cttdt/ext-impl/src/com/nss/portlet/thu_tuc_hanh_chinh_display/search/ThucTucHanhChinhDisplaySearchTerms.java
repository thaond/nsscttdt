package com.nss.portlet.thu_tuc_hanh_chinh_display.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;
import com.liferay.portal.kernel.util.ParamUtil;

public class ThucTucHanhChinhDisplaySearchTerms extends ThucTucHanhChinhDisplayDisplayTerms{

	public ThucTucHanhChinhDisplaySearchTerms(PortletRequest portletRequest) {
		super(portletRequest);
		tenThuTucHanhChinh = DAOParamUtil.getLike(portletRequest, TEN_THU_TUC_HANH_CHINH);
		linhVucThuTuc = ParamUtil.getLong(portletRequest, LINH_VUC_THU_TUC);
		capDonViThuTuc = ParamUtil.getLong(portletRequest, CAP_DON_VI_THU_TUC, 1);
		donViThuTuc = ParamUtil.getLong(portletRequest, DON_VI_THU_TUC);
	}

}
