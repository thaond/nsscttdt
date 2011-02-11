package com.sgs.portlet.pml_tinh_chat.service.impl;

import com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat;
import com.sgs.portlet.pml_tinh_chat.service.base.PmlTinhChatServiceBaseImpl;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.security.permission.ActionKeys;


public class PmlTinhChatServiceImpl extends PmlTinhChatServiceBaseImpl {
	public PmlTinhChat addPmlTinhChat(String tenTinhChat)
		throws PortalException, SystemException {
		
		return pmlTinhChatLocalService.addPmlTinhChat( tenTinhChat);
	}

	public PmlTinhChat updatePmlTinhChat(long idTinhChat, String tenTinhChat)
		throws PortalException, SystemException {

		return pmlTinhChatLocalService.updatePmlTinhChat(idTinhChat,tenTinhChat);
	}
}
