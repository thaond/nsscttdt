package com.sgs.portlet.career.service.persistence;

public class CareerFinderUtil {
    private static CareerFinder _finder;

    public static int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getFinder().countByKeywords(keywords);
    }

    public static int countByTEN_MA_NGHENGHIEP(java.lang.String code,
        java.lang.String name, java.lang.String des, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder().countByTEN_MA_NGHENGHIEP(code, name, des, andOperator);
    }

    public static int countByTEN_MA_NGHENGHIEP(java.lang.String[] codes,
        java.lang.String[] names, java.lang.String[] des, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByTEN_MA_NGHENGHIEP(codes, names, des, andOperator);
    }

    public static java.util.List<com.sgs.portlet.career.model.Career> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder().findByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.career.model.Career> findTEN_MA_NGHENGHIEP(
        java.lang.String code, java.lang.String name, java.lang.String des,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findTEN_MA_NGHENGHIEP(code, name, des, andOperator, start,
            end, obc);
    }

    public static java.util.List<com.sgs.portlet.career.model.Career> findTEN_MA_NGHENGHIEP(
        java.lang.String[] codes, java.lang.String[] names,
        java.lang.String[] des, boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findTEN_MA_NGHENGHIEP(codes, names, des, andOperator,
            start, end, obc);
    }

    public static CareerFinder getFinder() {
        return _finder;
    }

    public void setFinder(CareerFinder finder) {
        _finder = finder;
    }
}
