package com.sgs.portlet.organizationexternal.service.base;

import com.liferay.portal.service.base.PrincipalBean;

import com.sgs.portlet.organizationexternal.service.OrganizationExternalLocalService;
import com.sgs.portlet.organizationexternal.service.OrganizationExternalService;
import com.sgs.portlet.organizationexternal.service.persistence.OrganizationExternalFinder;
import com.sgs.portlet.organizationexternal.service.persistence.OrganizationExternalPersistence;


public abstract class OrganizationExternalServiceBaseImpl extends PrincipalBean
    implements OrganizationExternalService {
    @javax.annotation.Resource(name = "com.sgs.portlet.organizationexternal.service.OrganizationExternalLocalService.impl")
    protected OrganizationExternalLocalService organizationExternalLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.organizationexternal.service.OrganizationExternalService.impl")
    protected OrganizationExternalService organizationExternalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.organizationexternal.service.persistence.OrganizationExternalPersistence.impl")
    protected OrganizationExternalPersistence organizationExternalPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.organizationexternal.service.persistence.OrganizationExternalFinder.impl")
    protected OrganizationExternalFinder organizationExternalFinder;

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
