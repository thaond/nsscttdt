
package com.sgs.portlet.pcccdocumentreceiptprocess.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
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
import com.liferay.portal.service.persistence.UserUtil;
import com.liferay.portal.util.PortalUtil;
import com.sgs.liferay.jbpm.param.WorkflowParam;
import com.sgs.portlet.document.workflow.DocumentReceiptPortletAction;

public class TransCVPAction extends DocumentReceiptPortletAction {

	private static Log _log = LogFactory.getLog(TransCVPAction.class);

	/**
	 * Get list users (CVP) to trans document
	 * 
	 * @param req
	 * @return List<PmlUser>
	 */

	private List<User> getListUser(RenderRequest req)
		throws Exception {

		boolean changeCVP = ParamUtil.getBoolean(req, "changeCVP", false);
		List<User> results = new ArrayList<User>();
		// long userId =
		// PmlDepartmentsLeaderUtil.findByDepartmentsId("DMPB01090000038").get(0).getUserId();
		// results.add(UserLocalServiceUtil.getUser(userId));
		PortletPreferences prefs = req.getPreferences();
		String[] listUser = prefs.getValues("listUser", new String[0]);

		if (false == changeCVP) {
			try {
				long taskId = ParamUtil.getLong(req, "taskId");

				if (taskId != 0) {
					_log.info("taskId: " + taskId);
					results = getLiferayWorkflowService().getPooledUser(taskId);
					if ((results == null) || (results.size() == 0)) {

						User user = null;
						for (int i = 0; i < listUser.length; i++) {
							try {
								user =
									UserUtil.findByPrimaryKey(Long.parseLong(listUser[i]));
							}
							catch (Exception e) {
								user = null;
							}
							if (user != null) {
								results.add(user);
							}
						}
					}
				}

			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			User user = null;
			for (int i = 0; i < listUser.length; i++) {
				try {
					user =
						UserUtil.findByPrimaryKey(Long.parseLong(listUser[i]));
				}
				catch (Exception e) {
					user = null;
				}
				if (user != null) {
					results.add(user);
				}
			}
		}

		Collections.sort(results, new Comparator<User>() {

			public int compare(User o1, User o2) {

				return o1.getFullName().compareTo(o2.getFullName());
			}
		});

		return results;
	}

	public void processStrutsAction(
		ActionMapping mapping, ActionForm form, PortletConfig config,
		ActionRequest req, ActionResponse res)
		throws Exception {

		long receiverId = ParamUtil.getLong(req, "receiverId", -1);
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

		// addWorkflowParameter(req, "processor", WorkflowParam.TRANSIENT,
		// String.valueOf(PortalUtil.getUserId(req)));
		// end yenlt update 11082010

		// yenlt update 20101101 chuyen thanh cong thi xoa trong bang tam
		long documentReceiptIdTemp =
			ParamUtil.getLong(req, "documentReceiptIdTemp", 0);
		addWorkflowParameter(
			req, "documentReceiptIdTemp", WorkflowParam.TRANSIENT,
			String.valueOf(documentReceiptIdTemp));
		// end yenlt update 20101101
		// yenlt 20101118 chuyen nhieu vb
		boolean changeCVP = ParamUtil.getBoolean(req, "changeCVP", false);
		String documentReceiptIdList =
			ParamUtil.getString(req, "documentReceiptIdList");

		addWorkflowParameter(
			req, "changeCVP", WorkflowParam.TRANSIENT,
			String.valueOf(changeCVP));
		addWorkflowParameter(
			req, "documentReceiptIdList", WorkflowParam.TRANSIENT,
			documentReceiptIdList);
		// yenlt 20101118

		_log.info("in processstrutsAction method of TransCVPAction");
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

		return mapping.findForward("portlet.sgs.pcccdocumentreceiptprocess.transcvp");
	}

}
