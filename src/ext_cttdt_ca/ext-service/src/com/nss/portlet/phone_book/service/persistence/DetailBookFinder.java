package com.nss.portlet.phone_book.service.persistence;

public interface DetailBookFinder {
    public int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int count_detail_Book(java.lang.String detailBookCodes,
        java.lang.String detailBookNames,
        java.lang.String detailBookDescriptions, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public int count_detail_Book(java.lang.String[] detailBookCodes,
        java.lang.String[] detailBookNames,
        java.lang.String[] detailBookDescriptions, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.phone_book.model.DetailBook> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.phone_book.model.DetailBook> find_detail_book(
        java.lang.String detailBookCodes, java.lang.String detailBookNames,
        java.lang.String detailBookDescriptions, int start, int end,
        boolean andOperator,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.phone_book.model.DetailBook> find_detail_book(
        java.lang.String[] detailBookCodes, java.lang.String[] detailBookNames,
        java.lang.String[] detailBookDescriptions, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;
}
