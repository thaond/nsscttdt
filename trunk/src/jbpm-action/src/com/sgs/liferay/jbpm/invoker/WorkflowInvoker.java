/**
 * 
 */
package com.sgs.liferay.jbpm.invoker;


import com.sgs.liferay.jbpm.command.WorkflowCommand;

/**
 * Invoker of Command Design Pattern.
 * @author hieuvh
 *
 */
public class WorkflowInvoker {

	private static WorkflowInvoker instance = null;
	private WorkflowCommand workflowCommand;
	
	private WorkflowInvoker() {}
	
	public static WorkflowInvoker getInstance() {
		if (instance == null) {
			instance = new WorkflowInvoker();
		}
		return instance;
	}

	/**
	 * @return the workflowCommand
	 */
	public WorkflowCommand getWorkflowCommand() {
		return workflowCommand;
	}

	/**
	 * @param workflowCommand the workflowCommand to set
	 */
	public void setWorkflowCommand(WorkflowCommand workflowCommand) {
		this.workflowCommand = workflowCommand;
	}
	
	/**
	 * this method called by client to request a action of receiver
	 */
	public Object invoke() {
		return workflowCommand.execute();
	}
}
