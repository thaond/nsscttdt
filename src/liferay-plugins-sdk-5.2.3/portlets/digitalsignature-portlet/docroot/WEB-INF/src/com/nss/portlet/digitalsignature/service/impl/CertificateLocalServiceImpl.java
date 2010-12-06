
package com.nss.portlet.digitalsignature.service.impl;

import java.math.BigInteger;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Date;

import javax.security.auth.x500.X500Principal;

import org.bouncycastle.asn1.x509.BasicConstraints;
import org.bouncycastle.asn1.x509.ExtendedKeyUsage;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.GeneralNames;
import org.bouncycastle.asn1.x509.KeyPurposeId;
import org.bouncycastle.asn1.x509.KeyUsage;
import org.bouncycastle.asn1.x509.X509Extensions;
import org.bouncycastle.x509.X509V3CertificateGenerator;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.Base64;
import com.nss.portlet.digitalsignature.model.Certificate;
import com.nss.portlet.digitalsignature.model.impl.CertificateImpl;
import com.nss.portlet.digitalsignature.service.base.CertificateLocalServiceBaseImpl;

public class CertificateLocalServiceImpl
	extends CertificateLocalServiceBaseImpl {

	private static final long VALIDITY_PERIOD = 27 * 365 * 24 * 60 * 60 * 1000l;

	public X509Certificate createCertificate(
		String algorithmId, PrivateKey privateKey, PublicKey publicKey,
		String issuerDN, String subjectDN, Date notBeforeDate,
		Date notAfterDate, String email)
		throws PortalException {

		if (notBeforeDate == null) {
			notBeforeDate = new Date(System.currentTimeMillis());
		}
		if (notAfterDate == null) {
			notAfterDate =
				new Date(System.currentTimeMillis() + VALIDITY_PERIOD);
		}

		try {
			X509V3CertificateGenerator certGen =
				new X509V3CertificateGenerator();

			certGen.setSerialNumber(BigInteger.valueOf(System.currentTimeMillis()));
			certGen.setIssuerDN(new X500Principal(issuerDN));
			certGen.setNotBefore(notBeforeDate);
			certGen.setNotAfter(notAfterDate);
			certGen.setSubjectDN(new X500Principal(subjectDN));
			certGen.setPublicKey(publicKey);
			certGen.setSignatureAlgorithm(algorithmId);

			certGen.addExtension(
				X509Extensions.BasicConstraints, true, new BasicConstraints(
					false));
			certGen.addExtension(X509Extensions.KeyUsage, true, new KeyUsage(
				KeyUsage.digitalSignature | KeyUsage.keyEncipherment));
			certGen.addExtension(
				X509Extensions.ExtendedKeyUsage, true, new ExtendedKeyUsage(
					KeyPurposeId.id_kp_serverAuth));

			certGen.addExtension(
				X509Extensions.SubjectAlternativeName, false, new GeneralNames(
					new GeneralName(GeneralName.rfc822Name, email)));

			return certGen.generate(privateKey);
		}
		catch (Exception e) {
			throw new PortalException(e);
		}
	}

	public Certificate updateCertificate(
		long userId, String algorithmId, PrivateKey privateKey,
		PublicKey publicKey, String issuerDN, String subjectDN,
		Date notBeforeDate, Date notAfterDate, String email)
		throws PortalException, CertificateException, SystemException {

		X509Certificate x509Certificate =
			createCertificate(
				algorithmId, privateKey, publicKey, issuerDN, subjectDN,
				notBeforeDate, notAfterDate, email);
		return updateCertificate(userId, x509Certificate);
	}

	public Certificate updateCertificate(
		long userId, X509Certificate x509Certificate)
		throws CertificateException, SystemException {

		Certificate certificate = new CertificateImpl();
		certificate.setUserId(userId);
		certificate.setX509Certificate(Base64.encode(x509Certificate.getEncoded()));

		return certificatePersistence.update(certificate, true);
	}

}
