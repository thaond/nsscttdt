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
public class MoveToAgencyLeaderDocumentSendCommand extends
		LiferayWorkflowCommand {

	public Object execute() {
		((DocumentSendLiferayWorkflowService) getLiferayWorkflowService())
				.moveToAgencyLeader(getWorkflowParams());
		// Return for MoveToAgencyLeaderDocumentSendCommandResultProcessor to redirect
		return "";
	}

}
