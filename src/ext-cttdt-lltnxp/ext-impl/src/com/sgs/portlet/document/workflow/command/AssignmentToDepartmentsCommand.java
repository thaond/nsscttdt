/**
 * 
 */
package com.sgs.portlet.document.workflow.command;

import com.sgs.liferay.jbpm.command.LiferayWorkflowCommand;
import com.sgs.portlet.document.workflow.DocumentReceiptLiferayWorkflowService;

/**
 * @author hieuvh
 *
 */
public class AssignmentToDepartmentsCommand extends LiferayWorkflowCommand {

	public Object execute() {
		//minh update 20100127
//		((DocumentReceiptLiferayWorkflowService) getLiferayWorkflowService()).signalDocumentReceiptToDepartment(getWorkflowParams());
		((DocumentReceiptLiferayWorkflowService) getLiferayWorkflowService()).signalDocumentReceiptToDepartmentUseUsers(getWorkflowParams());
		// end
		return "";
	}
	
}
