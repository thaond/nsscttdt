package com.sgs.portlet.document.receipt.service.persistence;

public class PmlEdmDocumentRecordTypeFinderUtil {
    private static PmlEdmDocumentRecordTypeFinder _finder;

    public static int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getFinder().countByKeywords(keywords);
    }

    public static int countByPmlEdmDocumentRecordType(
        java.lang.String pmlEdmDocumentRecordTypeCode,
        java.lang.String pmlEdmDocumentRecordTypeName, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByPmlEdmDocumentRecordType(pmlEdmDocumentRecordTypeCode,
            pmlEdmDocumentRecordTypeName, andOperator);
    }

    public static int countByPmlEdmDocumentRecordType(
        java.lang.String[] pmlEdmDocumentRecordTypeCodes,
        java.lang.String[] pmlEdmDocumentRecordTypeNames, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByPmlEdmDocumentRecordType(pmlEdmDocumentRecordTypeCodes,
            pmlEdmDocumentRecordTypeNames, andOperator);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder().findByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType> findByPmlEdmDocumentRecordType(
        java.lang.String pmlEdmDocumentRecordTypeCode,
        java.lang.String pmlEdmDocumentRecordTypeName, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByPmlEdmDocumentRecordType(pmlEdmDocumentRecordTypeCode,
            pmlEdmDocumentRecordTypeName, andOperator, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType> findByPmlEdmDocumentRecordType(
        java.lang.String[] pmlEdmDocumentRecordTypeCodes,
        java.lang.String[] pmlEdmDocumentRecordTypeNames, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByPmlEdmDocumentRecordType(pmlEdmDocumentRecordTypeCodes,
            pmlEdmDocumentRecordTypeNames, andOperator, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType> findByDocumentRecordTypeCode(
        java.lang.String documentRecordTypeCode)
        throws com.liferay.portal.SystemException {
        return getFinder().findByDocumentRecordTypeCode(documentRecordTypeCode);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType> getDocumentRecordTypeUseForAgency(
        java.lang.String flag, java.lang.String agencyId, int currentYear)
        throws java.lang.Exception {
        return getFinder()
                   .getDocumentRecordTypeUseForAgency(flag, agencyId,
            currentYear);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByDocumentRecordTypeId_Year(
        int documentRecordTypeId, java.lang.String year)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByDocumentRecordTypeId_Year(documentRecordTypeId, year);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType> getDocumentRecordTypeUseForDeparment(
        java.lang.String departmentId, int currentYear)
        throws java.lang.Exception {
        return getFinder()
                   .getDocumentRecordTypeUseForDeparment(departmentId,
            currentYear);
    }

    public static PmlEdmDocumentRecordTypeFinder getFinder() {
        return _finder;
    }

    public void setFinder(PmlEdmDocumentRecordTypeFinder finder) {
        _finder = finder;
    }
}