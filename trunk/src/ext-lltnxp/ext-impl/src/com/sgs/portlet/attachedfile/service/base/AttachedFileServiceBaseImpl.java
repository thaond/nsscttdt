package com.sgs.portlet.attachedfile.service.base;

import com.liferay.portal.service.base.PrincipalBean;

import com.sgs.portlet.attachedfile.service.AttachedFileLocalService;
import com.sgs.portlet.attachedfile.service.AttachedFileService;
import com.sgs.portlet.attachedfile.service.persistence.AttachedFileFinder;
import com.sgs.portlet.attachedfile.service.persistence.AttachedFilePersistence;


public abstract class AttachedFileServiceBaseImpl extends PrincipalBean
    implements AttachedFileService {
    @javax.annotation.Resource(name = "com.sgs.portlet.attachedfile.service.AttachedFileLocalService.impl")
    protected AttachedFileLocalService attachedFileLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.attachedfile.service.AttachedFileService.impl")
    protected AttachedFileService attachedFileService;
    @javax.annotation.Resource(name = "com.sgs.portlet.attachedfile.service.persistence.AttachedFilePersistence.impl")
    protected AttachedFilePersistence attachedFilePersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.attachedfile.service.persistence.AttachedFileFinder.impl")
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
}
