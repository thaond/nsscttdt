package com.sgs.portlet.documentdelegate.service.base;

import com.liferay.portal.service.base.PrincipalBean;

import com.sgs.portlet.documentdelegate.service.PmlDocumentDelegateLocalService;
import com.sgs.portlet.documentdelegate.service.PmlDocumentDelegateService;
import com.sgs.portlet.documentdelegate.service.persistence.PmlDocumentDelegateFinder;
import com.sgs.portlet.documentdelegate.service.persistence.PmlDocumentDelegatePersistence;


public abstract class PmlDocumentDelegateServiceBaseImpl extends PrincipalBean
    implements PmlDocumentDelegateService {
    @javax.annotation.Resource(name = "com.sgs.portlet.documentdelegate.service.PmlDocumentDelegateLocalService.impl")
    protected PmlDocumentDelegateLocalService pmlDocumentDelegateLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.documentdelegate.service.PmlDocumentDelegateService.impl")
    protected PmlDocumentDelegateService pmlDocumentDelegateService;
    @javax.annotation.Resource(name = "com.sgs.portlet.documentdelegate.service.persistence.PmlDocumentDelegatePersistence.impl")
    protected PmlDocumentDelegatePersistence pmlDocumentDelegatePersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.documentdelegate.service.persistence.PmlDocumentDelegateFinder.impl")
    protected PmlDocumentDelegateFinder pmlDocumentDelegateFinder;

    public PmlDocumentDelegateLocalService getPmlDocumentDelegateLocalService() {
        return pmlDocumentDelegateLocalService;
    }

    public void setPmlDocumentDelegateLocalService(
        PmlDocumentDelegateLocalService pmlDocumentDelegateLocalService) {
        this.pmlDocumentDelegateLocalService = pmlDocumentDelegateLocalService;
    }

    public PmlDocumentDelegateService getPmlDocumentDelegateService() {
        return pmlDocumentDelegateService;
    }

    public void setPmlDocumentDelegateService(
        PmlDocumentDelegateService pmlDocumentDelegateService) {
        this.pmlDocumentDelegateService = pmlDocumentDelegateService;
    }

    public PmlDocumentDelegatePersistence getPmlDocumentDelegatePersistence() {
        return pmlDocumentDelegatePersistence;
    }

    public void setPmlDocumentDelegatePersistence(
        PmlDocumentDelegatePersistence pmlDocumentDelegatePersistence) {
        this.pmlDocumentDelegatePersistence = pmlDocumentDelegatePersistence;
    }

    public PmlDocumentDelegateFinder getPmlDocumentDelegateFinder() {
        return pmlDocumentDelegateFinder;
    }

    public void setPmlDocumentDelegateFinder(
        PmlDocumentDelegateFinder pmlDocumentDelegateFinder) {
        this.pmlDocumentDelegateFinder = pmlDocumentDelegateFinder;
    }
}
