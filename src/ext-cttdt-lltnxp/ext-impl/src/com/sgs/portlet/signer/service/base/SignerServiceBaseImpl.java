package com.sgs.portlet.signer.service.base;

import com.liferay.portal.service.base.PrincipalBean;

import com.sgs.portlet.signer.service.SignerLocalService;
import com.sgs.portlet.signer.service.SignerService;
import com.sgs.portlet.signer.service.persistence.SignerFinder;
import com.sgs.portlet.signer.service.persistence.SignerPersistence;


public abstract class SignerServiceBaseImpl extends PrincipalBean
    implements SignerService {
    @javax.annotation.Resource(name = "com.sgs.portlet.signer.service.SignerLocalService.impl")
    protected SignerLocalService signerLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.signer.service.SignerService.impl")
    protected SignerService signerService;
    @javax.annotation.Resource(name = "com.sgs.portlet.signer.service.persistence.SignerPersistence.impl")
    protected SignerPersistence signerPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.signer.service.persistence.SignerFinder.impl")
    protected SignerFinder signerFinder;

    public SignerLocalService getSignerLocalService() {
        return signerLocalService;
    }

    public void setSignerLocalService(SignerLocalService signerLocalService) {
        this.signerLocalService = signerLocalService;
    }

    public SignerService getSignerService() {
        return signerService;
    }

    public void setSignerService(SignerService signerService) {
        this.signerService = signerService;
    }

    public SignerPersistence getSignerPersistence() {
        return signerPersistence;
    }

    public void setSignerPersistence(SignerPersistence signerPersistence) {
        this.signerPersistence = signerPersistence;
    }

    public SignerFinder getSignerFinder() {
        return signerFinder;
    }

    public void setSignerFinder(SignerFinder signerFinder) {
        this.signerFinder = signerFinder;
    }
}
