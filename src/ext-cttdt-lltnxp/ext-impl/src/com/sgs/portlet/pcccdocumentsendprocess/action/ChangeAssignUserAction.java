/**
 * 
 */
package com.sgs.portlet.pcccdocumentsendprocess.action;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

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
 * @author 
 * @author  - interact workflow
 */
public class ChangeAssignUserAction extends DocumentReceiptPortletAction {
	//xuancong close private static Log _log = LogFactory.getLog(ChangeAssignUserAction.class);
	
	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
	}
	
	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		/* Get id of login user */
		long userId = PortalUtil.getUserId(req);
		
		/* Get user from userId */
		PmlUser nowUser = PmlUserLocalServiceUtil.getPmlUser(userId);
		
		/* Get department id of login user */ 
		String departmentId = nowUser.getDepartmentsId();
		//xuancong close _log.info("departmenId: " + departmentId);
		
		/* Get list of user in together department */
		List<PmlUser> userSportals = PmlUserUtil.findByDepartmentsId(departmentId);
		List<User> users = new ArrayList<User>();
		
		if (users != null) {
			//xuancong close _log.info("size user: " + userSportals.size());
			for (int i = 0; i < userSportals.size(); i++) {
				PmlUser pmlUser = userSportals.get(i);
				User user = UserLocalServiceUtil.getUser(pmlUser.getUserId());
				users.add(user);
			}
		}
		
		//sort with name
		for (int j = 0; j < users.size(); j++) {	
			int temp = j;
			for (int i = temp; i < users.size(); i++) {
				if (users.get(j).getFullName().compareTo(users.get(i).getFullName())> 0) {				
					java.util.Collections.swap(users, j, i);
				}
			}
		}
		
		req.setAttribute("userList", users);
		
		if (getForward(req) != null && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req)); // Use forward set in processAction if available
		} else {
			/* Foward to assign.jsp */
			return mapping.findForward("portlet.sgs.pcccdocumentsendprocess.changeusers");
		}
	}
}