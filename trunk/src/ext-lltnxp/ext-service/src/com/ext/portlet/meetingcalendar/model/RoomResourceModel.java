package com.ext.portlet.meetingcalendar.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="RoomResourceModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>RoomResource</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.ext.portlet.meetingcalendar.model.RoomResource
 * @see com.ext.portlet.meetingcalendar.model.impl.RoomResourceImpl
 * @see com.ext.portlet.meetingcalendar.model.impl.RoomResourceModelImpl
 *
 */
public interface RoomResourceModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getRoomId();

    public void setRoomId(long roomId);

    public long getCompanyId();

    public void setCompanyId(long companyId);

    public long getUserId();

    public void setUserId(long userId);

    public Date getCreateDate();

    public void setCreateDate(Date createDate);

    public Date getModifiedDate();

    public void setModifiedDate(Date modifiedDate);

    public String getRoomName();

    public void setRoomName(String roomName);

    public String getDescription();

    public void setDescription(String description);

    public RoomResource toEscapedModel();
}
