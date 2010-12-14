package com.nss.portlet.phone_book.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.impl.ExpandoBridgeImpl;

import com.nss.portlet.phone_book.model.ContactBook;
import com.nss.portlet.phone_book.model.ContactBookSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="ContactBookModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>ContactBook</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.phone_book.model.ContactBook
 * @see com.nss.portlet.phone_book.model.ContactBookModel
 * @see com.nss.portlet.phone_book.model.impl.ContactBookImpl
 *
 */
public class ContactBookModelImpl extends BaseModelImpl<ContactBook> {
    public static final String TABLE_NAME = "nss_contact_book";
    public static final Object[][] TABLE_COLUMNS = {
            { "contactBookId", new Integer(Types.BIGINT) },
            

            { "contactBookCode", new Integer(Types.VARCHAR) },
            

            { "contactBookName", new Integer(Types.VARCHAR) },
            

            { "contactDescription", new Integer(Types.VARCHAR) },
            

            { "contactActive", new Integer(Types.BOOLEAN) },
            

            { "companyid", new Integer(Types.BIGINT) },
            

            { "userid", new Integer(Types.BIGINT) }
        };
    public static final String TABLE_SQL_CREATE = "create table nss_contact_book (contactBookId LONG not null primary key,contactBookCode VARCHAR(75) null,contactBookName VARCHAR(75) null,contactDescription VARCHAR(75) null,contactActive BOOLEAN,companyid LONG,userid LONG)";
    public static final String TABLE_SQL_DROP = "drop table nss_contact_book";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.entity.cache.enabled.com.nss.portlet.phone_book.model.ContactBook"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.nss.portlet.phone_book.model.ContactBook"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.nss.portlet.phone_book.model.ContactBook"));
    private long _contactBookId;
    private String _contactBookCode;
    private String _contactBookName;
    private String _contactDescription;
    private boolean _contactActive;
    private long _companyid;
    private long _userid;
    private transient ExpandoBridge _expandoBridge;

    public ContactBookModelImpl() {
    }

    public static ContactBook toModel(ContactBookSoap soapModel) {
        ContactBook model = new ContactBookImpl();

        model.setContactBookId(soapModel.getContactBookId());
        model.setContactBookCode(soapModel.getContactBookCode());
        model.setContactBookName(soapModel.getContactBookName());
        model.setContactDescription(soapModel.getContactDescription());
        model.setContactActive(soapModel.getContactActive());
        model.setCompanyid(soapModel.getCompanyid());
        model.setUserid(soapModel.getUserid());

        return model;
    }

    public static List<ContactBook> toModels(ContactBookSoap[] soapModels) {
        List<ContactBook> models = new ArrayList<ContactBook>(soapModels.length);

        for (ContactBookSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _contactBookId;
    }

    public void setPrimaryKey(long pk) {
        setContactBookId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_contactBookId);
    }

    public long getContactBookId() {
        return _contactBookId;
    }

    public void setContactBookId(long contactBookId) {
        _contactBookId = contactBookId;
    }

    public String getContactBookCode() {
        return GetterUtil.getString(_contactBookCode);
    }

    public void setContactBookCode(String contactBookCode) {
        _contactBookCode = contactBookCode;
    }

    public String getContactBookName() {
        return GetterUtil.getString(_contactBookName);
    }

    public void setContactBookName(String contactBookName) {
        _contactBookName = contactBookName;
    }

    public String getContactDescription() {
        return GetterUtil.getString(_contactDescription);
    }

    public void setContactDescription(String contactDescription) {
        _contactDescription = contactDescription;
    }

    public boolean getContactActive() {
        return _contactActive;
    }

    public boolean isContactActive() {
        return _contactActive;
    }

    public void setContactActive(boolean contactActive) {
        _contactActive = contactActive;
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

    public ContactBook toEscapedModel() {
        if (isEscapedModel()) {
            return (ContactBook) this;
        } else {
            ContactBook model = new ContactBookImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setContactBookId(getContactBookId());
            model.setContactBookCode(HtmlUtil.escape(getContactBookCode()));
            model.setContactBookName(HtmlUtil.escape(getContactBookName()));
            model.setContactDescription(HtmlUtil.escape(getContactDescription()));
            model.setContactActive(getContactActive());
            model.setCompanyid(getCompanyid());
            model.setUserid(getUserid());

            model = (ContactBook) Proxy.newProxyInstance(ContactBook.class.getClassLoader(),
                    new Class[] { ContactBook.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = new ExpandoBridgeImpl(ContactBook.class.getName(),
                    getPrimaryKey());
        }

        return _expandoBridge;
    }

    public Object clone() {
        ContactBookImpl clone = new ContactBookImpl();

        clone.setContactBookId(getContactBookId());
        clone.setContactBookCode(getContactBookCode());
        clone.setContactBookName(getContactBookName());
        clone.setContactDescription(getContactDescription());
        clone.setContactActive(getContactActive());
        clone.setCompanyid(getCompanyid());
        clone.setUserid(getUserid());

        return clone;
    }

    public int compareTo(ContactBook contactBook) {
        long pk = contactBook.getPrimaryKey();

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

        ContactBook contactBook = null;

        try {
            contactBook = (ContactBook) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = contactBook.getPrimaryKey();

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

        sb.append("{contactBookId=");
        sb.append(getContactBookId());
        sb.append(", contactBookCode=");
        sb.append(getContactBookCode());
        sb.append(", contactBookName=");
        sb.append(getContactBookName());
        sb.append(", contactDescription=");
        sb.append(getContactDescription());
        sb.append(", contactActive=");
        sb.append(getContactActive());
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
        sb.append("com.nss.portlet.phone_book.model.ContactBook");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>contactBookId</column-name><column-value><![CDATA[");
        sb.append(getContactBookId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>contactBookCode</column-name><column-value><![CDATA[");
        sb.append(getContactBookCode());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>contactBookName</column-name><column-value><![CDATA[");
        sb.append(getContactBookName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>contactDescription</column-name><column-value><![CDATA[");
        sb.append(getContactDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>contactActive</column-name><column-value><![CDATA[");
        sb.append(getContactActive());
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
