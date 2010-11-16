package com.liferay.portlet.messageboards.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="MBStatsUserModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>MBStatsUser</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.liferay.portlet.messageboards.model.MBStatsUser
 * @see com.liferay.portlet.messageboards.model.impl.MBStatsUserImpl
 * @see com.liferay.portlet.messageboards.model.impl.MBStatsUserModelImpl
 *
 */
public interface MBStatsUserModel extends BaseModel<MBStatsUser> {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getStatsUserId();

    public void setStatsUserId(long statsUserId);

    public long getGroupId();

    public void setGroupId(long groupId);

    public long getUserId();

    public void setUserId(long userId);

    public int getMessageCount();

    public void setMessageCount(int messageCount);

    public Date getLastPostDate();

    public void setLastPostDate(Date lastPostDate);

    public MBStatsUser toEscapedModel();
}
