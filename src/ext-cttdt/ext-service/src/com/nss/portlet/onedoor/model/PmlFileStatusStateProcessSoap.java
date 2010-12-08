package com.nss.portlet.onedoor.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlFileStatusStateProcessSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.onedoor.service.http.PmlFileStatusStateProcessServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.onedoor.service.http.PmlFileStatusStateProcessServiceSoap
 *
 */
public class PmlFileStatusStateProcessSoap implements Serializable {
    private long _id;
    private long _fileStatusId;
    private long _stateProcessId;
    private String _description;

    public PmlFileStatusStateProcessSoap() {
    }

    public static PmlFileStatusStateProcessSoap toSoapModel(
        PmlFileStatusStateProcess model) {
        PmlFileStatusStateProcessSoap soapModel = new PmlFileStatusStateProcessSoap();

        soapModel.setId(model.getId());
        soapModel.setFileStatusId(model.getFileStatusId());
        soapModel.setStateProcessId(model.getStateProcessId());
        soapModel.setDescription(model.getDescription());

        return soapModel;
    }

    public static PmlFileStatusStateProcessSoap[] toSoapModels(
        PmlFileStatusStateProcess[] models) {
        PmlFileStatusStateProcessSoap[] soapModels = new PmlFileStatusStateProcessSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static PmlFileStatusStateProcessSoap[][] toSoapModels(
        PmlFileStatusStateProcess[][] models) {
        PmlFileStatusStateProcessSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new PmlFileStatusStateProcessSoap[models.length][models[0].length];
        } else {
            soapModels = new PmlFileStatusStateProcessSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static PmlFileStatusStateProcessSoap[] toSoapModels(
        List<PmlFileStatusStateProcess> models) {
        List<PmlFileStatusStateProcessSoap> soapModels = new ArrayList<PmlFileStatusStateProcessSoap>(models.size());

        for (PmlFileStatusStateProcess model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlFileStatusStateProcessSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _id;
    }

    public void setPrimaryKey(long pk) {
        setId(pk);
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public long getFileStatusId() {
        return _fileStatusId;
    }

    public void setFileStatusId(long fileStatusId) {
        _fileStatusId = fileStatusId;
    }

    public long getStateProcessId() {
        return _stateProcessId;
    }

    public void setStateProcessId(long stateProcessId) {
        _stateProcessId = stateProcessId;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }
}
