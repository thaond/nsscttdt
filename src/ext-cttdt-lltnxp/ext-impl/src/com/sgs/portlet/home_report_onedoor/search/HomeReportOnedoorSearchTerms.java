package com.sgs.portlet.home_report_onedoor.search;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.util.ParamUtil;

public class HomeReportOnedoorSearchTerms extends HomeReportOnedoorDisplayTerms{

	public HomeReportOnedoorSearchTerms(RenderRequest renderRequest) {
		super(renderRequest);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		fromDate = ParamUtil.getString(renderRequest, FROMDATE , dateFormat.format(new Date()));
		toDate = ParamUtil.getString(renderRequest, TODATE, dateFormat.format(new Date()));
	}
}
