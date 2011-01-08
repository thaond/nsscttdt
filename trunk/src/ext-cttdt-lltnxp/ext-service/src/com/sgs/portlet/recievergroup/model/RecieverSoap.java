package com.sgs.portlet.recievergroup.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="RecieverSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.recievergroup.service.http.RecieverServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.recievergroup.service.http.RecieverServiceSoap
 *
 */
public class RecieverSoap implements Serializable {
    private long _recieverId;
    private long _companyId;
    private long _userId;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private long _recieverUserId;
    private String _recieverUserName;
    private String _viewName;
    private int _recieverType;

    public RecieverSoap() {
    }

    public static RecieverSoap toSoapModel(Reciever model) {
        RecieverSoap soapModel = new RecieverSoap();

        soapModel.setRecieverId(model.getRecieverId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setRecieverUserId(model.getRecieverUserId());
        soapModel.setRecieverUserName(model.getRecieverUserName());
        soapModel.setViewName(model.getViewName());
        soapModel.setRecieverType(model.getRecieverType());

        return soapModel;
    }

    public static RecieverSoap[] toSoapModels(List<Reciever> models) {
        List<RecieverSoap> soapModels = new ArrayList<RecieverSoap>(models.size());

        for (Reciever model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new RecieverSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _recieverId;
    }

    public void setPrimaryKey(long pk) {
        setRecieverId(pk);
    }

    public long getRecieverId() {
        return _recieverId;
    }

    public void setRecieverId(long recieverId) {
        _recieverId = recieverId;
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

    public long getRecieverUserId() {
        return _recieverUserId;
    }

    public void setRecieverUserId(long recieverUserId) {
        _recieverUserId = recieverUserId;
    }

    public String getRecieverUserName() {
        return _recieverUserName;
    }

    public void setRecieverUserName(String recieverUserName) {
        _recieverUserName = recieverUserName;
    }

    public String getViewName() {
        return _viewName;
    }

    public void setViewName(String viewName) {
        _viewName = viewName;
    }

    public int getRecieverType() {
        return _recieverType;
    }

    public void setRecieverType(int recieverType) {
        _recieverType = recieverType;
    }
}
