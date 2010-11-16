package com.nss.portlet.media_chu_de.service.base;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.media_chu_de.service.MediaChuDeLocalService;
import com.nss.portlet.media_chu_de.service.MediaChuDeService;
import com.nss.portlet.media_chu_de.service.persistence.MediaChuDeFinder;
import com.nss.portlet.media_chu_de.service.persistence.MediaChuDePersistence;


public abstract class MediaChuDeServiceBaseImpl extends PrincipalBean
    implements MediaChuDeService {
    @BeanReference(name = "com.nss.portlet.media_chu_de.service.MediaChuDeLocalService.impl")
    protected MediaChuDeLocalService mediaChuDeLocalService;
    @BeanReference(name = "com.nss.portlet.media_chu_de.service.MediaChuDeService.impl")
    protected MediaChuDeService mediaChuDeService;
    @BeanReference(name = "com.nss.portlet.media_chu_de.service.persistence.MediaChuDePersistence.impl")
    protected MediaChuDePersistence mediaChuDePersistence;
    @BeanReference(name = "com.nss.portlet.media_chu_de.service.persistence.MediaChuDeFinder.impl")
    protected MediaChuDeFinder mediaChuDeFinder;

    public MediaChuDeLocalService getMediaChuDeLocalService() {
        return mediaChuDeLocalService;
    }

    public void setMediaChuDeLocalService(
        MediaChuDeLocalService mediaChuDeLocalService) {
        this.mediaChuDeLocalService = mediaChuDeLocalService;
    }

    public MediaChuDeService getMediaChuDeService() {
        return mediaChuDeService;
    }

    public void setMediaChuDeService(MediaChuDeService mediaChuDeService) {
        this.mediaChuDeService = mediaChuDeService;
    }

    public MediaChuDePersistence getMediaChuDePersistence() {
        return mediaChuDePersistence;
    }

    public void setMediaChuDePersistence(
        MediaChuDePersistence mediaChuDePersistence) {
        this.mediaChuDePersistence = mediaChuDePersistence;
    }

    public MediaChuDeFinder getMediaChuDeFinder() {
        return mediaChuDeFinder;
    }

    public void setMediaChuDeFinder(MediaChuDeFinder mediaChuDeFinder) {
        this.mediaChuDeFinder = mediaChuDeFinder;
    }

    protected void runSQL(String sql) throws SystemException {
        try {
            PortalUtil.runSQL(sql);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
