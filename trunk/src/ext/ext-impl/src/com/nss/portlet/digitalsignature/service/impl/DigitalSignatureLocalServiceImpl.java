
package com.nss.portlet.digitalsignature.service.impl;

import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.security.Signature;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import com.nss.portlet.digitalsignature.DigitalSignatureKeys;
import com.nss.portlet.digitalsignature.service.base.DigitalSignatureLocalServiceBaseImpl;

public class DigitalSignatureLocalServiceImpl
	extends DigitalSignatureLocalServiceBaseImpl {

	public byte[] hash(InputStream inputStream, String algorithm)
		throws Exception {
		Security.addProvider(new BouncyCastleProvider());
		MessageDigest messageDigest =
			MessageDigest.getInstance(algorithm, "BC");

		byte[] b = new byte[1024];
		int r;

		while ((r = inputStream.read(b)) != -1) {
			messageDigest.update(b, 0, r);
		}

		return messageDigest.digest();
	}

	public byte[] sign(PrivateKey privateKey, byte[] hashValue)
		throws GeneralSecurityException {

		Signature signer =
			Signature.getInstance(
				DigitalSignatureKeys.SHA1WITHRSA,
				DigitalSignatureKeys.PROVIDER_BC);
		signer.initSign(privateKey);
		signer.update(hashValue);
		byte[] signature = signer.sign();
		return signature;
	}

	public boolean verysign(
		PublicKey publicKey, byte[] hashValue, byte[] signature)
		throws GeneralSecurityException {

		Signature signer =
			Signature.getInstance(
				DigitalSignatureKeys.SHA1WITHRSA,
				DigitalSignatureKeys.PROVIDER_BC);
		signer.initVerify(publicKey);
		signer.update(hashValue);
		return (signer.verify(signature));
	}
}
