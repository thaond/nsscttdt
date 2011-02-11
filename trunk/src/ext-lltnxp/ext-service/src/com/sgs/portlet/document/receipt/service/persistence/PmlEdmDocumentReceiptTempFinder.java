package com.sgs.portlet.document.receipt.service.persistence;

public interface PmlEdmDocumentReceiptTempFinder {
    public int countPmlEdmDocumentReceiptTemp(java.lang.String soVBDen,
        java.lang.String soHieuGoc, int loaiSoVanBan,
        java.lang.String issuingplaceId, java.lang.String noiBanHanh,
        java.lang.String trichYeu, java.lang.String tuNgay,
        java.lang.String denNgay) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> listPmlEdmDocumentReceiptTemp(
        java.lang.String soVBDen, java.lang.String soHieuGoc, int loaiSoVanBan,
        java.lang.String issuingplaceId, java.lang.String noiBanHanh,
        java.lang.String trichYeu, java.lang.String tuNgay,
        java.lang.String denNgay, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp> getAllList(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int countAllList() throws com.liferay.portal.SystemException;
}
