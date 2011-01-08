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
public class MoveToDepartmentLeaderDocumentSendCommand extends
		LiferayWorkflowCommand {

	public Object execute() {
		((DocumentSendLiferayWorkflowService) getLiferayWorkflowService())
				.moveToDepartmentLeader(getWorkflowParams());
		// Return for ToDepartmentLeaderDocumentSendCommandResultProcessor to redirect
		return "";
	}

}
