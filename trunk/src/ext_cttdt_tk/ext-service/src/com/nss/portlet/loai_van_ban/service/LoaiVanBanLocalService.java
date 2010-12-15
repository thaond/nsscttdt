package com.nss.portlet.loai_van_ban.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="LoaiVanBanLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.nss.portlet.loai_van_ban.service.impl.LoaiVanBanLocalServiceImpl</code>.
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
 * @see com.nss.portlet.loai_van_ban.service.LoaiVanBanLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface LoaiVanBanLocalService {
    public com.nss.portlet.loai_van_ban.model.LoaiVanBan addLoaiVanBan(
        com.nss.portlet.loai_van_ban.model.LoaiVanBan loaiVanBan)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.loai_van_ban.model.LoaiVanBan createLoaiVanBan(
        long maLoaiVanBan);

    public void deleteLoaiVanBan(long maLoaiVanBan)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteLoaiVanBan(
        com.nss.portlet.loai_van_ban.model.LoaiVanBan loaiVanBan)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.loai_van_ban.model.LoaiVanBan getLoaiVanBan(
        long maLoaiVanBan)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.loai_van_ban.model.LoaiVanBan> getLoaiVanBans(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getLoaiVanBansCount() throws com.liferay.portal.SystemException;

    public com.nss.portlet.loai_van_ban.model.LoaiVanBan updateLoaiVanBan(
        com.nss.portlet.loai_van_ban.model.LoaiVanBan loaiVanBan)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.loai_van_ban.model.LoaiVanBan updateLoaiVanBan(
        com.nss.portlet.loai_van_ban.model.LoaiVanBan loaiVanBan, boolean merge)
        throws com.liferay.portal.SystemException;

    public int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int countByTEN_MOTA(java.lang.String name, java.lang.String des,
        boolean andOperator) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.loai_van_ban.model.LoaiVanBan> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.loai_van_ban.model.LoaiVanBan> findTEN_MOTA(
        java.lang.String name, java.lang.String des, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.loai_van_ban.model.LoaiVanBan> findByActive(
        int active);
}
