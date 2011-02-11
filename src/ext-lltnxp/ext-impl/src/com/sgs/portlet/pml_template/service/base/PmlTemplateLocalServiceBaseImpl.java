package com.sgs.portlet.pml_template.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;

import com.sgs.portlet.pml_template.model.PmlTemplate;
import com.sgs.portlet.pml_template.service.FileTemplateLocalService;
import com.sgs.portlet.pml_template.service.FileTemplateService;
import com.sgs.portlet.pml_template.service.PmlTemplateLocalService;
import com.sgs.portlet.pml_template.service.PmlTemplateService;
import com.sgs.portlet.pml_template.service.persistence.FileTemplatePersistence;
import com.sgs.portlet.pml_template.service.persistence.PmlTemplateFinder;
import com.sgs.portlet.pml_template.service.persistence.PmlTemplatePersistence;

import java.util.List;


public abstract class PmlTemplateLocalServiceBaseImpl
    implements PmlTemplateLocalService {
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

    public PmlTemplate addPmlTemplate(PmlTemplate pmlTemplate)
        throws SystemException {
        pmlTemplate.setNew(true);

        return pmlTemplatePersistence.update(pmlTemplate, false);
    }

    public PmlTemplate createPmlTemplate(long templateId) {
        return pmlTemplatePersistence.create(templateId);
    }

    public void deletePmlTemplate(long templateId)
        throws PortalException, SystemException {
        pmlTemplatePersistence.remove(templateId);
    }

    public void deletePmlTemplate(PmlTemplate pmlTemplate)
        throws SystemException {
        pmlTemplatePersistence.remove(pmlTemplate);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return pmlTemplatePersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return pmlTemplatePersistence.findWithDynamicQuery(dynamicQuery, start,
            end);
    }

    public PmlTemplate getPmlTemplate(long templateId)
        throws PortalException, SystemException {
        return pmlTemplatePersistence.findByPrimaryKey(templateId);
    }

    public List<PmlTemplate> getPmlTemplates(int start, int end)
        throws SystemException {
        return pmlTemplatePersistence.findAll(start, end);
    }

    public int getPmlTemplatesCount() throws SystemException {
        return pmlTemplatePersistence.countAll();
    }

    public PmlTemplate updatePmlTemplate(PmlTemplate pmlTemplate)
        throws SystemException {
        pmlTemplate.setNew(false);

        return pmlTemplatePersistence.update(pmlTemplate, true);
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
