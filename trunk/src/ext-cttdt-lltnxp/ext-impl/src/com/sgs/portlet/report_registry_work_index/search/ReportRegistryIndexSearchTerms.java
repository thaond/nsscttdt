package com.sgs.portlet.report_registry_work_index.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class ReportRegistryIndexSearchTerms extends ReportRegistryIndexDisplayTerms {
	
	public ReportRegistryIndexSearchTerms(RenderRequest renderRequest) {
		super(renderRequest);
		reportRegistryCode = DAOParamUtil.getLike(renderRequest, REPORTREGISTRYCODE);
		userCreate = DAOParamUtil.getLike(renderRequest, USERCREATE);
		resultWork = DAOParamUtil.getLike(renderRequest, RESULTWORK);
		programWork = DAOParamUtil.getLike(renderRequest, PROGRAMWORK);
		department = DAOParamUtil.getLong(renderRequest, DEPARTMENT);
	}
}
