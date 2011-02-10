
package com.sgs.portlet.connecttogateway.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.sgs.portlet.document.edmsgateway.DocumentEdmsGateway;

public class ConfigurationActionImpl implements ConfigurationAction {

	public void processAction(
		PortletConfig portletConfig, ActionRequest actionRequest,
		ActionResponse actionResponse)
		throws Exception {

		String portletResource =
			ParamUtil.getString(actionRequest, "portletResource");

		String edmsGatewayUrl =
			ParamUtil.getString(actionRequest, "edmsGatewayUrl");
		String edmsGatewayUserName =
			ParamUtil.getString(actionRequest, "edmsGatewayUserName");
		String edmsGatewayPassword =
			ParamUtil.getString(actionRequest, "edmsGatewayPassword");
		long timerDelay = ParamUtil.getLong(actionRequest, "timerDelay");
		long timerDelayOrg = ParamUtil.getLong(actionRequest, "timerDelayOrg");
		long timerDelaySendMail =
			ParamUtil.getLong(actionRequest, "timerDelaySendMail");
		String edmsGatewayStatusNew =
			ParamUtil.getString(actionRequest, "edmsGatewayStatusNew");
		String edmsGatewayStatusRecieve =
			ParamUtil.getString(actionRequest, "edmsGatewayStatusRecieve");
		String edmsGatewayFromDate =
			ParamUtil.getString(actionRequest, "edmsGatewayFromDate");
		String edmsGatewayToDate =
			ParamUtil.getString(actionRequest, "edmsGatewayToDate");
		String edmsGatewaySubCompany =
			ParamUtil.getString(actionRequest, "edmsGatewaySubCompany");

		PortletPreferences prefs =
			PortletPreferencesFactoryUtil.getPortletSetup(
				actionRequest, portletResource);

		prefs.setValue("edmsGatewayUrl", edmsGatewayUrl);
		prefs.setValue("edmsGatewayUserName", edmsGatewayUserName);
		prefs.setValue("edmsGatewayPassword", edmsGatewayPassword);
		prefs.setValue("timerDelay", timerDelay + "");
		prefs.setValue("timerDelayOrg", timerDelayOrg + "");
		prefs.setValue("timerDelaySendMail", String.valueOf(timerDelaySendMail));
		prefs.setValue("edmsGatewayStatusNew", edmsGatewayStatusNew);
		prefs.setValue("edmsGatewayStatusRecieve", edmsGatewayStatusRecieve);
		prefs.setValue("edmsGatewayFromDate", edmsGatewayFromDate);
		prefs.setValue("edmsGatewayToDate", edmsGatewayToDate);
		prefs.setValue("edmsGatewaySubCompany", edmsGatewaySubCompany);

		prefs.store();

		// set value for connecttion object
		DocumentEdmsGateway.DEG.setEdmsGatewayUrl(edmsGatewayUrl);
		DocumentEdmsGateway.DEG.setEdmsGatewayUserName(edmsGatewayUserName);
		DocumentEdmsGateway.DEG.setEdmsGatewayPassword(edmsGatewayPassword);
		DocumentEdmsGateway.DEG.setTimerDelay(timerDelay);
		DocumentEdmsGateway.DEG.setTimerDelayOrg(timerDelayOrg);
		DocumentEdmsGateway.DEG.setTimerDelaySendMail(timerDelaySendMail);
		DocumentEdmsGateway.DEG.setEdmsGatewayStatusNew(edmsGatewayStatusNew);
		DocumentEdmsGateway.DEG.setEdmsGatewayStatusRecive(edmsGatewayStatusRecieve);
		DocumentEdmsGateway.DEG.setEdmsGatewayFromDate(edmsGatewayFromDate);
		DocumentEdmsGateway.DEG.setEdmsGatewayToDate(edmsGatewayToDate);
		DocumentEdmsGateway.DEG.setEdmsGatewaySubCompany(edmsGatewaySubCompany);
		DocumentEdmsGateway.DEG.setParamForConnectionDocument(DocumentEdmsGateway.DEG);

		SessionMessages.add(actionRequest, portletConfig.getPortletName() +
			".doConfigure");
	}

	public String render(
		PortletConfig portletConfig, RenderRequest renderRequest,
		RenderResponse renderResponse)
		throws Exception {

		return "/html/portlet/ext/connecttogateway/configuration.jsp";
	}

}
