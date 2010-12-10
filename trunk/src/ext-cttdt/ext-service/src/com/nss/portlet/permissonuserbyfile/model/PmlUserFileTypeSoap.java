package com.nss.portlet.permissonuserbyfile.model;

import com.nss.portlet.permissonuserbyfile.service.persistence.PmlUserFileTypePK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlUserFileTypeSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.permissonuserbyfile.service.http.PmlUserFileTypeServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.permissonuserbyfile.service.http.PmlUserFileTypeServiceSoap
 *
 */
public class PmlUserFileTypeSoap implements Serializable {
    private long _userId;
    private String _fileTypeId;
    private String _description;

    public PmlUserFileTypeSoap() {
    }

    public static PmlUserFileTypeSoap toSoapModel(PmlUserFileType model) {
        PmlUserFileTypeSoap soapModel = new PmlUserFileTypeSoap();

        soapModel.setUserId(model.getUserId());
        soapModel.setFileTypeId(model.getFileTypeId());
        soapModel.setDescription(model.getDescription());

        return soapModel;
    }

    public static PmlUserFileTypeSoap[] toSoapModels(PmlUserFileType[] models) {
        PmlUserFileTypeSoap[] soapModels = new PmlUserFileTypeSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static PmlUserFileTypeSoap[][] toSoapModels(
        PmlUserFileType[][] models) {
        PmlUserFileTypeSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new PmlUserFileTypeSoap[models.length][models[0].length];
        } else {
            soapModels = new PmlUserFileTypeSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static PmlUserFileTypeSoap[] toSoapModels(
        List<PmlUserFileType> models) {
        List<PmlUserFileTypeSoap> soapModels = new ArrayList<PmlUserFileTypeSoap>(models.size());

        for (PmlUserFileType model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlUserFileTypeSoap[soapModels.size()]);
    }

    public PmlUserFileTypePK getPrimaryKey() {
        return new PmlUserFileTypePK(_userId, _fileTypeId);
    }

    public void setPrimaryKey(PmlUserFileTypePK pk) {
        setUserId(pk.userId);
        setFileTypeId(pk.fileTypeId);
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public String getFileTypeId() {
        return _fileTypeId;
    }

    public void setFileTypeId(String fileTypeId) {
        _fileTypeId = fileTypeId;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }
}
