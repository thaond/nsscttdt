package com.sgs.portlet.report_registry_work_index.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class DepartmentIndexSearchTerms extends DepartmentIndexDisplayTerms {
	
	public DepartmentIndexSearchTerms(RenderRequest renderRequest) {
		super(renderRequest);
		departmentCode = DAOParamUtil.getLike(renderRequest, DEPARTMENTCODE);
		departmentName = DAOParamUtil.getLike(renderRequest, DEPARTMENTNAME);
		departmentDescription = DAOParamUtil.getLike(renderRequest, DEPARTMENTDESCRIPTION);
	}
}
