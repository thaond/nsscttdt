package com.nss.portlet.link_display.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.portlet.BaseConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

public class ConfigurationActionImpl extends BaseConfigurationAction{
	private static Log _log = LogFactory.getLog(ConfigurationActionImpl.class);
	
	public void processAction(
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse)
		throws Exception {

		String portletResource = ParamUtil.getString(
				actionRequest, "portletResource");

		PortletPreferences preferences =
			PortletPreferencesFactoryUtil.getPortletSetup(
				actionRequest, portletResource);

		updateDisplaySettings(actionRequest, preferences);
		
		if (SessionErrors.isEmpty(actionRequest)) {
			preferences.store();

			SessionMessages.add(
				actionRequest,
				portletConfig.getPortletName() + ".doConfigure");
		}
	}
	
	public void updateDisplaySettings(ActionRequest actionRequest,
			PortletPreferences preferences) {
		String displayStyle = ParamUtil.getString(actionRequest, "displayStyle");
		try {
			preferences.setValue("display-style", displayStyle);
		} catch (ReadOnlyException e) {
			_log.error(e.getMessage());
		}
		
		
	}

	public String render(
			PortletConfig portletConfig, RenderRequest renderRequest,
			RenderResponse renderResponse)
		throws Exception {

		return "/html/portlet/nss/link_display/configuration.jsp";
	}
}
