package com.nss.portlet.chat.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="StatusModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>Status</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.chat.model.Status
 * @see com.nss.portlet.chat.model.impl.StatusImpl
 * @see com.nss.portlet.chat.model.impl.StatusModelImpl
 *
 */
public interface StatusModel extends BaseModel<Status> {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getStatusId();

    public void setStatusId(long statusId);

    public long getUserId();

    public void setUserId(long userId);

    public long getModifiedDate();

    public void setModifiedDate(long modifiedDate);

    public boolean getOnline();

    public boolean isOnline();

    public void setOnline(boolean online);

    public boolean getAwake();

    public boolean isAwake();

    public void setAwake(boolean awake);

    public String getActivePanelId();

    public void setActivePanelId(String activePanelId);

    public String getMessage();

    public void setMessage(String message);

    public boolean getPlaySound();

    public boolean isPlaySound();

    public void setPlaySound(boolean playSound);

    public Status toEscapedModel();
}
