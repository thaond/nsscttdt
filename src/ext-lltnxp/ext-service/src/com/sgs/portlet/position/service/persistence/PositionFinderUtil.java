package com.sgs.portlet.position.service.persistence;

public class PositionFinderUtil {
    private static PositionFinder _finder;

    public static java.util.List<com.sgs.portlet.position.model.Position> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder().findByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.position.model.Position> find_CODE_NAME_DESCRIPTION(
        java.lang.String code, java.lang.String name,
        java.lang.String description, boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .find_CODE_NAME_DESCRIPTION(code, name, description,
            andOperator, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.position.model.Position> findPosition(
        java.lang.String[] codes, java.lang.String[] names,
        java.lang.String[] descriptions, boolean andOperator, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findPosition(codes, names, descriptions, andOperator,
            start, end, obc);
    }

    public static int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getFinder().countByKeywords(keywords);
    }

    public static int count_CODE_NAME_DESCRIPTION(java.lang.String code,
        java.lang.String name, java.lang.String description, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .count_CODE_NAME_DESCRIPTION(code, name, description,
            andOperator);
    }

    public static int countTotalPosition(java.lang.String[] codes,
        java.lang.String[] names, java.lang.String[] description,
        boolean andOperator) throws com.liferay.portal.SystemException {
        return getFinder()
                   .countTotalPosition(codes, names, description, andOperator);
    }

    public static PositionFinder getFinder() {
        return _finder;
    }

    public void setFinder(PositionFinder finder) {
        _finder = finder;
    }
}
