package com.liferay.portlet.messageboards.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.impl.ExpandoBridgeImpl;
import com.liferay.portlet.messageboards.model.MBThread;
import com.liferay.portlet.messageboards.model.MBThreadSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="MBThreadModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>MBThread</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.liferay.portlet.messageboards.model.MBThread
 * @see com.liferay.portlet.messageboards.model.MBThreadModel
 * @see com.liferay.portlet.messageboards.model.impl.MBThreadImpl
 *
 */
public class MBThreadModelImpl extends BaseModelImpl<MBThread> {
    public static final String TABLE_NAME = "MBThread";
    public static final Object[][] TABLE_COLUMNS = {
            { "threadId", new Integer(Types.BIGINT) },
            

            { "groupId", new Integer(Types.BIGINT) },
            

            { "categoryId", new Integer(Types.BIGINT) },
            

            { "rootMessageId", new Integer(Types.BIGINT) },
            

            { "messageCount", new Integer(Types.INTEGER) },
            

            { "viewCount", new Integer(Types.INTEGER) },
            

            { "lastPostByUserId", new Integer(Types.BIGINT) },
            

            { "lastPostDate", new Integer(Types.TIMESTAMP) },
            

            { "priority", new Integer(Types.DOUBLE) }
        };
    public static final String TABLE_SQL_CREATE = "create table MBThread (threadId LONG not null primary key,groupId LONG,categoryId LONG,rootMessageId LONG,messageCount INTEGER,viewCount INTEGER,lastPostByUserId LONG,lastPostDate DATE null,priority DOUBLE)";
    public static final String TABLE_SQL_DROP = "drop table MBThread";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.entity.cache.enabled.com.liferay.portlet.messageboards.model.MBThread"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.liferay.portlet.messageboards.model.MBThread"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.liferay.portlet.messageboards.model.MBThread"));
    private long _threadId;
    private long _groupId;
    private long _categoryId;
    private long _rootMessageId;
    private int _messageCount;
    private int _viewCount;
    private long _lastPostByUserId;
    private Date _lastPostDate;
    private double _priority;
    private transient ExpandoBridge _expandoBridge;

    public MBThreadModelImpl() {
    }

    public static MBThread toModel(MBThreadSoap soapModel) {
        MBThread model = new MBThreadImpl();

        model.setThreadId(soapModel.getThreadId());
        model.setGroupId(soapModel.getGroupId());
        model.setCategoryId(soapModel.getCategoryId());
        model.setRootMessageId(soapModel.getRootMessageId());
        model.setMessageCount(soapModel.getMessageCount());
        model.setViewCount(soapModel.getViewCount());
        model.setLastPostByUserId(soapModel.getLastPostByUserId());
        model.setLastPostDate(soapModel.getLastPostDate());
        model.setPriority(soapModel.getPriority());

        return model;
    }

    public static List<MBThread> toModels(MBThreadSoap[] soapModels) {
        List<MBThread> models = new ArrayList<MBThread>(soapModels.length);

        for (MBThreadSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _threadId;
    }

    public void setPrimaryKey(long pk) {
        setThreadId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_threadId);
    }

    public long getThreadId() {
        return _threadId;
    }

