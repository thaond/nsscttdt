
package com.nss.portlet.digitalsignature.service.impl;

import com.nss.portlet.digitalsignature.service.base.DigitalSignatureLocalServiceBaseImpl;
import com.nss.portlet.digitalsignature.util.DigitalSignatureKeys;

import java.io.InputStream;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

public class DigitalSignatureLocalServiceImpl
	extends DigitalSignatureLocalServiceBaseImpl {

	public byte[] digest(InputStream inputStream, String algorithm)
		throws Exception {

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
		return signer.verify(signature);
	}
}