package com.nss.portlet.journalworkflow.action;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.nss.portlet.journalworkflow.model.JournalProcessDefinition;
import com.nss.portlet.journalworkflow.service.JournalProcessDefinitionLocalServiceUtil;
import com.nss.portlet.journalworkflow.util.XmlRead;

public class ConfigurationActionImpl implements ConfigurationAction {

	@Override
	public void processAction(PortletConfig portletConfig,
			ActionRequest req, ActionResponse res)
			throws Exception {
		long bpid = ParamUtil.getLong(req, "currentBpid");
		int delta = ParamUtil.getInteger(req, "delta", 10);
		JournalProcessDefinition definition;
		List<String> keys = new ArrayList<String>();
		
		String portletResource = ParamUtil.getString(req, "portletResource");
		PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(req, portletResource);
		if (bpid > 0) {
			//definition = ProcessDefinitionUtil.findByPrimaryKey(bpid);
			definition = JournalProcessDefinitionLocalServiceUtil.getJournalProcessDefinition(bpid);
			
			keys = XmlRead.getNodeName("task-node", definition.getContent());
			if (keys.size() > 0) {
				preferences.setValue("bpid", String.valueOf(bpid));
				for (String s : keys) {
					preferences.setValue(s, ParamUtil.getString(req, s));
				}
			}
		}
		preferences.setValue("delta", String.valueOf(delta));
		preferences.store();
	}

	@Override
	public String render(PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
			throws Exception {
		return "/html/portlet/nss/journalworkflow/configuration.jsp";
	}

}
