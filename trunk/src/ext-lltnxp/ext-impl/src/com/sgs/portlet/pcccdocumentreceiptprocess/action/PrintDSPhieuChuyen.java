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
import com.liferay.portal.struts.PortletAction;

public class PrintDSPhieuChuyen extends PortletAction {
	
	public void processAction(
			ActionMapping mapping, ActionForm form, PortletConfig config,
			ActionRequest req, ActionResponse res) throws Exception {
	}
	
	
	public ActionForward render(
			ActionMapping mapping, ActionForm form, PortletConfig config,
			RenderRequest req, RenderResponse res)
			throws Exception {
		
		String documentReceiptIdList = ParamUtil.getString(req, "documentReceiptIdList", "");
		req.setAttribute("documentReceiptIdList", documentReceiptIdList);
		
		return mapping.findForward("portlet.sgs.pcccdocumentreceiptprocess.printlist");
	}

}
