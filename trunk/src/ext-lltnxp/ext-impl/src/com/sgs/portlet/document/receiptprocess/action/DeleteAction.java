/**
 * Xoa cong van co id duoc xac dinh
 * Sau khi xoa tra ve trang hien danh sach (display.jsp)
 */
package com.sgs.portlet.document.receiptprocess.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.sgs.liferay.jbpm.param.WorkflowParam;
import com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalServiceUtil;
import com.sgs.portlet.document.workflow.DocumentReceiptPortletAction;

/**
 * Delete a receipt document when it know id of receipt document
 * @author doanhdv
 * @author kienbqc
 */
public class DeleteAction extends DocumentReceiptPortletAction {
	/**
	 * When client want detele a receipt document, this method is called.
	 * To delete a receipt document, we will: <br>
	 * 
	 * - Get id of receipt document in parameter.<br>
	 * - Use PmlEdmDocumentReceiptLocalServiceUtil object to delete that document 
	 */
	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		
		long documentReceiptId = ParamUtil.getLong(req, "documentReceiptId");
		
		String deleteMessage = "";
		try {
			deleteMessage = "success"; 
			PmlEdmDocumentReceiptLocalServiceUtil.deletePmlEdmDocumentReceipt(documentReceiptId);
			
			// add parameter for Workflow Service to delete workflow instance
			addWorkflowParameter(req, "documentReceiptId",
					WorkflowParam.TRANSIENT, "" + documentReceiptId);
			
		} catch (PortalException e) {
			deleteMessage = "fail";
		} catch (SystemException e) {
			deleteMessage = "fail";
		}
		
		req.setAttribute("deleteMessage", deleteMessage);
	}

	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		return null;
	}
}
