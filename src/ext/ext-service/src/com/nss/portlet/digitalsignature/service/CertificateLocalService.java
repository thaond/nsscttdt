package com.nss.portlet.digitalsignature.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="CertificateLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.nss.portlet.digitalsignature.service.impl.CertificateLocalServiceImpl</code>.
 * Modify methods in that class and rerun ServiceBuilder to populate this class
 * and all other generated classes.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.digitalsignature.service.CertificateLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface CertificateLocalService {
    public com.nss.portlet.digitalsignature.model.Certificate addCertificate(
        com.nss.portlet.digitalsignature.model.Certificate certificate)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.digitalsignature.model.Certificate createCertificate(
        long userId);

    public void deleteCertificate(long userId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteCertificate(
        com.nss.portlet.digitalsignature.model.Certificate certificate)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.digitalsignature.model.Certificate getCertificate(
        long userId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.digitalsignature.model.Certificate> getCertificates(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getCertificatesCount() throws com.liferay.portal.SystemException;

    public com.nss.portlet.digitalsignature.model.Certificate updateCertificate(
        com.nss.portlet.digitalsignature.model.Certificate certificate)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.digitalsignature.model.Certificate updateCertificate(
        com.nss.portlet.digitalsignature.model.Certificate certificate,
        boolean merge) throws com.liferay.portal.SystemException;

    public java.security.cert.X509Certificate addCertificate(
        java.lang.String algorithmId, java.security.PrivateKey privateKey,
        java.security.PublicKey publicKey, java.lang.String issuerDN,
        java.lang.String subjectDN) throws com.liferay.portal.PortalException;
}
