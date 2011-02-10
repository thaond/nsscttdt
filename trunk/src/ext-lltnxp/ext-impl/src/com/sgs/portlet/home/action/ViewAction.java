
package com.sgs.portlet.home.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

public class ViewAction extends PortletAction {

	public void processAction(
		ActionMapping mapping, ActionForm form, PortletConfig config,
		ActionRequest req, ActionResponse res)
		throws Exception {

		/*
		 * Process Action Code Goes Here
		 */
	}

	public ActionForward render(
		ActionMapping mapping, ActionForm form, PortletConfig config,
		RenderRequest req, RenderResponse res)
		throws Exception {

		
		if (getForward(req) != null && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req)); // Use forward set in
															// processAction if
															// available
		}
		else {
			PortletPreferences prefs = req.getPreferences();

			String portletResource = ParamUtil.getString(req, "portletResource");

			if (Validator.isNotNull(portletResource)) {
				prefs =
					PortletPreferencesFactoryUtil.getPortletSetup(
						req, portletResource);
			}

			String oneDoor =
				GetterUtil.getString(prefs.getValue("oneDoor", StringPool.BLANK));
			req.setAttribute("oneDoor", oneDoor);
			
			String document =
				GetterUtil.getString(prefs.getValue("document", StringPool.BLANK));
			req.setAttribute("document", document);
		
			String news =
				GetterUtil.getString(prefs.getValue("news", StringPool.BLANK));
			req.setAttribute("news", news);

			String calendar =
				GetterUtil.getString(prefs.getValue("calendar", StringPool.BLANK));
			req.setAttribute("calendar", calendar);
			return mapping.findForward("portlet.sgs.home.view");
		}
	}
}
