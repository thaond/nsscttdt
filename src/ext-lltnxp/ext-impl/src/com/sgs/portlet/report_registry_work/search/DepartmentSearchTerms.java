package com.sgs.portlet.report_registry_work.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class DepartmentSearchTerms extends DepartmentDisplayTerms {
	
	public DepartmentSearchTerms(RenderRequest renderRequest) {
		super(renderRequest);
		departmentCode = DAOParamUtil.getLike(renderRequest, DEPARTMENTCODE);
		departmentName = DAOParamUtil.getLike(renderRequest, DEPARTMENTNAME);
		departmentDescription = DAOParamUtil.getLike(renderRequest, DEPARTMENTDESCRIPTION);
	}
}
