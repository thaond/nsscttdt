package com.nss.portlet.media_library.service.base;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.media_library.service.MediaLibraryLocalService;
import com.nss.portlet.media_library.service.MediaLibraryService;
import com.nss.portlet.media_library.service.persistence.MediaLibraryFinder;
import com.nss.portlet.media_library.service.persistence.MediaLibraryPersistence;


public abstract class MediaLibraryServiceBaseImpl extends PrincipalBean
    implements MediaLibraryService {
    @BeanReference(name = "com.nss.portlet.media_library.service.MediaLibraryLocalService.impl")
    protected MediaLibraryLocalService mediaLibraryLocalService;
    @BeanReference(name = "com.nss.portlet.media_library.service.MediaLibraryService.impl")
    protected MediaLibraryService mediaLibraryService;
    @BeanReference(name = "com.nss.portlet.media_library.service.persistence.MediaLibraryPersistence.impl")
    protected MediaLibraryPersistence mediaLibraryPersistence;
    @BeanReference(name = "com.nss.portlet.media_library.service.persistence.MediaLibraryFinder.impl")
    protected MediaLibraryFinder mediaLibraryFinder;

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
