/**
 * 
 */
package com.sgs.portlet.document.workflow.command;

import com.sgs.liferay.jbpm.command.LiferayWorkflowCommand;

/**
 * @author hieuvh
 *
 */
public class ConfirmViewCommand extends LiferayWorkflowCommand {

	public Object execute() {
		getLiferayWorkflowService().signalTask(getWorkflowParams());
		
		// return for ConfirmViewCommandResultProcessor to redirect
		return "";
	}

}
