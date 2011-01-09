package com.sgs.portlet.report_registry_work.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class ReportRegistryDisplayTerms extends DisplayTerms {

	public static final String REPORTREGISTRYCODE = "reportRegistryCode";
	public static final String RESULTWORK = "resultWork";
	public static final String PROGRAMWORK = "programWork";
	public static final String REPORTDATE = "reportDate";

	protected String reportRegistryCode;
	protected String resultWork;
	protected String programWork;
	protected String reportDate;

	public ReportRegistryDisplayTerms(RenderRequest renderRequest) {
		super(renderRequest);
		reportRegistryCode = ParamUtil.getString(renderRequest, REPORTREGISTRYCODE);
		resultWork = ParamUtil.getString(renderRequest, RESULTWORK);
		programWork = ParamUtil.getString(renderRequest, PROGRAMWORK);
		reportDate = ParamUtil.getString(renderRequest, REPORTDATE);

	}

	public String getReportRegistryCode() {
		return reportRegistryCode;
	}

	public void setReportRegistryCode(String reportRegistryCode) {
		this.reportRegistryCode = reportRegistryCode;
	}

	public String getResultWork() {
		return resultWork;
	}

	public void setResultWork(String resultWork) {
		this.resultWork = resultWork;
	}

	public String getProgramWork() {
		return programWork;
	}

	public void setProgramWork(String programWork) {
		this.programWork = programWork;
	}

	public String getReportDate() {
		return reportDate;
	}

	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}

}
