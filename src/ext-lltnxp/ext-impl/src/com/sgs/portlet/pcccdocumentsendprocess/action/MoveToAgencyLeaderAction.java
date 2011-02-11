
package com.sgs.portlet.pcccdocumentsendprocess.action;

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

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.persistence.UserUtil;
import com.liferay.portal.util.PortalUtil;
import com.sgs.liferay.jbpm.param.WorkflowParam;
import com.sgs.portlet.document.workflow.DocumentSendPortletAction;

public class MoveToAgencyLeaderAction extends DocumentSendPortletAction {

	// xuancong close private static Log _log =
	// LogFactory.getLog(MoveToAgencyLeaderAction.class);

	/**
	 * Get department leader in list
	 * 
	 * @param req
	 * @return List<User>
	 */
	private List<User> getListUser(RenderRequest req)
		throws Exception {

		List<User> results = new ArrayList<User>();
		// long documentSendId = ParamUtil.getLong(req, "documentSendId", 0);
		// long userId = PortalUtil.getUserId(req);
		// long tUserId = getAgencyLeader(userId);
		// User user = UserLocalServiceUtil.getUser(tUserId);
		// results.add(user);
		// User userLogin = UserLocalServiceUtil.getUser(userId);
		//
		// List<PmlDepartmentsLeader> pmlDepartmentsLeaderList = new
		// ArrayList<PmlDepartmentsLeader>();
		// try {
		// pmlDepartmentsLeaderList =
		// PmlDepartmentsLeaderUtil.findByUserId(userId);
		// } catch (Exception e) {
		// }
		//
		// if (!results.contains(userLogin) &&
		// pmlDepartmentsLeaderList.isEmpty()) {
		// results.add(0,userLogin);
		// }

		PortletPreferences prefs = req.getPreferences();
		String[] listUser = prefs.getValues("listUserLDB", new String[0]);

		User user = null;
		for (int i = 0; i < listUser.length; i++) {
			try {
				user = UserUtil.findByPrimaryKey(Long.parseLong(listUser[i]));
			}
			catch (Exception e) {
				user = null;
			}
			if (user != null) {
				results.add(user);
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
		// xuancong close _log.info("in processstrutsAction method");

		PortletSession session = req.getPortletSession();
		session.setAttribute(
			"transition", "transition", PortletSession.APPLICATION_SCOPE);
	}

	public ActionForward renderStruts(
		ActionMapping mapping, ActionForm form, PortletConfig config,
		RenderRequest req, RenderResponse res)
		throws Exception {

		// xuancong close _log.info("in renderstrutsAction method");
		List<User> users = getListUser(req);

		// get current page
		int page = ParamUtil.getInteger(req, "page", 1);

		// get total item of page
		int limit = ParamUtil.getInteger(req, "limit", 20); // default

		req.setAttribute("users", users);

		req.setAttribute("currentPage", page);
		req.setAttribute("currentLimit", limit);

		return mapping.findForward("portlet.sgs.pcccdocumentsendprocess.trans");
	}

	/**
	 * get team leader of an user via given userId
	 * 
	 * @param userId
	 * @return
	 */
	/*
	 * xuancong close start vi chua su dung private long getAgencyLeader(long
	 * userId) { PmlUser user = null; // get user in SGS Core try { user =
	 * PmlUserUtil.findByPrimaryKey(userId); } catch (Exception e) {
	 * _log.info("PML_User Not Found -> Department Leader Not found"); } // user
	 * not found return -1 if (Validator.isNull(user)) { return -1; } // get
	 * team leader of user. String departmentId = user.getDepartmentsId();
	 * PmlDepartment dep = null; try { dep =
	 * PmlDepartmentUtil.findByPrimaryKey(departmentId); } catch
	 * (NoSuchPmlDepartmentException e) { _log.error("Not Found Exception: ",
	 * e); } catch (SystemException e) { _log.error("System Exception", e); } if
	 * (Validator.isNull(dep)) { return -1; } String agencyId =
	 * dep.getAgencyId(); PmlAgencyLeader leader = null; try { leader =
	 * PmlAgencyLeaderUtil.findByPrimaryKey(agencyId); } catch
	 * (NoSuchPmlAgencyLeaderException e) { _log.error("Not Found Exception: ",
	 * e); } catch (SystemException e) { _log.error("System Exception", e); } if
	 * (Validator.isNull(leader)) { return -1; } return leader.getUserId(); }
	 * xuancong close end
	 */
}
