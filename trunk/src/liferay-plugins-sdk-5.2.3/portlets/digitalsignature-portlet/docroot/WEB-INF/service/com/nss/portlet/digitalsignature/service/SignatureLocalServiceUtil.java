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
 * <a href="SignatureLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author canhminh
 *
 */
public class SignatureLocalServiceUtil {
	public static com.nss.portlet.digitalsignature.model.Signature addSignature(
		com.nss.portlet.digitalsignature.model.Signature signature)
		throws com.liferay.portal.SystemException {
		return getService().addSignature(signature);
	}

	public static com.nss.portlet.digitalsignature.model.Signature createSignature(
		long signatureId) {
		return getService().createSignature(signatureId);
	}

	public static void deleteSignature(long signatureId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteSignature(signatureId);
	}

	public static void deleteSignature(
		com.nss.portlet.digitalsignature.model.Signature signature)
		throws com.liferay.portal.SystemException {
		getService().deleteSignature(signature);
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

	public static com.nss.portlet.digitalsignature.model.Signature getSignature(
		long signatureId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getSignature(signatureId);
	}

	public static java.util.List<com.nss.portlet.digitalsignature.model.Signature> getSignatures(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getSignatures(start, end);
	}

	public static int getSignaturesCount()
		throws com.liferay.portal.SystemException {
		return getService().getSignaturesCount();
	}

	public static com.nss.portlet.digitalsignature.model.Signature updateSignature(
		com.nss.portlet.digitalsignature.model.Signature signature)
		throws com.liferay.portal.SystemException {
		return getService().updateSignature(signature);
	}

	public static com.nss.portlet.digitalsignature.model.Signature updateSignature(
		com.nss.portlet.digitalsignature.model.Signature signature,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService().updateSignature(signature, merge);
	}

	public static com.nss.portlet.digitalsignature.model.Signature addSignature(
		long groupId, long companyId, long userId, long articlePrimKey,
		java.lang.String articleId, java.lang.String signData)
		throws com.liferay.portal.SystemException {
		return getService()
				   .addSignature(groupId, companyId, userId, articlePrimKey,
			articleId, signData);
	}

	public static java.util.List<com.nss.portlet.digitalsignature.model.Signature> findByArticleId(
		java.lang.String articleId) throws com.liferay.portal.SystemException {
		return getService().findByArticleId(articleId);
	}

	public static java.util.List<com.nss.portlet.digitalsignature.model.Signature> findByArticlePrimKey(
		long articlePrimKey) throws com.liferay.portal.SystemException {
		return getService().findByArticlePrimKey(articlePrimKey);
	}

	public static com.nss.portlet.digitalsignature.model.Signature getSignature(
		long articlePrimKey, long userId)
		throws com.liferay.portal.SystemException {
		return getService().getSignature(articlePrimKey, userId);
	}

	public static void clearService() {
		_service = null;
	}

	public static SignatureLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					SignatureLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new SignatureLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(SignatureLocalService service) {
		_service = service;
	}

	private static SignatureLocalService _service;
}