/**
 * 
 */
package com.nss.workflowonedoor.command;

import java.io.InputStream;

import com.nss.workflowonedoor.OneDoorProcessLiferayWorkflowService;
import com.sgs.liferay.jbpm.command.LiferayWorkflowCommand;

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
