package com.sgs.portlet.pml_do_quan_trong.service.persistence;

public class PmlDoQuanTrongFinderUtil {
    private static PmlDoQuanTrongFinder _finder;

    public static int countByC_G(boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder().countByC_G(andOperator);
    }

    public static java.util.List<com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong> findByC_G(
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder().findByC_G(andOperator, start, end, obc);
    }

    public static PmlDoQuanTrongFinder getFinder() {
        return _finder;
    }

    public void setFinder(PmlDoQuanTrongFinder finder) {
        _finder = finder;
    }
}
