package com.liferay.portlet.messageboards.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="MBStatsUserSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.liferay.portlet.messageboards.service.http.MBStatsUserServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.liferay.portlet.messageboards.service.http.MBStatsUserServiceSoap
 *
 */
public class MBStatsUserSoap implements Serializable {
    private long _statsUserId;
    private long _groupId;
    private long _userId;
    private int _messageCount;
    private Date _lastPostDate;

    public MBStatsUserSoap() {
    }

    public static MBStatsUserSoap toSoapModel(MBStatsUser model) {
        MBStatsUserSoap soapModel = new MBStatsUserSoap();

        soapModel.setStatsUserId(model.getStatsUserId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setUserId(model.getUserId());
        soapModel.setMessageCount(model.getMessageCount());
        soapModel.setLastPostDate(model.getLastPostDate());

        return soapModel;
    }

    public static MBStatsUserSoap[] toSoapModels(MBStatsUser[] models) {
        MBStatsUserSoap[] soapModels = new MBStatsUserSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static MBStatsUserSoap[][] toSoapModels(MBStatsUser[][] models) {
        MBStatsUserSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new MBStatsUserSoap[models.length][models[0].length];
        } else {
            soapModels = new MBStatsUserSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static MBStatsUserSoap[] toSoapModels(List<MBStatsUser> models) {
        List<MBStatsUserSoap> soapModels = new ArrayList<MBStatsUserSoap>(models.size());

        for (MBStatsUser model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new MBStatsUserSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _statsUserId;
    }

    public void setPrimaryKey(long pk) {
        setStatsUserId(pk);
    }

    public long getStatsUserId() {
        return _statsUserId;
    }

    public void setStatsUserId(long statsUserId) {
        _statsUserId = statsUserId;
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public int getMessageCount() {
        return _messageCount;
    }

    public void setMessageCount(int messageCount) {
        _messageCount = messageCount;
    }

    public Date getLastPostDate() {
        return _lastPostDate;
    }

    public void setLastPostDate(Date lastPostDate) {
        _lastPostDate = lastPostDate;
    }
}
