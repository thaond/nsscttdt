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

package com.nss.portlet.login.action;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.SendPasswordException;
import com.liferay.portal.UserEmailAddressException;
import com.liferay.portal.UserReminderQueryException;
import com.liferay.portal.kernel.captcha.CaptchaTextException;
import com.liferay.portal.kernel.captcha.CaptchaUtil;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PropsValues;
import com.liferay.portal.util.WebKeys;
import com.liferay.portlet.login.util.LoginUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * <a href="ForgotPasswordAction.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ForgotPasswordAction extends PortletAction {

	public void processAction(
			ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		try {
			User user = getUser(actionRequest);

			if (PropsValues.USERS_REMINDER_QUERIES_ENABLED &&
				(PropsValues.CAPTCHA_CHECK_PORTAL_SEND_PASSWORD ||
				 (Validator.isNotNull(user.getReminderQueryQuestion()) &&
				  Validator.isNotNull(user.getReminderQueryAnswer())))) {

				actionRequest.setAttribute(
					ForgotPasswordAction.class.getName(), user);

				int step = ParamUtil.getInteger(actionRequest, "step");

				if (step == 2) {
					if (PropsValues.CAPTCHA_CHECK_PORTAL_SEND_PASSWORD) {
						CaptchaUtil.check(actionRequest);
					}

					sendPassword(actionRequest, actionResponse);
				}
			}
			else {
				if (PropsValues.CAPTCHA_CHECK_PORTAL_SEND_PASSWORD) {
					CaptchaUtil.check(actionRequest);
				}

				sendPassword(actionRequest, actionResponse);
			}
		}
		catch (Exception e) {
			if (e instanceof CaptchaTextException ||
				e instanceof NoSuchUserException ||
				e instanceof SendPasswordException ||
				e instanceof UserEmailAddressException ||
				e instanceof UserReminderQueryException) {

				SessionErrors.add(actionRequest, e.getClass().getName());
			}
			else {
				PortalUtil.sendError(e, actionRequest, actionResponse);
			}
		}
	}

	public ActionForward render(
			ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		renderResponse.setTitle(
			LanguageUtil.get(
				themeDisplay.getCompanyId(), themeDisplay.getLocale(),
				"forgot-password"));

		return mapping.findForward("portlet.nss.login.forgot_password");
	}

	protected User getUser(ActionRequest actionRequest) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		long userId = ParamUtil.getLong(actionRequest, "userId");
		String screenName = ParamUtil.getString(actionRequest, "screenName");
		String emailAddress = ParamUtil.getString(
			actionRequest, "emailAddress");

		User user = null;

		if (Validator.isNotNull(emailAddress)) {
			user = UserLocalServiceUtil.getUserByEmailAddress(
				themeDisplay.getCompanyId(), emailAddress);
		}
		else if (Validator.isNotNull(screenName)) {
			user = UserLocalServiceUtil.getUserByScreenName(
				themeDisplay.getCompanyId(), screenName);
		}
		else if (userId > 0) {
			user = UserLocalServiceUtil.getUserById(userId);
		}
		else {
			throw new NoSuchUserException();
		}

		return user;
	}

	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}

	protected void sendPassword(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		User user = getUser(actionRequest);

		if (PropsValues.USERS_REMINDER_QUERIES_ENABLED) {
			String answer = ParamUtil.getString(actionRequest, "answer");

			if (!user.getReminderQueryAnswer().equals(answer)) {
				throw new UserReminderQueryException();
			}
		}

		PortletPreferences preferences = actionRequest.getPreferences();

		String languageId = LanguageUtil.getLanguageId(actionRequest);

		String emailFromName = preferences.getValue("emailFromName", null);
		String emailFromAddress = preferences.getValue(
			"emailFromAddress", null);
		String emailToAddress = user.getEmailAddress();
		String subject = preferences.getValue(
			"emailPasswordSentSubject_" + languageId, null);
		String body = preferences.getValue(
			"emailPasswordSentBody_" + languageId, null);

		LoginUtil.sendPassword(
			actionRequest, emailFromName, emailFromAddress, emailToAddress,
			subject, body);

		sendRedirect(actionRequest, actionResponse);
	}

	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;

}