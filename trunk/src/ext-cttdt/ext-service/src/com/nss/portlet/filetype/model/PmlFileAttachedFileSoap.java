package com.nss.portlet.filetype.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlFileAttachedFileSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.filetype.service.http.PmlFileAttachedFileServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.filetype.service.http.PmlFileAttachedFileServiceSoap
 *
 */
public class PmlFileAttachedFileSoap implements Serializable {
    private String _fileAttachedFileId;
    private String _fileId;
    private int _original;
    private int _copy_;
    private String _attachedFileId;
    private String _attachedFileName;
    private String _note;

    public PmlFileAttachedFileSoap() {
    }

    public static PmlFileAttachedFileSoap toSoapModel(PmlFileAttachedFile model) {
        PmlFileAttachedFileSoap soapModel = new PmlFileAttachedFileSoap();

        soapModel.setFileAttachedFileId(model.getFileAttachedFileId());
        soapModel.setFileId(model.getFileId());
        soapModel.setOriginal(model.getOriginal());
        soapModel.setCopy_(model.getCopy_());
        soapModel.setAttachedFileId(model.getAttachedFileId());
        soapModel.setAttachedFileName(model.getAttachedFileName());
        soapModel.setNote(model.getNote());

        return soapModel;
    }

    public static PmlFileAttachedFileSoap[] toSoapModels(
        PmlFileAttachedFile[] models) {
        PmlFileAttachedFileSoap[] soapModels = new PmlFileAttachedFileSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static PmlFileAttachedFileSoap[][] toSoapModels(
        PmlFileAttachedFile[][] models) {
        PmlFileAttachedFileSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new PmlFileAttachedFileSoap[models.length][models[0].length];
        } else {
            soapModels = new PmlFileAttachedFileSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static PmlFileAttachedFileSoap[] toSoapModels(
        List<PmlFileAttachedFile> models) {
        List<PmlFileAttachedFileSoap> soapModels = new ArrayList<PmlFileAttachedFileSoap>(models.size());

        for (PmlFileAttachedFile model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlFileAttachedFileSoap[soapModels.size()]);
    }

    public String getPrimaryKey() {
        return _fileAttachedFileId;
    }

    public void setPrimaryKey(String pk) {
        setFileAttachedFileId(pk);
    }

    public String getFileAttachedFileId() {
        return _fileAttachedFileId;
    }

    public void setFileAttachedFileId(String fileAttachedFileId) {
        _fileAttachedFileId = fileAttachedFileId;
    }

    public String getFileId() {
        return _fileId;
    }

    public void setFileId(String fileId) {
        _fileId = fileId;
    }

    public int getOriginal() {
        return _original;
    }

    public void setOriginal(int original) {
        _original = original;
    }

    public int getCopy_() {
        return _copy_;
    }

    public void setCopy_(int copy_) {
        _copy_ = copy_;
    }

    public String getAttachedFileId() {
        return _attachedFileId;
    }

    public void setAttachedFileId(String attachedFileId) {
        _attachedFileId = attachedFileId;
    }

    public String getAttachedFileName() {
        return _attachedFileName;
    }

    public void setAttachedFileName(String attachedFileName) {
        _attachedFileName = attachedFileName;
    }

    public String getNote() {
        return _note;
    }

    public void setNote(String note) {
        _note = note;
    }
}
