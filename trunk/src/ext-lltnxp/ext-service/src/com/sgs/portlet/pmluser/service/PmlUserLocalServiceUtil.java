package com.sgs.portlet.pmluser.service;


/**
 * <a href="PmlUserLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.pmluser.service.PmlUserLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pmluser.service.PmlUserLocalService
 *
 */
public class PmlUserLocalServiceUtil {
    private static PmlUserLocalService _service;

    public static com.sgs.portlet.pmluser.model.PmlUser addPmlUser(
        com.sgs.portlet.pmluser.model.PmlUser pmlUser)
        throws com.liferay.portal.SystemException {
        return getService().addPmlUser(pmlUser);
    }

    public static com.sgs.portlet.pmluser.model.PmlUser createPmlUser(
        long userId) {
        return getService().createPmlUser(userId);
    }

    public static void deletePmlUser(long userId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlUser(userId);
    }

    public static void deletePmlUser(
        com.sgs.portlet.pmluser.model.PmlUser pmlUser)
        throws com.liferay.portal.SystemException {
        getService().deletePmlUser(pmlUser);
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

    public static com.sgs.portlet.pmluser.model.PmlUser getPmlUser(long userId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlUser(userId);
    }

    public static java.util.List<com.sgs.portlet.pmluser.model.PmlUser> getPmlUsers(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlUsers(start, end);
    }

    public static int getPmlUsersCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlUsersCount();
    }

