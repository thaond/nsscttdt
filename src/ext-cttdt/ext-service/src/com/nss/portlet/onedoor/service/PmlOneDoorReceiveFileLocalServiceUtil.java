package com.nss.portlet.onedoor.service;


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
 * <code>com.nss.portlet.onedoor.service.PmlOneDoorReceiveFileLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.onedoor.service.PmlOneDoorReceiveFileLocalService
 *
 */
public class PmlOneDoorReceiveFileLocalServiceUtil {
    private static PmlOneDoorReceiveFileLocalService _service;

    public static com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile addPmlOneDoorReceiveFile(
        com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile pmlOneDoorReceiveFile)
        throws com.liferay.portal.SystemException {
        return getService().addPmlOneDoorReceiveFile(pmlOneDoorReceiveFile);
    }

    public static com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile createPmlOneDoorReceiveFile(
        java.lang.String fileId) {
        return getService().createPmlOneDoorReceiveFile(fileId);
    }

    public static void deletePmlOneDoorReceiveFile(java.lang.String fileId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlOneDoorReceiveFile(fileId);
    }

    public static void deletePmlOneDoorReceiveFile(
        com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile pmlOneDoorReceiveFile)
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

    public static com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile getPmlOneDoorReceiveFile(
        java.lang.String fileId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlOneDoorReceiveFile(fileId);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getPmlOneDoorReceiveFiles(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlOneDoorReceiveFiles(start, end);
    }

    public static int getPmlOneDoorReceiveFilesCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlOneDoorReceiveFilesCount();
    }

    public static com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile updatePmlOneDoorReceiveFile(
        com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile pmlOneDoorReceiveFile)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlOneDoorReceiveFile(pmlOneDoorReceiveFile);
    }

    public static com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile updatePmlOneDoorReceiveFile(
        com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile pmlOneDoorReceiveFile,
        boolean merge) throws com.liferay.portal.SystemException {
        return getService()
                   .updatePmlOneDoorReceiveFile(pmlOneDoorReceiveFile, merge);
    }

    public static int getGeneralNumberReceipt(
        java.lang.String ddmmyyyyReceiveDate)
        throws com.liferay.portal.SystemException {
        return getService().getGeneralNumberReceipt(ddmmyyyyReceiveDate);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileChuaNhanChuaHoanThanh(
        long userId, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getListFileChuaNhanChuaHoanThanh(userId, typeList,
            valueTypeList, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileCanXuLyTrongNgay(
        long userId, java.lang.String toDate, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .getListFileCanXuLyTrongNgay(userId, toDate, typeList,
            valueTypeList, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileQuaHanISOChuaHoanThanh(
        long userId, java.lang.String toDate, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getListFileQuaHanISOChuaHoanThanh(userId, toDate, typeList,
            valueTypeList, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileChoBoSungChuaHoanThanh(
        long userId, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getListFileChoBoSungChuaHoanThanh(userId, typeList,
            valueTypeList, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileNeedProcess(
        long userId, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc) {
        return getService()
                   .getListFileNeedProcess(userId, typeList, valueTypeList,
            start, end, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileDelegated(
        long userId, java.util.List<String> typeList,
        java.util.List<String> valueTypeList,
        com.liferay.portal.kernel.util.OrderByComparator obc) {
        return getService()
                   .getListFileDelegated(userId, typeList, valueTypeList, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileIsDelegated(
        long userId, java.util.List<String> typeList,
        java.util.List<String> valueTypeList,
        com.liferay.portal.kernel.util.OrderByComparator obc) {
        return getService()
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
        com.liferay.portal.kernel.util.OrderByComparator obc) {
        return getService()
                   .search(numberreceipt, filename, applicantname,
            permanentaddress, telephone, filetypeid, tuNgayTiepNhan,
            denNgayTiepNhan, tuNgayHenTra, denNgayHenTra, tuNgayHSHoanThanh,
            denNgayHSHoanThanh, tuNgayHSTraThuc, denNgayHSTraThuc, typeList,
            valueTypeList, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> findByFileTypeId(
        java.lang.String fileTypeId) {
        return getService().findByFileTypeId(fileTypeId);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> findByPMLFILERETURN(
        java.util.List<String> fileTypeIds, int year,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .findByPMLFILERETURN(fileTypeIds, year, typeList,
            valueTypeList, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> findByTEN_MA_NAM_HS(
        long userId, int year, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .findByTEN_MA_NAM_HS(userId, year, typeList, valueTypeList,
            start, end, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoLuongHSTonBCThang(
        java.util.List<com.nss.portlet.filetype.model.PmlFileType> fileTypeList,
        java.lang.String fromDate, java.util.List<String> typeList,
        java.util.List<String> valueTypeList, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getSoLuongHSTonBCThang(fileTypeList, fromDate, typeList,
            valueTypeList, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoLuongHSNhanTrongThang(
        java.util.List<com.nss.portlet.filetype.model.PmlFileType> fileTypeList,
        java.lang.String fromDate, java.lang.String toDate,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getSoLuongHSNhanTrongThang(fileTypeList, fromDate, toDate,
            typeList, valueTypeList, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoLuongTongHS(
        java.util.List<com.nss.portlet.filetype.model.PmlFileType> fileTypeList,
        java.lang.String fromDate, java.lang.String toDate,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getSoLuongTongHS(fileTypeList, fromDate, toDate, typeList,
            valueTypeList, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoHSHoanThanhDungHan(
        java.util.List<com.nss.portlet.filetype.model.PmlFileType> fileTypeList,
        java.lang.String fromDate, java.lang.String toDate,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getSoHSHoanThanhDungHan(fileTypeList, fromDate, toDate,
            typeList, valueTypeList, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoHSHoanThanhTreHan(
        java.util.List<com.nss.portlet.filetype.model.PmlFileType> fileTypeList,
        java.lang.String fromDate, java.lang.String toDate,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getSoHSHoanThanhTreHan(fileTypeList, fromDate, toDate,
            typeList, valueTypeList, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoHSDangThuLyDungHan(
        java.util.List<com.nss.portlet.filetype.model.PmlFileType> fileTypeList,
        java.lang.String fromDate, java.lang.String toDate,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getSoHSDangThuLyDungHan(fileTypeList, fromDate, toDate,
            typeList, valueTypeList, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoHSDangThuLyTreHan(
        java.util.List<com.nss.portlet.filetype.model.PmlFileType> fileTypeList,
        java.lang.String fromDate, java.lang.String toDate,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getSoHSDangThuLyTreHan(fileTypeList, fromDate, toDate,
            typeList, valueTypeList, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile> getSoHSChoBoSung(
        java.util.List<com.nss.portlet.filetype.model.PmlFileType> fileTypeList,
        java.lang.String fromDate, java.lang.String toDate,
        java.util.List<String> typeList, java.util.List<String> valueTypeList,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getSoHSChoBoSung(fileTypeList, fromDate, toDate, typeList,
            valueTypeList, start, end, obc);
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
