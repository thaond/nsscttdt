/**
 * 
 */
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
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.sgs.liferay.jbpm.param.WorkflowParam;
import com.sgs.portlet.document.workflow.DocumentSendLiferayWorkflowService;
import com.sgs.portlet.document.workflow.DocumentSendPortletAction;

/**
 * @author hieuvh
 *
 */
public class ApproveAction extends DocumentSendPortletAction {
	private static Log _log = LogFactory.getLog(ApproveAction.class);
	
	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		long receiverId = ParamUtil.getLong(req, "receiverId", 0);
		String processInformation = ParamUtil.getString(req, "processInformation", "");
		
		addWorkflowParameter(req, "receiverId",  WorkflowParam.TRANSIENT, receiverId+"");
		addWorkflowParameter(req, "processInformation",  WorkflowParam.TRANSIENT, processInformation);
//		addWorkflowParameter(req, "processor",  WorkflowParam.TRANSIENT, PortalUtil.getUserId(req)+"");
		
		// vu update 20110112
		
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
		
		
		// end vu update
		
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
		long documentSendId = ParamUtil.getLong(req, "documentSendId", 0);
		
		long userId = PortalUtil.getUserId(req);
		long tUserId = getCreator(documentSendId);
		
		User user = UserLocalServiceUtil.getUser(tUserId);
		
		results.add(user);
		return results;
	}

	/**
	 * get creator of document send id
	 * @param userId
	 * @return
	 */
	private long getCreator(long documentSendId) {
		return ((DocumentSendLiferayWorkflowService) getLiferayWorkflowService()).getCreatorDocumentSend(documentSendId);
	}
}
