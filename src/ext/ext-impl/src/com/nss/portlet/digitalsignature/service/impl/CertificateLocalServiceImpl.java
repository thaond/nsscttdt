
package com.nss.portlet.digitalsignature.service.impl;

import java.math.BigInteger;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
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
import com.nss.portlet.digitalsignature.service.base.CertificateLocalServiceBaseImpl;

public class CertificateLocalServiceImpl
	extends CertificateLocalServiceBaseImpl {

	public X509Certificate addCertificate(
		String algorithmId, PrivateKey privateKey, PublicKey publicKey,
		String issuerDN, String subjectDN)
		throws PortalException {

		try {
			Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

			X509V3CertificateGenerator certGen =
				new X509V3CertificateGenerator();

			certGen.setSerialNumber(BigInteger.valueOf(System.currentTimeMillis()));
			certGen.setIssuerDN(new X500Principal(issuerDN));
			certGen.setNotBefore(new Date(System.currentTimeMillis() - 10000));
			certGen.setNotAfter(new Date(System.currentTimeMillis() + 10000));
			certGen.setSubjectDN(new X500Principal(subjectDN));
			certGen.setPublicKey(publicKey);
			certGen.setSignatureAlgorithm("SHA256WithRSAEncryption");

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
					new GeneralName(GeneralName.rfc822Name, "test@test.test")));

			return certGen.generate(privateKey);
		}
		catch (Exception e) {
			throw new PortalException(e);
		}
	}
}
