/**
 * 
 */
package com.sgs.portlet.document.workflow.command;

import com.sgs.liferay.jbpm.command.LiferayWorkflowCommand;
import com.sgs.portlet.document.workflow.DocumentSendLiferayWorkflowService;

/**
 * @author hieuvh
 *
 */
public class DeleteDocumentSendCommand extends LiferayWorkflowCommand {

	public Object execute() {
		((DocumentSendLiferayWorkflowService) getLiferayWorkflowService())
				.deleteDocumentSend(getWorkflowParams());
		
		// for redirect
		return "";
	}

}
