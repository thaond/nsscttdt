package com.nss.portlet.journal.service.persistence;

public class JournalFeedFinderUtil {
    private static JournalFeedFinder _finder;

    public static int countByKeywords(long companyId, long groupId,
        java.lang.String keywords) throws com.liferay.portal.SystemException {
        return getFinder().countByKeywords(companyId, groupId, keywords);
    }

    public static int countByC_G_F_N_D(long companyId, long groupId,
        java.lang.String feedId, java.lang.String name,
        java.lang.String description, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByC_G_F_N_D(companyId, groupId, feedId, name,
            description, andOperator);
    }

    public static int countByC_G_F_N_D(long companyId, long groupId,
        java.lang.String[] feedIds, java.lang.String[] names,
        java.lang.String[] descriptions, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByC_G_F_N_D(companyId, groupId, feedIds, names,
            descriptions, andOperator);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalFeed> findByKeywords(
        long companyId, long groupId, java.lang.String keywords, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByKeywords(companyId, groupId, keywords, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalFeed> findByC_G_F_N_D(
        long companyId, long groupId, java.lang.String feedId,
        java.lang.String name, java.lang.String description,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByC_G_F_N_D(companyId, groupId, feedId, name,
            description, andOperator, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalFeed> findByC_G_F_N_D(
        long companyId, long groupId, java.lang.String[] feedIds,
        java.lang.String[] names, java.lang.String[] descriptions,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByC_G_F_N_D(companyId, groupId, feedIds, names,
            descriptions, andOperator, start, end, obc);
    }

    public static JournalFeedFinder getFinder() {
        return _finder;
    }

    public void setFinder(JournalFeedFinder finder) {
        _finder = finder;
    }
}