    public static com.sgs.portlet.pmluser.model.PmlUser updatePmlUser(
        com.sgs.portlet.pmluser.model.PmlUser pmlUser)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlUser(pmlUser);
    }

    public static com.sgs.portlet.pmluser.model.PmlUser findByUserId(
        long userId) throws com.liferay.portal.SystemException {
        return getService().findByUserId(userId);
    }

    public static java.util.List<com.sgs.portlet.pmluser.model.PmlUser> searchByDep(
        java.lang.String departmentsId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().searchByDep(departmentsId, start, end, obc);
    }

    public static int searchCountByDep(java.lang.String departmentsId)
        throws com.liferay.portal.SystemException {
        return getService().searchCountByDep(departmentsId);
    }

    public static java.util.List<com.sgs.portlet.pmluser.model.PmlUser> getListUserByFieldId(
        java.lang.String fieldId) {
        return getService().getListUserByFieldId(fieldId);
    }

    public static int countFileTonTruoc(long userId, java.util.Date date) {
        return getService().countFileTonTruoc(userId, date);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> getListForTonTruoc(
        long userId, java.util.Date date) {
        return getService().getListForTonTruoc(userId, date);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileTonTruoc(
        long userId, java.util.Date date) {
        return getService().getListFileTonTruoc(userId, date);
    }

    public static int countFileDaNhan(long userId, java.util.Date date) {
        return getService().countFileDaNhan(userId, date);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> getListForDaNhan(
        long userId, java.util.Date date) {
        return getService().getListForDaNhan(userId, date);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileDaNhan(
        long userId, java.util.Date date) {
        return getService().getListFileDaNhan(userId, date);
    }

    public static int countFileChuaNhan(long userId, java.util.Date date) {
        return getService().countFileChuaNhan(userId, date);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> getListForChuaNhan(
        long userId, java.util.Date date) {
        return getService().getListForChuaNhan(userId, date);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileChuaNhan(
        long userId, java.util.Date date) {
        return getService().getListFileChuaNhan(userId, date);
    }

    public static int countFileTuGiaiQuyet(long userId, java.util.Date date) {
        return getService().countFileTuGiaiQuyet(userId, date);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> getListForTuGiaiQuyet(
        long userId, java.util.Date date) {
        return getService().getListForTuGiaiQuyet(userId, date);
    }

    public static int countFileNguoiKhacThuLyThay(long userId,
        java.util.Date date) {
        return getService().countFileNguoiKhacThuLyThay(userId, date);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> getListForNguoiKhacThuLyThay(
        long userId, java.util.Date date) {
        return getService().getListForNguoiKhacThuLyThay(userId, date);
    }

    public static int countFileTrongHanISO(long userId, java.util.Date date) {
        return getService().countFileTrongHanISO(userId, date);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> getListForTrongHanISO(
        long userId, java.util.Date date) {
        return getService().getListForTrongHanISO(userId, date);
    }

    public static int countFileQuaHanISO(long userId, java.util.Date date) {
        return getService().countFileQuaHanISO(userId, date);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> getListForQuaHanISO(
        long userId, java.util.Date date) {
        return getService().getListForQuaHanISO(userId, date);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileQuaHanISO(
        long userId, java.util.Date date) {
        return getService().getListFileQuaHanISO(userId, date);
    }

    public static int countFileChoBoSung(long userId, java.util.Date date) {
        return getService().countFileChoBoSung(userId, date);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileDangChoBoSung(
        long userId, java.util.Date date) {
        return getService().getListFileDangChoBoSung(userId, date);
    }

    public static int getTonDauKy(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> pmlFilePCCCList,
        int pmlFilePCCCSize, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getService()
                   .getTonDauKy(pmlFilePCCCList, pmlFilePCCCSize, fromDate,
            toDate);
    }

    public static int getHoSoNhanTrongThang(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> pmlFilePCCCList,
        int pmlFilePCCCSize, java.util.Date fromDate, java.util.Date toDate) {
        return getService()
                   .getHoSoNhanTrongThang(pmlFilePCCCList, pmlFilePCCCSize,
            fromDate, toDate);
    }

    public static int getSoLuongHoSoDungHan(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> pmlFilePCCCList,
        int pmlFilePCCCSize, java.util.Date fromDate, java.util.Date toDate) {
        return getService()
                   .getSoLuongHoSoDungHan(pmlFilePCCCList, pmlFilePCCCSize,
            fromDate, toDate);
    }

    public static int getSoLuongHoSoTreHan(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> pmlFilePCCCList,
        int pmlFilePCCCSize, java.util.Date fromDate, java.util.Date toDate) {
        return getService()
                   .getSoLuongHoSoTreHan(pmlFilePCCCList, pmlFilePCCCSize,
            fromDate, toDate);
    }

    public static int getSoLuongHoSoTrongHan(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> pmlFilePCCCList,
        int pmlFilePCCCSize, java.util.Date fromDate, java.util.Date toDate) {
        return getService()
                   .getSoLuongHoSoTrongHan(pmlFilePCCCList, pmlFilePCCCSize,
            fromDate, toDate);
    }

    public static int getSoLuongHoSoDaTreHan(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> pmlFilePCCCList,
        int pmlFilePCCCSize, java.util.Date fromDate, java.util.Date toDate) {
        return getService()
                   .getSoLuongHoSoDaTreHan(pmlFilePCCCList, pmlFilePCCCSize,
            fromDate, toDate);
    }

    public static int getSoLuongHoSoChinhSuBoSung(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> pmlFilePCCCList,
        int pmlFilePCCCSize, java.util.Date fromDate, java.util.Date toDate) {
        return getService()
                   .getSoLuongHoSoChinhSuBoSung(pmlFilePCCCList,
            pmlFilePCCCSize, fromDate, toDate);
    }

    public static int getTonDauKyThangLuyKe(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> pmlFilePCCCList,
        int pmlFilePCCCSize, java.util.Date fromDate, java.util.Date toDate) {
        return getService()
                   .getTonDauKyThangLuyKe(pmlFilePCCCList, pmlFilePCCCSize,
            fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileTonDauKyThangLuyKe(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> pmlFilePCCCList,
        int pmlFilePCCCSize, java.util.Date fromDate, java.util.Date toDate) {
        return getService()
                   .getListFileTonDauKyThangLuyKe(pmlFilePCCCList,
            pmlFilePCCCSize, fromDate, toDate);
    }

    public static int getHoSoNhanTuNgayDenNgayThangLuyKe(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> pmlFilePCCCList,
        int pmlFilePCCCSize, java.util.Date fromDate, java.util.Date toDate) {
        return getService()
                   .getHoSoNhanTuNgayDenNgayThangLuyKe(pmlFilePCCCList,
            pmlFilePCCCSize, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileHoSoNhanTuNgayDenNgayThangLuyKe(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> pmlFilePCCCList,
        int pmlFilePCCCSize, java.util.Date fromDate, java.util.Date toDate) {
        return getService()
                   .getListFileHoSoNhanTuNgayDenNgayThangLuyKe(pmlFilePCCCList,
            pmlFilePCCCSize, fromDate, toDate);
    }

    public static int getHoSoNhanTrongThangThangLuyKe(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> pmlFilePCCCList,
        int pmlFilePCCCSize, java.util.Date fromDate, java.util.Date toDate) {
        return getService()
                   .getHoSoNhanTrongThangThangLuyKe(pmlFilePCCCList,
            pmlFilePCCCSize, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileHoSoNhanTrongThangThangLuyKe(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> pmlFilePCCCList,
        int pmlFilePCCCSize, java.util.Date fromDate, java.util.Date toDate) {
        return getService()
                   .getListFileHoSoNhanTrongThangThangLuyKe(pmlFilePCCCList,
            pmlFilePCCCSize, fromDate, toDate);
    }

    public static int getHoSoNhanTrongNamThangLuyKe(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> pmlFilePCCCList,
        int pmlFilePCCCSize, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getService()
                   .getHoSoNhanTrongNamThangLuyKe(pmlFilePCCCList,
            pmlFilePCCCSize, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileHoSoNhanTrongNamThangLuyKe(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> pmlFilePCCCList,
        int pmlFilePCCCSize, java.util.Date fromDate, java.util.Date toDate)
        throws java.lang.Exception {
        return getService()
                   .getListFileHoSoNhanTrongNamThangLuyKe(pmlFilePCCCList,
            pmlFilePCCCSize, fromDate, toDate);
    }

    public static int getHoSoGiaiQuyetTuNgayDenNgayThangLuyKe(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> pmlFilePCCCList,
        int pmlFilePCCCSize, java.util.Date fromDate, java.util.Date toDate) {
        return getService()
                   .getHoSoGiaiQuyetTuNgayDenNgayThangLuyKe(pmlFilePCCCList,
            pmlFilePCCCSize, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileHoSoGiaiQuyetTuNgayDenNgayThangLuyKe(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> pmlFilePCCCList,
        int pmlFilePCCCSize, java.util.Date fromDate, java.util.Date toDate) {
        return getService()
                   .getListFileHoSoGiaiQuyetTuNgayDenNgayThangLuyKe(pmlFilePCCCList,
            pmlFilePCCCSize, fromDate, toDate);
    }

    public static int getHoSoGiaiQuyetTrongThangThangLuyKe(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> pmlFilePCCCList,
        int pmlFilePCCCSize, java.util.Date fromDate, java.util.Date toDate) {
        return getService()
                   .getHoSoGiaiQuyetTrongThangThangLuyKe(pmlFilePCCCList,
            pmlFilePCCCSize, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileHoSoGiaiQuyetTrongThangThangLuyKe(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> pmlFilePCCCList,
        int pmlFilePCCCSize, java.util.Date fromDate, java.util.Date toDate) {
        return getService()
                   .getListFileHoSoGiaiQuyetTrongThangThangLuyKe(pmlFilePCCCList,
            pmlFilePCCCSize, fromDate, toDate);
    }

    public static int getHoSoGiaiQuyetTrongNam(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> pmlFilePCCCList,
        int pmlFilePCCCSize, java.util.Date toDate) throws java.lang.Exception {
        return getService()
                   .getHoSoGiaiQuyetTrongNam(pmlFilePCCCList, pmlFilePCCCSize,
            toDate);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileHoSoGiaiQuyetTrongNam(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> pmlFilePCCCList,
        int pmlFilePCCCSize, java.util.Date toDate) throws java.lang.Exception {
        return getService()
                   .getListFileHoSoGiaiQuyetTrongNam(pmlFilePCCCList,
            pmlFilePCCCSize, toDate);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> getListFileHoSoTonThangLuyKe(
        java.util.List<com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile> pmlFilePCCCList,
        int pmlFilePCCCSize, java.util.Date toDate) throws java.lang.Exception {
        return getService()
                   .getListFileHoSoTonThangLuyKe(pmlFilePCCCList,
            pmlFilePCCCSize, toDate);
    }

    public static int getSoLuongHoSoTonTruocCapSo(
        java.util.List<com.sgs.portlet.pmluser.model.PmlUser> pmlUserList,
        java.util.Date date) throws java.lang.Exception {
        return getService().getSoLuongHoSoTonTruocCapSo(pmlUserList, date);
    }

    public static int getSoLuongHoSoDaNhanCapSo(
        java.util.List<com.sgs.portlet.pmluser.model.PmlUser> pmlUserList,
        java.util.Date date) throws java.lang.Exception {
        return getService().getSoLuongHoSoDaNhanCapSo(pmlUserList, date);
    }

    public static int getSoLuongHoSoChuaNhanCapSo(
        java.util.List<com.sgs.portlet.pmluser.model.PmlUser> pmlUserList,
        java.util.Date date) throws java.lang.Exception {
        return getService().getSoLuongHoSoChuaNhanCapSo(pmlUserList, date);
    }

    public static int getSoLuongHoSoGiaiQuyetCapSo(
        java.util.List<com.sgs.portlet.pmluser.model.PmlUser> pmlUserList,
        java.util.Date date) throws java.lang.Exception {
        return getService().getSoLuongHoSoGiaiQuyetCapSo(pmlUserList, date);
    }

    public static int getSoLuongHoSoTrongHanISOCapSo(
        java.util.List<com.sgs.portlet.pmluser.model.PmlUser> pmlUserList,
        java.util.Date date) throws java.lang.Exception {
        return getService().getSoLuongHoSoTrongHanISOCapSo(pmlUserList, date);
    }

    public static int getSoLuongHoSoQuaHanISOCapSo(
        java.util.List<com.sgs.portlet.pmluser.model.PmlUser> pmlUserList,
        java.util.Date date) throws java.lang.Exception {
        return getService().getSoLuongHoSoQuaHanISOCapSo(pmlUserList, date);
    }

    public static java.lang.String getFullName(long userId)
        throws java.lang.Exception {
        return getService().getFullName(userId);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> getListFileForUser(
        long userId) {
        return getService().getListFileForUser(userId);
    }

    public static int searchCount(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getService().searchCount(keywords);
    }

    public static int searchCount(java.lang.String screenName,
        java.lang.String lastName, java.lang.String middleName,
        java.lang.String firstName, java.lang.String positionId,
        boolean andOperator) throws com.liferay.portal.SystemException {
        return getService()
                   .searchCount(screenName, lastName, middleName, firstName,
            positionId, andOperator);
    }

    public static java.util.List<com.sgs.portlet.pmluser.model.PmlUser> search(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().search(keywords, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.pmluser.model.PmlUser> search(
        java.lang.String screenName, java.lang.String lastName,
        java.lang.String middleName, java.lang.String firstName,
        java.lang.String positionId, boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .search(screenName, lastName, middleName, firstName,
            positionId, andOperator, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findUserListByDepartmentId(
        java.lang.String departmentsId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .findUserListByDepartmentId(departmentsId, start, end, obc);
    }

    public static int countUserListByDepartmentId(
        java.lang.String departmentsId) throws java.lang.Exception {
        return getService().countUserListByDepartmentId(departmentsId);
    }

    public static int countTinhHinhThuLyCongVanChuyenVien(
        java.lang.String departmentId) throws java.lang.Exception {
        return getService().countTinhHinhThuLyCongVanChuyenVien(departmentId);
    }

    public static java.util.List<com.sgs.portlet.pmluser.model.PmlUser> findUserListByDepartment(
        java.lang.String departmentsId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getService().findUserListByDepartment(departmentsId, start, end);
    }

    public static int countUserListByDepartment(java.lang.String departmentsId)
        throws java.lang.Exception {
        return getService().countUserListByDepartment(departmentsId);
    }

    public static void synchronizePmlUserWithPortalUser()
        throws java.lang.Exception {
        getService().synchronizePmlUserWithPortalUser();
    }

    public static boolean removePmlUser(long userId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().removePmlUser(userId);
    }

    public static java.util.List<com.liferay.portal.model.User> listUserTheoDoiHoSo(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().listUserTheoDoiHoSo(start, end, obc);
    }

    public static int countUserTheoDoiHoSo()
        throws com.liferay.portal.SystemException {
        return getService().countUserTheoDoiHoSo();
    }

    public static PmlUserLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("PmlUserLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlUserLocalService service) {
        _service = service;
    }
}
