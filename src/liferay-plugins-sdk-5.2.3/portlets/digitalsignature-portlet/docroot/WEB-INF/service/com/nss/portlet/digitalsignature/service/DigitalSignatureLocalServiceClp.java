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

import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.NullWrapper;

/**
 * <a href="DigitalSignatureLocalServiceClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author canhminh
 *
 */
public class DigitalSignatureLocalServiceClp
	implements DigitalSignatureLocalService {
	public DigitalSignatureLocalServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;
	}

	public byte[] digest(java.io.InputStream inputStream,
		java.lang.String algorithm) throws java.lang.Exception {
		Object paramObj0 = ClpSerializer.translateInput(inputStream);

		if (inputStream == null) {
			paramObj0 = new NullWrapper("java.io.InputStream");
		}

		Object paramObj1 = ClpSerializer.translateInput(algorithm);

		if (algorithm == null) {
			paramObj1 = new NullWrapper("java.lang.String");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("digest",
					new Object[] { paramObj0, paramObj1 });
		}
		catch (Throwable t) {
			if (t instanceof java.lang.Exception) {
				throw (java.lang.Exception)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (byte[])ClpSerializer.translateOutput(returnObj);
	}

	public byte[] sign(java.security.PrivateKey privateKey, byte[] hashValue)
		throws java.security.GeneralSecurityException {
		Object paramObj0 = ClpSerializer.translateInput(privateKey);

		if (privateKey == null) {
			paramObj0 = new NullWrapper("java.security.PrivateKey");
		}

		Object paramObj1 = ClpSerializer.translateInput(hashValue);

		if (hashValue == null) {
			paramObj1 = new NullWrapper("[B");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("sign",
					new Object[] { paramObj0, paramObj1 });
		}
		catch (Throwable t) {
			if (t instanceof java.security.GeneralSecurityException) {
				throw (java.security.GeneralSecurityException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (byte[])ClpSerializer.translateOutput(returnObj);
	}

	public boolean verysign(java.security.PublicKey publicKey,
		byte[] hashValue, byte[] signature)
		throws java.security.GeneralSecurityException {
		Object paramObj0 = ClpSerializer.translateInput(publicKey);

		if (publicKey == null) {
			paramObj0 = new NullWrapper("java.security.PublicKey");
		}

		Object paramObj1 = ClpSerializer.translateInput(hashValue);

		if (hashValue == null) {
			paramObj1 = new NullWrapper("[B");
		}

		Object paramObj2 = ClpSerializer.translateInput(signature);

		if (signature == null) {
			paramObj2 = new NullWrapper("[B");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("verysign",
					new Object[] { paramObj0, paramObj1, paramObj2 });
		}
		catch (Throwable t) {
			if (t instanceof java.security.GeneralSecurityException) {
				throw (java.security.GeneralSecurityException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Boolean)returnObj).booleanValue();
	}

	private ClassLoaderProxy _classLoaderProxy;
}