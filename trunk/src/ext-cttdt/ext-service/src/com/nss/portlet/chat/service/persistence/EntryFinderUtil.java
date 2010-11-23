package com.nss.portlet.chat.service.persistence;

public class EntryFinderUtil {
    private static EntryFinder _finder;

    public static java.util.List<com.nss.portlet.chat.model.Entry> findByEmptyContent(
        long fromUserId, long toUserId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getFinder().findByEmptyContent(fromUserId, toUserId, start, end);
    }

    public static java.util.List<com.nss.portlet.chat.model.Entry> findByNew(
        long userId, long createDate, int start, int end)
        throws com.liferay.portal.SystemException {
        return getFinder().findByNew(userId, createDate, start, end);
    }

    public static java.util.List<com.nss.portlet.chat.model.Entry> findByOld(
        long createDate, int start, int end)
        throws com.liferay.portal.SystemException {
        return getFinder().findByOld(createDate, start, end);
    }

    public static EntryFinder getFinder() {
        return _finder;
    }

    public void setFinder(EntryFinder finder) {
        _finder = finder;
    }
}
