package com.sgs.portlet.pcccdocumentreceiptprocess.action;

import java.util.List;

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
import com.sgs.portlet.document.model.PmlFileStatus;
import com.sgs.portlet.document.service.persistence.PmlFileStatusUtil;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.pmluser.service.persistence.PmlUserUtil;

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
		String[] dangXuLyChung = new String[0];
		String[] dangXuLyTuXuLy = new String[0];
		String[] daXuLyChung = new String[0];
		String[] daXuLyTuXuLy = new String[0];
		String[] listUser = new String [0];
		String[] listUserLDB = new String [0];
		String processDateNumber = ParamUtil.getString(req, "processDateNumber", "0");
		
		if (req.getParameterValues("dangXuLyChung") != null) {
			dangXuLyChung = req.getParameterValues("dangXuLyChung");
		}
		
		if (req.getParameterValues("dangXuLyTuXuLy") != null) {
			dangXuLyTuXuLy = req.getParameterValues("dangXuLyTuXuLy");
		}
		
		if (req.getParameterValues("daXuLyChung") != null) {
			daXuLyChung = req.getParameterValues("daXuLyChung");
		}
		
		if (req.getParameterValues("daXuLyTuXuLy") != null) {
			daXuLyTuXuLy = req.getParameterValues("daXuLyTuXuLy");
		}
		
		//list user lanh dao van phong
		if (req.getParameterValues("listUser") != null) {
			listUser = req.getParameterValues("listUser");
		}
		
		//list user lanh dao van ban
		if (req.getParameterValues("listUserLDB") != null) {
			listUserLDB = req.getParameterValues("listUserLDB");
		}
		
		pref.setValue("processDateNumber", processDateNumber);
		pref.setValues("dangXuLyChung", dangXuLyChung);
		pref.setValues("dangXuLyTuXuLy", dangXuLyTuXuLy);
		pref.setValues("daXuLyChung", daXuLyChung);
		pref.setValues("daXuLyTuXuLy", daXuLyTuXuLy);
		pref.setValues("listUser", listUser);
		pref.setValues("listUserLDB", listUserLDB);
	}

	public String render(PortletConfig config, RenderRequest request,
			RenderResponse response) throws Exception {
		List<PmlFileStatus> list = PmlFileStatusUtil.findAll();
		
		List<PmlUser> userList = PmlUserUtil.findAll();
		
		request.setAttribute("listFileStatus", list);
		request.setAttribute("userList", userList);
		return "/html/portlet/ext/pcccdocumentreceiptprocess/configuration.jsp";
	}

}
