package com.nss.portlet.phone_book.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.impl.ExpandoBridgeImpl;

import com.nss.portlet.phone_book.model.DetailBook;
import com.nss.portlet.phone_book.model.DetailBookSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="DetailBookModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>DetailBook</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.phone_book.model.DetailBook
 * @see com.nss.portlet.phone_book.model.DetailBookModel
 * @see com.nss.portlet.phone_book.model.impl.DetailBookImpl
 *
 */
public class DetailBookModelImpl extends BaseModelImpl<DetailBook> {
    public static final String TABLE_NAME = "nss_detail_book";
    public static final Object[][] TABLE_COLUMNS = {
            { "detailBookId", new Integer(Types.BIGINT) },
            

            { "detailBookCode", new Integer(Types.VARCHAR) },
            

            { "detailBookName", new Integer(Types.VARCHAR) },
            

            { "detailDescription", new Integer(Types.VARCHAR) },
            

            { "detailActive", new Integer(Types.BOOLEAN) },
            

            { "zip", new Integer(Types.VARCHAR) },
            

            { "internal_", new Integer(Types.VARCHAR) },
            

            { "home", new Integer(Types.VARCHAR) },
            

            { "mobile", new Integer(Types.VARCHAR) },
            

            { "email", new Integer(Types.VARCHAR) },
            

            { "contactBookId", new Integer(Types.BIGINT) },
            

            { "companyid", new Integer(Types.BIGINT) },
            

            { "userid", new Integer(Types.BIGINT) }
        };
    public static final String TABLE_SQL_CREATE = "create table nss_detail_book (detailBookId LONG not null primary key,detailBookCode VARCHAR(75) null,detailBookName VARCHAR(75) null,detailDescription VARCHAR(75) null,detailActive BOOLEAN,zip VARCHAR(75) null,internal_ VARCHAR(75) null,home VARCHAR(75) null,mobile VARCHAR(75) null,email VARCHAR(75) null,contactBookId LONG,companyid LONG,userid LONG)";
    public static final String TABLE_SQL_DROP = "drop table nss_detail_book";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.entity.cache.enabled.com.nss.portlet.phone_book.model.DetailBook"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.nss.portlet.phone_book.model.DetailBook"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.nss.portlet.phone_book.model.DetailBook"));
    private long _detailBookId;
    private String _detailBookCode;
    private String _detailBookName;
    private String _detailDescription;
    private boolean _detailActive;
    private String _zip;
    private String _internal;
    private String _home;
    private String _mobile;
    private String _email;
    private long _contactBookId;
    private long _companyid;
    private long _userid;
    private transient ExpandoBridge _expandoBridge;

    public DetailBookModelImpl() {
    }

    public static DetailBook toModel(DetailBookSoap soapModel) {
        DetailBook model = new DetailBookImpl();

        model.setDetailBookId(soapModel.getDetailBookId());
        model.setDetailBookCode(soapModel.getDetailBookCode());
        model.setDetailBookName(soapModel.getDetailBookName());
        model.setDetailDescription(soapModel.getDetailDescription());
        model.setDetailActive(soapModel.getDetailActive());
        model.setZip(soapModel.getZip());
        model.setInternal(soapModel.getInternal());
        model.setHome(soapModel.getHome());
        model.setMobile(soapModel.getMobile());
        model.setEmail(soapModel.getEmail());
        model.setContactBookId(soapModel.getContactBookId());
        model.setCompanyid(soapModel.getCompanyid());
        model.setUserid(soapModel.getUserid());

        return model;
    }

    public static List<DetailBook> toModels(DetailBookSoap[] soapModels) {
        List<DetailBook> models = new ArrayList<DetailBook>(soapModels.length);

        for (DetailBookSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _detailBookId;
    }

    public void setPrimaryKey(long pk) {
        setDetailBookId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_detailBookId);
    }

    public long getDetailBookId() {
        return _detailBookId;
    }

    public void setDetailBookId(long detailBookId) {
        _detailBookId = detailBookId;
    }

    public String getDetailBookCode() {
        return GetterUtil.getString(_detailBookCode);
    }

    public void setDetailBookCode(String detailBookCode) {
        _detailBookCode = detailBookCode;
    }

    public String getDetailBookName() {
        return GetterUtil.getString(_detailBookName);
    }

    public void setDetailBookName(String detailBookName) {
        _detailBookName = detailBookName;
    }

    public String getDetailDescription() {
        return GetterUtil.getString(_detailDescription);
    }

    public void setDetailDescription(String detailDescription) {
        _detailDescription = detailDescription;
    }

    public boolean getDetailActive() {
        return _detailActive;
    }

    public boolean isDetailActive() {
        return _detailActive;
    }

    public void setDetailActive(boolean detailActive) {
        _detailActive = detailActive;
    }

    public String getZip() {
        return GetterUtil.getString(_zip);
    }

    public void setZip(String zip) {
        _zip = zip;
    }

    public String getInternal() {
        return GetterUtil.getString(_internal);
    }

    public void setInternal(String internal) {
        _internal = internal;
    }

