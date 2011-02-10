/**
 * Lay thong tin xu ly tung buoc cong van di tu khoi tao den trang thai hien tai
 * Liet ke cac trang thai 
 */
package com.sgs.portlet.document.sendprocess.action;

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

import com.liferay.portal.kernel.util.ParamUtil;
import com.sgs.portlet.document.workflow.DocumentSendPortletAction;

/**
 * @author doanhdv
 *
 */
public class ShowProcessAction extends DocumentSendPortletAction {
	private static Log _log = LogFactory.getLog(ShowProcessAction.class);
	@Override
	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		/*
		 * Process Action Code Goes Here
		 * 
		 * */
	}

	@Override
	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		//load cac danh muc dung chung cho cac select box
		
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				long documentSendId = ParamUtil.getLong(req, "documentSendId");
				List<com.sgs.portlet.document.send.dto.LogProcessDTO> logProcessDTOs = getLogProcessDTOs(documentSendId);
				req.setAttribute("logProcessDTOs", logProcessDTOs);
				return mapping.findForward("portlet.sgs.document.sendprocess.showProcess");
			}
	}
}
