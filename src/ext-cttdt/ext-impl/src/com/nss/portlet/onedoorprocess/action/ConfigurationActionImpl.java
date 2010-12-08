/**
 * Copyright (c) 2000-2008 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.nss.portlet.onedoorprocess.action;

import java.util.ArrayList;
import java.util.List;

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
import com.nss.portlet.department.model.PmlDepartmentsLeader;
import com.nss.portlet.department.model.PmlUser;
import com.nss.portlet.department.service.PmlDepartmentsLeaderLocalServiceUtil;
import com.nss.portlet.department.service.PmlUserLocalServiceUtil;
import com.nss.portlet.onedoor.model.PmlStateProcess;
import com.nss.portlet.onedoor.service.PmlStateProcessLocalServiceUtil;

/**
 * <a href="ConfigurationActionImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ConfigurationActionImpl implements ConfigurationAction {

	public void processAction(
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse)
		throws Exception {
		String portletResource = ParamUtil.getString(
			actionRequest, "portletResource");
		String isProcess = ParamUtil.getString(
			actionRequest, "isProcess");

		String showStatus = ParamUtil.getString(
				actionRequest, "showStatus");
		
		PortletPreferences prefs =
			PortletPreferencesFactoryUtil.getPortletSetup(
				actionRequest, portletResource);

		prefs.setValue("isProcess", isProcess);
		prefs.setValue("showStatus", showStatus);

		// yenlt 20082010
		update(actionRequest, prefs);
		prefs.store();

		SessionMessages.add(
			actionRequest, portletConfig.getPortletName() + ".doConfigure");
	}
	private void update(ActionRequest req, PortletPreferences pref) throws Exception {
		String[] dsNguoiKy = new String[0];
		
		if (req.getParameterValues("dsNguoiKy") != null) {
			dsNguoiKy = req.getParameterValues("dsNguoiKy");
		}
		
		pref.setValues("dsNguoiKy", dsNguoiKy);
	}
	// end yenlt 20082010
	public String render(
			PortletConfig portletConfig, RenderRequest renderRequest,
			RenderResponse renderResponse)
		throws Exception {
		
		List<PmlStateProcess> list = PmlStateProcessLocalServiceUtil.getPmlStateProcesses(-1, -1);
		// yenlt update add them user vao ds nguoi ky 20082010
		List<PmlDepartmentsLeader> leaders = PmlDepartmentsLeaderLocalServiceUtil.getPmlDepartmentsLeaders(-1, -1);
		List<PmlUser> userList = new ArrayList<PmlUser>();
		PmlUser userLeader = null;
		long userId = 0;
		for (int i = 0; i < leaders.size(); i++) {
			userId = leaders.get(i).getUserId();
			try {
				userLeader = PmlUserLocalServiceUtil.getPmlUser(userId);
			} catch (Exception e) {
				userLeader = null;
			}
			if (null != userLeader) {
				userList.add(userLeader);
			}
		}
		
		renderRequest.setAttribute("userList", userList);
		// end yenlt 20802010
		renderRequest.setAttribute("listStateProcess", list);
		return "/html/portlet/nss/onedoorprocess/configuration.jsp";
	}

}