package com.sgs.portlet.document.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlFileStatusSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document.service.http.PmlFileStatusServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.service.http.PmlFileStatusServiceSoap
 *
 */
public class PmlFileStatusSoap implements Serializable {
    private long _fileStatusId;
    private String _fileStatusCode;
    private String _fileStatusName;
    private String _description;
    private String _active;
    private String _type;

    public PmlFileStatusSoap() {
    }

    public static PmlFileStatusSoap toSoapModel(PmlFileStatus model) {
        PmlFileStatusSoap soapModel = new PmlFileStatusSoap();

        soapModel.setFileStatusId(model.getFileStatusId());
        soapModel.setFileStatusCode(model.getFileStatusCode());
        soapModel.setFileStatusName(model.getFileStatusName());
        soapModel.setDescription(model.getDescription());
        soapModel.setActive(model.getActive());
        soapModel.setType(model.getType());

        return soapModel;
    }

    public static PmlFileStatusSoap[] toSoapModels(List<PmlFileStatus> models) {
        List<PmlFileStatusSoap> soapModels = new ArrayList<PmlFileStatusSoap>(models.size());

        for (PmlFileStatus model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlFileStatusSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _fileStatusId;
    }

    public void setPrimaryKey(long pk) {
        setFileStatusId(pk);
    }

    public long getFileStatusId() {
        return _fileStatusId;
    }

    public void setFileStatusId(long fileStatusId) {
        _fileStatusId = fileStatusId;
    }

    public String getFileStatusCode() {
        return _fileStatusCode;
    }

    public void setFileStatusCode(String fileStatusCode) {
        _fileStatusCode = fileStatusCode;
    }

    public String getFileStatusName() {
        return _fileStatusName;
    }

    public void setFileStatusName(String fileStatusName) {
        _fileStatusName = fileStatusName;
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

    public String getType() {
        return _type;
    }

    public void setType(String type) {
        _type = type;
    }
}
