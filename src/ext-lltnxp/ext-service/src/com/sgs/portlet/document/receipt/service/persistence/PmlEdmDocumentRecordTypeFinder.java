package com.sgs.portlet.document.receipt.service.persistence;

public interface PmlEdmDocumentRecordTypeFinder {
    public int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int countByPmlEdmDocumentRecordType(
        java.lang.String pmlEdmDocumentRecordTypeCode,
        java.lang.String pmlEdmDocumentRecordTypeName, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public int countByPmlEdmDocumentRecordType(
        java.lang.String[] pmlEdmDocumentRecordTypeCodes,
        java.lang.String[] pmlEdmDocumentRecordTypeNames, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType> findByPmlEdmDocumentRecordType(
        java.lang.String pmlEdmDocumentRecordTypeCode,
        java.lang.String pmlEdmDocumentRecordTypeName, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType> findByPmlEdmDocumentRecordType(
        java.lang.String[] pmlEdmDocumentRecordTypeCodes,
        java.lang.String[] pmlEdmDocumentRecordTypeNames, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType> findByDocumentRecordTypeCode(
        java.lang.String documentRecordTypeCode)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType> getDocumentRecordTypeUseForAgency(
        java.lang.String flag, java.lang.String agencyId, int currentYear)
        throws java.lang.Exception;
}
