/**
 * Copyright (c) 2000-2009 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.nss.portlet.digitalsignature.service.base;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.digitalsignature.service.ArticleDigestLocalService;
import com.nss.portlet.digitalsignature.service.ArticleDigestService;
import com.nss.portlet.digitalsignature.service.CertificateLocalService;
import com.nss.portlet.digitalsignature.service.CertificateService;
import com.nss.portlet.digitalsignature.service.DigitalSignatureLocalService;
import com.nss.portlet.digitalsignature.service.DigitalSignatureService;
import com.nss.portlet.digitalsignature.service.SignatureLocalService;
import com.nss.portlet.digitalsignature.service.SignatureService;
import com.nss.portlet.digitalsignature.service.persistence.CertificatePersistence;
import com.nss.portlet.digitalsignature.service.persistence.SignaturePersistence;

/**
 * <a href="DigitalSignatureServiceBaseImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author canhminh
 *
 */
public abstract class DigitalSignatureServiceBaseImpl extends PrincipalBean
	implements DigitalSignatureService {
	public ArticleDigestLocalService getArticleDigestLocalService() {
		return articleDigestLocalService;
	}

	public void setArticleDigestLocalService(
		ArticleDigestLocalService articleDigestLocalService) {
		this.articleDigestLocalService = articleDigestLocalService;
	}

	public ArticleDigestService getArticleDigestService() {
		return articleDigestService;
	}

	public void setArticleDigestService(
		ArticleDigestService articleDigestService) {
		this.articleDigestService = articleDigestService;
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
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(name = "com.nss.portlet.digitalsignature.service.ArticleDigestLocalService.impl")
	protected ArticleDigestLocalService articleDigestLocalService;
	@BeanReference(name = "com.nss.portlet.digitalsignature.service.ArticleDigestService.impl")
	protected ArticleDigestService articleDigestService;
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
}