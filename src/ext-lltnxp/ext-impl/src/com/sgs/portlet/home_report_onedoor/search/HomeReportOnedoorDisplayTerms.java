package com.sgs.portlet.home_report_onedoor.search;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class HomeReportOnedoorDisplayTerms extends DisplayTerms {

	public static final String FROMDATE = "fromDate";
	public static final String TODATE = "toDate";
	
	protected String fromDate;
	protected String toDate;
	
	public HomeReportOnedoorDisplayTerms(RenderRequest renderRequest) {
		super(renderRequest);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		fromDate = ParamUtil.getString(renderRequest, FROMDATE , dateFormat.format(new Date()));
		toDate = ParamUtil.getString(renderRequest, TODATE, dateFormat.format(new Date()));
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

}
