package com.sgs.portlet.sovanbannoibo.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class PhongBanDisplayTerms extends DisplayTerms {

	public static final String DEPARTMENTSCODE = "departmentsCode";
	public static final String DEPARTMENTNAMES = "departmentsName";
	public static final String ABBREVIATENAME = "abbreviateName";
	
	protected String departmentsCode;
	protected String departmentsName;
	protected String abbreviateName;

	public PhongBanDisplayTerms(RenderRequest request) {
		super(request);
		departmentsCode = ParamUtil.getString(request, DEPARTMENTSCODE);
		departmentsName = ParamUtil.getString(request, DEPARTMENTNAMES);
		abbreviateName = ParamUtil.getString(request, ABBREVIATENAME);
	}

	public String getDepartmentsCode() {
		return departmentsCode;
	}

	public void setDepartmentsCode(String departmentsCode) {
		this.departmentsCode = departmentsCode;
	}

	public String getDepartmentsName() {
		return departmentsName;
	}

	public void setDepartmentsName(String departmentsName) {
		this.departmentsName = departmentsName;
	}

	public String getAbbreviateName() {
		return abbreviateName;
	}

	public void setAbbreviateName(String abbreviateName) {
		this.abbreviateName = abbreviateName;
	}
}
