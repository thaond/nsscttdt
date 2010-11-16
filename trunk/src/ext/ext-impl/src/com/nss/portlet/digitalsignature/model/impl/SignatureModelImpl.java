package com.nss.portlet.digitalsignature.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
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
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>Signature</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.digitalsignature.model.Signature
 * @see com.nss.portlet.digitalsignature.model.SignatureModel
 * @see com.nss.portlet.digitalsignature.model.impl.SignatureImpl
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
            

            { "articleId", new Integer(Types.BIGINT) },
            

            { "signData", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table nss_signature (signatureId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,articleId LONG,signData VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table nss_signature";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.entity.cache.enabled.com.nss.portlet.digitalsignature.model.Signature"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.nss.portlet.digitalsignature.model.Signature"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.nss.portlet.digitalsignature.model.Signature"));
    private long _signatureId;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userName;
    private Date _createDate;
    private long _articleId;
    private String _signData;
    private transient ExpandoBridge _expandoBridge;

    public SignatureModelImpl() {
    }

    public static Signature toModel(SignatureSoap soapModel) {
        Signature model = new SignatureImpl();

        model.setSignatureId(soapModel.getSignatureId());
        model.setGroupId(soapModel.getGroupId());
        model.setCompanyId(soapModel.getCompanyId());
        model.setUserId(soapModel.getUserId());
        model.setUserName(soapModel.getUserName());
        model.setCreateDate(soapModel.getCreateDate());
        model.setArticleId(soapModel.getArticleId());
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

    public long getArticleId() {
        return _articleId;
    }

    public void setArticleId(long articleId) {
        _articleId = articleId;
    }

    public String getSignData() {
        return GetterUtil.getString(_signData);
    }

    public void setSignData(String signData) {
        _signData = signData;
    }

    public Signature toEscapedModel() {
        if (isEscapedModel()) {
            return (Signature) this;
        } else {
            Signature model = new SignatureImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setSignatureId(getSignatureId());
            model.setGroupId(getGroupId());
            model.setCompanyId(getCompanyId());
            model.setUserId(getUserId());
            model.setUserName(HtmlUtil.escape(getUserName()));
            model.setCreateDate(getCreateDate());
            model.setArticleId(getArticleId());
            model.setSignData(HtmlUtil.escape(getSignData()));

            model = (Signature) Proxy.newProxyInstance(Signature.class.getClassLoader(),
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
        clone.setArticleId(getArticleId());
        clone.setSignData(getSignData());

        return clone;
    }

    public int compareTo(Signature signature) {
        long pk = signature.getPrimaryKey();

        if (getPrimaryKey() < pk) {
            return -1;
        } else if (getPrimaryKey() > pk) {
            return 1;
        } else {
            return 0;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        Signature signature = null;

        try {
            signature = (Signature) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = signature.getPrimaryKey();

        if (getPrimaryKey() == pk) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (int) getPrimaryKey();
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
        sb.append(", articleId=");
        sb.append(getArticleId());
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
            "<column><column-name>articleId</column-name><column-value><![CDATA[");
        sb.append(getArticleId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>signData</column-name><column-value><![CDATA[");
        sb.append(getSignData());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
