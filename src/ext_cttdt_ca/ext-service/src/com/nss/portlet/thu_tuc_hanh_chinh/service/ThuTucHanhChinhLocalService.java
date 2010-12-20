package com.nss.portlet.thu_tuc_hanh_chinh.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="ThuTucHanhChinhLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.nss.portlet.thu_tuc_hanh_chinh.service.impl.ThuTucHanhChinhLocalServiceImpl</code>.
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
 * @see com.nss.portlet.thu_tuc_hanh_chinh.service.ThuTucHanhChinhLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface ThuTucHanhChinhLocalService {
    public com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh addThuTucHanhChinh(
        com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh thuTucHanhChinh)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh createThuTucHanhChinh(
        long maThuTucHanhChinh);

    public void deleteThuTucHanhChinh(long maThuTucHanhChinh)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteThuTucHanhChinh(
        com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh thuTucHanhChinh)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh getThuTucHanhChinh(
        long maThuTucHanhChinh)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh> getThuTucHanhChinhs(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getThuTucHanhChinhsCount()
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh updateThuTucHanhChinh(
        com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh thuTucHanhChinh)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh updateThuTucHanhChinh(
        com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh thuTucHanhChinh,
        boolean merge) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int searchCount(java.lang.String name, long linhVuc, long capDonVi,
        long donVi, boolean andOperator)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh> search(
        java.lang.String name, long linhVuc, long capDonVi, long donVi,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh> findByMaLinhVucThuTuc(
        long maLinhVucThuTuc);

    public java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh> findByMaDonViThuTuc(
        long maDonViThuTuc);
}
