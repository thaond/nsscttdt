package com.sgs.portlet.onedoor.service;


/**
 * <a href="PmlOneDoorReceiveFileLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.onedoor.service.PmlOneDoorReceiveFileLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.onedoor.service.PmlOneDoorReceiveFileLocalService
 *
 */
public class PmlOneDoorReceiveFileLocalServiceUtil {
    private static PmlOneDoorReceiveFileLocalService _service;

    public static com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile addPmlOneDoorReceiveFile(
        com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile pmlOneDoorReceiveFile)
        throws com.liferay.portal.SystemException {
        return getService().addPmlOneDoorReceiveFile(pmlOneDoorReceiveFile);
    }

    public static com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile createPmlOneDoorReceiveFile(
        java.lang.String fileId) {
        return getService().createPmlOneDoorReceiveFile(fileId);
    }

    public static void deletePmlOneDoorReceiveFile(java.lang.String fileId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlOneDoorReceiveFile(fileId);
    }

    public static void deletePmlOneDoorReceiveFile(
        com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile pmlOneDoorReceiveFile)
        throws com.liferay.portal.SystemException {
        getService().deletePmlOneDoorReceiveFile(pmlOneDoorReceiveFile);
    }

    public static java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    public static java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    public static com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile getPmlOneDoorReceiveFile(
        java.lang.String fileId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlOneDoorReceiveFile(fileId);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getPmlOneDoorReceiveFiles(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlOneDoorReceiveFiles(start, end);
    }

    public static int getPmlOneDoorReceiveFilesCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlOneDoorReceiveFilesCount();
    }

