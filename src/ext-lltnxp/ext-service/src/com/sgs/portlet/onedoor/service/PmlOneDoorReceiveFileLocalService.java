package com.sgs.portlet.onedoor.service;


/**
 * <a href="PmlOneDoorReceiveFileLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.onedoor.service.impl.PmlOneDoorReceiveFileLocalServiceImpl</code>.
 * Modify methods in that class and rerun ServiceBuilder to populate this class
 * and all other generated classes.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.onedoor.service.PmlOneDoorReceiveFileLocalServiceUtil
 *
 */
public interface PmlOneDoorReceiveFileLocalService {
    public com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile addPmlOneDoorReceiveFile(
        com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile pmlOneDoorReceiveFile)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile createPmlOneDoorReceiveFile(
        java.lang.String fileId);

    public void deletePmlOneDoorReceiveFile(java.lang.String fileId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlOneDoorReceiveFile(
        com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile pmlOneDoorReceiveFile)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile getPmlOneDoorReceiveFile(
        java.lang.String fileId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getPmlOneDoorReceiveFiles(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlOneDoorReceiveFilesCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile updatePmlOneDoorReceiveFile(
        com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile pmlOneDoorReceiveFile)
        throws com.liferay.portal.SystemException;

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
        com.liferay.portal.kernel.util.OrderByComparator obc);

    public java.util.List<com.sgs.portlet.attachedfile.model.AttachedFile> getAttachedByFileType(
        java.lang.String fileTypeId);

    public java.util.List<com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile> getFileTypeAttachedFileByFileTypeId(
        java.lang.String fileTypeId);

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> filter(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> list,
        java.lang.String fileTypeName, java.util.Date startDate,
        java.util.Date endDate, java.lang.String applicantName,
        java.lang.String organization, java.lang.String address,
        java.lang.String district, java.lang.String numberReceipt);

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> filterByNumberReceipt(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> list,
        java.lang.String numberReceipt);

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> filterByDistrict(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> list,
        java.lang.String district);

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> filterByAddress(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> list,
        java.lang.String address);

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> filterByFileTypeName(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> list,
        java.lang.String fileTypeName);

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> filterByApplicantName(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> list,
        java.lang.String applicantName);

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> filterByOrganization(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> list,
        java.lang.String organization);

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> filterByStartDate(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> list,
        java.util.Date startDate);

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> filterByEndDate(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> list,
        java.util.Date endDate);

    public int counterApplicationFile(java.util.Date startDate,
        java.util.Date endDate, java.lang.String fileTypeId);

    public int counterExactReturningFile(java.util.Date startDate,
        java.util.Date endDate, java.lang.String fileTypeId);

    public int counterExpectedReturningFile(java.util.Date startDate,
        java.util.Date endDate, java.lang.String fileTypeId);

    public java.util.List<com.sgs.portlet.filetype.model.PmlFileType> getListFileTypeByListFile(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> list);

    public java.util.List<com.sgs.portlet.field.model.PmlField> getListFieldByListFile(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> listFile);

    public java.util.List<com.sgs.portlet.department.model.Department> getListDepartmentsByListFile(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> listFile);

    public java.util.List<com.sgs.portlet.agency.model.Agency> getListAgencyByListFile(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> listFile);

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileByField(
        com.sgs.portlet.field.model.PmlField pmlField);

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileByFileType(
        com.sgs.portlet.filetype.model.PmlFileType pmlFileType);

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFile(
        java.util.Date startDate, java.util.Date endDate,
        com.sgs.portlet.field.model.PmlField pmlField);

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFile(
        java.util.Date startDate, java.util.Date endDate);

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileByExactReturningDate(
        java.util.Date startDate, java.util.Date endDate,
        com.sgs.portlet.filetype.model.PmlFileType pmlFileType);

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileByExactReturningFile(
        java.util.Date startDate, java.util.Date endDate);

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileByExpectedReturningDate(
        com.sgs.portlet.filetype.model.PmlFileType pmlFileType,
        java.util.Date startDate, java.util.Date endDate);

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileByApplicationDate(
        com.sgs.portlet.filetype.model.PmlFileType pmlFileType,
        java.util.Date startDate, java.util.Date endDate);

    public java.util.Map<String, java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile>> getListFieldIDAndListFile(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> listFile);

    public java.util.Map<String, java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile>> getListFieldIDAndListFile(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> listFile,
        java.util.Date startDate, java.util.Date endDate);

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileBy_fileTypeId_startDate_endDate(
        java.lang.String fileTypeId, java.util.Date startDate,
        java.util.Date endDate);

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileBy_DepartmentId(
        java.lang.String departmentId);

    public java.util.List<com.sgs.portlet.filetype.model.PmlFileType> getListFileTypeByDepartmentId(
        java.lang.String departmentId);

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileBy_DepartmentId_FileTypeId(
        java.lang.String departmentId, java.lang.String fileTypeId);

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
        com.liferay.portal.kernel.util.OrderByComparator obc);

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileDelegated(
        long userId, java.util.List<String> typeList,
        java.util.List<String> valueTypeList,
        com.liferay.portal.kernel.util.OrderByComparator obc);

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileIsDelegated(
        long userId, java.util.List<String> typeList,
        java.util.List<String> valueTypeList,
        com.liferay.portal.kernel.util.OrderByComparator obc);

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

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoLuongHoSoGiaiQuyet(
        java.util.List<Long> userIds, java.lang.String toDay,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoLuongTongHoSoTonISO(
        java.util.List<Long> userIds, java.lang.String toDay,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoLuongTongHoSoCanXuLy(
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
