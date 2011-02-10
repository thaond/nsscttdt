package com.sgs.portlet.imagehome.action;

import java.io.File;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ImageLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

public class ConfigurationActionImpl implements ConfigurationAction {
	private static Log _log = LogFactory.getLog(ViewAction.class);
	
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

	private void update(ActionRequest req, PortletPreferences prefs) throws Exception {
		long imageUpload = ParamUtil.getLong(req, "imageUpload", 0);
		String urlImageHome = ParamUtil.getString(req, "urlImageHome");
		String description = ParamUtil.getString(req, "descriptionImageHome");
		
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(req);
		File file = uploadRequest.getFile("fileImageHome");
		
		try {
			if (file.exists()) {
				if (imageUpload == 0) {
					imageUpload = CounterLocalServiceUtil.increment();
				}
				ImageLocalServiceUtil.updateImage(imageUpload, file);
				prefs.setValue("imageUpload", String.valueOf(imageUpload));
			}
			
		} catch (SystemException e) {
			_log.error(e);
		}
		
		prefs.setValue("urlImageHome", urlImageHome);
		prefs.setValue("descriptionImageHome", description);
	}
	

	public String render(PortletConfig config, RenderRequest request,
			RenderResponse response) throws Exception {
		return "/html/portlet/ext/imagehome/configuration.jsp";
	}

}
