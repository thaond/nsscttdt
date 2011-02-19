package com.sgs.portlet.loaivanbannoibo.service.persistence;

public class LoaiVanBanNoiBoFinderUtil {
    private static LoaiVanBanNoiBoFinder _finder;

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

    public static java.util.List<com.sgs.portlet.loaivanbannoibo.model.LoaiVanBanNoiBo> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder().findByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.loaivanbannoibo.model.LoaiVanBanNoiBo> find_loai_van_ban_noi_bo(
        java.lang.String kyHieuLoaiVanBanNoiBos,
        java.lang.String tenLoaiVanBanNoiBos, int start, int end,
        boolean andOperator,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .find_loai_van_ban_noi_bo(kyHieuLoaiVanBanNoiBos,
            tenLoaiVanBanNoiBos, start, end, andOperator, obc);
    }

    public static java.util.List<com.sgs.portlet.loaivanbannoibo.model.LoaiVanBanNoiBo> find_loai_van_ban_noi_bo(
        java.lang.String[] kyHieuLoaiVanBanNoiBos,
        java.lang.String[] tenLoaiVanBanNoiBos, boolean andOperator, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .find_loai_van_ban_noi_bo(kyHieuLoaiVanBanNoiBos,
            tenLoaiVanBanNoiBos, andOperator, start, end, obc);
    }

    public static LoaiVanBanNoiBoFinder getFinder() {
        return _finder;
    }

    public void setFinder(LoaiVanBanNoiBoFinder finder) {
        _finder = finder;
    }
}
