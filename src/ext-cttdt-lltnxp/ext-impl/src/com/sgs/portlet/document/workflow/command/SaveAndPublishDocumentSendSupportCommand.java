package com.sgs.portlet.document.workflow.command;

import com.sgs.liferay.jbpm.command.LiferayWorkflowCommand;
import com.sgs.portlet.document.workflow.DocumentSendLiferayWorkflowService;

/**
 * 
 */

/**
 * @author WIN7
 *
 */
public class SaveAndPublishDocumentSendSupportCommand extends LiferayWorkflowCommand {
	public Object execute() {
		String message = ((DocumentSendLiferayWorkflowService)getLiferayWorkflowService())
				.publishDocumentSendSupport(getWorkflowParams());
		
		return message;
	}
}
