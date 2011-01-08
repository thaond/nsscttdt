package com.sgs.portlet.agency.service.persistence;

public class AgencyFinderUtil {
    private static AgencyFinder _finder;

    public static int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getFinder().countByKeywords(keywords);
    }

    public static int countByTEN_MA_COQUAN(java.lang.String leaderLastNames,
        java.lang.String leaderFirstNames, java.lang.String agencyCode,
        java.lang.String agencyName, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByTEN_MA_COQUAN(leaderLastNames, leaderFirstNames,
            agencyCode, agencyName, andOperator);
    }

    public static int countByTEN_MA_COQUAN(java.lang.String[] leaderLastNames,
        java.lang.String[] leaderFirstNames, java.lang.String[] agencyCodes,
        java.lang.String[] agencyNames, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByTEN_MA_COQUAN(leaderLastNames, leaderFirstNames,
            agencyCodes, agencyNames, andOperator);
    }

    public static java.util.List<com.sgs.portlet.agency.model.Agency> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder().findByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.agency.model.Agency> findTEN_MA_COQUAN(
        java.lang.String leaderLastNames, java.lang.String leaderFirstNames,
        java.lang.String agencyCode, java.lang.String agencyName,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findTEN_MA_COQUAN(leaderLastNames, leaderFirstNames,
            agencyCode, agencyName, andOperator, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.agency.model.Agency> findTEN_MA_COQUAN(
        java.lang.String[] leaderLastNames,
        java.lang.String[] leaderFirstNames, java.lang.String[] agencyCodes,
        java.lang.String[] agencyNames, boolean andOperator, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findTEN_MA_COQUAN(leaderLastNames, leaderFirstNames,
            agencyCodes, agencyNames, andOperator, start, end, obc);
    }

    public static AgencyFinder getFinder() {
        return _finder;
    }

    public void setFinder(AgencyFinder finder) {
        _finder = finder;
    }
}
