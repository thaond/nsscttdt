package com.nss.workflow.command;

import com.nss.workflow.JournalLiferayWorkflowService;
import com.sgs.liferay.jbpm.command.LiferayWorkflowCommand;

public class SignalWorkflowJournalArticleACommand extends LiferayWorkflowCommand{

	@Override
	public Object execute() {
		((JournalLiferayWorkflowService)getLiferayWorkflowService()).signalTask(getWorkflowParams());
		return "";
	}
}
