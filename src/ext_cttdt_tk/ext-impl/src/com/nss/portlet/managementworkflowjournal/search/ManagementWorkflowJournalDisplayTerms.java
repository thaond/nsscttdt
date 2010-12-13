package com.nss.portlet.managementworkflowjournal.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class ManagementWorkflowJournalDisplayTerms extends DisplayTerms{
	public static final String WORKFLOW_NAME = "workflowName";
	public static final String VERSION = "version";
	
	protected String workflowName;
	protected int version;
	
	public ManagementWorkflowJournalDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);
		workflowName = ParamUtil.getString(portletRequest, WORKFLOW_NAME);
		version = ParamUtil.getInteger(portletRequest, VERSION);
	}

	public String getWorkflowName() {
		return workflowName;
	}

	public void setWorkflowName(String workflowName) {
		this.workflowName = workflowName;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}
