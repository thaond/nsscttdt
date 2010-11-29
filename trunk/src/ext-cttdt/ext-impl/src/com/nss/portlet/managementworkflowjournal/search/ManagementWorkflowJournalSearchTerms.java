package com.nss.portlet.managementworkflowjournal.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class ManagementWorkflowJournalSearchTerms extends ManagementWorkflowJournalDisplayTerms{

	public ManagementWorkflowJournalSearchTerms(PortletRequest portletRequest) {
		super(portletRequest);
		workflowName = DAOParamUtil.getLike(portletRequest, WORKFLOW_NAME);
		version = DAOParamUtil.getInteger(portletRequest, VERSION);
	}

}
