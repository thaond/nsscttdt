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

package com.nss.portlet.digitalsignature.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="CertificateSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author canhminh
 *
 */
public class CertificateSoap implements Serializable {
	public static CertificateSoap toSoapModel(Certificate model) {
		CertificateSoap soapModel = new CertificateSoap();

		soapModel.setUserId(model.getUserId());
		soapModel.setX509Certificate(model.getX509Certificate());

		return soapModel;
	}

	public static CertificateSoap[] toSoapModels(Certificate[] models) {
		CertificateSoap[] soapModels = new CertificateSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CertificateSoap[][] toSoapModels(Certificate[][] models) {
		CertificateSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CertificateSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CertificateSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CertificateSoap[] toSoapModels(List<Certificate> models) {
		List<CertificateSoap> soapModels = new ArrayList<CertificateSoap>(models.size());

		for (Certificate model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CertificateSoap[soapModels.size()]);
	}

	public CertificateSoap() {
	}

	public long getPrimaryKey() {
		return _userId;
	}

	public void setPrimaryKey(long pk) {
		setUserId(pk);
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getX509Certificate() {
		return _x509Certificate;
	}

	public void setX509Certificate(String x509Certificate) {
		_x509Certificate = x509Certificate;
	}

	private long _userId;
	private String _x509Certificate;
}