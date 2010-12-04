package com.nss.portlet.generatetemplateid.service.base;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.generatetemplateid.service.IdGeneratedLocalService;
import com.nss.portlet.generatetemplateid.service.IdGeneratedService;
import com.nss.portlet.generatetemplateid.service.IdTemplateLocalService;
import com.nss.portlet.generatetemplateid.service.IdTemplateService;
import com.nss.portlet.generatetemplateid.service.persistence.IdGeneratedPersistence;
import com.nss.portlet.generatetemplateid.service.persistence.IdTemplateFinder;
import com.nss.portlet.generatetemplateid.service.persistence.IdTemplatePersistence;


public abstract class IdGeneratedServiceBaseImpl extends PrincipalBean
    implements IdGeneratedService {
    @BeanReference(name = "com.nss.portlet.generatetemplateid.service.IdTemplateLocalService.impl")
    protected IdTemplateLocalService idTemplateLocalService;
    @BeanReference(name = "com.nss.portlet.generatetemplateid.service.IdTemplateService.impl")
    protected IdTemplateService idTemplateService;
    @BeanReference(name = "com.nss.portlet.generatetemplateid.service.persistence.IdTemplatePersistence.impl")
    protected IdTemplatePersistence idTemplatePersistence;
    @BeanReference(name = "com.nss.portlet.generatetemplateid.service.persistence.IdTemplateFinder.impl")
    protected IdTemplateFinder idTemplateFinder;
    @BeanReference(name = "com.nss.portlet.generatetemplateid.service.IdGeneratedLocalService.impl")
    protected IdGeneratedLocalService idGeneratedLocalService;
    @BeanReference(name = "com.nss.portlet.generatetemplateid.service.IdGeneratedService.impl")
    protected IdGeneratedService idGeneratedService;
    @BeanReference(name = "com.nss.portlet.generatetemplateid.service.persistence.IdGeneratedPersistence.impl")
    protected IdGeneratedPersistence idGeneratedPersistence;

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

    protected void runSQL(String sql) throws SystemException {
        try {
            PortalUtil.runSQL(sql);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
