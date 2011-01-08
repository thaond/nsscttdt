package com.sgs.portlet.document.send.service.persistence;

public class PmlEdmDocumentSendFinderUtil {
    private static PmlEdmDocumentSendFinder _finder;

    public static int countByS_L_T_P_N_N_TN_DN_S_T(
        java.lang.String soPhatHanh, long loaiCongVan,
        java.lang.String traLoiCongVanSo, java.lang.String phongSoanThao,
        java.lang.String noiNhan, long nguoiKy, java.lang.String tuNgay,
        java.lang.String denNgay, long soHSCV, java.lang.String trichYeu)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByS_L_T_P_N_N_TN_DN_S_T(soPhatHanh, loaiCongVan,
            traLoiCongVanSo, phongSoanThao, noiNhan, nguoiKy, tuNgay, denNgay,
            soHSCV, trichYeu);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByS_L_T_P_N_N_TN_DN_S_T(
        java.lang.String soPhatHanh, long loaiCongVan,
        java.lang.String traLoiCongVanSo, java.lang.String phongSoanThao,
        java.lang.String noiNhan, long nguoiKy, java.lang.String tuNgay,
        java.lang.String denNgay, long soHSCV, java.lang.String trichYeu,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByS_L_T_P_N_N_TN_DN_S_T(soPhatHanh, loaiCongVan,
            traLoiCongVanSo, phongSoanThao, noiNhan, nguoiKy, tuNgay, denNgay,
            soHSCV, trichYeu, start, end, obc);
    }

    public static int countDocSendNeedProcess(long userId)
        throws com.liferay.portal.SystemException {
        return getFinder().countDocSendNeedProcess(userId);
    }

