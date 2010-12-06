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
 * <a href="DigitalSignatureLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author canhminh
 *
 */
public class DigitalSignatureLocalServiceUtil {
	public static byte[] digest(java.io.InputStream inputStream,
		java.lang.String algorithm) throws java.lang.Exception {
		return getService().digest(inputStream, algorithm);
	}

	public static byte[] sign(java.security.PrivateKey privateKey,
		byte[] hashValue) throws java.security.GeneralSecurityException {
		return getService().sign(privateKey, hashValue);
	}

	public static boolean verysign(java.security.PublicKey publicKey,
		byte[] hashValue, byte[] signature)
		throws java.security.GeneralSecurityException {
		return getService().verysign(publicKey, hashValue, signature);
	}

	public static void clearService() {
		_service = null;
	}

	public static DigitalSignatureLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					DigitalSignatureLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new DigitalSignatureLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(DigitalSignatureLocalService service) {
		_service = service;
	}

	private static DigitalSignatureLocalService _service;
}