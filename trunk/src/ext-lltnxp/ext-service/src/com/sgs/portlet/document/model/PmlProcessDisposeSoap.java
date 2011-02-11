package com.sgs.portlet.document.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="PmlProcessDisposeSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.document.service.http.PmlProcessDisposeServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.service.http.PmlProcessDisposeServiceSoap
 *
 */
public class PmlProcessDisposeSoap implements Serializable {
    private long _processDisposeId;
    private String _fileId;
    private int _transition_;
    private long _processer;
    private Date _dateProcess;
    private String _processInfomation;
    private long _receiver;
    private Date _receiveDate;
    private long _stateProcessIdBefore;
    private long _stateProcessIdAfter;
    private Date _expiredDate;
    private long _delegateUser;
    private Date _sendDate;

    public PmlProcessDisposeSoap() {
    }

    public static PmlProcessDisposeSoap toSoapModel(PmlProcessDispose model) {
        PmlProcessDisposeSoap soapModel = new PmlProcessDisposeSoap();

        soapModel.setProcessDisposeId(model.getProcessDisposeId());
        soapModel.setFileId(model.getFileId());
        soapModel.setTransition_(model.getTransition_());
        soapModel.setProcesser(model.getProcesser());
        soapModel.setDateProcess(model.getDateProcess());
        soapModel.setProcessInfomation(model.getProcessInfomation());
        soapModel.setReceiver(model.getReceiver());
        soapModel.setReceiveDate(model.getReceiveDate());
        soapModel.setStateProcessIdBefore(model.getStateProcessIdBefore());
        soapModel.setStateProcessIdAfter(model.getStateProcessIdAfter());
        soapModel.setExpiredDate(model.getExpiredDate());
        soapModel.setDelegateUser(model.getDelegateUser());
        soapModel.setSendDate(model.getSendDate());

        return soapModel;
    }

    public static PmlProcessDisposeSoap[] toSoapModels(
        List<PmlProcessDispose> models) {
        List<PmlProcessDisposeSoap> soapModels = new ArrayList<PmlProcessDisposeSoap>(models.size());

        for (PmlProcessDispose model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlProcessDisposeSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _processDisposeId;
    }

    public void setPrimaryKey(long pk) {
        setProcessDisposeId(pk);
    }

    public long getProcessDisposeId() {
        return _processDisposeId;
    }

    public void setProcessDisposeId(long processDisposeId) {
        _processDisposeId = processDisposeId;
    }

    public String getFileId() {
        return _fileId;
    }

    public void setFileId(String fileId) {
        _fileId = fileId;
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

    public Date getExpiredDate() {
        return _expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        _expiredDate = expiredDate;
    }

    public long getDelegateUser() {
        return _delegateUser;
    }

    public void setDelegateUser(long delegateUser) {
        _delegateUser = delegateUser;
    }

    public Date getSendDate() {
        return _sendDate;
    }

    public void setSendDate(Date sendDate) {
        _sendDate = sendDate;
    }
}
