package com.sgs.portlet.document.receipt.service.persistence;

public interface PmlEdmDocumentRecordToFinder {
    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findDocumentRecordToAgency(
        java.lang.String loaiSoCVs, java.lang.String so, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findDocumentRecordToAgency(
        java.lang.String[] loaiSoCVs, java.lang.String[] so,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int countDocumentRecordToAgency(java.lang.String loaiSoCVs,
        java.lang.String so, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public int countDocumentRecordToAgency(java.lang.String[] loaiSoCVs,
        java.lang.String[] so, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByKeywordsPB(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findDocumentRecordToDepartment(
        java.lang.String loaiSoCVs, java.lang.String phongBan,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findDocumentRecordToDepartment(
        java.lang.String[] loaiSoCVs, java.lang.String[] phongBan,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int countByKeywordsPB(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int countDocumentRecordToDepartment(java.lang.String loaiSoCVs,
        java.lang.String phongBan, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public int countDocumentRecordToDepartment(java.lang.String[] loaiSoCVs,
        java.lang.String[] phongBan, boolean andOperator)
        throws com.liferay.portal.SystemException;
}
