package com.nss.portlet.loai_thu_tuc.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="LoaiThuTucHanhChinhLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.nss.portlet.loai_thu_tuc.service.impl.LoaiThuTucHanhChinhLocalServiceImpl</code>.
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
 * @see com.nss.portlet.loai_thu_tuc.service.LoaiThuTucHanhChinhLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface LoaiThuTucHanhChinhLocalService {
    public com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh addLoaiThuTucHanhChinh(
        com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh loaiThuTucHanhChinh)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh createLoaiThuTucHanhChinh(
        long maLoaiThuTucHanhChinh);

    public void deleteLoaiThuTucHanhChinh(long maLoaiThuTucHanhChinh)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteLoaiThuTucHanhChinh(
        com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh loaiThuTucHanhChinh)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh getLoaiThuTucHanhChinh(
        long maLoaiThuTucHanhChinh)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh> getLoaiThuTucHanhChinhs(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getLoaiThuTucHanhChinhsCount()
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh updateLoaiThuTucHanhChinh(
        com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh loaiThuTucHanhChinh)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh updateLoaiThuTucHanhChinh(
        com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh loaiThuTucHanhChinh,
        boolean merge) throws com.liferay.portal.SystemException;

    public int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int searchCount(java.lang.String name, java.lang.String des,
        boolean andOperator) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh> search(
        java.lang.String name, java.lang.String des, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh> findByActive(
        int active);
}
