package com.sgs.portlet.signer.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;

import com.sgs.portlet.signer.model.Signer;
import com.sgs.portlet.signer.service.SignerLocalService;
import com.sgs.portlet.signer.service.SignerService;
import com.sgs.portlet.signer.service.persistence.SignerFinder;
import com.sgs.portlet.signer.service.persistence.SignerPersistence;

import java.util.List;


public abstract class SignerLocalServiceBaseImpl implements SignerLocalService {
    @javax.annotation.Resource(name = "com.sgs.portlet.signer.service.SignerLocalService.impl")
    protected SignerLocalService signerLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.signer.service.SignerService.impl")
    protected SignerService signerService;
    @javax.annotation.Resource(name = "com.sgs.portlet.signer.service.persistence.SignerPersistence.impl")
    protected SignerPersistence signerPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.signer.service.persistence.SignerFinder.impl")
    protected SignerFinder signerFinder;

    public Signer addSigner(Signer signer) throws SystemException {
        signer.setNew(true);

        return signerPersistence.update(signer, false);
    }

    public Signer createSigner(long signerId) {
        return signerPersistence.create(signerId);
    }

    public void deleteSigner(long signerId)
        throws PortalException, SystemException {
        signerPersistence.remove(signerId);
    }

    public void deleteSigner(Signer signer) throws SystemException {
        signerPersistence.remove(signer);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return signerPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return signerPersistence.findWithDynamicQuery(dynamicQuery, start, end);
    }

    public Signer getSigner(long signerId)
        throws PortalException, SystemException {
        return signerPersistence.findByPrimaryKey(signerId);
    }

    public List<Signer> getSigners(int start, int end)
        throws SystemException {
        return signerPersistence.findAll(start, end);
    }

    public int getSignersCount() throws SystemException {
        return signerPersistence.countAll();
    }

    public Signer updateSigner(Signer signer) throws SystemException {
        signer.setNew(false);

        return signerPersistence.update(signer, true);
    }

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
