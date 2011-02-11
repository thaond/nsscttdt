package com.sgs.portlet.message_note.service.persistence;

public interface PmlMessageFinder {
    public int getTotalDocumentByUser(java.util.List<Long> fromUserList,
        long toUserId) throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.message_note.model.PmlMessage> getDocumentListByUser(
        long fromUserId, long toUserId, java.lang.Class clazz)
        throws java.lang.Exception;
}
