package com.sgs.portlet.document.send.service.persistence;

public interface PmlEdmBookDocumentSendFinder {
    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findDocumentRecordToAgency(
        java.lang.String loaiSoCVs, java.lang.String so, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findDocumentRecordToAgency(
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

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findByKeywordsPB(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findDocumentRecordToDepartment(
        java.lang.String loaiSoCVs, java.lang.String phongBan,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend> findDocumentRecordToDepartment(
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
