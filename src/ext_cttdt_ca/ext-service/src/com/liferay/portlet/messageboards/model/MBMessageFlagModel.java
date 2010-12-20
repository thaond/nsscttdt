package com.liferay.portlet.messageboards.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="MBMessageFlagModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>MBMessageFlag</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.liferay.portlet.messageboards.model.MBMessageFlag
 * @see com.liferay.portlet.messageboards.model.impl.MBMessageFlagImpl
 * @see com.liferay.portlet.messageboards.model.impl.MBMessageFlagModelImpl
 *
 */
public interface MBMessageFlagModel extends BaseModel<MBMessageFlag> {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getMessageFlagId();

    public void setMessageFlagId(long messageFlagId);

    public long getUserId();

    public void setUserId(long userId);

    public Date getModifiedDate();

    public void setModifiedDate(Date modifiedDate);

    public long getThreadId();

    public void setThreadId(long threadId);

    public long getMessageId();

    public void setMessageId(long messageId);

    public int getFlag();

    public void setFlag(int flag);

    public MBMessageFlag toEscapedModel();
}
