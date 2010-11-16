package com.liferay.portlet.messageboards.service.persistence;

public class MBCategoryFinderUtil {
    private static MBCategoryFinder _finder;

    public static int countByS_G_U(long groupId, long userId)
        throws com.liferay.portal.SystemException {
        return getFinder().countByS_G_U(groupId, userId);
    }

    public static java.util.List<com.liferay.portlet.messageboards.model.MBCategory> findByS_G_U(
        long groupId, long userId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getFinder().findByS_G_U(groupId, userId, start, end);
    }

    public static MBCategoryFinder getFinder() {
        return _finder;
    }

    public void setFinder(MBCategoryFinder finder) {
        _finder = finder;
    }
}
