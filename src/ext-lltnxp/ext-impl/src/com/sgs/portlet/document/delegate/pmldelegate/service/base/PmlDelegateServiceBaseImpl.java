package com.sgs.portlet.document.delegate.pmldelegate.service.base;

import com.liferay.portal.service.base.PrincipalBean;

import com.sgs.portlet.document.delegate.pmldelegate.service.PmlDelegateLocalService;
import com.sgs.portlet.document.delegate.pmldelegate.service.PmlDelegateService;
import com.sgs.portlet.document.delegate.pmldelegate.service.persistence.PmlDelegateFinder;
import com.sgs.portlet.document.delegate.pmldelegate.service.persistence.PmlDelegatePersistence;


public abstract class PmlDelegateServiceBaseImpl extends PrincipalBean
    implements PmlDelegateService {
    @javax.annotation.Resource(name = "com.sgs.portlet.document.delegate.pmldelegate.service.PmlDelegateLocalService.impl")
    protected PmlDelegateLocalService pmlDelegateLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.delegate.pmldelegate.service.PmlDelegateService.impl")
    protected PmlDelegateService pmlDelegateService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.delegate.pmldelegate.service.persistence.PmlDelegatePersistence.impl")
    protected PmlDelegatePersistence pmlDelegatePersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.delegate.pmldelegate.service.persistence.PmlDelegateFinder.impl")
    protected PmlDelegateFinder pmlDelegateFinder;

    public PmlDelegateLocalService getPmlDelegateLocalService() {
        return pmlDelegateLocalService;
    }

    public void setPmlDelegateLocalService(
        PmlDelegateLocalService pmlDelegateLocalService) {
        this.pmlDelegateLocalService = pmlDelegateLocalService;
    }

    public PmlDelegateService getPmlDelegateService() {
        return pmlDelegateService;
    }

    public void setPmlDelegateService(PmlDelegateService pmlDelegateService) {
        this.pmlDelegateService = pmlDelegateService;
    }

    public PmlDelegatePersistence getPmlDelegatePersistence() {
        return pmlDelegatePersistence;
    }

    public void setPmlDelegatePersistence(
        PmlDelegatePersistence pmlDelegatePersistence) {
        this.pmlDelegatePersistence = pmlDelegatePersistence;
    }

    public PmlDelegateFinder getPmlDelegateFinder() {
        return pmlDelegateFinder;
    }

    public void setPmlDelegateFinder(PmlDelegateFinder pmlDelegateFinder) {
        this.pmlDelegateFinder = pmlDelegateFinder;
    }
}
