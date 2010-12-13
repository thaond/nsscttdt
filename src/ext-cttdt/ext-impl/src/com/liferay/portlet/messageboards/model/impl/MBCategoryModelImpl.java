package com.liferay.portlet.messageboards.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.impl.ExpandoBridgeImpl;
import com.liferay.portlet.messageboards.model.MBCategory;
import com.liferay.portlet.messageboards.model.MBCategorySoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="MBCategoryModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>MBCategory</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.liferay.portlet.messageboards.model.MBCategory
 * @see com.liferay.portlet.messageboards.model.MBCategoryModel
 * @see com.liferay.portlet.messageboards.model.impl.MBCategoryImpl
 *
 */
public class MBCategoryModelImpl extends BaseModelImpl<MBCategory> {
    public static final String TABLE_NAME = "MBCategory";
    public static final Object[][] TABLE_COLUMNS = {
            { "uuid_", new Integer(Types.VARCHAR) },
            

            { "categoryId", new Integer(Types.BIGINT) },
            

            { "groupId", new Integer(Types.BIGINT) },
            

            { "companyId", new Integer(Types.BIGINT) },
            

            { "userId", new Integer(Types.BIGINT) },
            

            { "userName", new Integer(Types.VARCHAR) },
            

            { "createDate", new Integer(Types.TIMESTAMP) },
            

            { "modifiedDate", new Integer(Types.TIMESTAMP) },
            

            { "parentCategoryId", new Integer(Types.BIGINT) },
            

            { "name", new Integer(Types.VARCHAR) },
            

            { "description", new Integer(Types.VARCHAR) },
            

            { "threadCount", new Integer(Types.INTEGER) },
            

            { "messageCount", new Integer(Types.INTEGER) },
            

            { "lastPostDate", new Integer(Types.TIMESTAMP) },
            

            { "image_liferay", new Integer(Types.BIGINT) },
            

            { "orderNumber", new Integer(Types.INTEGER) }
        };
    public static final String TABLE_SQL_CREATE = "create table MBCategory (uuid_ VARCHAR(75) null,categoryId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,parentCategoryId LONG,name VARCHAR(75) null,description STRING null,threadCount INTEGER,messageCount INTEGER,lastPostDate DATE null,image_liferay LONG,orderNumber INTEGER)";
    public static final String TABLE_SQL_DROP = "drop table MBCategory";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.entity.cache.enabled.com.liferay.portlet.messageboards.model.MBCategory"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.liferay.portlet.messageboards.model.MBCategory"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.liferay.portlet.messageboards.model.MBCategory"));
    private String _uuid;
    private String _originalUuid;
    private long _categoryId;
    private long _groupId;
    private long _originalGroupId;
    private boolean _setOriginalGroupId;
    private long _companyId;
    private long _userId;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private long _parentCategoryId;
    private String _name;
    private String _description;
    private int _threadCount;
    private int _messageCount;
    private Date _lastPostDate;
    private long _image_liferay;
    private int _orderNumber;
    private transient ExpandoBridge _expandoBridge;

    public MBCategoryModelImpl() {
    }

    public static MBCategory toModel(MBCategorySoap soapModel) {
        MBCategory model = new MBCategoryImpl();

        model.setUuid(soapModel.getUuid());
        model.setCategoryId(soapModel.getCategoryId());
        model.setGroupId(soapModel.getGroupId());
        model.setCompanyId(soapModel.getCompanyId());
        model.setUserId(soapModel.getUserId());
        model.setUserName(soapModel.getUserName());
        model.setCreateDate(soapModel.getCreateDate());
        model.setModifiedDate(soapModel.getModifiedDate());
        model.setParentCategoryId(soapModel.getParentCategoryId());
        model.setName(soapModel.getName());
        model.setDescription(soapModel.getDescription());
        model.setThreadCount(soapModel.getThreadCount());
        model.setMessageCount(soapModel.getMessageCount());
        model.setLastPostDate(soapModel.getLastPostDate());
        model.setImage_liferay(soapModel.getImage_liferay());
        model.setOrderNumber(soapModel.getOrderNumber());

        return model;
    }

