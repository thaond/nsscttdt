package com.liferay.portlet.messageboards.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="MBBanSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.liferay.portlet.messageboards.service.http.MBBanServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.liferay.portlet.messageboards.service.http.MBBanServiceSoap
 *
 */
public class MBBanSoap implements Serializable {
    private long _banId;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private long _banUserId;

    public MBBanSoap() {
    }

    public static MBBanSoap toSoapModel(MBBan model) {
        MBBanSoap soapModel = new MBBanSoap();

        soapModel.setBanId(model.getBanId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setBanUserId(model.getBanUserId());

        return soapModel;
    }

    public static MBBanSoap[] toSoapModels(MBBan[] models) {
        MBBanSoap[] soapModels = new MBBanSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static MBBanSoap[][] toSoapModels(MBBan[][] models) {
        MBBanSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new MBBanSoap[models.length][models[0].length];
        } else {
            soapModels = new MBBanSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static MBBanSoap[] toSoapModels(List<MBBan> models) {
        List<MBBanSoap> soapModels = new ArrayList<MBBanSoap>(models.size());

        for (MBBan model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new MBBanSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _banId;
    }

    public void setPrimaryKey(long pk) {
        setBanId(pk);
    }

    public long getBanId() {
        return _banId;
    }

    public void setBanId(long banId) {
        _banId = banId;
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _groupId = groupId;
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

    public long getBanUserId() {
        return _banUserId;
    }

    public void setBanUserId(long banUserId) {
        _banUserId = banUserId;
    }
}
