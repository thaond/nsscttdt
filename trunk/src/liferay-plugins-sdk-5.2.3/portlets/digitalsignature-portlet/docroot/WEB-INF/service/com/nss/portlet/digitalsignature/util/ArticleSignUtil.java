/**
 *
 */

package com.nss.portlet.digitalsignature.util;

import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.List;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.Base64;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.nss.portlet.digitalsignature.model.Certificate;
import com.nss.portlet.digitalsignature.model.Signature;
import com.nss.portlet.digitalsignature.service.ArticleDigestLocalServiceUtil;
import com.nss.portlet.digitalsignature.service.CertificateLocalServiceUtil;
import com.nss.portlet.digitalsignature.service.DigitalSignatureLocalServiceUtil;
import com.nss.portlet.digitalsignature.service.SignatureLocalServiceUtil;

/**
 * @author canhminh
 */
public class ArticleSignUtil {

	/**
	 * decode a base64 private key String to a PrivateKey object
	 * 
	 * @param base64PrivateKey
	 * @param algorithm
	 * @param provider
	 * @return
	 * @throws InvalidKeySpecException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 */
	public static PrivateKey decodePrivateKey(
		String base64PrivateKey, String algorithm, String provider)
		throws InvalidKeySpecException, NoSuchAlgorithmException,
		NoSuchProviderException {

		byte[] keyCode = Base64.decode(base64PrivateKey);

		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyCode);

		return KeyFactory.getInstance(algorithm, provider).generatePrivate(
			keySpec);
	}

	/**
	 * decode a base64 public key String to a PrivateKey object
	 * 
	 * @param base64PublicKey
	 * @param algorithm
	 * @param provider
	 * @return
	 * @throws InvalidKeySpecException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 */
	public static PublicKey decodePublicKey(
		String base64PublicKey, String algorithm, String provider)
		throws InvalidKeySpecException, NoSuchAlgorithmException,
		NoSuchProviderException {

		byte[] keyCode = Base64.decode(base64PublicKey);

		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyCode);

		return KeyFactory.getInstance(algorithm, provider).generatePublic(
			keySpec);
	}

	/**
	 * @param userId
	 * @param article
	 * @param privateKey
	 * @throws PortalException
	 * @throws SystemException
	 * @throws GeneralSecurityException
	 */
	public static void sign(
		long userId, JournalArticle article, PrivateKey privateKey)
		throws PortalException, SystemException, GeneralSecurityException {

		byte[] digist = ArticleDigestLocalServiceUtil.digest(article);
		byte[] sign = DigitalSignatureLocalServiceUtil.sign(privateKey, digist);

		SignatureLocalServiceUtil.addSignature(
			article.getGroupId(), article.getCompanyId(), userId,
			article.getId(), article.getArticleId(), Base64.encode(sign));
	}

	/**
	 * @param userId
	 * @param article
	 * @param base64PrivateKey
	 * @param algorithm
	 * @param provider
	 * @throws PortalException
	 * @throws SystemException
	 * @throws GeneralSecurityException
	 */
	public static void sign(
		long userId, JournalArticle article, String base64PrivateKey,
		String algorithm, String provider)
		throws PortalException, SystemException, GeneralSecurityException {

		sign(
			userId, article,
			decodePrivateKey(base64PrivateKey, algorithm, provider));
	}

	/**
	 * @param userId
	 * @param articlePrimKey
	 * @param privateKey
	 * @throws PortalException
	 * @throws SystemException
	 * @throws GeneralSecurityException
	 */
	public static void sign(
		long userId, long articlePrimKey, PrivateKey privateKey)
		throws PortalException, SystemException, GeneralSecurityException {

		JournalArticle article =
			JournalArticleLocalServiceUtil.getArticle(articlePrimKey);
		sign(userId, article, privateKey);
	}

	/**
	 * @param userId
	 * @param articlePrimKey
	 *            is id of article want to sign
	 * @param base64PrivateKey
	 * @param algorithm
	 * @param provider
	 * @throws PortalException
	 * @throws SystemException
	 * @throws GeneralSecurityException
	 */
	public static void sign(
		long userId, long articlePrimKey, String base64PrivateKey,
		String algorithm, String provider)
		throws PortalException, SystemException, GeneralSecurityException {

		JournalArticle article =
			JournalArticleLocalServiceUtil.getArticle(articlePrimKey);
		sign(userId, article, base64PrivateKey, algorithm, provider);
	}

	public static int veriSign(long articlePrimKey)
		throws PortalException, SystemException, GeneralSecurityException {

		try {
			List<Signature> signatures =
				SignatureLocalServiceUtil.findByArticlePrimKey(articlePrimKey);
			if (signatures.size() > 0) {
				return veriSign(signatures.get(0));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static int veriSign(long articlePrimKey, long userId)
		throws PortalException, SystemException, GeneralSecurityException {

		try {
			Signature signature =
				SignatureLocalServiceUtil.getSignature(articlePrimKey, userId);
			return veriSign(signature);
		}
		catch (Exception e) {
			return 0;
		}
	}

	/**
	 * @param articlePrimKey
	 * @param userId
	 * @return <ul> <li>0 : not sign yet</li> <li>1 : sign is correct</li> <li>2
	 *         : sign is not correct</li> </ul>
	 * @throws PortalException
	 * @throws SystemException
	 * @throws GeneralSecurityException
	 */
	public static int veriSign(Signature signature)
		throws PortalException, SystemException, GeneralSecurityException {

		if (signature == null) {
			return 0;
		}

		Certificate certificate =
			CertificateLocalServiceUtil.getCertificate(signature.getUserId());
		JournalArticle article =
			JournalArticleLocalServiceUtil.getArticle(signature.getArticlePrimKey());
		byte[] digist = ArticleDigestLocalServiceUtil.digest(article);
		byte[] sign = signature.getSignatureData();

		boolean value =
			DigitalSignatureLocalServiceUtil.verysign(
				certificate.getCertificate().getPublicKey(), digist, sign);
		if (value) {
			return 1;
		}
		else {
			return 2;
		}
	}
}
