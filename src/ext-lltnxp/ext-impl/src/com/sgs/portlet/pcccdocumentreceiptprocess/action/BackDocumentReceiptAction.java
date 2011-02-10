
package com.sgs.portlet.pcccdocumentreceiptprocess.action;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;
import com.sgs.liferay.jbpm.param.WorkflowParam;
import com.sgs.portlet.document.workflow.DocumentReceiptLiferayWorkflowService;
import com.sgs.portlet.document.workflow.DocumentReceiptPortletAction;

public class BackDocumentReceiptAction extends DocumentReceiptPortletAction {

	private static Log _log = LogFactory.getLog(TransAction.class);

	/**
	 * Get list users (Director) to trans document
	 * 
	 * @param req
	 * @return List<PmlUser>
	 */
	private List<User> getListUser(RenderRequest req)
		throws Exception {

		List<User> res = new ArrayList<User>();
		long documentReceiptId = ParamUtil.getLong(req, "documentReceiptId", 0);

		DocumentReceiptLiferayWorkflowService documentReceiptLiferayWorkflowService =
			(DocumentReceiptLiferayWorkflowService) getLiferayWorkflowService();
		User user =
			documentReceiptLiferayWorkflowService.getUserProcess(documentReceiptId);
		res.add(user);
		return res;
	}

	public void processStrutsAction(
		ActionMapping mapping, ActionForm form, PortletConfig config,
		ActionRequest req, ActionResponse res)
		throws Exception {

		long receiverId = ParamUtil.getLong(req, "receiverId", 0);
		String processInformation =
			ParamUtil.getString(req, "processInformation", "");

		addWorkflowParameter(
			req, "receiverId", WorkflowParam.TRANSIENT,
			String.valueOf(receiverId));
		addWorkflowParameter(
			req, "processInformation", WorkflowParam.TRANSIENT,
			processInformation);
		// yenlt update 11082010
		long userIdXLT = ParamUtil.getLong(req, "userIdXLT", 0);
		if (userIdXLT == 0) {
			addWorkflowParameter(
				req, "processor", WorkflowParam.TRANSIENT,
				String.valueOf(PortalUtil.getUserId(req)));
		}
		else {
			addWorkflowParameter(
				req, "processor", WorkflowParam.TRANSIENT,
				String.valueOf(userIdXLT));
			// Canh
			addWorkflowParameter(
				req, "directprocessor", WorkflowParam.TRANSIENT,
				String.valueOf(PortalUtil.getUserId(req)));
			// End of Canh
		}
		// yenlt update rut lai vb 20101119
		boolean rutLai = ParamUtil.getBoolean(req, "rutLai");
		long receiverIdBack = ParamUtil.getLong(req, "receiverIdBack", -1);
		addWorkflowParameter(
			req, "rutLai", WorkflowParam.TRANSIENT, String.valueOf(rutLai));
		addWorkflowParameter(
			req, "receiverIdBack", WorkflowParam.TRANSIENT,
			String.valueOf(receiverIdBack));
		// end yenlt update 20101119

		PortletSession session = req.getPortletSession();
		session.setAttribute(
			"transition", "transition", PortletSession.APPLICATION_SCOPE);
	}

	public ActionForward renderStruts(
		ActionMapping mapping, ActionForm form, PortletConfig config,
		RenderRequest req, RenderResponse res)
		throws Exception {

		List<User> users = getListUser(req);

		// get current page
		int page = ParamUtil.getInteger(req, "page", 1);

		// get total item of page
		int limit = ParamUtil.getInteger(req, "limit", 20); // default

		req.setAttribute("users", users);
		req.setAttribute("currentPage", page);
		req.setAttribute("currentLimit", limit);

		return mapping.findForward("portlet.sgs.pcccdocumentreceiptprocess.backDocumentReceipt");
	}
}
