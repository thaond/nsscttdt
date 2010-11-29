package com.nss.portlet.generatetemplateid.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.generatetemplateid.model.IdGenerated;
import com.nss.portlet.generatetemplateid.service.IdGeneratedLocalService;
import com.nss.portlet.generatetemplateid.service.IdGeneratedService;
import com.nss.portlet.generatetemplateid.service.IdTemplateLocalService;
import com.nss.portlet.generatetemplateid.service.persistence.IdGeneratedPersistence;
import com.nss.portlet.generatetemplateid.service.persistence.IdTemplateFinder;
import com.nss.portlet.generatetemplateid.service.persistence.IdTemplatePersistence;

import java.util.List;


public abstract class IdGeneratedLocalServiceBaseImpl
    implements IdGeneratedLocalService {
    @BeanReference(name = "com.nss.portlet.generatetemplateid.service.IdTemplateLocalService.impl")
    protected IdTemplateLocalService idTemplateLocalService;
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

    public IdGenerated addIdGenerated(IdGenerated idGenerated)
        throws SystemException {
        idGenerated.setNew(true);

        return idGeneratedPersistence.update(idGenerated, false);
    }

    public IdGenerated createIdGenerated(long id) {
        return idGeneratedPersistence.create(id);
    }

    public void deleteIdGenerated(long id)
        throws PortalException, SystemException {
        idGeneratedPersistence.remove(id);
    }

    public void deleteIdGenerated(IdGenerated idGenerated)
        throws SystemException {
        idGeneratedPersistence.remove(idGenerated);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return idGeneratedPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return idGeneratedPersistence.findWithDynamicQuery(dynamicQuery, start,
            end);
    }

    public IdGenerated getIdGenerated(long id)
        throws PortalException, SystemException {
        return idGeneratedPersistence.findByPrimaryKey(id);
    }

    public List<IdGenerated> getIdGenerateds(int start, int end)
        throws SystemException {
        return idGeneratedPersistence.findAll(start, end);
    }

    public int getIdGeneratedsCount() throws SystemException {
        return idGeneratedPersistence.countAll();
    }

    public IdGenerated updateIdGenerated(IdGenerated idGenerated)
        throws SystemException {
        idGenerated.setNew(false);

        return idGeneratedPersistence.update(idGenerated, true);
    }

    public IdGenerated updateIdGenerated(IdGenerated idGenerated, boolean merge)
        throws SystemException {
        idGenerated.setNew(false);

        return idGeneratedPersistence.update(idGenerated, merge);
    }

    public IdTemplateLocalService getIdTemplateLocalService() {
        return idTemplateLocalService;
    }

    public void setIdTemplateLocalService(
        IdTemplateLocalService idTemplateLocalService) {
        this.idTemplateLocalService = idTemplateLocalService;
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
