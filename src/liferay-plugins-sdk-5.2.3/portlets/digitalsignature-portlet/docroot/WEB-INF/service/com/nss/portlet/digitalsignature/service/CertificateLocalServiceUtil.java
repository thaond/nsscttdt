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

package com.nss.portlet.digitalsignature.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;

/**
 * <a href="CertificateLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author canhminh
 *
 */
public class CertificateLocalServiceUtil {
	public static com.nss.portlet.digitalsignature.model.Certificate addCertificate(
		com.nss.portlet.digitalsignature.model.Certificate certificate)
		throws com.liferay.portal.SystemException {
		return getService().addCertificate(certificate);
	}

	public static com.nss.portlet.digitalsignature.model.Certificate createCertificate(
		long userId) {
		return getService().createCertificate(userId);
	}

	public static void deleteCertificate(long userId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteCertificate(userId);
	}

	public static void deleteCertificate(
		com.nss.portlet.digitalsignature.model.Certificate certificate)
		throws com.liferay.portal.SystemException {
		getService().deleteCertificate(certificate);
	}

	public static java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	public static java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	public static com.nss.portlet.digitalsignature.model.Certificate getCertificate(
		long userId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getCertificate(userId);
	}

	public static java.util.List<com.nss.portlet.digitalsignature.model.Certificate> getCertificates(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getCertificates(start, end);
	}

	public static int getCertificatesCount()
		throws com.liferay.portal.SystemException {
		return getService().getCertificatesCount();
	}

	public static com.nss.portlet.digitalsignature.model.Certificate updateCertificate(
		com.nss.portlet.digitalsignature.model.Certificate certificate)
		throws com.liferay.portal.SystemException {
		return getService().updateCertificate(certificate);
	}

	public static com.nss.portlet.digitalsignature.model.Certificate updateCertificate(
		com.nss.portlet.digitalsignature.model.Certificate certificate,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService().updateCertificate(certificate, merge);
	}

	public static java.security.cert.X509Certificate createCertificate(
		java.lang.String algorithmId, java.security.PrivateKey privateKey,
		java.security.PublicKey publicKey, java.lang.String issuerDN,
		java.lang.String subjectDN, java.util.Date notBeforeDate,
		java.util.Date notAfterDate, java.lang.String email)
		throws com.liferay.portal.PortalException {
		return getService()
				   .createCertificate(algorithmId, privateKey, publicKey,
			issuerDN, subjectDN, notBeforeDate, notAfterDate, email);
	}

	public static com.nss.portlet.digitalsignature.model.Certificate updateCertificate(
		long userId, java.lang.String algorithmId,
		java.security.PrivateKey privateKey, java.security.PublicKey publicKey,
		java.lang.String issuerDN, java.lang.String subjectDN,
		java.util.Date notBeforeDate, java.util.Date notAfterDate,
		java.lang.String email)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException,
			java.security.cert.CertificateException {
		return getService()
				   .updateCertificate(userId, algorithmId, privateKey,
			publicKey, issuerDN, subjectDN, notBeforeDate, notAfterDate, email);
	}

	public static com.nss.portlet.digitalsignature.model.Certificate updateCertificate(
		long userId, java.security.cert.X509Certificate x509Certificate)
		throws com.liferay.portal.SystemException,
			java.security.cert.CertificateException {
		return getService().updateCertificate(userId, x509Certificate);
	}

	public static void clearService() {
		_service = null;
	}

	public static CertificateLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					CertificateLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new CertificateLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(CertificateLocalService service) {
		_service = service;
	}

	private static CertificateLocalService _service;
}