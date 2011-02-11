package com.sgs.portlet.pml_ho_so_cong_viec.service;


/**
 * <a href="PmlHoSoCongViecLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.pml_ho_so_cong_viec.service.impl.PmlHoSoCongViecLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.pml_ho_so_cong_viec.service.PmlHoSoCongViecLocalServiceUtil
 *
 */
public interface PmlHoSoCongViecLocalService {
    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec addPmlHoSoCongViec(
        com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec pmlHoSoCongViec)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec createPmlHoSoCongViec(
        long idHoSoCongViec);

    public void deletePmlHoSoCongViec(long idHoSoCongViec)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlHoSoCongViec(
        com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec pmlHoSoCongViec)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec getPmlHoSoCongViec(
        long idHoSoCongViec)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> getPmlHoSoCongViecs(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlHoSoCongViecsCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec updatePmlHoSoCongViec(
        com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec pmlHoSoCongViec)
        throws com.liferay.portal.SystemException;

    public int searchCount(long userId, java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int searchCount(long userId, java.lang.String soHieuHSCV,
        java.lang.String tieuDe, java.util.Date ngayMoHSCV,
        java.lang.String idLinhVuc, java.lang.String vanDeLienQuan,
        long idDoQuanTrong, long idTrangThaiHSCV,
        java.lang.String tomTatNoiDung, java.lang.String hoatDong,
        boolean andOperator) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> search(
        long userId, java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> search(
        long userId, java.lang.String soHieuHSCV, java.lang.String tieuDe,
        java.util.Date ngayMoHSCV, java.lang.String idLinhVuc,
        java.lang.String vanDeLienQuan, long idDoQuanTrong,
        long idTrangThaiHSCV, java.lang.String tomTatNoiDung,
        java.lang.String hoatDong, boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec addPmlHoSoCongViec(
        long userId, long idHSCVCha, java.lang.String soHieuHSCV,
        java.lang.String tieuDe, int ngayMoHSCVMonth, int ngayMoHSCVDay,
        int ngayMoHSCVYear, int hanXuLyMonth, int hanXuLyDay, int hanXuLyYear,
        java.lang.String idLinhVuc, java.lang.String vanDeLienQuan,
        long idDoQuanTrong, long idTinhChat, long idTrangThaiHSCV,
        java.lang.String tomTatNoiDung, java.lang.String hoatDong)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec updatePmlHoSoCongViec(
        long idHoSoCongViec, long userId, long idHSCVCha,
        java.lang.String soHieuHSCV, java.lang.String tieuDe,
        int ngayMoHSCVMonth, int ngayMoHSCVDay, int ngayMoHSCVYear,
        int hanXuLyMonth, int hanXuLyDay, int hanXuLyYear,
        java.lang.String idLinhVuc, java.lang.String vanDeLienQuan,
        long idDoQuanTrong, long idTinhChat, long idTrangThaiHSCV,
        java.lang.String tomTatNoiDung, java.lang.String hoatDong)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public int countByI_S(long idHoSoCongViec, java.lang.String soHieuHSCV)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> getAll()
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portal.model.User> getAllUsers()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> getByIdHSCVCha(
        long idHSCVCha) throws com.liferay.portal.SystemException;

    public void expirePmlHoSoCongViec(long expPmlHSCVId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findByIdTinhChat(
        long idTinhChat)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findByIdDoQuanTrong(
        long idDoQuanTrong)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findByIdTrangThaiHSCV(
        long idTrangThaiHSCV)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public int findByHSCVIdTrangThaiHSCV(java.lang.String idTrangThaiHSCV)
        throws com.liferay.portal.SystemException;

    public int findByHSCVIdTinhChat(java.lang.String idTinhChat)
        throws com.liferay.portal.SystemException;

    public int findByHSCVIdDoQuanTrong(java.lang.String idDoQuanTrong)
        throws com.liferay.portal.SystemException;
}
