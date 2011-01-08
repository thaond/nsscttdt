/**
 * 
 */
package com.sgs.portlet.onedoor.workflow.command;

import com.sgs.liferay.jbpm.command.LiferayWorkflowCommand;
import com.sgs.portlet.onedoor.workflow.OneDoorProcessLiferayWorkflowService;

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