package com.nss.portlet.image_signer.service.base;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.image_signer.service.ImageSignerLocalService;
import com.nss.portlet.image_signer.service.ImageSignerService;
import com.nss.portlet.image_signer.service.persistence.ImageSignerFinder;
import com.nss.portlet.image_signer.service.persistence.ImageSignerPersistence;


public abstract class ImageSignerServiceBaseImpl extends PrincipalBean
    implements ImageSignerService {
    @BeanReference(name = "com.nss.portlet.image_signer.service.ImageSignerLocalService.impl")
    protected ImageSignerLocalService imageSignerLocalService;
    @BeanReference(name = "com.nss.portlet.image_signer.service.ImageSignerService.impl")
    protected ImageSignerService imageSignerService;
    @BeanReference(name = "com.nss.portlet.image_signer.service.persistence.ImageSignerPersistence.impl")
    protected ImageSignerPersistence imageSignerPersistence;
    @BeanReference(name = "com.nss.portlet.image_signer.service.persistence.ImageSignerFinder.impl")
    protected ImageSignerFinder imageSignerFinder;

    public ImageSignerLocalService getImageSignerLocalService() {
        return imageSignerLocalService;
    }

    public void setImageSignerLocalService(
        ImageSignerLocalService imageSignerLocalService) {
        this.imageSignerLocalService = imageSignerLocalService;
    }

    public ImageSignerService getImageSignerService() {
        return imageSignerService;
    }

    public void setImageSignerService(ImageSignerService imageSignerService) {
        this.imageSignerService = imageSignerService;
    }

    public ImageSignerPersistence getImageSignerPersistence() {
        return imageSignerPersistence;
    }

    public void setImageSignerPersistence(
        ImageSignerPersistence imageSignerPersistence) {
        this.imageSignerPersistence = imageSignerPersistence;
    }

    public ImageSignerFinder getImageSignerFinder() {
        return imageSignerFinder;
    }

    public void setImageSignerFinder(ImageSignerFinder imageSignerFinder) {
        this.imageSignerFinder = imageSignerFinder;
    }

    protected void runSQL(String sql) throws SystemException {
        try {
            PortalUtil.runSQL(sql);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
