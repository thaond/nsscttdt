/**
 * 
 */
package com.sgs.liferay.jbpm.command;

import java.util.Iterator;
import java.util.List;

import com.sgs.liferay.jbpm.param.WorkflowParam;
import com.sgs.liferay.jbpm.service.LiferayWorkflowService;

/**
 * @author hieuvh
 *
 */
public abstract class LiferayWorkflowCommand implements WorkflowCommand {
	private LiferayWorkflowService liferayWorkflowService;
	private List<WorkflowParam> workflowParams;

	/**
	 * @return the liferayWorkflowService
	 */
	public LiferayWorkflowService getLiferayWorkflowService() {
		return liferayWorkflowService;
	}

	/**
	 * @param liferayWorkflowService the liferayWorkflowService to set
	 */
	public void setLiferayWorkflowService(
			LiferayWorkflowService liferayWorkflowService) {
		this.liferayWorkflowService = liferayWorkflowService;
	}
	
	/**
	 * @return the workflowParams
	 */
	public List<WorkflowParam> getWorkflowParams() {
		return workflowParams;
	}

	/**
	 * @param workflowParams the workflowParams to set
	 */
	public void setWorkflowParams(List<WorkflowParam> workflowParams) {
		this.workflowParams = workflowParams;
	}
}
