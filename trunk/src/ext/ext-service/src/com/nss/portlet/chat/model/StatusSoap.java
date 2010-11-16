package com.nss.portlet.chat.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="StatusSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.chat.service.http.StatusServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.chat.service.http.StatusServiceSoap
 *
 */
public class StatusSoap implements Serializable {
    private long _statusId;
    private long _userId;
    private long _modifiedDate;
    private boolean _online;
    private boolean _awake;
    private String _activePanelId;
    private String _message;
    private boolean _playSound;

    public StatusSoap() {
    }

    public static StatusSoap toSoapModel(Status model) {
        StatusSoap soapModel = new StatusSoap();

        soapModel.setStatusId(model.getStatusId());
        soapModel.setUserId(model.getUserId());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setOnline(model.getOnline());
        soapModel.setAwake(model.getAwake());
        soapModel.setActivePanelId(model.getActivePanelId());
        soapModel.setMessage(model.getMessage());
        soapModel.setPlaySound(model.getPlaySound());

        return soapModel;
    }

    public static StatusSoap[] toSoapModels(Status[] models) {
        StatusSoap[] soapModels = new StatusSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static StatusSoap[][] toSoapModels(Status[][] models) {
        StatusSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new StatusSoap[models.length][models[0].length];
        } else {
            soapModels = new StatusSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static StatusSoap[] toSoapModels(List<Status> models) {
        List<StatusSoap> soapModels = new ArrayList<StatusSoap>(models.size());

        for (Status model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new StatusSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _statusId;
    }

    public void setPrimaryKey(long pk) {
        setStatusId(pk);
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
        return _activePanelId;
    }

    public void setActivePanelId(String activePanelId) {
        _activePanelId = activePanelId;
    }

    public String getMessage() {
        return _message;
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
}
