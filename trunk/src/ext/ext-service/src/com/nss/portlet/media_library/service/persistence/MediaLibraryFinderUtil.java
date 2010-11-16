package com.nss.portlet.media_library.service.persistence;

public class MediaLibraryFinderUtil {
    private static MediaLibraryFinder _finder;

    public static int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getFinder().countByKeywords(keywords);
    }

    public static int countMediaLibrary(java.lang.String tieuDeMediaLibrary,
        java.lang.String tenMediaLibrary, long maMediaChuDe, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countMediaLibrary(tieuDeMediaLibrary, tenMediaLibrary,
            maMediaChuDe, andOperator);
    }

    public static int countMediaLibrary(java.lang.String[] tieuDeMediaLibrary,
        java.lang.String[] tenMediaLibrary, long maMediaChuDe,
        boolean andOperator) throws com.liferay.portal.SystemException {
        return getFinder()
                   .countMediaLibrary(tieuDeMediaLibrary, tenMediaLibrary,
            maMediaChuDe, andOperator);
    }

    public static java.util.List<com.nss.portlet.media_library.model.MediaLibrary> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder().findByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.media_library.model.MediaLibrary> findMediaLibrary(
        java.lang.String tieuDeMediaLibrary, java.lang.String tenMediaLibrary,
        long maMediaChuDe, boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findMediaLibrary(tieuDeMediaLibrary, tenMediaLibrary,
            maMediaChuDe, andOperator, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.media_library.model.MediaLibrary> findMediaLibrary(
        java.lang.String[] tieuDeMediaLibrary,
        java.lang.String[] tenMediaLibrary, long maMediaChuDe,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findMediaLibrary(tieuDeMediaLibrary, tenMediaLibrary,
            maMediaChuDe, andOperator, start, end, obc);
    }

    public static MediaLibraryFinder getFinder() {
        return _finder;
    }

    public void setFinder(MediaLibraryFinder finder) {
        _finder = finder;
    }
}
