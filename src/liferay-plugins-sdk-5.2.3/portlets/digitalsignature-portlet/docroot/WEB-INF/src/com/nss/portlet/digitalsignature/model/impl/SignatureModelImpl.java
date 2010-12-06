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
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.impl.ExpandoBridgeImpl;

import com.nss.portlet.digitalsignature.model.Signature;
import com.nss.portlet.digitalsignature.model.SignatureSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="SignatureModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author canhminh
 *
 */
public class SignatureModelImpl extends BaseModelImpl<Signature> {
	public static final String TABLE_NAME = "nss_signature";
	public static final Object[][] TABLE_COLUMNS = {
			{ "signatureId", new Integer(Types.BIGINT) },
			

			{ "groupId", new Integer(Types.BIGINT) },
			

			{ "companyId", new Integer(Types.BIGINT) },
			

			{ "userId", new Integer(Types.BIGINT) },
			

			{ "userName", new Integer(Types.VARCHAR) },
			

			{ "createDate", new Integer(Types.TIMESTAMP) },
			

			{ "articlePrimKey", new Integer(Types.BIGINT) },
			

			{ "articleId", new Integer(Types.VARCHAR) },
			

			{ "version", new Integer(Types.DOUBLE) },
			

			{ "signData", new Integer(Types.VARCHAR) }
		};
	public static final String TABLE_SQL_CREATE = "create table nss_signature (signatureId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,articlePrimKey LONG,articleId VARCHAR(75) null,version DOUBLE,signData STRING null)";
	public static final String TABLE_SQL_DROP = "drop table nss_signature";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.nss.portlet.digitalsignature.model.Signature"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.nss.portlet.digitalsignature.model.Signature"),
			true);

	public static Signature toModel(SignatureSoap soapModel) {
		Signature model = new SignatureImpl();

		model.setSignatureId(soapModel.getSignatureId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setArticlePrimKey(soapModel.getArticlePrimKey());
		model.setArticleId(soapModel.getArticleId());
		model.setVersion(soapModel.getVersion());
		model.setSignData(soapModel.getSignData());

		return model;
	}

	public static List<Signature> toModels(SignatureSoap[] soapModels) {
		List<Signature> models = new ArrayList<Signature>(soapModels.length);

		for (SignatureSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.nss.portlet.digitalsignature.model.Signature"));

	public SignatureModelImpl() {
	}

	public long getPrimaryKey() {
		return _signatureId;
	}

	public void setPrimaryKey(long pk) {
		setSignatureId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_signatureId);
	}

	public long getSignatureId() {
		return _signatureId;
	}

	public void setSignatureId(long signatureId) {
		_signatureId = signatureId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = userId;
		}
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	public String getUserName() {
		return GetterUtil.getString(_userName);
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public long getArticlePrimKey() {
		return _articlePrimKey;
	}

	public void setArticlePrimKey(long articlePrimKey) {
		_articlePrimKey = articlePrimKey;

		if (!_setOriginalArticlePrimKey) {
			_setOriginalArticlePrimKey = true;

			_originalArticlePrimKey = articlePrimKey;
		}
	}

	public long getOriginalArticlePrimKey() {
		return _originalArticlePrimKey;
	}

	public String getArticleId() {
		return GetterUtil.getString(_articleId);
	}

	public void setArticleId(String articleId) {
		_articleId = articleId;
	}

	public double getVersion() {
		return _version;
	}

	public void setVersion(double version) {
		_version = version;
	}

	public String getSignData() {
		return GetterUtil.getString(_signData);
	}

	public void setSignData(String signData) {
		_signData = signData;
	}

	public Signature toEscapedModel() {
		if (isEscapedModel()) {
			return (Signature)this;
		}
		else {
			Signature model = new SignatureImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setSignatureId(getSignatureId());
			model.setGroupId(getGroupId());
			model.setCompanyId(getCompanyId());
			model.setUserId(getUserId());
			model.setUserName(HtmlUtil.escape(getUserName()));
			model.setCreateDate(getCreateDate());
			model.setArticlePrimKey(getArticlePrimKey());
			model.setArticleId(HtmlUtil.escape(getArticleId()));
			model.setVersion(getVersion());
			model.setSignData(HtmlUtil.escape(getSignData()));

			model = (Signature)Proxy.newProxyInstance(Signature.class.getClassLoader(),
					new Class[] { Signature.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = new ExpandoBridgeImpl(Signature.class.getName(),
					getPrimaryKey());
		}

		return _expandoBridge;
	}

	public Object clone() {
		SignatureImpl clone = new SignatureImpl();

		clone.setSignatureId(getSignatureId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setArticlePrimKey(getArticlePrimKey());
		clone.setArticleId(getArticleId());
		clone.setVersion(getVersion());
		clone.setSignData(getSignData());

		return clone;
	}

	public int compareTo(Signature signature) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), signature.getCreateDate());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		Signature signature = null;

		try {
			signature = (Signature)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = signature.getPrimaryKey();

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

		sb.append("{signatureId=");
		sb.append(getSignatureId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", articlePrimKey=");
		sb.append(getArticlePrimKey());
		sb.append(", articleId=");
		sb.append(getArticleId());
		sb.append(", version=");
		sb.append(getVersion());
		sb.append(", signData=");
		sb.append(getSignData());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("com.nss.portlet.digitalsignature.model.Signature");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>signatureId</column-name><column-value><![CDATA[");
		sb.append(getSignatureId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>articlePrimKey</column-name><column-value><![CDATA[");
		sb.append(getArticlePrimKey());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>articleId</column-name><column-value><![CDATA[");
		sb.append(getArticleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>version</column-name><column-value><![CDATA[");
		sb.append(getVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>signData</column-name><column-value><![CDATA[");
		sb.append(getSignData());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _signatureId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private String _userName;
	private Date _createDate;
	private long _articlePrimKey;
	private long _originalArticlePrimKey;
	private boolean _setOriginalArticlePrimKey;
	private String _articleId;
	private double _version;
	private String _signData;
	private transient ExpandoBridge _expandoBridge;
}