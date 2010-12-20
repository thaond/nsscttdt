/**
 * 
 */

package com.nss.workflow.command;

import com.sgs.liferay.jbpm.command.LiferayWorkflowCommand;
import com.sgs.liferay.jbpm.util.WorkflowParamUtil;

/**
 * @author hieuvh
 */
public class AddWorkflowJournalArticleCommand extends LiferayWorkflowCommand {

	public Object execute() {

		getLiferayWorkflowService().addWorkflowInstance(getWorkflowParams());

		String result =
			WorkflowParamUtil.getString(
				getWorkflowParams(), "saveAndContinue", "");

		return result;
	}

}
