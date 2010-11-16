package com.nss.portlet.journalworkflow.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.dom4j.Document;

import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.struts.PortletAction;
import com.nss.portlet.journalworkflow.util.SAWWorkflowUtil;
import com.nss.portlet.journalworkflow.util.XmlRead;

public class ViewAction extends PortletAction {
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;

	protected boolean isCheckMethodOnProcessAction() {
	return _CHECK_METHOD_ON_PROCESS_ACTION;
	}


	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		String cmd = ParamUtil.getString(req, Constants.CMD);
		String redirect = ParamUtil.getString(req, "redirect","/nss/journalworkflow/view");
		if (cmd.equals("addBusinessProcess")) {
			addBusinessProcess(req, res);
		} 
		sendRedirect(req, res, redirect);
	}

	
	
	private void addBusinessProcess(ActionRequest req, ActionResponse res) {
		String xml = ParamUtil.getString(req, "bpdText");
		Document document = XmlRead.parse(xml);
		SAWWorkflowUtil.deploy(document.asXML());
	}



	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				return mapping.findForward("portlet.nss.journalworkflow.view");
			}
	}

}
