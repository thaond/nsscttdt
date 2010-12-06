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

import com.liferay.portal.kernel.util.BooleanWrapper;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.LongWrapper;
import com.liferay.portal.kernel.util.NullWrapper;

/**
 * <a href="CertificateLocalServiceClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author canhminh
 *
 */
public class CertificateLocalServiceClp implements CertificateLocalService {
	public CertificateLocalServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;
	}

	public com.nss.portlet.digitalsignature.model.Certificate addCertificate(
		com.nss.portlet.digitalsignature.model.Certificate certificate)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(certificate);

		if (certificate == null) {
			paramObj0 = new NullWrapper(
					"com.nss.portlet.digitalsignature.model.Certificate");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("addCertificate",
					new Object[] { paramObj0 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.nss.portlet.digitalsignature.model.Certificate)ClpSerializer.translateOutput(returnObj);
	}

	public com.nss.portlet.digitalsignature.model.Certificate createCertificate(
		long userId) {
		Object paramObj0 = new LongWrapper(userId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("createCertificate",
					new Object[] { paramObj0 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.nss.portlet.digitalsignature.model.Certificate)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteCertificate(long userId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = new LongWrapper(userId);

		try {
			_classLoaderProxy.invoke("deleteCertificate",
				new Object[] { paramObj0 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.PortalException) {
				throw (com.liferay.portal.PortalException)t;
			}

			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void deleteCertificate(
		com.nss.portlet.digitalsignature.model.Certificate certificate)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(certificate);

		if (certificate == null) {
			paramObj0 = new NullWrapper(
					"com.nss.portlet.digitalsignature.model.Certificate");
		}

		try {
			_classLoaderProxy.invoke("deleteCertificate",
				new Object[] { paramObj0 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(dynamicQuery);

		if (dynamicQuery == null) {
			paramObj0 = new NullWrapper(
					"com.liferay.portal.kernel.dao.orm.DynamicQuery");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("dynamicQuery",
					new Object[] { paramObj0 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<Object>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(dynamicQuery);

		if (dynamicQuery == null) {
			paramObj0 = new NullWrapper(
					"com.liferay.portal.kernel.dao.orm.DynamicQuery");
		}

		Object paramObj1 = new IntegerWrapper(start);

		Object paramObj2 = new IntegerWrapper(end);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("dynamicQuery",
					new Object[] { paramObj0, paramObj1, paramObj2 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<Object>)ClpSerializer.translateOutput(returnObj);
	}

	public com.nss.portlet.digitalsignature.model.Certificate getCertificate(
		long userId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = new LongWrapper(userId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getCertificate",
					new Object[] { paramObj0 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.PortalException) {
				throw (com.liferay.portal.PortalException)t;
			}

			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.nss.portlet.digitalsignature.model.Certificate)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.nss.portlet.digitalsignature.model.Certificate> getCertificates(
		int start, int end) throws com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(start);

		Object paramObj1 = new IntegerWrapper(end);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getCertificates",
					new Object[] { paramObj0, paramObj1 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.nss.portlet.digitalsignature.model.Certificate>)ClpSerializer.translateOutput(returnObj);
	}

	public int getCertificatesCount() throws com.liferay.portal.SystemException {
		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getCertificatesCount",
					new Object[0]);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public com.nss.portlet.digitalsignature.model.Certificate updateCertificate(
		com.nss.portlet.digitalsignature.model.Certificate certificate)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(certificate);

		if (certificate == null) {
			paramObj0 = new NullWrapper(
					"com.nss.portlet.digitalsignature.model.Certificate");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("updateCertificate",
					new Object[] { paramObj0 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.nss.portlet.digitalsignature.model.Certificate)ClpSerializer.translateOutput(returnObj);
	}

	public com.nss.portlet.digitalsignature.model.Certificate updateCertificate(
		com.nss.portlet.digitalsignature.model.Certificate certificate,
		boolean merge) throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(certificate);

		if (certificate == null) {
			paramObj0 = new NullWrapper(
					"com.nss.portlet.digitalsignature.model.Certificate");
		}

		Object paramObj1 = new BooleanWrapper(merge);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("updateCertificate",
					new Object[] { paramObj0, paramObj1 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.nss.portlet.digitalsignature.model.Certificate)ClpSerializer.translateOutput(returnObj);
	}

	public java.security.cert.X509Certificate createCertificate(
		java.lang.String algorithmId, java.security.PrivateKey privateKey,
		java.security.PublicKey publicKey, java.lang.String issuerDN,
		java.lang.String subjectDN, java.util.Date notBeforeDate,
		java.util.Date notAfterDate, java.lang.String email)
		throws com.liferay.portal.PortalException {
		Object paramObj0 = ClpSerializer.translateInput(algorithmId);

		if (algorithmId == null) {
			paramObj0 = new NullWrapper("java.lang.String");
		}

		Object paramObj1 = ClpSerializer.translateInput(privateKey);

		if (privateKey == null) {
			paramObj1 = new NullWrapper("java.security.PrivateKey");
		}

		Object paramObj2 = ClpSerializer.translateInput(publicKey);

		if (publicKey == null) {
			paramObj2 = new NullWrapper("java.security.PublicKey");
		}

		Object paramObj3 = ClpSerializer.translateInput(issuerDN);

		if (issuerDN == null) {
			paramObj3 = new NullWrapper("java.lang.String");
		}

		Object paramObj4 = ClpSerializer.translateInput(subjectDN);

		if (subjectDN == null) {
			paramObj4 = new NullWrapper("java.lang.String");
		}

		Object paramObj5 = ClpSerializer.translateInput(notBeforeDate);

		if (notBeforeDate == null) {
			paramObj5 = new NullWrapper("java.util.Date");
		}

		Object paramObj6 = ClpSerializer.translateInput(notAfterDate);

		if (notAfterDate == null) {
			paramObj6 = new NullWrapper("java.util.Date");
		}

		Object paramObj7 = ClpSerializer.translateInput(email);

		if (email == null) {
			paramObj7 = new NullWrapper("java.lang.String");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("createCertificate",
					new Object[] {
						paramObj0, paramObj1, paramObj2, paramObj3, paramObj4,
						paramObj5, paramObj6, paramObj7
					});
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.PortalException) {
				throw (com.liferay.portal.PortalException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.security.cert.X509Certificate)ClpSerializer.translateOutput(returnObj);
	}

	public com.nss.portlet.digitalsignature.model.Certificate updateCertificate(
		long userId, java.lang.String algorithmId,
		java.security.PrivateKey privateKey, java.security.PublicKey publicKey,
		java.lang.String issuerDN, java.lang.String subjectDN,
		java.util.Date notBeforeDate, java.util.Date notAfterDate,
		java.lang.String email)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException,
			java.security.cert.CertificateException {
		Object paramObj0 = new LongWrapper(userId);

		Object paramObj1 = ClpSerializer.translateInput(algorithmId);

		if (algorithmId == null) {
			paramObj1 = new NullWrapper("java.lang.String");
		}

		Object paramObj2 = ClpSerializer.translateInput(privateKey);

		if (privateKey == null) {
			paramObj2 = new NullWrapper("java.security.PrivateKey");
		}

		Object paramObj3 = ClpSerializer.translateInput(publicKey);

		if (publicKey == null) {
			paramObj3 = new NullWrapper("java.security.PublicKey");
		}

		Object paramObj4 = ClpSerializer.translateInput(issuerDN);

		if (issuerDN == null) {
			paramObj4 = new NullWrapper("java.lang.String");
		}

		Object paramObj5 = ClpSerializer.translateInput(subjectDN);

		if (subjectDN == null) {
			paramObj5 = new NullWrapper("java.lang.String");
		}

		Object paramObj6 = ClpSerializer.translateInput(notBeforeDate);

		if (notBeforeDate == null) {
			paramObj6 = new NullWrapper("java.util.Date");
		}

		Object paramObj7 = ClpSerializer.translateInput(notAfterDate);

		if (notAfterDate == null) {
			paramObj7 = new NullWrapper("java.util.Date");
		}

		Object paramObj8 = ClpSerializer.translateInput(email);

		if (email == null) {
			paramObj8 = new NullWrapper("java.lang.String");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("updateCertificate",
					new Object[] {
						paramObj0, paramObj1, paramObj2, paramObj3, paramObj4,
						paramObj5, paramObj6, paramObj7, paramObj8
					});
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.PortalException) {
				throw (com.liferay.portal.PortalException)t;
			}

			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof java.security.cert.CertificateException) {
				throw (java.security.cert.CertificateException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.nss.portlet.digitalsignature.model.Certificate)ClpSerializer.translateOutput(returnObj);
	}

	public com.nss.portlet.digitalsignature.model.Certificate updateCertificate(
		long userId, java.security.cert.X509Certificate x509Certificate)
		throws com.liferay.portal.SystemException,
			java.security.cert.CertificateException {
		Object paramObj0 = new LongWrapper(userId);

		Object paramObj1 = ClpSerializer.translateInput(x509Certificate);

		if (x509Certificate == null) {
			paramObj1 = new NullWrapper("java.security.cert.X509Certificate");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("updateCertificate",
					new Object[] { paramObj0, paramObj1 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof java.security.cert.CertificateException) {
				throw (java.security.cert.CertificateException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.nss.portlet.digitalsignature.model.Certificate)ClpSerializer.translateOutput(returnObj);
	}

	private ClassLoaderProxy _classLoaderProxy;
}