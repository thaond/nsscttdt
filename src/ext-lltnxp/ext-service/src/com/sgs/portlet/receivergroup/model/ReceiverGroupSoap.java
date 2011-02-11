package com.sgs.portlet.receivergroup.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="ReceiverGroupSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.receivergroup.service.http.ReceiverGroupServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.receivergroup.service.http.ReceiverGroupServiceSoap
 *
 */
public class ReceiverGroupSoap implements Serializable {
    private long _receiverGroupId;
    private long _companyId;
    private long _userId;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private String _receiverGroupName;
    private String _description;
    private int _type;
    private boolean _active;

    public ReceiverGroupSoap() {
    }

    public static ReceiverGroupSoap toSoapModel(ReceiverGroup model) {
        ReceiverGroupSoap soapModel = new ReceiverGroupSoap();

        soapModel.setReceiverGroupId(model.getReceiverGroupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setReceiverGroupName(model.getReceiverGroupName());
        soapModel.setDescription(model.getDescription());
        soapModel.setType(model.getType());
        soapModel.setActive(model.getActive());

        return soapModel;
    }

    public static ReceiverGroupSoap[] toSoapModels(List<ReceiverGroup> models) {
        List<ReceiverGroupSoap> soapModels = new ArrayList<ReceiverGroupSoap>(models.size());

        for (ReceiverGroup model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ReceiverGroupSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _receiverGroupId;
    }

    public void setPrimaryKey(long pk) {
        setReceiverGroupId(pk);
    }

    public long getReceiverGroupId() {
        return _receiverGroupId;
    }

    public void setReceiverGroupId(long receiverGroupId) {
        _receiverGroupId = receiverGroupId;
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

    public String getReceiverGroupName() {
        return _receiverGroupName;
    }

    public void setReceiverGroupName(String receiverGroupName) {
        _receiverGroupName = receiverGroupName;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public int getType() {
        return _type;
    }

    public void setType(int type) {
        _type = type;
    }

    public boolean getActive() {
        return _active;
    }

    public boolean isActive() {
        return _active;
    }

    public void setActive(boolean active) {
        _active = active;
    }
}
