/**
 * Copyright (c) 2000-2009 Liferay, Inc. All rights reserved.
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

package com.liferay.portlet.journalcontentsearch.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.portlet.BaseConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

/**
 * <a href="ConfigurationActionImpl.java.html"><b><i>View Source</i></b></a>
 * 
 * @author Richard Beatty
 * @author Raymond Augé
 */
public class ConfigurationActionImpl extends BaseConfigurationAction {

	public void processAction(
		PortletConfig portletConfig, ActionRequest actionRequest,
		ActionResponse actionResponse)
		throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		if (!cmd.equals(Constants.UPDATE)) {
			return;
		}

		boolean showListed = ParamUtil.getBoolean(actionRequest, "showListed");
		String targetPortletId =
			ParamUtil.getString(actionRequest, "targetPortletId");
		String type = ParamUtil.getString(actionRequest, "type");

		String portletResource =
			ParamUtil.getString(actionRequest, "portletResource");
		String search_type =
			ParamUtil.getString(actionRequest, "c_search_type");

		PortletPreferences preferences =
			PortletPreferencesFactoryUtil.getPortletSetup(
				actionRequest, portletResource);

		preferences.setValue("show-listed", String.valueOf(showListed));
		preferences.setValue("target-portlet-id", targetPortletId);
		preferences.setValue("type", type);
		preferences.setValue("c_search_type", search_type);

		preferences.store();

		SessionMessages.add(actionRequest, portletConfig.getPortletName() +
			".doConfigure");
	}

	public String render(
		PortletConfig portletConfig, RenderRequest renderRequest,
		RenderResponse renderResponse)
		throws Exception {

		return "/html/portlet/journal_content_search/configuration.jsp";
	}

}
