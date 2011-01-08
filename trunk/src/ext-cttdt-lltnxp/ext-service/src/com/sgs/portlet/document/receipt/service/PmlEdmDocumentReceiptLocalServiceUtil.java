package com.sgs.portlet.document.receipt.service;


/**
 * <a href="PmlEdmDocumentReceiptLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalService
 *
 */
public class PmlEdmDocumentReceiptLocalServiceUtil {
    private static PmlEdmDocumentReceiptLocalService _service;

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt addPmlEdmDocumentReceipt(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt pmlEdmDocumentReceipt)
        throws com.liferay.portal.SystemException {
        return getService().addPmlEdmDocumentReceipt(pmlEdmDocumentReceipt);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt createPmlEdmDocumentReceipt(
        long documentReceiptId) {
        return getService().createPmlEdmDocumentReceipt(documentReceiptId);
    }

    public static void deletePmlEdmDocumentReceipt(long documentReceiptId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlEdmDocumentReceipt(documentReceiptId);
    }

    public static void deletePmlEdmDocumentReceipt(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt pmlEdmDocumentReceipt)
        throws com.liferay.portal.SystemException {
        getService().deletePmlEdmDocumentReceipt(pmlEdmDocumentReceipt);
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

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt getPmlEdmDocumentReceipt(
        long documentReceiptId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlEdmDocumentReceipt(documentReceiptId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> getPmlEdmDocumentReceipts(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlEdmDocumentReceipts(start, end);
    }

    public static int getPmlEdmDocumentReceiptsCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlEdmDocumentReceiptsCount();
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt updatePmlEdmDocumentReceipt(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt pmlEdmDocumentReceipt)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlEdmDocumentReceipt(pmlEdmDocumentReceipt);
    }

    public static java.util.List<com.liferay.portal.model.User> getSortedListUser()
        throws com.liferay.portal.SystemException {
        return getService().getSortedListUser();
    }

    public static java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> getListIssuingPlace(
        java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listDocumentReceipt) {
        return getService().getListIssuingPlace(listDocumentReceipt);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> filter(
        java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> list,
        java.lang.String briefContent, java.lang.String signer,
        java.util.Date dateArrive, java.lang.String documentReference,
        java.lang.String issuingPlace, java.lang.String status) {
        return getService()
                   .filter(list, briefContent, signer, dateArrive,
            documentReference, issuingPlace, status);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> filterByStatus(
        java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> list,
        java.lang.String status) {
        return getService().filterByStatus(list, status);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> filterByIssuingPlace(
        java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> list,
        java.lang.String issuingPlace) {
        return getService().filterByIssuingPlace(list, issuingPlace);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> filterByDocumentReference(
        java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> list,
        java.lang.String documentReference) {
        return getService().filterByDocumentReference(list, documentReference);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> filterByDateArrive(
        java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> list,
        java.util.Date dateArrive) {
        return getService().filterByDateArrive(list, dateArrive);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> filterBySigner(
        java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> list,
        java.lang.String signer) {
        return getService().filterBySigner(list, signer);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> filterByBriefContent(
        java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> list,
        java.lang.String briefContent) {
        return getService().filterByBriefContent(list, briefContent);
    }

    public static int countByDocumentReceipt_Users_Status_DangXuLy_TreHan(
        java.util.List<Long> userIds, long statusId, java.lang.String soCVDen,
        java.lang.String capGui) throws java.lang.Exception {
        return getService()
                   .countByDocumentReceipt_Users_Status_DangXuLy_TreHan(userIds,
            statusId, soCVDen, capGui);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByDocumentReceipt_Users_Status_DangXuLy_TreHan(
        java.util.List<Long> userIds, long statusId, java.lang.String soCVDen,
        java.lang.String capGui, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .findByDocumentReceipt_Users_Status_DangXuLy_TreHan(userIds,
            statusId, soCVDen, capGui, start, end, obc);
    }

    public static int countByS_L_N_S_N_T_D_D_S_T(java.lang.String soCVDen,
        java.lang.String soVaoSo, java.lang.String tuNgay,
        java.lang.String denNgay, long soHSCV, long loaiCV,
        java.lang.String noiPhatHanh, long trangThai, java.lang.String nguoiKy,
        java.lang.String trichYeu) throws java.lang.Exception {
        return getService()
                   .countByS_L_N_S_N_T_D_D_S_T(soCVDen, soVaoSo, tuNgay,
            denNgay, soHSCV, loaiCV, noiPhatHanh, trangThai, nguoiKy, trichYeu);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByS_L_N_S_N_T_D_D_S_T(
        java.lang.String soCVDen, java.lang.String soVaoSo,
        java.lang.String tuNgay, java.lang.String denNgay, long soHSCV,
        long loaiCV, java.lang.String noiPhatHanh, long trangThai,
        java.lang.String nguoiKy, java.lang.String trichYeu, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .findByS_L_N_S_N_T_D_D_S_T(soCVDen, soVaoSo, tuNgay,
            denNgay, soHSCV, loaiCV, noiPhatHanh, trangThai, nguoiKy, trichYeu,
            start, end, obc);
    }

    public static int countTonDauKyChuyenVien_CVDen(long userId,
        int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getService()
                   .countTonDauKyChuyenVien_CVDen(userId, documentRecordTypeId,
            capGui, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listTonDauKyChuyenVien_CVDen(
        long userId, int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .listTonDauKyChuyenVien_CVDen(userId, documentRecordTypeId,
            capGui, loaiVB, doMat, fromDate, toDate, start, end, obc);
    }

    public static int countNhanTrongKyChuyenVien_CVDen(long userId,
        int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getService()
                   .countNhanTrongKyChuyenVien_CVDen(userId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listNhanTrongKyChuyenVien_CVDen(
        long userId, int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .listNhanTrongKyChuyenVien_CVDen(userId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate,
            start, end, obc);
    }

    public static int countChuaNhanChuyenVien_CVDen(long userId,
        int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getService()
                   .countChuaNhanChuyenVien_CVDen(userId, documentRecordTypeId,
            capGui, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listChuaNhanChuyenVien_CVDen(
        long userId, int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .listChuaNhanChuyenVien_CVDen(userId, documentRecordTypeId,
            capGui, loaiVB, doMat, fromDate, toDate, start, end, obc);
    }

    public static int countNhanTrongThangChuyenVien_CVDen(long userId,
        int documentRecordTypeId, int capGui, int loaiVB,
        java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getService()
                   .countNhanTrongThangChuyenVien_CVDen(userId,
            documentRecordTypeId, capGui, loaiVB, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listNhanTrongThangChuyenVien_CVDen(
        long userId, int documentRecordTypeId, int capGui, int loaiVB,
        java.util.Date fromDate, java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .listNhanTrongThangChuyenVien_CVDen(userId,
            documentRecordTypeId, capGui, loaiVB, fromDate, toDate, start, end,
            obc);
    }

    public static int countDungHanDaXuLyChuyenVien_CVDen(long userId,
        int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getService()
                   .countDungHanDaXuLyChuyenVien_CVDen(userId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listDungHanDaXuLyChuyenVien_CVDen(
        long userId, int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .listDungHanDaXuLyChuyenVien_CVDen(userId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate,
            start, end, obc);
    }

    public static int countTreHanDaXuLyChuyenVien_CVDen(long userId,
        int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getService()
                   .countTreHanDaXuLyChuyenVien_CVDen(userId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listTreHanDaXuLyChuyenVien_CVDen(
        long userId, int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .listTreHanDaXuLyChuyenVien_CVDen(userId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate,
            start, end, obc);
    }

    public static int countTongDaXuLyChuyenVien_CVDen(long userId,
        int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getService()
                   .countTongDaXuLyChuyenVien_CVDen(userId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listTongDaXuLyChuyenVien_CVDen(
        long userId, int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .listTongDaXuLyChuyenVien_CVDen(userId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate,
            start, end, obc);
    }

    public static int countDungHanDangXuLyChuyenVien_CVDen(long userId,
        int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getService()
                   .countDungHanDangXuLyChuyenVien_CVDen(userId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listDungHanDangXuLyChuyenVien_CVDen(
        long userId, int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .listDungHanDangXuLyChuyenVien_CVDen(userId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate,
            start, end, obc);
    }

    public static int countTreHanDangXuLyChuyenVien_CVDen(long userId,
        int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getService()
                   .countTreHanDangXuLyChuyenVien_CVDen(userId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listTreHanDangXuLyChuyenVien_CVDen(
        long userId, int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .listTreHanDangXuLyChuyenVien_CVDen(userId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate,
            start, end, obc);
    }

    public static int countTongDangXuLyChuyenVien_CVDen(long userId,
        int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getService()
                   .countTongDangXuLyChuyenVien_CVDen(userId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listTongDangXuLyChuyenVien_CVDen(
        long userId, int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .listTongDangXuLyChuyenVien_CVDen(userId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate,
            start, end, obc);
    }

    public static int countTonDauKyPhongBan_CVDen(
        java.lang.String departmentId, int documentRecordTypeId, int capGui,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate) throws java.lang.Exception {
        return getService()
                   .countTonDauKyPhongBan_CVDen(departmentId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listTonDauKyPhongBan_CVDen(
        java.lang.String departmentId, int documentRecordTypeId, int capGui,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .listTonDauKyPhongBan_CVDen(departmentId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate,
            start, end, obc);
    }

    public static int countNhanTrongKyPhongBan_CVDen(
        java.lang.String departmentId, int documentRecordTypeId, int capGui,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate) throws java.lang.Exception {
        return getService()
                   .countNhanTrongKyPhongBan_CVDen(departmentId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listNhanTrongKyPhongBan_CVDen(
        java.lang.String departmentId, int documentRecordTypeId, int capGui,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .listNhanTrongKyPhongBan_CVDen(departmentId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate,
            start, end, obc);
    }

    public static int countChuaNhanTrongKyPhongBan_CVDen(
        java.lang.String departmentId, int documentRecordTypeId, int capGui,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate) throws java.lang.Exception {
        return getService()
                   .countChuaNhanTrongKyPhongBan_CVDen(departmentId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listChuaNhanTrongKyPhongBan_CVDen(
        java.lang.String departmentId, int documentRecordTypeId, int capGui,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .listChuaNhanTrongKyPhongBan_CVDen(departmentId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate,
            start, end, obc);
    }

    public static int countDungHanDaXuLyPhongBan_CVDen(
        java.lang.String departmentId, int documentRecordTypeId, int capGui,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate) throws java.lang.Exception {
        return getService()
                   .countDungHanDaXuLyPhongBan_CVDen(departmentId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listDungHanDaXuLyPhongBan_CVDen(
        java.lang.String departmentId, int documentRecordTypeId, int capGui,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .listDungHanDaXuLyPhongBan_CVDen(departmentId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate,
            start, end, obc);
    }

    public static int countTreHanDaXuLyPhongBan_CVDen(
        java.lang.String departmentId, int documentRecordTypeId, int capGui,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate) throws java.lang.Exception {
        return getService()
                   .countTreHanDaXuLyPhongBan_CVDen(departmentId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listTreHanDaXuLyPhongBan_CVDen(
        java.lang.String departmentId, int documentRecordTypeId, int capGui,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .listTreHanDaXuLyPhongBan_CVDen(departmentId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate,
            start, end, obc);
    }

    public static int countTongDaXuLyPhongBan_CVDen(
        java.lang.String departmentId, int documentRecordTypeId, int capGui,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate) throws java.lang.Exception {
        return getService()
                   .countTongDaXuLyPhongBan_CVDen(departmentId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listTongDaXuLyPhongBan_CVDen(
        java.lang.String departmentId, int documentRecordTypeId, int capGui,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .listTongDaXuLyPhongBan_CVDen(departmentId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate,
            start, end, obc);
    }

    public static int countDungHanDangXuLyPhongBan_CVDen(
        java.lang.String departmentId, int documentRecordTypeId, int capGui,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate) throws java.lang.Exception {
        return getService()
                   .countDungHanDangXuLyPhongBan_CVDen(departmentId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listDungHanDangXuLyPhongBan_CVDen(
        java.lang.String departmentId, int documentRecordTypeId, int capGui,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .listDungHanDangXuLyPhongBan_CVDen(departmentId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate,
            start, end, obc);
    }

    public static int countTreHanDangXuLyPhongBan_CVDen(
        java.lang.String departmentId, int documentRecordTypeId, int capGui,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate) throws java.lang.Exception {
        return getService()
                   .countTreHanDangXuLyPhongBan_CVDen(departmentId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listTreHanDangXuLyPhongBan_CVDen(
        java.lang.String departmentId, int documentRecordTypeId, int capGui,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .listTreHanDangXuLyPhongBan_CVDen(departmentId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate,
            start, end, obc);
    }

    public static int countTongDangXuLyPhongBan_CVDen(
        java.lang.String departmentId, int documentRecordTypeId, int capGui,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate) throws java.lang.Exception {
        return getService()
                   .countTongDangXuLyPhongBan_CVDen(departmentId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listTongDangXuLyPhongBan_CVDen(
        java.lang.String departmentId, int documentRecordTypeId, int capGui,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .listTongDangXuLyPhongBan_CVDen(departmentId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate,
            start, end, obc);
    }

    public static int countTonDauKySo_CVDen(int documentRecordTypeId,
        int capGui, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getService()
                   .countTonDauKySo_CVDen(documentRecordTypeId, capGui, loaiVB,
            doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listTonDauKySo_CVDen(
        int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .listTonDauKySo_CVDen(documentRecordTypeId, capGui, loaiVB,
            doMat, fromDate, toDate, start, end, obc);
    }

    public static int countNhanTrongKySo_CVDen(int documentRecordTypeId,
        int capGui, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getService()
                   .countNhanTrongKySo_CVDen(documentRecordTypeId, capGui,
            loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listNhanTrongKySo_CVDen(
        int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .listNhanTrongKySo_CVDen(documentRecordTypeId, capGui,
            loaiVB, doMat, fromDate, toDate, start, end, obc);
    }

    public static int countDungHanDaXuLySo_CVDen(int documentRecordTypeId,
        int capGui, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getService()
                   .countDungHanDaXuLySo_CVDen(documentRecordTypeId, capGui,
            loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listDungHanDaXuLySo_CVDen(
        int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .listDungHanDaXuLySo_CVDen(documentRecordTypeId, capGui,
            loaiVB, doMat, fromDate, toDate, start, end, obc);
    }

    public static int countTreHanDaXuLySo_CVDen(int documentRecordTypeId,
        int capGui, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getService()
                   .countTreHanDaXuLySo_CVDen(documentRecordTypeId, capGui,
            loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listTreHanDaXuLySo_CVDen(
        int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .listTreHanDaXuLySo_CVDen(documentRecordTypeId, capGui,
            loaiVB, doMat, fromDate, toDate, start, end, obc);
    }

    public static int countTongDaXuLySo_CVDen(int documentRecordTypeId,
        int capGui, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getService()
                   .countTongDaXuLySo_CVDen(documentRecordTypeId, capGui,
            loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listTongDaXuLySo_CVDen(
        int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .listTongDaXuLySo_CVDen(documentRecordTypeId, capGui,
            loaiVB, doMat, fromDate, toDate, start, end, obc);
    }

    public static int countDungHanDangXuLySo_CVDen(int documentRecordTypeId,
        int capGui, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getService()
                   .countDungHanDangXuLySo_CVDen(documentRecordTypeId, capGui,
            loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listDungHanDangXuLySo_CVDen(
        int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .listDungHanDangXuLySo_CVDen(documentRecordTypeId, capGui,
            loaiVB, doMat, fromDate, toDate, start, end, obc);
    }

    public static int countTreHanDangXuLySo_CVDen(int documentRecordTypeId,
        int capGui, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getService()
                   .countTreHanDangXuLySo_CVDen(documentRecordTypeId, capGui,
            loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listTreHanDangXuLySo_CVDen(
        int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .listTreHanDangXuLySo_CVDen(documentRecordTypeId, capGui,
            loaiVB, doMat, fromDate, toDate, start, end, obc);
    }

    public static int countTongDangXuLySo_CVDen(int documentRecordTypeId,
        int capGui, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getService()
                   .countTongDangXuLySo_CVDen(documentRecordTypeId, capGui,
            loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listTongDangXuLySo_CVDen(
        int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .listTongDangXuLySo_CVDen(documentRecordTypeId, capGui,
            loaiVB, doMat, fromDate, toDate, start, end, obc);
    }

    public static int totalDateOff(java.lang.String dateNow,
        java.lang.String dateCalen) throws com.liferay.portal.SystemException {
        return getService().totalDateOff(dateNow, dateCalen);
    }

    public static java.lang.String addDateNum(java.lang.String dateInput,
        int numDate) throws com.liferay.portal.SystemException {
        return getService().addDateNum(dateInput, numDate);
    }

    public static int getGeneralNumberDocumentReceipt(
        java.lang.String ddmmyyyyReceiveDate)
        throws com.liferay.portal.SystemException {
        return getService().getGeneralNumberDocumentReceipt(ddmmyyyyReceiveDate);
    }

    public static int countDocRecNeedProcess(long userId)
        throws com.liferay.portal.SystemException {
        return getService().countDocRecNeedProcess(userId);
    }

    public static int countByDocumentReceipt_Users_Status_DangXuLy(
        java.util.List<Long> userIds, long statusId, java.lang.String soCVDen,
        java.lang.String capGui) throws java.lang.Exception {
        return getService()
                   .countByDocumentReceipt_Users_Status_DangXuLy(userIds,
            statusId, soCVDen, capGui);
    }

    public static int countByDocumentReceipt_Users_Status_DangXuLy(
        java.util.List<Long> userIds, long statusId, java.lang.String soCVDen,
        java.lang.String capGui, java.lang.String cachThucXuLy)
        throws java.lang.Exception {
        return getService()
                   .countByDocumentReceipt_Users_Status_DangXuLy(userIds,
            statusId, soCVDen, capGui, cachThucXuLy);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByDocumentReceipt_Users_Status_DangXuLy(
        java.util.List<Long> userIds, long statusId, java.lang.String soCVDen,
        java.lang.String capGui, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .findByDocumentReceipt_Users_Status_DangXuLy(userIds,
            statusId, soCVDen, capGui, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByDocumentReceipt_Users_Status_DangXuLy(
        java.util.List<Long> userIds, long statusId, java.lang.String soCVDen,
        java.lang.String capGui, java.lang.String cachThucXuLy, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .findByDocumentReceipt_Users_Status_DangXuLy(userIds,
            statusId, soCVDen, capGui, cachThucXuLy, start, end, obc);
    }

    public static int countByDocumentReceipt_Users(
        java.util.List<Long> userIds, java.lang.String capGui,
        java.lang.String loaisocongvan) throws java.lang.Exception {
        return getService()
                   .countByDocumentReceipt_Users(userIds, capGui, loaisocongvan);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByDocumentReceipt_Users(
        java.util.List<Long> userIds, java.lang.String capGui,
        java.lang.String loaisocongvan, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .findByDocumentReceipt_Users(userIds, capGui, loaisocongvan,
            start, end, obc);
    }

    public static int countByDocumentReceipt_Users_Status_DaXuLy(
        java.util.List<Long> userIds, long statusId, int year,
        java.lang.String soCVDen, java.lang.String capGui)
        throws java.lang.Exception {
        return getService()
                   .countByDocumentReceipt_Users_Status_DaXuLy(userIds,
            statusId, year, soCVDen, capGui);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByDocumentReceipt_Users_Status_DaXuLy(
        java.util.List<Long> userIds, long statusId, int year,
        java.lang.String soCVDen, java.lang.String capGui, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .findByDocumentReceipt_Users_Status_DaXuLy(userIds,
            statusId, year, soCVDen, capGui, start, end, obc);
    }

    public static int countByDocumentReceipt_Users_Status_DaXuLy_TreHan(
        java.util.List<Long> userIds, long statusId, int year,
        java.lang.String soCVDen, java.lang.String capGui)
        throws java.lang.Exception {
        return getService()
                   .countByDocumentReceipt_Users_Status_DaXuLy_TreHan(userIds,
            statusId, year, soCVDen, capGui);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByDocumentReceipt_Users_Status_DaXuLy_TreHan(
        java.util.List<Long> userIds, long statusId, int year,
        java.lang.String soCVDen, java.lang.String capGui, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .findByDocumentReceipt_Users_Status_DaXuLy_TreHan(userIds,
            statusId, year, soCVDen, capGui, start, end, obc);
    }

    public static long getMaxDocumentReceiptId()
        throws com.liferay.portal.SystemException {
        return getService().getMaxDocumentReceiptId();
    }

    public static void reIndex(long companyId,
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt documentReceipt)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException {
        getService().reIndex(companyId, documentReceipt);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt addPmlEdmDocumentReceipt(
        long companyId,
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt pmlEdmDocumentReceipt)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException {
        return getService()
                   .addPmlEdmDocumentReceipt(companyId, pmlEdmDocumentReceipt);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt updatePmlEdmDocumentReceipt(
        long companyId,
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt pmlEdmDocumentReceipt)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException {
        return getService()
                   .updatePmlEdmDocumentReceipt(companyId, pmlEdmDocumentReceipt);
    }

    public static void deletePmlEdmDocumentReceipt(long companyId,
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt pmlEdmDocumentReceipt)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException {
        getService()
            .deletePmlEdmDocumentReceipt(companyId, pmlEdmDocumentReceipt);
    }

    public static void deletePmlEdmDocumentReceipt(long companyId,
        long documentReceiptId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlEdmDocumentReceipt(companyId, documentReceiptId);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt addPmlEdmDocumentReceipt(
        long companyId, java.lang.String documentReference,
        java.lang.String numberLocalDocumentReceipt,
        java.lang.String issuingPlaceId, java.util.Date issuingDate,
        java.lang.String signer, java.util.Date dateArrive, int processTime,
        boolean isPublic, int levelSendId, long documentTypeId,
        java.lang.String confidentialLevelId,
        java.lang.String privilegeLevelId, java.lang.String briefContent)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException {
        return getService()
                   .addPmlEdmDocumentReceipt(companyId, documentReference,
            numberLocalDocumentReceipt, issuingPlaceId, issuingDate, signer,
            dateArrive, processTime, isPublic, levelSendId, documentTypeId,
            confidentialLevelId, privilegeLevelId, briefContent);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt updatePmlEdmDocumentReceipt(
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
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException {
        return getService()
                   .updatePmlEdmDocumentReceipt(companyId, documentReceiptId,
            documentReference, numberLocalDocumentReceipt, issuingPlaceId,
            issuingDate, signer, dateArrive, processTime, isPublic,
            levelSendId, documentTypeId, confidentialLevelId, privilegeLevelId,
            briefContent);
    }

    public static void reIndex(java.lang.String[] ids)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException {
        getService().reIndex(ids);
    }

    public static com.liferay.portal.kernel.search.Hits search(long companyId,
        java.lang.String soCVDen, java.lang.String soVaoSo,
        java.util.Date tuNgay, java.util.Date denNgay, long soHSCV,
        long loaiCV, java.lang.String noiPhatHanh, long trangThai,
        java.lang.String nguoiKy, java.lang.String trichYeu,
        java.lang.String active, int start, int end)
        throws com.liferay.portal.SystemException {
        return getService()
                   .search(companyId, soCVDen, soVaoSo, tuNgay, denNgay,
            soHSCV, loaiCV, noiPhatHanh, trangThai, nguoiKy, trichYeu, active,
            start, end);
    }

    public static com.liferay.portal.kernel.search.Hits search(long companyId,
        java.lang.String soCVDen, java.lang.String soVaoSo,
        java.util.Date tuNgay, java.util.Date denNgay, long soHSCV,
        long loaiCV, java.lang.String noiPhatHanh, long trangThai,
        java.lang.String nguoiKy, java.lang.String trichYeu,
        java.lang.String active, java.lang.String sortField, int sortType,
        int start, int end) throws com.liferay.portal.SystemException {
        return getService()
                   .search(companyId, soCVDen, soVaoSo, tuNgay, denNgay,
            soHSCV, loaiCV, noiPhatHanh, trangThai, nguoiKy, trichYeu, active,
            sortField, sortType, start, end);
    }

    public static com.liferay.portal.kernel.search.Hits search(long companyId,
        java.lang.String soCVDen, java.lang.String soVaoSo,
        java.util.Date tuNgay, java.util.Date denNgay, long soHSCV,
        long loaiCV, java.lang.String noiPhatHanh, long trangThai,
        java.lang.String nguoiKy, java.lang.String trichYeu,
        java.lang.String active, java.lang.String sortField, int sortType,
        boolean reverse, int start, int end)
        throws com.liferay.portal.SystemException {
        return getService()
                   .search(companyId, soCVDen, soVaoSo, tuNgay, denNgay,
            soHSCV, loaiCV, noiPhatHanh, trangThai, nguoiKy, trichYeu, active,
            sortField, sortType, reverse, start, end);
    }

    public static int countByDocrefIssyearArrYear(java.lang.String docRef,
        int issuingYear, boolean findIssuingYear, int arriveYear,
        boolean findArriveYear) throws com.liferay.portal.SystemException {
        return getService()
                   .countByDocrefIssyearArrYear(docRef, issuingYear,
            findIssuingYear, arriveYear, findArriveYear);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> getListCVDenDaXuLyChung(
        long userId, java.lang.String year, java.lang.String capGui,
        java.lang.String loaisocongvan, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getListCVDenDaXuLyChung(userId, year, capGui,
            loaisocongvan, start, end, obc);
    }

    public static int countListCVDenDaXuLyChung(long userId,
        java.lang.String year, java.lang.String capGui,
        java.lang.String loaisocongvan)
        throws com.liferay.portal.SystemException {
        return getService()
                   .countListCVDenDaXuLyChung(userId, year, capGui,
            loaisocongvan);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> getListCVDenDaXuLyTuXuLy(
        long userId, java.lang.String year, java.lang.String capGui,
        java.lang.String loaisocongvan, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getListCVDenDaXuLyTuXuLy(userId, year, capGui,
            loaisocongvan, start, end, obc);
    }

    public static int countListCVDenDaXuLyTuXuLy(long userId,
        java.lang.String year, java.lang.String capGui,
        java.lang.String loaisocongvan)
        throws com.liferay.portal.SystemException {
        return getService()
                   .countListCVDenDaXuLyTuXuLy(userId, year, capGui,
            loaisocongvan);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> getListCVDenDaXuLyChung_treHan(
        long userId, java.lang.String year, java.lang.String capGui,
        java.lang.String loaisocongvan, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getListCVDenDaXuLyChung_treHan(userId, year, capGui,
            loaisocongvan, start, end, obc);
    }

    public static int countListCVDenDaXuLyChung_treHan(long userId,
        java.lang.String year, java.lang.String capGui,
        java.lang.String loaisocongvan)
        throws com.liferay.portal.SystemException {
        return getService()
                   .countListCVDenDaXuLyChung_treHan(userId, year, capGui,
            loaisocongvan);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> getListCVDenDaXuLyTuXuLy_treHan(
        long userId, java.lang.String year, java.lang.String capGui,
        java.lang.String loaisocongvan, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getListCVDenDaXuLyTuXuLy_treHan(userId, year, capGui,
            loaisocongvan, start, end, obc);
    }

    public static int countListCVDenDaXuLyTuXuLy_treHan(long userId,
        java.lang.String year, java.lang.String capGui,
        java.lang.String loaisocongvan)
        throws com.liferay.portal.SystemException {
        return getService()
                   .countListCVDenDaXuLyTuXuLy_treHan(userId, year, capGui,
            loaisocongvan);
    }

    public static int countByN_D_I_L_I_P_D_D_D_B(java.lang.String soNoiBo,
        java.lang.String soHieuGoc, int ngayPHDay, int ngayPHMonth,
        int ngayPHYear, long capGui, java.lang.String noiPhatHanh,
        java.lang.String uuTien, int ngayDenDay, int ngayDenMonth,
        int ngayDenYear, long loaiVB, java.lang.String phongBan,
        java.lang.String trichYeu) throws com.liferay.portal.SystemException {
        return getService()
                   .countByN_D_I_L_I_P_D_D_D_B(soNoiBo, soHieuGoc, ngayPHDay,
            ngayPHMonth, ngayPHYear, capGui, noiPhatHanh, uuTien, ngayDenDay,
            ngayDenMonth, ngayDenYear, loaiVB, phongBan, trichYeu);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByN_D_I_L_I_P_D_D_D_B(
        java.lang.String soNoiBo, java.lang.String soHieuGoc, int ngayPHDay,
        int ngayPHMonth, int ngayPHYear, long capGui,
        java.lang.String noiPhatHanh, java.lang.String uuTien, int ngayDenDay,
        int ngayDenMonth, int ngayDenYear, long loaiVB,
        java.lang.String phongBan, java.lang.String trichYeu, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .findByN_D_I_L_I_P_D_D_D_B(soNoiBo, soHieuGoc, ngayPHDay,
            ngayPHMonth, ngayPHYear, capGui, noiPhatHanh, uuTien, ngayDenDay,
            ngayDenMonth, ngayDenYear, loaiVB, phongBan, trichYeu, start, end,
            obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> getListCVDenDaXuLyChung(
        long userId, java.lang.String soVBDen, java.lang.String soHieuGoc,
        int loaiSoVanBan, java.lang.String issuingplaceId,
        java.lang.String noiBanHanh, java.lang.String trichYeu,
        java.lang.String tuNgay, java.lang.String denNgay,
        java.lang.String ngayHetHan, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getListCVDenDaXuLyChung(userId, soVBDen, soHieuGoc,
            loaiSoVanBan, issuingplaceId, noiBanHanh, trichYeu, tuNgay,
            denNgay, ngayHetHan, start, end, obc);
    }

    public static int countListCVDenDaXuLyChung(long userId,
        java.lang.String soVBDen, java.lang.String soHieuGoc, int loaiSoVanBan,
        java.lang.String issuingplaceId, java.lang.String noiBanHanh,
        java.lang.String trichYeu, java.lang.String tuNgay,
        java.lang.String denNgay, java.lang.String ngayHetHan)
        throws com.liferay.portal.SystemException {
        return getService()
                   .countListCVDenDaXuLyChung(userId, soVBDen, soHieuGoc,
            loaiSoVanBan, issuingplaceId, noiBanHanh, trichYeu, tuNgay,
            denNgay, ngayHetHan);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> getListCVDenDaXuLyTuXuLy(
        long userId, java.lang.String soVBDen, java.lang.String soHieuGoc,
        int loaiSoVanBan, java.lang.String issuingplaceId,
        java.lang.String noiBanHanh, java.lang.String trichYeu,
        java.lang.String tuNgay, java.lang.String denNgay,
        java.lang.String ngayHetHan, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getListCVDenDaXuLyTuXuLy(userId, soVBDen, soHieuGoc,
            loaiSoVanBan, issuingplaceId, noiBanHanh, trichYeu, tuNgay,
            denNgay, ngayHetHan, start, end, obc);
    }

    public static int countListCVDenDaXuLyTuXuLy(long userId,
        java.lang.String soVBDen, java.lang.String soHieuGoc, int loaiSoVanBan,
        java.lang.String issuingplaceId, java.lang.String noiBanHanh,
        java.lang.String trichYeu, java.lang.String tuNgay,
        java.lang.String denNgay, java.lang.String ngayHetHan)
        throws com.liferay.portal.SystemException {
        return getService()
                   .countListCVDenDaXuLyTuXuLy(userId, soVBDen, soHieuGoc,
            loaiSoVanBan, issuingplaceId, noiBanHanh, trichYeu, tuNgay,
            denNgay, ngayHetHan);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> getListCVDenDaXuLyChung_treHan(
        long userId, java.lang.String soVBDen, java.lang.String soHieuGoc,
        int loaiSoVanBan, java.lang.String issuingplaceId,
        java.lang.String noiBanHanh, java.lang.String trichYeu,
        java.lang.String tuNgay, java.lang.String denNgay,
        java.lang.String ngayHetHan, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getListCVDenDaXuLyChung_treHan(userId, soVBDen, soHieuGoc,
            loaiSoVanBan, issuingplaceId, noiBanHanh, trichYeu, tuNgay,
            denNgay, ngayHetHan, start, end, obc);
    }

    public static int countListCVDenDaXuLyChung_treHan(long userId,
        java.lang.String soVBDen, java.lang.String soHieuGoc, int loaiSoVanBan,
        java.lang.String issuingplaceId, java.lang.String noiBanHanh,
        java.lang.String trichYeu, java.lang.String tuNgay,
        java.lang.String denNgay, java.lang.String ngayHetHan)
        throws com.liferay.portal.SystemException {
        return getService()
                   .countListCVDenDaXuLyChung_treHan(userId, soVBDen,
            soHieuGoc, loaiSoVanBan, issuingplaceId, noiBanHanh, trichYeu,
            tuNgay, denNgay, ngayHetHan);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> getListCVDenDaXuLyTuXuLy_treHan(
        long userId, java.lang.String soVBDen, java.lang.String soHieuGoc,
        int loaiSoVanBan, java.lang.String issuingplaceId,
        java.lang.String noiBanHanh, java.lang.String trichYeu,
        java.lang.String tuNgay, java.lang.String denNgay,
        java.lang.String ngayHetHan, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getListCVDenDaXuLyTuXuLy_treHan(userId, soVBDen, soHieuGoc,
            loaiSoVanBan, issuingplaceId, noiBanHanh, trichYeu, tuNgay,
            denNgay, ngayHetHan, start, end, obc);
    }

    public static int countListCVDenDaXuLyTuXuLy_treHan(long userId,
        java.lang.String soVBDen, java.lang.String soHieuGoc, int loaiSoVanBan,
        java.lang.String issuingplaceId, java.lang.String noiBanHanh,
        java.lang.String trichYeu, java.lang.String tuNgay,
        java.lang.String denNgay, java.lang.String ngayHetHan)
        throws com.liferay.portal.SystemException {
        return getService()
                   .countListCVDenDaXuLyTuXuLy_treHan(userId, soVBDen,
            soHieuGoc, loaiSoVanBan, issuingplaceId, noiBanHanh, trichYeu,
            tuNgay, denNgay, ngayHetHan);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByDocumentReceipt_Users_Status_DangXuLy(
        java.util.List<Long> userIds, long statusId, java.lang.String soVBDen,
        java.lang.String soHieuGoc, int loaiSoVanBan,
        java.lang.String issuingplaceId, java.lang.String noiBanHanh,
        java.lang.String trichYeu, java.lang.String tuNgay,
        java.lang.String denNgay, java.lang.String ngayHetHan, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .findByDocumentReceipt_Users_Status_DangXuLy(userIds,
            statusId, soVBDen, soHieuGoc, loaiSoVanBan, issuingplaceId,
            noiBanHanh, trichYeu, tuNgay, denNgay, ngayHetHan, start, end, obc);
    }

    public static int countByDocumentReceipt_Users_Status_DangXuLy(
        java.util.List<Long> userIds, long statusId, java.lang.String soVBDen,
        java.lang.String soHieuGoc, int loaiSoVanBan,
        java.lang.String issuingplaceId, java.lang.String noiBanHanh,
        java.lang.String trichYeu, java.lang.String tuNgay,
        java.lang.String denNgay, java.lang.String ngayHetHan)
        throws java.lang.Exception {
        return getService()
                   .countByDocumentReceipt_Users_Status_DangXuLy(userIds,
            statusId, soVBDen, soHieuGoc, loaiSoVanBan, issuingplaceId,
            noiBanHanh, trichYeu, tuNgay, denNgay, ngayHetHan);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByDocumentReceipt_Users_Status_DangXuLy_TreHan(
        java.util.List<Long> userIds, long statusId, java.lang.String soVBDen,
        java.lang.String soHieuGoc, int loaiSoVanBan,
        java.lang.String issuingplaceId, java.lang.String noiBanHanh,
        java.lang.String trichYeu, java.lang.String tuNgay,
        java.lang.String denNgay, java.lang.String ngayHetHan, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .findByDocumentReceipt_Users_Status_DangXuLy_TreHan(userIds,
            statusId, soVBDen, soHieuGoc, loaiSoVanBan, issuingplaceId,
            noiBanHanh, trichYeu, tuNgay, denNgay, ngayHetHan, start, end, obc);
    }

    public static int countByDocumentReceipt_Users_Status_DangXuLy_TreHan(
        java.util.List<Long> userIds, long statusId, java.lang.String soVBDen,
        java.lang.String soHieuGoc, int loaiSoVanBan,
        java.lang.String issuingplaceId, java.lang.String noiBanHanh,
        java.lang.String trichYeu, java.lang.String tuNgay,
        java.lang.String denNgay, java.lang.String ngayHetHan)
        throws java.lang.Exception {
        return getService()
                   .countByDocumentReceipt_Users_Status_DangXuLy_TreHan(userIds,
            statusId, soVBDen, soHieuGoc, loaiSoVanBan, issuingplaceId,
            noiBanHanh, trichYeu, tuNgay, denNgay, ngayHetHan);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByDocumentReceipt_Users(
        java.util.List<Long> userIds, java.lang.String soVBDen,
        java.lang.String soHieuGoc, int loaiSoVanBan,
        java.lang.String issuingplaceId, java.lang.String noiBanHanh,
        java.lang.String trichYeu, java.lang.String tuNgay,
        java.lang.String denNgay, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .findByDocumentReceipt_Users(userIds, soVBDen, soHieuGoc,
            loaiSoVanBan, issuingplaceId, noiBanHanh, trichYeu, tuNgay,
            denNgay, start, end, obc);
    }

    public static int countByDocumentReceipt_Users(
        java.util.List<Long> userIds, java.lang.String soVBDen,
        java.lang.String soHieuGoc, int loaiSoVanBan,
        java.lang.String issuingplaceId, java.lang.String noiBanHanh,
        java.lang.String trichYeu, java.lang.String tuNgay,
        java.lang.String denNgay) throws java.lang.Exception {
        return getService()
                   .countByDocumentReceipt_Users(userIds, soVBDen, soHieuGoc,
            loaiSoVanBan, issuingplaceId, noiBanHanh, trichYeu, tuNgay, denNgay);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptLog_Users_Status_DangXuLy(
        java.util.List<Long> userIds, long statusId, java.lang.String soVBDen,
        java.lang.String soHieuGoc, int loaiSoVanBan,
        java.lang.String issuingplaceId, java.lang.String noiBanHanh,
        java.lang.String trichYeu, java.lang.String tuNgay,
        java.lang.String denNgay, java.lang.String ngayHetHan, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .findByDocumentReceiptLog_Users_Status_DangXuLy(userIds,
            statusId, soVBDen, soHieuGoc, loaiSoVanBan, issuingplaceId,
            noiBanHanh, trichYeu, tuNgay, denNgay, ngayHetHan, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptLog_Users_Status_DangXuLy_TreHan(
        java.util.List<Long> userIds, long statusId, java.lang.String soVBDen,
        java.lang.String soHieuGoc, int loaiSoVanBan,
        java.lang.String issuingplaceId, java.lang.String noiBanHanh,
        java.lang.String trichYeu, java.lang.String tuNgay,
        java.lang.String denNgay, java.lang.String ngayHetHan, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .findByDocumentReceiptLog_Users_Status_DangXuLy_TreHan(userIds,
            statusId, soVBDen, soHieuGoc, loaiSoVanBan, issuingplaceId,
            noiBanHanh, trichYeu, tuNgay, denNgay, ngayHetHan, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptLog_Users(
        java.util.List<Long> userIds, java.lang.String soVBDen,
        java.lang.String soHieuGoc, int loaiSoVanBan,
        java.lang.String issuingplaceId, java.lang.String noiBanHanh,
        java.lang.String trichYeu, java.lang.String tuNgay,
        java.lang.String denNgay, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .findByDocumentReceiptLog_Users(userIds, soVBDen, soHieuGoc,
            loaiSoVanBan, issuingplaceId, noiBanHanh, trichYeu, tuNgay,
            denNgay, start, end, obc);
    }

    public static java.util.List<Long> searchBySD_SNB_ND_NPH_TY_noRelation(
        long companyId, java.lang.String soVBDen, java.lang.String soNoiBo,
        java.util.Date tuNgay, java.util.Date denNgay,
        java.lang.String noiPhatHanh, java.lang.String trichYeu,
        java.util.List<Long> notInDocIdRelation, java.lang.String sortField,
        int sortType, boolean reverse)
        throws com.liferay.portal.SystemException {
        return getService()
                   .searchBySD_SNB_ND_NPH_TY_noRelation(companyId, soVBDen,
            soNoiBo, tuNgay, denNgay, noiPhatHanh, trichYeu,
            notInDocIdRelation, sortField, sortType, reverse);
    }

    public static int countBySD_SNB_ND_NPH_TY_noRelation(long companyId,
        java.lang.String soVBDen, java.lang.String soNoiBo,
        java.util.Date tuNgay, java.util.Date denNgay,
        java.lang.String noiPhatHanh, java.lang.String trichYeu,
        java.util.List<Long> notInDocIdRelation)
        throws com.liferay.portal.SystemException {
        return getService()
                   .countBySD_SNB_ND_NPH_TY_noRelation(companyId, soVBDen,
            soNoiBo, tuNgay, denNgay, noiPhatHanh, trichYeu, notInDocIdRelation);
    }

    public static java.util.List<Long> searchBySD_SNB_ND_NPH_TY_noRelation(
        long companyId, java.lang.String soVBDen, java.lang.String soNoiBo,
        java.util.Date tuNgay, java.util.Date denNgay,
        java.lang.String noiPhatHanh, java.lang.String trichYeu,
        java.util.List<Long> notInDocIdRelation, java.lang.String sortField,
        int sortType, boolean reverse, int start, int end)
        throws com.liferay.portal.SystemException {
        return getService()
                   .searchBySD_SNB_ND_NPH_TY_noRelation(companyId, soVBDen,
            soNoiBo, tuNgay, denNgay, noiPhatHanh, trichYeu,
            notInDocIdRelation, sortField, sortType, reverse, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findBy_isPublic_mainDepartmentProcessId_Date(
        java.lang.String isPublic, java.lang.String mainDepartmentProcessId,
        java.lang.String tuNgay, java.lang.String denNgay,
        java.lang.String listUserId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator order)
        throws com.liferay.portal.SystemException {
        return getService()
                   .findBy_isPublic_mainDepartmentProcessId_Date(isPublic,
            mainDepartmentProcessId, tuNgay, denNgay, listUserId, start, end,
            order);
    }

    public static int countBy_isPublic_mainDepartmentProcessId_Date(
        java.lang.String isPublic, java.lang.String mainDepartmentProcessId,
        java.lang.String tuNgay, java.lang.String denNgay,
        java.lang.String listUserId) throws com.liferay.portal.SystemException {
        return getService()
                   .countBy_isPublic_mainDepartmentProcessId_Date(isPublic,
            mainDepartmentProcessId, tuNgay, denNgay, listUserId);
    }

    public static int countByNumberDocumentReceipt(
        java.lang.String numberDocumentReceipt, int issuingYear,
        long documentReceiptId) throws com.liferay.portal.SystemException {
        return getService()
                   .countByNumberDocumentReceipt(numberDocumentReceipt,
            issuingYear, documentReceiptId);
    }

    public static int countByDocumentReference(
        java.lang.String documentReference, int issuingYear,
        long documentReceiptId) throws com.liferay.portal.SystemException {
        return getService()
                   .countByDocumentReference(documentReference, issuingYear,
            documentReceiptId);
    }

    public static PmlEdmDocumentReceiptLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "PmlEdmDocumentReceiptLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlEdmDocumentReceiptLocalService service) {
        _service = service;
    }
}
