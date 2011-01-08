package com.sgs.portlet.document.receipt.service.persistence;

public class PmlEdmDocumentReceiptTempFinderUtil {
    private static PmlEdmDocumentReceiptTempFinder _finder;

    public static int countPmlEdmDocumentReceiptTemp(java.lang.String soVBDen,
        java.lang.String soHieuGoc, int loaiSoVanBan,
        java.lang.String issuingplaceId, java.lang.String noiBanHanh,
        java.lang.String trichYeu, java.lang.String tuNgay,
        java.lang.String denNgay) throws com.liferay.portal.SystemException {
        return getFinder()
                   .countPmlEdmDocumentReceiptTemp(soVBDen, soHieuGoc,
            loaiSoVanBan, issuingplaceId, noiBanHanh, trichYeu, tuNgay, denNgay);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> listPmlEdmDocumentReceiptTemp(
        java.lang.String soVBDen, java.lang.String soHieuGoc, int loaiSoVanBan,
        java.lang.String issuingplaceId, java.lang.String noiBanHanh,
        java.lang.String trichYeu, java.lang.String tuNgay,
        java.lang.String denNgay, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .listPmlEdmDocumentReceiptTemp(soVBDen, soHieuGoc,
            loaiSoVanBan, issuingplaceId, noiBanHanh, trichYeu, tuNgay,
            denNgay, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> getAllList(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder().getAllList(start, end, obc);
    }

    public static int countAllList() throws com.liferay.portal.SystemException {
        return getFinder().countAllList();
    }

    public static PmlEdmDocumentReceiptTempFinder getFinder() {
        return _finder;
    }

    public void setFinder(PmlEdmDocumentReceiptTempFinder finder) {
        _finder = finder;
    }
}
