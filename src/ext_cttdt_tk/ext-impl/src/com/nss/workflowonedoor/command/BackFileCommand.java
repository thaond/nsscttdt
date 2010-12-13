/**
 * 
 */
package com.nss.workflowonedoor.command;

import org.apache.log4j.Logger;

import com.nss.workflowonedoor.OneDoorProcessLiferayWorkflowService;
import com.sgs.liferay.jbpm.command.LiferayWorkflowCommand;

/**
 * @author canhminh
 *
 */
public class BackFileCommand extends LiferayWorkflowCommand {
	
	public Object execute() {
		((OneDoorProcessLiferayWorkflowService) getLiferayWorkflowService()).signalBackTask(getWorkflowParams());
		return "";
	}
}
