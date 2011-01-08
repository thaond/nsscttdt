package com.sgs.portlet.pcccdocumentsendprocess.action;

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

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.sgs.liferay.jbpm.param.WorkflowParam;
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
	
	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		long receiverId = ParamUtil.getLong(req, "receiverId", 0);
		String processInformation = ParamUtil.getString(req, "processInformation", "");
		
		addWorkflowParameter(req, "receiverId",  WorkflowParam.TRANSIENT, receiverId+"");
		addWorkflowParameter(req, "processInformation",  WorkflowParam.TRANSIENT, processInformation);
		addWorkflowParameter(req, "processor",  WorkflowParam.TRANSIENT, PortalUtil.getUserId(req)+"");
		_log.info("in processstrutsAction method");
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
		
		User creator = getCreator(documentSendId);
		
		results.add(creator);
		return results;
	}

	/**
	 * get creator of document for send back
	 * @param documentSendId
	 * @return
	 */
	private User getCreator(long documentSendId) {
		long userId = ((DocumentSendLiferayWorkflowService) getLiferayWorkflowService()).getCreatorDocumentSend(documentSendId);
		try {
			return UserLocalServiceUtil.getUser(userId);
		} catch (PortalException e) {
			_log.error("From Portal Exception: " + e);
		} catch (SystemException e) {
			_log.error("From System Exception" + e);
		}
		
		return null;
	}
}
