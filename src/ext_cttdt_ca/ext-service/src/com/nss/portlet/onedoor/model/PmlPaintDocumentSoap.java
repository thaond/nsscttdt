package com.nss.portlet.onedoor.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlPaintDocumentSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.onedoor.service.http.PmlPaintDocumentServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.onedoor.service.http.PmlPaintDocumentServiceSoap
 *
 */
public class PmlPaintDocumentSoap implements Serializable {
    private long _paintDocumentId;
    private String _fileId;
    private String _paintDocumentName;
    private int _quantity;
    private String _note;

    public PmlPaintDocumentSoap() {
    }

    public static PmlPaintDocumentSoap toSoapModel(PmlPaintDocument model) {
        PmlPaintDocumentSoap soapModel = new PmlPaintDocumentSoap();

        soapModel.setPaintDocumentId(model.getPaintDocumentId());
        soapModel.setFileId(model.getFileId());
        soapModel.setPaintDocumentName(model.getPaintDocumentName());
        soapModel.setQuantity(model.getQuantity());
        soapModel.setNote(model.getNote());

        return soapModel;
    }

    public static PmlPaintDocumentSoap[] toSoapModels(PmlPaintDocument[] models) {
        PmlPaintDocumentSoap[] soapModels = new PmlPaintDocumentSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static PmlPaintDocumentSoap[][] toSoapModels(
        PmlPaintDocument[][] models) {
        PmlPaintDocumentSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new PmlPaintDocumentSoap[models.length][models[0].length];
        } else {
            soapModels = new PmlPaintDocumentSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static PmlPaintDocumentSoap[] toSoapModels(
        List<PmlPaintDocument> models) {
        List<PmlPaintDocumentSoap> soapModels = new ArrayList<PmlPaintDocumentSoap>(models.size());

        for (PmlPaintDocument model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlPaintDocumentSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _paintDocumentId;
    }

    public void setPrimaryKey(long pk) {
        setPaintDocumentId(pk);
    }

    public long getPaintDocumentId() {
        return _paintDocumentId;
    }

    public void setPaintDocumentId(long paintDocumentId) {
        _paintDocumentId = paintDocumentId;
    }

    public String getFileId() {
        return _fileId;
    }

    public void setFileId(String fileId) {
        _fileId = fileId;
    }

    public String getPaintDocumentName() {
        return _paintDocumentName;
    }

    public void setPaintDocumentName(String paintDocumentName) {
        _paintDocumentName = paintDocumentName;
    }

    public int getQuantity() {
        return _quantity;
    }

    public void setQuantity(int quantity) {
        _quantity = quantity;
    }

    public String getNote() {
        return _note;
    }

    public void setNote(String note) {
        _note = note;
    }
}
