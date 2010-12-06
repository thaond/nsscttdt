/**
 * 
 */
package com.sgs.liferay.jbpm.command;

import java.util.Map;

import com.sgs.liferay.jbpm.service.LiferayWorkflowService;

/**
 * @author hieuvh
 *
 */
public interface WorkflowCommand {
	
	/**
	 * do execute method.
	 * Subclass implement this method by call a concrete action of a object named receiver
	 * @return Object after concrete command call action method of receiver  
	 */
	Object execute();
}
