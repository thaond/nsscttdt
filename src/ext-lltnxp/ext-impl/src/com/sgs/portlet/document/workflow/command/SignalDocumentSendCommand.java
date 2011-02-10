/**
 * 
 */
package com.sgs.portlet.document.workflow.command;

import com.sgs.liferay.jbpm.command.LiferayWorkflowCommand;

/**
 * @author hieuvh
 *
 */
public class SignalDocumentSendCommand extends LiferayWorkflowCommand {

	public Object execute() {
		getLiferayWorkflowService().signalTask(getWorkflowParams());
		return null;
	}
}
