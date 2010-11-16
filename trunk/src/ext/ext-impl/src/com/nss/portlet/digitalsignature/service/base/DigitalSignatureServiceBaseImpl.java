package com.nss.portlet.digitalsignature.service.base;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.digitalsignature.service.CertificateLocalService;
import com.nss.portlet.digitalsignature.service.CertificateService;
import com.nss.portlet.digitalsignature.service.DigitalSignatureLocalService;
import com.nss.portlet.digitalsignature.service.DigitalSignatureService;
import com.nss.portlet.digitalsignature.service.SignatureLocalService;
import com.nss.portlet.digitalsignature.service.SignatureService;
import com.nss.portlet.digitalsignature.service.persistence.CertificatePersistence;
import com.nss.portlet.digitalsignature.service.persistence.SignaturePersistence;


public abstract class DigitalSignatureServiceBaseImpl extends PrincipalBean
    implements DigitalSignatureService {
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
