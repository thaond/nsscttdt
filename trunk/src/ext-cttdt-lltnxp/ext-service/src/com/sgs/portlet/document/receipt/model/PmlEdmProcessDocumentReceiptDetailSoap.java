package com.sgs.portlet.document.receipt.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="PmlEdmProcessDocumentReceiptDetailSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document.receipt.service.http.PmlEdmProcessDocumentReceiptDetailServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.service.http.PmlEdmProcessDocumentReceiptDetailServiceSoap
 *
 */
public class PmlEdmProcessDocumentReceiptDetailSoap implements Serializable {
    private long _id;
    private long _documentReceiptId;
    private long _userId;
    private String _note;
    private Date _dateCreated;
    private Date _dateUpdate;

    public PmlEdmProcessDocumentReceiptDetailSoap() {
    }

    public static PmlEdmProcessDocumentReceiptDetailSoap toSoapModel(
        PmlEdmProcessDocumentReceiptDetail model) {
        PmlEdmProcessDocumentReceiptDetailSoap soapModel = new PmlEdmProcessDocumentReceiptDetailSoap();

        soapModel.setId(model.getId());
        soapModel.setDocumentReceiptId(model.getDocumentReceiptId());
        soapModel.setUserId(model.getUserId());
        soapModel.setNote(model.getNote());
        soapModel.setDateCreated(model.getDateCreated());
        soapModel.setDateUpdate(model.getDateUpdate());

        return soapModel;
    }

    public static PmlEdmProcessDocumentReceiptDetailSoap[] toSoapModels(
        List<PmlEdmProcessDocumentReceiptDetail> models) {
        List<PmlEdmProcessDocumentReceiptDetailSoap> soapModels = new ArrayList<PmlEdmProcessDocumentReceiptDetailSoap>(models.size());

        for (PmlEdmProcessDocumentReceiptDetail model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlEdmProcessDocumentReceiptDetailSoap[soapModels.size()]);
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

    public long getDocumentReceiptId() {
        return _documentReceiptId;
    }

    public void setDocumentReceiptId(long documentReceiptId) {
        _documentReceiptId = documentReceiptId;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public String getNote() {
        return _note;
    }

    public void setNote(String note) {
        _note = note;
    }

    public Date getDateCreated() {
        return _dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        _dateCreated = dateCreated;
    }

    public Date getDateUpdate() {
        return _dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        _dateUpdate = dateUpdate;
    }
}
