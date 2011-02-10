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
public class SignalDocumentReceiptToDepartmentCommand extends LiferayWorkflowCommand {

	public Object execute() {
		((DocumentReceiptLiferayWorkflowService) getLiferayWorkflowService()).signalDocumentReceiptToDepartment(getWorkflowParams());
		return null;
	}
	
}
