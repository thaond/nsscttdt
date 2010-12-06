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
 * <a href="ArticleDigestLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author canhminh
 *
 */
public class ArticleDigestLocalServiceUtil {
	public static byte[] digest(
		com.liferay.portlet.journal.model.JournalArticle article)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().digest(article);
	}

	public static byte[] digest(
		com.liferay.portlet.journal.model.JournalArticle article,
		java.lang.String algorithm, java.lang.String provider)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().digest(article, algorithm, provider);
	}

	public static byte[] digest(long articleId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().digest(articleId);
	}

	public static byte[] digest(long articleId, java.lang.String algorithm,
		java.lang.String provider)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().digest(articleId, algorithm, provider);
	}

	public static void clearService() {
		_service = null;
	}

	public static ArticleDigestLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					ArticleDigestLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new ArticleDigestLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(ArticleDigestLocalService service) {
		_service = service;
	}

	private static ArticleDigestLocalService _service;
}