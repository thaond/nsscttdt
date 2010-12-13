package com.nss.portlet.filetype.service.base;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.filetype.service.PmlFileAttachedFileLocalService;
import com.nss.portlet.filetype.service.PmlFileAttachedFileService;
import com.nss.portlet.filetype.service.PmlFileTypeAttachedFileLocalService;
import com.nss.portlet.filetype.service.PmlFileTypeAttachedFileService;
import com.nss.portlet.filetype.service.PmlFileTypeLocalService;
import com.nss.portlet.filetype.service.PmlFileTypeService;
import com.nss.portlet.filetype.service.persistence.PmlFileAttachedFilePersistence;
import com.nss.portlet.filetype.service.persistence.PmlFileTypeAttachedFilePersistence;
import com.nss.portlet.filetype.service.persistence.PmlFileTypeFinder;
import com.nss.portlet.filetype.service.persistence.PmlFileTypePersistence;


public abstract class PmlFileTypeServiceBaseImpl extends PrincipalBean
    implements PmlFileTypeService {
    @BeanReference(name = "com.nss.portlet.filetype.service.PmlFileTypeLocalService.impl")
    protected PmlFileTypeLocalService pmlFileTypeLocalService;
    @BeanReference(name = "com.nss.portlet.filetype.service.PmlFileTypeService.impl")
    protected PmlFileTypeService pmlFileTypeService;
    @BeanReference(name = "com.nss.portlet.filetype.service.persistence.PmlFileTypePersistence.impl")
    protected PmlFileTypePersistence pmlFileTypePersistence;
    @BeanReference(name = "com.nss.portlet.filetype.service.persistence.PmlFileTypeFinder.impl")
    protected PmlFileTypeFinder pmlFileTypeFinder;
    @BeanReference(name = "com.nss.portlet.filetype.service.PmlFileTypeAttachedFileLocalService.impl")
    protected PmlFileTypeAttachedFileLocalService pmlFileTypeAttachedFileLocalService;
    @BeanReference(name = "com.nss.portlet.filetype.service.PmlFileTypeAttachedFileService.impl")
    protected PmlFileTypeAttachedFileService pmlFileTypeAttachedFileService;
    @BeanReference(name = "com.nss.portlet.filetype.service.persistence.PmlFileTypeAttachedFilePersistence.impl")
    protected PmlFileTypeAttachedFilePersistence pmlFileTypeAttachedFilePersistence;
    @BeanReference(name = "com.nss.portlet.filetype.service.PmlFileAttachedFileLocalService.impl")
    protected PmlFileAttachedFileLocalService pmlFileAttachedFileLocalService;
    @BeanReference(name = "com.nss.portlet.filetype.service.PmlFileAttachedFileService.impl")
    protected PmlFileAttachedFileService pmlFileAttachedFileService;
    @BeanReference(name = "com.nss.portlet.filetype.service.persistence.PmlFileAttachedFilePersistence.impl")
    protected PmlFileAttachedFilePersistence pmlFileAttachedFilePersistence;

    public PmlFileTypeLocalService getPmlFileTypeLocalService() {
        return pmlFileTypeLocalService;
    }

    public void setPmlFileTypeLocalService(
        PmlFileTypeLocalService pmlFileTypeLocalService) {
        this.pmlFileTypeLocalService = pmlFileTypeLocalService;
    }

    public PmlFileTypeService getPmlFileTypeService() {
        return pmlFileTypeService;
    }

    public void setPmlFileTypeService(PmlFileTypeService pmlFileTypeService) {
        this.pmlFileTypeService = pmlFileTypeService;
    }

    public PmlFileTypePersistence getPmlFileTypePersistence() {
        return pmlFileTypePersistence;
    }

    public void setPmlFileTypePersistence(
        PmlFileTypePersistence pmlFileTypePersistence) {
        this.pmlFileTypePersistence = pmlFileTypePersistence;
    }

    public PmlFileTypeFinder getPmlFileTypeFinder() {
        return pmlFileTypeFinder;
    }

    public void setPmlFileTypeFinder(PmlFileTypeFinder pmlFileTypeFinder) {
        this.pmlFileTypeFinder = pmlFileTypeFinder;
    }

    public PmlFileTypeAttachedFileLocalService getPmlFileTypeAttachedFileLocalService() {
        return pmlFileTypeAttachedFileLocalService;
    }

    public void setPmlFileTypeAttachedFileLocalService(
        PmlFileTypeAttachedFileLocalService pmlFileTypeAttachedFileLocalService) {
        this.pmlFileTypeAttachedFileLocalService = pmlFileTypeAttachedFileLocalService;
    }

    public PmlFileTypeAttachedFileService getPmlFileTypeAttachedFileService() {
        return pmlFileTypeAttachedFileService;
    }

    public void setPmlFileTypeAttachedFileService(
        PmlFileTypeAttachedFileService pmlFileTypeAttachedFileService) {
        this.pmlFileTypeAttachedFileService = pmlFileTypeAttachedFileService;
    }

    public PmlFileTypeAttachedFilePersistence getPmlFileTypeAttachedFilePersistence() {
        return pmlFileTypeAttachedFilePersistence;
    }

    public void setPmlFileTypeAttachedFilePersistence(
        PmlFileTypeAttachedFilePersistence pmlFileTypeAttachedFilePersistence) {
        this.pmlFileTypeAttachedFilePersistence = pmlFileTypeAttachedFilePersistence;
    }

    public PmlFileAttachedFileLocalService getPmlFileAttachedFileLocalService() {
        return pmlFileAttachedFileLocalService;
    }

    public void setPmlFileAttachedFileLocalService(
        PmlFileAttachedFileLocalService pmlFileAttachedFileLocalService) {
        this.pmlFileAttachedFileLocalService = pmlFileAttachedFileLocalService;
    }

    public PmlFileAttachedFileService getPmlFileAttachedFileService() {
        return pmlFileAttachedFileService;
    }

    public void setPmlFileAttachedFileService(
        PmlFileAttachedFileService pmlFileAttachedFileService) {
        this.pmlFileAttachedFileService = pmlFileAttachedFileService;
    }

    public PmlFileAttachedFilePersistence getPmlFileAttachedFilePersistence() {
        return pmlFileAttachedFilePersistence;
    }

    public void setPmlFileAttachedFilePersistence(
        PmlFileAttachedFilePersistence pmlFileAttachedFilePersistence) {
        this.pmlFileAttachedFilePersistence = pmlFileAttachedFilePersistence;
    }

    protected void runSQL(String sql) throws SystemException {
        try {
            PortalUtil.runSQL(sql);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
