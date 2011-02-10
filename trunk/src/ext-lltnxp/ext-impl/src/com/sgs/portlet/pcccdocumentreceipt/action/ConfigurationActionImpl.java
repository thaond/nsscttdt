package com.sgs.portlet.pcccdocumentreceipt.action;

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

		boolean privateDocument = ParamUtil.getBoolean(request,"privateDocument", false);
		boolean documentRecordTypeCode = ParamUtil.getBoolean(request,"documentRecordTypeCode", false);
		boolean documentTypeCode = ParamUtil.getBoolean(request,"documentTypeCode", false);
		String textAdd = ParamUtil.getString(request,"textAdd", "");
		boolean departmentCode = ParamUtil.getBoolean(request,"departmentCode", false);
		boolean useYear = ParamUtil.getBoolean(request,"useYear", false);
		
		pref.setValue("privateDocument", String.valueOf(privateDocument));
		pref.setValue("documentRecordTypeCode", String.valueOf(documentRecordTypeCode));
		pref.setValue("documentTypeCode", String.valueOf(documentTypeCode));
		pref.setValue("textAdd", String.valueOf(textAdd));
		pref.setValue("departmentCode", String.valueOf(departmentCode));
		pref.setValue("useYear", String.valueOf(useYear));
		
		if (SessionErrors.isEmpty(request)) {
			pref.store();

			SessionMessages.add(
				request, config.getPortletName() + ".doConfigure");
		}
	}

	public String render(PortletConfig config, RenderRequest request,
			RenderResponse response) throws Exception {
		return "/html/portlet/ext/pcccdocumentreceipt/configuration.jsp";
	}

}
