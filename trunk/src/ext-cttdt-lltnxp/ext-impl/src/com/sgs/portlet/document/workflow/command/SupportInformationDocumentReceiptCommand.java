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
public class SupportInformationDocumentReceiptCommand extends LiferayWorkflowCommand {

	public Object execute() {
		((DocumentReceiptLiferayWorkflowService) getLiferayWorkflowService())
				.giveSupportInformation(getWorkflowParams());
		return "";
	}

}
