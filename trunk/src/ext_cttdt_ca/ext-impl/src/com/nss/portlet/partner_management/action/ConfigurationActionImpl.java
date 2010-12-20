package com.nss.portlet.partner_management.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.portlet.BaseConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

public class ConfigurationActionImpl extends BaseConfigurationAction {
	
	public void processAction(
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse)
		throws Exception {

		String portletResource = ParamUtil.getString(actionRequest, "portletResource");

		PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);

		updateSettings(actionRequest, preferences);
		
		if (SessionErrors.isEmpty(actionRequest)) {
			preferences.store();

			SessionMessages.add(actionRequest, portletConfig.getPortletName() + ".doConfigure");
		}
	}
	

	public String render(PortletConfig portletConfig, RenderRequest renderRequest,
			RenderResponse renderResponse) throws Exception {

		return "/html/portlet/nss/partner_management/configuration.jsp";
	}


	protected void updateSettings(
			ActionRequest actionRequest, PortletPreferences preferences)
		throws Exception {

		String displayStyle = ParamUtil.getString(actionRequest, "displayStyle");
		
		preferences.setValue("displayStyle", displayStyle);
	}

}