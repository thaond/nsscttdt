/**
 * 
 */
package com.nss.workflow.command;

import com.sgs.liferay.jbpm.command.LiferayWorkflowCommand;

/**
 * @author hieuvh
 *
 */
public class AddWorkflowJournalArticleCommand extends LiferayWorkflowCommand {
	public Object execute() {
		getLiferayWorkflowService().addWorkflowInstance(getWorkflowParams());
		return "";
	}

}
