/**
 * 
 */

package com.nss.workflow.command;

import com.nss.workflow.JournalLiferayWorkflowService;
import com.sgs.liferay.jbpm.command.LiferayWorkflowCommand;

/**
 * @author Tu
 */
public class DeleteWorkflowJournalArticleCommand extends LiferayWorkflowCommand {

	public Object execute() {

		((JournalLiferayWorkflowService) getLiferayWorkflowService()).deleteWorkflowJournalAritcle(getWorkflowParams());
		return "";
	}

}
