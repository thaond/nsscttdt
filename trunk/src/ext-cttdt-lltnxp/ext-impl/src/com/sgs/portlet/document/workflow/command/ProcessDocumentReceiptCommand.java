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
public class ProcessDocumentReceiptCommand extends LiferayWorkflowCommand {

	public Object execute() {
		((DocumentReceiptLiferayWorkflowService) getLiferayWorkflowService())
				.processDocumentReceipt(getWorkflowParams());
		// return for ProcessDocumentReceiptCommandResultProcessor to redirect
		return "";
	}

}
