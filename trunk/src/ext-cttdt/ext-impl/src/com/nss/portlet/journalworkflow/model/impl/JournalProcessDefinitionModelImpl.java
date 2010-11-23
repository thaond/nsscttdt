package com.nss.portlet.journalworkflow.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.impl.ExpandoBridgeImpl;

import com.nss.portlet.journalworkflow.model.JournalProcessDefinition;
import com.nss.portlet.journalworkflow.model.JournalProcessDefinitionSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="JournalProcessDefinitionModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>JournalProcessDefinition</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.journalworkflow.model.JournalProcessDefinition
 * @see com.nss.portlet.journalworkflow.model.JournalProcessDefinitionModel
 * @see com.nss.portlet.journalworkflow.model.impl.JournalProcessDefinitionImpl
 *
 */
public class JournalProcessDefinitionModelImpl extends BaseModelImpl<JournalProcessDefinition> {
    public static final String TABLE_NAME = "JournalProcessDefinition";
    public static final Object[][] TABLE_COLUMNS = {
            { "journalProcessDefinitionId", new Integer(Types.BIGINT) },
            

            { "name", new Integer(Types.VARCHAR) },
            

            { "version", new Integer(Types.VARCHAR) },
            

            { "content", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table JournalProcessDefinition (journalProcessDefinitionId LONG not null primary key,name VARCHAR(75) null,version VARCHAR(75) null,content VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table JournalProcessDefinition";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.entity.cache.enabled.com.nss.portlet.journalworkflow.model.JournalProcessDefinition"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.nss.portlet.journalworkflow.model.JournalProcessDefinition"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.nss.portlet.journalworkflow.model.JournalProcessDefinition"));
    private long _journalProcessDefinitionId;
    private String _name;
    private String _version;
    private String _content;
    private transient ExpandoBridge _expandoBridge;

    public JournalProcessDefinitionModelImpl() {
    }

    public static JournalProcessDefinition toModel(
        JournalProcessDefinitionSoap soapModel) {
        JournalProcessDefinition model = new JournalProcessDefinitionImpl();

        model.setJournalProcessDefinitionId(soapModel.getJournalProcessDefinitionId());
        model.setName(soapModel.getName());
        model.setVersion(soapModel.getVersion());
        model.setContent(soapModel.getContent());

        return model;
    }

    public static List<JournalProcessDefinition> toModels(
        JournalProcessDefinitionSoap[] soapModels) {
        List<JournalProcessDefinition> models = new ArrayList<JournalProcessDefinition>(soapModels.length);

        for (JournalProcessDefinitionSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _journalProcessDefinitionId;
    }

    public void setPrimaryKey(long pk) {
        setJournalProcessDefinitionId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_journalProcessDefinitionId);
    }

    public long getJournalProcessDefinitionId() {
        return _journalProcessDefinitionId;
    }

    public void setJournalProcessDefinitionId(long journalProcessDefinitionId) {
        _journalProcessDefinitionId = journalProcessDefinitionId;
    }

    public String getName() {
        return GetterUtil.getString(_name);
    }

    public void setName(String name) {
        _name = name;
    }

    public String getVersion() {
        return GetterUtil.getString(_version);
    }

    public void setVersion(String version) {
        _version = version;
    }

    public String getContent() {
        return GetterUtil.getString(_content);
    }

    public void setContent(String content) {
        _content = content;
    }

    public JournalProcessDefinition toEscapedModel() {
        if (isEscapedModel()) {
            return (JournalProcessDefinition) this;
        } else {
            JournalProcessDefinition model = new JournalProcessDefinitionImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setJournalProcessDefinitionId(getJournalProcessDefinitionId());
            model.setName(HtmlUtil.escape(getName()));
            model.setVersion(HtmlUtil.escape(getVersion()));
            model.setContent(HtmlUtil.escape(getContent()));

            model = (JournalProcessDefinition) Proxy.newProxyInstance(JournalProcessDefinition.class.getClassLoader(),
                    new Class[] { JournalProcessDefinition.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = new ExpandoBridgeImpl(JournalProcessDefinition.class.getName(),
                    getPrimaryKey());
        }

        return _expandoBridge;
    }

    public Object clone() {
        JournalProcessDefinitionImpl clone = new JournalProcessDefinitionImpl();

        clone.setJournalProcessDefinitionId(getJournalProcessDefinitionId());
        clone.setName(getName());
        clone.setVersion(getVersion());
        clone.setContent(getContent());

        return clone;
    }

    public int compareTo(JournalProcessDefinition journalProcessDefinition) {
        int value = 0;

        value = getName().compareTo(journalProcessDefinition.getName());

        if (value != 0) {
            return value;
        }

        value = getVersion().compareTo(journalProcessDefinition.getVersion());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        JournalProcessDefinition journalProcessDefinition = null;

        try {
            journalProcessDefinition = (JournalProcessDefinition) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = journalProcessDefinition.getPrimaryKey();

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

        sb.append("{journalProcessDefinitionId=");
        sb.append(getJournalProcessDefinitionId());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", version=");
        sb.append(getVersion());
        sb.append(", content=");
        sb.append(getContent());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBuilder sb = new StringBuilder();

        sb.append("<model><model-name>");
        sb.append(
            "com.nss.portlet.journalworkflow.model.JournalProcessDefinition");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>journalProcessDefinitionId</column-name><column-value><![CDATA[");
        sb.append(getJournalProcessDefinitionId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>version</column-name><column-value><![CDATA[");
        sb.append(getVersion());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>content</column-name><column-value><![CDATA[");
        sb.append(getContent());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
