package com.ext.portlet.meetingcalendar.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="RoomResourceSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.ext.portlet.meetingcalendar.service.http.RoomResourceServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.ext.portlet.meetingcalendar.service.http.RoomResourceServiceSoap
 *
 */
public class RoomResourceSoap implements Serializable {
    private long _roomId;
    private long _companyId;
    private long _userId;
    private Date _createDate;
    private Date _modifiedDate;
    private String _roomName;
    private String _description;

    public RoomResourceSoap() {
    }

    public static RoomResourceSoap toSoapModel(RoomResource model) {
        RoomResourceSoap soapModel = new RoomResourceSoap();

        soapModel.setRoomId(model.getRoomId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setRoomName(model.getRoomName());
        soapModel.setDescription(model.getDescription());

        return soapModel;
    }

    public static RoomResourceSoap[] toSoapModels(List<RoomResource> models) {
        List<RoomResourceSoap> soapModels = new ArrayList<RoomResourceSoap>(models.size());

        for (RoomResource model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new RoomResourceSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _roomId;
    }

    public void setPrimaryKey(long pk) {
        setRoomId(pk);
    }

    public long getRoomId() {
        return _roomId;
    }

    public void setRoomId(long roomId) {
        _roomId = roomId;
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

    public String getRoomName() {
        return _roomName;
    }

    public void setRoomName(String roomName) {
        _roomName = roomName;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }
}
