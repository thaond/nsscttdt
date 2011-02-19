package com.sgs.portlet.sovanbannoibo.service.persistence;

public class SoVanBanNoiBoFinderUtil {
    private static SoVanBanNoiBoFinder _finder;

    public static int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getFinder().countByKeywords(keywords);
    }

    public static int count_so_van_ban_noi_bo(
        java.lang.String maSoVanBanNoiBos, java.lang.String tenSoVanBanNoiBos,
        boolean andOperator) throws com.liferay.portal.SystemException {
        return getFinder()
                   .count_so_van_ban_noi_bo(maSoVanBanNoiBos,
            tenSoVanBanNoiBos, andOperator);
    }

    public static int count_so_van_ban_noi_bo(
        java.lang.String[] maSoVanBanNoiBos,
        java.lang.String[] tenSoVanBanNoiBos, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .count_so_van_ban_noi_bo(maSoVanBanNoiBos,
            tenSoVanBanNoiBos, andOperator);
    }

    public static java.util.List<com.sgs.portlet.sovanbannoibo.model.SoVanBanNoiBo> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder().findByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.sovanbannoibo.model.SoVanBanNoiBo> find_so_van_ban_noi_bo(
        java.lang.String maSoVanBanNoiBos, java.lang.String tenSoVanBanNoiBos,
        int start, int end, boolean andOperator,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .find_so_van_ban_noi_bo(maSoVanBanNoiBos, tenSoVanBanNoiBos,
            start, end, andOperator, obc);
    }

    public static java.util.List<com.sgs.portlet.sovanbannoibo.model.SoVanBanNoiBo> find_so_van_ban_noi_bo(
        java.lang.String[] maSoVanBanNoiBos,
        java.lang.String[] tenSoVanBanNoiBos, boolean andOperator, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .find_so_van_ban_noi_bo(maSoVanBanNoiBos, tenSoVanBanNoiBos,
            andOperator, start, end, obc);
    }

    public static SoVanBanNoiBoFinder getFinder() {
        return _finder;
    }

    public void setFinder(SoVanBanNoiBoFinder finder) {
        _finder = finder;
    }
}
