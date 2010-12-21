package com.nss.portlet.media_chu_de.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="MediaChuDeLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.nss.portlet.media_chu_de.service.impl.MediaChuDeLocalServiceImpl</code>.
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
 * @see com.nss.portlet.media_chu_de.service.MediaChuDeLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface MediaChuDeLocalService {
    public com.nss.portlet.media_chu_de.model.MediaChuDe addMediaChuDe(
        com.nss.portlet.media_chu_de.model.MediaChuDe mediaChuDe)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.media_chu_de.model.MediaChuDe createMediaChuDe(
        long maMediaChuDe);

    public void deleteMediaChuDe(long maMediaChuDe)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.media_chu_de.MediaChuDeCanNotDeleteException,
            com.liferay.portal.PortalException,
            com.nss.portlet.media_chu_de.NoSuchMediaChuDeException;

    public void deleteMediaChuDe(
        com.nss.portlet.media_chu_de.model.MediaChuDe mediaChuDe)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.media_chu_de.model.MediaChuDe getMediaChuDe(
        long maMediaChuDe)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.media_chu_de.model.MediaChuDe> getMediaChuDes(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getMediaChuDesCount() throws com.liferay.portal.SystemException;

    public com.nss.portlet.media_chu_de.model.MediaChuDe updateMediaChuDe(
        com.nss.portlet.media_chu_de.model.MediaChuDe mediaChuDe)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.media_chu_de.model.MediaChuDe updateMediaChuDe(
        com.nss.portlet.media_chu_de.model.MediaChuDe mediaChuDe, boolean merge)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.media_chu_de.model.MediaChuDe> findMediaChuDe(
        java.lang.String tenMediaChuDe, boolean andOperator, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int countMediaChuDe(java.lang.String tenMediaChuDe,
        boolean andOperator) throws com.liferay.portal.SystemException;

    public com.nss.portlet.media_chu_de.model.MediaChuDe addMediaChuDe(
        java.lang.String tenMediaChuDe)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.nss.portlet.media_chu_de.model.MediaChuDe updateMediaChuDe(
        long maMediaChuDe, java.lang.String tenMediaChuDe)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.media_chu_de.model.MediaChuDe> findByActive(
        boolean active);
}
