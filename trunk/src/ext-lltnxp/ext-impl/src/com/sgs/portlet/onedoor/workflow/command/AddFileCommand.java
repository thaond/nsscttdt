package com.sgs.portlet.onedoor.workflow.command;

import java.util.List;

import org.apache.log4j.Logger;

import com.sgs.liferay.jbpm.command.LiferayWorkflowCommand;
import com.sgs.liferay.jbpm.param.WorkflowParam;

public class AddFileCommand extends LiferayWorkflowCommand {
	private final static Logger log = Logger
	.getLogger(AddFileCommand.class);
	
	public Object execute() {
		getLiferayWorkflowService().addWorkflowInstance(getWorkflowParams());
		return "";
	}
}
