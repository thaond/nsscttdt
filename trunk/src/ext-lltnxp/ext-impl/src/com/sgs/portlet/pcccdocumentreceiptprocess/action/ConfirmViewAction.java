package com.sgs.portlet.pcccdocumentreceiptprocess.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
import com.sgs.liferay.jbpm.param.WorkflowParam;
import com.sgs.portlet.document.workflow.DocumentReceiptPortletAction;

public class ConfirmViewAction extends DocumentReceiptPortletAction {
	
	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
//		addWorkflowParameter(req, "processor",  WorkflowParam.TRANSIENT, PortalUtil.getUserId(req) + "");
		//vu update 20110112
		
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
	}

	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
				
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); 
			} else {
				return mapping.findForward("portlet.sgs.pcccdocumentreceiptprocess.confirmView");
			}
	}
}
