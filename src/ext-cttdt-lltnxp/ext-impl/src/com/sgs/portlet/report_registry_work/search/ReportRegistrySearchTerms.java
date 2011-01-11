package com.sgs.portlet.report_registry_work.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class ReportRegistrySearchTerms extends ReportRegistryDisplayTerms {
	
	public ReportRegistrySearchTerms(RenderRequest renderRequest) {
		super(renderRequest);
		reportRegistryCode = DAOParamUtil.getLike(renderRequest, REPORTREGISTRYCODE);
		resultWork = DAOParamUtil.getLike(renderRequest, RESULTWORK);
		programWork = DAOParamUtil.getLike(renderRequest, PROGRAMWORK);
		reportDate = DAOParamUtil.getLike(renderRequest, REPORTDATE);
	}
}