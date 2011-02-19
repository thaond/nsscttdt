
package com.sgs.portlet.pcccdocumentsendprocess.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.sgs.liferay.jbpm.param.WorkflowParam;
import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;
import com.sgs.portlet.document.send.service.PmlEdmDocumentSendLocalServiceUtil;
import com.sgs.portlet.document.workflow.DocumentSendLiferayWorkflowService;
import com.sgs.portlet.document.workflow.DocumentSendPortletAction;
import com.sgs.portlet.documentdelegate.util.PmlDocumentDelegateUtil;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil;
import com.sgs.portlet.pmluser.service.persistence.PmlUserUtil;

/**
 * <ul>
 * <li>renderStruts: prepare data to view</li>
 * <li>processStrutsAction: process move to department leader action.<br/>
 * After that, redirect to ViewAction</li>
 * </ul>
 * 
 * @author doanhdv
 * @author hieuvh
 */
public class MoveToPublishAction extends DocumentSendPortletAction {

	private static Log _log = LogFactory.getLog(MoveToPublishAction.class);

	/**
	 * Get department leader in list
	 * 
	 * @param req
	 * @return List<User>
	 */
	private List<User> getListUser(RenderRequest req)
		throws Exception {

		List<User> results = new ArrayList<User>();
//		long documentSendId = ParamUtil.getLong(req, "documentSendId", 0);

		long taskId = getTaskInstanceId(req);
		List<User> users =
			((DocumentSendLiferayWorkflowService) getLiferayWorkflowService()).getPooledUser(taskId);

		results.addAll(users);
		Collections.sort(results, new Comparator<User>() {

			public int compare(User o1, User o2) {

				return o1.getFullName().compareTo(o2.getFullName());
			}
		});
		return results;
	}

	@Override
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

		PortletSession session = req.getPortletSession();
		session.setAttribute(
			"transition", "transition", PortletSession.APPLICATION_SCOPE);
	}

	@Override
	public ActionForward renderStruts(
		ActionMapping mapping, ActionForm form, PortletConfig config,
		RenderRequest req, RenderResponse res)
		throws Exception {

		long documentSendId = ParamUtil.getLong(req, "documentSendId", 0);
		PmlEdmDocumentSend pmlEdmDocumentSend = PmlEdmDocumentSendLocalServiceUtil.getPmlEdmDocumentSend(documentSendId);
		
		List<User> users = new ArrayList<User>();
		if (!pmlEdmDocumentSend.getIsDocOfDepartment()) {
			users = getListUser(req);
		} else {
			long userId = PortalUtil.getUserId(req);
			PmlUser pmlUser = null;
			String departmentId = "";
			List<PmlUser> userOfDepartmentList = new ArrayList<PmlUser>();
			try {
				pmlUser = PmlUserLocalServiceUtil.getPmlUser(userId);
				departmentId = pmlUser.getDepartmentsId();
				userOfDepartmentList = PmlUserUtil.findByDepartmentsId(departmentId);
				
				for (PmlUser pmlUser2 : userOfDepartmentList) {
					if (pmlUser2.getIsVanThuPhong()) {
						users.add(UserLocalServiceUtil.getUser(pmlUser2.getUserId()));
					}
				}
			} catch (Exception e) {}
			
//			 new nguoi chuyen phat hanh khong co van thu phong
			if (users.size() == 0) {
				try {
					userOfDepartmentList = PmlUserUtil.findByIsVanThuPhong(true);
					for (PmlUser pmlUser2 : userOfDepartmentList) {
						users.add(UserLocalServiceUtil.getUser(pmlUser2.getUserId()));
					}
				} catch (Exception e) {
				}
			}
		}

		Collections.sort(users, new Comparator<User>() {

			public int compare(User o1, User o2) {
				return PmlDocumentDelegateUtil.getFullName(o1.getUserId()).compareTo(PmlDocumentDelegateUtil.getFullName(o2.getUserId()));
			}
		});

		// get current page
//		int page = ParamUtil.getInteger(req, "page", 1);

		// get total item of page
//		int limit = ParamUtil.getInteger(req, "limit", 20); // default

		req.setAttribute("users", users);

//		req.setAttribute("currentPage", page);
//		req.setAttribute("currentLimit", limit);

		return mapping.findForward("portlet.sgs.pcccdocumentsendprocess.movetopublish");
	}

}
