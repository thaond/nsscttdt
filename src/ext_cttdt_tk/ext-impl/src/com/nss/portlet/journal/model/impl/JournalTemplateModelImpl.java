package com.nss.portlet.journal.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.impl.ExpandoBridgeImpl;

import com.nss.portlet.journal.model.JournalTemplate;
import com.nss.portlet.journal.model.JournalTemplateSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="JournalTemplateModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>JournalTemplate</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.journal.model.JournalTemplate
 * @see com.nss.portlet.journal.model.JournalTemplateModel
 * @see com.nss.portlet.journal.model.impl.JournalTemplateImpl
 *
 */
public class JournalTemplateModelImpl extends BaseModelImpl<JournalTemplate> {
    public static final String TABLE_NAME = "JournalTemplate";
    public static final Object[][] TABLE_COLUMNS = {
            { "uuid_", new Integer(Types.VARCHAR) },
            

            { "id_", new Integer(Types.BIGINT) },
            

            { "groupId", new Integer(Types.BIGINT) },
            

            { "companyId", new Integer(Types.BIGINT) },
            

            { "userId", new Integer(Types.BIGINT) },
            

            { "userName", new Integer(Types.VARCHAR) },
            

            { "createDate", new Integer(Types.TIMESTAMP) },
            

            { "modifiedDate", new Integer(Types.TIMESTAMP) },
            

            { "templateId", new Integer(Types.VARCHAR) },
            

            { "structureId", new Integer(Types.VARCHAR) },
            

            { "name", new Integer(Types.VARCHAR) },
            

            { "description", new Integer(Types.VARCHAR) },
            

            { "xsl", new Integer(Types.VARCHAR) },
            

            { "langType", new Integer(Types.VARCHAR) },
            

            { "cacheable", new Integer(Types.BOOLEAN) },
            

            { "smallImage", new Integer(Types.BOOLEAN) },
            

            { "smallImageId", new Integer(Types.BIGINT) },
            

            { "smallImageURL", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table JournalTemplate (uuid_ VARCHAR(75) null,id_ LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,templateId VARCHAR(75) null,structureId VARCHAR(75) null,name VARCHAR(75) null,description VARCHAR(75) null,xsl VARCHAR(75) null,langType VARCHAR(75) null,cacheable BOOLEAN,smallImage BOOLEAN,smallImageId LONG,smallImageURL VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table JournalTemplate";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.entity.cache.enabled.com.nss.portlet.journal.model.JournalTemplate"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.nss.portlet.journal.model.JournalTemplate"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.nss.portlet.journal.model.JournalTemplate"));
    private String _uuid;
    private String _originalUuid;
    private long _id;
    private long _groupId;
    private long _originalGroupId;
    private boolean _setOriginalGroupId;
    private long _companyId;
    private long _userId;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private String _templateId;
    private String _originalTemplateId;
    private String _structureId;
    private String _name;
    private String _description;
    private String _xsl;
    private String _langType;
    private boolean _cacheable;
    private boolean _smallImage;
    private long _smallImageId;
    private long _originalSmallImageId;
    private boolean _setOriginalSmallImageId;
    private String _smallImageURL;
    private transient ExpandoBridge _expandoBridge;

    public JournalTemplateModelImpl() {
    }

    public static JournalTemplate toModel(JournalTemplateSoap soapModel) {
        JournalTemplate model = new JournalTemplateImpl();

        model.setUuid(soapModel.getUuid());
        model.setId(soapModel.getId());
        model.setGroupId(soapModel.getGroupId());
        model.setCompanyId(soapModel.getCompanyId());
        model.setUserId(soapModel.getUserId());
        model.setUserName(soapModel.getUserName());
        model.setCreateDate(soapModel.getCreateDate());
        model.setModifiedDate(soapModel.getModifiedDate());
        model.setTemplateId(soapModel.getTemplateId());
        model.setStructureId(soapModel.getStructureId());
        model.setName(soapModel.getName());
        model.setDescription(soapModel.getDescription());
        model.setXsl(soapModel.getXsl());
        model.setLangType(soapModel.getLangType());
        model.setCacheable(soapModel.getCacheable());
        model.setSmallImage(soapModel.getSmallImage());
        model.setSmallImageId(soapModel.getSmallImageId());
        model.setSmallImageURL(soapModel.getSmallImageURL());

        return model;
    }

    public static List<JournalTemplate> toModels(
        JournalTemplateSoap[] soapModels) {
        List<JournalTemplate> models = new ArrayList<JournalTemplate>(soapModels.length);

        for (JournalTemplateSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _id;
    }

    public void setPrimaryKey(long pk) {
        setId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_id);
    }

    public String getUuid() {
        return GetterUtil.getString(_uuid);
    }

    public void setUuid(String uuid) {
        _uuid = uuid;

        if (_originalUuid == null) {
            _originalUuid = uuid;
        }
    }

    public String getOriginalUuid() {
        return GetterUtil.getString(_originalUuid);
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _groupId = groupId;

        if (!_setOriginalGroupId) {
            _setOriginalGroupId = true;

            _originalGroupId = groupId;
        }
    }

    public long getOriginalGroupId() {
        return _originalGroupId;
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

    public Date getModifiedDate() {
        return _modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;
    }

    public String getTemplateId() {
        return GetterUtil.getString(_templateId);
    }

    public void setTemplateId(String templateId) {
        _templateId = templateId;

        if (_originalTemplateId == null) {
            _originalTemplateId = templateId;
        }
    }

    public String getOriginalTemplateId() {
        return GetterUtil.getString(_originalTemplateId);
    }

    public String getStructureId() {
        return GetterUtil.getString(_structureId);
    }

    public void setStructureId(String structureId) {
        _structureId = structureId;
    }

    public String getName() {
        return GetterUtil.getString(_name);
    }

    public void setName(String name) {
        _name = name;
    }

    public String getDescription() {
        return GetterUtil.getString(_description);
    }

    public void setDescription(String description) {
        _description = description;
    }

    public String getXsl() {
        return GetterUtil.getString(_xsl);
    }

    public void setXsl(String xsl) {
        _xsl = xsl;
    }

    public String getLangType() {
        return GetterUtil.getString(_langType);
    }

    public void setLangType(String langType) {
        _langType = langType;
    }

    public boolean getCacheable() {
        return _cacheable;
    }

    public boolean isCacheable() {
        return _cacheable;
    }

    public void setCacheable(boolean cacheable) {
        _cacheable = cacheable;
    }

    public boolean getSmallImage() {
        return _smallImage;
    }

    public boolean isSmallImage() {
        return _smallImage;
    }

    public void setSmallImage(boolean smallImage) {
        _smallImage = smallImage;
    }

    public long getSmallImageId() {
        return _smallImageId;
    }

    public void setSmallImageId(long smallImageId) {
        _smallImageId = smallImageId;

        if (!_setOriginalSmallImageId) {
            _setOriginalSmallImageId = true;

            _originalSmallImageId = smallImageId;
        }
    }

    public long getOriginalSmallImageId() {
        return _originalSmallImageId;
    }

    public String getSmallImageURL() {
        return GetterUtil.getString(_smallImageURL);
    }

    public void setSmallImageURL(String smallImageURL) {
        _smallImageURL = smallImageURL;
    }

    public JournalTemplate toEscapedModel() {
        if (isEscapedModel()) {
            return (JournalTemplate) this;
        } else {
            JournalTemplate model = new JournalTemplateImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setUuid(HtmlUtil.escape(getUuid()));
            model.setId(getId());
            model.setGroupId(getGroupId());
            model.setCompanyId(getCompanyId());
            model.setUserId(getUserId());
            model.setUserName(HtmlUtil.escape(getUserName()));
            model.setCreateDate(getCreateDate());
            model.setModifiedDate(getModifiedDate());
            model.setTemplateId(HtmlUtil.escape(getTemplateId()));
            model.setStructureId(HtmlUtil.escape(getStructureId()));
            model.setName(HtmlUtil.escape(getName()));
            model.setDescription(HtmlUtil.escape(getDescription()));
            model.setXsl(HtmlUtil.escape(getXsl()));
            model.setLangType(HtmlUtil.escape(getLangType()));
            model.setCacheable(getCacheable());
            model.setSmallImage(getSmallImage());
            model.setSmallImageId(getSmallImageId());
            model.setSmallImageURL(HtmlUtil.escape(getSmallImageURL()));

            model = (JournalTemplate) Proxy.newProxyInstance(JournalTemplate.class.getClassLoader(),
                    new Class[] { JournalTemplate.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = new ExpandoBridgeImpl(JournalTemplate.class.getName(),
                    getPrimaryKey());
        }

        return _expandoBridge;
    }

    public Object clone() {
        JournalTemplateImpl clone = new JournalTemplateImpl();

        clone.setUuid(getUuid());
        clone.setId(getId());
        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());
        clone.setUserId(getUserId());
        clone.setUserName(getUserName());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());
        clone.setTemplateId(getTemplateId());
        clone.setStructureId(getStructureId());
        clone.setName(getName());
        clone.setDescription(getDescription());
        clone.setXsl(getXsl());
        clone.setLangType(getLangType());
        clone.setCacheable(getCacheable());
        clone.setSmallImage(getSmallImage());
        clone.setSmallImageId(getSmallImageId());
        clone.setSmallImageURL(getSmallImageURL());

        return clone;
    }

    public int compareTo(JournalTemplate journalTemplate) {
        int value = 0;

        value = getTemplateId().compareTo(journalTemplate.getTemplateId());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        JournalTemplate journalTemplate = null;

        try {
            journalTemplate = (JournalTemplate) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = journalTemplate.getPrimaryKey();

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

        sb.append("{uuid=");
        sb.append(getUuid());
        sb.append(", id=");
        sb.append(getId());
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
        sb.append(", modifiedDate=");
        sb.append(getModifiedDate());
        sb.append(", templateId=");
        sb.append(getTemplateId());
        sb.append(", structureId=");
        sb.append(getStructureId());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", xsl=");
        sb.append(getXsl());
        sb.append(", langType=");
        sb.append(getLangType());
        sb.append(", cacheable=");
        sb.append(getCacheable());
        sb.append(", smallImage=");
        sb.append(getSmallImage());
        sb.append(", smallImageId=");
        sb.append(getSmallImageId());
        sb.append(", smallImageURL=");
        sb.append(getSmallImageURL());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBuilder sb = new StringBuilder();

        sb.append("<model><model-name>");
        sb.append("com.nss.portlet.journal.model.JournalTemplate");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>uuid</column-name><column-value><![CDATA[");
        sb.append(getUuid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
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
            "<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
        sb.append(getModifiedDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>templateId</column-name><column-value><![CDATA[");
        sb.append(getTemplateId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>structureId</column-name><column-value><![CDATA[");
        sb.append(getStructureId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>xsl</column-name><column-value><![CDATA[");
        sb.append(getXsl());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>langType</column-name><column-value><![CDATA[");
        sb.append(getLangType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>cacheable</column-name><column-value><![CDATA[");
        sb.append(getCacheable());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>smallImage</column-name><column-value><![CDATA[");
        sb.append(getSmallImage());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>smallImageId</column-name><column-value><![CDATA[");
        sb.append(getSmallImageId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>smallImageURL</column-name><column-value><![CDATA[");
        sb.append(getSmallImageURL());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
