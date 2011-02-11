package com.sgs.portlet.receivergroup.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="ReceiverSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.receivergroup.service.http.ReceiverServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.receivergroup.service.http.ReceiverServiceSoap
 *
 */
public class ReceiverSoap implements Serializable {
    private long _receiverId;
    private long _companyId;
    private long _userId;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private long _receiverUserId;
    private String _receiverUserName;
    private String _viewName;
    private int _receiverType;

    public ReceiverSoap() {
    }

    public static ReceiverSoap toSoapModel(Receiver model) {
        ReceiverSoap soapModel = new ReceiverSoap();

        soapModel.setReceiverId(model.getReceiverId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setReceiverUserId(model.getReceiverUserId());
        soapModel.setReceiverUserName(model.getReceiverUserName());
        soapModel.setViewName(model.getViewName());
        soapModel.setReceiverType(model.getReceiverType());

        return soapModel;
    }

    public static ReceiverSoap[] toSoapModels(List<Receiver> models) {
        List<ReceiverSoap> soapModels = new ArrayList<ReceiverSoap>(models.size());

        for (Receiver model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ReceiverSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _receiverId;
    }

    public void setPrimaryKey(long pk) {
        setReceiverId(pk);
    }

    public long getReceiverId() {
        return _receiverId;
    }

    public void setReceiverId(long receiverId) {
        _receiverId = receiverId;
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public String getUserName() {
        return _userName;
    }

    public void setUserName(String userName) {
        _userName = userName;
    }

    public Date getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    public Date getModifiedDate() {
        return _modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;
    }

    public long getReceiverUserId() {
        return _receiverUserId;
    }

    public void setReceiverUserId(long receiverUserId) {
        _receiverUserId = receiverUserId;
    }

    public String getReceiverUserName() {
        return _receiverUserName;
    }

    public void setReceiverUserName(String receiverUserName) {
        _receiverUserName = receiverUserName;
    }

    public String getViewName() {
        return _viewName;
    }

    public void setViewName(String viewName) {
        _viewName = viewName;
    }

    public int getReceiverType() {
        return _receiverType;
    }

    public void setReceiverType(int receiverType) {
        _receiverType = receiverType;
    }
}
