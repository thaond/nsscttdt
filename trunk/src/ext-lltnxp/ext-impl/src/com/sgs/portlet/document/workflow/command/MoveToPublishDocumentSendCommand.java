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
public class MoveToPublishDocumentSendCommand extends LiferayWorkflowCommand {

	public Object execute() {
		((DocumentSendLiferayWorkflowService) getLiferayWorkflowService())
				.moveToPublish(getWorkflowParams());
		// Return for MoveToPublishDocumentSendCommandResultProcessor to redirect
		return "";
	}

}
