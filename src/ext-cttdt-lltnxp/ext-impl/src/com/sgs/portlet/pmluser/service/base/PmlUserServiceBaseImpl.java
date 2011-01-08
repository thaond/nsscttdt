package com.sgs.portlet.pmluser.service.base;

import com.liferay.portal.service.base.PrincipalBean;

import com.sgs.portlet.pmluser.service.PmlUserLocalService;
import com.sgs.portlet.pmluser.service.PmlUserService;
import com.sgs.portlet.pmluser.service.persistence.PmlUserFinder;
import com.sgs.portlet.pmluser.service.persistence.PmlUserPersistence;


public abstract class PmlUserServiceBaseImpl extends PrincipalBean
    implements PmlUserService {
    @javax.annotation.Resource(name = "com.sgs.portlet.pmluser.service.PmlUserLocalService.impl")
    protected PmlUserLocalService pmlUserLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.pmluser.service.PmlUserService.impl")
    protected PmlUserService pmlUserService;
    @javax.annotation.Resource(name = "com.sgs.portlet.pmluser.service.persistence.PmlUserPersistence.impl")
    protected PmlUserPersistence pmlUserPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.pmluser.service.persistence.PmlUserFinder.impl")
    protected PmlUserFinder pmlUserFinder;

    public PmlUserLocalService getPmlUserLocalService() {
        return pmlUserLocalService;
    }

    public void setPmlUserLocalService(PmlUserLocalService pmlUserLocalService) {
        this.pmlUserLocalService = pmlUserLocalService;
    }

    public PmlUserService getPmlUserService() {
        return pmlUserService;
    }

    public void setPmlUserService(PmlUserService pmlUserService) {
        this.pmlUserService = pmlUserService;
    }

    public PmlUserPersistence getPmlUserPersistence() {
        return pmlUserPersistence;
    }

    public void setPmlUserPersistence(PmlUserPersistence pmlUserPersistence) {
        this.pmlUserPersistence = pmlUserPersistence;
    }

    public PmlUserFinder getPmlUserFinder() {
        return pmlUserFinder;
    }

    public void setPmlUserFinder(PmlUserFinder pmlUserFinder) {
        this.pmlUserFinder = pmlUserFinder;
    }
}
