package com.nss.portlet.link.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="LoaiWebsiteLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.nss.portlet.link.service.impl.LoaiWebsiteLocalServiceImpl</code>.
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
 * @see com.nss.portlet.link.service.LoaiWebsiteLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface LoaiWebsiteLocalService {
    public com.nss.portlet.link.model.LoaiWebsite addLoaiWebsite(
        com.nss.portlet.link.model.LoaiWebsite loaiWebsite)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.link.model.LoaiWebsite createLoaiWebsite(
        long maLoaiWebsite);

    public void deleteLoaiWebsite(long maLoaiWebsite)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteLoaiWebsite(
        com.nss.portlet.link.model.LoaiWebsite loaiWebsite)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.link.model.LoaiWebsite getLoaiWebsite(
        long maLoaiWebsite)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.link.model.LoaiWebsite> getLoaiWebsites(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getLoaiWebsitesCount() throws com.liferay.portal.SystemException;

    public com.nss.portlet.link.model.LoaiWebsite updateLoaiWebsite(
        com.nss.portlet.link.model.LoaiWebsite loaiWebsite)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.link.model.LoaiWebsite updateLoaiWebsite(
        com.nss.portlet.link.model.LoaiWebsite loaiWebsite, boolean merge)
        throws com.liferay.portal.SystemException;

    public int countLoaiWebsiteByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int countLoaiWebsite(java.lang.String name, java.lang.String des,
        boolean andOperator) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.link.model.LoaiWebsite> findLoaiWebsiteByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.link.model.LoaiWebsite> findLoaiWebsite(
        java.lang.String name, java.lang.String des, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.link.model.LoaiWebsite> findByActive(
        int active);
}
