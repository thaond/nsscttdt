package com.liferay.portlet.messageboards.service.persistence;

public class MBThreadFinderUtil {
    private static MBThreadFinder _finder;

    public static int countByS_G_U(long groupId, long userId)
        throws com.liferay.portal.SystemException {
        return getFinder().countByS_G_U(groupId, userId);
    }

    public static java.util.List<com.liferay.portlet.messageboards.model.MBThread> findByS_G_U(
        long groupId, long userId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getFinder().findByS_G_U(groupId, userId, start, end);
    }

    public static MBThreadFinder getFinder() {
        return _finder;
    }

    public void setFinder(MBThreadFinder finder) {
        _finder = finder;
    }
}
