package com.sgs.portlet.documentdelegate.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="PmlDocumentDelegateSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.documentdelegate.service.http.PmlDocumentDelegateServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.documentdelegate.service.http.PmlDocumentDelegateServiceSoap
 *
 */
public class PmlDocumentDelegateSoap implements Serializable {
    private long _documentDelegateId;
    private long _userDelegateId;
    private long _userIsDelegateId;
    private int _documentId;
    private Date _fromtDate;
    private Date _toDate;
    private Date _cancelDate;

    public PmlDocumentDelegateSoap() {
    }

    public static PmlDocumentDelegateSoap toSoapModel(PmlDocumentDelegate model) {
        PmlDocumentDelegateSoap soapModel = new PmlDocumentDelegateSoap();

        soapModel.setDocumentDelegateId(model.getDocumentDelegateId());
        soapModel.setUserDelegateId(model.getUserDelegateId());
        soapModel.setUserIsDelegateId(model.getUserIsDelegateId());
        soapModel.setDocumentId(model.getDocumentId());
        soapModel.setFromtDate(model.getFromtDate());
        soapModel.setToDate(model.getToDate());
        soapModel.setCancelDate(model.getCancelDate());

        return soapModel;
    }

    public static PmlDocumentDelegateSoap[] toSoapModels(
        List<PmlDocumentDelegate> models) {
        List<PmlDocumentDelegateSoap> soapModels = new ArrayList<PmlDocumentDelegateSoap>(models.size());

        for (PmlDocumentDelegate model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlDocumentDelegateSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _documentDelegateId;
    }

    public void setPrimaryKey(long pk) {
        setDocumentDelegateId(pk);
    }

    public long getDocumentDelegateId() {
        return _documentDelegateId;
    }

    public void setDocumentDelegateId(long documentDelegateId) {
        _documentDelegateId = documentDelegateId;
    }

    public long getUserDelegateId() {
        return _userDelegateId;
    }

    public void setUserDelegateId(long userDelegateId) {
        _userDelegateId = userDelegateId;
    }

    public long getUserIsDelegateId() {
        return _userIsDelegateId;
    }

    public void setUserIsDelegateId(long userIsDelegateId) {
        _userIsDelegateId = userIsDelegateId;
    }

    public int getDocumentId() {
        return _documentId;
    }

    public void setDocumentId(int documentId) {
        _documentId = documentId;
    }

    public Date getFromtDate() {
        return _fromtDate;
    }

    public void setFromtDate(Date fromtDate) {
        _fromtDate = fromtDate;
    }

    public Date getToDate() {
        return _toDate;
    }

    public void setToDate(Date toDate) {
        _toDate = toDate;
    }

    public Date getCancelDate() {
        return _cancelDate;
    }

    public void setCancelDate(Date cancelDate) {
        _cancelDate = cancelDate;
    }
}
