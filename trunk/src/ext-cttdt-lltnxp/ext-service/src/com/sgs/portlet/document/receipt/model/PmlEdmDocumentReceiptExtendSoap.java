package com.sgs.portlet.document.receipt.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="PmlEdmDocumentReceiptExtendSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document.receipt.service.http.PmlEdmDocumentReceiptExtendServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.service.http.PmlEdmDocumentReceiptExtendServiceSoap
 *
 */
public class PmlEdmDocumentReceiptExtendSoap implements Serializable {
    private long _documentReceiptExtendId;
    private long _documentReceiptId;
    private long _documentReceiptLogId;
    private int _extendOrderNo;
    private Date _startProcessDate;
    private int _numDayProcessBef;
    private Date _limitDateBef;
    private String _extendReason;
    private int _numDayProcessAft;
    private Date _limitDateAft;
    private boolean _leanOnLimitDate;
    private long _extendUserId;
    private String _extendDepartmentId;

    public PmlEdmDocumentReceiptExtendSoap() {
    }

    public static PmlEdmDocumentReceiptExtendSoap toSoapModel(
        PmlEdmDocumentReceiptExtend model) {
        PmlEdmDocumentReceiptExtendSoap soapModel = new PmlEdmDocumentReceiptExtendSoap();

        soapModel.setDocumentReceiptExtendId(model.getDocumentReceiptExtendId());
        soapModel.setDocumentReceiptId(model.getDocumentReceiptId());
        soapModel.setDocumentReceiptLogId(model.getDocumentReceiptLogId());
        soapModel.setExtendOrderNo(model.getExtendOrderNo());
        soapModel.setStartProcessDate(model.getStartProcessDate());
        soapModel.setNumDayProcessBef(model.getNumDayProcessBef());
        soapModel.setLimitDateBef(model.getLimitDateBef());
        soapModel.setExtendReason(model.getExtendReason());
        soapModel.setNumDayProcessAft(model.getNumDayProcessAft());
        soapModel.setLimitDateAft(model.getLimitDateAft());
        soapModel.setLeanOnLimitDate(model.getLeanOnLimitDate());
        soapModel.setExtendUserId(model.getExtendUserId());
        soapModel.setExtendDepartmentId(model.getExtendDepartmentId());

        return soapModel;
    }

    public static PmlEdmDocumentReceiptExtendSoap[] toSoapModels(
        List<PmlEdmDocumentReceiptExtend> models) {
        List<PmlEdmDocumentReceiptExtendSoap> soapModels = new ArrayList<PmlEdmDocumentReceiptExtendSoap>(models.size());

        for (PmlEdmDocumentReceiptExtend model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlEdmDocumentReceiptExtendSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _documentReceiptExtendId;
    }

    public void setPrimaryKey(long pk) {
        setDocumentReceiptExtendId(pk);
    }

    public long getDocumentReceiptExtendId() {
        return _documentReceiptExtendId;
    }

    public void setDocumentReceiptExtendId(long documentReceiptExtendId) {
        _documentReceiptExtendId = documentReceiptExtendId;
    }

    public long getDocumentReceiptId() {
        return _documentReceiptId;
    }

    public void setDocumentReceiptId(long documentReceiptId) {
        _documentReceiptId = documentReceiptId;
    }

    public long getDocumentReceiptLogId() {
        return _documentReceiptLogId;
    }

    public void setDocumentReceiptLogId(long documentReceiptLogId) {
        _documentReceiptLogId = documentReceiptLogId;
    }

    public int getExtendOrderNo() {
        return _extendOrderNo;
    }

    public void setExtendOrderNo(int extendOrderNo) {
        _extendOrderNo = extendOrderNo;
    }

    public Date getStartProcessDate() {
        return _startProcessDate;
    }

    public void setStartProcessDate(Date startProcessDate) {
        _startProcessDate = startProcessDate;
    }

    public int getNumDayProcessBef() {
        return _numDayProcessBef;
    }

    public void setNumDayProcessBef(int numDayProcessBef) {
        _numDayProcessBef = numDayProcessBef;
    }

    public Date getLimitDateBef() {
        return _limitDateBef;
    }

    public void setLimitDateBef(Date limitDateBef) {
        _limitDateBef = limitDateBef;
    }

    public String getExtendReason() {
        return _extendReason;
    }

    public void setExtendReason(String extendReason) {
        _extendReason = extendReason;
    }

    public int getNumDayProcessAft() {
        return _numDayProcessAft;
    }

    public void setNumDayProcessAft(int numDayProcessAft) {
        _numDayProcessAft = numDayProcessAft;
    }

    public Date getLimitDateAft() {
        return _limitDateAft;
    }

    public void setLimitDateAft(Date limitDateAft) {
        _limitDateAft = limitDateAft;
    }

    public boolean getLeanOnLimitDate() {
        return _leanOnLimitDate;
    }

    public boolean isLeanOnLimitDate() {
        return _leanOnLimitDate;
    }

    public void setLeanOnLimitDate(boolean leanOnLimitDate) {
        _leanOnLimitDate = leanOnLimitDate;
    }

    public long getExtendUserId() {
        return _extendUserId;
    }

    public void setExtendUserId(long extendUserId) {
        _extendUserId = extendUserId;
    }

    public String getExtendDepartmentId() {
        return _extendDepartmentId;
    }

    public void setExtendDepartmentId(String extendDepartmentId) {
        _extendDepartmentId = extendDepartmentId;
    }
}
