package com.sgs.portlet.pcccdocumentsendprocess.action;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.sgs.liferay.jbpm.param.WorkflowParam;
import com.sgs.portlet.document.workflow.DocumentSendPortletAction;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.pmluser.service.persistence.PmlUserUtil;
import com.sgs.portlet.onedoorpccc.model.PmlTeamLeader;
import com.sgs.portlet.onedoorpccc.service.persistence.PmlTeamLeaderUtil;

/**
 * <ul>
 * <li>renderStruts: prepare data to view</li>
 * <li>processStrutsAction: process move to department leader action.<br/>
 * 	   After that, redirect to ViewAction</li>
 * </ul>
 * @author doanhdv
 * @author hieuvh
 */
public class MoveToTeamLeaderAction extends DocumentSendPortletAction {
	private static Log _log = LogFactory.getLog(MoveToTeamLeaderAction.class);
	
	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		long receiverId = ParamUtil.getLong(req, "receiverId", 0);
		String processInformation = ParamUtil.getString(req, "processInformation", "");
		
		addWorkflowParameter(req, "receiverId",  WorkflowParam.TRANSIENT, receiverId+"");
		addWorkflowParameter(req, "processInformation",  WorkflowParam.TRANSIENT, processInformation);
		addWorkflowParameter(req, "processor",  WorkflowParam.TRANSIENT, PortalUtil.getUserId(req)+"");
		_log.info("in processstrutsAction method");
		
		PortletSession session= req.getPortletSession();
		session.setAttribute("transition", "transition",PortletSession.APPLICATION_SCOPE);
	}

	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
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
		
		return mapping.findForward("portlet.sgs.pcccdocumentsendprocess.trans");
	}

	/**
	 * Get department leader in list
	 * @param req
	 * @return List<User>
	 */
	private List<User> getListUser(RenderRequest req) throws Exception {
		List<User> results = new ArrayList<User>();
		//xuancong close long documentSendId = ParamUtil.getLong(req, "documentSendId", 0);
		
		long userId = PortalUtil.getUserId(req);
		long tUserId = getTeamLeader(userId);
		
		User user = UserLocalServiceUtil.getUser(tUserId);
		
		results.add(user);
		return results;
	}

	/**
	 * get team leader of an user via given userId
	 * @param userId
	 * @return
	 */
	private long getTeamLeader(long userId) {
		PmlUser user = null;

		// get user in SGS Core
		try {
			user = PmlUserUtil.findByPrimaryKey(userId);
		} catch (Exception e) {
			_log.info("PML_User Not Found -> Department Leader Not found");
		}
		
		// user not found return -1
		if (Validator.isNull(user)) {
			return -1;
		}
		
		// get team leader of user.
		long teamId = user.getTeamId();
		
		PmlTeamLeader teamLeader = null;
		try {
			teamLeader = PmlTeamLeaderUtil.findByPrimaryKey(teamId);
		} catch (Exception e) {
		} 
				
		// team leader not found, return -1
		if (Validator.isNull(teamLeader)) {
			return -1;
		}
		
		// return userId of team leader
		return teamLeader.getUserId();
	}
}
