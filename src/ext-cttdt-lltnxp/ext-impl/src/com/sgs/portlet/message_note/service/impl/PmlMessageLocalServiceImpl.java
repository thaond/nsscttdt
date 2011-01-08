package com.sgs.portlet.message_note.service.impl;

import java.util.List;

import com.sgs.portlet.message_note.model.PmlMessage;
import com.sgs.portlet.message_note.service.PmlMessageLocalServiceUtil;
import com.sgs.portlet.message_note.service.base.PmlMessageLocalServiceBaseImpl;

@SuppressWarnings("unchecked")
public class PmlMessageLocalServiceImpl extends PmlMessageLocalServiceBaseImpl {
	
	public void deletePmlMessageList(List<PmlMessage> messageList) throws Exception {
		
		for (int t = 0; t < messageList.size(); t ++) {
			PmlMessageLocalServiceUtil.deletePmlMessage(messageList.get(t));
		}
	}
	
	// dem tong so luong van ban ma touser nhan duoc, ko can biet do la vb den hay di
	public int getTotalDocumentByUser(List<Long> fromUserList, long toUserId) throws Exception {
		return pmlMessageFinder.getTotalDocumentByUser(fromUserList, toUserId);
	}
	
	// lay danh sach van ban ma touser nhan duoc, phan biet nguoi gui va loai vb den/di
	public List<PmlMessage> getDocumentListByUser(long fromUserId, long toUserId, Class clazz) throws Exception {
		return pmlMessageFinder.getDocumentListByUser(fromUserId, toUserId, clazz);
	}
}
