package com.nss.portlet.filetype.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlFileTypeAttachedFileSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.filetype.service.http.PmlFileTypeAttachedFileServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.filetype.service.http.PmlFileTypeAttachedFileServiceSoap
 *
 */
public class PmlFileTypeAttachedFileSoap implements Serializable {
    private String _filetypeAttachedFileId;
    private String _fileTypeId;
    private int _original;
    private int _copy_;
    private String _attachedFileId;
    private String _attachedFileName;
    private String _note;

    public PmlFileTypeAttachedFileSoap() {
    }

    public static PmlFileTypeAttachedFileSoap toSoapModel(
        PmlFileTypeAttachedFile model) {
        PmlFileTypeAttachedFileSoap soapModel = new PmlFileTypeAttachedFileSoap();

        soapModel.setFiletypeAttachedFileId(model.getFiletypeAttachedFileId());
        soapModel.setFileTypeId(model.getFileTypeId());
        soapModel.setOriginal(model.getOriginal());
        soapModel.setCopy_(model.getCopy_());
        soapModel.setAttachedFileId(model.getAttachedFileId());
        soapModel.setAttachedFileName(model.getAttachedFileName());
        soapModel.setNote(model.getNote());

        return soapModel;
    }

    public static PmlFileTypeAttachedFileSoap[] toSoapModels(
        PmlFileTypeAttachedFile[] models) {
        PmlFileTypeAttachedFileSoap[] soapModels = new PmlFileTypeAttachedFileSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static PmlFileTypeAttachedFileSoap[][] toSoapModels(
        PmlFileTypeAttachedFile[][] models) {
        PmlFileTypeAttachedFileSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new PmlFileTypeAttachedFileSoap[models.length][models[0].length];
        } else {
            soapModels = new PmlFileTypeAttachedFileSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static PmlFileTypeAttachedFileSoap[] toSoapModels(
        List<PmlFileTypeAttachedFile> models) {
        List<PmlFileTypeAttachedFileSoap> soapModels = new ArrayList<PmlFileTypeAttachedFileSoap>(models.size());

        for (PmlFileTypeAttachedFile model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlFileTypeAttachedFileSoap[soapModels.size()]);
    }

    public String getPrimaryKey() {
        return _filetypeAttachedFileId;
    }

    public void setPrimaryKey(String pk) {
        setFiletypeAttachedFileId(pk);
    }

    public String getFiletypeAttachedFileId() {
        return _filetypeAttachedFileId;
    }

    public void setFiletypeAttachedFileId(String filetypeAttachedFileId) {
        _filetypeAttachedFileId = filetypeAttachedFileId;
    }

    public String getFileTypeId() {
        return _fileTypeId;
    }

    public void setFileTypeId(String fileTypeId) {
        _fileTypeId = fileTypeId;
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
