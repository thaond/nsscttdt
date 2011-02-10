package com.sgs.portlet.organizationexternal.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;

import com.sgs.portlet.organizationexternal.model.OrganizationExternal;
import com.sgs.portlet.organizationexternal.service.OrganizationExternalLocalService;
import com.sgs.portlet.organizationexternal.service.OrganizationExternalService;
import com.sgs.portlet.organizationexternal.service.persistence.OrganizationExternalFinder;
import com.sgs.portlet.organizationexternal.service.persistence.OrganizationExternalPersistence;

import java.util.List;


public abstract class OrganizationExternalLocalServiceBaseImpl
    implements OrganizationExternalLocalService {
    @javax.annotation.Resource(name = "com.sgs.portlet.organizationexternal.service.OrganizationExternalLocalService.impl")
    protected OrganizationExternalLocalService organizationExternalLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.organizationexternal.service.OrganizationExternalService.impl")
    protected OrganizationExternalService organizationExternalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.organizationexternal.service.persistence.OrganizationExternalPersistence.impl")
    protected OrganizationExternalPersistence organizationExternalPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.organizationexternal.service.persistence.OrganizationExternalFinder.impl")
    protected OrganizationExternalFinder organizationExternalFinder;

    public OrganizationExternal addOrganizationExternal(
        OrganizationExternal organizationExternal) throws SystemException {
        organizationExternal.setNew(true);

        return organizationExternalPersistence.update(organizationExternal,
            false);
    }

    public OrganizationExternal createOrganizationExternal(long orgExternalId) {
        return organizationExternalPersistence.create(orgExternalId);
    }

    public void deleteOrganizationExternal(long orgExternalId)
        throws PortalException, SystemException {
        organizationExternalPersistence.remove(orgExternalId);
    }

    public void deleteOrganizationExternal(
        OrganizationExternal organizationExternal) throws SystemException {
        organizationExternalPersistence.remove(organizationExternal);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return organizationExternalPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return organizationExternalPersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
    }

    public OrganizationExternal getOrganizationExternal(long orgExternalId)
        throws PortalException, SystemException {
        return organizationExternalPersistence.findByPrimaryKey(orgExternalId);
    }

    public List<OrganizationExternal> getOrganizationExternals(int start,
        int end) throws SystemException {
        return organizationExternalPersistence.findAll(start, end);
    }

    public int getOrganizationExternalsCount() throws SystemException {
        return organizationExternalPersistence.countAll();
    }

    public OrganizationExternal updateOrganizationExternal(
        OrganizationExternal organizationExternal) throws SystemException {
        organizationExternal.setNew(false);

        return organizationExternalPersistence.update(organizationExternal, true);
    }

    public OrganizationExternalLocalService getOrganizationExternalLocalService() {
        return organizationExternalLocalService;
    }

    public void setOrganizationExternalLocalService(
        OrganizationExternalLocalService organizationExternalLocalService) {
        this.organizationExternalLocalService = organizationExternalLocalService;
    }

    public OrganizationExternalService getOrganizationExternalService() {
        return organizationExternalService;
    }

    public void setOrganizationExternalService(
        OrganizationExternalService organizationExternalService) {
        this.organizationExternalService = organizationExternalService;
    }

    public OrganizationExternalPersistence getOrganizationExternalPersistence() {
        return organizationExternalPersistence;
    }

    public void setOrganizationExternalPersistence(
        OrganizationExternalPersistence organizationExternalPersistence) {
        this.organizationExternalPersistence = organizationExternalPersistence;
    }

    public OrganizationExternalFinder getOrganizationExternalFinder() {
        return organizationExternalFinder;
    }

    public void setOrganizationExternalFinder(
        OrganizationExternalFinder organizationExternalFinder) {
        this.organizationExternalFinder = organizationExternalFinder;
    }
}
