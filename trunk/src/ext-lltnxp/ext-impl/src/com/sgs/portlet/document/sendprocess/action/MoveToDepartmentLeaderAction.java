package com.sgs.portlet.document.sendprocess.action;

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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.sgs.portlet.document.workflow.DocumentSendPortletAction;
import com.sgs.portlet.onedoor.model.PmlDepartmentsLeader;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.onedoor.service.persistence.PmlDepartmentsLeaderPK;
import com.sgs.portlet.onedoor.service.persistence.PmlDepartmentsLeaderUtil;
import com.sgs.portlet.pmluser.service.persistence.PmlUserUtil;

/**
 * <ul>
 * <li>renderStruts: prepare data to view</li>
 * <li>processStrutsAction: process move to department leader action.<br/>
 * 	   After that, redirect to ViewAction</li>
 * </ul>
 * @author doanhdv
 * @author hieuvh
 */
public class MoveToDepartmentLeaderAction extends DocumentSendPortletAction {
	private static Log _log = LogFactory.getLog(MoveToDepartmentLeaderAction.class);
	
	/* (non-Javadoc)
	 * @see com.sgs.liferay.web.struts.action.WorkflowPortletAction#processStrutsAction(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.portlet.PortletConfig, javax.portlet.ActionRequest, javax.portlet.ActionResponse)
	 */
	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		_log.info("process move to department leader action");
	}

	/* (non-Javadoc)
	 * @see com.sgs.liferay.web.struts.action.WorkflowPortletAction#renderStruts(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.portlet.PortletConfig, javax.portlet.RenderRequest, javax.portlet.RenderResponse)
	 */
	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
	
		if (getForward(req) != null && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req)); // Use forward set in processAction if available
		} else {
			_log.info("----------Prepare data for view ----------");
			//xuancong close long documentSendId = ParamUtil.getLong(req, "documentSendId");
			
			// sender is login user
			long userId = PortalUtil.getUserId(req);
			String sender = PortalUtil.getUserName(userId, "");
			
			// receiver is DepartmentLeader of User.
			long receiverId = getDepartmentLeader(userId);
			String receiver = PortalUtil.getUserName(receiverId, "");
			
			req.setAttribute("sender", sender);
			req.setAttribute("senderId", "" + userId);
			
			req.setAttribute("receiver", receiver);
			req.setAttribute("receiverId", "" + receiverId);
			
			return mapping.findForward("portlet.sgs.document.sendprocess.moveToDepartmentLeader");
		}
	}

	/**
	 * get department leader of an user via given userId
	 * @param userId
	 * @return
	 */
	private long getDepartmentLeader(long userId) {
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
		
		// get department leader of user.
		String departmentId = user.getDepartmentsId();
		
		PmlDepartmentsLeader leader = null;
		PmlDepartmentsLeaderPK departmentsLeaderPK = new PmlDepartmentsLeaderPK(departmentId, userId);
		try {
			leader = PmlDepartmentsLeaderUtil.findByPrimaryKey(departmentsLeaderPK);
		} catch (Exception e) {
			_log.info("Department Leader Not found");
		}
		
		// deparment leader not found, return -1
		if (Validator.isNull(leader)) {
			return -1;
		}
		
		// return userId of department leader
		return leader.getUserId();
	}
}
