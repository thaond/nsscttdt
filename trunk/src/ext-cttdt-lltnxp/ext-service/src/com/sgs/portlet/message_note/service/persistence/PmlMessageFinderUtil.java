package com.sgs.portlet.message_note.service.persistence;

public class PmlMessageFinderUtil {
    private static PmlMessageFinder _finder;

    public static int getTotalDocumentByUser(
        java.util.List<Long> fromUserList, long toUserId)
        throws java.lang.Exception {
        return getFinder().getTotalDocumentByUser(fromUserList, toUserId);
    }

    public static java.util.List<com.sgs.portlet.message_note.model.PmlMessage> getDocumentListByUser(
        long fromUserId, long toUserId, java.lang.Class clazz)
        throws java.lang.Exception {
        return getFinder().getDocumentListByUser(fromUserId, toUserId, clazz);
    }

    public static PmlMessageFinder getFinder() {
        return _finder;
    }

    public void setFinder(PmlMessageFinder finder) {
        _finder = finder;
    }
}
