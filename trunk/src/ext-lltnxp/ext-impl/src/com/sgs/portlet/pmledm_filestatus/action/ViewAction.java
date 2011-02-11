/**
 * @author triltm
 * @since 10/04/2009
 * @version 1.0
 * This class access admin to do some action with file status
 */

package com.sgs.portlet.pmledm_filestatus.action;

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

public class ViewAction extends PortletAction {
	/**
	 * Yen update 2009-12-21
	 */
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}

	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		

	}
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		

		String tabs = ParamUtil.getString(req, "tabs" );
		req.setAttribute("tabs", tabs);
		
			return mapping.findForward("portlet.sgs.pmledm_filestatus.view");
	}
	
	
}
