package com.sgs.portlet.pml_ho_so_cong_viec.service;


/**
 * <a href="PmlHoSoCongViecLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.pml_ho_so_cong_viec.service.PmlHoSoCongViecLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pml_ho_so_cong_viec.service.PmlHoSoCongViecLocalService
 *
 */
public class PmlHoSoCongViecLocalServiceUtil {
    private static PmlHoSoCongViecLocalService _service;

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec addPmlHoSoCongViec(
        com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec pmlHoSoCongViec)
        throws com.liferay.portal.SystemException {
        return getService().addPmlHoSoCongViec(pmlHoSoCongViec);
    }

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec createPmlHoSoCongViec(
        long idHoSoCongViec) {
        return getService().createPmlHoSoCongViec(idHoSoCongViec);
    }

    public static void deletePmlHoSoCongViec(long idHoSoCongViec)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlHoSoCongViec(idHoSoCongViec);
    }

    public static void deletePmlHoSoCongViec(
        com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec pmlHoSoCongViec)
        throws com.liferay.portal.SystemException {
        getService().deletePmlHoSoCongViec(pmlHoSoCongViec);
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

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec getPmlHoSoCongViec(
        long idHoSoCongViec)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlHoSoCongViec(idHoSoCongViec);
    }

    public static java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> getPmlHoSoCongViecs(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlHoSoCongViecs(start, end);
    }

    public static int getPmlHoSoCongViecsCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlHoSoCongViecsCount();
    }

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec updatePmlHoSoCongViec(
        com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec pmlHoSoCongViec)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlHoSoCongViec(pmlHoSoCongViec);
    }

    public static int searchCount(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getService().searchCount(keywords);
    }

    public static int searchCount(java.lang.String soHieuHSCV,
        java.lang.String tieuDe, java.util.Date ngayMoHSCV,
        java.lang.String idLinhVuc, java.lang.String vanDeLienQuan,
        long idDoQuanTrong, long idTrangThaiHSCV,
        java.lang.String tomTatNoiDung, java.lang.String hoatDong,
        boolean andOperator) throws com.liferay.portal.SystemException {
        return getService()
                   .searchCount(soHieuHSCV, tieuDe, ngayMoHSCV, idLinhVuc,
            vanDeLienQuan, idDoQuanTrong, idTrangThaiHSCV, tomTatNoiDung,
            hoatDong, andOperator);
    }

    public static java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> search(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().search(keywords, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> search(
        java.lang.String soHieuHSCV, java.lang.String tieuDe,
        java.util.Date ngayMoHSCV, java.lang.String idLinhVuc,
        java.lang.String vanDeLienQuan, long idDoQuanTrong,
        long idTrangThaiHSCV, java.lang.String tomTatNoiDung,
        java.lang.String hoatDong, boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .search(soHieuHSCV, tieuDe, ngayMoHSCV, idLinhVuc,
            vanDeLienQuan, idDoQuanTrong, idTrangThaiHSCV, tomTatNoiDung,
            hoatDong, andOperator, start, end, obc);
    }

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec addPmlHoSoCongViec(
        long userId, long idHSCVCha, java.lang.String soHieuHSCV,
        java.lang.String tieuDe, int ngayMoHSCVMonth, int ngayMoHSCVDay,
        int ngayMoHSCVYear, int hanXuLyMonth, int hanXuLyDay, int hanXuLyYear,
        java.lang.String idLinhVuc, java.lang.String vanDeLienQuan,
        long idDoQuanTrong, long idTinhChat, long idTrangThaiHSCV,
        java.lang.String tomTatNoiDung, java.lang.String hoatDong)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .addPmlHoSoCongViec(userId, idHSCVCha, soHieuHSCV, tieuDe,
            ngayMoHSCVMonth, ngayMoHSCVDay, ngayMoHSCVYear, hanXuLyMonth,
            hanXuLyDay, hanXuLyYear, idLinhVuc, vanDeLienQuan, idDoQuanTrong,
            idTinhChat, idTrangThaiHSCV, tomTatNoiDung, hoatDong);
    }

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec updatePmlHoSoCongViec(
        long idHoSoCongViec, long userId, long idHSCVCha,
        java.lang.String soHieuHSCV, java.lang.String tieuDe,
        int ngayMoHSCVMonth, int ngayMoHSCVDay, int ngayMoHSCVYear,
        int hanXuLyMonth, int hanXuLyDay, int hanXuLyYear,
        java.lang.String idLinhVuc, java.lang.String vanDeLienQuan,
        long idDoQuanTrong, long idTinhChat, long idTrangThaiHSCV,
        java.lang.String tomTatNoiDung, java.lang.String hoatDong)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .updatePmlHoSoCongViec(idHoSoCongViec, userId, idHSCVCha,
            soHieuHSCV, tieuDe, ngayMoHSCVMonth, ngayMoHSCVDay, ngayMoHSCVYear,
            hanXuLyMonth, hanXuLyDay, hanXuLyYear, idLinhVuc, vanDeLienQuan,
            idDoQuanTrong, idTinhChat, idTrangThaiHSCV, tomTatNoiDung, hoatDong);
    }

    public static int countByI_S(long idHoSoCongViec,
        java.lang.String soHieuHSCV)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().countByI_S(idHoSoCongViec, soHieuHSCV);
    }

    public static java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> getAll()
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getAll();
    }

    public static java.util.List<com.liferay.portal.model.User> getAllUsers()
        throws com.liferay.portal.SystemException {
        return getService().getAllUsers();
    }

    public static java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> getByIdHSCVCha(
        long idHSCVCha) throws com.liferay.portal.SystemException {
        return getService().getByIdHSCVCha(idHSCVCha);
    }

    public static void expirePmlHoSoCongViec(long expPmlHSCVId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().expirePmlHoSoCongViec(expPmlHSCVId);
    }

    public static java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findByIdTinhChat(
        long idTinhChat)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().findByIdTinhChat(idTinhChat);
    }

    public static java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findByIdDoQuanTrong(
        long idDoQuanTrong)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().findByIdDoQuanTrong(idDoQuanTrong);
    }

    public static java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findByIdTrangThaiHSCV(
        long idTrangThaiHSCV)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().findByIdTrangThaiHSCV(idTrangThaiHSCV);
    }

    public static int findByHSCVIdTrangThaiHSCV(
        java.lang.String idTrangThaiHSCV)
        throws com.liferay.portal.SystemException {
        return getService().findByHSCVIdTrangThaiHSCV(idTrangThaiHSCV);
    }

    public static int findByHSCVIdTinhChat(java.lang.String idTinhChat)
        throws com.liferay.portal.SystemException {
        return getService().findByHSCVIdTinhChat(idTinhChat);
    }

    public static int findByHSCVIdDoQuanTrong(java.lang.String idDoQuanTrong)
        throws com.liferay.portal.SystemException {
        return getService().findByHSCVIdDoQuanTrong(idDoQuanTrong);
    }

    public static PmlHoSoCongViecLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("PmlHoSoCongViecLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlHoSoCongViecLocalService service) {
        _service = service;
    }
}
