package com.sgs.portlet.report_registry_work.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class ReportRegistryDisplayTerms extends DisplayTerms {

	public static final String REPORTREGISTRYCODE = "reportRegistryCode";
	public static final String USERCREATE = "userCreate";
	public static final String RESULTWORK = "resultWork";
	public static final String PROGRAMWORK = "programWork";
	public static final String DEPARTMENT = "department";

	protected String reportRegistryCode;
	protected String userCreate;
	protected String resultWork;
	protected String programWork;
	protected String department;

	public ReportRegistryDisplayTerms(RenderRequest renderRequest) {
		super(renderRequest);
		reportRegistryCode = ParamUtil.getString(renderRequest, REPORTREGISTRYCODE);
		userCreate = ParamUtil.getString(renderRequest, USERCREATE);
		resultWork = ParamUtil.getString(renderRequest, RESULTWORK);
		programWork = ParamUtil.getString(renderRequest, PROGRAMWORK);
		department = ParamUtil.getString(renderRequest, DEPARTMENT);
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

	public String getUserCreate() {
		return userCreate;
	}

	public void setUserCreate(String userCreate) {
		this.userCreate = userCreate;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
}
