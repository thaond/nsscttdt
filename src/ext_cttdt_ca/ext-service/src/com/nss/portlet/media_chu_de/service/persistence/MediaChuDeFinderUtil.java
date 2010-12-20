package com.nss.portlet.media_chu_de.service.persistence;

public class MediaChuDeFinderUtil {
    private static MediaChuDeFinder _finder;

    public static int countMediaChuDe(java.lang.String tenMediaChuDe,
        boolean andOperator) throws com.liferay.portal.SystemException {
        return getFinder().countMediaChuDe(tenMediaChuDe, andOperator);
    }

    public static int countMediaChuDe(java.lang.String[] tenMediaChuDe,
        boolean andOperator) throws com.liferay.portal.SystemException {
        return getFinder().countMediaChuDe(tenMediaChuDe, andOperator);
    }

    public static java.util.List<com.nss.portlet.media_chu_de.model.MediaChuDe> findMediaChuDe(
        java.lang.String tenMediaChuDe, boolean andOperator, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findMediaChuDe(tenMediaChuDe, andOperator, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.media_chu_de.model.MediaChuDe> findMediaChuDe(
        java.lang.String[] tenMediaChuDe, boolean andOperator, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findMediaChuDe(tenMediaChuDe, andOperator, start, end, obc);
    }

    public static MediaChuDeFinder getFinder() {
        return _finder;
    }

    public void setFinder(MediaChuDeFinder finder) {
        _finder = finder;
    }
}
