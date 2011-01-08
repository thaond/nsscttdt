package com.sgs.portlet.pml_tinh_chat.action;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat;
import com.sgs.portlet.pml_tinh_chat.service.PmlTinhChatLocalServiceUtil;
import com.ext.portal.util.WebKeysExt;

import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * <a href="ActionUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Hai Trieu
 *
 */
public class ActionUtil {

	public static void getPmlTinhChat(ActionRequest actionRequest)
		throws Exception {

		HttpServletRequest request = PortalUtil.getHttpServletRequest(
			actionRequest);

		getPmlTinhChat(request);
	}

	public static void getPmlTinhChat(RenderRequest renderRequest)
		throws Exception {

		HttpServletRequest request = PortalUtil.getHttpServletRequest(
			renderRequest);

		getPmlTinhChat(request);
	}

	public static void getPmlTinhChat(HttpServletRequest request) 
	throws Exception {
		long idTinhChat = ParamUtil.getLong(request, "idTinhChat");
		

		PmlTinhChat pmlTinhChat = null;

		if (Validator.isNotNull(idTinhChat)) {
			pmlTinhChat = PmlTinhChatLocalServiceUtil.getPmlTinhChat(idTinhChat);
		}

		request.setAttribute(WebKeysExt.PMLTINHCHAT, pmlTinhChat);
	}
}