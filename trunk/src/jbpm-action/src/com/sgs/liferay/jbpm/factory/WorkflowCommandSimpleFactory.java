/**
 * 
 */
package com.sgs.liferay.jbpm.factory;

import com.liferay.util.portlet.PortletProps;
import com.sgs.liferay.jbpm.command.WorkflowCommand;

/**
 * @author hieuvh
 * 
 */
public class WorkflowCommandSimpleFactory {
	
	/**
	 * instance for singleton design pattern
	 */
	private static WorkflowCommandSimpleFactory instance = null;

	/**
	 * private default constructor
	 */
	private WorkflowCommandSimpleFactory() {
	}

	/**
	 * get singleton instance
	 * @return instance
	 */
	public static WorkflowCommandSimpleFactory getInstance() {
		
		if (instance == null) {
			instance = new WorkflowCommandSimpleFactory();
		}
		
		return instance;
	}
	
	/**
	 * factory method to create command.
	 * input a workflowActionName, this method base on configure in 
	 * portlet.properties of liferay portal to create an instance of WorkfowCommand
	 * @param workflowActionName
	 * @return instance of WorkflowCommand, null if classname associate with 
	 * workflowActionName wrong or not found in portlet.properties
	 */
	public WorkflowCommand createWorkflowCommand(String workflowActionName) {
		String className = PortletProps.get(workflowActionName);
		WorkflowCommand command;
		
		try {
			command = (WorkflowCommand) Class.forName(className).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return command;
	}
}
