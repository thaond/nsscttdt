package com.nss.portlet.phone_book.service.persistence;

public interface ContactBookFinder {
    public int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int count_Contact_Book(java.lang.String contactBookCodes,
        java.lang.String contactBookNames,
        java.lang.String contactBookDescriptions, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public int count_Contact_Book(java.lang.String[] contactBookCodes,
        java.lang.String[] contactBookNames,
        java.lang.String[] contactBookDescriptions, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.phone_book.model.ContactBook> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.phone_book.model.ContactBook> find_contact_book(
        java.lang.String contactBookCodes, java.lang.String contactBookNames,
        java.lang.String contactBookDescriptions, int start, int end,
        boolean andOperator,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.phone_book.model.ContactBook> find_contact_book(
        java.lang.String[] contactBookCodes,
        java.lang.String[] contactBookNames,
        java.lang.String[] contactBookDescriptions, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;
}
