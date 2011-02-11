package com.sgs.portlet.field.service.persistence;

public class PmlFieldFinderUtil {
    private static PmlFieldFinder _finder;

    public static int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getFinder().countByKeywords(keywords);
    }

    public static int countByField(java.lang.String fieldCode,
        java.lang.String fieldName, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder().countByField(fieldCode, fieldName, andOperator);
    }

    public static int countByField(java.lang.String[] fieldCodes,
        java.lang.String[] fieldNames, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder().countByField(fieldCodes, fieldNames, andOperator);
    }

    public static java.util.List<com.sgs.portlet.field.model.PmlField> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder().findByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.field.model.PmlField> findByField(
        java.lang.String fieldCode, java.lang.String fieldName,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByField(fieldCode, fieldName, andOperator, start, end,
            obc);
    }

    public static java.util.List<com.sgs.portlet.field.model.PmlField> findByField(
        java.lang.String[] fieldCodes, java.lang.String[] fieldNames,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByField(fieldCodes, fieldNames, andOperator, start,
            end, obc);
    }

    public static PmlFieldFinder getFinder() {
        return _finder;
    }

    public void setFinder(PmlFieldFinder finder) {
        _finder = finder;
    }
}
