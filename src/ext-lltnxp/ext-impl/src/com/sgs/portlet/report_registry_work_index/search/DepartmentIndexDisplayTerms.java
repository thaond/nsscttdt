package com.sgs.portlet.report_registry_work_index.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class DepartmentIndexDisplayTerms extends DisplayTerms {

	public static final String DEPARTMENTCODE = "departmentCode";
	public static final String DEPARTMENTNAME = "departmentName";
	public static final String DEPARTMENTDESCRIPTION = "departmentDescription";

	protected String departmentCode;
	protected String departmentName;
	protected String departmentDescription;

	public DepartmentIndexDisplayTerms(RenderRequest renderRequest) {
		super(renderRequest);
		departmentCode = ParamUtil.getString(renderRequest, DEPARTMENTCODE);
		departmentName = ParamUtil.getString(renderRequest, DEPARTMENTNAME);
		departmentDescription = ParamUtil.getString(renderRequest, DEPARTMENTDESCRIPTION);

	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentDescription() {
		return departmentDescription;
	}

	public void setDepartmentDescription(String departmentDescription) {
		this.departmentDescription = departmentDescription;
	}
}
