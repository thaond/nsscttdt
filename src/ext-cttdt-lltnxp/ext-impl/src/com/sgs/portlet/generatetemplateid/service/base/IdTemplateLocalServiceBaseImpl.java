package com.sgs.portlet.generatetemplateid.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;

import com.sgs.portlet.generatetemplateid.model.IdTemplate;
import com.sgs.portlet.generatetemplateid.service.IdGeneratedLocalService;
import com.sgs.portlet.generatetemplateid.service.IdGeneratedService;
import com.sgs.portlet.generatetemplateid.service.IdTemplateLocalService;
import com.sgs.portlet.generatetemplateid.service.IdTemplateService;
import com.sgs.portlet.generatetemplateid.service.persistence.IdGeneratedFinder;
import com.sgs.portlet.generatetemplateid.service.persistence.IdGeneratedPersistence;
import com.sgs.portlet.generatetemplateid.service.persistence.IdTemplateFinder;
import com.sgs.portlet.generatetemplateid.service.persistence.IdTemplatePersistence;

import java.util.List;


public abstract class IdTemplateLocalServiceBaseImpl
    implements IdTemplateLocalService {
    @javax.annotation.Resource(name = "com.sgs.portlet.generatetemplateid.service.IdTemplateLocalService.impl")
    protected IdTemplateLocalService idTemplateLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.generatetemplateid.service.IdTemplateService.impl")
    protected IdTemplateService idTemplateService;
    @javax.annotation.Resource(name = "com.sgs.portlet.generatetemplateid.service.persistence.IdTemplatePersistence.impl")
    protected IdTemplatePersistence idTemplatePersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.generatetemplateid.service.persistence.IdTemplateFinder.impl")
    protected IdTemplateFinder idTemplateFinder;
    @javax.annotation.Resource(name = "com.sgs.portlet.generatetemplateid.service.IdGeneratedLocalService.impl")
    protected IdGeneratedLocalService idGeneratedLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.generatetemplateid.service.IdGeneratedService.impl")
    protected IdGeneratedService idGeneratedService;
    @javax.annotation.Resource(name = "com.sgs.portlet.generatetemplateid.service.persistence.IdGeneratedPersistence.impl")
    protected IdGeneratedPersistence idGeneratedPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.generatetemplateid.service.persistence.IdGeneratedFinder.impl")
    protected IdGeneratedFinder idGeneratedFinder;

    public IdTemplate addIdTemplate(IdTemplate idTemplate)
        throws SystemException {
        idTemplate.setNew(true);

        return idTemplatePersistence.update(idTemplate, false);
    }

    public IdTemplate createIdTemplate(long templateId) {
        return idTemplatePersistence.create(templateId);
    }

    public void deleteIdTemplate(long templateId)
        throws PortalException, SystemException {
        idTemplatePersistence.remove(templateId);
    }

    public void deleteIdTemplate(IdTemplate idTemplate)
        throws SystemException {
        idTemplatePersistence.remove(idTemplate);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return idTemplatePersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return idTemplatePersistence.findWithDynamicQuery(dynamicQuery, start,
            end);
    }

    public IdTemplate getIdTemplate(long templateId)
        throws PortalException, SystemException {
        return idTemplatePersistence.findByPrimaryKey(templateId);
    }

    public List<IdTemplate> getIdTemplates(int start, int end)
        throws SystemException {
        return idTemplatePersistence.findAll(start, end);
    }

    public int getIdTemplatesCount() throws SystemException {
        return idTemplatePersistence.countAll();
    }

    public IdTemplate updateIdTemplate(IdTemplate idTemplate)
        throws SystemException {
        idTemplate.setNew(false);

        return idTemplatePersistence.update(idTemplate, true);
    }

    public IdTemplateLocalService getIdTemplateLocalService() {
        return idTemplateLocalService;
    }

    public void setIdTemplateLocalService(
        IdTemplateLocalService idTemplateLocalService) {
        this.idTemplateLocalService = idTemplateLocalService;
    }

    public IdTemplateService getIdTemplateService() {
        return idTemplateService;
    }

    public void setIdTemplateService(IdTemplateService idTemplateService) {
        this.idTemplateService = idTemplateService;
    }

    public IdTemplatePersistence getIdTemplatePersistence() {
        return idTemplatePersistence;
    }

    public void setIdTemplatePersistence(
        IdTemplatePersistence idTemplatePersistence) {
        this.idTemplatePersistence = idTemplatePersistence;
    }

    public IdTemplateFinder getIdTemplateFinder() {
        return idTemplateFinder;
    }

    public void setIdTemplateFinder(IdTemplateFinder idTemplateFinder) {
        this.idTemplateFinder = idTemplateFinder;
    }

    public IdGeneratedLocalService getIdGeneratedLocalService() {
        return idGeneratedLocalService;
    }

    public void setIdGeneratedLocalService(
        IdGeneratedLocalService idGeneratedLocalService) {
        this.idGeneratedLocalService = idGeneratedLocalService;
    }

    public IdGeneratedService getIdGeneratedService() {
        return idGeneratedService;
    }

    public void setIdGeneratedService(IdGeneratedService idGeneratedService) {
        this.idGeneratedService = idGeneratedService;
    }

    public IdGeneratedPersistence getIdGeneratedPersistence() {
        return idGeneratedPersistence;
    }

    public void setIdGeneratedPersistence(
        IdGeneratedPersistence idGeneratedPersistence) {
        this.idGeneratedPersistence = idGeneratedPersistence;
    }

    public IdGeneratedFinder getIdGeneratedFinder() {
        return idGeneratedFinder;
    }

    public void setIdGeneratedFinder(IdGeneratedFinder idGeneratedFinder) {
        this.idGeneratedFinder = idGeneratedFinder;
    }
}
