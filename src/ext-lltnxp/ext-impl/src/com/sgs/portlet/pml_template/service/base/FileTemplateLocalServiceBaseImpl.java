package com.sgs.portlet.pml_template.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;

import com.sgs.portlet.pml_template.model.FileTemplate;
import com.sgs.portlet.pml_template.service.FileTemplateLocalService;
import com.sgs.portlet.pml_template.service.FileTemplateService;
import com.sgs.portlet.pml_template.service.PmlTemplateLocalService;
import com.sgs.portlet.pml_template.service.PmlTemplateService;
import com.sgs.portlet.pml_template.service.persistence.FileTemplatePersistence;
import com.sgs.portlet.pml_template.service.persistence.PmlTemplateFinder;
import com.sgs.portlet.pml_template.service.persistence.PmlTemplatePersistence;

import java.util.List;


public abstract class FileTemplateLocalServiceBaseImpl
    implements FileTemplateLocalService {
    @javax.annotation.Resource(name = "com.sgs.portlet.pml_template.service.PmlTemplateLocalService.impl")
    protected PmlTemplateLocalService pmlTemplateLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.pml_template.service.PmlTemplateService.impl")
    protected PmlTemplateService pmlTemplateService;
    @javax.annotation.Resource(name = "com.sgs.portlet.pml_template.service.persistence.PmlTemplatePersistence.impl")
    protected PmlTemplatePersistence pmlTemplatePersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.pml_template.service.persistence.PmlTemplateFinder.impl")
    protected PmlTemplateFinder pmlTemplateFinder;
    @javax.annotation.Resource(name = "com.sgs.portlet.pml_template.service.FileTemplateLocalService.impl")
    protected FileTemplateLocalService fileTemplateLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.pml_template.service.FileTemplateService.impl")
    protected FileTemplateService fileTemplateService;
    @javax.annotation.Resource(name = "com.sgs.portlet.pml_template.service.persistence.FileTemplatePersistence.impl")
    protected FileTemplatePersistence fileTemplatePersistence;

    public FileTemplate addFileTemplate(FileTemplate fileTemplate)
        throws SystemException {
        fileTemplate.setNew(true);

        return fileTemplatePersistence.update(fileTemplate, false);
    }

    public FileTemplate createFileTemplate(long fileTemplateId) {
        return fileTemplatePersistence.create(fileTemplateId);
    }

    public void deleteFileTemplate(long fileTemplateId)
        throws PortalException, SystemException {
        fileTemplatePersistence.remove(fileTemplateId);
    }

    public void deleteFileTemplate(FileTemplate fileTemplate)
        throws SystemException {
        fileTemplatePersistence.remove(fileTemplate);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return fileTemplatePersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return fileTemplatePersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
    }

    public FileTemplate getFileTemplate(long fileTemplateId)
        throws PortalException, SystemException {
        return fileTemplatePersistence.findByPrimaryKey(fileTemplateId);
    }

    public List<FileTemplate> getFileTemplates(int start, int end)
        throws SystemException {
        return fileTemplatePersistence.findAll(start, end);
    }

    public int getFileTemplatesCount() throws SystemException {
        return fileTemplatePersistence.countAll();
    }

    public FileTemplate updateFileTemplate(FileTemplate fileTemplate)
        throws SystemException {
        fileTemplate.setNew(false);

        return fileTemplatePersistence.update(fileTemplate, true);
    }

    public PmlTemplateLocalService getPmlTemplateLocalService() {
        return pmlTemplateLocalService;
    }

    public void setPmlTemplateLocalService(
        PmlTemplateLocalService pmlTemplateLocalService) {
        this.pmlTemplateLocalService = pmlTemplateLocalService;
    }

    public PmlTemplateService getPmlTemplateService() {
        return pmlTemplateService;
    }

    public void setPmlTemplateService(PmlTemplateService pmlTemplateService) {
        this.pmlTemplateService = pmlTemplateService;
    }

    public PmlTemplatePersistence getPmlTemplatePersistence() {
        return pmlTemplatePersistence;
    }

    public void setPmlTemplatePersistence(
        PmlTemplatePersistence pmlTemplatePersistence) {
        this.pmlTemplatePersistence = pmlTemplatePersistence;
    }

    public PmlTemplateFinder getPmlTemplateFinder() {
        return pmlTemplateFinder;
    }

    public void setPmlTemplateFinder(PmlTemplateFinder pmlTemplateFinder) {
        this.pmlTemplateFinder = pmlTemplateFinder;
    }

    public FileTemplateLocalService getFileTemplateLocalService() {
        return fileTemplateLocalService;
    }

    public void setFileTemplateLocalService(
        FileTemplateLocalService fileTemplateLocalService) {
        this.fileTemplateLocalService = fileTemplateLocalService;
    }

    public FileTemplateService getFileTemplateService() {
        return fileTemplateService;
    }

    public void setFileTemplateService(FileTemplateService fileTemplateService) {
        this.fileTemplateService = fileTemplateService;
    }

    public FileTemplatePersistence getFileTemplatePersistence() {
        return fileTemplatePersistence;
    }

    public void setFileTemplatePersistence(
        FileTemplatePersistence fileTemplatePersistence) {
        this.fileTemplatePersistence = fileTemplatePersistence;
    }
}
