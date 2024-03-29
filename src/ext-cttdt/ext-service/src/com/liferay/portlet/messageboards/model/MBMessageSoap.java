package com.liferay.portlet.messageboards.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="MBMessageSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.liferay.portlet.messageboards.service.http.MBMessageServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.liferay.portlet.messageboards.service.http.MBMessageServiceSoap
 *
 */
public class MBMessageSoap implements Serializable {
    private String _uuid;
    private long _messageId;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private long _classNameId;
    private long _classPK;
    private long _categoryId;
    private long _threadId;
    private long _parentMessageId;
    private String _subject;
    private String _body;
    private boolean _attachments;
    private boolean _anonymous;
    private double _priority;

    public MBMessageSoap() {
    }

    public static MBMessageSoap toSoapModel(MBMessage model) {
        MBMessageSoap soapModel = new MBMessageSoap();

        soapModel.setUuid(model.getUuid());
        soapModel.setMessageId(model.getMessageId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setClassNameId(model.getClassNameId());
        soapModel.setClassPK(model.getClassPK());
        soapModel.setCategoryId(model.getCategoryId());
        soapModel.setThreadId(model.getThreadId());
        soapModel.setParentMessageId(model.getParentMessageId());
        soapModel.setSubject(model.getSubject());
        soapModel.setBody(model.getBody());
        soapModel.setAttachments(model.getAttachments());
        soapModel.setAnonymous(model.getAnonymous());
        soapModel.setPriority(model.getPriority());

        return soapModel;
    }

    public static MBMessageSoap[] toSoapModels(MBMessage[] models) {
        MBMessageSoap[] soapModels = new MBMessageSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static MBMessageSoap[][] toSoapModels(MBMessage[][] models) {
        MBMessageSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new MBMessageSoap[models.length][models[0].length];
        } else {
            soapModels = new MBMessageSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static MBMessageSoap[] toSoapModels(List<MBMessage> models) {
        List<MBMessageSoap> soapModels = new ArrayList<MBMessageSoap>(models.size());

        for (MBMessage model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new MBMessageSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _messageId;
    }

    public void setPrimaryKey(long pk) {
        setMessageId(pk);
    }

    public String getUuid() {
        return _uuid;
    }

    public void setUuid(String uuid) {
        _uuid = uuid;
    }

    public long getMessageId() {
        return _messageId;
    }

    public void setMessageId(long messageId) {
        _messageId = messageId;
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

    public long getClassNameId() {
        return _classNameId;
    }

    public void setClassNameId(long classNameId) {
        _classNameId = classNameId;
    }

    public long getClassPK() {
        return _classPK;
    }

    public void setClassPK(long classPK) {
        _classPK = classPK;
    }

    public long getCategoryId() {
        return _categoryId;
    }

    public void setCategoryId(long categoryId) {
        _categoryId = categoryId;
    }

    public long getThreadId() {
        return _threadId;
    }

    public void setThreadId(long threadId) {
        _threadId = threadId;
    }

    public long getParentMessageId() {
        return _parentMessageId;
    }

    public void setParentMessageId(long parentMessageId) {
        _parentMessageId = parentMessageId;
    }

    public String getSubject() {
        return _subject;
    }

    public void setSubject(String subject) {
        _subject = subject;
    }

    public String getBody() {
        return _body;
    }

    public void setBody(String body) {
        _body = body;
    }

    public boolean getAttachments() {
        return _attachments;
    }

    public boolean isAttachments() {
        return _attachments;
    }

    public void setAttachments(boolean attachments) {
        _attachments = attachments;
    }

    public boolean getAnonymous() {
        return _anonymous;
    }

    public boolean isAnonymous() {
        return _anonymous;
    }

    public void setAnonymous(boolean anonymous) {
        _anonymous = anonymous;
    }

    public double getPriority() {
        return _priority;
    }

    public void setPriority(double priority) {
        _priority = priority;
    }
}
