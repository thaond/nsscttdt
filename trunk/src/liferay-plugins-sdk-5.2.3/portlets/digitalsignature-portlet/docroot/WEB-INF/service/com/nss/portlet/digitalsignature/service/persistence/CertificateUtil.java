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

package com.nss.portlet.digitalsignature.service.persistence;

/**
 * <a href="CertificateUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author canhminh
 *
 */
public class CertificateUtil {
	public static void cacheResult(
		com.nss.portlet.digitalsignature.model.Certificate certificate) {
		getPersistence().cacheResult(certificate);
	}

	public static void cacheResult(
		java.util.List<com.nss.portlet.digitalsignature.model.Certificate> certificates) {
		getPersistence().cacheResult(certificates);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static com.nss.portlet.digitalsignature.model.Certificate create(
		long userId) {
		return getPersistence().create(userId);
	}

	public static com.nss.portlet.digitalsignature.model.Certificate remove(
		long userId)
		throws com.liferay.portal.SystemException,
			com.nss.portlet.digitalsignature.NoSuchCertificateException {
		return getPersistence().remove(userId);
	}

	public static com.nss.portlet.digitalsignature.model.Certificate remove(
		com.nss.portlet.digitalsignature.model.Certificate certificate)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(certificate);
	}

	public static com.nss.portlet.digitalsignature.model.Certificate update(
		com.nss.portlet.digitalsignature.model.Certificate certificate)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(certificate);
	}

	public static com.nss.portlet.digitalsignature.model.Certificate update(
		com.nss.portlet.digitalsignature.model.Certificate certificate,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(certificate, merge);
	}

	public static com.nss.portlet.digitalsignature.model.Certificate updateImpl(
		com.nss.portlet.digitalsignature.model.Certificate certificate,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(certificate, merge);
	}

	public static com.nss.portlet.digitalsignature.model.Certificate findByPrimaryKey(
		long userId)
		throws com.liferay.portal.SystemException,
			com.nss.portlet.digitalsignature.NoSuchCertificateException {
		return getPersistence().findByPrimaryKey(userId);
	}

	public static com.nss.portlet.digitalsignature.model.Certificate fetchByPrimaryKey(
		long userId) throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(userId);
	}

	public static java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	public static java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	public static java.util.List<com.nss.portlet.digitalsignature.model.Certificate> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<com.nss.portlet.digitalsignature.model.Certificate> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<com.nss.portlet.digitalsignature.model.Certificate> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static CertificatePersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(CertificatePersistence persistence) {
		_persistence = persistence;
	}

	private static CertificatePersistence _persistence;
}