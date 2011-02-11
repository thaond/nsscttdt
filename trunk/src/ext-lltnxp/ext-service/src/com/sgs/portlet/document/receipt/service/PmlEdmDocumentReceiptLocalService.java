package com.sgs.portlet.document.receipt.service;


/**
 * <a href="PmlEdmDocumentReceiptLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.document.receipt.service.impl.PmlEdmDocumentReceiptLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalServiceUtil
 *
 */
public interface PmlEdmDocumentReceiptLocalService {
    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt addPmlEdmDocumentReceipt(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt pmlEdmDocumentReceipt)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt createPmlEdmDocumentReceipt(
        long documentReceiptId);

    public void deletePmlEdmDocumentReceipt(long documentReceiptId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlEdmDocumentReceipt(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt pmlEdmDocumentReceipt)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt getPmlEdmDocumentReceipt(
        long documentReceiptId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> getPmlEdmDocumentReceipts(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlEdmDocumentReceiptsCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt updatePmlEdmDocumentReceipt(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt pmlEdmDocumentReceipt)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portal.model.User> getSortedListUser()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> getListIssuingPlace(
        java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listDocumentReceipt);

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> filter(
        java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> list,
        java.lang.String briefContent, java.lang.String signer,
        java.util.Date dateArrive, java.lang.String documentReference,
        java.lang.String issuingPlace, java.lang.String status);

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> filterByStatus(
        java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> list,
        java.lang.String status);

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> filterByIssuingPlace(
        java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> list,
        java.lang.String issuingPlace);

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> filterByDocumentReference(
        java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> list,
        java.lang.String documentReference);

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> filterByDateArrive(
        java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> list,
        java.util.Date dateArrive);

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> filterBySigner(
        java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> list,
        java.lang.String signer);

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> filterByBriefContent(
        java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> list,
        java.lang.String briefContent);

    public int countByDocumentReceipt_Users_Status_DangXuLy_TreHan(
        java.util.List<Long> userIds, long statusId, java.lang.String soCVDen,
        java.lang.String capGui) throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByDocumentReceipt_Users_Status_DangXuLy_TreHan(
        java.util.List<Long> userIds, long statusId, java.lang.String soCVDen,
        java.lang.String capGui, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countByS_L_N_S_N_T_D_D_S_T(java.lang.String soCVDen,
        java.lang.String soVaoSo, java.lang.String tuNgay,
        java.lang.String denNgay, long soHSCV, long loaiCV,
        java.lang.String noiPhatHanh, long trangThai, java.lang.String nguoiKy,
        java.lang.String trichYeu) throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByS_L_N_S_N_T_D_D_S_T(
        java.lang.String soCVDen, java.lang.String soVaoSo,
        java.lang.String tuNgay, java.lang.String denNgay, long soHSCV,
        long loaiCV, java.lang.String noiPhatHanh, long trangThai,
        java.lang.String nguoiKy, java.lang.String trichYeu, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countTonDauKyChuyenVien_CVDen(long userId,
        int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listTonDauKyChuyenVien_CVDen(
        long userId, int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countNhanTrongKyChuyenVien_CVDen(long userId,
        int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listNhanTrongKyChuyenVien_CVDen(
        long userId, int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countChuaNhanChuyenVien_CVDen(long userId,
        int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listChuaNhanChuyenVien_CVDen(
        long userId, int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countNhanTrongThangChuyenVien_CVDen(long userId,
        int documentRecordTypeId, int capGui, int loaiVB,
        java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listNhanTrongThangChuyenVien_CVDen(
        long userId, int documentRecordTypeId, int capGui, int loaiVB,
        java.util.Date fromDate, java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countDungHanDaXuLyChuyenVien_CVDen(long userId,
        int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listDungHanDaXuLyChuyenVien_CVDen(
        long userId, int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countTreHanDaXuLyChuyenVien_CVDen(long userId,
        int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listTreHanDaXuLyChuyenVien_CVDen(
        long userId, int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countTongDaXuLyChuyenVien_CVDen(long userId,
        int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listTongDaXuLyChuyenVien_CVDen(
        long userId, int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countDungHanDangXuLyChuyenVien_CVDen(long userId,
        int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listDungHanDangXuLyChuyenVien_CVDen(
        long userId, int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countTreHanDangXuLyChuyenVien_CVDen(long userId,
        int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listTreHanDangXuLyChuyenVien_CVDen(
        long userId, int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countTongDangXuLyChuyenVien_CVDen(long userId,
        int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listTongDangXuLyChuyenVien_CVDen(
        long userId, int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countTonDauKyPhongBan_CVDen(java.lang.String departmentId,
        int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listTonDauKyPhongBan_CVDen(
        java.lang.String departmentId, int documentRecordTypeId, int capGui,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countNhanTrongKyPhongBan_CVDen(java.lang.String departmentId,
        int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listNhanTrongKyPhongBan_CVDen(
        java.lang.String departmentId, int documentRecordTypeId, int capGui,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countChuaNhanTrongKyPhongBan_CVDen(
        java.lang.String departmentId, int documentRecordTypeId, int capGui,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate) throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listChuaNhanTrongKyPhongBan_CVDen(
        java.lang.String departmentId, int documentRecordTypeId, int capGui,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countDungHanDaXuLyPhongBan_CVDen(java.lang.String departmentId,
        int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listDungHanDaXuLyPhongBan_CVDen(
        java.lang.String departmentId, int documentRecordTypeId, int capGui,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countTreHanDaXuLyPhongBan_CVDen(java.lang.String departmentId,
        int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listTreHanDaXuLyPhongBan_CVDen(
        java.lang.String departmentId, int documentRecordTypeId, int capGui,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countTongDaXuLyPhongBan_CVDen(java.lang.String departmentId,
        int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listTongDaXuLyPhongBan_CVDen(
        java.lang.String departmentId, int documentRecordTypeId, int capGui,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countDungHanDangXuLyPhongBan_CVDen(
        java.lang.String departmentId, int documentRecordTypeId, int capGui,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate) throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listDungHanDangXuLyPhongBan_CVDen(
        java.lang.String departmentId, int documentRecordTypeId, int capGui,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countTreHanDangXuLyPhongBan_CVDen(
        java.lang.String departmentId, int documentRecordTypeId, int capGui,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate) throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listTreHanDangXuLyPhongBan_CVDen(
        java.lang.String departmentId, int documentRecordTypeId, int capGui,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countTongDangXuLyPhongBan_CVDen(java.lang.String departmentId,
        int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listTongDangXuLyPhongBan_CVDen(
        java.lang.String departmentId, int documentRecordTypeId, int capGui,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countTonDauKySo_CVDen(int documentRecordTypeId, int capGui,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate) throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listTonDauKySo_CVDen(
        int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countNhanTrongKySo_CVDen(int documentRecordTypeId, int capGui,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate) throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listNhanTrongKySo_CVDen(
        int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countDungHanDaXuLySo_CVDen(int documentRecordTypeId, int capGui,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate) throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listDungHanDaXuLySo_CVDen(
        int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countTreHanDaXuLySo_CVDen(int documentRecordTypeId, int capGui,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate) throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listTreHanDaXuLySo_CVDen(
        int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countTongDaXuLySo_CVDen(int documentRecordTypeId, int capGui,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate) throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listTongDaXuLySo_CVDen(
        int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countDungHanDangXuLySo_CVDen(int documentRecordTypeId,
        int capGui, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listDungHanDangXuLySo_CVDen(
        int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countTreHanDangXuLySo_CVDen(int documentRecordTypeId,
        int capGui, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listTreHanDangXuLySo_CVDen(
        int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countTongDangXuLySo_CVDen(int documentRecordTypeId, int capGui,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate) throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listTongDangXuLySo_CVDen(
        int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int totalDateOff(java.lang.String dateNow, java.lang.String dateCalen)
        throws com.liferay.portal.SystemException;

    public java.lang.String addDateNum(java.lang.String dateInput, int numDate)
        throws com.liferay.portal.SystemException;

    public int getGeneralNumberDocumentReceipt(
        java.lang.String ddmmyyyyReceiveDate)
        throws com.liferay.portal.SystemException;

    public int countDocRecNeedProcess(long userId)
        throws com.liferay.portal.SystemException;

    public int countByDocumentReceipt_Users_Status_DangXuLy(
        java.util.List<Long> userIds, long statusId, java.lang.String soCVDen,
        java.lang.String capGui) throws java.lang.Exception;

    public int countByDocumentReceipt_Users_Status_DangXuLy(
        java.util.List<Long> userIds, long statusId, java.lang.String soCVDen,
        java.lang.String capGui, java.lang.String cachThucXuLy)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByDocumentReceipt_Users_Status_DangXuLy(
        java.util.List<Long> userIds, long statusId, java.lang.String soCVDen,
        java.lang.String capGui, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByDocumentReceipt_Users_Status_DangXuLy(
        java.util.List<Long> userIds, long statusId, java.lang.String soCVDen,
        java.lang.String capGui, java.lang.String cachThucXuLy, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countByDocumentReceipt_Users(java.util.List<Long> userIds,
        java.lang.String capGui, java.lang.String loaisocongvan)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByDocumentReceipt_Users(
        java.util.List<Long> userIds, java.lang.String capGui,
        java.lang.String loaisocongvan, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countByDocumentReceipt_Users_Status_DaXuLy(
        java.util.List<Long> userIds, long statusId, int year,
        java.lang.String soCVDen, java.lang.String capGui)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByDocumentReceipt_Users_Status_DaXuLy(
        java.util.List<Long> userIds, long statusId, int year,
        java.lang.String soCVDen, java.lang.String capGui, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countByDocumentReceipt_Users_Status_DaXuLy_TreHan(
        java.util.List<Long> userIds, long statusId, int year,
        java.lang.String soCVDen, java.lang.String capGui)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByDocumentReceipt_Users_Status_DaXuLy_TreHan(
        java.util.List<Long> userIds, long statusId, int year,
        java.lang.String soCVDen, java.lang.String capGui, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public long getMaxDocumentReceiptId()
        throws com.liferay.portal.SystemException;

    public void reIndex(long companyId,
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt documentReceipt)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt addPmlEdmDocumentReceipt(
        long companyId,
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt pmlEdmDocumentReceipt)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt updatePmlEdmDocumentReceipt(
        long companyId,
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt pmlEdmDocumentReceipt)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException;

    public void deletePmlEdmDocumentReceipt(long companyId,
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt pmlEdmDocumentReceipt)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException;

    public void deletePmlEdmDocumentReceipt(long companyId,
        long documentReceiptId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt addPmlEdmDocumentReceipt(
        long companyId, java.lang.String documentReference,
        java.lang.String numberLocalDocumentReceipt,
        java.lang.String issuingPlaceId, java.util.Date issuingDate,
        java.lang.String signer, java.util.Date dateArrive, int processTime,
        boolean isPublic, int levelSendId, long documentTypeId,
        java.lang.String confidentialLevelId,
        java.lang.String privilegeLevelId, java.lang.String briefContent)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt updatePmlEdmDocumentReceipt(
        long companyId, long documentReceiptId,
        java.lang.String documentReference,
        java.lang.String numberLocalDocumentReceipt,
        java.lang.String issuingPlaceId, java.util.Date issuingDate,
        java.lang.String signer, java.util.Date dateArrive, int processTime,
        boolean isPublic, int levelSendId, long documentTypeId,
        java.lang.String confidentialLevelId,
        java.lang.String privilegeLevelId, java.lang.String briefContent)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException;

    public void reIndex(java.lang.String[] ids)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException;

    public com.liferay.portal.kernel.search.Hits search(long companyId,
        java.lang.String soCVDen, java.lang.String soVaoSo,
        java.util.Date tuNgay, java.util.Date denNgay, long soHSCV,
        long loaiCV, java.lang.String noiPhatHanh, long trangThai,
        java.lang.String nguoiKy, java.lang.String trichYeu,
        java.lang.String active, int start, int end)
        throws com.liferay.portal.SystemException;

    public com.liferay.portal.kernel.search.Hits search(long companyId,
        java.lang.String soCVDen, java.lang.String soVaoSo,
        java.util.Date tuNgay, java.util.Date denNgay, long soHSCV,
        long loaiCV, java.lang.String noiPhatHanh, long trangThai,
        java.lang.String nguoiKy, java.lang.String trichYeu,
        java.lang.String active, java.lang.String sortField, int sortType,
        int start, int end) throws com.liferay.portal.SystemException;

    public com.liferay.portal.kernel.search.Hits search(long companyId,
        java.lang.String soCVDen, java.lang.String soVaoSo,
        java.util.Date tuNgay, java.util.Date denNgay, long soHSCV,
        long loaiCV, java.lang.String noiPhatHanh, long trangThai,
        java.lang.String nguoiKy, java.lang.String trichYeu,
        java.lang.String active, java.lang.String sortField, int sortType,
        boolean reverse, int start, int end)
        throws com.liferay.portal.SystemException;

    public int countByDocrefIssyearArrYear(java.lang.String docRef,
        int issuingYear, boolean findIssuingYear, int arriveYear,
        boolean findArriveYear) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> getListCVDenDaXuLyChung(
        long userId, java.lang.String year, java.lang.String capGui,
        java.lang.String loaisocongvan, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int countListCVDenDaXuLyChung(long userId, java.lang.String year,
        java.lang.String capGui, java.lang.String loaisocongvan)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> getListCVDenDaXuLyTuXuLy(
        long userId, java.lang.String year, java.lang.String capGui,
        java.lang.String loaisocongvan, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int countListCVDenDaXuLyTuXuLy(long userId, java.lang.String year,
        java.lang.String capGui, java.lang.String loaisocongvan)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> getListCVDenDaXuLyChung_treHan(
        long userId, java.lang.String year, java.lang.String capGui,
        java.lang.String loaisocongvan, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int countListCVDenDaXuLyChung_treHan(long userId,
        java.lang.String year, java.lang.String capGui,
        java.lang.String loaisocongvan)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> getListCVDenDaXuLyTuXuLy_treHan(
        long userId, java.lang.String year, java.lang.String capGui,
        java.lang.String loaisocongvan, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int countListCVDenDaXuLyTuXuLy_treHan(long userId,
        java.lang.String year, java.lang.String capGui,
        java.lang.String loaisocongvan)
        throws com.liferay.portal.SystemException;

    public int countByN_D_I_L_I_P_D_D_D_B(java.lang.String soNoiBo,
        java.lang.String soHieuGoc, int ngayPHDay, int ngayPHMonth,
        int ngayPHYear, long capGui, java.lang.String noiPhatHanh,
        java.lang.String uuTien, int ngayDenDay, int ngayDenMonth,
        int ngayDenYear, long loaiVB, java.lang.String phongBan,
        java.lang.String trichYeu) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByN_D_I_L_I_P_D_D_D_B(
        java.lang.String soNoiBo, java.lang.String soHieuGoc, int ngayPHDay,
        int ngayPHMonth, int ngayPHYear, long capGui,
        java.lang.String noiPhatHanh, java.lang.String uuTien, int ngayDenDay,
        int ngayDenMonth, int ngayDenYear, long loaiVB,
        java.lang.String phongBan, java.lang.String trichYeu, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> getListCVDenDaXuLyChung(
        long userId, java.lang.String soVBDen, java.lang.String soHieuGoc,
        int loaiSoVanBan, java.lang.String issuingplaceId,
        java.lang.String noiBanHanh, java.lang.String trichYeu,
        java.lang.String tuNgay, java.lang.String denNgay,
        java.lang.String ngayHetHan, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int countListCVDenDaXuLyChung(long userId, java.lang.String soVBDen,
        java.lang.String soHieuGoc, int loaiSoVanBan,
        java.lang.String issuingplaceId, java.lang.String noiBanHanh,
        java.lang.String trichYeu, java.lang.String tuNgay,
        java.lang.String denNgay, java.lang.String ngayHetHan)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> getListCVDenDaXuLyTuXuLy(
        long userId, java.lang.String soVBDen, java.lang.String soHieuGoc,
        int loaiSoVanBan, java.lang.String issuingplaceId,
        java.lang.String noiBanHanh, java.lang.String trichYeu,
        java.lang.String tuNgay, java.lang.String denNgay,
        java.lang.String ngayHetHan, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int countListCVDenDaXuLyTuXuLy(long userId,
        java.lang.String soVBDen, java.lang.String soHieuGoc, int loaiSoVanBan,
        java.lang.String issuingplaceId, java.lang.String noiBanHanh,
        java.lang.String trichYeu, java.lang.String tuNgay,
        java.lang.String denNgay, java.lang.String ngayHetHan)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> getListCVDenDaXuLyChung_treHan(
        long userId, java.lang.String soVBDen, java.lang.String soHieuGoc,
        int loaiSoVanBan, java.lang.String issuingplaceId,
        java.lang.String noiBanHanh, java.lang.String trichYeu,
        java.lang.String tuNgay, java.lang.String denNgay,
        java.lang.String ngayHetHan, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int countListCVDenDaXuLyChung_treHan(long userId,
        java.lang.String soVBDen, java.lang.String soHieuGoc, int loaiSoVanBan,
        java.lang.String issuingplaceId, java.lang.String noiBanHanh,
        java.lang.String trichYeu, java.lang.String tuNgay,
        java.lang.String denNgay, java.lang.String ngayHetHan)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> getListCVDenDaXuLyTuXuLy_treHan(
        long userId, java.lang.String soVBDen, java.lang.String soHieuGoc,
        int loaiSoVanBan, java.lang.String issuingplaceId,
        java.lang.String noiBanHanh, java.lang.String trichYeu,
        java.lang.String tuNgay, java.lang.String denNgay,
        java.lang.String ngayHetHan, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int countListCVDenDaXuLyTuXuLy_treHan(long userId,
        java.lang.String soVBDen, java.lang.String soHieuGoc, int loaiSoVanBan,
        java.lang.String issuingplaceId, java.lang.String noiBanHanh,
        java.lang.String trichYeu, java.lang.String tuNgay,
        java.lang.String denNgay, java.lang.String ngayHetHan)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByDocumentReceipt_Users_Status_DangXuLy(
        java.util.List<Long> userIds, long statusId, java.lang.String soVBDen,
        java.lang.String soHieuGoc, int loaiSoVanBan,
        java.lang.String issuingplaceId, java.lang.String noiBanHanh,
        java.lang.String trichYeu, java.lang.String tuNgay,
        java.lang.String denNgay, java.lang.String ngayHetHan, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countByDocumentReceipt_Users_Status_DangXuLy(
        java.util.List<Long> userIds, long statusId, java.lang.String soVBDen,
        java.lang.String soHieuGoc, int loaiSoVanBan,
        java.lang.String issuingplaceId, java.lang.String noiBanHanh,
        java.lang.String trichYeu, java.lang.String tuNgay,
        java.lang.String denNgay, java.lang.String ngayHetHan)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByDocumentReceipt_Users_Status_DangXuLy_TreHan(
        java.util.List<Long> userIds, long statusId, java.lang.String soVBDen,
        java.lang.String soHieuGoc, int loaiSoVanBan,
        java.lang.String issuingplaceId, java.lang.String noiBanHanh,
        java.lang.String trichYeu, java.lang.String tuNgay,
        java.lang.String denNgay, java.lang.String ngayHetHan, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countByDocumentReceipt_Users_Status_DangXuLy_TreHan(
        java.util.List<Long> userIds, long statusId, java.lang.String soVBDen,
        java.lang.String soHieuGoc, int loaiSoVanBan,
        java.lang.String issuingplaceId, java.lang.String noiBanHanh,
        java.lang.String trichYeu, java.lang.String tuNgay,
        java.lang.String denNgay, java.lang.String ngayHetHan)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByDocumentReceipt_Users(
        java.util.List<Long> userIds, java.lang.String soVBDen,
        java.lang.String soHieuGoc, int loaiSoVanBan,
        java.lang.String issuingplaceId, java.lang.String noiBanHanh,
        java.lang.String trichYeu, java.lang.String tuNgay,
        java.lang.String denNgay, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countByDocumentReceipt_Users(java.util.List<Long> userIds,
        java.lang.String soVBDen, java.lang.String soHieuGoc, int loaiSoVanBan,
        java.lang.String issuingplaceId, java.lang.String noiBanHanh,
        java.lang.String trichYeu, java.lang.String tuNgay,
        java.lang.String denNgay) throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptLog_Users_Status_DangXuLy(
        java.util.List<Long> userIds, long statusId, java.lang.String soVBDen,
        java.lang.String soHieuGoc, int loaiSoVanBan,
        java.lang.String issuingplaceId, java.lang.String noiBanHanh,
        java.lang.String trichYeu, java.lang.String tuNgay,
        java.lang.String denNgay, java.lang.String ngayHetHan, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptLog_Users_Status_DangXuLy_TreHan(
        java.util.List<Long> userIds, long statusId, java.lang.String soVBDen,
        java.lang.String soHieuGoc, int loaiSoVanBan,
        java.lang.String issuingplaceId, java.lang.String noiBanHanh,
        java.lang.String trichYeu, java.lang.String tuNgay,
        java.lang.String denNgay, java.lang.String ngayHetHan, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptLog_Users(
        java.util.List<Long> userIds, java.lang.String soVBDen,
        java.lang.String soHieuGoc, int loaiSoVanBan,
        java.lang.String issuingplaceId, java.lang.String noiBanHanh,
        java.lang.String trichYeu, java.lang.String tuNgay,
        java.lang.String denNgay, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public java.util.List<Long> searchBySD_SNB_ND_NPH_TY_noRelation(
        long companyId, java.lang.String soVBDen, java.lang.String soNoiBo,
        java.util.Date tuNgay, java.util.Date denNgay,
        java.lang.String noiPhatHanh, java.lang.String trichYeu,
        java.util.List<Long> notInDocIdRelation, java.lang.String sortField,
        int sortType, boolean reverse)
        throws com.liferay.portal.SystemException;

    public int countBySD_SNB_ND_NPH_TY_noRelation(long companyId,
        java.lang.String soVBDen, java.lang.String soNoiBo,
        java.util.Date tuNgay, java.util.Date denNgay,
        java.lang.String noiPhatHanh, java.lang.String trichYeu,
        java.util.List<Long> notInDocIdRelation)
        throws com.liferay.portal.SystemException;

    public java.util.List<Long> searchBySD_SNB_ND_NPH_TY_noRelation(
        long companyId, java.lang.String soVBDen, java.lang.String soNoiBo,
        java.util.Date tuNgay, java.util.Date denNgay,
        java.lang.String noiPhatHanh, java.lang.String trichYeu,
        java.util.List<Long> notInDocIdRelation, java.lang.String sortField,
        int sortType, boolean reverse, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findBy_isPublic_mainDepartmentProcessId_Date(
        java.lang.String isPublic, java.lang.String mainDepartmentProcessId,
        java.lang.String tuNgay, java.lang.String denNgay,
        java.lang.String listUserId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator order)
        throws com.liferay.portal.SystemException;

    public int countBy_isPublic_mainDepartmentProcessId_Date(
        java.lang.String isPublic, java.lang.String mainDepartmentProcessId,
        java.lang.String tuNgay, java.lang.String denNgay,
        java.lang.String listUserId) throws com.liferay.portal.SystemException;

    public int countByNumberDocumentReceipt(
        java.lang.String numberDocumentReceipt, int issuingYear,
        long documentReceiptId) throws com.liferay.portal.SystemException;

    public int countByDocumentReference(java.lang.String documentReference,
        int issuingYear, long documentReceiptId)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt addPmlEdmDocumentReceipt(
        long companyId, java.lang.String documentReference,
        java.lang.String numberLocalDocumentReceipt,
        java.lang.String issuingPlaceId, java.util.Date issuingDate,
        java.lang.String signer, java.util.Date dateArrive, int processTime,
        boolean isPublic, int levelSendId, long documentTypeId,
        java.lang.String confidentialLevelId,
        java.lang.String privilegeLevelId, java.lang.String briefContent,
        boolean IsVbqppl, java.lang.String fieldId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException;

    public com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt updatePmlEdmDocumentReceipt(
        long companyId, long documentReceiptId,
        java.lang.String documentReference,
        java.lang.String numberLocalDocumentReceipt,
        java.lang.String issuingPlaceId, java.util.Date issuingDate,
        java.lang.String signer, java.util.Date dateArrive, int processTime,
        boolean isPublic, int levelSendId, long documentTypeId,
        java.lang.String confidentialLevelId,
        java.lang.String privilegeLevelId, java.lang.String briefContent,
        boolean IsVbqppl, java.lang.String fieldId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException;

    public int countBy_R_B_F_T(java.lang.String documentReference,
        java.lang.String briefContent, java.util.Date fromDate,
        java.util.Date toDate, boolean andOperator);

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findBy_R_B_F_T(
        java.lang.String documentReference, java.lang.String briefContent,
        java.util.Date fromDate, java.util.Date toDate, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;
}
