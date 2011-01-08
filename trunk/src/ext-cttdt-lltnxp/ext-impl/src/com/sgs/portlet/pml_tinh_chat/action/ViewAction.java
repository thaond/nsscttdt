package com.sgs.portlet.pml_tinh_chat.action;

import ise.antelope.tasks.typedefs.string.Substring;

import com.liferay.portal.kernel.util.Validator;
import com.sgs.portlet.pml_tinh_chat.NoSuchPmlTinhChatException;
import com.sgs.portlet.pml_tinh_chat.PmlTinhChatTenTinhChatException;
import com.sgs.portlet.pml_tinh_chat.PmlTinhChatCanNotDeleteException;
import com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat;
import com.sgs.portlet.pml_tinh_chat.action.ActionUtil;
import com.sgs.portlet.pml_tinh_chat.service.PmlTinhChatLocalServiceUtil;
import com.sgs.portlet.pml_tinh_chat.service.PmlTinhChatServiceUtil;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;


import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * <a href="ViewAction.java.html"><b><i>View Source</i></b></a>
 *
 * @author Hai Trieu
 *
 */
public class ViewAction extends PortletAction {

	public void processAction(
			ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
		try {
			if (cmd.equals(Constants.ADD) || cmd.equals(Constants.UPDATE)) {
				updatePmlTinhChat(actionRequest);
			}
			else if(cmd.equals(Constants.DELETE)){

				deletePmlTinhChat(actionRequest);
			}
			if (Validator.isNotNull(cmd)) {
				String pmlTinhChatURL = ParamUtil.getString(
						actionRequest, "pmlTinhChatURL");
				sendRedirect(actionRequest, actionResponse, pmlTinhChatURL);
			}
		}
		catch (Exception e) {
			if (e instanceof NoSuchPmlTinhChatException ||
				e instanceof PrincipalException) {

				SessionErrors.add(actionRequest, e.getClass().getName());

				setForward(actionRequest, "portlet.sgs.pml_tinh_chat.error");
			}
			else if (e instanceof PmlTinhChatTenTinhChatException) {

				actionRequest.setAttribute("PmlTinhChatAUFlag", "fail");
				SessionErrors.add(actionRequest, e.getClass().getName());
			}
			else if (e instanceof PmlTinhChatCanNotDeleteException){
				SessionErrors.add(actionRequest,e.getClass().getName());
			}
			else {
				throw e;
			}
		}
	}

	public ActionForward render(
			ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws Exception {

		try {
			String cmd = ParamUtil.getString(renderRequest, Constants.CMD);

			// Case edit element
			if (cmd.equals(Constants.EDIT)) {
				ActionUtil.getPmlTinhChat(renderRequest);
			}
		}
		catch (NoSuchPmlTinhChatException nsex) {

			// Bo qua loi nay khi bat dau vao trang them moi
		}
		catch (Exception e) {
			throw e;
		}

		if (getForward(renderRequest) != null && !getForward(renderRequest).equals("")) {
			return mapping.findForward(getForward(renderRequest));
		}
		else {
			return mapping.findForward("portlet.sgs.pml_tinh_chat.view");
		}
	}

	protected PmlTinhChat updatePmlTinhChat(ActionRequest actionRequest)
	throws Exception {

		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(
			actionRequest);
	
		String cmd = ParamUtil.getString(uploadRequest, Constants.CMD);
	
		long idTinhChat = ParamUtil.getLong(uploadRequest, "idTinhChat");
		String tenTinhChat = ParamUtil.getString(uploadRequest, "tenTinhChat");
	
		PmlTinhChat pmlTinhChat = null;
	
		if (cmd.equals(Constants.ADD)) {
			// Add 
			pmlTinhChat = PmlTinhChatServiceUtil.addPmlTinhChat(tenTinhChat);
		}
		else {
			// Update 
			pmlTinhChat = PmlTinhChatServiceUtil.updatePmlTinhChat(idTinhChat, tenTinhChat);
		}
	
		return pmlTinhChat;
	}
	protected void deletePmlTinhChat(ActionRequest actionRequest)
		throws Exception {

		String idTinhChatList = actionRequest.getParameter("deletePmlTinhChatIdTinhChats");
		// trong choi idTinhChatList co chuoi "on," --> cat chuoi bo
		if (idTinhChatList.length() > 3)
			idTinhChatList = idTinhChatList.substring(3);
		// truong hop chuoi rong
		if (idTinhChatList.length()<3)

			idTinhChatList = idTinhChatList.replaceAll("on", "");
		/* 
		long[] idTinhChats = StringUtil.split(
				ParamUtil.getString(actionRequest, "deletePmlTinhChatIdTinhChats"), 0L);
		*/
		if (!idTinhChatList.equals("")){
			PmlTinhChatLocalServiceUtil.removePmlTinhChat(idTinhChatList);
		}	
		
		// Click xoa bang img delete.png
		String idTinhChat = ""; 
		
		idTinhChat = actionRequest.getParameter("deletePmlTinhChatIdTinhChat");
		
		if (!idTinhChat.equals("")){
			PmlTinhChatLocalServiceUtil.removePmlTinhChat(idTinhChat);
		}
	}
}