    public static List<MBCategory> toModels(MBCategorySoap[] soapModels) {
        List<MBCategory> models = new ArrayList<MBCategory>(soapModels.length);

        for (MBCategorySoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _categoryId;
    }

    public void setPrimaryKey(long pk) {
        setCategoryId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_categoryId);
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

    public long getCategoryId() {
        return _categoryId;
    }

    public void setCategoryId(long categoryId) {
        _categoryId = categoryId;
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

    public long getParentCategoryId() {
        return _parentCategoryId;
    }

    public void setParentCategoryId(long parentCategoryId) {
        _parentCategoryId = parentCategoryId;
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

    public int getThreadCount() {
        return _threadCount;
    }

    public void setThreadCount(int threadCount) {
        _threadCount = threadCount;
    }

    public int getMessageCount() {
        return _messageCount;
    }

    public void setMessageCount(int messageCount) {
        _messageCount = messageCount;
    }

    public Date getLastPostDate() {
        return _lastPostDate;
    }

    public void setLastPostDate(Date lastPostDate) {
        _lastPostDate = lastPostDate;
    }

    public long getImage_liferay() {
        return _image_liferay;
    }

    public void setImage_liferay(long image_liferay) {
        _image_liferay = image_liferay;
    }

    public int getOrderNumber() {
        return _orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        _orderNumber = orderNumber;
    }

    public MBCategory toEscapedModel() {
        if (isEscapedModel()) {
            return (MBCategory) this;
        } else {
            MBCategory model = new MBCategoryImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setUuid(HtmlUtil.escape(getUuid()));
            model.setCategoryId(getCategoryId());
            model.setGroupId(getGroupId());
            model.setCompanyId(getCompanyId());
            model.setUserId(getUserId());
            model.setUserName(HtmlUtil.escape(getUserName()));
            model.setCreateDate(getCreateDate());
            model.setModifiedDate(getModifiedDate());
            model.setParentCategoryId(getParentCategoryId());
            model.setName(HtmlUtil.escape(getName()));
            model.setDescription(HtmlUtil.escape(getDescription()));
            model.setThreadCount(getThreadCount());
            model.setMessageCount(getMessageCount());
            model.setLastPostDate(getLastPostDate());
            model.setImage_liferay(getImage_liferay());
            model.setOrderNumber(getOrderNumber());

            model = (MBCategory) Proxy.newProxyInstance(MBCategory.class.getClassLoader(),
                    new Class[] { MBCategory.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = new ExpandoBridgeImpl(MBCategory.class.getName(),
                    getPrimaryKey());
        }

        return _expandoBridge;
    }

    public Object clone() {
        MBCategoryImpl clone = new MBCategoryImpl();

        clone.setUuid(getUuid());
        clone.setCategoryId(getCategoryId());
        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());
        clone.setUserId(getUserId());
        clone.setUserName(getUserName());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());
        clone.setParentCategoryId(getParentCategoryId());
        clone.setName(getName());
        clone.setDescription(getDescription());
        clone.setThreadCount(getThreadCount());
        clone.setMessageCount(getMessageCount());
        clone.setLastPostDate(getLastPostDate());
        clone.setImage_liferay(getImage_liferay());
        clone.setOrderNumber(getOrderNumber());

        return clone;
    }

    public int compareTo(MBCategory mbCategory) {
        int value = 0;

        if (getOrderNumber() < mbCategory.getOrderNumber()) {
            value = -1;
        } else if (getOrderNumber() > mbCategory.getOrderNumber()) {
            value = 1;
        } else {
            value = 0;
        }

        if (value != 0) {
            return value;
        }

        value = DateUtil.compareTo(getModifiedDate(),
                mbCategory.getModifiedDate());

        value = value * -1;

        if (value != 0) {
            return value;
        }

        value = getName().toLowerCase()
                    .compareTo(mbCategory.getName().toLowerCase());

        if (value != 0) {
            return value;
        }

        if (getParentCategoryId() < mbCategory.getParentCategoryId()) {
            value = -1;
        } else if (getParentCategoryId() > mbCategory.getParentCategoryId()) {
            value = 1;
        } else {
            value = 0;
        }

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        MBCategory mbCategory = null;

        try {
            mbCategory = (MBCategory) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = mbCategory.getPrimaryKey();

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
        sb.append(", categoryId=");
        sb.append(getCategoryId());
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
        sb.append(", parentCategoryId=");
        sb.append(getParentCategoryId());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", threadCount=");
        sb.append(getThreadCount());
        sb.append(", messageCount=");
        sb.append(getMessageCount());
        sb.append(", lastPostDate=");
        sb.append(getLastPostDate());
        sb.append(", image_liferay=");
        sb.append(getImage_liferay());
        sb.append(", orderNumber=");
        sb.append(getOrderNumber());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBuilder sb = new StringBuilder();

        sb.append("<model><model-name>");
        sb.append("com.liferay.portlet.messageboards.model.MBCategory");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>uuid</column-name><column-value><![CDATA[");
        sb.append(getUuid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>categoryId</column-name><column-value><![CDATA[");
        sb.append(getCategoryId());
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
            "<column><column-name>parentCategoryId</column-name><column-value><![CDATA[");
        sb.append(getParentCategoryId());
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
            "<column><column-name>threadCount</column-name><column-value><![CDATA[");
        sb.append(getThreadCount());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>messageCount</column-name><column-value><![CDATA[");
        sb.append(getMessageCount());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>lastPostDate</column-name><column-value><![CDATA[");
        sb.append(getLastPostDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>image_liferay</column-name><column-value><![CDATA[");
        sb.append(getImage_liferay());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>orderNumber</column-name><column-value><![CDATA[");
        sb.append(getOrderNumber());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}