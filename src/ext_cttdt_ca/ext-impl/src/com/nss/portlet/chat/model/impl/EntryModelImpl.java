package com.nss.portlet.chat.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.impl.ExpandoBridgeImpl;

import com.nss.portlet.chat.model.Entry;
import com.nss.portlet.chat.model.EntrySoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="EntryModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>Entry</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.chat.model.Entry
 * @see com.nss.portlet.chat.model.EntryModel
 * @see com.nss.portlet.chat.model.impl.EntryImpl
 *
 */
public class EntryModelImpl extends BaseModelImpl<Entry> {
    public static final String TABLE_NAME = "chat_entry";
    public static final Object[][] TABLE_COLUMNS = {
            { "entryId", new Integer(Types.BIGINT) },
            

            { "createDate", new Integer(Types.BIGINT) },
            

            { "fromUserId", new Integer(Types.BIGINT) },
            

            { "toUserId", new Integer(Types.BIGINT) },
            

            { "content", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table chat_entry (entryId LONG not null primary key,createDate LONG,fromUserId LONG,toUserId LONG,content VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table chat_entry";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.entity.cache.enabled.com.nss.portlet.chat.model.Entry"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.nss.portlet.chat.model.Entry"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.nss.portlet.chat.model.Entry"));
    private long _entryId;
    private long _createDate;
    private long _fromUserId;
    private long _toUserId;
    private String _content;
    private transient ExpandoBridge _expandoBridge;

    public EntryModelImpl() {
    }

    public static Entry toModel(EntrySoap soapModel) {
        Entry model = new EntryImpl();

        model.setEntryId(soapModel.getEntryId());
        model.setCreateDate(soapModel.getCreateDate());
        model.setFromUserId(soapModel.getFromUserId());
        model.setToUserId(soapModel.getToUserId());
        model.setContent(soapModel.getContent());

        return model;
    }

    public static List<Entry> toModels(EntrySoap[] soapModels) {
        List<Entry> models = new ArrayList<Entry>(soapModels.length);

        for (EntrySoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _entryId;
    }

    public void setPrimaryKey(long pk) {
        setEntryId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_entryId);
    }

    public long getEntryId() {
        return _entryId;
    }

    public void setEntryId(long entryId) {
        _entryId = entryId;
    }

    public long getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(long createDate) {
        _createDate = createDate;
    }

    public long getFromUserId() {
        return _fromUserId;
    }

    public void setFromUserId(long fromUserId) {
        _fromUserId = fromUserId;
    }

    public long getToUserId() {
        return _toUserId;
    }

    public void setToUserId(long toUserId) {
        _toUserId = toUserId;
    }

    public String getContent() {
        return GetterUtil.getString(_content);
    }

    public void setContent(String content) {
        _content = content;
    }

    public Entry toEscapedModel() {
        if (isEscapedModel()) {
            return (Entry) this;
        } else {
            Entry model = new EntryImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setEntryId(getEntryId());
            model.setCreateDate(getCreateDate());
            model.setFromUserId(getFromUserId());
            model.setToUserId(getToUserId());
            model.setContent(HtmlUtil.escape(getContent()));

            model = (Entry) Proxy.newProxyInstance(Entry.class.getClassLoader(),
                    new Class[] { Entry.class }, new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = new ExpandoBridgeImpl(Entry.class.getName(),
                    getPrimaryKey());
        }

        return _expandoBridge;
    }

    public Object clone() {
        EntryImpl clone = new EntryImpl();

        clone.setEntryId(getEntryId());
        clone.setCreateDate(getCreateDate());
        clone.setFromUserId(getFromUserId());
        clone.setToUserId(getToUserId());
        clone.setContent(getContent());

        return clone;
    }

    public int compareTo(Entry entry) {
        int value = 0;

        if (getCreateDate() < entry.getCreateDate()) {
            value = -1;
        } else if (getCreateDate() > entry.getCreateDate()) {
            value = 1;
        } else {
            value = 0;
        }

        value = value * -1;

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        Entry entry = null;

        try {
            entry = (Entry) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = entry.getPrimaryKey();

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

        sb.append("{entryId=");
        sb.append(getEntryId());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append(", fromUserId=");
        sb.append(getFromUserId());
        sb.append(", toUserId=");
        sb.append(getToUserId());
        sb.append(", content=");
        sb.append(getContent());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBuilder sb = new StringBuilder();

        sb.append("<model><model-name>");
        sb.append("com.nss.portlet.chat.model.Entry");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>entryId</column-name><column-value><![CDATA[");
        sb.append(getEntryId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createDate</column-name><column-value><![CDATA[");
        sb.append(getCreateDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>fromUserId</column-name><column-value><![CDATA[");
        sb.append(getFromUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>toUserId</column-name><column-value><![CDATA[");
        sb.append(getToUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>content</column-name><column-value><![CDATA[");
        sb.append(getContent());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
