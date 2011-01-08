package com.sgs.portlet.pml_ho_so_cong_viec.service.persistence;

public interface PmlChiTietHSCVFinder {
    public int countByID_T_C(long[] idTinhChats)
        throws com.liferay.portal.SystemException;

    public int countByID_T_T_HSCV(long[] idTrangThaiHSCVs)
        throws com.liferay.portal.SystemException;

    public int countByID_D_Q_T(long[] idDoQuanTrongs)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByCVDen(
        long idHoSoCongViec, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByCVDi(
        long idHoSoCongViec, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findBy_F_ATT_CVDEN(
        long[] documentreceiptids) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findBy_F_ATT_CVDI(
        long[] documentreceiptids) throws com.liferay.portal.SystemException;

    public int countByCVDen(long idHoSoCongViec, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public int countByCVDi(long idHoSoCongViec, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend> findBy_CreateDateDocSend(
        long[] documentSendIds) throws com.liferay.portal.SystemException;
}
