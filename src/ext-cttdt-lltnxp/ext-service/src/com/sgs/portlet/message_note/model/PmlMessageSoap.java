package com.sgs.portlet.message_note.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="PmlMessageSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.message_note.service.http.PmlMessageServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.message_note.service.http.PmlMessageServiceSoap
 *
 */
public class PmlMessageSoap implements Serializable {
    private long _messageId;
    private long _documentId;
    private long _fromUserId;
    private long _toUserId;
    private Date _createDate;
    private String _objectType;
    private boolean _isAlert;

    public PmlMessageSoap() {
    }

    public static PmlMessageSoap toSoapModel(PmlMessage model) {
        PmlMessageSoap soapModel = new PmlMessageSoap();

        soapModel.setMessageId(model.getMessageId());
        soapModel.setDocumentId(model.getDocumentId());
        soapModel.setFromUserId(model.getFromUserId());
        soapModel.setToUserId(model.getToUserId());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setObjectType(model.getObjectType());
        soapModel.setIsAlert(model.getIsAlert());

        return soapModel;
    }

    public static PmlMessageSoap[] toSoapModels(List<PmlMessage> models) {
        List<PmlMessageSoap> soapModels = new ArrayList<PmlMessageSoap>(models.size());

        for (PmlMessage model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlMessageSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _messageId;
    }

    public void setPrimaryKey(long pk) {
        setMessageId(pk);
    }

    public long getMessageId() {
        return _messageId;
    }

    public void setMessageId(long messageId) {
        _messageId = messageId;
    }

    public long getDocumentId() {
        return _documentId;
    }

    public void setDocumentId(long documentId) {
        _documentId = documentId;
    }

    public long getFromUserId() {
        return _fromUserId;
    }

    public void setFromUserId(long fromUserId) {
        _fromUserId = fromUserId;
    }

    public long getToUserId() {
        return _toUserId;
    }

    public void setToUserId(long toUserId) {
        _toUserId = toUserId;
    }

    public Date getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    public String getObjectType() {
        return _objectType;
    }

    public void setObjectType(String objectType) {
        _objectType = objectType;
    }

    public boolean getIsAlert() {
        return _isAlert;
    }

    public boolean isIsAlert() {
        return _isAlert;
    }

    public void setIsAlert(boolean isAlert) {
        _isAlert = isAlert;
    }
}
