/**
 * 
 */
package com.sgs.portlet.document.receiptprocess.action;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.sgs.portlet.document.workflow.DocumentReceiptPortletAction;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil;
import com.sgs.portlet.pmluser.service.persistence.PmlUserUtil;

/**
 * ChangeAssignAction class can forward to assign.jsp (renderStruts method)
 * @author doanhdv
 * @author hieuvh - interact workflow
 */
public class ChangeAssignAction extends DocumentReceiptPortletAction {
	private static Log _log = LogFactory.getLog(ChangeAssignAction.class);
	
	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		/*
		 * Process Action Code Goes Here
		 * 
		 * */
	}

	/**
	 * <p>
	 * Prepare data for assign form: list of user in together deparment with
	 * user login.
	 * </p>
	 * <p>
	 * Step: <br>
	 * - Get id of login user <br>
	 * - Get user from userId <br>
	 * - Get department id of login user <br>
	 * - Get list of user in together department <br>
	 * - Set list into attribute of request <br>
	 * </p>
	 */
	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		_log.info("render change assign action");
		
		/* Get id of login user */
		long userId = PortalUtil.getUserId(req);
		
		/* Get user from userId */
		PmlUser nowUser = PmlUserLocalServiceUtil.getPmlUser(userId);
		
		/* Get department id of login user */ 
		String departmentId = nowUser.getDepartmentsId();
		_log.info("departmenId: " + departmentId);
		
		/* Get list of user in together department */
		List<PmlUser> userSportals = PmlUserUtil.findByDepartmentsId(departmentId);
		List<User> users = new ArrayList<User>();
		
		if (users != null) {
			_log.info("size user: " + userSportals.size());
			for (int i = 0; i < userSportals.size(); i++) {
				PmlUser pmlUser = userSportals.get(i);
				User user = UserLocalServiceUtil.getUser(pmlUser.getUserId());
				users.add(user);
			}
		}
		
		req.setAttribute("users", users);
		
		if (getForward(req) != null && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req)); // Use forward set in processAction if available
		} else {
			/* Foward to assign.jsp */
			return mapping.findForward("portlet.sgs.document.receiptprocess.assign");
		}
	}
}
