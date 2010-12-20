package com.nss.portlet.onedoor.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


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
 * <code>com.nss.portlet.onedoor.service.impl.PmlOneDoorReceiveFileLocalServiceImpl</code>.
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
 * @see com.nss.portlet.onedoor.service.PmlOneDoorReceiveFileLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface PmlOneDoorReceiveFileLocalService {
    public com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile addPmlOneDoorReceiveFile(
        com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile pmlOneDoorReceiveFile)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile createPmlOneDoorReceiveFile(
        java.lang.String fileId);

    public void deletePmlOneDoorReceiveFile(java.lang.String fileId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlOneDoorReceiveFile(
        com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile pmlOneDoorReceiveFile)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile getPmlOneDoorReceiveFile(
        java.lang.String fileId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getPmlOneDoorReceiveFiles(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getPmlOneDoorReceiveFilesCount()
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile updatePmlOneDoorReceiveFile(
        com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile pmlOneDoorReceiveFile)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile updatePmlOneDoorReceiveFile(
        com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile pmlOneDoorReceiveFile,
        boolean merge) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getGeneralNumberReceipt(java.lang.String ddmmyyyyReceiveDate)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileChuaNhanChuaHoanThanh(
        long userId, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileCanXuLyTrongNgay(
        long userId, java.lang.String toDate, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileQuaHanISOChuaHoanThanh(
        long userId, java.lang.String toDate, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileChoBoSungChuaHoanThanh(
        long userId, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileNeedProcess(
        long userId, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc);

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileDelegated(
        long userId, java.util.List<String> typeList,
        java.util.List<String> valueTypeList,
        com.liferay.portal.kernel.util.OrderByComparator obc);

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileIsDelegated(
        long userId, java.util.List<String> typeList,
        java.util.List<String> valueTypeList,
        com.liferay.portal.kernel.util.OrderByComparator obc);

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> search(
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

    public java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> findByFileTypeId(
        java.lang.String fileTypeId);

    public java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> findByPMLFILERETURN(
        java.util.List<String> fileTypeIds, int year,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> findByTEN_MA_NAM_HS(
        long userId, int year, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoLuongHSTonBCThang(
        java.util.List<com.nss.portlet.filetype.model.PmlFileType> fileTypeList,
        java.lang.String fromDate, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoLuongHSNhanTrongThang(
        java.util.List<com.nss.portlet.filetype.model.PmlFileType> fileTypeList,
        java.lang.String fromDate, java.lang.String toDate,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoLuongTongHS(
        java.util.List<com.nss.portlet.filetype.model.PmlFileType> fileTypeList,
        java.lang.String fromDate, java.lang.String toDate,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoHSHoanThanhDungHan(
        java.util.List<com.nss.portlet.filetype.model.PmlFileType> fileTypeList,
        java.lang.String fromDate, java.lang.String toDate,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoHSHoanThanhTreHan(
        java.util.List<com.nss.portlet.filetype.model.PmlFileType> fileTypeList,
        java.lang.String fromDate, java.lang.String toDate,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoHSDangThuLyDungHan(
        java.util.List<com.nss.portlet.filetype.model.PmlFileType> fileTypeList,
        java.lang.String fromDate, java.lang.String toDate,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoHSDangThuLyTreHan(
        java.util.List<com.nss.portlet.filetype.model.PmlFileType> fileTypeList,
        java.lang.String fromDate, java.lang.String toDate,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoHSChoBoSung(
        java.util.List<com.nss.portlet.filetype.model.PmlFileType> fileTypeList,
        java.lang.String fromDate, java.lang.String toDate,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getListHSTonDenNgayBCThangLuyKe(
        java.lang.String departmentId, java.util.List<Long> userIds,
        java.lang.String fileTypeId, java.lang.String toDate,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getListHSGiaiQuyetTrongNamLuyKe(
        java.lang.String departmentId, java.util.List<Long> userIds,
        java.lang.String fileTypeId, java.lang.String fromDate,
        java.lang.String toDate, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getListHSGiaiQuyetTrongThangLuyKe(
        java.lang.String departmentId, java.util.List<Long> userIds,
        java.lang.String fileTypeId, java.lang.String fromDate,
        java.lang.String toDate, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getListHSNhanTrongNamThangLuyKe(
        java.lang.String departmentId, java.util.List<Long> userIds,
        java.lang.String fileTypeId, java.lang.String fromDate,
        java.lang.String toDate, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getListTongHSNhanThangLuyKe(
        java.lang.String departmentId, java.util.List<Long> userIds,
        java.lang.String fileTypeId, java.lang.String fromDate,
        java.lang.String toDate, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getListHSNhanTrongThangThangLuyKe(
        java.lang.String departmentId, java.util.List<Long> userIds,
        java.lang.String fileTypeId, java.lang.String fromDate,
        java.lang.String toDate, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getListTonDauKyThangLuyKe(
        java.lang.String departmentId, java.util.List<Long> userIds,
        java.lang.String fileTypeId, java.lang.String fromDate,
        java.lang.String toDate, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoLuongHoSoTonTruoc(
        java.util.List<Long> userIds, java.lang.String toDay,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoLuongHoSoDaNhan(
        java.util.List<Long> userIds, java.lang.String toDay,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoLuongHoSoChuaNhan(
        java.util.List<Long> userIds, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoLuongTongHoSoCanXuLy(
        java.util.List<Long> userIds, java.lang.String toDay,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoLuongHoSoTuGiaiQuyet(
        java.util.List<Long> userIds, java.lang.String toDay,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoLuongHoSoNguoiKhacThuLyThay(
        java.util.List<Long> userIds, java.lang.String toDay,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoLuongHoSoGiaiQuyet(
        java.util.List<Long> userIds, java.lang.String toDay,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoLuongHoSoTonTrongHanISO(
        java.util.List<Long> userIds, java.lang.String toDay,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoLuongHoSoTonQuaHanISO(
        java.util.List<Long> userIds, java.lang.String toDay,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoLuongTongHoSoTonISO(
        java.util.List<Long> userIds, java.lang.String toDay,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;
}
