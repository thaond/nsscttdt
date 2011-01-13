package com.sgs.portlet.document_manager.service.persistence;

public class DocumentManagerFinderUtil {
    private static DocumentManagerFinder _finder;

    public static int count_document_manager(
        java.lang.String documentManagerCodes,
        java.lang.String documentManagerDescriptions,
        java.lang.String documentManagerTitles, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .count_document_manager(documentManagerCodes,
            documentManagerDescriptions, documentManagerTitles, andOperator);
    }

    public static int count_document_manager(
        java.lang.String[] documentManagerCodes,
        java.lang.String[] documentManagerDescriptions,
        java.lang.String[] documentManagerTitles, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .count_document_manager(documentManagerCodes,
            documentManagerDescriptions, documentManagerTitles, andOperator);
    }

    public static java.util.List<com.sgs.portlet.document_manager.model.DocumentManager> find_document_manager(
        java.lang.String documentManagerCodes,
        java.lang.String documentManagerDescriptions,
        java.lang.String documentManagerTitles, int start, int end,
        boolean andOperator,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .find_document_manager(documentManagerCodes,
            documentManagerDescriptions, documentManagerTitles, start, end,
            andOperator, obc);
    }

    public static java.util.List<com.sgs.portlet.document_manager.model.DocumentManager> find_document_manager(
        java.lang.String[] documentManagerCodes,
        java.lang.String[] documentManagerDescriptions,
        java.lang.String[] documentManagerTitles, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .find_document_manager(documentManagerCodes,
            documentManagerDescriptions, documentManagerTitles, andOperator,
            start, end, obc);
    }

    public static DocumentManagerFinder getFinder() {
        return _finder;
    }

    public void setFinder(DocumentManagerFinder finder) {
        _finder = finder;
    }
}