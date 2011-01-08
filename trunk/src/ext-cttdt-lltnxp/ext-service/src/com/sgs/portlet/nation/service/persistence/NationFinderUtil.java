package com.sgs.portlet.nation.service.persistence;

public class NationFinderUtil {
    private static NationFinder _finder;

    public static int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getFinder().countByKeywords(keywords);
    }

    public static int countByTEN_MA_MOTA_QUOCGIA(java.lang.String code,
        java.lang.String name, java.lang.String des, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByTEN_MA_MOTA_QUOCGIA(code, name, des, andOperator);
    }

    public static int countByTEN_MA_MOTA_QUOCGIA(java.lang.String[] codes,
        java.lang.String[] names, java.lang.String[] des, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByTEN_MA_MOTA_QUOCGIA(codes, names, des, andOperator);
    }

    public static java.util.List<com.sgs.portlet.nation.model.Nation> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder().findByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.nation.model.Nation> findTEN_MA_MOTA_QUOCGIA(
        java.lang.String code, java.lang.String name, java.lang.String des,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findTEN_MA_MOTA_QUOCGIA(code, name, des, andOperator,
            start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.nation.model.Nation> findTEN_MA_MOTA_QUOCGIA(
        java.lang.String[] codes, java.lang.String[] names,
        java.lang.String[] des, boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findTEN_MA_MOTA_QUOCGIA(codes, names, des, andOperator,
            start, end, obc);
    }

    public static NationFinder getFinder() {
        return _finder;
    }

    public void setFinder(NationFinder finder) {
        _finder = finder;
    }
}
