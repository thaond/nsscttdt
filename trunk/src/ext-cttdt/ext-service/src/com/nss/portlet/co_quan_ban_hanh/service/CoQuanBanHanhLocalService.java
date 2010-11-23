package com.nss.portlet.co_quan_ban_hanh.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="CoQuanBanHanhLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.nss.portlet.co_quan_ban_hanh.service.impl.CoQuanBanHanhLocalServiceImpl</code>.
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
 * @see com.nss.portlet.co_quan_ban_hanh.service.CoQuanBanHanhLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface CoQuanBanHanhLocalService {
    public com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh addCoQuanBanHanh(
        com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh coQuanBanHanh)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh createCoQuanBanHanh(
        long maCoQuanBanHanh);

    public void deleteCoQuanBanHanh(long maCoQuanBanHanh)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteCoQuanBanHanh(
        com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh coQuanBanHanh)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh getCoQuanBanHanh(
        long maCoQuanBanHanh)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh> getCoQuanBanHanhs(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getCoQuanBanHanhsCount()
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh updateCoQuanBanHanh(
        com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh coQuanBanHanh)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh updateCoQuanBanHanh(
        com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh coQuanBanHanh,
        boolean merge) throws com.liferay.portal.SystemException;

    public int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int searchCount(java.lang.String name, java.lang.String des,
        boolean andOperator) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh> search(
        java.lang.String name, java.lang.String des, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh> findByActive(
        int active);
}
