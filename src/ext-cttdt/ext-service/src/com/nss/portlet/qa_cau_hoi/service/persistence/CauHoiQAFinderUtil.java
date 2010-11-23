package com.nss.portlet.qa_cau_hoi.service.persistence;

public class CauHoiQAFinderUtil {
    private static CauHoiQAFinder _finder;

    public static int countByTieuDe_ChuDe(long maChuDeCauHoi,
        java.lang.String name, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder().countByTieuDe_ChuDe(maChuDeCauHoi, name, andOperator);
    }

    public static int countByTieuDe_ChuDe(long maChuDeCauHoi,
        java.lang.String[] names, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder().countByTieuDe_ChuDe(maChuDeCauHoi, names, andOperator);
    }

    public static java.util.List<com.nss.portlet.qa_cau_hoi.model.CauHoiQA> findTieuDe_ChuDe(
        long maChuDeCauHoi, java.lang.String name, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findTieuDe_ChuDe(maChuDeCauHoi, name, andOperator, start,
            end, obc);
    }

    public static java.util.List<com.nss.portlet.qa_cau_hoi.model.CauHoiQA> findTieuDe_ChuDe(
        long maChuDeCauHoi, java.lang.String[] names, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findTieuDe_ChuDe(maChuDeCauHoi, names, andOperator, start,
            end, obc);
    }

    public static int countByTieuDe_ChuDe_PhanQuyen(long userId,
        long maChuDeCauHoi, java.lang.String name, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByTieuDe_ChuDe_PhanQuyen(userId, maChuDeCauHoi, name,
            andOperator);
    }

    public static int countByTieuDe_ChuDe_PhanQuyen(long userId,
        long maChuDeCauHoi, java.lang.String[] names, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByTieuDe_ChuDe_PhanQuyen(userId, maChuDeCauHoi, names,
            andOperator);
    }

    public static java.util.List<com.nss.portlet.qa_cau_hoi.model.CauHoiQA> findTieuDe_ChuDe_PhanQuyen(
        long userId, long maChuDeCauHoi, java.lang.String name,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findTieuDe_ChuDe_PhanQuyen(userId, maChuDeCauHoi, name,
            andOperator, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.qa_cau_hoi.model.CauHoiQA> findTieuDe_ChuDe_PhanQuyen(
        long userId, long maChuDeCauHoi, java.lang.String[] names,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findTieuDe_ChuDe_PhanQuyen(userId, maChuDeCauHoi, names,
            andOperator, start, end, obc);
    }

    public static CauHoiQAFinder getFinder() {
        return _finder;
    }

    public void setFinder(CauHoiQAFinder finder) {
        _finder = finder;
    }
}
