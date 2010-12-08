/**
 * 
 */
package com.nss.workflowonedoor.command;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.WebKeys;
import com.liferay.util.servlet.ServletResponseUtil;
import com.sgs.liferay.jbpm.command.StrutsActionCommandResultProcessor;

/**
 * @author hieuvh
 *
 */
public class InBienNhanCommandResultProcessor extends
		StrutsActionCommandResultProcessor {

	@Override
	protected void processResultInStrutsAction(Object result) {
		
		ThemeDisplay themeDisplay =
			(ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);

		HttpServletRequest req = PortalUtil.getHttpServletRequest(
			request);
		HttpServletResponse res = PortalUtil.getHttpServletResponse(
			response);

		getFile(
			result, themeDisplay, req, res);

	}

	private void getFile(Object result, ThemeDisplay themeDisplay,
			HttpServletRequest request, HttpServletResponse response) {

		try {
			ServletResponseUtil.sendFile(response, "bienNhanHoSo.rtf", (InputStream) result, "application/rtf");
		} 
		catch (IOException e) {
			e.printStackTrace();
		} finally {
		}
		
	}

}
