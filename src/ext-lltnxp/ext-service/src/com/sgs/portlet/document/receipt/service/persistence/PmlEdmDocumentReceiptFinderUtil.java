package com.sgs.portlet.document.receipt.service.persistence;

public class PmlEdmDocumentReceiptFinderUtil {
    private static PmlEdmDocumentReceiptFinder _finder;

    public static java.util.List<com.liferay.portal.model.User> getSortedListUser()
        throws com.liferay.portal.SystemException {
        return getFinder().getSortedListUser();
    }

    public static java.util.List<com.liferay.portal.model.User> getSortedListUser(
        int start, int end) throws java.lang.Exception {
        return getFinder().getSortedListUser(start, end);
    }

    public static int countByDocumentReceipt_Users(
        java.util.List<Long> userIds, java.lang.String capGui,
        java.lang.String loaisocongvan) throws java.lang.Exception {
        return getFinder()
                   .countByDocumentReceipt_Users(userIds, capGui, loaisocongvan);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByDocumentReceipt_Users(
        java.util.List<Long> userIds, java.lang.String capGui,
        java.lang.String loaisocongvan, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .findByDocumentReceipt_Users(userIds, capGui, loaisocongvan,
            start, end, obc);
    }

    public static int countByDocumentReceipt_Users_Status_DangXuLy(
        java.util.List<Long> userIds, long statusId, java.lang.String soCVDen,
        java.lang.String capGui) throws java.lang.Exception {
        return getFinder()
                   .countByDocumentReceipt_Users_Status_DangXuLy(userIds,
            statusId, soCVDen, capGui);
    }

    public static int countByDocumentReceipt_Users_Status_DangXuLy(
        java.util.List<Long> userIds, long statusId, java.lang.String soCVDen,
        java.lang.String capGui, java.lang.String cachThucXuLy)
        throws java.lang.Exception {
        return getFinder()
                   .countByDocumentReceipt_Users_Status_DangXuLy(userIds,
            statusId, soCVDen, capGui, cachThucXuLy);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByDocumentReceipt_Users_Status_DangXuLy(
        java.util.List<Long> userIds, long statusId, java.lang.String soCVDen,
        java.lang.String capGui, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .findByDocumentReceipt_Users_Status_DangXuLy(userIds,
            statusId, soCVDen, capGui, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByDocumentReceipt_Users_Status_DangXuLy(
        java.util.List<Long> userIds, long statusId, java.lang.String soCVDen,
        java.lang.String capGui, java.lang.String cachThucXuLy, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .findByDocumentReceipt_Users_Status_DangXuLy(userIds,
            statusId, soCVDen, capGui, cachThucXuLy, start, end, obc);
    }

    public static int countByDocumentReceipt_Users_Status_DangXuLy_TreHan(
        java.util.List<Long> userIds, long statusId, java.lang.String soCVDen,
        java.lang.String capGui) throws java.lang.Exception {
        return getFinder()
                   .countByDocumentReceipt_Users_Status_DangXuLy_TreHan(userIds,
            statusId, soCVDen, capGui);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByDocumentReceipt_Users_Status_DangXuLy_TreHan(
        java.util.List<Long> userIds, long statusId, java.lang.String soCVDen,
        java.lang.String capGui, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .findByDocumentReceipt_Users_Status_DangXuLy_TreHan(userIds,
            statusId, soCVDen, capGui, start, end, obc);
    }

    public static int countByDocumentReceipt_Users_Status_DaXuLy(
        java.util.List<Long> userIds, long statusId, int year,
        java.lang.String soCVDen, java.lang.String capGui)
        throws java.lang.Exception {
        return getFinder()
                   .countByDocumentReceipt_Users_Status_DaXuLy(userIds,
            statusId, year, soCVDen, capGui);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByDocumentReceipt_Users_Status_DaXuLy(
        java.util.List<Long> userIds, long statusId, int year,
        java.lang.String soCVDen, java.lang.String capGui, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .findByDocumentReceipt_Users_Status_DaXuLy(userIds,
            statusId, year, soCVDen, capGui, start, end, obc);
    }

    public static int countByDocumentReceipt_Users_Status_DaXuLy_TreHan(
        java.util.List<Long> userIds, long statusId, int year,
        java.lang.String soCVDen, java.lang.String capGui)
        throws java.lang.Exception {
        return getFinder()
                   .countByDocumentReceipt_Users_Status_DaXuLy_TreHan(userIds,
            statusId, year, soCVDen, capGui);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findByDocumentReceipt_Users_Status_DaXuLy_TreHan(
        java.util.List<Long> userIds, long statusId, int year,
        java.lang.String soCVDen, java.lang.String capGui, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .findByDocumentReceipt_Users_Status_DaXuLy_TreHan(userIds,
            statusId, year, soCVDen, capGui, start, end, obc);
    }

    public static int countByS_L_N_S_N_T_D_D_S_T(java.lang.String soCVDen,
        java.lang.String soVaoSo, java.lang.String tuNgay,
        java.lang.String denNgay, long soHSCV, long loaiCV,
        java.lang.String noiPhatHanh, long trangThai, java.lang.String nguoiKy,
        java.lang.String trichYeu) throws java.lang.Exception {
        return getFinder()
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
        return getFinder()
                   .findByS_L_N_S_N_T_D_D_S_T(soCVDen, soVaoSo, tuNgay,
            denNgay, soHSCV, loaiCV, noiPhatHanh, trangThai, nguoiKy, trichYeu,
            start, end, obc);
    }

    public static int countTonDauKyChuyenVien_CVDen(long userId,
        int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getFinder()
                   .countTonDauKyChuyenVien_CVDen(userId, documentRecordTypeId,
            capGui, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listTonDauKyChuyenVien_CVDen(
        long userId, int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .listTonDauKyChuyenVien_CVDen(userId, documentRecordTypeId,
            capGui, loaiVB, doMat, fromDate, toDate, start, end, obc);
    }

    public static int countNhanTrongKyChuyenVien_CVDen(long userId,
        int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getFinder()
                   .countNhanTrongKyChuyenVien_CVDen(userId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listNhanTrongKyChuyenVien_CVDen(
        long userId, int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .listNhanTrongKyChuyenVien_CVDen(userId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate,
            start, end, obc);
    }

    public static int countChuaNhanChuyenVien_CVDen(long userId,
        int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getFinder()
                   .countChuaNhanChuyenVien_CVDen(userId, documentRecordTypeId,
            capGui, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listChuaNhanChuyenVien_CVDen(
        long userId, int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .listChuaNhanChuyenVien_CVDen(userId, documentRecordTypeId,
            capGui, loaiVB, doMat, fromDate, toDate, start, end, obc);
    }

    public static int countNhanTrongThangChuyenVien_CVDen(long userId,
        int documentRecordTypeId, int capGui, int loaiVB,
        java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getFinder()
                   .countNhanTrongThangChuyenVien_CVDen(userId,
            documentRecordTypeId, capGui, loaiVB, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listNhanTrongThangChuyenVien_CVDen(
        long userId, int documentRecordTypeId, int capGui, int loaiVB,
        java.util.Date fromDate, java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .listNhanTrongThangChuyenVien_CVDen(userId,
            documentRecordTypeId, capGui, loaiVB, fromDate, toDate, start, end,
            obc);
    }

    public static int countDungHanDaXuLyChuyenVien_CVDen(long userId,
        int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getFinder()
                   .countDungHanDaXuLyChuyenVien_CVDen(userId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listDungHanDaXuLyChuyenVien_CVDen(
        long userId, int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .listDungHanDaXuLyChuyenVien_CVDen(userId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate,
            start, end, obc);
    }

    public static int countTreHanDaXuLyChuyenVien_CVDen(long userId,
        int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getFinder()
                   .countTreHanDaXuLyChuyenVien_CVDen(userId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listTreHanDaXuLyChuyenVien_CVDen(
        long userId, int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .listTreHanDaXuLyChuyenVien_CVDen(userId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate,
            start, end, obc);
    }

    public static int countTongDaXuLyChuyenVien_CVDen(long userId,
        int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getFinder()
                   .countTongDaXuLyChuyenVien_CVDen(userId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listTongDaXuLyChuyenVien_CVDen(
        long userId, int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .listTongDaXuLyChuyenVien_CVDen(userId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate,
            start, end, obc);
    }

    public static int countDungHanDangXuLyChuyenVien_CVDen(long userId,
        int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getFinder()
                   .countDungHanDangXuLyChuyenVien_CVDen(userId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listDungHanDangXuLyChuyenVien_CVDen(
        long userId, int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .listDungHanDangXuLyChuyenVien_CVDen(userId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate,
            start, end, obc);
    }

    public static int countTreHanDangXuLyChuyenVien_CVDen(long userId,
        int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getFinder()
                   .countTreHanDangXuLyChuyenVien_CVDen(userId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listTreHanDangXuLyChuyenVien_CVDen(
        long userId, int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .listTreHanDangXuLyChuyenVien_CVDen(userId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate,
            start, end, obc);
    }

    public static int countTongDangXuLyChuyenVien_CVDen(long userId,
        int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getFinder()
                   .countTongDangXuLyChuyenVien_CVDen(userId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listTongDangXuLyChuyenVien_CVDen(
        long userId, int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .listTongDangXuLyChuyenVien_CVDen(userId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate,
            start, end, obc);
    }

    public static int countDocRecNeedProcess(long userId)
        throws com.liferay.portal.SystemException {
        return getFinder().countDocRecNeedProcess(userId);
    }

    public static int countTonDauKyPhongBan_CVDen(
        java.lang.String departmentId, int documentRecordTypeId, int capGui,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate) throws java.lang.Exception {
        return getFinder()
                   .countTonDauKyPhongBan_CVDen(departmentId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listTonDauKyPhongBan_CVDen(
        java.lang.String departmentId, int documentRecordTypeId, int capGui,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .listTonDauKyPhongBan_CVDen(departmentId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate,
            start, end, obc);
    }

    public static int countNhanTrongKyPhongBan_CVDen(
        java.lang.String departmentId, int documentRecordTypeId, int capGui,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate) throws java.lang.Exception {
        return getFinder()
                   .countNhanTrongKyPhongBan_CVDen(departmentId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listNhanTrongKyPhongBan_CVDen(
        java.lang.String departmentId, int documentRecordTypeId, int capGui,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .listNhanTrongKyPhongBan_CVDen(departmentId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate,
            start, end, obc);
    }

    public static int countChuaNhanTrongKyPhongBan_CVDen(
        java.lang.String departmentId, int documentRecordTypeId, int capGui,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate) throws java.lang.Exception {
        return getFinder()
                   .countChuaNhanTrongKyPhongBan_CVDen(departmentId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listChuaNhanTrongKyPhongBan_CVDen(
        java.lang.String departmentId, int documentRecordTypeId, int capGui,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .listChuaNhanTrongKyPhongBan_CVDen(departmentId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate,
            start, end, obc);
    }

    public static int countDungHanDaXuLyPhongBan_CVDen(
        java.lang.String departmentId, int documentRecordTypeId, int capGui,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate) throws java.lang.Exception {
        return getFinder()
                   .countDungHanDaXuLyPhongBan_CVDen(departmentId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listDungHanDaXuLyPhongBan_CVDen(
        java.lang.String departmentId, int documentRecordTypeId, int capGui,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .listDungHanDaXuLyPhongBan_CVDen(departmentId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate,
            start, end, obc);
    }

    public static int countTreHanDaXuLyPhongBan_CVDen(
        java.lang.String departmentId, int documentRecordTypeId, int capGui,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate) throws java.lang.Exception {
        return getFinder()
                   .countTreHanDaXuLyPhongBan_CVDen(departmentId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listTreHanDaXuLyPhongBan_CVDen(
        java.lang.String departmentId, int documentRecordTypeId, int capGui,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .listTreHanDaXuLyPhongBan_CVDen(departmentId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate,
            start, end, obc);
    }

    public static int countTongDaXuLyPhongBan_CVDen(
        java.lang.String departmentId, int documentRecordTypeId, int capGui,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate) throws java.lang.Exception {
        return getFinder()
                   .countTongDaXuLyPhongBan_CVDen(departmentId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listTongDaXuLyPhongBan_CVDen(
        java.lang.String departmentId, int documentRecordTypeId, int capGui,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .listTongDaXuLyPhongBan_CVDen(departmentId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate,
            start, end, obc);
    }

    public static int countDungHanDangXuLyPhongBan_CVDen(
        java.lang.String departmentId, int documentRecordTypeId, int capGui,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate) throws java.lang.Exception {
        return getFinder()
                   .countDungHanDangXuLyPhongBan_CVDen(departmentId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listDungHanDangXuLyPhongBan_CVDen(
        java.lang.String departmentId, int documentRecordTypeId, int capGui,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .listDungHanDangXuLyPhongBan_CVDen(departmentId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate,
            start, end, obc);
    }

    public static int countTreHanDangXuLyPhongBan_CVDen(
        java.lang.String departmentId, int documentRecordTypeId, int capGui,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate) throws java.lang.Exception {
        return getFinder()
                   .countTreHanDangXuLyPhongBan_CVDen(departmentId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listTreHanDangXuLyPhongBan_CVDen(
        java.lang.String departmentId, int documentRecordTypeId, int capGui,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .listTreHanDangXuLyPhongBan_CVDen(departmentId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate,
            start, end, obc);
    }

    public static int countTongDangXuLyPhongBan_CVDen(
        java.lang.String departmentId, int documentRecordTypeId, int capGui,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate) throws java.lang.Exception {
        return getFinder()
                   .countTongDangXuLyPhongBan_CVDen(departmentId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listTongDangXuLyPhongBan_CVDen(
        java.lang.String departmentId, int documentRecordTypeId, int capGui,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .listTongDangXuLyPhongBan_CVDen(departmentId,
            documentRecordTypeId, capGui, loaiVB, doMat, fromDate, toDate,
            start, end, obc);
    }

    public static int countTonDauKySo_CVDen(int documentRecordTypeId,
        int capGui, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getFinder()
                   .countTonDauKySo_CVDen(documentRecordTypeId, capGui, loaiVB,
            doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listTonDauKySo_CVDen(
        int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .listTonDauKySo_CVDen(documentRecordTypeId, capGui, loaiVB,
            doMat, fromDate, toDate, start, end, obc);
    }

    public static int countNhanTrongKySo_CVDen(int documentRecordTypeId,
        int capGui, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getFinder()
                   .countNhanTrongKySo_CVDen(documentRecordTypeId, capGui,
            loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listNhanTrongKySo_CVDen(
        int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .listNhanTrongKySo_CVDen(documentRecordTypeId, capGui,
            loaiVB, doMat, fromDate, toDate, start, end, obc);
    }

    public static int countDungHanDaXuLySo_CVDen(int documentRecordTypeId,
        int capGui, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getFinder()
                   .countDungHanDaXuLySo_CVDen(documentRecordTypeId, capGui,
            loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listDungHanDaXuLySo_CVDen(
        int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .listDungHanDaXuLySo_CVDen(documentRecordTypeId, capGui,
            loaiVB, doMat, fromDate, toDate, start, end, obc);
    }

    public static int countTreHanDaXuLySo_CVDen(int documentRecordTypeId,
        int capGui, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getFinder()
                   .countTreHanDaXuLySo_CVDen(documentRecordTypeId, capGui,
            loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listTreHanDaXuLySo_CVDen(
        int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .listTreHanDaXuLySo_CVDen(documentRecordTypeId, capGui,
            loaiVB, doMat, fromDate, toDate, start, end, obc);
    }

    public static int countTongDaXuLySo_CVDen(int documentRecordTypeId,
        int capGui, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getFinder()
                   .countTongDaXuLySo_CVDen(documentRecordTypeId, capGui,
            loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listTongDaXuLySo_CVDen(
        int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .listTongDaXuLySo_CVDen(documentRecordTypeId, capGui,
            loaiVB, doMat, fromDate, toDate, start, end, obc);
    }

    public static int countDungHanDangXuLySo_CVDen(int documentRecordTypeId,
        int capGui, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getFinder()
                   .countDungHanDangXuLySo_CVDen(documentRecordTypeId, capGui,
            loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listDungHanDangXuLySo_CVDen(
        int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .listDungHanDangXuLySo_CVDen(documentRecordTypeId, capGui,
            loaiVB, doMat, fromDate, toDate, start, end, obc);
    }

    public static int countTreHanDangXuLySo_CVDen(int documentRecordTypeId,
        int capGui, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getFinder()
                   .countTreHanDangXuLySo_CVDen(documentRecordTypeId, capGui,
            loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listTreHanDangXuLySo_CVDen(
        int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .listTreHanDangXuLySo_CVDen(documentRecordTypeId, capGui,
            loaiVB, doMat, fromDate, toDate, start, end, obc);
    }

    public static int countTongDangXuLySo_CVDen(int documentRecordTypeId,
        int capGui, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getFinder()
                   .countTongDangXuLySo_CVDen(documentRecordTypeId, capGui,
            loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> listTongDangXuLySo_CVDen(
        int documentRecordTypeId, int capGui, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .listTongDangXuLySo_CVDen(documentRecordTypeId, capGui,
            loaiVB, doMat, fromDate, toDate, start, end, obc);
    }

    public static int countBy_Date_N_C(java.lang.String dateNow,
        java.lang.String dateCalen) throws com.liferay.portal.SystemException {
        return getFinder().countBy_Date_N_C(dateNow, dateCalen);
    }

    public static int getGeneralNumberDocumentReceipt(
        java.lang.String ddmmyyyyReceiveDate)
        throws com.liferay.portal.SystemException {
        return getFinder().getGeneralNumberDocumentReceipt(ddmmyyyyReceiveDate);
    }

    public static long getMaxDocumentReceiptId()
        throws com.liferay.portal.SystemException {
        return getFinder().getMaxDocumentReceiptId();
    }

    public static int countByDocrefIssyearArrYear(java.lang.String docRef,
        int issuingYear, boolean findIssuingYear, int arriveYear,
        boolean findArriveYear) throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByDocrefIssyearArrYear(docRef, issuingYear,
            findIssuingYear, arriveYear, findArriveYear);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> getListCVDenDaXuLyChung(
        long userId, java.lang.String year, java.lang.String capGui,
        java.lang.String loaisocongvan, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .getListCVDenDaXuLyChung(userId, year, capGui,
            loaisocongvan, start, end, obc);
    }

    public static int countListCVDenDaXuLyChung(long userId,
        java.lang.String year, java.lang.String capGui,
        java.lang.String loaisocongvan)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countListCVDenDaXuLyChung(userId, year, capGui,
            loaisocongvan);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> getListCVDenDaXuLyTuXuLy(
        long userId, java.lang.String year, java.lang.String capGui,
        java.lang.String loaisocongvan, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .getListCVDenDaXuLyTuXuLy(userId, year, capGui,
            loaisocongvan, start, end, obc);
    }

    public static int countListCVDenDaXuLyTuXuLy(long userId,
        java.lang.String year, java.lang.String capGui,
        java.lang.String loaisocongvan)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countListCVDenDaXuLyTuXuLy(userId, year, capGui,
            loaisocongvan);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> getListCVDenDaXuLyChung_treHan(
        long userId, java.lang.String year, java.lang.String capGui,
        java.lang.String loaisocongvan, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .getListCVDenDaXuLyChung_treHan(userId, year, capGui,
            loaisocongvan, start, end, obc);
    }

    public static int countListCVDenDaXuLyChung_treHan(long userId,
        java.lang.String year, java.lang.String capGui,
        java.lang.String loaisocongvan)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countListCVDenDaXuLyChung_treHan(userId, year, capGui,
            loaisocongvan);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> getListCVDenDaXuLyTuXuLy_treHan(
        long userId, java.lang.String year, java.lang.String capGui,
        java.lang.String loaisocongvan, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .getListCVDenDaXuLyTuXuLy_treHan(userId, year, capGui,
            loaisocongvan, start, end, obc);
    }

    public static int countListCVDenDaXuLyTuXuLy_treHan(long userId,
        java.lang.String year, java.lang.String capGui,
        java.lang.String loaisocongvan)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countListCVDenDaXuLyTuXuLy_treHan(userId, year, capGui,
            loaisocongvan);
    }

    public static int countByN_D_I_L_I_P_D_D_D_B(java.lang.String soNoiBo,
        java.lang.String soHieuGoc, int ngayPHDay, int ngayPHMonth,
        int ngayPHYear, long capGui, java.lang.String noiPhatHanh,
        java.lang.String uuTien, int ngayDenDay, int ngayDenMonth,
        int ngayDenYear, long loaiVB, java.lang.String phongBan,
        java.lang.String trichYeu) throws com.liferay.portal.SystemException {
        return getFinder()
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
        return getFinder()
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
        return getFinder()
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
        return getFinder()
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
        return getFinder()
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
        return getFinder()
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
        return getFinder()
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
        return getFinder()
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
        return getFinder()
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
        return getFinder()
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
        return getFinder()
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
        return getFinder()
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
        return getFinder()
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
        return getFinder()
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
        return getFinder()
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
        return getFinder()
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
        return getFinder()
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
        return getFinder()
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
        return getFinder()
                   .findByDocumentReceiptLog_Users(userIds, soVBDen, soHieuGoc,
            loaiSoVanBan, issuingplaceId, noiBanHanh, trichYeu, tuNgay,
            denNgay, start, end, obc);
    }

    public static int countBy_isPublic_mainDepartmentProcessId_Date(
        java.lang.String isPublic, java.lang.String mainDepartmentProcessId,
        java.lang.String tuNgay, java.lang.String denNgay,
        java.lang.String listUserId) throws com.liferay.portal.SystemException {
        return getFinder()
                   .countBy_isPublic_mainDepartmentProcessId_Date(isPublic,
            mainDepartmentProcessId, tuNgay, denNgay, listUserId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findBy_isPublic_mainDepartmentProcessId_Date(
        java.lang.String isPublic, java.lang.String mainDepartmentProcessId,
        java.lang.String tuNgay, java.lang.String denNgay,
        java.lang.String listUserId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator order)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findBy_isPublic_mainDepartmentProcessId_Date(isPublic,
            mainDepartmentProcessId, tuNgay, denNgay, listUserId, start, end,
            order);
    }

    public static int countByNumberDocumentReceipt(
        java.lang.String numberDocumentReceipt, int issuingYear,
        long documentReceiptId) throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByNumberDocumentReceipt(numberDocumentReceipt,
            issuingYear, documentReceiptId);
    }

    public static int countByDocumentReference(
        java.lang.String documentReference, int issuingYear,
        long documentReceiptId) throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByDocumentReference(documentReference, issuingYear,
            documentReceiptId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> findBy_R_B_F_T(
        java.lang.String documentReference, java.lang.String briefContent,
        java.util.Date fromDate, java.util.Date toDate, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findBy_R_B_F_T(documentReference, briefContent, fromDate,
            toDate, andOperator, start, end, obc);
    }

    public static int countBy_R_B_F_T(java.lang.String documentReference,
        java.lang.String briefContent, java.util.Date fromDate,
        java.util.Date toDate, boolean andOperator) {
        return getFinder()
                   .countBy_R_B_F_T(documentReference, briefContent, fromDate,
            toDate, andOperator);
    }

    public static PmlEdmDocumentReceiptFinder getFinder() {
        return _finder;
    }

    public void setFinder(PmlEdmDocumentReceiptFinder finder) {
        _finder = finder;
    }
}
