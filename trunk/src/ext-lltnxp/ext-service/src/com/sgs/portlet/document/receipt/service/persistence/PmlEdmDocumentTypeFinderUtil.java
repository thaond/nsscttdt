package com.sgs.portlet.document.receipt.service.persistence;

public class PmlEdmDocumentTypeFinderUtil {
    private static PmlEdmDocumentTypeFinder _finder;

    public static int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getFinder().countByKeywords(keywords);
    }

    public static int countByPmlEdmDocumentType(
        java.lang.String pmlEdmDocumentTypeName,
        java.lang.String pmlEdmDocumentRecordTypeName, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByPmlEdmDocumentType(pmlEdmDocumentTypeName,
            pmlEdmDocumentRecordTypeName, andOperator);
    }

    public static int countByPmlEdmDocumentType(
        java.lang.String[] pmlEdmDocumentTypeNames,
        java.lang.String[] pmlEdmDocumentRecordTypeNames, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByPmlEdmDocumentType(pmlEdmDocumentTypeNames,
            pmlEdmDocumentRecordTypeNames, andOperator);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder().findByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> findByPmlEdmDocumentType(
        java.lang.String pmlEdmDocumentTypeName,
        java.lang.String pmlEdmDocumentRecordTypeName, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByPmlEdmDocumentType(pmlEdmDocumentTypeName,
            pmlEdmDocumentRecordTypeName, andOperator, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> findByPmlEdmDocumentType(
        java.lang.String[] pmlEdmDocumentTypeNames,
        java.lang.String[] pmlEdmDocumentRecordTypeNames, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByPmlEdmDocumentType(pmlEdmDocumentTypeNames,
            pmlEdmDocumentRecordTypeNames, andOperator, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> findByDocumentTypeIds(
        java.util.List<Long> documentTypeIds) throws java.lang.Exception {
        return getFinder().findByDocumentTypeIds(documentTypeIds);
    }

    public static PmlEdmDocumentTypeFinder getFinder() {
        return _finder;
    }

    public void setFinder(PmlEdmDocumentTypeFinder finder) {
        _finder = finder;
    }
}
