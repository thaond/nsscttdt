package com.sgs.portlet.document.receiptprocess.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sgs.portlet.document.workflow.DocumentReceiptPortletAction;

public class ConfirmViewAction extends DocumentReceiptPortletAction {
	
	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		
	}

	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
				
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); 
			} else {
				return mapping.findForward("portlet.sgs.document.receiptprocess.confirmView");
			}
	}
}
