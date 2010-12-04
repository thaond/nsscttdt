package com.nss.portlet.documentfield.service.base;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.documentfield.service.PmlFieldLocalService;
import com.nss.portlet.documentfield.service.PmlFieldService;
import com.nss.portlet.documentfield.service.persistence.PmlFieldFinder;
import com.nss.portlet.documentfield.service.persistence.PmlFieldPersistence;


public abstract class PmlFieldServiceBaseImpl extends PrincipalBean
    implements PmlFieldService {
    @BeanReference(name = "com.nss.portlet.documentfield.service.PmlFieldLocalService.impl")
    protected PmlFieldLocalService pmlFieldLocalService;
    @BeanReference(name = "com.nss.portlet.documentfield.service.PmlFieldService.impl")
    protected PmlFieldService pmlFieldService;
    @BeanReference(name = "com.nss.portlet.documentfield.service.persistence.PmlFieldPersistence.impl")
    protected PmlFieldPersistence pmlFieldPersistence;
    @BeanReference(name = "com.nss.portlet.documentfield.service.persistence.PmlFieldFinder.impl")
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

    protected void runSQL(String sql) throws SystemException {
        try {
            PortalUtil.runSQL(sql);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
