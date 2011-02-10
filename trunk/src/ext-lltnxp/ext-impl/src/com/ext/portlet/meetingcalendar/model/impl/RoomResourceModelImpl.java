package com.ext.portlet.meetingcalendar.model.impl;

import com.ext.portlet.meetingcalendar.model.RoomResource;
import com.ext.portlet.meetingcalendar.model.RoomResourceSoap;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="RoomResourceModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>RoomResource</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.ext.portlet.meetingcalendar.model.RoomResource
 * @see com.ext.portlet.meetingcalendar.model.RoomResourceModel
 * @see com.ext.portlet.meetingcalendar.model.impl.RoomResourceImpl
 *
 */
public class RoomResourceModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_room_resource";
    public static final Object[][] TABLE_COLUMNS = {
            { "roomId", new Integer(Types.BIGINT) },
            

            { "companyId", new Integer(Types.BIGINT) },
            

            { "userId", new Integer(Types.BIGINT) },
            

            { "createDate", new Integer(Types.TIMESTAMP) },
            

            { "modifiedDate", new Integer(Types.TIMESTAMP) },
            

            { "roomName", new Integer(Types.VARCHAR) },
            

            { "description", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_room_resource (roomId LONG not null primary key,companyId LONG,userId LONG,createDate DATE null,modifiedDate DATE null,roomName VARCHAR(255) null,description STRING null)";
    public static final String TABLE_SQL_DROP = "drop table pml_room_resource";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.ext.portlet.meetingcalendar.model.RoomResource"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.ext.portlet.meetingcalendar.model.RoomResource"));
    private long _roomId;
    private long _companyId;
    private long _userId;
    private Date _createDate;
    private Date _modifiedDate;
    private String _roomName;
    private String _description;

    public RoomResourceModelImpl() {
    }

    public static RoomResource toModel(RoomResourceSoap soapModel) {
        RoomResource model = new RoomResourceImpl();

        model.setRoomId(soapModel.getRoomId());
        model.setCompanyId(soapModel.getCompanyId());
        model.setUserId(soapModel.getUserId());
        model.setCreateDate(soapModel.getCreateDate());
        model.setModifiedDate(soapModel.getModifiedDate());
        model.setRoomName(soapModel.getRoomName());
        model.setDescription(soapModel.getDescription());

        return model;
    }

    public static List<RoomResource> toModels(RoomResourceSoap[] soapModels) {
        List<RoomResource> models = new ArrayList<RoomResource>(soapModels.length);

        for (RoomResourceSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _roomId;
    }

    public void setPrimaryKey(long pk) {
        setRoomId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_roomId);
    }

    public long getRoomId() {
        return _roomId;
    }

    public void setRoomId(long roomId) {
        if (roomId != _roomId) {
            _roomId = roomId;
        }
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        if (companyId != _companyId) {
            _companyId = companyId;
        }
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        if (userId != _userId) {
            _userId = userId;
        }
    }

    public Date getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(Date createDate) {
        if (((createDate == null) && (_createDate != null)) ||
                ((createDate != null) && (_createDate == null)) ||
                ((createDate != null) && (_createDate != null) &&
                !createDate.equals(_createDate))) {
            _createDate = createDate;
        }
    }

    public Date getModifiedDate() {
        return _modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        if (((modifiedDate == null) && (_modifiedDate != null)) ||
                ((modifiedDate != null) && (_modifiedDate == null)) ||
                ((modifiedDate != null) && (_modifiedDate != null) &&
                !modifiedDate.equals(_modifiedDate))) {
            _modifiedDate = modifiedDate;
        }
    }

    public String getRoomName() {
        return GetterUtil.getString(_roomName);
    }

    public void setRoomName(String roomName) {
        if (((roomName == null) && (_roomName != null)) ||
                ((roomName != null) && (_roomName == null)) ||
                ((roomName != null) && (_roomName != null) &&
                !roomName.equals(_roomName))) {
            _roomName = roomName;
        }
    }

    public String getDescription() {
        return GetterUtil.getString(_description);
    }

    public void setDescription(String description) {
        if (((description == null) && (_description != null)) ||
                ((description != null) && (_description == null)) ||
                ((description != null) && (_description != null) &&
                !description.equals(_description))) {
            _description = description;
        }
    }

    public RoomResource toEscapedModel() {
        if (isEscapedModel()) {
            return (RoomResource) this;
        } else {
            RoomResource model = new RoomResourceImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setRoomId(getRoomId());
            model.setCompanyId(getCompanyId());
            model.setUserId(getUserId());
            model.setCreateDate(getCreateDate());
            model.setModifiedDate(getModifiedDate());
            model.setRoomName(HtmlUtil.escape(getRoomName()));
            model.setDescription(HtmlUtil.escape(getDescription()));

            model = (RoomResource) Proxy.newProxyInstance(RoomResource.class.getClassLoader(),
                    new Class[] { RoomResource.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        RoomResourceImpl clone = new RoomResourceImpl();

        clone.setRoomId(getRoomId());
        clone.setCompanyId(getCompanyId());
        clone.setUserId(getUserId());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());
        clone.setRoomName(getRoomName());
        clone.setDescription(getDescription());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        RoomResourceImpl roomResource = (RoomResourceImpl) obj;

        int value = 0;

        value = getRoomName().compareTo(roomResource.getRoomName());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        RoomResourceImpl roomResource = null;

        try {
            roomResource = (RoomResourceImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = roomResource.getPrimaryKey();

        if (getPrimaryKey() == pk) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (int) getPrimaryKey();
    }
}
