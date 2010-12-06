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

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.impl.ExpandoBridgeImpl;

import com.nss.portlet.digitalsignature.model.Certificate;
import com.nss.portlet.digitalsignature.model.CertificateSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="CertificateModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author canhminh
 *
 */
public class CertificateModelImpl extends BaseModelImpl<Certificate> {
	public static final String TABLE_NAME = "nss_certificate";
	public static final Object[][] TABLE_COLUMNS = {
			{ "userId", new Integer(Types.BIGINT) },
			

			{ "x509Certificate", new Integer(Types.CLOB) }
		};
	public static final String TABLE_SQL_CREATE = "create table nss_certificate (userId LONG not null primary key,x509Certificate TEXT null)";
	public static final String TABLE_SQL_DROP = "drop table nss_certificate";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.nss.portlet.digitalsignature.model.Certificate"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.nss.portlet.digitalsignature.model.Certificate"),
			true);

	public static Certificate toModel(CertificateSoap soapModel) {
		Certificate model = new CertificateImpl();

		model.setUserId(soapModel.getUserId());
		model.setX509Certificate(soapModel.getX509Certificate());

		return model;
	}

	public static List<Certificate> toModels(CertificateSoap[] soapModels) {
		List<Certificate> models = new ArrayList<Certificate>(soapModels.length);

		for (CertificateSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.nss.portlet.digitalsignature.model.Certificate"));

	public CertificateModelImpl() {
	}

	public long getPrimaryKey() {
		return _userId;
	}

	public void setPrimaryKey(long pk) {
		setUserId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_userId);
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getX509Certificate() {
		return GetterUtil.getString(_x509Certificate);
	}

	public void setX509Certificate(String x509Certificate) {
		_x509Certificate = x509Certificate;
	}

	public Certificate toEscapedModel() {
		if (isEscapedModel()) {
			return (Certificate)this;
		}
		else {
			Certificate model = new CertificateImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setUserId(getUserId());
			model.setX509Certificate(HtmlUtil.escape(getX509Certificate()));

			model = (Certificate)Proxy.newProxyInstance(Certificate.class.getClassLoader(),
					new Class[] { Certificate.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = new ExpandoBridgeImpl(Certificate.class.getName(),
					getPrimaryKey());
		}

		return _expandoBridge;
	}

	public Object clone() {
		CertificateImpl clone = new CertificateImpl();

		clone.setUserId(getUserId());
		clone.setX509Certificate(getX509Certificate());

		return clone;
	}

	public int compareTo(Certificate certificate) {
		long pk = certificate.getPrimaryKey();

		if (getPrimaryKey() < pk) {
			return -1;
		}
		else if (getPrimaryKey() > pk) {
			return 1;
		}
		else {
			return 0;
		}
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		Certificate certificate = null;

		try {
			certificate = (Certificate)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = certificate.getPrimaryKey();

		if (getPrimaryKey() == pk) {
			return true;
		}
		else {
			return false;
		}
	}

	public int hashCode() {
		return (int)getPrimaryKey();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("{userId=");
		sb.append(getUserId());
		sb.append(", x509Certificate=");
		sb.append(getX509Certificate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("com.nss.portlet.digitalsignature.model.Certificate");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>x509Certificate</column-name><column-value><![CDATA[");
		sb.append(getX509Certificate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _userId;
	private String _x509Certificate;
	private transient ExpandoBridge _expandoBridge;
}