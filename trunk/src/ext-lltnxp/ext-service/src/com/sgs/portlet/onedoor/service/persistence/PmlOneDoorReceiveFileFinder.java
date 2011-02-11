package com.sgs.portlet.onedoor.service.persistence;

public interface PmlOneDoorReceiveFileFinder {
    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> search(
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
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileChuaNhanChuaHoanThanh(
        long userId, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileDaNhanChuaHoanThanh(
        long userId, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileQuaHanISOChuaHoanThanh(
        long userId, java.lang.String toDate, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileChoBoSungChuaHoanThanh(
        long userId, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileCanXuLyTrongNgay(
        long userId, java.lang.String toDate, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileNeedProcess(
        long userId, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileDelegated(
        long userId, java.util.List<String> typeList,
        java.util.List<String> valueTypeList,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileIsDelegated(
        long userId, java.util.List<String> typeList,
        java.util.List<String> valueTypeList,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoLuongHoSoTonTruoc(
        java.util.List<Long> userIds, java.lang.String toDay,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoLuongHoSoDaNhan(
        java.util.List<Long> userIds, java.lang.String toDay,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoLuongHoSoChuaNhan(
        java.util.List<Long> userIds, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoLuongTongHoSoCanXuLy(
        java.util.List<Long> userIds, java.lang.String toDay,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoLuongHoSoTuGiaiQuyet(
        java.util.List<Long> userIds, java.lang.String toDay,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoLuongHoSoNguoiKhacThuLyThay(
        java.util.List<Long> userIds, java.lang.String toDay,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoLuongHoSoGiaiQuyet(
        java.util.List<Long> userIds, java.lang.String toDay,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoLuongHoSoTonTrongHanISO(
        java.util.List<Long> userIds, java.lang.String toDay,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoLuongHoSoTonQuaHanISO(
        java.util.List<Long> userIds, java.lang.String toDay,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoLuongTongHoSoTonISO(
        java.util.List<Long> userIds, java.lang.String toDay,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoLuongHSTonBCThang(
        java.util.List<com.sgs.portlet.filetype.model.PmlFileType> fileTypeList,
        java.lang.String fromDate, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoLuongHSNhanTrongThang(
        java.util.List<com.sgs.portlet.filetype.model.PmlFileType> fileTypeList,
        java.lang.String fromDate, java.lang.String toDate,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoLuongTongHS(
        java.util.List<com.sgs.portlet.filetype.model.PmlFileType> fileTypeList,
        java.lang.String fromDate, java.lang.String toDate,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoHSHoanThanhDungHan(
        java.util.List<com.sgs.portlet.filetype.model.PmlFileType> fileTypeList,
        java.lang.String fromDate, java.lang.String toDate,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoHSHoanThanhTreHan(
        java.util.List<com.sgs.portlet.filetype.model.PmlFileType> fileTypeList,
        java.lang.String fromDate, java.lang.String toDate,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoHSDangThuLyDungHan(
        java.util.List<com.sgs.portlet.filetype.model.PmlFileType> fileTypeList,
        java.lang.String fromDate, java.lang.String toDate,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoHSDangThuLyTreHan(
        java.util.List<com.sgs.portlet.filetype.model.PmlFileType> fileTypeList,
        java.lang.String fromDate, java.lang.String toDate,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoHSChoBoSung(
        java.util.List<com.sgs.portlet.filetype.model.PmlFileType> fileTypeList,
        java.lang.String fromDate, java.lang.String toDate,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListTonDauKyThangLuyKe(
        java.lang.String departmentId, java.util.List<Long> userIds,
        java.lang.String fileTypeId, java.lang.String fromDate,
        java.lang.String toDate, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListHSNhanTrongThangThangLuyKe(
        java.lang.String departmentId, java.util.List<Long> userIds,
        java.lang.String fileTypeId, java.lang.String fromDate,
        java.lang.String toDate, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListTongHSNhanThangLuyKe(
        java.lang.String departmentId, java.util.List<Long> userIds,
        java.lang.String fileTypeId, java.lang.String fromDate,
        java.lang.String toDate, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListHSNhanTrongNamThangLuyKe(
        java.lang.String departmentId, java.util.List<Long> userIds,
        java.lang.String fileTypeId, java.lang.String fromDate,
        java.lang.String toDate, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListHSGiaiQuyetTrongThangLuyKe(
        java.lang.String departmentId, java.util.List<Long> userIds,
        java.lang.String fileTypeId, java.lang.String fromDate,
        java.lang.String toDate, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListHSGiaiQuyetTrongNamLuyKe(
        java.lang.String departmentId, java.util.List<Long> userIds,
        java.lang.String fileTypeId, java.lang.String fromDate,
        java.lang.String toDate, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListHSTonDenNgayBCThangLuyKe(
        java.lang.String departmentId, java.util.List<Long> userIds,
        java.lang.String fileTypeId, java.lang.String toDate,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByTEN_MA_NAM_HS(
        long userId, int year, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int getGeneralNumberReceipt(java.lang.String ddmmyyyyReceiveDate)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByPMLFILERETURN(
        java.util.List<String> fileTypeIds, int year,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> onedoorSearch(
        java.lang.String numberreceipt, java.lang.String filename,
        java.lang.String applicantname, java.lang.String permanentaddress,
        java.lang.String telephone, java.lang.String filetypeid,
        java.lang.String tuNgayTiepNhan, java.lang.String denNgayTiepNhan,
        java.lang.String tuNgayHenTra, java.lang.String denNgayHenTra,
        java.lang.String tuNgayHSHoanThanh,
        java.lang.String denNgayHSHoanThanh, java.lang.String tuNgayHSTraThuc,
        java.lang.String denNgayHSTraThuc, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int onedoorSearchCount(java.lang.String numberreceipt,
        java.lang.String filename, java.lang.String applicantname,
        java.lang.String permanentaddress, java.lang.String telephone,
        java.lang.String filetypeid, java.lang.String tuNgayTiepNhan,
        java.lang.String denNgayTiepNhan, java.lang.String tuNgayHenTra,
        java.lang.String denNgayHenTra, java.lang.String tuNgayHSHoanThanh,
        java.lang.String denNgayHSHoanThanh, java.lang.String tuNgayHSTraThuc,
        java.lang.String denNgayHSTraThuc)
        throws com.liferay.portal.SystemException;

    public int countSoLuongHoSoTonTruoc(java.util.List<Long> userIds,
        java.lang.String fromDate, java.lang.String toDate)
        throws com.liferay.portal.SystemException;

    public int countSoLuongHoSoNhanTrongThang(java.util.List<Long> userIds,
        java.lang.String fromDate, java.lang.String toDate)
        throws com.liferay.portal.SystemException;

    public int countSoLuongHoSoDaXuLy(java.util.List<Long> userIds,
        java.lang.String fromDate, java.lang.String toDate)
        throws com.liferay.portal.SystemException;

    public int countSoLuongHoSoConTon(java.util.List<Long> userIds,
        java.lang.String fromDate, java.lang.String toDate)
        throws com.liferay.portal.SystemException;
}
