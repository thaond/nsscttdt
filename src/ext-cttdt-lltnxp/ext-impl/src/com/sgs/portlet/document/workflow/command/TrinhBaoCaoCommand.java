package com.sgs.portlet.document.workflow.command;

import com.sgs.liferay.jbpm.command.LiferayWorkflowCommand;
import com.sgs.portlet.document.workflow.DocumentReceiptLiferayWorkflowService;

public class TrinhBaoCaoCommand extends LiferayWorkflowCommand {

	public Object execute() {
//		((DocumentReceiptLiferayWorkflowService) getLiferayWorkflowService())
//		.processDocumentReceipt(getWorkflowParams()); // yenlt update 06052010 
		((DocumentReceiptLiferayWorkflowService) getLiferayWorkflowService())
		.signalReport(getWorkflowParams());
		return "";
	}
}

