package com.nss.portlet.qa_cau_tra_loi.searchCauHoi;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;
import com.liferay.portal.kernel.util.ParamUtil;

public class QACauHoiSearchTerms extends QACauHoiDisplayTerms{

	public QACauHoiSearchTerms(PortletRequest portletRequest) {
		super(portletRequest);
		tieuDeCauHoi = DAOParamUtil.getLike(portletRequest, TIEU_DE_CAU_HOI);
		maChuDeCauHoi = ParamUtil.getLong(portletRequest, MA_CHU_DE_CAU_HOI, 0);
	}

}
