package com.sgs.portlet.recievergroup.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="RecieverGroupSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.recievergroup.service.http.RecieverGroupServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.recievergroup.service.http.RecieverGroupServiceSoap
 *
 */
public class RecieverGroupSoap implements Serializable {
    private long _recieverGroupId;
    private long _companyId;
    private long _userId;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private String _recieverGroupName;
    private String _description;
    private int _type;
    private boolean _active;

    public RecieverGroupSoap() {
    }

    public static RecieverGroupSoap toSoapModel(RecieverGroup model) {
        RecieverGroupSoap soapModel = new RecieverGroupSoap();

        soapModel.setRecieverGroupId(model.getRecieverGroupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setRecieverGroupName(model.getRecieverGroupName());
        soapModel.setDescription(model.getDescription());
        soapModel.setType(model.getType());
        soapModel.setActive(model.getActive());

        return soapModel;
    }

    public static RecieverGroupSoap[] toSoapModels(List<RecieverGroup> models) {
        List<RecieverGroupSoap> soapModels = new ArrayList<RecieverGroupSoap>(models.size());

        for (RecieverGroup model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new RecieverGroupSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _recieverGroupId;
    }

    public void setPrimaryKey(long pk) {
        setRecieverGroupId(pk);
    }

    public long getRecieverGroupId() {
        return _recieverGroupId;
    }

    public void setRecieverGroupId(long recieverGroupId) {
        _recieverGroupId = recieverGroupId;
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

    public String getRecieverGroupName() {
        return _recieverGroupName;
    }

    public void setRecieverGroupName(String recieverGroupName) {
        _recieverGroupName = recieverGroupName;
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
