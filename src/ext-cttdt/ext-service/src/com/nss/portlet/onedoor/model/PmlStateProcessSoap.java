package com.nss.portlet.onedoor.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlStateProcessSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.onedoor.service.http.PmlStateProcessServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.onedoor.service.http.PmlStateProcessServiceSoap
 *
 */
public class PmlStateProcessSoap implements Serializable {
    private long _stateProcessId;
    private String _stateProcessCode;
    private String _stateProcessName;
    private long _fileStatusId;
    private String _description;
    private String _active;

    public PmlStateProcessSoap() {
    }

    public static PmlStateProcessSoap toSoapModel(PmlStateProcess model) {
        PmlStateProcessSoap soapModel = new PmlStateProcessSoap();

        soapModel.setStateProcessId(model.getStateProcessId());
        soapModel.setStateProcessCode(model.getStateProcessCode());
        soapModel.setStateProcessName(model.getStateProcessName());
        soapModel.setFileStatusId(model.getFileStatusId());
        soapModel.setDescription(model.getDescription());
        soapModel.setActive(model.getActive());

        return soapModel;
    }

    public static PmlStateProcessSoap[] toSoapModels(PmlStateProcess[] models) {
        PmlStateProcessSoap[] soapModels = new PmlStateProcessSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static PmlStateProcessSoap[][] toSoapModels(
        PmlStateProcess[][] models) {
        PmlStateProcessSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new PmlStateProcessSoap[models.length][models[0].length];
        } else {
            soapModels = new PmlStateProcessSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static PmlStateProcessSoap[] toSoapModels(
        List<PmlStateProcess> models) {
        List<PmlStateProcessSoap> soapModels = new ArrayList<PmlStateProcessSoap>(models.size());

        for (PmlStateProcess model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlStateProcessSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _stateProcessId;
    }

    public void setPrimaryKey(long pk) {
        setStateProcessId(pk);
    }

    public long getStateProcessId() {
        return _stateProcessId;
    }

    public void setStateProcessId(long stateProcessId) {
        _stateProcessId = stateProcessId;
    }

    public String getStateProcessCode() {
        return _stateProcessCode;
    }

    public void setStateProcessCode(String stateProcessCode) {
        _stateProcessCode = stateProcessCode;
    }

    public String getStateProcessName() {
        return _stateProcessName;
    }

    public void setStateProcessName(String stateProcessName) {
        _stateProcessName = stateProcessName;
    }

    public long getFileStatusId() {
        return _fileStatusId;
    }

    public void setFileStatusId(long fileStatusId) {
        _fileStatusId = fileStatusId;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public String getActive() {
        return _active;
    }

    public void setActive(String active) {
        _active = active;
    }
}
