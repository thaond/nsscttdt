
package com.nss.portlet.journal.action;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;
import com.nss.workflow.JournalLiferayPortletAction;
import com.nss.workflow.JournalLiferayWorkflowService;
import com.sgs.liferay.jbpm.param.WorkflowParam;

public class TransitionReviewJournalArticle extends JournalLiferayPortletAction {

	@Override
	public void processStrutsAction(
		ActionMapping arg0, ActionForm arg1, PortletConfig arg2,
		ActionRequest actionRequest, ActionResponse arg4)
		throws Exception {

		System.out.println("da vao processAction void taskId: ");

		String resourcePrimey =
			ParamUtil.getString(actionRequest, "resourcePrimey");

		String processInformation =
			ParamUtil.getString(actionRequest, "processInformation");

		String userIds = ParamUtil.getString(actionRequest, "userIds");

		addWorkflowParameter(
			actionRequest, "userId", WorkflowParam.TRANSIENT,
			String.valueOf(PortalUtil.getUserId(actionRequest)));

		addWorkflowParameter(
			actionRequest, "resourcePrimey", WorkflowParam.TRANSIENT,
			resourcePrimey);

		addWorkflowParameter(
			actionRequest, "processInformation", WorkflowParam.TRANSIENT,
			processInformation);

		addWorkflowParameter(
			actionRequest, "userIds", WorkflowParam.TRANSIENT, userIds);

		addWorkflowParameter(
			actionRequest, "userIdProcess", WorkflowParam.TRANSIENT,
			String.valueOf(PortalUtil.getUserId(actionRequest)));

	}

	@Override
	public ActionForward renderStruts(
		ActionMapping mapping, ActionForm arg1, PortletConfig arg2,
		RenderRequest req, RenderResponse arg4)
		throws Exception {

		long taskId = ParamUtil.getLong(req, "wf_taskId");
		List<User> users =
			((JournalLiferayWorkflowService) getLiferayWorkflowService()).getListUsers(taskId);
		req.setAttribute("users", users);

		return mapping.findForward("portlet.nss.journal.transitionreviewjournalarticle");
	}

}
