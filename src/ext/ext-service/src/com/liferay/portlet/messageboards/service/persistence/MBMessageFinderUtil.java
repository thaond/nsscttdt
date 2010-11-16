package com.liferay.portlet.messageboards.service.persistence;

public class MBMessageFinderUtil {
    private static MBMessageFinder _finder;

    public static int countByG_U(long groupId, long userId)
        throws com.liferay.portal.SystemException {
        return getFinder().countByG_U(groupId, userId);
    }

    public static int countByG_U_A(long groupId, long userId, boolean anonymous)
        throws com.liferay.portal.SystemException {
        return getFinder().countByG_U_A(groupId, userId, anonymous);
    }

    public static java.util.List<com.liferay.portlet.messageboards.model.MBMessage> findByNoAssets()
        throws com.liferay.portal.SystemException {
        return getFinder().findByNoAssets();
    }

    public static java.util.List<Long> findByG_U(long groupId, long userId,
        int start, int end) throws com.liferay.portal.SystemException {
        return getFinder().findByG_U(groupId, userId, start, end);
    }

    public static java.util.List<Long> findByG_U_A(long groupId, long userId,
        boolean anonymous, int start, int end)
        throws com.liferay.portal.SystemException {
        return getFinder().findByG_U_A(groupId, userId, anonymous, start, end);
    }

    public static MBMessageFinder getFinder() {
        return _finder;
    }

    public void setFinder(MBMessageFinder finder) {
        _finder = finder;
    }
}
