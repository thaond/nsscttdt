/**
 * 
 */
package com.nss.workflowonedoor.command;

import com.nss.workflowonedoor.OneDoorProcessLiferayWorkflowService;
import com.sgs.liferay.jbpm.command.LiferayWorkflowCommand;

/**
 * @author hieuvh
 *
 */
public class DeleteFileCommand extends LiferayWorkflowCommand {

	
	public Object execute() {
		((OneDoorProcessLiferayWorkflowService)getLiferayWorkflowService())
				.deleteWorkflowInstance(getWorkflowParams());
		return "";
	}
}