package com.nss.portlet.media_library.service.persistence;

public interface MediaLibraryFinder {
    public int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int countMediaLibrary(java.lang.String tieuDeMediaLibrary,
        java.lang.String tenMediaLibrary, long maMediaChuDe, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public int countMediaLibrary(java.lang.String[] tieuDeMediaLibrary,
        java.lang.String[] tenMediaLibrary, long maMediaChuDe,
        boolean andOperator) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.media_library.model.MediaLibrary> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.media_library.model.MediaLibrary> findMediaLibrary(
        java.lang.String tieuDeMediaLibrary, java.lang.String tenMediaLibrary,
        long maMediaChuDe, boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.media_library.model.MediaLibrary> findMediaLibrary(
        java.lang.String[] tieuDeMediaLibrary,
        java.lang.String[] tenMediaLibrary, long maMediaChuDe,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;
}
