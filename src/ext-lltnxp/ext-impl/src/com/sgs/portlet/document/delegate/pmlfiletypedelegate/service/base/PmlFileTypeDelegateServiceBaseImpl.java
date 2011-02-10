package com.sgs.portlet.document.delegate.pmlfiletypedelegate.service.base;

import com.liferay.portal.service.base.PrincipalBean;

import com.sgs.portlet.document.delegate.pmlfiletypedelegate.service.PmlFileTypeDelegateLocalService;
import com.sgs.portlet.document.delegate.pmlfiletypedelegate.service.PmlFileTypeDelegateService;
import com.sgs.portlet.document.delegate.pmlfiletypedelegate.service.persistence.PmlFileTypeDelegatePersistence;


public abstract class PmlFileTypeDelegateServiceBaseImpl extends PrincipalBean
    implements PmlFileTypeDelegateService {
    @javax.annotation.Resource(name = "com.sgs.portlet.document.delegate.pmlfiletypedelegate.service.PmlFileTypeDelegateLocalService.impl")
    protected PmlFileTypeDelegateLocalService pmlFileTypeDelegateLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.delegate.pmlfiletypedelegate.service.PmlFileTypeDelegateService.impl")
    protected PmlFileTypeDelegateService pmlFileTypeDelegateService;
    @javax.annotation.Resource(name = "com.sgs.portlet.document.delegate.pmlfiletypedelegate.service.persistence.PmlFileTypeDelegatePersistence.impl")
    protected PmlFileTypeDelegatePersistence pmlFileTypeDelegatePersistence;

    public PmlFileTypeDelegateLocalService getPmlFileTypeDelegateLocalService() {
        return pmlFileTypeDelegateLocalService;
    }

    public void setPmlFileTypeDelegateLocalService(
        PmlFileTypeDelegateLocalService pmlFileTypeDelegateLocalService) {
        this.pmlFileTypeDelegateLocalService = pmlFileTypeDelegateLocalService;
    }

    public PmlFileTypeDelegateService getPmlFileTypeDelegateService() {
        return pmlFileTypeDelegateService;
    }

    public void setPmlFileTypeDelegateService(
        PmlFileTypeDelegateService pmlFileTypeDelegateService) {
        this.pmlFileTypeDelegateService = pmlFileTypeDelegateService;
    }

    public PmlFileTypeDelegatePersistence getPmlFileTypeDelegatePersistence() {
        return pmlFileTypeDelegatePersistence;
    }

    public void setPmlFileTypeDelegatePersistence(
        PmlFileTypeDelegatePersistence pmlFileTypeDelegatePersistence) {
        this.pmlFileTypeDelegatePersistence = pmlFileTypeDelegatePersistence;
    }
}
