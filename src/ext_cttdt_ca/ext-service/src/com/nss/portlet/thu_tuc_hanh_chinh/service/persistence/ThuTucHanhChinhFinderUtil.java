package com.nss.portlet.thu_tuc_hanh_chinh.service.persistence;

public class ThuTucHanhChinhFinderUtil {
    private static ThuTucHanhChinhFinder _finder;

    public static int countByTEN_LINHVUC_DONVI(java.lang.String name,
        long linhVuc, long capDonVi, long donVi, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByTEN_LINHVUC_DONVI(name, linhVuc, capDonVi, donVi,
            andOperator);
    }

    public static int countByTEN_LINHVUC_DONVI(java.lang.String[] names,
        long linhVuc, long capDonVi, long donVi, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByTEN_LINHVUC_DONVI(names, linhVuc, capDonVi, donVi,
            andOperator);
    }

    public static java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh> findTEN_LINHVUC_DONVI(
        java.lang.String name, long linhVuc, long capDonVi, long donVi,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findTEN_LINHVUC_DONVI(name, linhVuc, capDonVi, donVi,
            andOperator, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh> findTEN_LINHVUC_DONVI(
        java.lang.String[] names, long linhVuc, long capDonVi, long donVi,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findTEN_LINHVUC_DONVI(names, linhVuc, capDonVi, donVi,
            andOperator, start, end, obc);
    }

    public static ThuTucHanhChinhFinder getFinder() {
        return _finder;
    }

    public void setFinder(ThuTucHanhChinhFinder finder) {
        _finder = finder;
    }
}
