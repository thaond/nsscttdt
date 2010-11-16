package com.nss.portlet.media_chu_de.service.persistence;

public interface MediaChuDeFinder {
    public int countMediaChuDe(java.lang.String tenMediaChuDe,
        boolean andOperator) throws com.liferay.portal.SystemException;

    public int countMediaChuDe(java.lang.String[] tenMediaChuDe,
        boolean andOperator) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.media_chu_de.model.MediaChuDe> findMediaChuDe(
        java.lang.String tenMediaChuDe, boolean andOperator, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.media_chu_de.model.MediaChuDe> findMediaChuDe(
        java.lang.String[] tenMediaChuDe, boolean andOperator, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;
}
