/**
 * 
 */
package com.sgs.portlet.document.receiptprocess.action;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.struts.PortletAction;
import com.sgs.portlet.document.receipt.dto.LogProcessDTO;
import com.sgs.portlet.document.receipt.util.DocumentReceiptUtil;

/**
 * @author doanhdv
 *
 */
public class ShowProcessAction extends PortletAction {
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		/*
		 * Process Action Code Goes Here
		 * 
		 * */
	}

	
	

	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		List<LogProcessDTO> logProcessDTOs = DocumentReceiptUtil.getLogProcessDTOs();
		req.setAttribute("logProcessDTOs", logProcessDTOs);
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				return mapping.findForward("portlet.sgs.document.receiptprocess.showProcess");
			}
	}
}
