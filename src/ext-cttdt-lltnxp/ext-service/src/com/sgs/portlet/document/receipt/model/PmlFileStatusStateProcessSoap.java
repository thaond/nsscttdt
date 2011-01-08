package com.sgs.portlet.document.receipt.model;

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
 * <code>com.sgs.portlet.document.receipt.service.http.PmlFileStatusStateProcessServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.service.http.PmlFileStatusStateProcessServiceSoap
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
