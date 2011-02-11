package com.sgs.portlet.document.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="PmlDocumentReceiptIssuingPlaceLogSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document.service.http.PmlDocumentReceiptIssuingPlaceLogServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.service.http.PmlDocumentReceiptIssuingPlaceLogServiceSoap
 *
 */
public class PmlDocumentReceiptIssuingPlaceLogSoap implements Serializable {
    private long _documentReceiptIssuingPlaceLogId;
    private long _documentReceiptId;
    private long _processor;
    private long _directProcessorId;
    private Date _dateProcess;
    private String _processInfomation;
    private String _receiver;
    private int _type_;
    private int _step;

    public PmlDocumentReceiptIssuingPlaceLogSoap() {
    }

    public static PmlDocumentReceiptIssuingPlaceLogSoap toSoapModel(
        PmlDocumentReceiptIssuingPlaceLog model) {
        PmlDocumentReceiptIssuingPlaceLogSoap soapModel = new PmlDocumentReceiptIssuingPlaceLogSoap();

        soapModel.setDocumentReceiptIssuingPlaceLogId(model.getDocumentReceiptIssuingPlaceLogId());
        soapModel.setDocumentReceiptId(model.getDocumentReceiptId());
        soapModel.setProcessor(model.getProcessor());
        soapModel.setDirectProcessorId(model.getDirectProcessorId());
        soapModel.setDateProcess(model.getDateProcess());
        soapModel.setProcessInfomation(model.getProcessInfomation());
        soapModel.setReceiver(model.getReceiver());
        soapModel.setType_(model.getType_());
        soapModel.setStep(model.getStep());

        return soapModel;
    }

    public static PmlDocumentReceiptIssuingPlaceLogSoap[] toSoapModels(
        List<PmlDocumentReceiptIssuingPlaceLog> models) {
        List<PmlDocumentReceiptIssuingPlaceLogSoap> soapModels = new ArrayList<PmlDocumentReceiptIssuingPlaceLogSoap>(models.size());

        for (PmlDocumentReceiptIssuingPlaceLog model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlDocumentReceiptIssuingPlaceLogSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _documentReceiptIssuingPlaceLogId;
    }

    public void setPrimaryKey(long pk) {
        setDocumentReceiptIssuingPlaceLogId(pk);
    }

    public long getDocumentReceiptIssuingPlaceLogId() {
        return _documentReceiptIssuingPlaceLogId;
    }

    public void setDocumentReceiptIssuingPlaceLogId(
        long documentReceiptIssuingPlaceLogId) {
        _documentReceiptIssuingPlaceLogId = documentReceiptIssuingPlaceLogId;
    }

    public long getDocumentReceiptId() {
        return _documentReceiptId;
    }

    public void setDocumentReceiptId(long documentReceiptId) {
        _documentReceiptId = documentReceiptId;
    }

    public long getProcessor() {
        return _processor;
    }

    public void setProcessor(long processor) {
        _processor = processor;
    }

    public long getDirectProcessorId() {
        return _directProcessorId;
    }

    public void setDirectProcessorId(long directProcessorId) {
        _directProcessorId = directProcessorId;
    }

    public Date getDateProcess() {
        return _dateProcess;
    }

    public void setDateProcess(Date dateProcess) {
        _dateProcess = dateProcess;
    }

    public String getProcessInfomation() {
        return _processInfomation;
    }

    public void setProcessInfomation(String processInfomation) {
        _processInfomation = processInfomation;
    }

    public String getReceiver() {
        return _receiver;
    }

    public void setReceiver(String receiver) {
        _receiver = receiver;
    }

    public int getType_() {
        return _type_;
    }

    public void setType_(int type_) {
        _type_ = type_;
    }

    public int getStep() {
        return _step;
    }

    public void setStep(int step) {
        _step = step;
    }
}
