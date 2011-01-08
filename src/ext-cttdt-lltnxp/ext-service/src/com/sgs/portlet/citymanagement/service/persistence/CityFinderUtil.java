package com.sgs.portlet.citymanagement.service.persistence;

public class CityFinderUtil {
    private static CityFinder _finder;

    public static int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getFinder().countByKeywords(keywords);
    }

    public static int countByTEN_MA_THANH_PHO(java.lang.String cityCode,
        java.lang.String cityName, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByTEN_MA_THANH_PHO(cityCode, cityName, andOperator);
    }

    public static int countByTEN_MA_THANH_PHO(java.lang.String[] cityCodes,
        java.lang.String[] cityNames, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByTEN_MA_THANH_PHO(cityCodes, cityNames, andOperator);
    }

    public static java.util.List<com.sgs.portlet.citymanagement.model.City> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder().findByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.citymanagement.model.City> findByTEN_MA_THANH_PHO(
        java.lang.String cityCode, java.lang.String cityName,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByTEN_MA_THANH_PHO(cityCode, cityName, andOperator,
            start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.citymanagement.model.City> findByTEN_MA_THANH_PHO(
        java.lang.String[] cityCodes, java.lang.String[] cityNames,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByTEN_MA_THANH_PHO(cityCodes, cityNames, andOperator,
            start, end, obc);
    }

    public static CityFinder getFinder() {
        return _finder;
    }

    public void setFinder(CityFinder finder) {
        _finder = finder;
    }
}
