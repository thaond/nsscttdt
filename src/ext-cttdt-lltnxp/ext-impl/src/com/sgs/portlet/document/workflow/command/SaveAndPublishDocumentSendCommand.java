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
public class SaveAndPublishDocumentSendCommand extends LiferayWorkflowCommand {

	public Object execute() {
		((DocumentSendLiferayWorkflowService)getLiferayWorkflowService())
				.publishDocumentSend(getWorkflowParams());
		
		// return for redirect
		return "";
	}

}
