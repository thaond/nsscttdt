package com.sgs.portlet.pcccdocumentrecordto.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.struts.PortletAction;

public class DetailAction extends PortletAction {
	
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		// Do nothing
	}
			
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		
		if (getForward(req) != null && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req));
		} 
		else {
			return mapping.findForward("portlet.sgs.pcccdocumentrecordto.detail");
		}
	}
}