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

package com.nss.portlet.digitalsignature.model.impl;

import com.liferay.portal.kernel.util.Base64;

import com.nss.portlet.digitalsignature.model.Certificate;

import java.io.ByteArrayInputStream;

import java.security.NoSuchProviderException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

/**
 * <a href="CertificateImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author canhminh
 */
public class CertificateImpl extends CertificateModelImpl
	implements Certificate {

	public CertificateImpl() {

	}

	public X509Certificate getCertificate()
		throws CertificateException, NoSuchProviderException {

		byte[] certDecode = Base64.decode(getX509Certificate());
		CertificateFactory factory =
			CertificateFactory.getInstance("X.509", "BC");
		ByteArrayInputStream bais = new ByteArrayInputStream(certDecode);

		return (X509Certificate) factory.generateCertificate(bais);
	}
}