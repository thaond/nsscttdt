package com.sgs.portlet.onedoorpcccprocess.action;

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
import com.liferay.portal.util.PortalUtil;
import com.sgs.liferay.jbpm.param.WorkflowParam;
import com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile;
import com.sgs.portlet.onedoor.service.persistence.PmlOneDoorReceiveFileUtil;
import com.sgs.portlet.onedoor.workflow.OneDoorProcessLiferayWorkflowService;
import com.sgs.portlet.onedoor.workflow.OneDoorProcessPortletAction;

public class BackFileAction extends OneDoorProcessPortletAction {
	private static Log _log = LogFactory.getLog(BackFileAction.class);
	
	@Override
	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		PortletSession session= req.getPortletSession();
		session.setAttribute("transition", "transition",PortletSession.APPLICATION_SCOPE);
		// yenlt 24052010
		String isDelegate = ParamUtil.getString(req, "isDelegate");
		addWorkflowParameter(req, "isDelegate", WorkflowParam.TRANSIENT, isDelegate);
		addWorkflowParameter(req, "processor", WorkflowParam.TRANSIENT, String.valueOf(PortalUtil.getUserId(req)));
		// end yenlt 24052010
	}
	
	@Override
	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
			List<User> users = getListUsers(req, res);
			req.setAttribute("users", users);
			String fileId = ParamUtil.getString(req, "fileId");
			try {
				PmlOneDoorReceiveFile file = PmlOneDoorReceiveFileUtil.findByPrimaryKey(fileId);
				String numberreceipt = file.getNumberReceipt();
				req.setAttribute("numberreceipt", numberreceipt);
			} catch (Exception e) {}
			return mapping.findForward("portlet.sgs.onedoorpcccprocess.transfer");
	}

	/**
	 * Get list user from a department to process file
	 * @param req
	 * @param res
	 * @return List<User> users;
	 * @throws Exception
	 */
	private List<User> getListUsers(RenderRequest req, RenderResponse res) throws Exception {
		List<User> result = new ArrayList<User>();
		String fileId = ParamUtil.getString(req,"fileId");
		OneDoorProcessLiferayWorkflowService oneDoorProcessLiferayWorkflowService  = (OneDoorProcessLiferayWorkflowService) getLiferayWorkflowService();
		User user= oneDoorProcessLiferayWorkflowService.getUserBackProcess(fileId);
		result.add(user);
		return result;
	}
}
