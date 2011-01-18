package com.sgs.portlet.document_manager_index.action;

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
import com.liferay.portal.struts.PortletAction;

public class ViewAction extends PortletAction {
	private static Log _log = LogFactory.getLog(ViewAction.class);
	
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	
	public void processAction(ActionMapping mapping, ActionForm form, 
			PortletConfig config, ActionRequest req, ActionResponse res) throws Exception {
		
	}
	
	public ActionForward render(ActionMapping mapping, ActionForm form, PortletConfig config, RenderRequest req, RenderResponse res) throws Exception {
		try {
			String dateFrom = ParamUtil.getString(req, "dateFrom");
			String dateTo = ParamUtil.getString(req, "dateTo");
			req.setAttribute("dateFrom", dateFrom);
			req.setAttribute("dateTo", dateTo);
		} catch (Exception e) {
			_log.error("ERROR IN RENDER OF " + ViewAction.class + " " + e.getMessage());
		}
		if (getForward(req) != null && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req));
		} else {
			return mapping.findForward("portlet.sgs.document_manager_index.view");
		}	
	}
}
