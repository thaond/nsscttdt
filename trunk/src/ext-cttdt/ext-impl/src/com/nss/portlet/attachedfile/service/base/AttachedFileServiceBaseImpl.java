package com.nss.portlet.attachedfile.service.base;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.attachedfile.service.AttachedFileLocalService;
import com.nss.portlet.attachedfile.service.AttachedFileService;
import com.nss.portlet.attachedfile.service.persistence.AttachedFileFinder;
import com.nss.portlet.attachedfile.service.persistence.AttachedFilePersistence;


public abstract class AttachedFileServiceBaseImpl extends PrincipalBean
    implements AttachedFileService {
    @BeanReference(name = "com.nss.portlet.attachedfile.service.AttachedFileLocalService.impl")
    protected AttachedFileLocalService attachedFileLocalService;
    @BeanReference(name = "com.nss.portlet.attachedfile.service.AttachedFileService.impl")
    protected AttachedFileService attachedFileService;
    @BeanReference(name = "com.nss.portlet.attachedfile.service.persistence.AttachedFilePersistence.impl")
    protected AttachedFilePersistence attachedFilePersistence;
    @BeanReference(name = "com.nss.portlet.attachedfile.service.persistence.AttachedFileFinder.impl")
    protected AttachedFileFinder attachedFileFinder;

    public AttachedFileLocalService getAttachedFileLocalService() {
        return attachedFileLocalService;
    }

    public void setAttachedFileLocalService(
        AttachedFileLocalService attachedFileLocalService) {
        this.attachedFileLocalService = attachedFileLocalService;
    }

    public AttachedFileService getAttachedFileService() {
        return attachedFileService;
    }

    public void setAttachedFileService(AttachedFileService attachedFileService) {
        this.attachedFileService = attachedFileService;
    }

    public AttachedFilePersistence getAttachedFilePersistence() {
        return attachedFilePersistence;
    }

    public void setAttachedFilePersistence(
        AttachedFilePersistence attachedFilePersistence) {
        this.attachedFilePersistence = attachedFilePersistence;
    }

    public AttachedFileFinder getAttachedFileFinder() {
        return attachedFileFinder;
    }

    public void setAttachedFileFinder(AttachedFileFinder attachedFileFinder) {
        this.attachedFileFinder = attachedFileFinder;
    }

    protected void runSQL(String sql) throws SystemException {
        try {
            PortalUtil.runSQL(sql);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
