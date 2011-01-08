package com.sgs.portlet.pml_ho_so_cong_viec.service.persistence;

public class PmlChiTietHSCVFinderUtil {
    private static PmlChiTietHSCVFinder _finder;

    public static int countByID_T_C(long[] idTinhChats)
        throws com.liferay.portal.SystemException {
        return getFinder().countByID_T_C(idTinhChats);
    }

    public static int countByID_T_T_HSCV(long[] idTrangThaiHSCVs)
        throws com.liferay.portal.SystemException {
        return getFinder().countByID_T_T_HSCV(idTrangThaiHSCVs);
    }

    public static int countByID_D_Q_T(long[] idDoQuanTrongs)
        throws com.liferay.portal.SystemException {
        return getFinder().countByID_D_Q_T(idDoQuanTrongs);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByCVDen(
        long idHoSoCongViec, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder().findByCVDen(idHoSoCongViec, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByCVDi(
        long idHoSoCongViec, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder().findByCVDi(idHoSoCongViec, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findBy_F_ATT_CVDEN(
        long[] documentreceiptids) throws com.liferay.portal.SystemException {
        return getFinder().findBy_F_ATT_CVDEN(documentreceiptids);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile> findBy_F_ATT_CVDI(
        long[] documentreceiptids) throws com.liferay.portal.SystemException {
        return getFinder().findBy_F_ATT_CVDI(documentreceiptids);
    }

    public static int countByCVDen(long idHoSoCongViec, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder().countByCVDen(idHoSoCongViec, andOperator);
    }

    public static int countByCVDi(long idHoSoCongViec, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder().countByCVDi(idHoSoCongViec, andOperator);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend> findBy_CreateDateDocSend(
        long[] documentSendIds) throws com.liferay.portal.SystemException {
        return getFinder().findBy_CreateDateDocSend(documentSendIds);
    }

    public static PmlChiTietHSCVFinder getFinder() {
        return _finder;
    }

    public void setFinder(PmlChiTietHSCVFinder finder) {
        _finder = finder;
    }
}
