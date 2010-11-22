package com.nss.portlet.image_signer.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.image_signer.model.ImageSigner;
import com.nss.portlet.image_signer.service.ImageSignerLocalService;
import com.nss.portlet.image_signer.service.ImageSignerService;
import com.nss.portlet.image_signer.service.persistence.ImageSignerFinder;
import com.nss.portlet.image_signer.service.persistence.ImageSignerPersistence;

import java.util.List;


public abstract class ImageSignerLocalServiceBaseImpl
    implements ImageSignerLocalService {
    @BeanReference(name = "com.nss.portlet.image_signer.service.ImageSignerLocalService.impl")
    protected ImageSignerLocalService imageSignerLocalService;
    @BeanReference(name = "com.nss.portlet.image_signer.service.ImageSignerService.impl")
    protected ImageSignerService imageSignerService;
    @BeanReference(name = "com.nss.portlet.image_signer.service.persistence.ImageSignerPersistence.impl")
    protected ImageSignerPersistence imageSignerPersistence;
    @BeanReference(name = "com.nss.portlet.image_signer.service.persistence.ImageSignerFinder.impl")
    protected ImageSignerFinder imageSignerFinder;

    public ImageSigner addImageSigner(ImageSigner imageSigner)
        throws SystemException {
        imageSigner.setNew(true);

        return imageSignerPersistence.update(imageSigner, false);
    }

    public ImageSigner createImageSigner(long imageSignerId) {
        return imageSignerPersistence.create(imageSignerId);
    }

    public void deleteImageSigner(long imageSignerId)
        throws PortalException, SystemException {
        imageSignerPersistence.remove(imageSignerId);
    }

    public void deleteImageSigner(ImageSigner imageSigner)
        throws SystemException {
        imageSignerPersistence.remove(imageSigner);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return imageSignerPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return imageSignerPersistence.findWithDynamicQuery(dynamicQuery, start,
            end);
    }

    public ImageSigner getImageSigner(long imageSignerId)
        throws PortalException, SystemException {
        return imageSignerPersistence.findByPrimaryKey(imageSignerId);
    }

    public List<ImageSigner> getImageSigners(int start, int end)
        throws SystemException {
        return imageSignerPersistence.findAll(start, end);
    }

    public int getImageSignersCount() throws SystemException {
        return imageSignerPersistence.countAll();
    }

    public ImageSigner updateImageSigner(ImageSigner imageSigner)
        throws SystemException {
        imageSigner.setNew(false);

        return imageSignerPersistence.update(imageSigner, true);
    }

    public ImageSigner updateImageSigner(ImageSigner imageSigner, boolean merge)
        throws SystemException {
        imageSigner.setNew(false);

        return imageSignerPersistence.update(imageSigner, merge);
    }

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
