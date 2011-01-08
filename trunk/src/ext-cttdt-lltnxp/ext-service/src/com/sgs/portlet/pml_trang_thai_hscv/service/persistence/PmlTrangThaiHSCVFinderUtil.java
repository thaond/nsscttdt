package com.sgs.portlet.pml_trang_thai_hscv.service.persistence;

public class PmlTrangThaiHSCVFinderUtil {
    private static PmlTrangThaiHSCVFinder _finder;

    public static int countByC_G(boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder().countByC_G(andOperator);
    }

    public static java.util.List<com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV> findByC_G(
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder().findByC_G(andOperator, start, end, obc);
    }

    public static PmlTrangThaiHSCVFinder getFinder() {
        return _finder;
    }

    public void setFinder(PmlTrangThaiHSCVFinder finder) {
        _finder = finder;
    }
}
