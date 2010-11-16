package com.nss.portlet.digitalsignature.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.digitalsignature.model.Signature;
import com.nss.portlet.digitalsignature.service.CertificateLocalService;
import com.nss.portlet.digitalsignature.service.CertificateService;
import com.nss.portlet.digitalsignature.service.DigitalSignatureLocalService;
import com.nss.portlet.digitalsignature.service.DigitalSignatureService;
import com.nss.portlet.digitalsignature.service.SignatureLocalService;
import com.nss.portlet.digitalsignature.service.SignatureService;
import com.nss.portlet.digitalsignature.service.persistence.CertificatePersistence;
import com.nss.portlet.digitalsignature.service.persistence.SignaturePersistence;

import java.util.List;


public abstract class SignatureLocalServiceBaseImpl
    implements SignatureLocalService {
    @BeanReference(name = "com.nss.portlet.digitalsignature.service.DigitalSignatureLocalService.impl")
    protected DigitalSignatureLocalService digitalSignatureLocalService;
    @BeanReference(name = "com.nss.portlet.digitalsignature.service.DigitalSignatureService.impl")
    protected DigitalSignatureService digitalSignatureService;
    @BeanReference(name = "com.nss.portlet.digitalsignature.service.SignatureLocalService.impl")
    protected SignatureLocalService signatureLocalService;
    @BeanReference(name = "com.nss.portlet.digitalsignature.service.SignatureService.impl")
    protected SignatureService signatureService;
    @BeanReference(name = "com.nss.portlet.digitalsignature.service.persistence.SignaturePersistence.impl")
    protected SignaturePersistence signaturePersistence;
    @BeanReference(name = "com.nss.portlet.digitalsignature.service.CertificateLocalService.impl")
    protected CertificateLocalService certificateLocalService;
    @BeanReference(name = "com.nss.portlet.digitalsignature.service.CertificateService.impl")
    protected CertificateService certificateService;
    @BeanReference(name = "com.nss.portlet.digitalsignature.service.persistence.CertificatePersistence.impl")
    protected CertificatePersistence certificatePersistence;

    public Signature addSignature(Signature signature)
        throws SystemException {
        signature.setNew(true);

        return signaturePersistence.update(signature, false);
    }

    public Signature createSignature(long signatureId) {
        return signaturePersistence.create(signatureId);
    }

    public void deleteSignature(long signatureId)
        throws PortalException, SystemException {
        signaturePersistence.remove(signatureId);
    }

    public void deleteSignature(Signature signature) throws SystemException {
        signaturePersistence.remove(signature);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return signaturePersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return signaturePersistence.findWithDynamicQuery(dynamicQuery, start,
            end);
    }

    public Signature getSignature(long signatureId)
        throws PortalException, SystemException {
        return signaturePersistence.findByPrimaryKey(signatureId);
    }

    public List<Signature> getSignatures(int start, int end)
        throws SystemException {
        return signaturePersistence.findAll(start, end);
    }

    public int getSignaturesCount() throws SystemException {
        return signaturePersistence.countAll();
    }

    public Signature updateSignature(Signature signature)
        throws SystemException {
        signature.setNew(false);

        return signaturePersistence.update(signature, true);
    }

    public Signature updateSignature(Signature signature, boolean merge)
        throws SystemException {
        signature.setNew(false);

        return signaturePersistence.update(signature, merge);
    }

    public DigitalSignatureLocalService getDigitalSignatureLocalService() {
        return digitalSignatureLocalService;
    }

    public void setDigitalSignatureLocalService(
        DigitalSignatureLocalService digitalSignatureLocalService) {
        this.digitalSignatureLocalService = digitalSignatureLocalService;
    }

    public DigitalSignatureService getDigitalSignatureService() {
        return digitalSignatureService;
    }

    public void setDigitalSignatureService(
        DigitalSignatureService digitalSignatureService) {
        this.digitalSignatureService = digitalSignatureService;
    }

    public SignatureLocalService getSignatureLocalService() {
        return signatureLocalService;
    }

    public void setSignatureLocalService(
        SignatureLocalService signatureLocalService) {
        this.signatureLocalService = signatureLocalService;
    }

    public SignatureService getSignatureService() {
        return signatureService;
    }

    public void setSignatureService(SignatureService signatureService) {
        this.signatureService = signatureService;
    }

    public SignaturePersistence getSignaturePersistence() {
        return signaturePersistence;
    }

    public void setSignaturePersistence(
        SignaturePersistence signaturePersistence) {
        this.signaturePersistence = signaturePersistence;
    }

    public CertificateLocalService getCertificateLocalService() {
        return certificateLocalService;
    }

    public void setCertificateLocalService(
        CertificateLocalService certificateLocalService) {
        this.certificateLocalService = certificateLocalService;
    }

    public CertificateService getCertificateService() {
        return certificateService;
    }

    public void setCertificateService(CertificateService certificateService) {
        this.certificateService = certificateService;
    }

    public CertificatePersistence getCertificatePersistence() {
        return certificatePersistence;
    }

    public void setCertificatePersistence(
        CertificatePersistence certificatePersistence) {
        this.certificatePersistence = certificatePersistence;
    }

    protected void runSQL(String sql) throws SystemException {
        try {
            PortalUtil.runSQL(sql);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
