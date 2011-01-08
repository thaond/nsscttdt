package com.sgs.portlet.document.receipt.service.persistence;

public class PmlEdmConfidentialLevelFinderUtil {
    private static PmlEdmConfidentialLevelFinder _finder;

    public static int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getFinder().countByKeywords(keywords);
    }

    public static int countByPmlEdmConfidentialLevel(
        java.lang.String[] pmlEdmConfidentialLevelNames, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByPmlEdmConfidentialLevel(pmlEdmConfidentialLevelNames,
            andOperator);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder().findByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel> findByPmlEdmConfidentialLevel(
        java.lang.String[] pmlEdmConfidentialLevelNames, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByPmlEdmConfidentialLevel(pmlEdmConfidentialLevelNames,
            andOperator, start, end, obc);
    }

    public static PmlEdmConfidentialLevelFinder getFinder() {
        return _finder;
    }

    public void setFinder(PmlEdmConfidentialLevelFinder finder) {
        _finder = finder;
    }
}
