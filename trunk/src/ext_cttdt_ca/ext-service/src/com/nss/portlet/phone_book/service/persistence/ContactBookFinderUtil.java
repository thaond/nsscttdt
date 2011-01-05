package com.nss.portlet.phone_book.service.persistence;

public class ContactBookFinderUtil {
    private static ContactBookFinder _finder;

    public static int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getFinder().countByKeywords(keywords);
    }

    public static int count_Contact_Book(java.lang.String contactBookCodes,
        java.lang.String contactBookNames,
        java.lang.String contactBookDescriptions, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .count_Contact_Book(contactBookCodes, contactBookNames,
            contactBookDescriptions, andOperator);
    }

    public static int count_Contact_Book(java.lang.String[] contactBookCodes,
        java.lang.String[] contactBookNames,
        java.lang.String[] contactBookDescriptions, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .count_Contact_Book(contactBookCodes, contactBookNames,
            contactBookDescriptions, andOperator);
    }

    public static java.util.List<com.nss.portlet.phone_book.model.ContactBook> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder().findByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.phone_book.model.ContactBook> find_contact_book(
        java.lang.String contactBookCodes, java.lang.String contactBookNames,
        java.lang.String contactBookDescriptions, int start, int end,
        boolean andOperator,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .find_contact_book(contactBookCodes, contactBookNames,
            contactBookDescriptions, start, end, andOperator, obc);
    }

    public static java.util.List<com.nss.portlet.phone_book.model.ContactBook> find_contact_book(
        java.lang.String[] contactBookCodes,
        java.lang.String[] contactBookNames,
        java.lang.String[] contactBookDescriptions, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .find_contact_book(contactBookCodes, contactBookNames,
            contactBookDescriptions, andOperator, start, end, obc);
    }

    public static ContactBookFinder getFinder() {
        return _finder;
    }

    public void setFinder(ContactBookFinder finder) {
        _finder = finder;
    }
}
