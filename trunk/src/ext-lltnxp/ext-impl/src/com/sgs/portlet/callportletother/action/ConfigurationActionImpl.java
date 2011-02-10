package com.sgs.portlet.callportletother.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

public class ConfigurationActionImpl implements ConfigurationAction {

	public void processAction(PortletConfig config, ActionRequest request,
			ActionResponse response) throws Exception {
		String portletResource = ParamUtil
				.getString(request, "portletResource");

		PortletPreferences pref = PortletPreferencesFactoryUtil
				.getPortletSetup(request, portletResource);

		String scriptSharing = ParamUtil.getString(request,"scriptSharing", "");
		pref.setValue("scriptSharing", String.valueOf(scriptSharing));
		if (SessionErrors.isEmpty(request)) {
			pref.store();

			SessionMessages.add(
				request, config.getPortletName() + ".doConfigure");
		}
	}

	public String render(PortletConfig config, RenderRequest request,
			RenderResponse response) throws Exception {
		return "/html/portlet/ext/callportletother/configuration.jsp";
	}

}
