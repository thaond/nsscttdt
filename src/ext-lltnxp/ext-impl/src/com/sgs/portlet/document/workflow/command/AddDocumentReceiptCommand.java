/**
 * 
 */
package com.sgs.portlet.document.workflow.command;

import com.sgs.liferay.jbpm.command.LiferayWorkflowCommand;
import com.sgs.liferay.jbpm.util.WorkflowParamUtil;

/**
 * @author hieuvh
 *
 */
public class AddDocumentReceiptCommand extends LiferayWorkflowCommand {
	public Object execute() {
		getLiferayWorkflowService().addWorkflowInstance(getWorkflowParams());
		// yenlt update 20101030
		long documentReceiptId = WorkflowParamUtil.getLong(getWorkflowParams(),"documentReceiptId", 0);
		long documentReceiptIdTemp = WorkflowParamUtil.getLong(getWorkflowParams(),"documentReceiptIdTemp", 0);
		String workflowRender = WorkflowParamUtil.getString(getWorkflowParams(), com.sgs.liferay.jbpm.util.Constants.WORKFLOW_RENDER, "false");
		if (documentReceiptId != 0) {
			return String.valueOf("&documentReceiptId=" + documentReceiptId + "&"+
					com.sgs.liferay.jbpm.util.Constants.WORKFLOW_RENDER + "=" + workflowRender
					+ "&documentReceiptIdTemp=" + documentReceiptIdTemp);
		}
		// return to use AddDocumentReceiptCommandResultProcessor for redirect
		return "";
	}

}
