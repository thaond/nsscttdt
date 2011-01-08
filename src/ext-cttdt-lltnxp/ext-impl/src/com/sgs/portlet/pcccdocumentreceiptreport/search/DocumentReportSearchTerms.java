package com.sgs.portlet.pcccdocumentreceiptreport.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.util.ParamUtil;

public class DocumentReportSearchTerms extends	DocumentReportDisplayTerms {
	public DocumentReportSearchTerms(RenderRequest renderRequest) {
		super(renderRequest);

		departmentId = ParamUtil.getString(renderRequest, DEPARTMENTID);
		userId = ParamUtil.getLong(renderRequest, USERID);
		nhomCongVan = ParamUtil.getInteger(renderRequest, NHOMCONGVAN);
		loaiCongVan = ParamUtil.getString(renderRequest, LOAICONGVAN);
		fromDate = ParamUtil.getString(renderRequest, FROMDATE);
		toDate = ParamUtil.getString(renderRequest, TODATE);
		radioTenPhongBan = ParamUtil.getBoolean(renderRequest, RADIOTENPHONGBAN);
		radioTenChuyenVien = ParamUtil.getBoolean(renderRequest, RADIOTENCHUYENVIEN);
		doMat = ParamUtil.getString(renderRequest, DOMAT);
	}
}
