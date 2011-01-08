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

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
import com.sgs.portlet.document.workflow.DocumentSendLiferayWorkflowService;
import com.sgs.portlet.document.workflow.DocumentSendPortletAction;

/**
 * <ul>
 * <li>renderStruts: prepare data to view</li>
 * <li>processStrutsAction: process move to department leader action.<br/>
 * 	   After that, redirect to ViewAction</li>
 * </ul>
 * @author doanhdv
 * @author hieuvh
 */
public class RequestAdditionalAction extends DocumentSendPortletAction {
	private static Log _log = LogFactory.getLog(RequestAdditionalAction.class);
	
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
			long documentSendId = ParamUtil.getLong(req, "documentSendId");
			
			// sender is login user
			long userId = PortalUtil.getUserId(req);
			String sender = PortalUtil.getUserName(userId, "");
			
			// receiver is DepartmentLeader of User.
			long receiverId = ((DocumentSendLiferayWorkflowService)getLiferayWorkflowService())
					.getCreatorDocumentSend(documentSendId);
			String receiver = PortalUtil.getUserName(receiverId, "");
			
			req.setAttribute("sender", sender);
			req.setAttribute("senderId", "" + userId);
			
			req.setAttribute("receiver", receiver);
			req.setAttribute("receiverId", "" + receiverId);
			
			return mapping.findForward("portlet.sgs.document.sendprocess.requestAdditional");
		}
	}
}
