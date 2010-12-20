package com.nss.portlet.onedoor.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="PmlFilePCCCAttachedFileSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.onedoor.service.http.PmlFilePCCCAttachedFileServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.onedoor.service.http.PmlFilePCCCAttachedFileServiceSoap
 *
 */
public class PmlFilePCCCAttachedFileSoap implements Serializable {
    private long _attachedFileId;
    private String _filePcccId;
    private String _objectType;
    private String _attachedFileName;
    private String _path;
    private Date _dateCreated;
    private String _fileType;
    private String _title;

    public PmlFilePCCCAttachedFileSoap() {
    }

    public static PmlFilePCCCAttachedFileSoap toSoapModel(
        PmlFilePCCCAttachedFile model) {
        PmlFilePCCCAttachedFileSoap soapModel = new PmlFilePCCCAttachedFileSoap();

        soapModel.setAttachedFileId(model.getAttachedFileId());
        soapModel.setFilePcccId(model.getFilePcccId());
        soapModel.setObjectType(model.getObjectType());
        soapModel.setAttachedFileName(model.getAttachedFileName());
        soapModel.setPath(model.getPath());
        soapModel.setDateCreated(model.getDateCreated());
        soapModel.setFileType(model.getFileType());
        soapModel.setTitle(model.getTitle());

        return soapModel;
    }

    public static PmlFilePCCCAttachedFileSoap[] toSoapModels(
        PmlFilePCCCAttachedFile[] models) {
        PmlFilePCCCAttachedFileSoap[] soapModels = new PmlFilePCCCAttachedFileSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static PmlFilePCCCAttachedFileSoap[][] toSoapModels(
        PmlFilePCCCAttachedFile[][] models) {
        PmlFilePCCCAttachedFileSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new PmlFilePCCCAttachedFileSoap[models.length][models[0].length];
        } else {
            soapModels = new PmlFilePCCCAttachedFileSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static PmlFilePCCCAttachedFileSoap[] toSoapModels(
        List<PmlFilePCCCAttachedFile> models) {
        List<PmlFilePCCCAttachedFileSoap> soapModels = new ArrayList<PmlFilePCCCAttachedFileSoap>(models.size());

        for (PmlFilePCCCAttachedFile model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlFilePCCCAttachedFileSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _attachedFileId;
    }

    public void setPrimaryKey(long pk) {
        setAttachedFileId(pk);
    }

    public long getAttachedFileId() {
        return _attachedFileId;
    }

    public void setAttachedFileId(long attachedFileId) {
        _attachedFileId = attachedFileId;
    }

    public String getFilePcccId() {
        return _filePcccId;
    }

    public void setFilePcccId(String filePcccId) {
        _filePcccId = filePcccId;
    }

    public String getObjectType() {
        return _objectType;
    }

    public void setObjectType(String objectType) {
        _objectType = objectType;
    }

    public String getAttachedFileName() {
        return _attachedFileName;
    }

    public void setAttachedFileName(String attachedFileName) {
        _attachedFileName = attachedFileName;
    }

    public String getPath() {
        return _path;
    }

    public void setPath(String path) {
        _path = path;
    }

    public Date getDateCreated() {
        return _dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        _dateCreated = dateCreated;
    }

    public String getFileType() {
        return _fileType;
    }

    public void setFileType(String fileType) {
        _fileType = fileType;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        _title = title;
    }
}
