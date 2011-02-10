package com.sgs.portlet.home_report.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.util.ParamUtil;

public class HomeReportSearchTerms extends HomeReportDisplayTerms {
	public HomeReportSearchTerms(RenderRequest renderRequest) {
		super(renderRequest);

		departmentId = ParamUtil.getString(renderRequest, DEPARTMENTID);
		userId = ParamUtil.getLong(renderRequest, USERID);
		loaiThongKe = ParamUtil.getString(renderRequest, LOAITHONGKE);
		fromDate = ParamUtil.getString(renderRequest, FROMDATE);
		toDate = ParamUtil.getString(renderRequest, TODATE);

	}
}
