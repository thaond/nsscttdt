/**
 * 
 */
package com.nss.workflowonedoor.command;

import com.sgs.liferay.jbpm.command.LiferayWorkflowCommand;

/**
 * @author hieuvh
 *
 */
public class ProcessTransitionCommand extends LiferayWorkflowCommand {
	
	public Object execute() {
		getLiferayWorkflowService().signalTask(getWorkflowParams());
		return "";
	}
}