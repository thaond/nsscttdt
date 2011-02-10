package com.sgs.portlet.document.workflow.command;

import com.sgs.liferay.jbpm.command.LiferayWorkflowCommand;
import com.sgs.portlet.document.workflow.DocumentSendLiferayWorkflowService;

public class BackDocumentSendCommand  extends
		LiferayWorkflowCommand {

	public Object execute() {
		((DocumentSendLiferayWorkflowService) getLiferayWorkflowService())
				.signalTaskBack(getWorkflowParams());
		return "";
	}
}
