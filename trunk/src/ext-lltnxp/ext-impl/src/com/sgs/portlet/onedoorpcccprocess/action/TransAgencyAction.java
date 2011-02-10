package com.sgs.portlet.onedoorpcccprocess.action;

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
import com.sgs.portlet.onedoor.workflow.OneDoorProcessPortletAction;

public class TransAgencyAction extends OneDoorProcessPortletAction {
	private static Log _log = LogFactory.getLog(TransAgencyAction.class);
	
	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig portletConfig, ActionRequest req,
			ActionResponse actionResponse) throws Exception {
		PortletSession session= req.getPortletSession();
		session.setAttribute("transition", "transition",PortletSession.APPLICATION_SCOPE);
		String isDelegate = ParamUtil.getString(req, "isDelegate");
		addWorkflowParameter(req, "isDelegate", WorkflowParam.TRANSIENT, isDelegate);
		addWorkflowParameter(req, "processor", WorkflowParam.TRANSIENT, String.valueOf(PortalUtil.getUserId(req)));
		
	}

	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig portletConfig, RenderRequest req,
			RenderResponse res) throws Exception {
		List<User> users = getListUsers(req, res);
		req.setAttribute("users", users);
		return mapping.findForward("portlet.sgs.onedoorpcccprocess.transfer");
	}

	/**
	 * Get list user from a department to process file
	 * @param req
	 * @param res
	 * @return List<User> users;
	 * @throws Exception
	 */
	private List<User> getListUsers(RenderRequest req, RenderResponse res){
		List<User> users = new ArrayList<User>();
		// lay ds user cau  hinh trong process
		try {
		long taskId = ParamUtil.getLong(req, "taskId");
	
			if (taskId != 0)  {		
				users = getLiferayWorkflowService().getPooledUser(taskId);
			}
			}catch (Exception e) {
				e.printStackTrace();
		}
		
		// lay them ds user co role add vao ds lanh dao
		PortletPreferences prefs = req.getPreferences();
		String[] listUser = prefs.getValues("dsNguoiKy", new String[0]);
		User signer = null;
		for (int i = 0; i < listUser.length; i++) {
			try {
				signer = UserUtil.findByPrimaryKey(Long.parseLong(listUser[i]));
				users.add(signer);
			} catch (Exception e) {
				_log.error(e.getMessage());
			}
		}
		Collections.sort(users, new Comparator<User>(){
			public int compare(User o1, User o2) {						
				return o1.getFullName().compareTo(o2.getFullName());
			}					
		});	
		
		return users;
	}
}
