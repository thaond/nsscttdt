package com.sgs.portlet.document.send.service;


/**
 * <a href="PmlEdmDocumentSendLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.document.send.service.PmlEdmDocumentSendLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.send.service.PmlEdmDocumentSendLocalService
 *
 */
public class PmlEdmDocumentSendLocalServiceUtil {
    private static PmlEdmDocumentSendLocalService _service;

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend addPmlEdmDocumentSend(
        com.sgs.portlet.document.send.model.PmlEdmDocumentSend pmlEdmDocumentSend)
        throws com.liferay.portal.SystemException {
        return getService().addPmlEdmDocumentSend(pmlEdmDocumentSend);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend createPmlEdmDocumentSend(
        long documentSendId) {
        return getService().createPmlEdmDocumentSend(documentSendId);
    }

    public static void deletePmlEdmDocumentSend(long documentSendId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlEdmDocumentSend(documentSendId);
    }

    public static void deletePmlEdmDocumentSend(
        com.sgs.portlet.document.send.model.PmlEdmDocumentSend pmlEdmDocumentSend)
        throws com.liferay.portal.SystemException {
        getService().deletePmlEdmDocumentSend(pmlEdmDocumentSend);
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

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend getPmlEdmDocumentSend(
        long documentSendId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlEdmDocumentSend(documentSendId);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> getPmlEdmDocumentSends(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlEdmDocumentSends(start, end);
    }

    public static int getPmlEdmDocumentSendsCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlEdmDocumentSendsCount();
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend updatePmlEdmDocumentSend(
        com.sgs.portlet.document.send.model.PmlEdmDocumentSend pmlEdmDocumentSend)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlEdmDocumentSend(pmlEdmDocumentSend);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> filter(
        java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> list,
        java.lang.String briefContent, long signer, java.util.Date issuingDate,
        java.lang.String documentReference, java.lang.String receivingPlace) {
        return getService()
                   .filter(list, briefContent, signer, issuingDate,
            documentReference, receivingPlace);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> filter(
        java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> list,
        java.lang.String briefContent, java.util.Date issuingDate,
        java.lang.String documentReference, java.lang.String receivingPlace) {
        return getService()
                   .filter(list, briefContent, issuingDate, documentReference,
            receivingPlace);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> filterByIssuingPlace(
        java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> list,
        java.lang.String receivingPlace) {
        return getService().filterByIssuingPlace(list, receivingPlace);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> filterByDocumentReference(
        java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> list,
        java.lang.String documentReference) {
        return getService().filterByDocumentReference(list, documentReference);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> filterByIssuingDate(
        java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> list,
        java.util.Date issuingDate) {
        return getService().filterByIssuingDate(list, issuingDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> filterBySigner(
        java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> list,
        long signer) {
        return getService().filterBySigner(list, signer);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> filterByBriefContent(
        java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> list,
        java.lang.String briefContent) {
        return getService().filterByBriefContent(list, briefContent);
    }

    public static int countByS_L_T_P_N_N_TN_DN_S_T(
        java.lang.String soPhatHanh, long loaiCongVan,
        java.lang.String traLoiCongVanSo, java.lang.String phongSoanThao,
        java.lang.String noiNhan, long nguoiKy, java.lang.String tuNgay,
        java.lang.String denNgay, long soHSCV, java.lang.String trichYeu)
        throws com.liferay.portal.SystemException {
        return getService()
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
        return getService()
                   .findByS_L_T_P_N_N_TN_DN_S_T(soPhatHanh, loaiCongVan,
            traLoiCongVanSo, phongSoanThao, noiNhan, nguoiKy, tuNgay, denNgay,
            soHSCV, trichYeu, start, end, obc);
    }

    public static int countDocSendNeedProcess(long userId)
        throws com.liferay.portal.SystemException {
        return getService().countDocSendNeedProcess(userId);
    }

    public static int countByDocumentSend_Users_Status_DangXuLy(
        java.util.List<Long> userIds, long statusId, java.lang.String soCVDen,
        java.lang.String capGui) throws java.lang.Exception {
        return getService()
                   .countByDocumentSend_Users_Status_DangXuLy(userIds,
            statusId, soCVDen, capGui);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByDocumentSend_Users_Status_DangXuLy(
        java.util.List<Long> userIds, long statusId, java.lang.String soCVDen,
        java.lang.String capGui, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .findByDocumentSend_Users_Status_DangXuLy(userIds, statusId,
            soCVDen, capGui, start, end, obc);
    }

    public static int countByDocumentSend_Users_Status_DangXuLy_TreHan(
        java.util.List<Long> userIds, long statusId,
        java.lang.String loaisocongvan, java.lang.String capGui)
        throws java.lang.Exception {
        return getService()
                   .countByDocumentSend_Users_Status_DangXuLy_TreHan(userIds,
            statusId, loaisocongvan, capGui);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByDocumentSend_Users_Status_DangXuLy_TreHan(
        java.util.List<Long> userIds, long statusId,
        java.lang.String loaisocongvan, java.lang.String capGui, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .findByDocumentSend_Users_Status_DangXuLy_TreHan(userIds,
            statusId, loaisocongvan, capGui, start, end, obc);
    }

    public static int countByDocumentSend_Users(java.util.List<Long> userIds,
        java.lang.String loaisocongvan) throws java.lang.Exception {
        return getService().countByDocumentSend_Users(userIds, loaisocongvan);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByDocumentSend_Users(
        java.util.List<Long> userIds, java.lang.String loaisocongvan,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .findByDocumentSend_Users(userIds, loaisocongvan, start,
            end, obc);
    }

    public static int countDocumentType(int documentTypeId,
        java.lang.String departmentsId)
        throws com.liferay.portal.SystemException {
        return getService().countDocumentType(documentTypeId, departmentsId);
    }

    public static long getMaxDocumentSendId()
        throws com.liferay.portal.SystemException {
        return getService().getMaxDocumentSendId();
    }

    public static long getMaxDocRefByTypeYear(long docTypeId, int issuingYear)
        throws com.liferay.portal.SystemException {
        return getService().getMaxDocRefByTypeYear(docTypeId, issuingYear);
    }

    public static void reIndext(long companyId,
        com.sgs.portlet.document.send.model.PmlEdmDocumentSend documentSend)
        throws com.liferay.portal.kernel.search.SearchException {
        getService().reIndext(companyId, documentSend);
    }

    public static void reIndex(java.lang.String[] ids)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException {
        getService().reIndex(ids);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend addPmlEdmDocumentSend(
        long companyId, java.lang.String briefContent,
        java.lang.String documentReference, java.lang.String receivingPlace,
        long editorId, long documentTypeId, java.lang.String privilegeLevelId,
        java.lang.String confidentialLevelId, java.util.Date dateCreated,
        boolean isLocal)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException {
        return getService()
                   .addPmlEdmDocumentSend(companyId, briefContent,
            documentReference, receivingPlace, editorId, documentTypeId,
            privilegeLevelId, confidentialLevelId, dateCreated, isLocal);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend addPmlEdmDocumentSend(
        long companyId,
        com.sgs.portlet.document.send.model.PmlEdmDocumentSend pmlEdmDocumentSend)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException {
        return getService().addPmlEdmDocumentSend(companyId, pmlEdmDocumentSend);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend updatePmlEdmDocumentSend(
        long companyId, long documentSendId, java.lang.String briefContent,
        java.lang.String documentReference, java.lang.String receivingPlace,
        long editorId, long documentTypeId, java.lang.String privilegeLevelId,
        java.lang.String confidentialLevelId, java.util.Date dateCreated,
        boolean isLocal)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException {
        return getService()
                   .updatePmlEdmDocumentSend(companyId, documentSendId,
            briefContent, documentReference, receivingPlace, editorId,
            documentTypeId, privilegeLevelId, confidentialLevelId, dateCreated,
            isLocal);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmDocumentSend updatePmlEdmDocumentSend(
        long companyId,
        com.sgs.portlet.document.send.model.PmlEdmDocumentSend documentSend)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException {
        return getService().updatePmlEdmDocumentSend(companyId, documentSend);
    }

    public static void deletePmlEdmDocumentSend(long companyId,
        long documentSendId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException {
        getService().deletePmlEdmDocumentSend(companyId, documentSendId);
    }

    public static void deletePmlEdmDocumentSend(long companyId,
        com.sgs.portlet.document.send.model.PmlEdmDocumentSend pmlEdmDocumentSend)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException {
        getService().deletePmlEdmDocumentSend(companyId, pmlEdmDocumentSend);
    }

    public static com.liferay.portal.kernel.search.Hits search(long companyId,
        java.lang.String soPhatHanh, long loaiCongVan,
        java.lang.String traLoiCongVanSo, java.lang.String phongSoanThao,
        java.lang.String noiNhan, java.lang.String nguoiKy,
        java.util.Date tuNgay, java.util.Date denNgay, long soHSCV,
        java.lang.String trichYeu, java.lang.String active, long nguoiSoanThao,
        int start, int end) throws com.liferay.portal.SystemException {
        return getService()
                   .search(companyId, soPhatHanh, loaiCongVan, traLoiCongVanSo,
            phongSoanThao, noiNhan, nguoiKy, tuNgay, denNgay, soHSCV, trichYeu,
            active, nguoiSoanThao, start, end);
    }

    public static com.liferay.portal.kernel.search.Hits search(long companyId,
        java.lang.String soPhatHanh, long loaiCongVan,
        java.lang.String traLoiCongVanSo, java.lang.String phongSoanThao,
        java.lang.String noiNhan, java.lang.String nguoiKy,
        java.util.Date tuNgay, java.util.Date denNgay, long soHSCV,
        java.lang.String trichYeu, java.lang.String active, long nguoiSoanThao,
        java.lang.String sortField, int sortType, int start, int end)
        throws com.liferay.portal.SystemException {
        return getService()
                   .search(companyId, soPhatHanh, loaiCongVan, traLoiCongVanSo,
            phongSoanThao, noiNhan, nguoiKy, tuNgay, denNgay, soHSCV, trichYeu,
            active, nguoiSoanThao, sortField, sortType, start, end);
    }

    public static com.liferay.portal.kernel.search.Hits search(long companyId,
        java.lang.String soPhatHanh, long loaiCongVan,
        java.lang.String traLoiCongVanSo, java.lang.String phongSoanThao,
        java.lang.String noiNhan, java.lang.String nguoiKy,
        java.util.Date tuNgay, java.util.Date denNgay, long soHSCV,
        java.lang.String trichYeu, java.lang.String active, long nguoiSoanThao,
        java.lang.String sortField, int sortType, boolean reverse, int start,
        int end) throws com.liferay.portal.SystemException {
        return getService()
                   .search(companyId, soPhatHanh, loaiCongVan, traLoiCongVanSo,
            phongSoanThao, noiNhan, nguoiKy, tuNgay, denNgay, soHSCV, trichYeu,
            active, nguoiSoanThao, sortField, sortType, reverse, start, end);
    }

    public static com.liferay.portal.kernel.search.Hits search(long companyId,
        java.lang.String soPhatHanh, long loaiCongVan,
        java.lang.String traLoiCongVanSo, java.lang.String phongSoanThao,
        java.lang.String noiNhan, java.lang.String nguoiKy,
        java.util.Date tuNgay, java.util.Date denNgay, long soHSCV,
        java.lang.String trichYeu, java.lang.String active,
        java.lang.String sortField, int sortType, boolean reverse, int start,
        int end) throws com.liferay.portal.SystemException {
        return getService()
                   .search(companyId, soPhatHanh, loaiCongVan, traLoiCongVanSo,
            phongSoanThao, noiNhan, nguoiKy, tuNgay, denNgay, soHSCV, trichYeu,
            active, sortField, sortType, reverse, start, end);
    }

    public static int countTonDauKyChuyenVien_CVDi(long userId,
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getService()
                   .countTonDauKyChuyenVien_CVDi(userId, documentRecordTypeId,
            loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listTonDauKyChuyenVien_CVDi(
        long userId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .listTonDauKyChuyenVien_CVDi(userId, documentRecordTypeId,
            loaiVB, doMat, fromDate, toDate, start, end, obc);
    }

    public static int countNhanTrongKyChuyenVien_CVDi(long userId,
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getService()
                   .countNhanTrongKyChuyenVien_CVDi(userId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listNhanTrongKyChuyenVien_CVDi(
        long userId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .listNhanTrongKyChuyenVien_CVDi(userId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate, start, end,
            obc);
    }

    public static int countChuaNhanChuyenVien_CVDi(long userId,
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getService()
                   .countChuaNhanChuyenVien_CVDi(userId, documentRecordTypeId,
            loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listChuaNhanChuyenVien_CVDi(
        long userId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .listChuaNhanChuyenVien_CVDi(userId, documentRecordTypeId,
            loaiVB, doMat, fromDate, toDate, start, end, obc);
    }

    public static int countNhanTrongThangChuyenVien_CVDi(long userId,
        int documentRecordTypeId, int loaiVB, java.util.Date fromDate,
        java.util.Date toDate) throws java.lang.Exception {
        return getService()
                   .countNhanTrongThangChuyenVien_CVDi(userId,
            documentRecordTypeId, loaiVB, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listNhanTrongThangChuyenVien_CVDi(
        long userId, int documentRecordTypeId, int loaiVB,
        java.util.Date fromDate, java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .listNhanTrongThangChuyenVien_CVDi(userId,
            documentRecordTypeId, loaiVB, fromDate, toDate, start, end, obc);
    }

    public static int countDungHanDaXuLyChuyenVien_CVDi(long userId,
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getService()
                   .countDungHanDaXuLyChuyenVien_CVDi(userId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listDungHanDaXuLyChuyenVien_CVDi(
        long userId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .listDungHanDaXuLyChuyenVien_CVDi(userId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate, start, end,
            obc);
    }

    public static int countTreHanDaXuLyChuyenVien_CVDi(long userId,
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getService()
                   .countTreHanDaXuLyChuyenVien_CVDi(userId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listTreHanDaXuLyChuyenVien_CVDi(
        long userId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .listTreHanDaXuLyChuyenVien_CVDi(userId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate, start, end,
            obc);
    }

    public static int countTongDaXuLyChuyenVien_CVDi(long userId,
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getService()
                   .countTongDaXuLyChuyenVien_CVDi(userId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listTongDaXuLyChuyenVien_CVDi(
        long userId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .listTongDaXuLyChuyenVien_CVDi(userId, documentRecordTypeId,
            loaiVB, doMat, fromDate, toDate, start, end, obc);
    }

    public static int countDungHanDangXuLyChuyenVien_CVDi(long userId,
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getService()
                   .countDungHanDangXuLyChuyenVien_CVDi(userId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listDungHanDangXuLyChuyenVien_CVDi(
        long userId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .listDungHanDangXuLyChuyenVien_CVDi(userId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate, start, end,
            obc);
    }

    public static int countTreHanDangXuLyChuyenVien_CVDi(long userId,
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getService()
                   .countTreHanDangXuLyChuyenVien_CVDi(userId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listTreHanDangXuLyChuyenVien_CVDi(
        long userId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .listTreHanDangXuLyChuyenVien_CVDi(userId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate, start, end,
            obc);
    }

    public static int countTongDangXuLyChuyenVien_CVDi(long userId,
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getService()
                   .countTongDangXuLyChuyenVien_CVDi(userId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listTongDangXuLyChuyenVien_CVDi(
        long userId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .listTongDangXuLyChuyenVien_CVDi(userId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate, start, end,
            obc);
    }

    public static int countTonDauKyPhongBan_CVDi(
        java.lang.String departmentId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getService()
                   .countTonDauKyPhongBan_CVDi(departmentId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listTonDauKyPhongBan_CVDi(
        java.lang.String departmentId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .listTonDauKyPhongBan_CVDi(departmentId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate, start, end,
            obc);
    }

    public static int countNhanTrongKyPhongBan_CVDi(
        java.lang.String departmentId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getService()
                   .countNhanTrongKyPhongBan_CVDi(departmentId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listNhanTrongKyPhongBan_CVDi(
        java.lang.String departmentId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .listNhanTrongKyPhongBan_CVDi(departmentId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate, start, end,
            obc);
    }

    public static int countChuaNhanTrongKyPhongBan_CVDi(
        java.lang.String departmentId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getService()
                   .countChuaNhanTrongKyPhongBan_CVDi(departmentId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listChuaNhanTrongKyPhongBan_CVDi(
        java.lang.String departmentId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .listChuaNhanTrongKyPhongBan_CVDi(departmentId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate, start, end,
            obc);
    }

    public static int countDungHanDaXuLyPhongBan_CVDi(
        java.lang.String departmentId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getService()
                   .countDungHanDaXuLyPhongBan_CVDi(departmentId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listDungHanDaXuLyPhongBan_CVDi(
        java.lang.String departmentId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .listDungHanDaXuLyPhongBan_CVDi(departmentId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate, start, end,
            obc);
    }

    public static int countTreHanDaXuLyPhongBan_CVDi(
        java.lang.String departmentId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getService()
                   .countTreHanDaXuLyPhongBan_CVDi(departmentId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listTreHanDaXuLyPhongBan_CVDi(
        java.lang.String departmentId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .listTreHanDaXuLyPhongBan_CVDi(departmentId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate, start, end,
            obc);
    }

    public static int countTongDaXuLyPhongBan_CVDi(
        java.lang.String departmentId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getService()
                   .countTongDaXuLyPhongBan_CVDi(departmentId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listTongDaXuLyPhongBan_CVDi(
        java.lang.String departmentId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .listTongDaXuLyPhongBan_CVDi(departmentId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate, start, end,
            obc);
    }

    public static int countDungHanDangXuLyPhongBan_CVDi(
        java.lang.String departmentId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getService()
                   .countDungHanDangXuLyPhongBan_CVDi(departmentId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listDungHanDangXuLyPhongBan_CVDi(
        java.lang.String departmentId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .listDungHanDangXuLyPhongBan_CVDi(departmentId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate, start, end,
            obc);
    }

    public static int countTreHanDangXuLyPhongBan_CVDi(
        java.lang.String departmentId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getService()
                   .countTreHanDangXuLyPhongBan_CVDi(departmentId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listTreHanDangXuLyPhongBan_CVDi(
        java.lang.String departmentId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .listTreHanDangXuLyPhongBan_CVDi(departmentId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate, start, end,
            obc);
    }

    public static int countTongDangXuLyPhongBan_CVDi(
        java.lang.String departmentId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getService()
                   .countTongDangXuLyPhongBan_CVDi(departmentId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listTongDangXuLyPhongBan_CVDi(
        java.lang.String departmentId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .listTongDangXuLyPhongBan_CVDi(departmentId,
            documentRecordTypeId, loaiVB, doMat, fromDate, toDate, start, end,
            obc);
    }

    public static int countTonDauKySo_CVDi(int documentRecordTypeId,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate) throws java.lang.Exception {
        return getService()
                   .countTonDauKySo_CVDi(documentRecordTypeId, loaiVB, doMat,
            fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listTonDauKySo_CVDi(
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .listTonDauKySo_CVDi(documentRecordTypeId, loaiVB, doMat,
            fromDate, toDate, start, end, obc);
    }

    public static int countNhanTrongKySo_CVDi(int documentRecordTypeId,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate) throws java.lang.Exception {
        return getService()
                   .countNhanTrongKySo_CVDi(documentRecordTypeId, loaiVB,
            doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listNhanTrongKySo_CVDi(
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .listNhanTrongKySo_CVDi(documentRecordTypeId, loaiVB, doMat,
            fromDate, toDate, start, end, obc);
    }

    public static int countDungHanDaXuLySo_CVDi(int documentRecordTypeId,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate) throws java.lang.Exception {
        return getService()
                   .countDungHanDaXuLySo_CVDi(documentRecordTypeId, loaiVB,
            doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listDungHanDaXuLySo_CVDi(
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .listDungHanDaXuLySo_CVDi(documentRecordTypeId, loaiVB,
            doMat, fromDate, toDate, start, end, obc);
    }

    public static int countTreHanDaXuLySo_CVDi(int documentRecordTypeId,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate) throws java.lang.Exception {
        return getService()
                   .countTreHanDaXuLySo_CVDi(documentRecordTypeId, loaiVB,
            doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listTreHanDaXuLySo_CVDi(
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .listTreHanDaXuLySo_CVDi(documentRecordTypeId, loaiVB,
            doMat, fromDate, toDate, start, end, obc);
    }

    public static int countTongDaXuLySo_CVDi(int documentRecordTypeId,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate) throws java.lang.Exception {
        return getService()
                   .countTongDaXuLySo_CVDi(documentRecordTypeId, loaiVB, doMat,
            fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listTongDaXuLySo_CVDi(
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .listTongDaXuLySo_CVDi(documentRecordTypeId, loaiVB, doMat,
            fromDate, toDate, start, end, obc);
    }

    public static int countDungHanDangXuLySo_CVDi(int documentRecordTypeId,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate) throws java.lang.Exception {
        return getService()
                   .countDungHanDangXuLySo_CVDi(documentRecordTypeId, loaiVB,
            doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listDungHanDangXuLySo_CVDi(
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .listDungHanDangXuLySo_CVDi(documentRecordTypeId, loaiVB,
            doMat, fromDate, toDate, start, end, obc);
    }

    public static int countTreHanDangXuLySo_CVDi(int documentRecordTypeId,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate) throws java.lang.Exception {
        return getService()
                   .countTreHanDangXuLySo_CVDi(documentRecordTypeId, loaiVB,
            doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listTreHanDangXuLySo_CVDi(
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .listTreHanDangXuLySo_CVDi(documentRecordTypeId, loaiVB,
            doMat, fromDate, toDate, start, end, obc);
    }

    public static int countTongDangXuLySo_CVDi(int documentRecordTypeId,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate) throws java.lang.Exception {
        return getService()
                   .countTongDangXuLySo_CVDi(documentRecordTypeId, loaiVB,
            doMat, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listTongDangXuLySo_CVDi(
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .listTongDangXuLySo_CVDi(documentRecordTypeId, loaiVB,
            doMat, fromDate, toDate, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> getListPmlEdmDocumentSend(
        int loaiSoCongVan, java.lang.String fromDate, java.lang.String toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .getListPmlEdmDocumentSend(loaiSoCongVan, fromDate, toDate,
            start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> getListPmlEdmDocumentSendByLoaiSoCV(
        java.lang.String loaiSoCongVan, java.lang.String fromDate,
        java.lang.String toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .getListPmlEdmDocumentSendByLoaiSoCV(loaiSoCongVan,
            fromDate, toDate, start, end, obc);
    }

    public static int countListPmlEdmDocumentSendByLoaiSoCV(
        java.lang.String loaiSoCongVan, java.lang.String fromDate,
        java.lang.String toDate) throws com.liferay.portal.SystemException {
        return getService()
                   .countListPmlEdmDocumentSendByLoaiSoCV(loaiSoCongVan,
            fromDate, toDate);
    }

    public static int countListCVDiDaXuLyTuXuLy(long userId,
        java.lang.String year, java.lang.String loaisocongvan)
        throws com.liferay.portal.SystemException {
        return getService()
                   .countListCVDiDaXuLyTuXuLy(userId, year, loaisocongvan);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> getListCVDiDaXuLyTuXuLy(
        long userId, java.lang.String year, java.lang.String loaisocongvan,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getListCVDiDaXuLyTuXuLy(userId, year, loaisocongvan, start,
            end, obc);
    }

    public static int countListCVDiDaXuLyChung(long userId,
        java.lang.String year, java.lang.String loaisocongvan)
        throws com.liferay.portal.SystemException {
        return getService().countListCVDiDaXuLyChung(userId, year, loaisocongvan);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> getListCVDiDaXuLyChung(
        long userId, java.lang.String year, java.lang.String loaisocongvan,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getListCVDiDaXuLyChung(userId, year, loaisocongvan, start,
            end, obc);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> getListCVDiDaXuLyChung_treHan(
        long userId, java.lang.String year, java.lang.String loaisocongvan,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getListCVDiDaXuLyChung_treHan(userId, year, loaisocongvan,
            start, end, obc);
    }

    public static int countListCVDiDaXuLyChung_treHan(long userId,
        java.lang.String year, java.lang.String loaisocongvan)
        throws com.liferay.portal.SystemException {
        return getService()
                   .countListCVDiDaXuLyChung_treHan(userId, year, loaisocongvan);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> getListCVDiDaXuLyTuXuLy_treHan(
        long userId, java.lang.String year, java.lang.String loaisocongvan,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getListCVDiDaXuLyTuXuLy_treHan(userId, year, loaisocongvan,
            start, end, obc);
    }

    public static int countListCVDiDaXuLyTuXuLy_treHan(long userId,
        java.lang.String year, java.lang.String loaisocongvan)
        throws com.liferay.portal.SystemException {
        return getService()
                   .countListCVDiDaXuLyTuXuLy_treHan(userId, year, loaisocongvan);
    }

    public static int countByD_I_D_R_D_S_E_B(java.lang.String soPH,
        int ngayPHMonth, int ngayPHYear, java.lang.String phongST,
        java.lang.String noiNhan, long loaiVB, java.lang.String tenNguoiKy,
        long nguoiST, java.lang.String trichYeu)
        throws com.liferay.portal.SystemException {
        return getService()
                   .countByD_I_D_R_D_S_E_B(soPH, ngayPHMonth, ngayPHYear,
            phongST, noiNhan, loaiVB, tenNguoiKy, nguoiST, trichYeu);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByD_I_D_R_D_S_E_B(
        java.lang.String soPH, int ngayPHMonth, int ngayPHYear,
        java.lang.String phongST, java.lang.String noiNhan, long loaiVB,
        java.lang.String tenNguoiKy, long nguoiST, java.lang.String trichYeu,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .findByD_I_D_R_D_S_E_B(soPH, ngayPHMonth, ngayPHYear,
            phongST, noiNhan, loaiVB, tenNguoiKy, nguoiST, trichYeu, start,
            end, obc);
    }

    public static int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getService().countByKeywords(keywords);
    }

    public static int countByLOAIVB_NGUOIKY(long loaiVB,
        java.lang.String nguoiKy, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getService().countByLOAIVB_NGUOIKY(loaiVB, nguoiKy, andOperator);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().findByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByLOAIVB_NGUOIKY(
        long loaiVB, java.lang.String nguoiKy, boolean andOperator, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
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
        return getService()
                   .getListCVDiDaXuLyChung(userId, loaiVB, soKyHieu,
            donViSoanThao, nguoiKy, trichYeu, coQuanNhan, tuNgay, denNgay,
            start, end, obc);
    }

    public static int countListCVDiDaXuLyChung(long userId, long loaiVB,
        java.lang.String soKyHieu, java.lang.String donViSoanThao,
        java.lang.String nguoiKy, java.lang.String trichYeu,
        java.lang.String coQuanNhan, java.lang.String tuNgay,
        java.lang.String denNgay) throws com.liferay.portal.SystemException {
        return getService()
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
        return getService()
                   .getListCVDiDaXuLyTuXuLy(userId, loaiVB, soKyHieu,
            donViSoanThao, nguoiKy, trichYeu, coQuanNhan, tuNgay, denNgay,
            start, end, obc);
    }

    public static int countListCVDiDaXuLyTuXuLy(long userId, long loaiVB,
        java.lang.String soKyHieu, java.lang.String donViSoanThao,
        java.lang.String nguoiKy, java.lang.String trichYeu,
        java.lang.String coQuanNhan, java.lang.String tuNgay,
        java.lang.String denNgay) throws com.liferay.portal.SystemException {
        return getService()
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
        return getService()
                   .getListCVDiDaXuLyChung_treHan(userId, loaiVB, soKyHieu,
            donViSoanThao, nguoiKy, trichYeu, coQuanNhan, tuNgay, denNgay,
            start, end, obc);
    }

    public static int countListCVDiDaXuLyChung_treHan(long userId, long loaiVB,
        java.lang.String soKyHieu, java.lang.String donViSoanThao,
        java.lang.String nguoiKy, java.lang.String trichYeu,
        java.lang.String coQuanNhan, java.lang.String tuNgay,
        java.lang.String denNgay) throws com.liferay.portal.SystemException {
        return getService()
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
        return getService()
                   .getListCVDiDaXuLyTuXuLy_treHan(userId, loaiVB, soKyHieu,
            donViSoanThao, nguoiKy, trichYeu, coQuanNhan, tuNgay, denNgay,
            start, end, obc);
    }

    public static int countListCVDiDaXuLyTuXuLy_treHan(long userId,
        long loaiVB, java.lang.String soKyHieu, java.lang.String donViSoanThao,
        java.lang.String nguoiKy, java.lang.String trichYeu,
        java.lang.String coQuanNhan, java.lang.String tuNgay,
        java.lang.String denNgay) throws com.liferay.portal.SystemException {
        return getService()
                   .countListCVDiDaXuLyTuXuLy_treHan(userId, loaiVB, soKyHieu,
            donViSoanThao, nguoiKy, trichYeu, coQuanNhan, tuNgay, denNgay);
    }

    public static int countByDocumentSend_Users_Status_DangXuLy(
        java.util.List<Long> userIds, long statusId, long loaiVB,
        java.lang.String soKyHieu, java.lang.String donViSoanThao,
        java.lang.String nguoiKy, java.lang.String trichYeu,
        java.lang.String coQuanNhan, java.lang.String tuNgay,
        java.lang.String denNgay) throws java.lang.Exception {
        return getService()
                   .countByDocumentSend_Users_Status_DangXuLy(userIds,
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
        return getService()
                   .findByDocumentSend_Users_Status_DangXuLy(userIds, statusId,
            loaiVB, soKyHieu, donViSoanThao, nguoiKy, trichYeu, coQuanNhan,
            tuNgay, denNgay, start, end, obc);
    }

    public static int countByDocumentSend_Users_Status_DangXuLy_TreHan(
        java.util.List<Long> userIds, long statusId, long loaiVB,
        java.lang.String soKyHieu, java.lang.String donViSoanThao,
        java.lang.String nguoiKy, java.lang.String trichYeu,
        java.lang.String coQuanNhan, java.lang.String tuNgay,
        java.lang.String denNgay) throws java.lang.Exception {
        return getService()
                   .countByDocumentSend_Users_Status_DangXuLy_TreHan(userIds,
            statusId, loaiVB, soKyHieu, donViSoanThao, nguoiKy, trichYeu,
            coQuanNhan, tuNgay, denNgay);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByDocumentSend_Users_Status_DangXuLy_TreHan(
        java.util.List<Long> userIds, long statusId, long loaiVB,
        java.lang.String soKyHieu, java.lang.String donViSoanThao,
        java.lang.String nguoiKy, java.lang.String trichYeu,
        java.lang.String coQuanNhan, java.lang.String tuNgay,
        java.lang.String denNgay, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .findByDocumentSend_Users_Status_DangXuLy_TreHan(userIds,
            statusId, loaiVB, soKyHieu, donViSoanThao, nguoiKy, trichYeu,
            coQuanNhan, tuNgay, denNgay, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByDocumentSend_Users(
        java.util.List<Long> userIds, long loaiVB,
        java.lang.String donViSoanThao, java.lang.String nguoiKy,
        java.lang.String trichYeu, java.lang.String coQuanNhan,
        java.lang.String tuNgay, java.lang.String denNgay, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .findByDocumentSend_Users(userIds, loaiVB, donViSoanThao,
            nguoiKy, trichYeu, coQuanNhan, tuNgay, denNgay, start, end, obc);
    }

    public static int countByDocumentSend_Users(java.util.List<Long> userIds,
        long loaiVB, java.lang.String donViSoanThao, java.lang.String nguoiKy,
        java.lang.String trichYeu, java.lang.String coQuanNhan,
        java.lang.String tuNgay, java.lang.String denNgay)
        throws java.lang.Exception {
        return getService()
                   .countByDocumentSend_Users(userIds, loaiVB, donViSoanThao,
            nguoiKy, trichYeu, coQuanNhan, tuNgay, denNgay);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendLog_Users_Status_DangXuLy(
        java.util.List<Long> userIds, long statusId, long soVanBan,
        java.lang.String soKyHieu, java.lang.String donViSoanThao,
        java.lang.String nguoiKy, java.lang.String trichYeu,
        java.lang.String coQuanNhan, java.lang.String tuNgay,
        java.lang.String denNgay, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .findByDocumentSendLog_Users_Status_DangXuLy(userIds,
            statusId, soVanBan, soKyHieu, donViSoanThao, nguoiKy, trichYeu,
            coQuanNhan, tuNgay, denNgay, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendLog_Users_Status_DangXuLy_TreHan(
        java.util.List<Long> userIds, long statusId, long soVanBan,
        java.lang.String soKyHieu, java.lang.String donViSoanThao,
        java.lang.String nguoiKy, java.lang.String trichYeu,
        java.lang.String coQuanNhan, java.lang.String tuNgay,
        java.lang.String denNgay, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .findByDocumentSendLog_Users_Status_DangXuLy_TreHan(userIds,
            statusId, soVanBan, soKyHieu, donViSoanThao, nguoiKy, trichYeu,
            coQuanNhan, tuNgay, denNgay, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendLog_Users(
        java.util.List<Long> userIds, long loaiVB,
        java.lang.String donViSoanThao, java.lang.String nguoiKy,
        java.lang.String trichYeu, java.lang.String coQuanNhan,
        java.lang.String tuNgay, java.lang.String denNgay, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .findByDocumentSendLog_Users(userIds, loaiVB, donViSoanThao,
            nguoiKy, trichYeu, coQuanNhan, tuNgay, denNgay, start, end, obc);
    }

    public static java.util.List<Long> searchBySPH_PST_NN_TY_noRelation(
        long companyId, java.lang.String soPH, java.lang.String phongST,
        java.lang.String noiNhan, java.lang.String trichYeu,
        java.util.List<Long> notInDocIdRelation, java.lang.String sortField,
        int sortType, boolean reverse)
        throws com.liferay.portal.SystemException {
        return getService()
                   .searchBySPH_PST_NN_TY_noRelation(companyId, soPH, phongST,
            noiNhan, trichYeu, notInDocIdRelation, sortField, sortType, reverse);
    }

    public static int countBySPH_PST_NN_TY_noRelation(long companyId,
        java.lang.String soPH, java.lang.String phongST,
        java.lang.String noiNhan, java.lang.String trichYeu,
        java.util.List<Long> notInDocIdRelation)
        throws com.liferay.portal.SystemException {
        return getService()
                   .countBySPH_PST_NN_TY_noRelation(companyId, soPH, phongST,
            noiNhan, trichYeu, notInDocIdRelation);
    }

    public static java.util.List<Long> searchBySPH_PST_NN_TY_noRelation(
        long companyId, java.lang.String soPH, java.lang.String phongST,
        java.lang.String noiNhan, java.lang.String trichYeu,
        java.util.List<Long> notInDocIdRelation, java.lang.String sortField,
        int sortType, boolean reverse, int start, int end)
        throws com.liferay.portal.SystemException {
        return getService()
                   .searchBySPH_PST_NN_TY_noRelation(companyId, soPH, phongST,
            noiNhan, trichYeu, notInDocIdRelation, sortField, sortType,
            reverse, start, end);
    }

    public static long getSoPhatHanhVBDi(long docTypeId, int issuingYear,
        boolean numOfDirector) throws com.liferay.portal.SystemException {
        return getService()
                   .getSoPhatHanhVBDi(docTypeId, issuingYear, numOfDirector);
    }

    public static com.liferay.portal.kernel.search.Hits timKiemVBDi(
        long companyId, int numOfDirector, java.lang.String soPhatHanh,
        long soVanBan, java.lang.String traLoiCongVanSo,
        java.lang.String phongSoanThao, java.lang.String noiNhan,
        java.lang.String nguoiKy, java.util.Date tuNgay,
        java.util.Date denNgay, long soHSCV, java.lang.String trichYeu,
        java.lang.String active, long nguoiSoanThao,
        java.lang.String sortField, int sortType, boolean reverse, int start,
        int end) throws com.liferay.portal.SystemException {
        return getService()
                   .timKiemVBDi(companyId, numOfDirector, soPhatHanh, soVanBan,
            traLoiCongVanSo, phongSoanThao, noiNhan, nguoiKy, tuNgay, denNgay,
            soHSCV, trichYeu, active, nguoiSoanThao, sortField, sortType,
            reverse, start, end);
    }

    public static int countByVBDi_SoVBDiCuaPhong(java.lang.String soPH,
        int ngayPHMonth, int ngayPHYear, java.lang.String phongST,
        java.lang.String noiNhan, long loaiVB, java.lang.String tenNguoiKy,
        long nguoiST, java.lang.String trichYeu, java.lang.String vanBanPH)
        throws com.liferay.portal.SystemException {
        return getService()
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
        return getService()
                   .findByVBDi_SoVBDiCuaPhong(soPH, ngayPHMonth, ngayPHYear,
            phongST, noiNhan, loaiVB, tenNguoiKy, nguoiST, trichYeu, vanBanPH,
            start, end, obc);
    }

    public static int kiemTraSoVaKyHieuVBPhatHanh(
        java.lang.String soVBPhatHanh, int issuingYear, long documentSendId)
        throws com.liferay.portal.SystemException {
        return getService()
                   .kiemTraSoVaKyHieuVBPhatHanh(soVBPhatHanh, issuingYear,
            documentSendId);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findBy_R_B_F_T(
        java.lang.String documentReference, java.lang.String briefContent,
        java.util.Date fromDate, java.util.Date toDate, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .findBy_R_B_F_T(documentReference, briefContent, fromDate,
            toDate, andOperator, start, end, obc);
    }

    public static int countBy_R_B_F_T(java.lang.String documentReference,
        java.lang.String briefContent, java.util.Date fromDate,
        java.util.Date toDate, boolean andOperator) {
        return getService()
                   .countBy_R_B_F_T(documentReference, briefContent, fromDate,
            toDate, andOperator);
    }

    public static int countByDocumentSend_Users_Status_DangXuLy1(
        java.util.List<Long> userIds, long statusId, long soVanBan,
        java.lang.String soKyHieu, java.lang.String donViSoanThao,
        java.lang.String nguoiKy, java.lang.String trichYeu,
        java.lang.String coQuanNhan, java.lang.String tuNgay,
        java.lang.String denNgay) throws java.lang.Exception {
        return getService()
                   .countByDocumentSend_Users_Status_DangXuLy1(userIds,
            statusId, soVanBan, soKyHieu, donViSoanThao, nguoiKy, trichYeu,
            coQuanNhan, tuNgay, denNgay);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByDocumentSend_Users_Status_DangXuLy1(
        java.util.List<Long> userIds, long statusId, long soVanBan,
        java.lang.String soKyHieu, java.lang.String donViSoanThao,
        java.lang.String nguoiKy, java.lang.String trichYeu,
        java.lang.String coQuanNhan, java.lang.String tuNgay,
        java.lang.String denNgay, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .findByDocumentSend_Users_Status_DangXuLy1(userIds,
            statusId, soVanBan, soKyHieu, donViSoanThao, nguoiKy, trichYeu,
            coQuanNhan, tuNgay, denNgay, start, end, obc);
    }

    public static int countByDocumentSend_Users_Status_DangXuLy_TreHan1(
        java.util.List<Long> userIds, long statusId, long soVanBan,
        java.lang.String soKyHieu, java.lang.String donViSoanThao,
        java.lang.String nguoiKy, java.lang.String trichYeu,
        java.lang.String coQuanNhan, java.lang.String tuNgay,
        java.lang.String denNgay) throws java.lang.Exception {
        return getService()
                   .countByDocumentSend_Users_Status_DangXuLy_TreHan1(userIds,
            statusId, soVanBan, soKyHieu, donViSoanThao, nguoiKy, trichYeu,
            coQuanNhan, tuNgay, denNgay);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByDocumentSend_Users_Status_DangXuLy_TreHan1(
        java.util.List<Long> userIds, long statusId, long soVanBan,
        java.lang.String soKyHieu, java.lang.String donViSoanThao,
        java.lang.String nguoiKy, java.lang.String trichYeu,
        java.lang.String coQuanNhan, java.lang.String tuNgay,
        java.lang.String denNgay, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception {
        return getService()
                   .findByDocumentSend_Users_Status_DangXuLy_TreHan1(userIds,
            statusId, soVanBan, soKyHieu, donViSoanThao, nguoiKy, trichYeu,
            coQuanNhan, tuNgay, denNgay, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> getListCVDiDaXuLyChung1(
        long userId, long soVanBan, java.lang.String soKyHieu,
        java.lang.String donViSoanThao, java.lang.String nguoiKy,
        java.lang.String trichYeu, java.lang.String coQuanNhan,
        java.lang.String tuNgay, java.lang.String denNgay, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getListCVDiDaXuLyChung1(userId, soVanBan, soKyHieu,
            donViSoanThao, nguoiKy, trichYeu, coQuanNhan, tuNgay, denNgay,
            start, end, obc);
    }

    public static int countListCVDiDaXuLyChung1(long userId, long soVanBan,
        java.lang.String soKyHieu, java.lang.String donViSoanThao,
        java.lang.String nguoiKy, java.lang.String trichYeu,
        java.lang.String coQuanNhan, java.lang.String tuNgay,
        java.lang.String denNgay) throws com.liferay.portal.SystemException {
        return getService()
                   .countListCVDiDaXuLyChung1(userId, soVanBan, soKyHieu,
            donViSoanThao, nguoiKy, trichYeu, coQuanNhan, tuNgay, denNgay);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> getListCVDiDaXuLyTuXuLy1(
        long userId, long soVanBan, java.lang.String soKyHieu,
        java.lang.String donViSoanThao, java.lang.String nguoiKy,
        java.lang.String trichYeu, java.lang.String coQuanNhan,
        java.lang.String tuNgay, java.lang.String denNgay, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getListCVDiDaXuLyTuXuLy1(userId, soVanBan, soKyHieu,
            donViSoanThao, nguoiKy, trichYeu, coQuanNhan, tuNgay, denNgay,
            start, end, obc);
    }

    public static int countListCVDiDaXuLyTuXuLy1(long userId, long soVanBan,
        java.lang.String soKyHieu, java.lang.String donViSoanThao,
        java.lang.String nguoiKy, java.lang.String trichYeu,
        java.lang.String coQuanNhan, java.lang.String tuNgay,
        java.lang.String denNgay) throws com.liferay.portal.SystemException {
        return getService()
                   .countListCVDiDaXuLyTuXuLy1(userId, soVanBan, soKyHieu,
            donViSoanThao, nguoiKy, trichYeu, coQuanNhan, tuNgay, denNgay);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> getListCVDiDaXuLyChung_treHan1(
        long userId, long soVanBan, java.lang.String soKyHieu,
        java.lang.String donViSoanThao, java.lang.String nguoiKy,
        java.lang.String trichYeu, java.lang.String coQuanNhan,
        java.lang.String tuNgay, java.lang.String denNgay, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getListCVDiDaXuLyChung_treHan1(userId, soVanBan, soKyHieu,
            donViSoanThao, nguoiKy, trichYeu, coQuanNhan, tuNgay, denNgay,
            start, end, obc);
    }

    public static int countListCVDiDaXuLyChung_treHan1(long userId,
        long soVanBan, java.lang.String soKyHieu,
        java.lang.String donViSoanThao, java.lang.String nguoiKy,
        java.lang.String trichYeu, java.lang.String coQuanNhan,
        java.lang.String tuNgay, java.lang.String denNgay)
        throws com.liferay.portal.SystemException {
        return getService()
                   .countListCVDiDaXuLyChung_treHan1(userId, soVanBan,
            soKyHieu, donViSoanThao, nguoiKy, trichYeu, coQuanNhan, tuNgay,
            denNgay);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> getListCVDiDaXuLyTuXuLy_treHan1(
        long userId, long soVanBan, java.lang.String soKyHieu,
        java.lang.String donViSoanThao, java.lang.String nguoiKy,
        java.lang.String trichYeu, java.lang.String coQuanNhan,
        java.lang.String tuNgay, java.lang.String denNgay, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getListCVDiDaXuLyTuXuLy_treHan1(userId, soVanBan, soKyHieu,
            donViSoanThao, nguoiKy, trichYeu, coQuanNhan, tuNgay, denNgay,
            start, end, obc);
    }

    public static int countListCVDiDaXuLyTuXuLy_treHan1(long userId,
        long soVanBan, java.lang.String soKyHieu,
        java.lang.String donViSoanThao, java.lang.String nguoiKy,
        java.lang.String trichYeu, java.lang.String coQuanNhan,
        java.lang.String tuNgay, java.lang.String denNgay)
        throws com.liferay.portal.SystemException {
        return getService()
                   .countListCVDiDaXuLyTuXuLy_treHan1(userId, soVanBan,
            soKyHieu, donViSoanThao, nguoiKy, trichYeu, coQuanNhan, tuNgay,
            denNgay);
    }

    public static PmlEdmDocumentSendLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "PmlEdmDocumentSendLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlEdmDocumentSendLocalService service) {
        _service = service;
    }
}
