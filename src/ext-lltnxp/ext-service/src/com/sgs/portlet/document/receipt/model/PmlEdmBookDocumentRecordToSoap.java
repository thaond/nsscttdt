package com.sgs.portlet.document.receipt.model;

import com.sgs.portlet.document.receipt.service.persistence.PmlEdmBookDocumentRecordToPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="PmlEdmBookDocumentRecordToSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document.receipt.service.http.PmlEdmBookDocumentRecordToServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.service.http.PmlEdmBookDocumentRecordToServiceSoap
 *
 */
public class PmlEdmBookDocumentRecordToSoap implements Serializable {
    private long _documentReceiptId;
    private long _documentRecordToId;
    private Date _dateCreate;
    private Date _dateComplete;
    private int _soCongVanDenPhongHienTai;

    public PmlEdmBookDocumentRecordToSoap() {
    }

    public static PmlEdmBookDocumentRecordToSoap toSoapModel(
        PmlEdmBookDocumentRecordTo model) {
        PmlEdmBookDocumentRecordToSoap soapModel = new PmlEdmBookDocumentRecordToSoap();

        soapModel.setDocumentReceiptId(model.getDocumentReceiptId());
        soapModel.setDocumentRecordToId(model.getDocumentRecordToId());
        soapModel.setDateCreate(model.getDateCreate());
        soapModel.setDateComplete(model.getDateComplete());
        soapModel.setSoCongVanDenPhongHienTai(model.getSoCongVanDenPhongHienTai());

        return soapModel;
    }

    public static PmlEdmBookDocumentRecordToSoap[] toSoapModels(
        List<PmlEdmBookDocumentRecordTo> models) {
        List<PmlEdmBookDocumentRecordToSoap> soapModels = new ArrayList<PmlEdmBookDocumentRecordToSoap>(models.size());

        for (PmlEdmBookDocumentRecordTo model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlEdmBookDocumentRecordToSoap[soapModels.size()]);
    }

    public PmlEdmBookDocumentRecordToPK getPrimaryKey() {
        return new PmlEdmBookDocumentRecordToPK(_documentReceiptId,
            _documentRecordToId);
    }

    public void setPrimaryKey(PmlEdmBookDocumentRecordToPK pk) {
        setDocumentReceiptId(pk.documentReceiptId);
        setDocumentRecordToId(pk.documentRecordToId);
    }

    public long getDocumentReceiptId() {
        return _documentReceiptId;
    }

    public void setDocumentReceiptId(long documentReceiptId) {
        _documentReceiptId = documentReceiptId;
    }

    public long getDocumentRecordToId() {
        return _documentRecordToId;
    }

    public void setDocumentRecordToId(long documentRecordToId) {
        _documentRecordToId = documentRecordToId;
    }

    public Date getDateCreate() {
        return _dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        _dateCreate = dateCreate;
    }

    public Date getDateComplete() {
        return _dateComplete;
    }

    public void setDateComplete(Date dateComplete) {
        _dateComplete = dateComplete;
    }

    public int getSoCongVanDenPhongHienTai() {
        return _soCongVanDenPhongHienTai;
    }

    public void setSoCongVanDenPhongHienTai(int soCongVanDenPhongHienTai) {
        _soCongVanDenPhongHienTai = soCongVanDenPhongHienTai;
    }
}
