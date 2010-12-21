package com.nss.portlet.qa_chu_de.service.persistence;

public class QAChuDeCauHoiFinderUtil {
    private static QAChuDeCauHoiFinder _finder;

    public static int countChuDeCauHoi(java.lang.String tenChuDeCauHoi,
        boolean andOperator) throws com.liferay.portal.SystemException {
        return getFinder().countChuDeCauHoi(tenChuDeCauHoi, andOperator);
    }

    public static int countChuDeCauHoi(java.lang.String[] tenChuDeCauHoi,
        boolean andOperator) throws com.liferay.portal.SystemException {
        return getFinder().countChuDeCauHoi(tenChuDeCauHoi, andOperator);
    }

    public static java.util.List<com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi> findChuDeCauHoi(
        java.lang.String tenChuDeCauHoi, boolean andOperator, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findChuDeCauHoi(tenChuDeCauHoi, andOperator, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi> findChuDeCauHoi(
        java.lang.String[] tenChuDeCauHoi, boolean andOperator, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findChuDeCauHoi(tenChuDeCauHoi, andOperator, start, end, obc);
    }

    public static QAChuDeCauHoiFinder getFinder() {
        return _finder;
    }

    public void setFinder(QAChuDeCauHoiFinder finder) {
        _finder = finder;
    }
}
