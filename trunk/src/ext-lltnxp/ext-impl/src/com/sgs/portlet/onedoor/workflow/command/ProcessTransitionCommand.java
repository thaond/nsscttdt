/**
 * 
 */
package com.sgs.portlet.onedoor.workflow.command;

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