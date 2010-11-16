package com.nss.portlet.van_ban_phap_quy.service.persistence;

public class VanBanPhapQuyFinderUtil {
    private static VanBanPhapQuyFinder _finder;

    public static int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getFinder().countByKeywords(keywords);
    }

    public static int countByVanBanPhapQuy(java.lang.String kyHieuVanBan,
        boolean andOperator) throws com.liferay.portal.SystemException {
        return getFinder().countByVanBanPhapQuy(kyHieuVanBan, andOperator);
    }

    public static int countByVanBanPhapQuy(java.lang.String[] kyHieuVanBans,
        boolean andOperator) throws com.liferay.portal.SystemException {
        return getFinder().countByVanBanPhapQuy(kyHieuVanBans, andOperator);
    }

    public static java.util.List<com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder().findByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy> findByVanBanPhapQuy(
        java.lang.String kyHieuVanBan, boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByVanBanPhapQuy(kyHieuVanBan, andOperator, start, end,
            obc);
    }

    public static java.util.List<com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy> findByVanBanPhapQuy(
        java.lang.String[] kyHieuVanBans, boolean andOperator, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByVanBanPhapQuy(kyHieuVanBans, andOperator, start, end,
            obc);
    }

    public static VanBanPhapQuyFinder getFinder() {
        return _finder;
    }

    public void setFinder(VanBanPhapQuyFinder finder) {
        _finder = finder;
    }
}
