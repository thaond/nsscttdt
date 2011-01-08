package com.ext.portlet.meetingcalendar.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="MeetingDetailWeekModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>MeetingDetailWeek</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.ext.portlet.meetingcalendar.model.MeetingDetailWeek
 * @see com.ext.portlet.meetingcalendar.model.impl.MeetingDetailWeekImpl
 * @see com.ext.portlet.meetingcalendar.model.impl.MeetingDetailWeekModelImpl
 *
 */
public interface MeetingDetailWeekModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getMdweekId();

    public void setMdweekId(long mdweekId);

    public long getGroupId();

    public void setGroupId(long groupId);

    public long getCompanyId();

    public void setCompanyId(long companyId);

    public long getUserId();

    public void setUserId(long userId);

    public String getUserName();

    public void setUserName(String userName);

    public String getFocus();

    public void setFocus(String focus);

    public String getNote();

    public void setNote(String note);

    public String getReceive();

    public void setReceive(String receive);

    public int getWeek();

    public void setWeek(int week);

    public int getYear();

    public void setYear(int year);

    public MeetingDetailWeek toEscapedModel();
}
