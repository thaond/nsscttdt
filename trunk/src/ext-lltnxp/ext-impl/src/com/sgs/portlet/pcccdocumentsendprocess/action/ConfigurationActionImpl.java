/**
 * 
 */
package com.sgs.portlet.pcccdocumentsendprocess.action;

/**
 * @author minhtri
 *
 */
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

	public void processAction(PortletConfig config, ActionRequest req,
			ActionResponse res) throws Exception {
		String portletResource = ParamUtil.getString(req, "portletResource");
		PortletPreferences pref = PortletPreferencesFactoryUtil.getPortletSetup(req, portletResource);
		update(req, pref);
		if (SessionErrors.isEmpty(req)) {
			pref.store();

			SessionMessages.add(
				req, config.getPortletName() + ".doConfigure");
		}
		
	}

	private void update(ActionRequest req, PortletPreferences pref) throws Exception {
		String[] dangXuLyChung = new String[0];
		String[] dangXuLyTuXuLy = new String[0];
		String[] daXuLyChung = new String[0];
		String[] daXuLyTuXuLy = new String[0];
		String[] listUser = new String [0];
		String[] listUserLDB = new String [0];
		if (req.getParameterValues("congVanDiDangXuLyChung") != null) {
			dangXuLyChung = req.getParameterValues("congVanDiDangXuLyChung");
		}
		
		if (req.getParameterValues("congVanDiDangXuLyTuXuLy") != null) {
			dangXuLyTuXuLy = req.getParameterValues("congVanDiDangXuLyTuXuLy");
		}
		
		if (req.getParameterValues("congVanDiDaXuLyChung") != null) {
			daXuLyChung = req.getParameterValues("congVanDiDaXuLyChung");
		}
		
		if (req.getParameterValues("congVanDiDaXuLyTuXuLy") != null) {
			daXuLyTuXuLy = req.getParameterValues("congVanDiDaXuLyTuXuLy");
		}
		
		//list user lanh dao van phong
		if (req.getParameterValues("listUser") != null) {
			listUser = req.getParameterValues("listUser");
		}
		
		//list user lanh dao van ban
		if (req.getParameterValues("listUserLDB") != null) {
			listUserLDB = req.getParameterValues("listUserLDB");
		}
		
		pref.setValues("congVanDiDangXuLyChung", dangXuLyChung);
		pref.setValues("congVanDiDangXuLyTuXuLy", dangXuLyTuXuLy);
		pref.setValues("congVanDiDaXuLyChung", daXuLyChung);
		pref.setValues("congVanDiDaXuLyTuXuLy", daXuLyTuXuLy);
		pref.setValues("listUser", listUser);
		pref.setValues("listUserLDB", listUserLDB);
		
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

	public String render(PortletConfig config, RenderRequest req,
			RenderResponse res) throws Exception {
		
		List<PmlFileStatus> list = PmlFileStatusUtil.findAll();
		List<PmlUser> userList = PmlUserUtil.findAll();
		req.setAttribute("listFileStatus", list);
		req.setAttribute("userList", userList);
		return "/html/portlet/ext/pcccdocumentsendprocess/configuration.jsp";
	}
	
}
