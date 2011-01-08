package com.sgs.portlet.pmlstreet.service.persistence;

public class PmlStreetFinderUtil {
    private static PmlStreetFinder _finder;

    public static int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getFinder().countByKeywords(keywords);
    }

    public static int countByPmlEdmConfidentialLevel(java.lang.String[] names,
        boolean andOperator) throws com.liferay.portal.SystemException {
        return getFinder().countByPmlEdmConfidentialLevel(names, andOperator);
    }

    public static java.util.List<com.sgs.portlet.pmlstreet.model.PmlStreet> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder().findByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.pmlstreet.model.PmlStreet> findByPmlEdmConfidentialLevel(
        java.lang.String[] names, boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByPmlEdmConfidentialLevel(names, andOperator, start,
            end, obc);
    }

    public static PmlStreetFinder getFinder() {
        return _finder;
    }

    public void setFinder(PmlStreetFinder finder) {
        _finder = finder;
    }
}