    public String getHome() {
        return GetterUtil.getString(_home);
    }

    public void setHome(String home) {
        _home = home;
    }

    public String getMobile() {
        return GetterUtil.getString(_mobile);
    }

    public void setMobile(String mobile) {
        _mobile = mobile;
    }

    public String getEmail() {
        return GetterUtil.getString(_email);
    }

    public void setEmail(String email) {
        _email = email;
    }

    public long getContactBookId() {
        return _contactBookId;
    }

    public void setContactBookId(long contactBookId) {
        _contactBookId = contactBookId;
    }

    public long getCompanyid() {
        return _companyid;
    }

    public void setCompanyid(long companyid) {
        _companyid = companyid;
    }

    public long getUserid() {
        return _userid;
    }

    public void setUserid(long userid) {
        _userid = userid;
    }

    public DetailBook toEscapedModel() {
        if (isEscapedModel()) {
            return (DetailBook) this;
        } else {
            DetailBook model = new DetailBookImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setDetailBookId(getDetailBookId());
            model.setDetailBookCode(HtmlUtil.escape(getDetailBookCode()));
            model.setDetailBookName(HtmlUtil.escape(getDetailBookName()));
            model.setDetailDescription(HtmlUtil.escape(getDetailDescription()));
            model.setDetailActive(getDetailActive());
            model.setZip(HtmlUtil.escape(getZip()));
            model.setInternal(HtmlUtil.escape(getInternal()));
            model.setHome(HtmlUtil.escape(getHome()));
            model.setMobile(HtmlUtil.escape(getMobile()));
            model.setEmail(HtmlUtil.escape(getEmail()));
            model.setContactBookId(getContactBookId());
            model.setCompanyid(getCompanyid());
            model.setUserid(getUserid());

            model = (DetailBook) Proxy.newProxyInstance(DetailBook.class.getClassLoader(),
                    new Class[] { DetailBook.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = new ExpandoBridgeImpl(DetailBook.class.getName(),
                    getPrimaryKey());
        }

        return _expandoBridge;
    }

    public Object clone() {
        DetailBookImpl clone = new DetailBookImpl();

        clone.setDetailBookId(getDetailBookId());
        clone.setDetailBookCode(getDetailBookCode());
        clone.setDetailBookName(getDetailBookName());
        clone.setDetailDescription(getDetailDescription());
        clone.setDetailActive(getDetailActive());
        clone.setZip(getZip());
        clone.setInternal(getInternal());
        clone.setHome(getHome());
        clone.setMobile(getMobile());
        clone.setEmail(getEmail());
        clone.setContactBookId(getContactBookId());
        clone.setCompanyid(getCompanyid());
        clone.setUserid(getUserid());

        return clone;
    }

    public int compareTo(DetailBook detailBook) {
        long pk = detailBook.getPrimaryKey();

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

        DetailBook detailBook = null;

        try {
            detailBook = (DetailBook) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = detailBook.getPrimaryKey();

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

        sb.append("{detailBookId=");
        sb.append(getDetailBookId());
        sb.append(", detailBookCode=");
        sb.append(getDetailBookCode());
        sb.append(", detailBookName=");
        sb.append(getDetailBookName());
        sb.append(", detailDescription=");
        sb.append(getDetailDescription());
        sb.append(", detailActive=");
        sb.append(getDetailActive());
        sb.append(", zip=");
        sb.append(getZip());
        sb.append(", internal=");
        sb.append(getInternal());
        sb.append(", home=");
        sb.append(getHome());
        sb.append(", mobile=");
        sb.append(getMobile());
        sb.append(", email=");
        sb.append(getEmail());
        sb.append(", contactBookId=");
        sb.append(getContactBookId());
        sb.append(", companyid=");
        sb.append(getCompanyid());
        sb.append(", userid=");
        sb.append(getUserid());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBuilder sb = new StringBuilder();

        sb.append("<model><model-name>");
        sb.append("com.nss.portlet.phone_book.model.DetailBook");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>detailBookId</column-name><column-value><![CDATA[");
        sb.append(getDetailBookId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>detailBookCode</column-name><column-value><![CDATA[");
        sb.append(getDetailBookCode());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>detailBookName</column-name><column-value><![CDATA[");
        sb.append(getDetailBookName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>detailDescription</column-name><column-value><![CDATA[");
        sb.append(getDetailDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>detailActive</column-name><column-value><![CDATA[");
        sb.append(getDetailActive());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>zip</column-name><column-value><![CDATA[");
        sb.append(getZip());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>internal</column-name><column-value><![CDATA[");
        sb.append(getInternal());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>home</column-name><column-value><![CDATA[");
        sb.append(getHome());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>mobile</column-name><column-value><![CDATA[");
        sb.append(getMobile());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>email</column-name><column-value><![CDATA[");
        sb.append(getEmail());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>contactBookId</column-name><column-value><![CDATA[");
        sb.append(getContactBookId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>companyid</column-name><column-value><![CDATA[");
        sb.append(getCompanyid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userid</column-name><column-value><![CDATA[");
        sb.append(getUserid());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
