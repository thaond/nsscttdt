package com.nss.portlet.media_library.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="MediaLibraryLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.nss.portlet.media_library.service.impl.MediaLibraryLocalServiceImpl</code>.
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
 * @see com.nss.portlet.media_library.service.MediaLibraryLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface MediaLibraryLocalService {
    public com.nss.portlet.media_library.model.MediaLibrary addMediaLibrary(
        com.nss.portlet.media_library.model.MediaLibrary mediaLibrary)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.media_library.model.MediaLibrary createMediaLibrary(
        long maMediaLibrary);

    public void deleteMediaLibrary(long maMediaLibrary)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteMediaLibrary(
        com.nss.portlet.media_library.model.MediaLibrary mediaLibrary)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.media_library.model.MediaLibrary getMediaLibrary(
        long maMediaLibrary)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.media_library.model.MediaLibrary> getMediaLibraries(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getMediaLibrariesCount()
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.media_library.model.MediaLibrary updateMediaLibrary(
        com.nss.portlet.media_library.model.MediaLibrary mediaLibrary)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.media_library.model.MediaLibrary updateMediaLibrary(
        com.nss.portlet.media_library.model.MediaLibrary mediaLibrary,
        boolean merge) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int searchCount(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.media_library.model.MediaLibrary> findMediaLibrary(
        java.lang.String tieuDeMediaLibrary, java.lang.String tenMediaLibrary,
        long maMediaChuDe, boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.media_library.model.MediaLibrary> search(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int countMediaLibrary(java.lang.String tieuDeMediaLibrary,
        java.lang.String tenMediaLibrary, long maMediaChuDe, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.media_library.model.MediaLibrary> findByMaMediaChuDe_Active(
        long maMediaChuDe, boolean active);

    public java.util.List<com.nss.portlet.media_library.model.MediaLibrary> findByActive(
        boolean active);
}
