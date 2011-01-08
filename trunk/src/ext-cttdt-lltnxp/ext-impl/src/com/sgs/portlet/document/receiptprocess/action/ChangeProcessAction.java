package com.sgs.portlet.document.receiptprocess.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.struts.PortletAction;
import com.sgs.portlet.document.workflow.DocumentReceiptPortletAction;

/**
 * @author doanhdv
 * @author hieuvh
 *
 */
public class ChangeProcessAction extends DocumentReceiptPortletAction {
	
	/* (non-Javadoc)
	 * @see com.sgs.liferay.web.struts.action.WorkflowPortletAction#processStrutsAction(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.portlet.PortletConfig, javax.portlet.ActionRequest, javax.portlet.ActionResponse)
	 */
	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
	}

	/* (non-Javadoc)
	 * @see com.sgs.liferay.web.struts.action.WorkflowPortletAction#renderStruts(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.portlet.PortletConfig, javax.portlet.RenderRequest, javax.portlet.RenderResponse)
	 */
	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		
		if (getForward(req) != null && !getForward(req).equals("")) {
			// Use forward set in processAction if available
			return mapping.findForward(getForward(req));
		} else {
			return mapping.findForward("portlet.sgs.document.receiptprocess.process");
		}
	}
}
