package com.sgs.portlet.document.workflow.command;

import com.sgs.liferay.jbpm.command.LiferayWorkflowCommand;
import com.sgs.portlet.document.workflow.DocumentReceiptLiferayWorkflowService;

public class BackDocumentReceiptCommand extends
		LiferayWorkflowCommand {

	public Object execute() {
		((DocumentReceiptLiferayWorkflowService) getLiferayWorkflowService())
				.signalBackDocumentReceipt(getWorkflowParams());
		return "";
	}
}