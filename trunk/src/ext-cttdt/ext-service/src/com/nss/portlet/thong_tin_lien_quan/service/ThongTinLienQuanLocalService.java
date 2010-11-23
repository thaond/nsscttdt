package com.nss.portlet.thong_tin_lien_quan.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="ThongTinLienQuanLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.nss.portlet.thong_tin_lien_quan.service.impl.ThongTinLienQuanLocalServiceImpl</code>.
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
 * @see com.nss.portlet.thong_tin_lien_quan.service.ThongTinLienQuanLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface ThongTinLienQuanLocalService {
    public com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan addThongTinLienQuan(
        com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan thongTinLienQuan)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan createThongTinLienQuan(
        long maThongTinLienQuan);

    public void deleteThongTinLienQuan(long maThongTinLienQuan)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteThongTinLienQuan(
        com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan thongTinLienQuan)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan getThongTinLienQuan(
        long maThongTinLienQuan)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan> getThongTinLienQuans(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getThongTinLienQuansCount()
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan updateThongTinLienQuan(
        com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan thongTinLienQuan)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan updateThongTinLienQuan(
        com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan thongTinLienQuan,
        boolean merge) throws com.liferay.portal.SystemException;

    public int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int searchCount(java.lang.String name, java.lang.String des,
        boolean andOperator) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan> search(
        java.lang.String name, java.lang.String des, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan> findByActive(
        int active);
}
