package com.nss.portlet.filetype.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.filetype.model.PmlFileTypeAttachedFile;
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

import java.util.List;


public abstract class PmlFileTypeAttachedFileLocalServiceBaseImpl
    implements PmlFileTypeAttachedFileLocalService {
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

    public PmlFileTypeAttachedFile addPmlFileTypeAttachedFile(
        PmlFileTypeAttachedFile pmlFileTypeAttachedFile)
        throws SystemException {
        pmlFileTypeAttachedFile.setNew(true);

        return pmlFileTypeAttachedFilePersistence.update(pmlFileTypeAttachedFile,
            false);
    }

    public PmlFileTypeAttachedFile createPmlFileTypeAttachedFile(
        String filetypeAttachedFileId) {
        return pmlFileTypeAttachedFilePersistence.create(filetypeAttachedFileId);
    }

    public void deletePmlFileTypeAttachedFile(String filetypeAttachedFileId)
        throws PortalException, SystemException {
        pmlFileTypeAttachedFilePersistence.remove(filetypeAttachedFileId);
    }

    public void deletePmlFileTypeAttachedFile(
        PmlFileTypeAttachedFile pmlFileTypeAttachedFile)
        throws SystemException {
        pmlFileTypeAttachedFilePersistence.remove(pmlFileTypeAttachedFile);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return pmlFileTypeAttachedFilePersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return pmlFileTypeAttachedFilePersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
    }

    public PmlFileTypeAttachedFile getPmlFileTypeAttachedFile(
        String filetypeAttachedFileId) throws PortalException, SystemException {
        return pmlFileTypeAttachedFilePersistence.findByPrimaryKey(filetypeAttachedFileId);
    }

    public List<PmlFileTypeAttachedFile> getPmlFileTypeAttachedFiles(
        int start, int end) throws SystemException {
        return pmlFileTypeAttachedFilePersistence.findAll(start, end);
    }

    public int getPmlFileTypeAttachedFilesCount() throws SystemException {
        return pmlFileTypeAttachedFilePersistence.countAll();
    }

    public PmlFileTypeAttachedFile updatePmlFileTypeAttachedFile(
        PmlFileTypeAttachedFile pmlFileTypeAttachedFile)
        throws SystemException {
        pmlFileTypeAttachedFile.setNew(false);

        return pmlFileTypeAttachedFilePersistence.update(pmlFileTypeAttachedFile,
            true);
    }

    public PmlFileTypeAttachedFile updatePmlFileTypeAttachedFile(
        PmlFileTypeAttachedFile pmlFileTypeAttachedFile, boolean merge)
        throws SystemException {
        pmlFileTypeAttachedFile.setNew(false);

        return pmlFileTypeAttachedFilePersistence.update(pmlFileTypeAttachedFile,
            merge);
    }

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
