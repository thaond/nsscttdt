package com.sgs.portlet.document_manager.service.persistence;

public class DocumentManagerFinderUtil {
    private static DocumentManagerFinder _finder;

    public static int count_document_manager(
        java.lang.String documentManagerCodes,
        java.lang.String documentManagerCategorys,
        java.lang.String documentManagerDescriptions,
        java.lang.String documentManagerTitles,
        java.lang.String documentManagerStyles, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .count_document_manager(documentManagerCodes,
            documentManagerCategorys, documentManagerDescriptions,
            documentManagerTitles, documentManagerStyles, andOperator);
    }

    public static int count_document_manager(
        java.lang.String[] documentManagerCodes,
        java.lang.String[] documentManagerCategorys,
        java.lang.String[] documentManagerDescriptions,
        java.lang.String[] documentManagerTitles,
        java.lang.String[] documentManagerStyles, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .count_document_manager(documentManagerCodes,
            documentManagerCategorys, documentManagerDescriptions,
            documentManagerTitles, documentManagerStyles, andOperator);
    }

    public static java.util.List<com.sgs.portlet.document_manager.model.DocumentManager> find_document_manager(
        java.lang.String documentManagerCodes,
        java.lang.String documentManagerCategorys,
        java.lang.String documentManagerDescriptions,
        java.lang.String documentManagerTitles,
        java.lang.String documentManagerStyles, int start, int end,
        boolean andOperator,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .find_document_manager(documentManagerCodes,
            documentManagerCategorys, documentManagerDescriptions,
            documentManagerTitles, documentManagerStyles, start, end,
            andOperator, obc);
    }

    public static java.util.List<com.sgs.portlet.document_manager.model.DocumentManager> find_document_manager(
        java.lang.String[] documentManagerCodes,
        java.lang.String[] documentManagerCategorys,
        java.lang.String[] documentManagerDescriptions,
        java.lang.String[] documentManagerTitles,
        java.lang.String[] documentManagerStyles, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .find_document_manager(documentManagerCodes,
            documentManagerCategorys, documentManagerDescriptions,
            documentManagerTitles, documentManagerStyles, andOperator, start,
            end, obc);
    }

    public static int count_document_manager_test(
        java.lang.String documentManagerCodes,
        java.lang.String documentManagerCategorys,
        java.lang.String documentManagerDescriptions,
        java.lang.String documentManagerTitles,
        java.lang.String documentManagerStyles, java.lang.String dateFrom,
        java.lang.String dateTo, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .count_document_manager_test(documentManagerCodes,
            documentManagerCategorys, documentManagerDescriptions,
            documentManagerTitles, documentManagerStyles, dateFrom, dateTo,
            andOperator);
    }

    public static int count_document_manager_test(
        java.lang.String[] documentManagerCodes,
        java.lang.String[] documentManagerCategorys,
        java.lang.String[] documentManagerDescriptions,
        java.lang.String[] documentManagerTitles,
        java.lang.String[] documentManagerStyles, java.lang.String dateFrom,
        java.lang.String dateTo, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .count_document_manager_test(documentManagerCodes,
            documentManagerCategorys, documentManagerDescriptions,
            documentManagerTitles, documentManagerStyles, dateFrom, dateTo,
            andOperator);
    }

    public static java.util.List<com.sgs.portlet.document_manager.model.DocumentManager> find_document_manager_test(
        java.lang.String documentManagerCodes,
        java.lang.String documentManagerCategorys,
        java.lang.String documentManagerDescriptions,
        java.lang.String documentManagerTitles,
        java.lang.String documentManagerStyles, java.lang.String dateFrom,
        java.lang.String dateTo, int start, int end, boolean andOperator,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .find_document_manager_test(documentManagerCodes,
            documentManagerCategorys, documentManagerDescriptions,
            documentManagerTitles, documentManagerStyles, dateFrom, dateTo,
            start, end, andOperator, obc);
    }

    public static java.util.List<com.sgs.portlet.document_manager.model.DocumentManager> find_document_manager_test(
        java.lang.String[] documentManagerCodes,
        java.lang.String[] documentManagerCategorys,
        java.lang.String[] documentManagerDescriptions,
        java.lang.String[] documentManagerTitles,
        java.lang.String[] documentManagerStyles, boolean andOperator,
        java.lang.String dateFrom, java.lang.String dateTo, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .find_document_manager_test(documentManagerCodes,
            documentManagerCategorys, documentManagerDescriptions,
            documentManagerTitles, documentManagerStyles, andOperator,
            dateFrom, dateTo, start, end, obc);
    }

    public static DocumentManagerFinder getFinder() {
        return _finder;
    }

    public void setFinder(DocumentManagerFinder finder) {
        _finder = finder;
    }
}
