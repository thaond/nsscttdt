package com.nss.portlet.chat.service.persistence;

public class StatusFinderUtil {
    private static StatusFinder _finder;

    public static java.util.List<Object[]> findByModifiedDate(long userId,
        long modifiedDate, int start, int end)
        throws com.liferay.portal.SystemException {
        return getFinder().findByModifiedDate(userId, modifiedDate, start, end);
    }

    public static java.util.List<Object[]> findBySocialRelationType(
        long userId, int type, long modifiedDate, int start, int end)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findBySocialRelationType(userId, type, modifiedDate, start,
            end);
    }

    public static java.util.List<Object[]> findByUsersGroups(long userId,
        long modifiedDate, int start, int end)
        throws com.liferay.portal.SystemException {
        return getFinder().findByUsersGroups(userId, modifiedDate, start, end);
    }

    public static StatusFinder getFinder() {
        return _finder;
    }

    public void setFinder(StatusFinder finder) {
        _finder = finder;
    }
}
