package com.nss.portlet.chat.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.impl.ExpandoBridgeImpl;

import com.nss.portlet.chat.model.Status;
import com.nss.portlet.chat.model.StatusSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="StatusModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>Status</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.chat.model.Status
 * @see com.nss.portlet.chat.model.StatusModel
 * @see com.nss.portlet.chat.model.impl.StatusImpl
 *
 */
public class StatusModelImpl extends BaseModelImpl<Status> {
    public static final String TABLE_NAME = "chat_status";
    public static final Object[][] TABLE_COLUMNS = {
            { "statusId", new Integer(Types.BIGINT) },
            

            { "userId", new Integer(Types.BIGINT) },
            

            { "modifiedDate", new Integer(Types.BIGINT) },
            

            { "online_", new Integer(Types.BOOLEAN) },
            

            { "awake", new Integer(Types.BOOLEAN) },
            

            { "activePanelId", new Integer(Types.VARCHAR) },
            

            { "message", new Integer(Types.VARCHAR) },
            

            { "playSound", new Integer(Types.BOOLEAN) }
        };
    public static final String TABLE_SQL_CREATE = "create table chat_status (statusId LONG not null primary key,userId LONG,modifiedDate LONG,online_ BOOLEAN,awake BOOLEAN,activePanelId VARCHAR(75) null,message VARCHAR(75) null,playSound BOOLEAN)";
    public static final String TABLE_SQL_DROP = "drop table chat_status";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.entity.cache.enabled.com.nss.portlet.chat.model.Status"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.nss.portlet.chat.model.Status"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.nss.portlet.chat.model.Status"));
    private long _statusId;
    private long _userId;
    private long _originalUserId;
    private boolean _setOriginalUserId;
    private long _modifiedDate;
    private boolean _online;
    private boolean _awake;
    private String _activePanelId;
    private String _message;
    private boolean _playSound;
    private transient ExpandoBridge _expandoBridge;

    public StatusModelImpl() {
    }

    public static Status toModel(StatusSoap soapModel) {
        Status model = new StatusImpl();

        model.setStatusId(soapModel.getStatusId());
        model.setUserId(soapModel.getUserId());
        model.setModifiedDate(soapModel.getModifiedDate());
        model.setOnline(soapModel.getOnline());
        model.setAwake(soapModel.getAwake());
        model.setActivePanelId(soapModel.getActivePanelId());
        model.setMessage(soapModel.getMessage());
        model.setPlaySound(soapModel.getPlaySound());

        return model;
    }

    public static List<Status> toModels(StatusSoap[] soapModels) {
        List<Status> models = new ArrayList<Status>(soapModels.length);

        for (StatusSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _statusId;
    }

    public void setPrimaryKey(long pk) {
        setStatusId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_statusId);
    }

    public long getStatusId() {
        return _statusId;
    }

    public void setStatusId(long statusId) {
        _statusId = statusId;
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

    public long getModifiedDate() {
        return _modifiedDate;
    }

    public void setModifiedDate(long modifiedDate) {
        _modifiedDate = modifiedDate;
    }

    public boolean getOnline() {
        return _online;
    }

    public boolean isOnline() {
        return _online;
    }

    public void setOnline(boolean online) {
        _online = online;
    }

    public boolean getAwake() {
        return _awake;
    }

    public boolean isAwake() {
        return _awake;
    }

    public void setAwake(boolean awake) {
        _awake = awake;
    }

    public String getActivePanelId() {
        return GetterUtil.getString(_activePanelId);
    }

    public void setActivePanelId(String activePanelId) {
        _activePanelId = activePanelId;
    }

    public String getMessage() {
        return GetterUtil.getString(_message);
    }

    public void setMessage(String message) {
        _message = message;
    }

    public boolean getPlaySound() {
        return _playSound;
    }

    public boolean isPlaySound() {
        return _playSound;
    }

    public void setPlaySound(boolean playSound) {
        _playSound = playSound;
    }

    public Status toEscapedModel() {
        if (isEscapedModel()) {
            return (Status) this;
        } else {
            Status model = new StatusImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setStatusId(getStatusId());
            model.setUserId(getUserId());
            model.setModifiedDate(getModifiedDate());
            model.setOnline(getOnline());
            model.setAwake(getAwake());
            model.setActivePanelId(HtmlUtil.escape(getActivePanelId()));
            model.setMessage(HtmlUtil.escape(getMessage()));
            model.setPlaySound(getPlaySound());

            model = (Status) Proxy.newProxyInstance(Status.class.getClassLoader(),
                    new Class[] { Status.class }, new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = new ExpandoBridgeImpl(Status.class.getName(),
                    getPrimaryKey());
        }

        return _expandoBridge;
    }

    public Object clone() {
        StatusImpl clone = new StatusImpl();

        clone.setStatusId(getStatusId());
        clone.setUserId(getUserId());
        clone.setModifiedDate(getModifiedDate());
        clone.setOnline(getOnline());
        clone.setAwake(getAwake());
        clone.setActivePanelId(getActivePanelId());
        clone.setMessage(getMessage());
        clone.setPlaySound(getPlaySound());

        return clone;
    }

    public int compareTo(Status status) {
        long pk = status.getPrimaryKey();

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

        Status status = null;

        try {
            status = (Status) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = status.getPrimaryKey();

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

        sb.append("{statusId=");
        sb.append(getStatusId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", modifiedDate=");
        sb.append(getModifiedDate());
        sb.append(", online=");
        sb.append(getOnline());
        sb.append(", awake=");
        sb.append(getAwake());
        sb.append(", activePanelId=");
        sb.append(getActivePanelId());
        sb.append(", message=");
        sb.append(getMessage());
        sb.append(", playSound=");
        sb.append(getPlaySound());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBuilder sb = new StringBuilder();

        sb.append("<model><model-name>");
        sb.append("com.nss.portlet.chat.model.Status");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>statusId</column-name><column-value><![CDATA[");
        sb.append(getStatusId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
        sb.append(getModifiedDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>online</column-name><column-value><![CDATA[");
        sb.append(getOnline());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>awake</column-name><column-value><![CDATA[");
        sb.append(getAwake());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>activePanelId</column-name><column-value><![CDATA[");
        sb.append(getActivePanelId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>message</column-name><column-value><![CDATA[");
        sb.append(getMessage());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>playSound</column-name><column-value><![CDATA[");
        sb.append(getPlaySound());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
