package com.nss.portlet.media_library.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.media_library.model.MediaLibrary;
import com.nss.portlet.media_library.service.MediaLibraryLocalService;
import com.nss.portlet.media_library.service.MediaLibraryService;
import com.nss.portlet.media_library.service.persistence.MediaLibraryFinder;
import com.nss.portlet.media_library.service.persistence.MediaLibraryPersistence;

import java.util.List;


public abstract class MediaLibraryLocalServiceBaseImpl
    implements MediaLibraryLocalService {
    @BeanReference(name = "com.nss.portlet.media_library.service.MediaLibraryLocalService.impl")
    protected MediaLibraryLocalService mediaLibraryLocalService;
    @BeanReference(name = "com.nss.portlet.media_library.service.MediaLibraryService.impl")
    protected MediaLibraryService mediaLibraryService;
    @BeanReference(name = "com.nss.portlet.media_library.service.persistence.MediaLibraryPersistence.impl")
    protected MediaLibraryPersistence mediaLibraryPersistence;
    @BeanReference(name = "com.nss.portlet.media_library.service.persistence.MediaLibraryFinder.impl")
    protected MediaLibraryFinder mediaLibraryFinder;

    public MediaLibrary addMediaLibrary(MediaLibrary mediaLibrary)
        throws SystemException {
        mediaLibrary.setNew(true);

        return mediaLibraryPersistence.update(mediaLibrary, false);
    }

    public MediaLibrary createMediaLibrary(long maMediaLibrary) {
        return mediaLibraryPersistence.create(maMediaLibrary);
    }

    public void deleteMediaLibrary(long maMediaLibrary)
        throws PortalException, SystemException {
        mediaLibraryPersistence.remove(maMediaLibrary);
    }

    public void deleteMediaLibrary(MediaLibrary mediaLibrary)
        throws SystemException {
        mediaLibraryPersistence.remove(mediaLibrary);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return mediaLibraryPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return mediaLibraryPersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
    }

    public MediaLibrary getMediaLibrary(long maMediaLibrary)
        throws PortalException, SystemException {
        return mediaLibraryPersistence.findByPrimaryKey(maMediaLibrary);
    }

    public List<MediaLibrary> getMediaLibraries(int start, int end)
        throws SystemException {
        return mediaLibraryPersistence.findAll(start, end);
    }

    public int getMediaLibrariesCount() throws SystemException {
        return mediaLibraryPersistence.countAll();
    }

    public MediaLibrary updateMediaLibrary(MediaLibrary mediaLibrary)
        throws SystemException {
        mediaLibrary.setNew(false);

        return mediaLibraryPersistence.update(mediaLibrary, true);
    }

    public MediaLibrary updateMediaLibrary(MediaLibrary mediaLibrary,
        boolean merge) throws SystemException {
        mediaLibrary.setNew(false);

        return mediaLibraryPersistence.update(mediaLibrary, merge);
    }

    public MediaLibraryLocalService getMediaLibraryLocalService() {
        return mediaLibraryLocalService;
    }

    public void setMediaLibraryLocalService(
        MediaLibraryLocalService mediaLibraryLocalService) {
        this.mediaLibraryLocalService = mediaLibraryLocalService;
    }

    public MediaLibraryService getMediaLibraryService() {
        return mediaLibraryService;
    }

    public void setMediaLibraryService(MediaLibraryService mediaLibraryService) {
        this.mediaLibraryService = mediaLibraryService;
    }

    public MediaLibraryPersistence getMediaLibraryPersistence() {
        return mediaLibraryPersistence;
    }

    public void setMediaLibraryPersistence(
        MediaLibraryPersistence mediaLibraryPersistence) {
        this.mediaLibraryPersistence = mediaLibraryPersistence;
    }

    public MediaLibraryFinder getMediaLibraryFinder() {
        return mediaLibraryFinder;
    }

    public void setMediaLibraryFinder(MediaLibraryFinder mediaLibraryFinder) {
        this.mediaLibraryFinder = mediaLibraryFinder;
    }

    protected void runSQL(String sql) throws SystemException {
        try {
            PortalUtil.runSQL(sql);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
