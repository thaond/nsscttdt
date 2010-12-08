package com.nss.portlet.onedoor.service.persistence;

public class PmlOneDoorReceiveFileFinderUtil {
    private static PmlOneDoorReceiveFileFinder _finder;

    public static int getGeneralNumberReceipt(
        java.lang.String ddmmyyyyReceiveDate)
        throws com.liferay.portal.SystemException {
        return getFinder().getGeneralNumberReceipt(ddmmyyyyReceiveDate);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileChuaNhanChuaHoanThanh(
        long userId, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .getListFileChuaNhanChuaHoanThanh(userId, typeList,
            valueTypeList, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileCanXuLyTrongNgay(
        long userId, java.lang.String toDate, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .getListFileCanXuLyTrongNgay(userId, toDate, typeList,
            valueTypeList, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileQuaHanISOChuaHoanThanh(
        long userId, java.lang.String toDate, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .getListFileQuaHanISOChuaHoanThanh(userId, toDate, typeList,
            valueTypeList, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileChoBoSungChuaHoanThanh(
        long userId, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .getListFileChoBoSungChuaHoanThanh(userId, typeList,
            valueTypeList, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileNeedProcess(
        long userId, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .getListFileNeedProcess(userId, typeList, valueTypeList,
            start, end, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileDelegated(
        long userId, java.util.List<String> typeList,
        java.util.List<String> valueTypeList,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .getListFileDelegated(userId, typeList, valueTypeList, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileIsDelegated(
        long userId, java.util.List<String> typeList,
        java.util.List<String> valueTypeList,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .getListFileIsDelegated(userId, typeList, valueTypeList, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> search(
        java.lang.String numberreceipt, java.lang.String filename,
        java.lang.String applicantname, java.lang.String permanentaddress,
        java.lang.String telephone, java.lang.String filetypeid,
        java.lang.String tuNgayTiepNhan, java.lang.String denNgayTiepNhan,
        java.lang.String tuNgayHenTra, java.lang.String denNgayHenTra,
        java.lang.String tuNgayHSHoanThanh,
        java.lang.String denNgayHSHoanThanh, java.lang.String tuNgayHSTraThuc,
        java.lang.String denNgayHSTraThuc, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .search(numberreceipt, filename, applicantname,
            permanentaddress, telephone, filetypeid, tuNgayTiepNhan,
            denNgayTiepNhan, tuNgayHenTra, denNgayHenTra, tuNgayHSHoanThanh,
            denNgayHSHoanThanh, tuNgayHSTraThuc, denNgayHSTraThuc, typeList,
            valueTypeList, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> findByPMLFILERETURN(
        java.util.List<String> fileTypeIds, int year,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByPMLFILERETURN(fileTypeIds, year, typeList,
            valueTypeList, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> findByTEN_MA_NAM_HS(
        long userId, int year, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByTEN_MA_NAM_HS(userId, year, typeList, valueTypeList,
            start, end, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoLuongHSTonBCThang(
        java.util.List<com.nss.portlet.filetype.model.PmlFileType> fileTypeList,
        java.lang.String fromDate, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .getSoLuongHSTonBCThang(fileTypeList, fromDate, typeList,
            valueTypeList, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoLuongHSNhanTrongThang(
        java.util.List<com.nss.portlet.filetype.model.PmlFileType> fileTypeList,
        java.lang.String fromDate, java.lang.String toDate,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .getSoLuongHSNhanTrongThang(fileTypeList, fromDate, toDate,
            typeList, valueTypeList, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoLuongTongHS(
        java.util.List<com.nss.portlet.filetype.model.PmlFileType> fileTypeList,
        java.lang.String fromDate, java.lang.String toDate,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .getSoLuongTongHS(fileTypeList, fromDate, toDate, typeList,
            valueTypeList, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoHSHoanThanhDungHan(
        java.util.List<com.nss.portlet.filetype.model.PmlFileType> fileTypeList,
        java.lang.String fromDate, java.lang.String toDate,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .getSoHSHoanThanhDungHan(fileTypeList, fromDate, toDate,
            typeList, valueTypeList, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoHSHoanThanhTreHan(
        java.util.List<com.nss.portlet.filetype.model.PmlFileType> fileTypeList,
        java.lang.String fromDate, java.lang.String toDate,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .getSoHSHoanThanhTreHan(fileTypeList, fromDate, toDate,
            typeList, valueTypeList, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoHSDangThuLyDungHan(
        java.util.List<com.nss.portlet.filetype.model.PmlFileType> fileTypeList,
        java.lang.String fromDate, java.lang.String toDate,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .getSoHSDangThuLyDungHan(fileTypeList, fromDate, toDate,
            typeList, valueTypeList, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoHSDangThuLyTreHan(
        java.util.List<com.nss.portlet.filetype.model.PmlFileType> fileTypeList,
        java.lang.String fromDate, java.lang.String toDate,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .getSoHSDangThuLyTreHan(fileTypeList, fromDate, toDate,
            typeList, valueTypeList, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoHSChoBoSung(
        java.util.List<com.nss.portlet.filetype.model.PmlFileType> fileTypeList,
        java.lang.String fromDate, java.lang.String toDate,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .getSoHSChoBoSung(fileTypeList, fromDate, toDate, typeList,
            valueTypeList, start, end, obc);
    }

    public static PmlOneDoorReceiveFileFinder getFinder() {
        return _finder;
    }

    public void setFinder(PmlOneDoorReceiveFileFinder finder) {
        _finder = finder;
    }
}
