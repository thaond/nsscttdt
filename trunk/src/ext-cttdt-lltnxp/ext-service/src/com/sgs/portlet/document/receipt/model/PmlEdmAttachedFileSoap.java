package com.sgs.portlet.document.receipt.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="PmlEdmAttachedFileSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document.receipt.service.http.PmlEdmAttachedFileServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.service.http.PmlEdmAttachedFileServiceSoap
 *
 */
public class PmlEdmAttachedFileSoap implements Serializable {
    private long _attachedFileId;
    private long _objectContentId;
    private String _objectType;
    private String _attachedFileName;
    private String _path;
    private Date _dateCreated;
    private String _fileType;
    private int _fileId;
    private String _title;
    private boolean _displayOrHidden;

    public PmlEdmAttachedFileSoap() {
    }

    public static PmlEdmAttachedFileSoap toSoapModel(PmlEdmAttachedFile model) {
        PmlEdmAttachedFileSoap soapModel = new PmlEdmAttachedFileSoap();

        soapModel.setAttachedFileId(model.getAttachedFileId());
        soapModel.setObjectContentId(model.getObjectContentId());
        soapModel.setObjectType(model.getObjectType());
        soapModel.setAttachedFileName(model.getAttachedFileName());
        soapModel.setPath(model.getPath());
        soapModel.setDateCreated(model.getDateCreated());
        soapModel.setFileType(model.getFileType());
        soapModel.setFileId(model.getFileId());
        soapModel.setTitle(model.getTitle());
        soapModel.setDisplayOrHidden(model.getDisplayOrHidden());

        return soapModel;
    }

    public static PmlEdmAttachedFileSoap[] toSoapModels(
        List<PmlEdmAttachedFile> models) {
        List<PmlEdmAttachedFileSoap> soapModels = new ArrayList<PmlEdmAttachedFileSoap>(models.size());

        for (PmlEdmAttachedFile model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlEdmAttachedFileSoap[soapModels.size()]);
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

    public long getObjectContentId() {
        return _objectContentId;
    }

    public void setObjectContentId(long objectContentId) {
        _objectContentId = objectContentId;
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

    public int getFileId() {
        return _fileId;
    }

    public void setFileId(int fileId) {
        _fileId = fileId;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        _title = title;
    }

    public boolean getDisplayOrHidden() {
        return _displayOrHidden;
    }

    public boolean isDisplayOrHidden() {
        return _displayOrHidden;
    }

    public void setDisplayOrHidden(boolean displayOrHidden) {
        _displayOrHidden = displayOrHidden;
    }
}
