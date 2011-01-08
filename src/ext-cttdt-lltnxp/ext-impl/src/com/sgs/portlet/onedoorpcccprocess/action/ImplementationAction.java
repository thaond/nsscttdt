package com.sgs.portlet.onedoorpcccprocess.action;

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
import com.sgs.portlet.onedoor.workflow.OneDoorProcessPortletAction;

public class ImplementationAction extends OneDoorProcessPortletAction {
	private static Log _log = LogFactory.getLog(TransferAction.class);
	
	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		// yenlt 24052010
		String isDelegate = ParamUtil.getString(req, "isDelegate");
		addWorkflowParameter(req, "isDelegate", WorkflowParam.TRANSIENT, isDelegate);
		addWorkflowParameter(req, "processor", WorkflowParam.TRANSIENT, String.valueOf(PortalUtil.getUserId(req)));
		// end yenlt 24052010
		PortletSession session= req.getPortletSession();
		session.setAttribute("transition", "transition",PortletSession.APPLICATION_SCOPE);
		sendImplementation(req);
		String redirect = ParamUtil.getString(req, "redirect");
		res.sendRedirect(redirect);
	}

	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		if (getForward(req) != null && !getForward(req).equals("")) {
			
			return mapping.findForward(getForward(req)); // Use forward set in processAction if available
		} else {
			
			List<User> users = getListUsers(req, res);
			_log.info("users: " + users);
			req.setAttribute("users", users);
			
			return mapping.findForward("portlet.sgs.onedoorpcccprocess.implementation");
		}
	}

	/**
	 * 
	 */
	private List<User> getListUsers(RenderRequest req, RenderResponse res) throws Exception {
		long taskId = ParamUtil.getLong(req, "taskId");
		_log.info("taskId: " + taskId);
		List<User> users = getLiferayWorkflowService().getPooledUser(taskId);
		return users;
	}
	
	private boolean sendImplementation(ActionRequest req) throws Exception {
		
		boolean flag = true;
		try {
			String strNote = ParamUtil.getString(req, "veViec") + "/\\/" + ParamUtil.getString(req, "ghiChu");
			addWorkflowParameter(req, "processInformation", WorkflowParam.TRANSIENT, strNote);
		} catch(Exception e) {
			flag = false;
		}
		return flag;
	}
	
}
