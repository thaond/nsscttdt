package com.liferay.portlet.messageboards.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="MBThreadModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>MBThread</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.liferay.portlet.messageboards.model.MBThread
 * @see com.liferay.portlet.messageboards.model.impl.MBThreadImpl
 * @see com.liferay.portlet.messageboards.model.impl.MBThreadModelImpl
 *
 */
public interface MBThreadModel extends BaseModel<MBThread> {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getThreadId();

    public void setThreadId(long threadId);

    public long getGroupId();

    public void setGroupId(long groupId);

    public long getCategoryId();

    public void setCategoryId(long categoryId);

    public long getRootMessageId();

    public void setRootMessageId(long rootMessageId);

    public int getMessageCount();

    public void setMessageCount(int messageCount);

    public int getViewCount();

    public void setViewCount(int viewCount);

    public long getLastPostByUserId();

    public void setLastPostByUserId(long lastPostByUserId);

    public Date getLastPostDate();

    public void setLastPostDate(Date lastPostDate);

    public double getPriority();

    public void setPriority(double priority);

    public MBThread toEscapedModel();
}
