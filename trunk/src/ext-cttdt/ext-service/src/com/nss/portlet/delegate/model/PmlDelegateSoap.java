package com.nss.portlet.delegate.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="PmlDelegateSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.delegate.service.http.PmlDelegateServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.delegate.service.http.PmlDelegateServiceSoap
 *
 */
public class PmlDelegateSoap implements Serializable {
    private long _delegateId;
    private long _assigner;
    private long _receiver;
    private Date _startDate;
    private Date _endDate;
    private Date _cancelDate;
    private String _cancelDelegate;
    private Date _dateCreated;

    public PmlDelegateSoap() {
    }

    public static PmlDelegateSoap toSoapModel(PmlDelegate model) {
        PmlDelegateSoap soapModel = new PmlDelegateSoap();

        soapModel.setDelegateId(model.getDelegateId());
        soapModel.setAssigner(model.getAssigner());
        soapModel.setReceiver(model.getReceiver());
        soapModel.setStartDate(model.getStartDate());
        soapModel.setEndDate(model.getEndDate());
        soapModel.setCancelDate(model.getCancelDate());
        soapModel.setCancelDelegate(model.getCancelDelegate());
        soapModel.setDateCreated(model.getDateCreated());

        return soapModel;
    }

    public static PmlDelegateSoap[] toSoapModels(PmlDelegate[] models) {
        PmlDelegateSoap[] soapModels = new PmlDelegateSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static PmlDelegateSoap[][] toSoapModels(PmlDelegate[][] models) {
        PmlDelegateSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new PmlDelegateSoap[models.length][models[0].length];
        } else {
            soapModels = new PmlDelegateSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static PmlDelegateSoap[] toSoapModels(List<PmlDelegate> models) {
        List<PmlDelegateSoap> soapModels = new ArrayList<PmlDelegateSoap>(models.size());

        for (PmlDelegate model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlDelegateSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _delegateId;
    }

    public void setPrimaryKey(long pk) {
        setDelegateId(pk);
    }

    public long getDelegateId() {
        return _delegateId;
    }

    public void setDelegateId(long delegateId) {
        _delegateId = delegateId;
    }

    public long getAssigner() {
        return _assigner;
    }

    public void setAssigner(long assigner) {
        _assigner = assigner;
    }

    public long getReceiver() {
        return _receiver;
    }

    public void setReceiver(long receiver) {
        _receiver = receiver;
    }

    public Date getStartDate() {
        return _startDate;
    }

    public void setStartDate(Date startDate) {
        _startDate = startDate;
    }

    public Date getEndDate() {
        return _endDate;
    }

    public void setEndDate(Date endDate) {
        _endDate = endDate;
    }

    public Date getCancelDate() {
        return _cancelDate;
    }

    public void setCancelDate(Date cancelDate) {
        _cancelDate = cancelDate;
    }

    public String getCancelDelegate() {
        return _cancelDelegate;
    }

    public void setCancelDelegate(String cancelDelegate) {
        _cancelDelegate = cancelDelegate;
    }

    public Date getDateCreated() {
        return _dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        _dateCreated = dateCreated;
    }
}
