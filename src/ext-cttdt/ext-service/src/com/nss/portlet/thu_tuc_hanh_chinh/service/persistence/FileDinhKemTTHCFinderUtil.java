package com.nss.portlet.thu_tuc_hanh_chinh.service.persistence;

public class FileDinhKemTTHCFinderUtil {
    private static FileDinhKemTTHCFinder _finder;

    public static int countFileDinhKem(long maThuTucHanhChinh)
        throws com.liferay.portal.SystemException {
        return getFinder().countFileDinhKem(maThuTucHanhChinh);
    }

    public static java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC> findFileDinhKem(
        long maThuTucHanhChinh, int start, int end)
        throws com.liferay.portal.SystemException {
        return getFinder().findFileDinhKem(maThuTucHanhChinh, start, end);
    }

    public static FileDinhKemTTHCFinder getFinder() {
        return _finder;
    }

    public void setFinder(FileDinhKemTTHCFinder finder) {
        _finder = finder;
    }
}
