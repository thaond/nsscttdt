package com.nss.portlet.loai_van_ban.service.persistence;

public class LoaiVanBanFinderUtil {
    private static LoaiVanBanFinder _finder;

    public static int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getFinder().countByKeywords(keywords);
    }

    public static int countByTEN_MOTA(java.lang.String name,
        java.lang.String des, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder().countByTEN_MOTA(name, des, andOperator);
    }

    public static int countByTEN_MOTA(java.lang.String[] names,
        java.lang.String[] des, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder().countByTEN_MOTA(names, des, andOperator);
    }

    public static java.util.List<com.nss.portlet.loai_van_ban.model.LoaiVanBan> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder().findByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.loai_van_ban.model.LoaiVanBan> findTEN_MOTA(
        java.lang.String name, java.lang.String des, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder().findTEN_MOTA(name, des, andOperator, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.loai_van_ban.model.LoaiVanBan> findTEN_MOTA(
        java.lang.String[] names, java.lang.String[] des, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder().findTEN_MOTA(names, des, andOperator, start, end, obc);
    }

    public static LoaiVanBanFinder getFinder() {
        return _finder;
    }

    public void setFinder(LoaiVanBanFinder finder) {
        _finder = finder;
    }
}