    public static com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile updatePmlOneDoorReceiveFile(
        com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile pmlOneDoorReceiveFile)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlOneDoorReceiveFile(pmlOneDoorReceiveFile);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> search(
        java.lang.String numberreceipt, java.lang.String filename,
        java.lang.String applicantname, java.lang.String permanentaddress,
        java.lang.String telephone, java.lang.String filetypeid,
        java.lang.String tuNgayTiepNhan, java.lang.String denNgayTiepNhan,
        java.lang.String tuNgayHenTra, java.lang.String denNgayHenTra,
        java.lang.String tuNgayHSHoanThanh,
        java.lang.String denNgayHSHoanThanh, java.lang.String tuNgayHSTraThuc,
        java.lang.String denNgayHSTraThuc, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc) {
        return getService()
                   .search(numberreceipt, filename, applicantname,
            permanentaddress, telephone, filetypeid, tuNgayTiepNhan,
            denNgayTiepNhan, tuNgayHenTra, denNgayHenTra, tuNgayHSHoanThanh,
            denNgayHSHoanThanh, tuNgayHSTraThuc, denNgayHSTraThuc, typeList,
            valueTypeList, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.attachedfile.model.AttachedFile> getAttachedByFileType(
        java.lang.String fileTypeId) {
        return getService().getAttachedByFileType(fileTypeId);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile> getFileTypeAttachedFileByFileTypeId(
        java.lang.String fileTypeId) {
        return getService().getFileTypeAttachedFileByFileTypeId(fileTypeId);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> filter(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> list,
        java.lang.String fileTypeName, java.util.Date startDate,
        java.util.Date endDate, java.lang.String applicantName,
        java.lang.String organization, java.lang.String address,
        java.lang.String district, java.lang.String numberReceipt) {
        return getService()
                   .filter(list, fileTypeName, startDate, endDate,
            applicantName, organization, address, district, numberReceipt);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> filterByNumberReceipt(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> list,
        java.lang.String numberReceipt) {
        return getService().filterByNumberReceipt(list, numberReceipt);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> filterByDistrict(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> list,
        java.lang.String district) {
        return getService().filterByDistrict(list, district);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> filterByAddress(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> list,
        java.lang.String address) {
        return getService().filterByAddress(list, address);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> filterByFileTypeName(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> list,
        java.lang.String fileTypeName) {
        return getService().filterByFileTypeName(list, fileTypeName);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> filterByApplicantName(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> list,
        java.lang.String applicantName) {
        return getService().filterByApplicantName(list, applicantName);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> filterByOrganization(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> list,
        java.lang.String organization) {
        return getService().filterByOrganization(list, organization);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> filterByStartDate(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> list,
        java.util.Date startDate) {
        return getService().filterByStartDate(list, startDate);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> filterByEndDate(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> list,
        java.util.Date endDate) {
        return getService().filterByEndDate(list, endDate);
    }

    public static int counterApplicationFile(java.util.Date startDate,
        java.util.Date endDate, java.lang.String fileTypeId) {
        return getService()
                   .counterApplicationFile(startDate, endDate, fileTypeId);
    }

    public static int counterExactReturningFile(java.util.Date startDate,
        java.util.Date endDate, java.lang.String fileTypeId) {
        return getService()
                   .counterExactReturningFile(startDate, endDate, fileTypeId);
    }

    public static int counterExpectedReturningFile(java.util.Date startDate,
        java.util.Date endDate, java.lang.String fileTypeId) {
        return getService()
                   .counterExpectedReturningFile(startDate, endDate, fileTypeId);
    }

    public static java.util.List<com.sgs.portlet.filetype.model.PmlFileType> getListFileTypeByListFile(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> list) {
        return getService().getListFileTypeByListFile(list);
    }

    public static java.util.List<com.sgs.portlet.field.model.PmlField> getListFieldByListFile(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> listFile) {
        return getService().getListFieldByListFile(listFile);
    }

    public static java.util.List<com.sgs.portlet.department.model.Department> getListDepartmentsByListFile(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> listFile) {
        return getService().getListDepartmentsByListFile(listFile);
    }

    public static java.util.List<com.sgs.portlet.agency.model.Agency> getListAgencyByListFile(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> listFile) {
        return getService().getListAgencyByListFile(listFile);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileByField(
        com.sgs.portlet.field.model.PmlField pmlField) {
        return getService().getListFileByField(pmlField);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileByFileType(
        com.sgs.portlet.filetype.model.PmlFileType pmlFileType) {
        return getService().getListFileByFileType(pmlFileType);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFile(
        java.util.Date startDate, java.util.Date endDate,
        com.sgs.portlet.field.model.PmlField pmlField) {
        return getService().getListFile(startDate, endDate, pmlField);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFile(
        java.util.Date startDate, java.util.Date endDate) {
        return getService().getListFile(startDate, endDate);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileByExactReturningDate(
        java.util.Date startDate, java.util.Date endDate,
        com.sgs.portlet.filetype.model.PmlFileType pmlFileType) {
        return getService()
                   .getListFileByExactReturningDate(startDate, endDate,
            pmlFileType);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileByExactReturningFile(
        java.util.Date startDate, java.util.Date endDate) {
        return getService().getListFileByExactReturningFile(startDate, endDate);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileByExpectedReturningDate(
        com.sgs.portlet.filetype.model.PmlFileType pmlFileType,
        java.util.Date startDate, java.util.Date endDate) {
        return getService()
                   .getListFileByExpectedReturningDate(pmlFileType, startDate,
            endDate);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileByApplicationDate(
        com.sgs.portlet.filetype.model.PmlFileType pmlFileType,
        java.util.Date startDate, java.util.Date endDate) {
        return getService()
                   .getListFileByApplicationDate(pmlFileType, startDate, endDate);
    }

    public static java.util.Map<String, java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile>> getListFieldIDAndListFile(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> listFile) {
        return getService().getListFieldIDAndListFile(listFile);
    }

    public static java.util.Map<String, java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile>> getListFieldIDAndListFile(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> listFile,
        java.util.Date startDate, java.util.Date endDate) {
        return getService()
                   .getListFieldIDAndListFile(listFile, startDate, endDate);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileBy_fileTypeId_startDate_endDate(
        java.lang.String fileTypeId, java.util.Date startDate,
        java.util.Date endDate) {
        return getService()
                   .getListFileBy_fileTypeId_startDate_endDate(fileTypeId,
            startDate, endDate);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileBy_DepartmentId(
        java.lang.String departmentId) {
        return getService().getListFileBy_DepartmentId(departmentId);
    }

    public static java.util.List<com.sgs.portlet.filetype.model.PmlFileType> getListFileTypeByDepartmentId(
        java.lang.String departmentId) {
        return getService().getListFileTypeByDepartmentId(departmentId);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileBy_DepartmentId_FileTypeId(
        java.lang.String departmentId, java.lang.String fileTypeId) {
        return getService()
                   .getListFileBy_DepartmentId_FileTypeId(departmentId,
            fileTypeId);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileChuaNhanChuaHoanThanh(
        long userId, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getListFileChuaNhanChuaHoanThanh(userId, typeList,
            valueTypeList, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileDaNhanChuaHoanThanh(
        long userId, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getListFileDaNhanChuaHoanThanh(userId, typeList,
            valueTypeList, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileQuaHanISOChuaHoanThanh(
        long userId, java.lang.String toDate, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getListFileQuaHanISOChuaHoanThanh(userId, toDate, typeList,
            valueTypeList, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileChoBoSungChuaHoanThanh(
        long userId, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getListFileChoBoSungChuaHoanThanh(userId, typeList,
            valueTypeList, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileCanXuLyTrongNgay(
        long userId, java.lang.String toDate, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .getListFileCanXuLyTrongNgay(userId, toDate, typeList,
            valueTypeList, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileNeedProcess(
        long userId, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc) {
        return getService()
                   .getListFileNeedProcess(userId, typeList, valueTypeList,
            start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileDelegated(
        long userId, java.util.List<String> typeList,
        java.util.List<String> valueTypeList,
        com.liferay.portal.kernel.util.OrderByComparator obc) {
        return getService()
                   .getListFileDelegated(userId, typeList, valueTypeList, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileIsDelegated(
        long userId, java.util.List<String> typeList,
        java.util.List<String> valueTypeList,
        com.liferay.portal.kernel.util.OrderByComparator obc) {
        return getService()
                   .getListFileIsDelegated(userId, typeList, valueTypeList, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListTonDauKyThangLuyKe(
        java.lang.String departmentId, java.util.List<Long> userIds,
        java.lang.String fileTypeId, java.lang.String fromDate,
        java.lang.String toDate, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getListTonDauKyThangLuyKe(departmentId, userIds,
            fileTypeId, fromDate, toDate, typeList, valueTypeList, start, end,
            obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListHSNhanTrongThangThangLuyKe(
        java.lang.String departmentId, java.util.List<Long> userIds,
        java.lang.String fileTypeId, java.lang.String fromDate,
        java.lang.String toDate, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getListHSNhanTrongThangThangLuyKe(departmentId, userIds,
            fileTypeId, fromDate, toDate, typeList, valueTypeList, start, end,
            obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListTongHSNhanThangLuyKe(
        java.lang.String departmentId, java.util.List<Long> userIds,
        java.lang.String fileTypeId, java.lang.String fromDate,
        java.lang.String toDate, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getListTongHSNhanThangLuyKe(departmentId, userIds,
            fileTypeId, fromDate, toDate, typeList, valueTypeList, start, end,
            obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListHSNhanTrongNamThangLuyKe(
        java.lang.String departmentId, java.util.List<Long> userIds,
        java.lang.String fileTypeId, java.lang.String fromDate,
        java.lang.String toDate, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getListHSNhanTrongNamThangLuyKe(departmentId, userIds,
            fileTypeId, fromDate, toDate, typeList, valueTypeList, start, end,
            obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListHSGiaiQuyetTrongThangLuyKe(
        java.lang.String departmentId, java.util.List<Long> userIds,
        java.lang.String fileTypeId, java.lang.String fromDate,
        java.lang.String toDate, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getListHSGiaiQuyetTrongThangLuyKe(departmentId, userIds,
            fileTypeId, fromDate, toDate, typeList, valueTypeList, start, end,
            obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListHSGiaiQuyetTrongNamLuyKe(
        java.lang.String departmentId, java.util.List<Long> userIds,
        java.lang.String fileTypeId, java.lang.String fromDate,
        java.lang.String toDate, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getListHSGiaiQuyetTrongNamLuyKe(departmentId, userIds,
            fileTypeId, fromDate, toDate, typeList, valueTypeList, start, end,
            obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListHSTonDenNgayBCThangLuyKe(
        java.lang.String departmentId, java.util.List<Long> userIds,
        java.lang.String fileTypeId, java.lang.String toDate,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getListHSTonDenNgayBCThangLuyKe(departmentId, userIds,
            fileTypeId, toDate, typeList, valueTypeList, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoLuongHoSoTonTruoc(
        java.util.List<Long> userIds, java.lang.String toDay,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getSoLuongHoSoTonTruoc(userIds, toDay, typeList,
            valueTypeList, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoLuongHoSoDaNhan(
        java.util.List<Long> userIds, java.lang.String toDay,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getSoLuongHoSoDaNhan(userIds, toDay, typeList,
            valueTypeList, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoLuongHoSoChuaNhan(
        java.util.List<Long> userIds, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getSoLuongHoSoChuaNhan(userIds, typeList, valueTypeList,
            start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoLuongHoSoTuGiaiQuyet(
        java.util.List<Long> userIds, java.lang.String toDay,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getSoLuongHoSoTuGiaiQuyet(userIds, toDay, typeList,
            valueTypeList, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoLuongHoSoNguoiKhacThuLyThay(
        java.util.List<Long> userIds, java.lang.String toDay,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getSoLuongHoSoNguoiKhacThuLyThay(userIds, toDay, typeList,
            valueTypeList, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoLuongHoSoTonTrongHanISO(
        java.util.List<Long> userIds, java.lang.String toDay,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getSoLuongHoSoTonTrongHanISO(userIds, toDay, typeList,
            valueTypeList, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoLuongHoSoTonQuaHanISO(
        java.util.List<Long> userIds, java.lang.String toDay,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getSoLuongHoSoTonQuaHanISO(userIds, toDay, typeList,
            valueTypeList, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoLuongHoSoGiaiQuyet(
        java.util.List<Long> userIds, java.lang.String toDay,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getSoLuongHoSoGiaiQuyet(userIds, toDay, typeList,
            valueTypeList, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoLuongTongHoSoTonISO(
        java.util.List<Long> userIds, java.lang.String toDay,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getSoLuongTongHoSoTonISO(userIds, toDay, typeList,
            valueTypeList, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoLuongTongHoSoCanXuLy(
        java.util.List<Long> userIds, java.lang.String toDay,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getSoLuongTongHoSoCanXuLy(userIds, toDay, typeList,
            valueTypeList, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoLuongHSTonBCThang(
        java.util.List<com.sgs.portlet.filetype.model.PmlFileType> fileTypeList,
        java.lang.String fromDate, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getSoLuongHSTonBCThang(fileTypeList, fromDate, typeList,
            valueTypeList, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoLuongHSNhanTrongThang(
        java.util.List<com.sgs.portlet.filetype.model.PmlFileType> fileTypeList,
        java.lang.String fromDate, java.lang.String toDate,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getSoLuongHSNhanTrongThang(fileTypeList, fromDate, toDate,
            typeList, valueTypeList, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoLuongTongHS(
        java.util.List<com.sgs.portlet.filetype.model.PmlFileType> fileTypeList,
        java.lang.String fromDate, java.lang.String toDate,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getSoLuongTongHS(fileTypeList, fromDate, toDate, typeList,
            valueTypeList, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoHSHoanThanhDungHan(
        java.util.List<com.sgs.portlet.filetype.model.PmlFileType> fileTypeList,
        java.lang.String fromDate, java.lang.String toDate,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getSoHSHoanThanhDungHan(fileTypeList, fromDate, toDate,
            typeList, valueTypeList, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoHSHoanThanhTreHan(
        java.util.List<com.sgs.portlet.filetype.model.PmlFileType> fileTypeList,
        java.lang.String fromDate, java.lang.String toDate,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getSoHSHoanThanhTreHan(fileTypeList, fromDate, toDate,
            typeList, valueTypeList, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoHSDangThuLyDungHan(
        java.util.List<com.sgs.portlet.filetype.model.PmlFileType> fileTypeList,
        java.lang.String fromDate, java.lang.String toDate,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getSoHSDangThuLyDungHan(fileTypeList, fromDate, toDate,
            typeList, valueTypeList, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoHSDangThuLyTreHan(
        java.util.List<com.sgs.portlet.filetype.model.PmlFileType> fileTypeList,
        java.lang.String fromDate, java.lang.String toDate,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getSoHSDangThuLyTreHan(fileTypeList, fromDate, toDate,
            typeList, valueTypeList, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoHSChoBoSung(
        java.util.List<com.sgs.portlet.filetype.model.PmlFileType> fileTypeList,
        java.lang.String fromDate, java.lang.String toDate,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getSoHSChoBoSung(fileTypeList, fromDate, toDate, typeList,
            valueTypeList, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByTEN_MA_NAM_HS(
        long userId, int year, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .findByTEN_MA_NAM_HS(userId, year, typeList, valueTypeList,
            start, end, obc);
    }

    public static int getGeneralNumberReceipt(
        java.lang.String ddmmyyyyReceiveDate)
        throws com.liferay.portal.SystemException {
        return getService().getGeneralNumberReceipt(ddmmyyyyReceiveDate);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> findByPMLFILERETURN(
        java.util.List<String> fileTypeIds, int year,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .findByPMLFILERETURN(fileTypeIds, year, typeList,
            valueTypeList, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> onedoorSearch(
        java.lang.String numberreceipt, java.lang.String filename,
        java.lang.String applicantname, java.lang.String permanentaddress,
        java.lang.String telephone, java.lang.String filetypeid,
        java.lang.String tuNgayTiepNhan, java.lang.String denNgayTiepNhan,
        java.lang.String tuNgayHenTra, java.lang.String denNgayHenTra,
        java.lang.String tuNgayHSHoanThanh,
        java.lang.String denNgayHSHoanThanh, java.lang.String tuNgayHSTraThuc,
        java.lang.String denNgayHSTraThuc, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .onedoorSearch(numberreceipt, filename, applicantname,
            permanentaddress, telephone, filetypeid, tuNgayTiepNhan,
            denNgayTiepNhan, tuNgayHenTra, denNgayHenTra, tuNgayHSHoanThanh,
            denNgayHSHoanThanh, tuNgayHSTraThuc, denNgayHSTraThuc, start, end,
            obc);
    }

    public static int onedoorSearchCount(java.lang.String numberreceipt,
        java.lang.String filename, java.lang.String applicantname,
        java.lang.String permanentaddress, java.lang.String telephone,
        java.lang.String filetypeid, java.lang.String tuNgayTiepNhan,
        java.lang.String denNgayTiepNhan, java.lang.String tuNgayHenTra,
        java.lang.String denNgayHenTra, java.lang.String tuNgayHSHoanThanh,
        java.lang.String denNgayHSHoanThanh, java.lang.String tuNgayHSTraThuc,
        java.lang.String denNgayHSTraThuc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .onedoorSearchCount(numberreceipt, filename, applicantname,
            permanentaddress, telephone, filetypeid, tuNgayTiepNhan,
            denNgayTiepNhan, tuNgayHenTra, denNgayHenTra, tuNgayHSHoanThanh,
            denNgayHSHoanThanh, tuNgayHSTraThuc, denNgayHSTraThuc);
    }

    public static int countSoLuongHoSoTonTruoc(java.util.List<Long> userIds,
        java.lang.String fromDate, java.lang.String toDate)
        throws com.liferay.portal.SystemException {
        return getService().countSoLuongHoSoTonTruoc(userIds, fromDate, toDate);
    }

    public static int countSoLuongHoSoNhanTrongThang(
        java.util.List<Long> userIds, java.lang.String fromDate,
        java.lang.String toDate) throws com.liferay.portal.SystemException {
        return getService()
                   .countSoLuongHoSoNhanTrongThang(userIds, fromDate, toDate);
    }

    public static int countSoLuongHoSoDaXuLy(java.util.List<Long> userIds,
        java.lang.String fromDate, java.lang.String toDate)
        throws com.liferay.portal.SystemException {
        return getService().countSoLuongHoSoDaXuLy(userIds, fromDate, toDate);
    }

    public static int countSoLuongHoSoConTon(java.util.List<Long> userIds,
        java.lang.String fromDate, java.lang.String toDate)
        throws com.liferay.portal.SystemException {
        return getService().countSoLuongHoSoConTon(userIds, fromDate, toDate);
    }

    public static PmlOneDoorReceiveFileLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "PmlOneDoorReceiveFileLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlOneDoorReceiveFileLocalService service) {
        _service = service;
    }
}