    public static int countByDocumentSend_Users(java.util.List<Long> userIds,
        java.lang.String loaisocongvan) throws java.lang.Exception {
        return getFinder().countByDocumentSend_Users(userIds, loaisocongvan);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByDocumentSend_Users(
        java.util.List<Long> userIds, java.lang.String loaisocongvan,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .findByDocumentSend_Users(userIds, loaisocongvan, start,
            end, obc);
    }

    public static int countByDocumentSend_Users_Status_DangXuLy(
        java.util.List<Long> userIds, long statusId,
        java.lang.String loaisocongvan, java.lang.String capGui)
        throws java.lang.Exception {
        return getFinder()
                   .countByDocumentSend_Users_Status_DangXuLy(userIds,
            statusId, loaisocongvan, capGui);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByDocumentSend_Users_Status_DangXuLy(
        java.util.List<Long> userIds, long statusId,
        java.lang.String loaisocongvan, java.lang.String capGui, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .findByDocumentSend_Users_Status_DangXuLy(userIds, statusId,
            loaisocongvan, capGui, start, end, obc);
    }

    public static int countByDocumentSend_Users_Status_DangXuLy_TreHan(
        java.util.List<Long> userIds, long statusId,
        java.lang.String loaisocongvan, java.lang.String capGui)
        throws java.lang.Exception {
        return getFinder()
                   .countByDocumentSend_Users_Status_DangXuLy_TreHan(userIds,
            statusId, loaisocongvan, capGui);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByDocumentSend_Users_Status_DangXuLy_TreHan(
        java.util.List<Long> userIds, long statusId,
        java.lang.String loaisocongvan, java.lang.String capGui, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .findByDocumentSend_Users_Status_DangXuLy_TreHan(userIds,
            statusId, loaisocongvan, capGui, start, end, obc);
    }

    public static int countDocumentType(int documentTypeId,
        java.lang.String abbreviateName)
        throws com.liferay.portal.SystemException {
        return getFinder().countDocumentType(documentTypeId, abbreviateName);
    }

    public static long getMaxDocumentSendId()
        throws com.liferay.portal.SystemException {
        return getFinder().getMaxDocumentSendId();
    }

    public static long getMaxDocRefByTypeYear(long docTypeId, int issuingYear)
        throws com.liferay.portal.SystemException {
        return getFinder().getMaxDocRefByTypeYear(docTypeId, issuingYear);
    }

    public static int countTonDauKyChuyenVien_CVDi(long userId,
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getFinder()
                   .countTonDauKyChuyenVien_CVDi(userId, documentRecordTypeId,
            loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listTonDauKyChuyenVien_CVDi(
        long userId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .listTonDauKyChuyenVien_CVDi(userId, documentRecordTypeId,
            loaiVB, doMat, fromDate, toDate, start, end, obc);
    }

    public static int countNhanTrongKyChuyenVien_CVDi(long userId,
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getFinder()
                   .countNhanTrongKyChuyenVien_CVDi(userId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listNhanTrongKyChuyenVien_CVDi(
        long userId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .listNhanTrongKyChuyenVien_CVDi(userId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate, start, end,
            obc);
    }

    public static int countChuaNhanChuyenVien_CVDi(long userId,
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getFinder()
                   .countChuaNhanChuyenVien_CVDi(userId, documentRecordTypeId,
            loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listChuaNhanChuyenVien_CVDi(
        long userId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .listChuaNhanChuyenVien_CVDi(userId, documentRecordTypeId,
            loaiVB, doMat, fromDate, toDate, start, end, obc);
    }

    public static int countNhanTrongThangChuyenVien_CVDi(long userId,
        int documentRecordTypeId, int loaiVB, java.util.Date fromDate,
        java.util.Date toDate) throws java.lang.Exception {
        return getFinder()
                   .countNhanTrongThangChuyenVien_CVDi(userId,
            documentRecordTypeId, loaiVB, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listNhanTrongThangChuyenVien_CVDi(
        long userId, int documentRecordTypeId, int loaiVB,
        java.util.Date fromDate, java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .listNhanTrongThangChuyenVien_CVDi(userId,
            documentRecordTypeId, loaiVB, fromDate, toDate, start, end, obc);
    }

    public static int countDungHanDaXuLyChuyenVien_CVDi(long userId,
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getFinder()
                   .countDungHanDaXuLyChuyenVien_CVDi(userId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listDungHanDaXuLyChuyenVien_CVDi(
        long userId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .listDungHanDaXuLyChuyenVien_CVDi(userId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate, start, end,
            obc);
    }

    public static int countTreHanDaXuLyChuyenVien_CVDi(long userId,
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getFinder()
                   .countTreHanDaXuLyChuyenVien_CVDi(userId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listTreHanDaXuLyChuyenVien_CVDi(
        long userId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .listTreHanDaXuLyChuyenVien_CVDi(userId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate, start, end,
            obc);
    }

    public static int countTongDaXuLyChuyenVien_CVDi(long userId,
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getFinder()
                   .countTongDaXuLyChuyenVien_CVDi(userId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listTongDaXuLyChuyenVien_CVDi(
        long userId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .listTongDaXuLyChuyenVien_CVDi(userId, documentRecordTypeId,
            loaiVB, doMat, fromDate, toDate, start, end, obc);
    }

    public static int countDungHanDangXuLyChuyenVien_CVDi(long userId,
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getFinder()
                   .countDungHanDangXuLyChuyenVien_CVDi(userId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listDungHanDangXuLyChuyenVien_CVDi(
        long userId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .listDungHanDangXuLyChuyenVien_CVDi(userId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate, start, end,
            obc);
    }

    public static int countTreHanDangXuLyChuyenVien_CVDi(long userId,
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getFinder()
                   .countTreHanDangXuLyChuyenVien_CVDi(userId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listTreHanDangXuLyChuyenVien_CVDi(
        long userId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .listTreHanDangXuLyChuyenVien_CVDi(userId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate, start, end,
            obc);
    }

    public static int countTongDangXuLyChuyenVien_CVDi(long userId,
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getFinder()
                   .countTongDangXuLyChuyenVien_CVDi(userId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listTongDangXuLyChuyenVien_CVDi(
        long userId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .listTongDangXuLyChuyenVien_CVDi(userId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate, start, end,
            obc);
    }

    public static int countTonDauKyPhongBan_CVDi(
        java.lang.String departmentId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getFinder()
                   .countTonDauKyPhongBan_CVDi(departmentId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listTonDauKyPhongBan_CVDi(
        java.lang.String departmentId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .listTonDauKyPhongBan_CVDi(departmentId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate, start, end,
            obc);
    }

    public static int countNhanTrongKyPhongBan_CVDi(
        java.lang.String departmentId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getFinder()
                   .countNhanTrongKyPhongBan_CVDi(departmentId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listNhanTrongKyPhongBan_CVDi(
        java.lang.String departmentId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .listNhanTrongKyPhongBan_CVDi(departmentId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate, start, end,
            obc);
    }

    public static int countChuaNhanTrongKyPhongBan_CVDi(
        java.lang.String departmentId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getFinder()
                   .countChuaNhanTrongKyPhongBan_CVDi(departmentId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listChuaNhanTrongKyPhongBan_CVDi(
        java.lang.String departmentId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .listChuaNhanTrongKyPhongBan_CVDi(departmentId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate, start, end,
            obc);
    }

    public static int countDungHanDaXuLyPhongBan_CVDi(
        java.lang.String departmentId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getFinder()
                   .countDungHanDaXuLyPhongBan_CVDi(departmentId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listDungHanDaXuLyPhongBan_CVDi(
        java.lang.String departmentId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .listDungHanDaXuLyPhongBan_CVDi(departmentId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate, start, end,
            obc);
    }

    public static int countTreHanDaXuLyPhongBan_CVDi(
        java.lang.String departmentId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getFinder()
                   .countTreHanDaXuLyPhongBan_CVDi(departmentId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listTreHanDaXuLyPhongBan_CVDi(
        java.lang.String departmentId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .listTreHanDaXuLyPhongBan_CVDi(departmentId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate, start, end,
            obc);
    }

    public static int countTongDaXuLyPhongBan_CVDi(
        java.lang.String departmentId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getFinder()
                   .countTongDaXuLyPhongBan_CVDi(departmentId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listTongDaXuLyPhongBan_CVDi(
        java.lang.String departmentId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .listTongDaXuLyPhongBan_CVDi(departmentId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate, start, end,
            obc);
    }

    public static int countDungHanDangXuLyPhongBan_CVDi(
        java.lang.String departmentId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getFinder()
                   .countDungHanDangXuLyPhongBan_CVDi(departmentId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listDungHanDangXuLyPhongBan_CVDi(
        java.lang.String departmentId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .listDungHanDangXuLyPhongBan_CVDi(departmentId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate, start, end,
            obc);
    }

    public static int countTreHanDangXuLyPhongBan_CVDi(
        java.lang.String departmentId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getFinder()
                   .countTreHanDangXuLyPhongBan_CVDi(departmentId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listTreHanDangXuLyPhongBan_CVDi(
        java.lang.String departmentId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .listTreHanDangXuLyPhongBan_CVDi(departmentId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate, start, end,
            obc);
    }

    public static int countTongDangXuLyPhongBan_CVDi(
        java.lang.String departmentId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getFinder()
                   .countTongDangXuLyPhongBan_CVDi(departmentId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listTongDangXuLyPhongBan_CVDi(
        java.lang.String departmentId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .listTongDangXuLyPhongBan_CVDi(departmentId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate, start, end,
            obc);
    }

    public static int countTonDauKySo_CVDi(int documentRecordTypeId,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate) throws java.lang.Exception {
        return getFinder()
                   .countTonDauKySo_CVDi(documentRecordTypeId, loaiVB, doMat,
            fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listTonDauKySo_CVDi(
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .listTonDauKySo_CVDi(documentRecordTypeId, loaiVB, doMat,
            fromDate, toDate, start, end, obc);
    }

    public static int countNhanTrongKySo_CVDi(int documentRecordTypeId,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate) throws java.lang.Exception {
        return getFinder()
                   .countNhanTrongKySo_CVDi(documentRecordTypeId, loaiVB,
            doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listNhanTrongKySo_CVDi(
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .listNhanTrongKySo_CVDi(documentRecordTypeId, loaiVB, doMat,
            fromDate, toDate, start, end, obc);
    }

    public static int countDungHanDaXuLySo_CVDi(int documentRecordTypeId,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate) throws java.lang.Exception {
        return getFinder()
                   .countDungHanDaXuLySo_CVDi(documentRecordTypeId, loaiVB,
            doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listDungHanDaXuLySo_CVDi(
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .listDungHanDaXuLySo_CVDi(documentRecordTypeId, loaiVB,
            doMat, fromDate, toDate, start, end, obc);
    }

    public static int countTreHanDaXuLySo_CVDi(int documentRecordTypeId,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate) throws java.lang.Exception {
        return getFinder()
                   .countTreHanDaXuLySo_CVDi(documentRecordTypeId, loaiVB,
            doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listTreHanDaXuLySo_CVDi(
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .listTreHanDaXuLySo_CVDi(documentRecordTypeId, loaiVB,
            doMat, fromDate, toDate, start, end, obc);
    }

    public static int countTongDaXuLySo_CVDi(int documentRecordTypeId,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate) throws java.lang.Exception {
        return getFinder()
                   .countTongDaXuLySo_CVDi(documentRecordTypeId, loaiVB, doMat,
            fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listTongDaXuLySo_CVDi(
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .listTongDaXuLySo_CVDi(documentRecordTypeId, loaiVB, doMat,
            fromDate, toDate, start, end, obc);
    }

    public static int countDungHanDangXuLySo_CVDi(int documentRecordTypeId,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate) throws java.lang.Exception {
        return getFinder()
                   .countDungHanDangXuLySo_CVDi(documentRecordTypeId, loaiVB,
            doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listDungHanDangXuLySo_CVDi(
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .listDungHanDangXuLySo_CVDi(documentRecordTypeId, loaiVB,
            doMat, fromDate, toDate, start, end, obc);
    }

    public static int countTreHanDangXuLySo_CVDi(int documentRecordTypeId,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate) throws java.lang.Exception {
        return getFinder()
                   .countTreHanDangXuLySo_CVDi(documentRecordTypeId, loaiVB,
            doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listTreHanDangXuLySo_CVDi(
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .listTreHanDangXuLySo_CVDi(documentRecordTypeId, loaiVB,
            doMat, fromDate, toDate, start, end, obc);
    }

    public static int countTongDangXuLySo_CVDi(int documentRecordTypeId,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate) throws java.lang.Exception {
        return getFinder()
                   .countTongDangXuLySo_CVDi(documentRecordTypeId, loaiVB,
            doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listTongDangXuLySo_CVDi(
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .listTongDangXuLySo_CVDi(documentRecordTypeId, loaiVB,
            doMat, fromDate, toDate, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> getListPmlEdmDocumentSend(
        int loaiSoCongVan, java.lang.String fromDate, java.lang.String toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .getListPmlEdmDocumentSend(loaiSoCongVan, fromDate, toDate,
            start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> getListPmlEdmDocumentSendByLoaiSoCV(
        java.lang.String loaiSoCongVan, java.lang.String fromDate,
        java.lang.String toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .getListPmlEdmDocumentSendByLoaiSoCV(loaiSoCongVan,
            fromDate, toDate, start, end, obc);
    }

    public static int countListPmlEdmDocumentSendByLoaiSoCV(
        java.lang.String loaiSoCongVan, java.lang.String fromDate,
        java.lang.String toDate) throws com.liferay.portal.SystemException {
        return getFinder()
                   .countListPmlEdmDocumentSendByLoaiSoCV(loaiSoCongVan,
            fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> getListCVDiDaXuLyChung(
        long userId, java.lang.String year, java.lang.String loaisocongvan,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .getListCVDiDaXuLyChung(userId, year, loaisocongvan, start,
            end, obc);
    }

    public static int countListCVDiDaXuLyChung(long userId,
        java.lang.String year, java.lang.String loaisocongvan)
        throws com.liferay.portal.SystemException {
        return getFinder().countListCVDiDaXuLyChung(userId, year, loaisocongvan);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> getListCVDiDaXuLyTuXuLy(
        long userId, java.lang.String year, java.lang.String loaisocongvan,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .getListCVDiDaXuLyTuXuLy(userId, year, loaisocongvan, start,
            end, obc);
    }

    public static int countListCVDiDaXuLyTuXuLy(long userId,
        java.lang.String year, java.lang.String loaisocongvan)
        throws com.liferay.portal.SystemException {
        return getFinder().countListCVDiDaXuLyTuXuLy(userId, year, loaisocongvan);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> getListCVDiDaXuLyChung_treHan(
        long userId, java.lang.String year, java.lang.String loaisocongvan,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .getListCVDiDaXuLyChung_treHan(userId, year, loaisocongvan,
            start, end, obc);
    }

    public static int countListCVDiDaXuLyChung_treHan(long userId,
        java.lang.String year, java.lang.String loaisocongvan)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countListCVDiDaXuLyChung_treHan(userId, year, loaisocongvan);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> getListCVDiDaXuLyTuXuLy_treHan(
        long userId, java.lang.String year, java.lang.String loaisocongvan,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .getListCVDiDaXuLyTuXuLy_treHan(userId, year, loaisocongvan,
            start, end, obc);
    }

    public static int countListCVDiDaXuLyTuXuLy_treHan(long userId,
        java.lang.String year, java.lang.String loaisocongvan)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countListCVDiDaXuLyTuXuLy_treHan(userId, year, loaisocongvan);
    }

    public static int countByD_I_D_R_D_S_E_B(java.lang.String soPH,
        int ngayPHMonth, int ngayPHYear, java.lang.String phongST,
        java.lang.String noiNhan, long loaiVB, java.lang.String tenNguoiKy,
        long nguoiST, java.lang.String trichYeu)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByD_I_D_R_D_S_E_B(soPH, ngayPHMonth, ngayPHYear,
            phongST, noiNhan, loaiVB, tenNguoiKy, nguoiST, trichYeu);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByD_I_D_R_D_S_E_B(
        java.lang.String soPH, int ngayPHMonth, int ngayPHYear,
        java.lang.String phongST, java.lang.String noiNhan, long loaiVB,
        java.lang.String tenNguoiKy, long nguoiST, java.lang.String trichYeu,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByD_I_D_R_D_S_E_B(soPH, ngayPHMonth, ngayPHYear,
            phongST, noiNhan, loaiVB, tenNguoiKy, nguoiST, trichYeu, start,
            end, obc);
    }

    public static int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getFinder().countByKeywords(keywords);
    }

    public static int countByLOAIVB_NGUOIKY(long loaiVB,
        java.lang.String nguoiKy, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder().countByLOAIVB_NGUOIKY(loaiVB, nguoiKy, andOperator);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder().findByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByLOAIVB_NGUOIKY(
        long loaiVB, java.lang.String nguoiKy, boolean andOperator, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByLOAIVB_NGUOIKY(loaiVB, nguoiKy, andOperator, start,
            end, obc);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> getListCVDiDaXuLyChung(
        long userId, long loaiVB, java.lang.String soKyHieu,
        java.lang.String donViSoanThao, java.lang.String nguoiKy,
        java.lang.String trichYeu, java.lang.String coQuanNhan,
        java.lang.String tuNgay, java.lang.String denNgay, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .getListCVDiDaXuLyChung(userId, loaiVB, soKyHieu,
            donViSoanThao, nguoiKy, trichYeu, coQuanNhan, tuNgay, denNgay,
            start, end, obc);
    }

    public static int countListCVDiDaXuLyChung(long userId, long loaiVB,
        java.lang.String soKyHieu, java.lang.String donViSoanThao,
        java.lang.String nguoiKy, java.lang.String trichYeu,
        java.lang.String coQuanNhan, java.lang.String tuNgay,
        java.lang.String denNgay) throws com.liferay.portal.SystemException {
        return getFinder()
                   .countListCVDiDaXuLyChung(userId, loaiVB, soKyHieu,
            donViSoanThao, nguoiKy, trichYeu, coQuanNhan, tuNgay, denNgay);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> getListCVDiDaXuLyTuXuLy(
        long userId, long loaiVB, java.lang.String soKyHieu,
        java.lang.String donViSoanThao, java.lang.String nguoiKy,
        java.lang.String trichYeu, java.lang.String coQuanNhan,
        java.lang.String tuNgay, java.lang.String denNgay, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .getListCVDiDaXuLyTuXuLy(userId, loaiVB, soKyHieu,
            donViSoanThao, nguoiKy, trichYeu, coQuanNhan, tuNgay, denNgay,
            start, end, obc);
    }

    public static int countListCVDiDaXuLyTuXuLy(long userId, long loaiVB,
        java.lang.String soKyHieu, java.lang.String donViSoanThao,
        java.lang.String nguoiKy, java.lang.String trichYeu,
        java.lang.String coQuanNhan, java.lang.String tuNgay,
        java.lang.String denNgay) throws com.liferay.portal.SystemException {
        return getFinder()
                   .countListCVDiDaXuLyTuXuLy(userId, loaiVB, soKyHieu,
            donViSoanThao, nguoiKy, trichYeu, coQuanNhan, tuNgay, denNgay);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> getListCVDiDaXuLyChung_treHan(
        long userId, long loaiVB, java.lang.String soKyHieu,
        java.lang.String donViSoanThao, java.lang.String nguoiKy,
        java.lang.String trichYeu, java.lang.String coQuanNhan,
        java.lang.String tuNgay, java.lang.String denNgay, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .getListCVDiDaXuLyChung_treHan(userId, loaiVB, soKyHieu,
            donViSoanThao, nguoiKy, trichYeu, coQuanNhan, tuNgay, denNgay,
            start, end, obc);
    }

    public static int countListCVDiDaXuLyChung_treHan(long userId, long loaiVB,
        java.lang.String soKyHieu, java.lang.String donViSoanThao,
        java.lang.String nguoiKy, java.lang.String trichYeu,
        java.lang.String coQuanNhan, java.lang.String tuNgay,
        java.lang.String denNgay) throws com.liferay.portal.SystemException {
        return getFinder()
                   .countListCVDiDaXuLyChung_treHan(userId, loaiVB, soKyHieu,
            donViSoanThao, nguoiKy, trichYeu, coQuanNhan, tuNgay, denNgay);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> getListCVDiDaXuLyTuXuLy_treHan(
        long userId, long loaiVB, java.lang.String soKyHieu,
        java.lang.String donViSoanThao, java.lang.String nguoiKy,
        java.lang.String trichYeu, java.lang.String coQuanNhan,
        java.lang.String tuNgay, java.lang.String denNgay, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .getListCVDiDaXuLyTuXuLy_treHan(userId, loaiVB, soKyHieu,
            donViSoanThao, nguoiKy, trichYeu, coQuanNhan, tuNgay, denNgay,
            start, end, obc);
    }

    public static int countListCVDiDaXuLyTuXuLy_treHan(long userId,
        long loaiVB, java.lang.String soKyHieu, java.lang.String donViSoanThao,
        java.lang.String nguoiKy, java.lang.String trichYeu,
        java.lang.String coQuanNhan, java.lang.String tuNgay,
        java.lang.String denNgay) throws com.liferay.portal.SystemException {
        return getFinder()
                   .countListCVDiDaXuLyTuXuLy_treHan(userId, loaiVB, soKyHieu,
            donViSoanThao, nguoiKy, trichYeu, coQuanNhan, tuNgay, denNgay);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByDocumentSend_Users_Status_DangXuLy_TreHan(
        java.util.List<Long> userIds, long statusId, long loaiVB,
        java.lang.String soKyHieu, java.lang.String donViSoanThao,
        java.lang.String nguoiKy, java.lang.String trichYeu,
        java.lang.String coQuanNhan, java.lang.String tuNgay,
        java.lang.String denNgay, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .findByDocumentSend_Users_Status_DangXuLy_TreHan(userIds,
            statusId, loaiVB, soKyHieu, donViSoanThao, nguoiKy, trichYeu,
            coQuanNhan, tuNgay, denNgay, start, end, obc);
    }

    public static int countByDocumentSend_Users_Status_DangXuLy_TreHan(
        java.util.List<Long> userIds, long statusId, long loaiVB,
        java.lang.String soKyHieu, java.lang.String donViSoanThao,
        java.lang.String nguoiKy, java.lang.String trichYeu,
        java.lang.String coQuanNhan, java.lang.String tuNgay,
        java.lang.String denNgay) throws java.lang.Exception {
        return getFinder()
                   .countByDocumentSend_Users_Status_DangXuLy_TreHan(userIds,
            statusId, loaiVB, soKyHieu, donViSoanThao, nguoiKy, trichYeu,
            coQuanNhan, tuNgay, denNgay);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByDocumentSend_Users_Status_DangXuLy(
        java.util.List<Long> userIds, long statusId, long loaiVB,
        java.lang.String soKyHieu, java.lang.String donViSoanThao,
        java.lang.String nguoiKy, java.lang.String trichYeu,
        java.lang.String coQuanNhan, java.lang.String tuNgay,
        java.lang.String denNgay, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .findByDocumentSend_Users_Status_DangXuLy(userIds, statusId,
            loaiVB, soKyHieu, donViSoanThao, nguoiKy, trichYeu, coQuanNhan,
            tuNgay, denNgay, start, end, obc);
    }

    public static int countByDocumentSend_Users_Status_DangXuLy(
        java.util.List<Long> userIds, long statusId, long loaiVB,
        java.lang.String soKyHieu, java.lang.String donViSoanThao,
        java.lang.String nguoiKy, java.lang.String trichYeu,
        java.lang.String coQuanNhan, java.lang.String tuNgay,
        java.lang.String denNgay) throws java.lang.Exception {
        return getFinder()
                   .countByDocumentSend_Users_Status_DangXuLy(userIds,
            statusId, loaiVB, soKyHieu, donViSoanThao, nguoiKy, trichYeu,
            coQuanNhan, tuNgay, denNgay);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByDocumentSend_Users(
        java.util.List<Long> userIds, long loaiVB,
        java.lang.String donViSoanThao, java.lang.String nguoiKy,
        java.lang.String trichYeu, java.lang.String coQuanNhan,
        java.lang.String tuNgay, java.lang.String denNgay, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .findByDocumentSend_Users(userIds, loaiVB, donViSoanThao,
            nguoiKy, trichYeu, coQuanNhan, tuNgay, denNgay, start, end, obc);
    }

    public static int countByDocumentSend_Users(java.util.List<Long> userIds,
        long loaiVB, java.lang.String donViSoanThao, java.lang.String nguoiKy,
        java.lang.String trichYeu, java.lang.String coQuanNhan,
        java.lang.String tuNgay, java.lang.String denNgay)
        throws java.lang.Exception {
        return getFinder()
                   .countByDocumentSend_Users(userIds, loaiVB, donViSoanThao,
            nguoiKy, trichYeu, coQuanNhan, tuNgay, denNgay);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendLog_Users_Status_DangXuLy(
        java.util.List<Long> userIds, long statusId, long loaiVB,
        java.lang.String soKyHieu, java.lang.String donViSoanThao,
        java.lang.String nguoiKy, java.lang.String trichYeu,
        java.lang.String coQuanNhan, java.lang.String tuNgay,
        java.lang.String denNgay, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .findByDocumentSendLog_Users_Status_DangXuLy(userIds,
            statusId, loaiVB, soKyHieu, donViSoanThao, nguoiKy, trichYeu,
            coQuanNhan, tuNgay, denNgay, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendLog_Users_Status_DangXuLy_TreHan(
        java.util.List<Long> userIds, long statusId, long loaiVB,
        java.lang.String soKyHieu, java.lang.String donViSoanThao,
        java.lang.String nguoiKy, java.lang.String trichYeu,
        java.lang.String coQuanNhan, java.lang.String tuNgay,
        java.lang.String denNgay, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .findByDocumentSendLog_Users_Status_DangXuLy_TreHan(userIds,
            statusId, loaiVB, soKyHieu, donViSoanThao, nguoiKy, trichYeu,
            coQuanNhan, tuNgay, denNgay, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendLog_Users(
        java.util.List<Long> userIds, long loaiVB,
        java.lang.String donViSoanThao, java.lang.String nguoiKy,
        java.lang.String trichYeu, java.lang.String coQuanNhan,
        java.lang.String tuNgay, java.lang.String denNgay, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getFinder()
                   .findByDocumentSendLog_Users(userIds, loaiVB, donViSoanThao,
            nguoiKy, trichYeu, coQuanNhan, tuNgay, denNgay, start, end, obc);
    }

    public static long getSoPhatHanhVBDi(long docTypeId, int issuingYear,
        boolean numOfDirector) throws com.liferay.portal.SystemException {
        return getFinder()
                   .getSoPhatHanhVBDi(docTypeId, issuingYear, numOfDirector);
    }

    public static int countByVBDi_SoVBDiCuaPhong(java.lang.String soPH,
        int ngayPHMonth, int ngayPHYear, java.lang.String phongST,
        java.lang.String noiNhan, long loaiVB, java.lang.String tenNguoiKy,
        long nguoiST, java.lang.String trichYeu, java.lang.String vanBanPH)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByVBDi_SoVBDiCuaPhong(soPH, ngayPHMonth, ngayPHYear,
            phongST, noiNhan, loaiVB, tenNguoiKy, nguoiST, trichYeu, vanBanPH);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByVBDi_SoVBDiCuaPhong(
        java.lang.String soPH, int ngayPHMonth, int ngayPHYear,
        java.lang.String phongST, java.lang.String noiNhan, long loaiVB,
        java.lang.String tenNguoiKy, long nguoiST, java.lang.String trichYeu,
        java.lang.String vanBanPH, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByVBDi_SoVBDiCuaPhong(soPH, ngayPHMonth, ngayPHYear,
            phongST, noiNhan, loaiVB, tenNguoiKy, nguoiST, trichYeu, vanBanPH,
            start, end, obc);
    }

    public static int kiemTraSoVaKyHieuVBPhatHanh(
        java.lang.String soVBPhatHanh, int issuingYear, long documentSendId)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .kiemTraSoVaKyHieuVBPhatHanh(soVBPhatHanh, issuingYear,
            documentSendId);
    }

    public static PmlEdmDocumentSendFinder getFinder() {
        return _finder;
    }

    public void setFinder(PmlEdmDocumentSendFinder finder) {
        _finder = finder;
    }
}
