package com.sgs.portlet.wardsmanagement.service.persistence;

public class WardsFinderUtil {
    private static WardsFinder _finder;

    public static int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getFinder().countByKeywords(keywords);
    }

    public static int countByTEN_MA_MOTA_PHUONG(java.lang.String code,
        java.lang.String name, java.lang.String des, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByTEN_MA_MOTA_PHUONG(code, name, des, andOperator);
    }

    public static int countByTEN_MA_MOTA_PHUONG(java.lang.String[] codes,
        java.lang.String[] names, java.lang.String[] des, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByTEN_MA_MOTA_PHUONG(codes, names, des, andOperator);
    }

    public static java.util.List<com.sgs.portlet.wardsmanagement.model.Wards> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder().findByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.wardsmanagement.model.Wards> findTEN_MA_MOTA_PHUONG(
        java.lang.String code, java.lang.String name, java.lang.String des,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findTEN_MA_MOTA_PHUONG(code, name, des, andOperator, start,
            end, obc);
    }

    public static java.util.List<com.sgs.portlet.wardsmanagement.model.Wards> findTEN_MA_MOTA_PHUONG(
        java.lang.String[] codes, java.lang.String[] names,
        java.lang.String[] des, boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findTEN_MA_MOTA_PHUONG(codes, names, des, andOperator,
            start, end, obc);
    }

    public static int countWardsByDistrictId(java.lang.String districtId)
        throws com.liferay.portal.SystemException {
        return getFinder().countWardsByDistrictId(districtId);
    }

    public static java.util.List<com.sgs.portlet.wardsmanagement.model.Wards> findWardsByDistrictId(
        java.lang.String districtId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getFinder().findWardsByDistrictId(districtId, start, end);
    }

    public static WardsFinder getFinder() {
        return _finder;
    }

    public void setFinder(WardsFinder finder) {
        _finder = finder;
    }
}
