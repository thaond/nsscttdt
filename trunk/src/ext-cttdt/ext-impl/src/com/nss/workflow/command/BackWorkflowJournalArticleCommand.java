package com.nss.workflow.command;

import com.nss.workflow.JournalLiferayWorkflowService;
import com.sgs.liferay.jbpm.command.LiferayWorkflowCommand;

public class BackWorkflowJournalArticleCommand extends LiferayWorkflowCommand{

	@Override
	public Object execute() {
		((JournalLiferayWorkflowService)getLiferayWorkflowService()).signalTaskBack(getWorkflowParams());
		return "";
	}

}
