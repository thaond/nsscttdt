package com.liferay.portlet.messageboards.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="MBMessageModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>MBMessage</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.liferay.portlet.messageboards.model.MBMessage
 * @see com.liferay.portlet.messageboards.model.impl.MBMessageImpl
 * @see com.liferay.portlet.messageboards.model.impl.MBMessageModelImpl
 *
 */
public interface MBMessageModel extends BaseModel<MBMessage> {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public String getUuid();

    public void setUuid(String uuid);

    public long getMessageId();

    public void setMessageId(long messageId);

    public long getGroupId();

    public void setGroupId(long groupId);

    public long getCompanyId();

    public void setCompanyId(long companyId);

    public long getUserId();

    public void setUserId(long userId);

    public String getUserName();

    public void setUserName(String userName);

    public Date getCreateDate();

    public void setCreateDate(Date createDate);

    public Date getModifiedDate();

    public void setModifiedDate(Date modifiedDate);

    public String getClassName();

    public long getClassNameId();

    public void setClassNameId(long classNameId);

    public long getClassPK();

    public void setClassPK(long classPK);

    public long getCategoryId();

    public void setCategoryId(long categoryId);

    public long getThreadId();

    public void setThreadId(long threadId);

    public long getParentMessageId();

    public void setParentMessageId(long parentMessageId);

    public String getSubject();

    public void setSubject(String subject);

    public String getBody();

    public void setBody(String body);

    public boolean getAttachments();

    public boolean isAttachments();

    public void setAttachments(boolean attachments);

    public boolean getAnonymous();

    public boolean isAnonymous();

    public void setAnonymous(boolean anonymous);

    public double getPriority();

    public void setPriority(double priority);

    public MBMessage toEscapedModel();
}
