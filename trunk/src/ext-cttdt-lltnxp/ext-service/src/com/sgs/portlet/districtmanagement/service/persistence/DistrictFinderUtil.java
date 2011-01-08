package com.sgs.portlet.districtmanagement.service.persistence;

public class DistrictFinderUtil {
    private static DistrictFinder _finder;

    public static int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getFinder().countByKeywords(keywords);
    }

    public static int countByTEN_MA_MOTA_QUAN(java.lang.String code,
        java.lang.String name, java.lang.String des, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder().countByTEN_MA_MOTA_QUAN(code, name, des, andOperator);
    }

    public static int countByTEN_MA_MOTA_QUAN(java.lang.String[] codes,
        java.lang.String[] names, java.lang.String[] des, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByTEN_MA_MOTA_QUAN(codes, names, des, andOperator);
    }

    public static java.util.List<com.sgs.portlet.districtmanagement.model.District> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder().findByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.districtmanagement.model.District> findTEN_MA_MOTA_QUAN(
        java.lang.String code, java.lang.String name, java.lang.String des,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findTEN_MA_MOTA_QUAN(code, name, des, andOperator, start,
            end, obc);
    }

    public static java.util.List<com.sgs.portlet.districtmanagement.model.District> findTEN_MA_MOTA_QUAN(
        java.lang.String[] codes, java.lang.String[] names,
        java.lang.String[] des, boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findTEN_MA_MOTA_QUAN(codes, names, des, andOperator, start,
            end, obc);
    }

    public static int countDistrictByCityId(java.lang.String cityId)
        throws com.liferay.portal.SystemException {
        return getFinder().countDistrictByCityId(cityId);
    }

    public static java.util.List<com.sgs.portlet.districtmanagement.model.District> findDistrictByCityId(
        java.lang.String cityId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getFinder().findDistrictByCityId(cityId, start, end);
    }

    public static DistrictFinder getFinder() {
        return _finder;
    }

    public void setFinder(DistrictFinder finder) {
        _finder = finder;
    }
}
