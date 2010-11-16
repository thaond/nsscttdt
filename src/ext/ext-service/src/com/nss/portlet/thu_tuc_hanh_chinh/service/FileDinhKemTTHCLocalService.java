package com.nss.portlet.thu_tuc_hanh_chinh.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="FileDinhKemTTHCLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.nss.portlet.thu_tuc_hanh_chinh.service.impl.FileDinhKemTTHCLocalServiceImpl</code>.
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
 * @see com.nss.portlet.thu_tuc_hanh_chinh.service.FileDinhKemTTHCLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface FileDinhKemTTHCLocalService {
    public com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC addFileDinhKemTTHC(
        com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC fileDinhKemTTHC)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC createFileDinhKemTTHC(
        long maFileDinhKemTTHC);

    public void deleteFileDinhKemTTHC(long maFileDinhKemTTHC)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteFileDinhKemTTHC(
        com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC fileDinhKemTTHC)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC getFileDinhKemTTHC(
        long maFileDinhKemTTHC)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC> getFileDinhKemTTHCs(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getFileDinhKemTTHCsCount()
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC updateFileDinhKemTTHC(
        com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC fileDinhKemTTHC)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC updateFileDinhKemTTHC(
        com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC fileDinhKemTTHC,
        boolean merge) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC> findByMaThuTucHanhChinh(
        long maThuTucHanhChinh);

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int searchCount(long maThuTucHanhChinh)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC> search(
        long maThuTucHanhChinh, int start, int end)
        throws com.liferay.portal.SystemException;
}
