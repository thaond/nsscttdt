/**
 * 
 */
package com.sgs.portlet.onedoor.workflow.command;

import java.io.InputStream;

import com.sgs.liferay.jbpm.command.LiferayWorkflowCommand;
import com.sgs.portlet.onedoor.workflow.OneDoorProcessLiferayWorkflowService;

/**
 * @author hieuvh
 *
 */
public class InBienNhanCommand extends LiferayWorkflowCommand {

	/* (non-Javadoc)
	 * @see com.sgs.liferay.jbpm.command.WorkflowCommand#execute()
	 */
	public Object execute() {
		InputStream stream = ((OneDoorProcessLiferayWorkflowService) getLiferayWorkflowService())
				.inBienNhan(getWorkflowParams());
		return stream;
	}

}
