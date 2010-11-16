package com.nss.portlet.van_ban_phap_quy.service.persistence;

public class FileDinhKemFinderUtil {
    private static FileDinhKemFinder _finder;

    public static int countFileDinhKem(long maVanBanPhapQuy)
        throws com.liferay.portal.SystemException {
        return getFinder().countFileDinhKem(maVanBanPhapQuy);
    }

    public static java.util.List<com.nss.portlet.van_ban_phap_quy.model.FileDinhKem> findFileDinhKem(
        long maVanBanPhapQuy, int start, int end)
        throws com.liferay.portal.SystemException {
        return getFinder().findFileDinhKem(maVanBanPhapQuy, start, end);
    }

    public static FileDinhKemFinder getFinder() {
        return _finder;
    }

    public void setFinder(FileDinhKemFinder finder) {
        _finder = finder;
    }
}
