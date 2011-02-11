package com.ext.portlet.meetingcalendar.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="MeetingCalComponentModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>MeetingCalComponent</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.ext.portlet.meetingcalendar.model.MeetingCalComponent
 * @see com.ext.portlet.meetingcalendar.model.impl.MeetingCalComponentImpl
 * @see com.ext.portlet.meetingcalendar.model.impl.MeetingCalComponentModelImpl
 *
 */
public interface MeetingCalComponentModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getMcalId();

    public void setMcalId(long mcalId);

    public String getGroupIds();

    public void setGroupIds(String groupIds);

    public Date getStartDate();

    public void setStartDate(Date startDate);

    public MeetingCalComponent toEscapedModel();
}
