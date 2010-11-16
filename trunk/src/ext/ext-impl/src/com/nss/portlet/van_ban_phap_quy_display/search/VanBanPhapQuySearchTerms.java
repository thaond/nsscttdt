package com.nss.portlet.van_ban_phap_quy_display.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;
import com.liferay.portal.kernel.util.ParamUtil;

public class VanBanPhapQuySearchTerms extends VanBanPhapQuyDisplayTerms{

	public VanBanPhapQuySearchTerms(PortletRequest portletRequest) {
		super(portletRequest);
		kyHieuVanBan = DAOParamUtil.getLike(portletRequest, KY_HIEU_VAN_BAN);
		tomTat = DAOParamUtil.getLike(portletRequest, TOM_TAT);
		nguoiKy = DAOParamUtil.getLike(portletRequest, NGUOI_KY);

		loaiVanBan = DAOParamUtil.getLike(portletRequest, LOAI_VAN_BAN);
		linhVucVanBan = DAOParamUtil.getLike(portletRequest, LINH_VUC_VAN_BAN);
		coQuanBanHanh = DAOParamUtil.getLike(portletRequest, CO_QUAN_BAN_HANH);
		
		maLoaiVanBan = ParamUtil.getLong(portletRequest, MA_LOAI_VAN_BAN);
		maLinhVucVanBan = ParamUtil.getLong(portletRequest, MA_LINH_VUC_VAN_BAN);
		maCoQuanBanHanh = ParamUtil.getLong(portletRequest, MA_CO_QUAN_BAN_HANH);
		
		tuNgay = ParamUtil.getString(portletRequest, TU_NGAY);
		denNgay = ParamUtil .getString(portletRequest, DEN_NGAY);
	}

}
