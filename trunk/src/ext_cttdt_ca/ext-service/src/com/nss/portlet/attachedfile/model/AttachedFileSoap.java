package com.nss.portlet.attachedfile.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="AttachedFileSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.attachedfile.service.http.AttachedFileServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.attachedfile.service.http.AttachedFileServiceSoap
 *
 */
public class AttachedFileSoap implements Serializable {
    private String _attachedFileId;
    private String _attachedFileCode;
    private String _attachedFileName;
    private String _description;
    private String _active;

    public AttachedFileSoap() {
    }

    public static AttachedFileSoap toSoapModel(AttachedFile model) {
        AttachedFileSoap soapModel = new AttachedFileSoap();

        soapModel.setAttachedFileId(model.getAttachedFileId());
        soapModel.setAttachedFileCode(model.getAttachedFileCode());
        soapModel.setAttachedFileName(model.getAttachedFileName());
        soapModel.setDescription(model.getDescription());
        soapModel.setActive(model.getActive());

        return soapModel;
    }

    public static AttachedFileSoap[] toSoapModels(AttachedFile[] models) {
        AttachedFileSoap[] soapModels = new AttachedFileSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static AttachedFileSoap[][] toSoapModels(AttachedFile[][] models) {
        AttachedFileSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new AttachedFileSoap[models.length][models[0].length];
        } else {
            soapModels = new AttachedFileSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static AttachedFileSoap[] toSoapModels(List<AttachedFile> models) {
        List<AttachedFileSoap> soapModels = new ArrayList<AttachedFileSoap>(models.size());

        for (AttachedFile model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new AttachedFileSoap[soapModels.size()]);
    }

    public String getPrimaryKey() {
        return _attachedFileId;
    }

    public void setPrimaryKey(String pk) {
        setAttachedFileId(pk);
    }

    public String getAttachedFileId() {
        return _attachedFileId;
    }

    public void setAttachedFileId(String attachedFileId) {
        _attachedFileId = attachedFileId;
    }

    public String getAttachedFileCode() {
        return _attachedFileCode;
    }

    public void setAttachedFileCode(String attachedFileCode) {
        _attachedFileCode = attachedFileCode;
    }

    public String getAttachedFileName() {
        return _attachedFileName;
    }

    public void setAttachedFileName(String attachedFileName) {
        _attachedFileName = attachedFileName;
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
