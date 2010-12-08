package com.nss.workflowonedoor.command;


import com.sgs.liferay.jbpm.command.LiferayWorkflowCommand;

public class AddFileCommand extends LiferayWorkflowCommand {
	public Object execute() {
		getLiferayWorkflowService().addWorkflowInstance(getWorkflowParams());
		return "";
	}
}
