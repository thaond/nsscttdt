package com.sgs.portlet.document.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="PmlDocumentReceiptLogSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document.service.http.PmlDocumentReceiptLogServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.service.http.PmlDocumentReceiptLogServiceSoap
 *
 */
public class PmlDocumentReceiptLogSoap implements Serializable {
    private long _documentReceiptLogId;
    private long _documentReceiptId;
    private int _transition_;
    private long _processer;
    private Date _dateProcess;
    private String _processInfomation;
    private long _receiver;
    private Date _receiveDate;
    private long _stateProcessIdBefore;
    private long _stateProcessIdAfter;
    private int _type_;
    private Date _expiredDate;
    private int _numDateProcess;
    private long _processInstanceId;
    private String _mainDepartmentProcessId;
    private long _mainUserProcessId;
    private Date _sendDateBefore;
    private String _departmentReceiveId;
    private String _departmentProcessId;
    private Date _dateProcessTime;
    private Date _receiveDateTime;
    private long _directProcesserId;
    private int _step;

    public PmlDocumentReceiptLogSoap() {
    }

    public static PmlDocumentReceiptLogSoap toSoapModel(
        PmlDocumentReceiptLog model) {
        PmlDocumentReceiptLogSoap soapModel = new PmlDocumentReceiptLogSoap();

        soapModel.setDocumentReceiptLogId(model.getDocumentReceiptLogId());
        soapModel.setDocumentReceiptId(model.getDocumentReceiptId());
        soapModel.setTransition_(model.getTransition_());
        soapModel.setProcesser(model.getProcesser());
        soapModel.setDateProcess(model.getDateProcess());
        soapModel.setProcessInfomation(model.getProcessInfomation());
        soapModel.setReceiver(model.getReceiver());
        soapModel.setReceiveDate(model.getReceiveDate());
        soapModel.setStateProcessIdBefore(model.getStateProcessIdBefore());
        soapModel.setStateProcessIdAfter(model.getStateProcessIdAfter());
        soapModel.setType_(model.getType_());
        soapModel.setExpiredDate(model.getExpiredDate());
        soapModel.setNumDateProcess(model.getNumDateProcess());
        soapModel.setProcessInstanceId(model.getProcessInstanceId());
        soapModel.setMainDepartmentProcessId(model.getMainDepartmentProcessId());
        soapModel.setMainUserProcessId(model.getMainUserProcessId());
        soapModel.setSendDateBefore(model.getSendDateBefore());
        soapModel.setDepartmentReceiveId(model.getDepartmentReceiveId());
        soapModel.setDepartmentProcessId(model.getDepartmentProcessId());
        soapModel.setDateProcessTime(model.getDateProcessTime());
        soapModel.setReceiveDateTime(model.getReceiveDateTime());
        soapModel.setDirectProcesserId(model.getDirectProcesserId());
        soapModel.setStep(model.getStep());

        return soapModel;
    }

    public static PmlDocumentReceiptLogSoap[] toSoapModels(
        List<PmlDocumentReceiptLog> models) {
        List<PmlDocumentReceiptLogSoap> soapModels = new ArrayList<PmlDocumentReceiptLogSoap>(models.size());

        for (PmlDocumentReceiptLog model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlDocumentReceiptLogSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _documentReceiptLogId;
    }

    public void setPrimaryKey(long pk) {
        setDocumentReceiptLogId(pk);
    }

    public long getDocumentReceiptLogId() {
        return _documentReceiptLogId;
    }

    public void setDocumentReceiptLogId(long documentReceiptLogId) {
        _documentReceiptLogId = documentReceiptLogId;
    }

    public long getDocumentReceiptId() {
        return _documentReceiptId;
    }

    public void setDocumentReceiptId(long documentReceiptId) {
        _documentReceiptId = documentReceiptId;
    }

    public int getTransition_() {
        return _transition_;
    }

    public void setTransition_(int transition_) {
        _transition_ = transition_;
    }

    public long getProcesser() {
        return _processer;
    }

    public void setProcesser(long processer) {
        _processer = processer;
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

    public long getReceiver() {
        return _receiver;
    }

    public void setReceiver(long receiver) {
        _receiver = receiver;
    }

    public Date getReceiveDate() {
        return _receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        _receiveDate = receiveDate;
    }

    public long getStateProcessIdBefore() {
        return _stateProcessIdBefore;
    }

    public void setStateProcessIdBefore(long stateProcessIdBefore) {
        _stateProcessIdBefore = stateProcessIdBefore;
    }

    public long getStateProcessIdAfter() {
        return _stateProcessIdAfter;
    }

    public void setStateProcessIdAfter(long stateProcessIdAfter) {
        _stateProcessIdAfter = stateProcessIdAfter;
    }

    public int getType_() {
        return _type_;
    }

    public void setType_(int type_) {
        _type_ = type_;
    }

    public Date getExpiredDate() {
        return _expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        _expiredDate = expiredDate;
    }

    public int getNumDateProcess() {
        return _numDateProcess;
    }

    public void setNumDateProcess(int numDateProcess) {
        _numDateProcess = numDateProcess;
    }

    public long getProcessInstanceId() {
        return _processInstanceId;
    }

    public void setProcessInstanceId(long processInstanceId) {
        _processInstanceId = processInstanceId;
    }

    public String getMainDepartmentProcessId() {
        return _mainDepartmentProcessId;
    }

    public void setMainDepartmentProcessId(String mainDepartmentProcessId) {
        _mainDepartmentProcessId = mainDepartmentProcessId;
    }

    public long getMainUserProcessId() {
        return _mainUserProcessId;
    }

    public void setMainUserProcessId(long mainUserProcessId) {
        _mainUserProcessId = mainUserProcessId;
    }

    public Date getSendDateBefore() {
        return _sendDateBefore;
    }

    public void setSendDateBefore(Date sendDateBefore) {
        _sendDateBefore = sendDateBefore;
    }

    public String getDepartmentReceiveId() {
        return _departmentReceiveId;
    }

    public void setDepartmentReceiveId(String departmentReceiveId) {
        _departmentReceiveId = departmentReceiveId;
    }

    public String getDepartmentProcessId() {
        return _departmentProcessId;
    }

    public void setDepartmentProcessId(String departmentProcessId) {
        _departmentProcessId = departmentProcessId;
    }

    public Date getDateProcessTime() {
        return _dateProcessTime;
    }

    public void setDateProcessTime(Date dateProcessTime) {
        _dateProcessTime = dateProcessTime;
    }

    public Date getReceiveDateTime() {
        return _receiveDateTime;
    }

    public void setReceiveDateTime(Date receiveDateTime) {
        _receiveDateTime = receiveDateTime;
    }

    public long getDirectProcesserId() {
        return _directProcesserId;
    }

    public void setDirectProcesserId(long directProcesserId) {
        _directProcesserId = directProcesserId;
    }

    public int getStep() {
        return _step;
    }

    public void setStep(int step) {
        _step = step;
    }
}
