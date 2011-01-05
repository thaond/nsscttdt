package com.nss.portlet.phone_book.service.persistence;

public class DetailBookFinderUtil {
    private static DetailBookFinder _finder;

    public static int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getFinder().countByKeywords(keywords);
    }

    public static int count_detail_Book(java.lang.String detailBookCodes,
        java.lang.String detailBookNames,
        java.lang.String detailBookDescriptions, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .count_detail_Book(detailBookCodes, detailBookNames,
            detailBookDescriptions, andOperator);
    }

    public static int count_detail_Book(java.lang.String[] detailBookCodes,
        java.lang.String[] detailBookNames,
        java.lang.String[] detailBookDescriptions, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .count_detail_Book(detailBookCodes, detailBookNames,
            detailBookDescriptions, andOperator);
    }

    public static java.util.List<com.nss.portlet.phone_book.model.DetailBook> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder().findByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.phone_book.model.DetailBook> find_detail_book(
        java.lang.String detailBookCodes, java.lang.String detailBookNames,
        java.lang.String detailBookDescriptions, int start, int end,
        boolean andOperator,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .find_detail_book(detailBookCodes, detailBookNames,
            detailBookDescriptions, start, end, andOperator, obc);
    }

    public static java.util.List<com.nss.portlet.phone_book.model.DetailBook> find_detail_book(
        java.lang.String[] detailBookCodes, java.lang.String[] detailBookNames,
        java.lang.String[] detailBookDescriptions, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .find_detail_book(detailBookCodes, detailBookNames,
            detailBookDescriptions, andOperator, start, end, obc);
    }

    public static DetailBookFinder getFinder() {
        return _finder;
    }

    public void setFinder(DetailBookFinder finder) {
        _finder = finder;
    }
}
