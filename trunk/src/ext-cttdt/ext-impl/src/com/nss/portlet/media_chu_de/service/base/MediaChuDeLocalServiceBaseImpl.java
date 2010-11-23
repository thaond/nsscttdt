package com.nss.portlet.media_chu_de.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.media_chu_de.model.MediaChuDe;
import com.nss.portlet.media_chu_de.service.MediaChuDeLocalService;
import com.nss.portlet.media_chu_de.service.MediaChuDeService;
import com.nss.portlet.media_chu_de.service.persistence.MediaChuDeFinder;
import com.nss.portlet.media_chu_de.service.persistence.MediaChuDePersistence;

import java.util.List;


public abstract class MediaChuDeLocalServiceBaseImpl
    implements MediaChuDeLocalService {
    @BeanReference(name = "com.nss.portlet.media_chu_de.service.MediaChuDeLocalService.impl")
    protected MediaChuDeLocalService mediaChuDeLocalService;
    @BeanReference(name = "com.nss.portlet.media_chu_de.service.MediaChuDeService.impl")
    protected MediaChuDeService mediaChuDeService;
    @BeanReference(name = "com.nss.portlet.media_chu_de.service.persistence.MediaChuDePersistence.impl")
    protected MediaChuDePersistence mediaChuDePersistence;
    @BeanReference(name = "com.nss.portlet.media_chu_de.service.persistence.MediaChuDeFinder.impl")
    protected MediaChuDeFinder mediaChuDeFinder;

    public MediaChuDe addMediaChuDe(MediaChuDe mediaChuDe)
        throws SystemException {
        mediaChuDe.setNew(true);

        return mediaChuDePersistence.update(mediaChuDe, false);
    }

    public MediaChuDe createMediaChuDe(long maMediaChuDe) {
        return mediaChuDePersistence.create(maMediaChuDe);
    }

    public void deleteMediaChuDe(long maMediaChuDe)
        throws PortalException, SystemException,
            com.nss.portlet.media_chu_de.MediaChuDeCanNotDeleteException,
            com.nss.portlet.media_chu_de.NoSuchMediaChuDeException {
        mediaChuDePersistence.remove(maMediaChuDe);
    }

    public void deleteMediaChuDe(MediaChuDe mediaChuDe)
        throws SystemException {
        mediaChuDePersistence.remove(mediaChuDe);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return mediaChuDePersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return mediaChuDePersistence.findWithDynamicQuery(dynamicQuery, start,
            end);
    }

    public MediaChuDe getMediaChuDe(long maMediaChuDe)
        throws PortalException, SystemException {
        return mediaChuDePersistence.findByPrimaryKey(maMediaChuDe);
    }

    public List<MediaChuDe> getMediaChuDes(int start, int end)
        throws SystemException {
        return mediaChuDePersistence.findAll(start, end);
    }

    public int getMediaChuDesCount() throws SystemException {
        return mediaChuDePersistence.countAll();
    }

    public MediaChuDe updateMediaChuDe(MediaChuDe mediaChuDe)
        throws SystemException {
        mediaChuDe.setNew(false);

        return mediaChuDePersistence.update(mediaChuDe, true);
    }

    public MediaChuDe updateMediaChuDe(MediaChuDe mediaChuDe, boolean merge)
        throws SystemException {
        mediaChuDe.setNew(false);

        return mediaChuDePersistence.update(mediaChuDe, merge);
    }

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
