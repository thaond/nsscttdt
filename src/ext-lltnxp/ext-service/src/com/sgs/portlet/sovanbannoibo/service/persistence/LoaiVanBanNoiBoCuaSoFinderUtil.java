package com.sgs.portlet.sovanbannoibo.service.persistence;

public class LoaiVanBanNoiBoCuaSoFinderUtil {
    private static LoaiVanBanNoiBoCuaSoFinder _finder;

    public static int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getFinder().countByKeywords(keywords);
    }

    public static int count_loai_van_ban_noi_bo(
        java.lang.String kyHieuLoaiVanBanNoiBos,
        java.lang.String tenLoaiVanBanNoiBos, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .count_loai_van_ban_noi_bo(kyHieuLoaiVanBanNoiBos,
            tenLoaiVanBanNoiBos, andOperator);
    }

    public static int count_loai_van_ban_noi_bo(
        java.lang.String[] kyHieuLoaiVanBanNoiBos,
        java.lang.String[] tenLoaiVanBanNoiBos, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .count_loai_van_ban_noi_bo(kyHieuLoaiVanBanNoiBos,
            tenLoaiVanBanNoiBos, andOperator);
    }

    public static java.util.List<com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder().findByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo> find_loai_van_ban_noi_bo(
        java.lang.String kyHieuLoaiVanBanNoiBos,
        java.lang.String tenLoaiVanBanNoiBos, int start, int end,
        boolean andOperator,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .find_loai_van_ban_noi_bo(kyHieuLoaiVanBanNoiBos,
            tenLoaiVanBanNoiBos, start, end, andOperator, obc);
    }

    public static java.util.List<com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo> find_loai_van_ban_noi_bo(
        java.lang.String[] kyHieuLoaiVanBanNoiBos,
        java.lang.String[] tenLoaiVanBanNoiBos, boolean andOperator, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .find_loai_van_ban_noi_bo(kyHieuLoaiVanBanNoiBos,
            tenLoaiVanBanNoiBos, andOperator, start, end, obc);
    }

    public static LoaiVanBanNoiBoCuaSoFinder getFinder() {
        return _finder;
    }

    public void setFinder(LoaiVanBanNoiBoCuaSoFinder finder) {
        _finder = finder;
    }
}
