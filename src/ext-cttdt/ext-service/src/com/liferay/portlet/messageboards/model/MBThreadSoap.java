package com.liferay.portlet.messageboards.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="MBThreadSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.liferay.portlet.messageboards.service.http.MBThreadServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.liferay.portlet.messageboards.service.http.MBThreadServiceSoap
 *
 */
public class MBThreadSoap implements Serializable {
    private long _threadId;
    private long _groupId;
    private long _categoryId;
    private long _rootMessageId;
    private int _messageCount;
    private int _viewCount;
    private long _lastPostByUserId;
    private Date _lastPostDate;
    private double _priority;

    public MBThreadSoap() {
    }

    public static MBThreadSoap toSoapModel(MBThread model) {
        MBThreadSoap soapModel = new MBThreadSoap();

        soapModel.setThreadId(model.getThreadId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCategoryId(model.getCategoryId());
        soapModel.setRootMessageId(model.getRootMessageId());
        soapModel.setMessageCount(model.getMessageCount());
        soapModel.setViewCount(model.getViewCount());
        soapModel.setLastPostByUserId(model.getLastPostByUserId());
        soapModel.setLastPostDate(model.getLastPostDate());
        soapModel.setPriority(model.getPriority());

        return soapModel;
    }

    public static MBThreadSoap[] toSoapModels(MBThread[] models) {
        MBThreadSoap[] soapModels = new MBThreadSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static MBThreadSoap[][] toSoapModels(MBThread[][] models) {
        MBThreadSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new MBThreadSoap[models.length][models[0].length];
        } else {
            soapModels = new MBThreadSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static MBThreadSoap[] toSoapModels(List<MBThread> models) {
        List<MBThreadSoap> soapModels = new ArrayList<MBThreadSoap>(models.size());

        for (MBThread model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new MBThreadSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _threadId;
    }

    public void setPrimaryKey(long pk) {
        setThreadId(pk);
    }

    public long getThreadId() {
        return _threadId;
    }

    public void setThreadId(long threadId) {
        _threadId = threadId;
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    public long getCategoryId() {
        return _categoryId;
    }

    public void setCategoryId(long categoryId) {
        _categoryId = categoryId;
    }

    public long getRootMessageId() {
        return _rootMessageId;
    }

    public void setRootMessageId(long rootMessageId) {
        _rootMessageId = rootMessageId;
    }

    public int getMessageCount() {
        return _messageCount;
    }

    public void setMessageCount(int messageCount) {
        _messageCount = messageCount;
    }

    public int getViewCount() {
        return _viewCount;
    }

    public void setViewCount(int viewCount) {
        _viewCount = viewCount;
    }

    public long getLastPostByUserId() {
        return _lastPostByUserId;
    }

    public void setLastPostByUserId(long lastPostByUserId) {
        _lastPostByUserId = lastPostByUserId;
    }

    public Date getLastPostDate() {
        return _lastPostDate;
    }

    public void setLastPostDate(Date lastPostDate) {
        _lastPostDate = lastPostDate;
    }

    public double getPriority() {
        return _priority;
    }

    public void setPriority(double priority) {
        _priority = priority;
    }
}
