package com.nss.portlet.van_ban_phap_quy.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="FileDinhKemLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.nss.portlet.van_ban_phap_quy.service.impl.FileDinhKemLocalServiceImpl</code>.
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
 * @see com.nss.portlet.van_ban_phap_quy.service.FileDinhKemLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface FileDinhKemLocalService {
    public com.nss.portlet.van_ban_phap_quy.model.FileDinhKem addFileDinhKem(
        com.nss.portlet.van_ban_phap_quy.model.FileDinhKem fileDinhKem)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.van_ban_phap_quy.model.FileDinhKem createFileDinhKem(
        long maFileDinhKem);

    public void deleteFileDinhKem(long maFileDinhKem)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteFileDinhKem(
        com.nss.portlet.van_ban_phap_quy.model.FileDinhKem fileDinhKem)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.van_ban_phap_quy.model.FileDinhKem getFileDinhKem(
        long maFileDinhKem)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.van_ban_phap_quy.model.FileDinhKem> getFileDinhKems(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getFileDinhKemsCount() throws com.liferay.portal.SystemException;

    public com.nss.portlet.van_ban_phap_quy.model.FileDinhKem updateFileDinhKem(
        com.nss.portlet.van_ban_phap_quy.model.FileDinhKem fileDinhKem)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.van_ban_phap_quy.model.FileDinhKem updateFileDinhKem(
        com.nss.portlet.van_ban_phap_quy.model.FileDinhKem fileDinhKem,
        boolean merge) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.van_ban_phap_quy.model.FileDinhKem getVanBanPhapQuy_PhienBan(
        long maVanBanPhapQuyId);

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.van_ban_phap_quy.model.FileDinhKem> getListFileDinhKemByMaVanBanPhapQuy(
        long maVanBanPhapQuyId);

    public int countFileDinhKem(long maVanBanPhapQuy)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.van_ban_phap_quy.model.FileDinhKem> findFileDinhKem(
        long maVanBanPhapQuy, int start, int end)
        throws com.liferay.portal.SystemException;
}
