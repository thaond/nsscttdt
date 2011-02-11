package com.sgs.portlet.phathanhcongvandi.action;

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

		update(request, pref);
		if (SessionErrors.isEmpty(request)) {
			pref.store();

			SessionMessages.add(
				request, config.getPortletName() + ".doConfigure");
		}
	}

	private void update(ActionRequest req, PortletPreferences pref) throws Exception {
		boolean documentRecordTypeCode = ParamUtil.getBoolean(req,"documentRecordTypeCode", false);
		boolean documentTypeCode = ParamUtil.getBoolean(req,"documentTypeCode", false);
		String textAdd = ParamUtil.getString(req,"textAdd", "");
		boolean departmentCode = ParamUtil.getBoolean(req,"departmentCode", false);
		boolean useYear = ParamUtil.getBoolean(req,"useYear", false);
		
		pref.setValue("documentRecordTypeCode", String.valueOf(documentRecordTypeCode));
		pref.setValue("documentTypeCode", String.valueOf(documentTypeCode));
		pref.setValue("textAdd", String.valueOf(textAdd));
		pref.setValue("departmentCode", String.valueOf(departmentCode));
		pref.setValue("useYear", String.valueOf(useYear));
	}

	public String render(PortletConfig config, RenderRequest request,
			RenderResponse response) throws Exception {
		return "/html/portlet/ext/phathanhcongvandi/configuration.jsp";
	}

}
