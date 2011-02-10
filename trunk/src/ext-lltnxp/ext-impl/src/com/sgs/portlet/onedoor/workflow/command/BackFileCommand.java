/**
 * 
 */
package com.sgs.portlet.onedoor.workflow.command;

import org.apache.log4j.Logger;

import com.sgs.liferay.jbpm.command.LiferayWorkflowCommand;
import com.sgs.portlet.onedoor.workflow.OneDoorProcessLiferayWorkflowService;

/**
 * @author canhminh
 *
 */
public class BackFileCommand extends LiferayWorkflowCommand {
	private final static Logger log = Logger.getLogger(BackFileCommand.class);
	
	public Object execute() {
		((OneDoorProcessLiferayWorkflowService) getLiferayWorkflowService()).signalBackTask(getWorkflowParams());
		return "";
	}
}
