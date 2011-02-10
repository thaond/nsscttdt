package com.sgs.portlet.field.service.base;

import com.liferay.portal.service.base.PrincipalBean;

import com.sgs.portlet.field.service.PmlFieldLocalService;
import com.sgs.portlet.field.service.PmlFieldService;
import com.sgs.portlet.field.service.persistence.PmlFieldFinder;
import com.sgs.portlet.field.service.persistence.PmlFieldPersistence;


public abstract class PmlFieldServiceBaseImpl extends PrincipalBean
    implements PmlFieldService {
    @javax.annotation.Resource(name = "com.sgs.portlet.field.service.PmlFieldLocalService.impl")
    protected PmlFieldLocalService pmlFieldLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.field.service.PmlFieldService.impl")
    protected PmlFieldService pmlFieldService;
    @javax.annotation.Resource(name = "com.sgs.portlet.field.service.persistence.PmlFieldPersistence.impl")
    protected PmlFieldPersistence pmlFieldPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.field.service.persistence.PmlFieldFinder.impl")
    protected PmlFieldFinder pmlFieldFinder;

    public PmlFieldLocalService getPmlFieldLocalService() {
        return pmlFieldLocalService;
    }

    public void setPmlFieldLocalService(
        PmlFieldLocalService pmlFieldLocalService) {
        this.pmlFieldLocalService = pmlFieldLocalService;
    }

    public PmlFieldService getPmlFieldService() {
        return pmlFieldService;
    }

    public void setPmlFieldService(PmlFieldService pmlFieldService) {
        this.pmlFieldService = pmlFieldService;
    }

    public PmlFieldPersistence getPmlFieldPersistence() {
        return pmlFieldPersistence;
    }

    public void setPmlFieldPersistence(PmlFieldPersistence pmlFieldPersistence) {
        this.pmlFieldPersistence = pmlFieldPersistence;
    }

    public PmlFieldFinder getPmlFieldFinder() {
        return pmlFieldFinder;
    }

    public void setPmlFieldFinder(PmlFieldFinder pmlFieldFinder) {
        this.pmlFieldFinder = pmlFieldFinder;
    }
}
