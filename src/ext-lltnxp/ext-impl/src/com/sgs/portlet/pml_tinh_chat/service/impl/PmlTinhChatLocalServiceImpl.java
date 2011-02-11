package com.sgs.portlet.pml_tinh_chat.service.impl;

import java.util.Date;
import java.util.List;


import com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat;
import com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec;
import com.sgs.portlet.pml_ho_so_cong_viec.service.base.PmlHoSoCongViecLocalServiceBaseImpl;
import com.sgs.portlet.pml_ho_so_cong_viec.service.persistence.PmlHoSoCongViecPersistence;
import com.sgs.portlet.pml_ho_so_cong_viec.service.PmlHoSoCongViecLocalServiceUtil;
import com.sgs.portlet.pml_tinh_chat.PmlTinhChatCanNotDeleteException;
import com.sgs.portlet.pml_tinh_chat.PmlTinhChatTenTinhChatException;
import com.sgs.portlet.pml_tinh_chat.service.PmlTinhChatLocalServiceUtil;
import com.sgs.portlet.pml_tinh_chat.service.base.PmlTinhChatLocalServiceBaseImpl;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;


public class PmlTinhChatLocalServiceImpl extends PmlTinhChatLocalServiceBaseImpl {
	public PmlTinhChat getPmlTinhChat(long idTinhChat)
	throws PortalException, SystemException {
		
		return pmlTinhChatPersistence.findByPrimaryKey(idTinhChat);
	}
	public int searchCount(boolean andOperator)
		throws SystemException {

		return pmlTinhChatFinder.countByC_G(andOperator);
	}
	public List<PmlTinhChat> search(boolean andOperator, 
			int start, int end, OrderByComparator obc)
		throws SystemException {

		return pmlTinhChatFinder.findByC_G(andOperator, 
				start, end, obc);
	}
	
	public PmlTinhChat addPmlTinhChat( String tenTinhChat)
		throws PortalException, SystemException {

		// Check inputted value
		validate(tenTinhChat);

		long idTinhChat = counterLocalService.increment();
		
		PmlTinhChat pmlTinhChat = pmlTinhChatPersistence.create(idTinhChat);

		// Set properties value
		pmlTinhChat.setTenTinhChat(tenTinhChat);
		
		pmlTinhChatPersistence.update(pmlTinhChat, false);

		return pmlTinhChat;
	}
	
	protected void validate(String tenTinhChat)
		throws PortalException, SystemException {
		
		// Check tenTinhChat
		if (Validator.isNull(tenTinhChat)){
			throw new PmlTinhChatTenTinhChatException();
		}
	}
	protected void validatePmlTinhChat(int idTinhChat)
	throws PortalException, SystemException {
	
	// Check idTinhChat
	if (idTinhChat != 0){
		throw new PmlTinhChatCanNotDeleteException();
	}
	
}

	public PmlTinhChat updatePmlTinhChat( long idTinhChat, 
			String tenTinhChat)
		throws PortalException, SystemException {

		// Checking inputted values
		validate(tenTinhChat);

		PmlTinhChat oldPmlTinhChat = pmlTinhChatPersistence.findByPrimaryKey(idTinhChat);

		// Updated properties
		oldPmlTinhChat.setTenTinhChat(tenTinhChat);
		
		pmlTinhChatPersistence.update(oldPmlTinhChat, false);

		return oldPmlTinhChat;
	}

	public List<PmlTinhChat> getAll() 
	throws SystemException, PortalException {
		
		try {
			return pmlTinhChatPersistence.findAll();
		}
		catch (Exception ex) {
			return null;
		}
	}
	
	public void removePmlTinhChat(String idTinhChat) 
	throws PortalException, SystemException{
		int pmlIdTinhChat = PmlHoSoCongViecLocalServiceUtil.findByHSCVIdTinhChat(idTinhChat);
		validatePmlTinhChat(pmlIdTinhChat);
		
		String[] idTinhChatList = idTinhChat.split(",");
		
		if (idTinhChatList.length >0) {
			long [] idTinhChats = new long[idTinhChatList.length];
			// chuyen mang String sang mang long de goi ham tim id_tinh_chat
			for (int i = 0; i < idTinhChats.length; i++){
				
				idTinhChats[i] = Long.valueOf(idTinhChatList[i]);
				
				pmlTinhChatPersistence.remove(idTinhChats[i]);
			}
			
		}	
	}
}
