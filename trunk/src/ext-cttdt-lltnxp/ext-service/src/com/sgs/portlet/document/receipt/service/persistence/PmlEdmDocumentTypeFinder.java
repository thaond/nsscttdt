package com.sgs.portlet.document.receipt.service.persistence;

public interface PmlEdmDocumentTypeFinder {
    public int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int countByPmlEdmDocumentType(
        java.lang.String pmlEdmDocumentTypeName,
        java.lang.String pmlEdmDocumentRecordTypeName, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public int countByPmlEdmDocumentType(
        java.lang.String[] pmlEdmDocumentTypeNames,
        java.lang.String[] pmlEdmDocumentRecordTypeNames, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> findByPmlEdmDocumentType(
        java.lang.String pmlEdmDocumentTypeName,
        java.lang.String pmlEdmDocumentRecordTypeName, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> findByPmlEdmDocumentType(
        java.lang.String[] pmlEdmDocumentTypeNames,
        java.lang.String[] pmlEdmDocumentRecordTypeNames, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentType> findByDocumentTypeIds(
        java.util.List<Long> documentTypeIds) throws java.lang.Exception;
}
