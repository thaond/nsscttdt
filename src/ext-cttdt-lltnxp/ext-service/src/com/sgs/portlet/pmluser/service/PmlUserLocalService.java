package com.sgs.portlet.pmluser.service;


/**
 * <a href="PmlUserLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.pmluser.service.impl.PmlUserLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil
 *
 */
public interface PmlUserLocalService {
    public com.sgs.portlet.pmluser.model.PmlUser addPmlUser(
        com.sgs.portlet.pmluser.model.PmlUser pmlUser)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pmluser.model.PmlUser createPmlUser(long userId);

    public void deletePmlUser(long userId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlUser(com.sgs.portlet.pmluser.model.PmlUser pmlUser)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pmluser.model.PmlUser getPmlUser(long userId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.pmluser.model.PmlUser> getPmlUsers(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlUsersCount() throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pmluser.model.PmlUser updatePmlUser(
        com.sgs.portlet.pmluser.model.PmlUser pmlUser)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pmluser.model.PmlUser findByUserId(long userId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmluser.model.PmlUser> searchByDep(
        java.lang.String departmentsId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int searchCountByDep(java.lang.String departmentsId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmluser.model.PmlUser> getListUserByFieldId(
        java.lang.String fieldId);

    public int countFileTonTruoc(long userId, java.util.Date date);

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> getListForTonTruoc(
        long userId, java.util.Date date);

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileTonTruoc(
        long userId, java.util.Date date);

    public int countFileDaNhan(long userId, java.util.Date date);

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> getListForDaNhan(
        long userId, java.util.Date date);

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileDaNhan(
        long userId, java.util.Date date);

    public int countFileChuaNhan(long userId, java.util.Date date);

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> getListForChuaNhan(
        long userId, java.util.Date date);

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileChuaNhan(
        long userId, java.util.Date date);

    public int countFileTuGiaiQuyet(long userId, java.util.Date date);

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> getListForTuGiaiQuyet(
        long userId, java.util.Date date);

    public int countFileNguoiKhacThuLyThay(long userId, java.util.Date date);

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> getListForNguoiKhacThuLyThay(
        long userId, java.util.Date date);

    public int countFileTrongHanISO(long userId, java.util.Date date);

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> getListForTrongHanISO(
        long userId, java.util.Date date);

    public int countFileQuaHanISO(long userId, java.util.Date date);

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> getListForQuaHanISO(
        long userId, java.util.Date date);

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileQuaHanISO(
        long userId, java.util.Date date);

    public int countFileChoBoSung(long userId, java.util.Date date);

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileDangChoBoSung(
        long userId, java.util.Date date);

    public int getTonDauKy(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> pmlFilePCCCList,
        int pmlFilePCCCSize, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception;

    public int getHoSoNhanTrongThang(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> pmlFilePCCCList,
        int pmlFilePCCCSize, java.util.Date fromDate, java.util.Date toDate);

    public int getSoLuongHoSoDungHan(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> pmlFilePCCCList,
        int pmlFilePCCCSize, java.util.Date fromDate, java.util.Date toDate);

    public int getSoLuongHoSoTreHan(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> pmlFilePCCCList,
        int pmlFilePCCCSize, java.util.Date fromDate, java.util.Date toDate);

    public int getSoLuongHoSoTrongHan(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> pmlFilePCCCList,
        int pmlFilePCCCSize, java.util.Date fromDate, java.util.Date toDate);

    public int getSoLuongHoSoDaTreHan(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> pmlFilePCCCList,
        int pmlFilePCCCSize, java.util.Date fromDate, java.util.Date toDate);

    public int getSoLuongHoSoChinhSuBoSung(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> pmlFilePCCCList,
        int pmlFilePCCCSize, java.util.Date fromDate, java.util.Date toDate);

    public int getTonDauKyThangLuyKe(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> pmlFilePCCCList,
        int pmlFilePCCCSize, java.util.Date fromDate, java.util.Date toDate);

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileTonDauKyThangLuyKe(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> pmlFilePCCCList,
        int pmlFilePCCCSize, java.util.Date fromDate, java.util.Date toDate);

    public int getHoSoNhanTuNgayDenNgayThangLuyKe(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> pmlFilePCCCList,
        int pmlFilePCCCSize, java.util.Date fromDate, java.util.Date toDate);

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileHoSoNhanTuNgayDenNgayThangLuyKe(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> pmlFilePCCCList,
        int pmlFilePCCCSize, java.util.Date fromDate, java.util.Date toDate);

    public int getHoSoNhanTrongThangThangLuyKe(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> pmlFilePCCCList,
        int pmlFilePCCCSize, java.util.Date fromDate, java.util.Date toDate);

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileHoSoNhanTrongThangThangLuyKe(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> pmlFilePCCCList,
        int pmlFilePCCCSize, java.util.Date fromDate, java.util.Date toDate);

    public int getHoSoNhanTrongNamThangLuyKe(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> pmlFilePCCCList,
        int pmlFilePCCCSize, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileHoSoNhanTrongNamThangLuyKe(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> pmlFilePCCCList,
        int pmlFilePCCCSize, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception;

    public int getHoSoGiaiQuyetTuNgayDenNgayThangLuyKe(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> pmlFilePCCCList,
        int pmlFilePCCCSize, java.util.Date fromDate, java.util.Date toDate);

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileHoSoGiaiQuyetTuNgayDenNgayThangLuyKe(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> pmlFilePCCCList,
        int pmlFilePCCCSize, java.util.Date fromDate, java.util.Date toDate);

    public int getHoSoGiaiQuyetTrongThangThangLuyKe(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> pmlFilePCCCList,
        int pmlFilePCCCSize, java.util.Date fromDate, java.util.Date toDate);

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileHoSoGiaiQuyetTrongThangThangLuyKe(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> pmlFilePCCCList,
        int pmlFilePCCCSize, java.util.Date fromDate, java.util.Date toDate);

    public int getHoSoGiaiQuyetTrongNam(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> pmlFilePCCCList,
        int pmlFilePCCCSize, java.util.Date toDate) throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileHoSoGiaiQuyetTrongNam(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> pmlFilePCCCList,
        int pmlFilePCCCSize, java.util.Date toDate) throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileHoSoTonThangLuyKe(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> pmlFilePCCCList,
        int pmlFilePCCCSize, java.util.Date toDate) throws java.lang.Exception;

    public int getSoLuongHoSoTonTruocCapSo(
        java.util.List<com.sgs.portlet.pmluser.model.PmlUser> pmlUserList,
        java.util.Date date) throws java.lang.Exception;

    public int getSoLuongHoSoDaNhanCapSo(
        java.util.List<com.sgs.portlet.pmluser.model.PmlUser> pmlUserList,
        java.util.Date date) throws java.lang.Exception;

    public int getSoLuongHoSoChuaNhanCapSo(
        java.util.List<com.sgs.portlet.pmluser.model.PmlUser> pmlUserList,
        java.util.Date date) throws java.lang.Exception;

    public int getSoLuongHoSoGiaiQuyetCapSo(
        java.util.List<com.sgs.portlet.pmluser.model.PmlUser> pmlUserList,
        java.util.Date date) throws java.lang.Exception;

    public int getSoLuongHoSoTrongHanISOCapSo(
        java.util.List<com.sgs.portlet.pmluser.model.PmlUser> pmlUserList,
        java.util.Date date) throws java.lang.Exception;

    public int getSoLuongHoSoQuaHanISOCapSo(
        java.util.List<com.sgs.portlet.pmluser.model.PmlUser> pmlUserList,
        java.util.Date date) throws java.lang.Exception;

    public java.lang.String getFullName(long userId) throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> getListFileForUser(
        long userId);

    public int searchCount(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int searchCount(java.lang.String screenName,
        java.lang.String lastName, java.lang.String middleName,
        java.lang.String firstName, java.lang.String positionId,
        boolean andOperator) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmluser.model.PmlUser> search(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmluser.model.PmlUser> search(
        java.lang.String screenName, java.lang.String lastName,
        java.lang.String middleName, java.lang.String firstName,
        java.lang.String positionId, boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findUserListByDepartmentId(
        java.lang.String departmentsId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int countUserListByDepartmentId(java.lang.String departmentsId)
        throws java.lang.Exception;

    public int countTinhHinhThuLyCongVanChuyenVien(
        java.lang.String departmentId) throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findUserListByDepartment(
        java.lang.String departmentsId, int start, int end)
        throws com.liferay.portal.SystemException;

    public int countUserListByDepartment(java.lang.String departmentsId)
        throws java.lang.Exception;

    public void synchronizePmlUserWithPortalUser() throws java.lang.Exception;

    public boolean removePmlUser(long userId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portal.model.User> listUserTheoDoiHoSo(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int countUserTheoDoiHoSo() throws com.liferay.portal.SystemException;
}
