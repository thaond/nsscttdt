/**
 * 
 */
package com.sgs.portlet.document.workflow.command;

import com.sgs.liferay.jbpm.command.LiferayWorkflowCommand;

/**
 * @author hieuvh
 *
 */
public class AddDocumentSendCommand extends LiferayWorkflowCommand {

	
	public Object execute() {
		getLiferayWorkflowService().addWorkflowInstance(getWorkflowParams());
		
		// return for AddDocumentSendCommandResultProcessor to redirect
		return "";
	}
		
}