    public void setThreadId(long threadId) {
        _threadId = threadId;
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    public long getCategoryId() {
        return _categoryId;
    }

    public void setCategoryId(long categoryId) {
        _categoryId = categoryId;
    }

    public long getRootMessageId() {
        return _rootMessageId;
    }

    public void setRootMessageId(long rootMessageId) {
        _rootMessageId = rootMessageId;
    }

    public int getMessageCount() {
        return _messageCount;
    }

    public void setMessageCount(int messageCount) {
        _messageCount = messageCount;
    }

    public int getViewCount() {
        return _viewCount;
    }

    public void setViewCount(int viewCount) {
        _viewCount = viewCount;
    }

    public long getLastPostByUserId() {
        return _lastPostByUserId;
    }

    public void setLastPostByUserId(long lastPostByUserId) {
        _lastPostByUserId = lastPostByUserId;
    }

    public Date getLastPostDate() {
        return _lastPostDate;
    }

    public void setLastPostDate(Date lastPostDate) {
        _lastPostDate = lastPostDate;
    }

    public double getPriority() {
        return _priority;
    }

    public void setPriority(double priority) {
        _priority = priority;
    }

    public MBThread toEscapedModel() {
        if (isEscapedModel()) {
            return (MBThread) this;
        } else {
            MBThread model = new MBThreadImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setThreadId(getThreadId());
            model.setGroupId(getGroupId());
            model.setCategoryId(getCategoryId());
            model.setRootMessageId(getRootMessageId());
            model.setMessageCount(getMessageCount());
            model.setViewCount(getViewCount());
            model.setLastPostByUserId(getLastPostByUserId());
            model.setLastPostDate(getLastPostDate());
            model.setPriority(getPriority());

            model = (MBThread) Proxy.newProxyInstance(MBThread.class.getClassLoader(),
                    new Class[] { MBThread.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = new ExpandoBridgeImpl(MBThread.class.getName(),
                    getPrimaryKey());
        }

        return _expandoBridge;
    }

    public Object clone() {
        MBThreadImpl clone = new MBThreadImpl();

        clone.setThreadId(getThreadId());
        clone.setGroupId(getGroupId());
        clone.setCategoryId(getCategoryId());
        clone.setRootMessageId(getRootMessageId());
        clone.setMessageCount(getMessageCount());
        clone.setViewCount(getViewCount());
        clone.setLastPostByUserId(getLastPostByUserId());
        clone.setLastPostDate(getLastPostDate());
        clone.setPriority(getPriority());

        return clone;
    }

    public int compareTo(MBThread mbThread) {
        int value = 0;

        if (getPriority() < mbThread.getPriority()) {
            value = -1;
        } else if (getPriority() > mbThread.getPriority()) {
            value = 1;
        } else {
            value = 0;
        }

        value = value * -1;

        if (value != 0) {
            return value;
        }

        value = DateUtil.compareTo(getLastPostDate(), mbThread.getLastPostDate());

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

        MBThread mbThread = null;

        try {
            mbThread = (MBThread) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = mbThread.getPrimaryKey();

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

        sb.append("{threadId=");
        sb.append(getThreadId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", categoryId=");
        sb.append(getCategoryId());
        sb.append(", rootMessageId=");
        sb.append(getRootMessageId());
        sb.append(", messageCount=");
        sb.append(getMessageCount());
        sb.append(", viewCount=");
        sb.append(getViewCount());
        sb.append(", lastPostByUserId=");
        sb.append(getLastPostByUserId());
        sb.append(", lastPostDate=");
        sb.append(getLastPostDate());
        sb.append(", priority=");
        sb.append(getPriority());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBuilder sb = new StringBuilder();

        sb.append("<model><model-name>");
        sb.append("com.liferay.portlet.messageboards.model.MBThread");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>threadId</column-name><column-value><![CDATA[");
        sb.append(getThreadId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>groupId</column-name><column-value><![CDATA[");
        sb.append(getGroupId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>categoryId</column-name><column-value><![CDATA[");
        sb.append(getCategoryId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>rootMessageId</column-name><column-value><![CDATA[");
        sb.append(getRootMessageId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>messageCount</column-name><column-value><![CDATA[");
        sb.append(getMessageCount());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>viewCount</column-name><column-value><![CDATA[");
        sb.append(getViewCount());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>lastPostByUserId</column-name><column-value><![CDATA[");
        sb.append(getLastPostByUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>lastPostDate</column-name><column-value><![CDATA[");
        sb.append(getLastPostDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>priority</column-name><column-value><![CDATA[");
        sb.append(getPriority());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
