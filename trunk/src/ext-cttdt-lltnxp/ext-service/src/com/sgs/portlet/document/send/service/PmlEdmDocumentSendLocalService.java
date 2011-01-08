package com.sgs.portlet.document.send.service;


/**
 * <a href="PmlEdmDocumentSendLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.document.send.service.impl.PmlEdmDocumentSendLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.document.send.service.PmlEdmDocumentSendLocalServiceUtil
 *
 */
public interface PmlEdmDocumentSendLocalService {
    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend addPmlEdmDocumentSend(
        com.sgs.portlet.document.send.model.PmlEdmDocumentSend pmlEdmDocumentSend)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend createPmlEdmDocumentSend(
        long documentSendId);

    public void deletePmlEdmDocumentSend(long documentSendId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlEdmDocumentSend(
        com.sgs.portlet.document.send.model.PmlEdmDocumentSend pmlEdmDocumentSend)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend getPmlEdmDocumentSend(
        long documentSendId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> getPmlEdmDocumentSends(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlEdmDocumentSendsCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend updatePmlEdmDocumentSend(
        com.sgs.portlet.document.send.model.PmlEdmDocumentSend pmlEdmDocumentSend)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> filter(
        java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> list,
        java.lang.String briefContent, long signer, java.util.Date issuingDate,
        java.lang.String documentReference, java.lang.String receivingPlace);

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> filter(
        java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> list,
        java.lang.String briefContent, java.util.Date issuingDate,
        java.lang.String documentReference, java.lang.String receivingPlace);

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> filterByIssuingPlace(
        java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> list,
        java.lang.String receivingPlace);

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> filterByDocumentReference(
        java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> list,
        java.lang.String documentReference);

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> filterByIssuingDate(
        java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> list,
        java.util.Date issuingDate);

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> filterBySigner(
        java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> list,
        long signer);

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> filterByBriefContent(
        java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> list,
        java.lang.String briefContent);

    public int countByS_L_T_P_N_N_TN_DN_S_T(java.lang.String soPhatHanh,
        long loaiCongVan, java.lang.String traLoiCongVanSo,
        java.lang.String phongSoanThao, java.lang.String noiNhan, long nguoiKy,
        java.lang.String tuNgay, java.lang.String denNgay, long soHSCV,
        java.lang.String trichYeu) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByS_L_T_P_N_N_TN_DN_S_T(
        java.lang.String soPhatHanh, long loaiCongVan,
        java.lang.String traLoiCongVanSo, java.lang.String phongSoanThao,
        java.lang.String noiNhan, long nguoiKy, java.lang.String tuNgay,
        java.lang.String denNgay, long soHSCV, java.lang.String trichYeu,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int countDocSendNeedProcess(long userId)
        throws com.liferay.portal.SystemException;

    public int countByDocumentSend_Users_Status_DangXuLy(
        java.util.List<Long> userIds, long statusId, java.lang.String soCVDen,
        java.lang.String capGui) throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByDocumentSend_Users_Status_DangXuLy(
        java.util.List<Long> userIds, long statusId, java.lang.String soCVDen,
        java.lang.String capGui, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countByDocumentSend_Users_Status_DangXuLy_TreHan(
        java.util.List<Long> userIds, long statusId,
        java.lang.String loaisocongvan, java.lang.String capGui)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByDocumentSend_Users_Status_DangXuLy_TreHan(
        java.util.List<Long> userIds, long statusId,
        java.lang.String loaisocongvan, java.lang.String capGui, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countByDocumentSend_Users(java.util.List<Long> userIds,
        java.lang.String loaisocongvan) throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByDocumentSend_Users(
        java.util.List<Long> userIds, java.lang.String loaisocongvan,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countDocumentType(int documentTypeId,
        java.lang.String departmentsId)
        throws com.liferay.portal.SystemException;

    public long getMaxDocumentSendId()
        throws com.liferay.portal.SystemException;

    public long getMaxDocRefByTypeYear(long docTypeId, int issuingYear)
        throws com.liferay.portal.SystemException;

    public void reIndext(long companyId,
        com.sgs.portlet.document.send.model.PmlEdmDocumentSend documentSend)
        throws com.liferay.portal.kernel.search.SearchException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend addPmlEdmDocumentSend(
        long companyId, java.lang.String briefContent,
        java.lang.String documentReference, java.lang.String receivingPlace,
        long editorId, long documentTypeId, java.lang.String privilegeLevelId,
        java.lang.String confidentialLevelId, java.util.Date dateCreated,
        boolean isLocal)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend addPmlEdmDocumentSend(
        long companyId,
        com.sgs.portlet.document.send.model.PmlEdmDocumentSend pmlEdmDocumentSend)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend updatePmlEdmDocumentSend(
        long companyId, long documentSendId, java.lang.String briefContent,
        java.lang.String documentReference, java.lang.String receivingPlace,
        long editorId, long documentTypeId, java.lang.String privilegeLevelId,
        java.lang.String confidentialLevelId, java.util.Date dateCreated,
        boolean isLocal)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;

    public com.sgs.portlet.document.send.model.PmlEdmDocumentSend updatePmlEdmDocumentSend(
        long companyId,
        com.sgs.portlet.document.send.model.PmlEdmDocumentSend documentSend)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException;

    public void deletePmlEdmDocumentSend(long companyId, long documentSendId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException,
            com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;

    public void deletePmlEdmDocumentSend(long companyId,
        com.sgs.portlet.document.send.model.PmlEdmDocumentSend pmlEdmDocumentSend)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException;

    public com.liferay.portal.kernel.search.Hits search(long companyId,
        java.lang.String soPhatHanh, long loaiCongVan,
        java.lang.String traLoiCongVanSo, java.lang.String phongSoanThao,
        java.lang.String noiNhan, java.lang.String nguoiKy,
        java.util.Date tuNgay, java.util.Date denNgay, long soHSCV,
        java.lang.String trichYeu, java.lang.String active, long nguoiSoanThao,
        int start, int end) throws com.liferay.portal.SystemException;

    public com.liferay.portal.kernel.search.Hits search(long companyId,
        java.lang.String soPhatHanh, long loaiCongVan,
        java.lang.String traLoiCongVanSo, java.lang.String phongSoanThao,
        java.lang.String noiNhan, java.lang.String nguoiKy,
        java.util.Date tuNgay, java.util.Date denNgay, long soHSCV,
        java.lang.String trichYeu, java.lang.String active, long nguoiSoanThao,
        java.lang.String sortField, int sortType, int start, int end)
        throws com.liferay.portal.SystemException;

    public com.liferay.portal.kernel.search.Hits search(long companyId,
        java.lang.String soPhatHanh, long loaiCongVan,
        java.lang.String traLoiCongVanSo, java.lang.String phongSoanThao,
        java.lang.String noiNhan, java.lang.String nguoiKy,
        java.util.Date tuNgay, java.util.Date denNgay, long soHSCV,
        java.lang.String trichYeu, java.lang.String active, long nguoiSoanThao,
        java.lang.String sortField, int sortType, boolean reverse, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.liferay.portal.kernel.search.Hits search(long companyId,
        java.lang.String soPhatHanh, long loaiCongVan,
        java.lang.String traLoiCongVanSo, java.lang.String phongSoanThao,
        java.lang.String noiNhan, java.lang.String nguoiKy,
        java.util.Date tuNgay, java.util.Date denNgay, long soHSCV,
        java.lang.String trichYeu, java.lang.String active,
        java.lang.String sortField, int sortType, boolean reverse, int start,
        int end) throws com.liferay.portal.SystemException;

    public int countTonDauKyChuyenVien_CVDi(long userId,
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listTonDauKyChuyenVien_CVDi(
        long userId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countNhanTrongKyChuyenVien_CVDi(long userId,
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listNhanTrongKyChuyenVien_CVDi(
        long userId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countChuaNhanChuyenVien_CVDi(long userId,
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listChuaNhanChuyenVien_CVDi(
        long userId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countNhanTrongThangChuyenVien_CVDi(long userId,
        int documentRecordTypeId, int loaiVB, java.util.Date fromDate,
        java.util.Date toDate) throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listNhanTrongThangChuyenVien_CVDi(
        long userId, int documentRecordTypeId, int loaiVB,
        java.util.Date fromDate, java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countDungHanDaXuLyChuyenVien_CVDi(long userId,
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listDungHanDaXuLyChuyenVien_CVDi(
        long userId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countTreHanDaXuLyChuyenVien_CVDi(long userId,
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listTreHanDaXuLyChuyenVien_CVDi(
        long userId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countTongDaXuLyChuyenVien_CVDi(long userId,
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listTongDaXuLyChuyenVien_CVDi(
        long userId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countDungHanDangXuLyChuyenVien_CVDi(long userId,
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listDungHanDangXuLyChuyenVien_CVDi(
        long userId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countTreHanDangXuLyChuyenVien_CVDi(long userId,
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listTreHanDangXuLyChuyenVien_CVDi(
        long userId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countTongDangXuLyChuyenVien_CVDi(long userId,
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listTongDangXuLyChuyenVien_CVDi(
        long userId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countTonDauKyPhongBan_CVDi(java.lang.String departmentId,
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listTonDauKyPhongBan_CVDi(
        java.lang.String departmentId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countNhanTrongKyPhongBan_CVDi(java.lang.String departmentId,
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listNhanTrongKyPhongBan_CVDi(
        java.lang.String departmentId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countChuaNhanTrongKyPhongBan_CVDi(
        java.lang.String departmentId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listChuaNhanTrongKyPhongBan_CVDi(
        java.lang.String departmentId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countDungHanDaXuLyPhongBan_CVDi(java.lang.String departmentId,
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listDungHanDaXuLyPhongBan_CVDi(
        java.lang.String departmentId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countTreHanDaXuLyPhongBan_CVDi(java.lang.String departmentId,
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listTreHanDaXuLyPhongBan_CVDi(
        java.lang.String departmentId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countTongDaXuLyPhongBan_CVDi(java.lang.String departmentId,
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listTongDaXuLyPhongBan_CVDi(
        java.lang.String departmentId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countDungHanDangXuLyPhongBan_CVDi(
        java.lang.String departmentId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listDungHanDangXuLyPhongBan_CVDi(
        java.lang.String departmentId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countTreHanDangXuLyPhongBan_CVDi(java.lang.String departmentId,
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listTreHanDangXuLyPhongBan_CVDi(
        java.lang.String departmentId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countTongDangXuLyPhongBan_CVDi(java.lang.String departmentId,
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listTongDangXuLyPhongBan_CVDi(
        java.lang.String departmentId, int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countTonDauKySo_CVDi(int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listTonDauKySo_CVDi(
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countNhanTrongKySo_CVDi(int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listNhanTrongKySo_CVDi(
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countDungHanDaXuLySo_CVDi(int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listDungHanDaXuLySo_CVDi(
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countTreHanDaXuLySo_CVDi(int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listTreHanDaXuLySo_CVDi(
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countTongDaXuLySo_CVDi(int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listTongDaXuLySo_CVDi(
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countDungHanDangXuLySo_CVDi(int documentRecordTypeId,
        int loaiVB, java.lang.String doMat, java.util.Date fromDate,
        java.util.Date toDate) throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listDungHanDangXuLySo_CVDi(
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countTreHanDangXuLySo_CVDi(int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listTreHanDangXuLySo_CVDi(
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countTongDangXuLySo_CVDi(int documentRecordTypeId, int loaiVB,
        java.lang.String doMat, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> listTongDangXuLySo_CVDi(
        int documentRecordTypeId, int loaiVB, java.lang.String doMat,
        java.util.Date fromDate, java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> getListPmlEdmDocumentSend(
        int loaiSoCongVan, java.lang.String fromDate, java.lang.String toDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> getListPmlEdmDocumentSendByLoaiSoCV(
        java.lang.String loaiSoCongVan, java.lang.String fromDate,
        java.lang.String toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countListPmlEdmDocumentSendByLoaiSoCV(
        java.lang.String loaiSoCongVan, java.lang.String fromDate,
        java.lang.String toDate) throws com.liferay.portal.SystemException;

    public int countListCVDiDaXuLyTuXuLy(long userId, java.lang.String year,
        java.lang.String loaisocongvan)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> getListCVDiDaXuLyTuXuLy(
        long userId, java.lang.String year, java.lang.String loaisocongvan,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int countListCVDiDaXuLyChung(long userId, java.lang.String year,
        java.lang.String loaisocongvan)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> getListCVDiDaXuLyChung(
        long userId, java.lang.String year, java.lang.String loaisocongvan,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> getListCVDiDaXuLyChung_treHan(
        long userId, java.lang.String year, java.lang.String loaisocongvan,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int countListCVDiDaXuLyChung_treHan(long userId,
        java.lang.String year, java.lang.String loaisocongvan)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> getListCVDiDaXuLyTuXuLy_treHan(
        long userId, java.lang.String year, java.lang.String loaisocongvan,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int countListCVDiDaXuLyTuXuLy_treHan(long userId,
        java.lang.String year, java.lang.String loaisocongvan)
        throws com.liferay.portal.SystemException;

    public int countByD_I_D_R_D_S_E_B(java.lang.String soPH, int ngayPHMonth,
        int ngayPHYear, java.lang.String phongST, java.lang.String noiNhan,
        long loaiVB, java.lang.String tenNguoiKy, long nguoiST,
        java.lang.String trichYeu) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByD_I_D_R_D_S_E_B(
        java.lang.String soPH, int ngayPHMonth, int ngayPHYear,
        java.lang.String phongST, java.lang.String noiNhan, long loaiVB,
        java.lang.String tenNguoiKy, long nguoiST, java.lang.String trichYeu,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int countByLOAIVB_NGUOIKY(long loaiVB, java.lang.String nguoiKy,
        boolean andOperator) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByLOAIVB_NGUOIKY(
        long loaiVB, java.lang.String nguoiKy, boolean andOperator, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> getListCVDiDaXuLyChung(
        long userId, long loaiVB, java.lang.String soKyHieu,
        java.lang.String donViSoanThao, java.lang.String nguoiKy,
        java.lang.String trichYeu, java.lang.String coQuanNhan,
        java.lang.String tuNgay, java.lang.String denNgay, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int countListCVDiDaXuLyChung(long userId, long loaiVB,
        java.lang.String soKyHieu, java.lang.String donViSoanThao,
        java.lang.String nguoiKy, java.lang.String trichYeu,
        java.lang.String coQuanNhan, java.lang.String tuNgay,
        java.lang.String denNgay) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> getListCVDiDaXuLyTuXuLy(
        long userId, long loaiVB, java.lang.String soKyHieu,
        java.lang.String donViSoanThao, java.lang.String nguoiKy,
        java.lang.String trichYeu, java.lang.String coQuanNhan,
        java.lang.String tuNgay, java.lang.String denNgay, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int countListCVDiDaXuLyTuXuLy(long userId, long loaiVB,
        java.lang.String soKyHieu, java.lang.String donViSoanThao,
        java.lang.String nguoiKy, java.lang.String trichYeu,
        java.lang.String coQuanNhan, java.lang.String tuNgay,
        java.lang.String denNgay) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> getListCVDiDaXuLyChung_treHan(
        long userId, long loaiVB, java.lang.String soKyHieu,
        java.lang.String donViSoanThao, java.lang.String nguoiKy,
        java.lang.String trichYeu, java.lang.String coQuanNhan,
        java.lang.String tuNgay, java.lang.String denNgay, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int countListCVDiDaXuLyChung_treHan(long userId, long loaiVB,
        java.lang.String soKyHieu, java.lang.String donViSoanThao,
        java.lang.String nguoiKy, java.lang.String trichYeu,
        java.lang.String coQuanNhan, java.lang.String tuNgay,
        java.lang.String denNgay) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> getListCVDiDaXuLyTuXuLy_treHan(
        long userId, long loaiVB, java.lang.String soKyHieu,
        java.lang.String donViSoanThao, java.lang.String nguoiKy,
        java.lang.String trichYeu, java.lang.String coQuanNhan,
        java.lang.String tuNgay, java.lang.String denNgay, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int countListCVDiDaXuLyTuXuLy_treHan(long userId, long loaiVB,
        java.lang.String soKyHieu, java.lang.String donViSoanThao,
        java.lang.String nguoiKy, java.lang.String trichYeu,
        java.lang.String coQuanNhan, java.lang.String tuNgay,
        java.lang.String denNgay) throws com.liferay.portal.SystemException;

    public int countByDocumentSend_Users_Status_DangXuLy(
        java.util.List<Long> userIds, long statusId, long loaiVB,
        java.lang.String soKyHieu, java.lang.String donViSoanThao,
        java.lang.String nguoiKy, java.lang.String trichYeu,
        java.lang.String coQuanNhan, java.lang.String tuNgay,
        java.lang.String denNgay) throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByDocumentSend_Users_Status_DangXuLy(
        java.util.List<Long> userIds, long statusId, long loaiVB,
        java.lang.String soKyHieu, java.lang.String donViSoanThao,
        java.lang.String nguoiKy, java.lang.String trichYeu,
        java.lang.String coQuanNhan, java.lang.String tuNgay,
        java.lang.String denNgay, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countByDocumentSend_Users_Status_DangXuLy_TreHan(
        java.util.List<Long> userIds, long statusId, long loaiVB,
        java.lang.String soKyHieu, java.lang.String donViSoanThao,
        java.lang.String nguoiKy, java.lang.String trichYeu,
        java.lang.String coQuanNhan, java.lang.String tuNgay,
        java.lang.String denNgay) throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByDocumentSend_Users_Status_DangXuLy_TreHan(
        java.util.List<Long> userIds, long statusId, long loaiVB,
        java.lang.String soKyHieu, java.lang.String donViSoanThao,
        java.lang.String nguoiKy, java.lang.String trichYeu,
        java.lang.String coQuanNhan, java.lang.String tuNgay,
        java.lang.String denNgay, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByDocumentSend_Users(
        java.util.List<Long> userIds, long loaiVB,
        java.lang.String donViSoanThao, java.lang.String nguoiKy,
        java.lang.String trichYeu, java.lang.String coQuanNhan,
        java.lang.String tuNgay, java.lang.String denNgay, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public int countByDocumentSend_Users(java.util.List<Long> userIds,
        long loaiVB, java.lang.String donViSoanThao, java.lang.String nguoiKy,
        java.lang.String trichYeu, java.lang.String coQuanNhan,
        java.lang.String tuNgay, java.lang.String denNgay)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendLog_Users_Status_DangXuLy(
        java.util.List<Long> userIds, long statusId, long loaiVB,
        java.lang.String soKyHieu, java.lang.String donViSoanThao,
        java.lang.String nguoiKy, java.lang.String trichYeu,
        java.lang.String coQuanNhan, java.lang.String tuNgay,
        java.lang.String denNgay, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendLog_Users_Status_DangXuLy_TreHan(
        java.util.List<Long> userIds, long statusId, long loaiVB,
        java.lang.String soKyHieu, java.lang.String donViSoanThao,
        java.lang.String nguoiKy, java.lang.String trichYeu,
        java.lang.String coQuanNhan, java.lang.String tuNgay,
        java.lang.String denNgay, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendLog_Users(
        java.util.List<Long> userIds, long loaiVB,
        java.lang.String donViSoanThao, java.lang.String nguoiKy,
        java.lang.String trichYeu, java.lang.String coQuanNhan,
        java.lang.String tuNgay, java.lang.String denNgay, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws java.lang.Exception;

    public java.util.List<Long> searchBySPH_PST_NN_TY_noRelation(
        long companyId, java.lang.String soPH, java.lang.String phongST,
        java.lang.String noiNhan, java.lang.String trichYeu,
        java.util.List<Long> notInDocIdRelation, java.lang.String sortField,
        int sortType, boolean reverse)
        throws com.liferay.portal.SystemException;

    public int countBySPH_PST_NN_TY_noRelation(long companyId,
        java.lang.String soPH, java.lang.String phongST,
        java.lang.String noiNhan, java.lang.String trichYeu,
        java.util.List<Long> notInDocIdRelation)
        throws com.liferay.portal.SystemException;

    public java.util.List<Long> searchBySPH_PST_NN_TY_noRelation(
        long companyId, java.lang.String soPH, java.lang.String phongST,
        java.lang.String noiNhan, java.lang.String trichYeu,
        java.util.List<Long> notInDocIdRelation, java.lang.String sortField,
        int sortType, boolean reverse, int start, int end)
        throws com.liferay.portal.SystemException;

    public long getSoPhatHanhVBDi(long docTypeId, int issuingYear,
        boolean numOfDirector) throws com.liferay.portal.SystemException;

    public com.liferay.portal.kernel.search.Hits timKiemVBDi(long companyId,
        int numOfDirector, java.lang.String soPhatHanh, long loaiCongVan,
        java.lang.String traLoiCongVanSo, java.lang.String phongSoanThao,
        java.lang.String noiNhan, java.lang.String nguoiKy,
        java.util.Date tuNgay, java.util.Date denNgay, long soHSCV,
        java.lang.String trichYeu, java.lang.String active, long nguoiSoanThao,
        java.lang.String sortField, int sortType, boolean reverse, int start,
        int end) throws com.liferay.portal.SystemException;

    public int countByVBDi_SoVBDiCuaPhong(java.lang.String soPH,
        int ngayPHMonth, int ngayPHYear, java.lang.String phongST,
        java.lang.String noiNhan, long loaiVB, java.lang.String tenNguoiKy,
        long nguoiST, java.lang.String trichYeu, java.lang.String vanBanPH)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> findByVBDi_SoVBDiCuaPhong(
        java.lang.String soPH, int ngayPHMonth, int ngayPHYear,
        java.lang.String phongST, java.lang.String noiNhan, long loaiVB,
        java.lang.String tenNguoiKy, long nguoiST, java.lang.String trichYeu,
        java.lang.String vanBanPH, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int kiemTraSoVaKyHieuVBPhatHanh(java.lang.String soVBPhatHanh,
        int issuingYear, long documentSendId)
        throws com.liferay.portal.SystemException;
}
