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
public class DeleteDocumentReceiptCommand extends LiferayWorkflowCommand {

	public Object execute() {
		((DocumentReceiptLiferayWorkflowService)getLiferayWorkflowService())
				.deleteDocumentReceipt(getWorkflowParams());
		
		// return to use DeleteDocumentReceiptCommandResultProcessor for redirect
		return "";
	}

}
