package com.nss.portlet.van_ban_phap_quy.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="VanBanPhapQuyLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.nss.portlet.van_ban_phap_quy.service.impl.VanBanPhapQuyLocalServiceImpl</code>.
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
 * @see com.nss.portlet.van_ban_phap_quy.service.VanBanPhapQuyLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface VanBanPhapQuyLocalService {
    public com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy addVanBanPhapQuy(
        com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy vanBanPhapQuy)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy createVanBanPhapQuy(
        long maVanBanPhapQuy);

    public void deleteVanBanPhapQuy(long maVanBanPhapQuy)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteVanBanPhapQuy(
        com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy vanBanPhapQuy)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy getVanBanPhapQuy(
        long maVanBanPhapQuy)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy> getVanBanPhapQuies(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getVanBanPhapQuiesCount()
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy updateVanBanPhapQuy(
        com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy vanBanPhapQuy)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy updateVanBanPhapQuy(
        com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy vanBanPhapQuy,
        boolean merge) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int searchCount(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int searchCount(java.lang.String kyHieuVanBan, boolean andOperator)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy> search(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy> search(
        java.lang.String kyHieuVanBan, boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public void reIndex(long companyId,
        com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy vanBanPhapQuy)
        throws com.liferay.portal.kernel.search.SearchException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public void reIndex(java.lang.String[] ids)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portal.kernel.search.Hits search(long companyId,
        java.lang.String kyHieuVanBan, java.lang.String tomTat,
        java.lang.String nguoiKy, long maLoaiVanBan, long maLinhVucVanBan,
        long maCoQuanBanHanh, java.util.Date tuNgay, java.util.Date denNgay,
        java.lang.String sortField, int sortType, boolean reverse, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portal.kernel.search.Hits searchDisplay(long companyId,
        long maLoaiVanBan, long maLinhVucVanBan, long maCoQuanBanHanh,
        java.lang.String sortField, int sortType, boolean reverse, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portal.kernel.search.Hits search(long companyId,
        java.lang.String keywords, java.lang.String sortField, int sortType,
        boolean reverse, int start, int end)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy addVanBanPhapQuy(
        long companyId, java.lang.String kyHieuVanBan, long maLoaiVanBan,
        long maLinhVucVanBan, long maCoQuanBanHanh, java.lang.String tomTat,
        java.lang.String nguoiKy, java.util.Date ngayBanHanh)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException;

    public com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy addVanBanPhapQuy(
        long companyId,
        com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy vanBanPhapQuy)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException;

    public com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy updateVanBanPhapQuy(
        long companyId, long maVanBanPhapQuy, java.lang.String kyHieuVanBan,
        long maLoaiVanBan, long maLinhVucVanBan, long maCoQuanBanHanh,
        java.lang.String tomTat, java.lang.String nguoiKy,
        java.util.Date ngayBanHanh)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException,
            com.nss.portlet.van_ban_phap_quy.NoSuchVanBanPhapQuyException;

    public com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy updateVanBanPhapQuy(
        long companyId,
        com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy vanBanPhapQuy)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException;

    public void deleteVanBanPhapQuy(long companyId, long maVanBanPhapQuy)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException,
            com.nss.portlet.van_ban_phap_quy.NoSuchVanBanPhapQuyException;

    public void deleteVanBanPhapQuy(long companyId,
        com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy vanBanPhapQuy)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.kernel.search.SearchException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy> getVanbanPhapQuyFromMaLinhVucVanBan(
        long maLinhVucVanBan);

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy> getVanbanPhapQuyFromMaLoaiVanBan(
        long maLoaiVanBan);

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy> getVanbanPhapQuyFromMaCoQuanBanHanh(
        long maCoQuanBanHanh);
}
