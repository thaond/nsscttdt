
package com.sgs.portlet.pcccdocumentsendprocess.action;

/**
 * @author triltm
 * @author thoind
 */
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
import com.sgs.portlet.document.workflow.DocumentSendLiferayWorkflowService;
import com.sgs.portlet.document.workflow.DocumentSendPortletAction;

public class BackDocumentAction extends DocumentSendPortletAction {

	private static Log _log = LogFactory.getLog(BackDocumentAction.class);

	/**
	 * Get list users (Director) to trans document
	 * 
	 * @param req
	 * @return List<PmlUser>
	 */
	private List<User> getListUser(RenderRequest req)
		throws Exception {

		List<User> res = new ArrayList<User>();
		long documentSendId = ParamUtil.getLong(req, "documentSendId", 0);

		DocumentSendLiferayWorkflowService doorProcessLiferayWorkflowService =
			(DocumentSendLiferayWorkflowService) getLiferayWorkflowService();
		User user =
			doorProcessLiferayWorkflowService.getUserProcess(documentSendId);
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
			req, "receiverId", WorkflowParam.TRANSIENT, receiverId + "");
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
			addWorkflowParameter(
				req, "directprocessor", WorkflowParam.TRANSIENT,
				String.valueOf(PortalUtil.getUserId(req)));
		}

		// addWorkflowParameter(req, "processor", WorkflowParam.TRANSIENT,
		// String.valueOf(PortalUtil.getUserId(req)));
		// end yenlt update 11082010
		// yenlt update rut lai vb di 20101119
		boolean rutLai = ParamUtil.getBoolean(req, "rutLai");
		long receiverIdBack = ParamUtil.getLong(req, "receiverIdBack", -1);
		addWorkflowParameter(
			req, "rutLai", WorkflowParam.TRANSIENT, String.valueOf(rutLai));
		addWorkflowParameter(
			req, "receiverIdBack", WorkflowParam.TRANSIENT,
			String.valueOf(receiverIdBack));
		// end yenlt update 20101119
		_log.info("in processstrutsAction method in class BackDocumentAction");

		PortletSession session = req.getPortletSession();
		session.setAttribute(
			"transition", "transition", PortletSession.APPLICATION_SCOPE);
	}

	public ActionForward renderStruts(
		ActionMapping mapping, ActionForm form, PortletConfig config,
		RenderRequest req, RenderResponse res)
		throws Exception {

		_log.info("in renderstrutsAction method");
		List<User> users = getListUser(req);

		// get current page
		int page = ParamUtil.getInteger(req, "page", 1);

		// get total item of page
		int limit = ParamUtil.getInteger(req, "limit", 20); // default

		req.setAttribute("users", users);

		req.setAttribute("currentPage", page);
		req.setAttribute("currentLimit", limit);

		return mapping.findForward("portlet.sgs.pcccdocumentsendprocess.backDocumentAction");
	}

}
