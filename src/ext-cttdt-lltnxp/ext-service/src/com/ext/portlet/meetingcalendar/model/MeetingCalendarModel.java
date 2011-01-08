package com.ext.portlet.meetingcalendar.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="MeetingCalendarModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>MeetingCalendar</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.ext.portlet.meetingcalendar.model.MeetingCalendar
 * @see com.ext.portlet.meetingcalendar.model.impl.MeetingCalendarImpl
 * @see com.ext.portlet.meetingcalendar.model.impl.MeetingCalendarModelImpl
 *
 */
public interface MeetingCalendarModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public String getUuid();

    public void setUuid(String uuid);

    public long getMcalId();

    public void setMcalId(long mcalId);

    public long getGroupId();

    public void setGroupId(long groupId);

    public long getCompanyId();

    public void setCompanyId(long companyId);

    public long getUserId();

    public void setUserId(long userId);

    public String getUserName();

    public void setUserName(String userName);

    public int getState();

    public void setState(int state);

    public String getPlace();

    public void setPlace(String place);

    public String getPlace_diff();

    public void setPlace_diff(String place_diff);

    public String getSponsor();

    public void setSponsor(String sponsor);

    public String getComponent();

    public void setComponent(String component);

    public String getNote();

    public void setNote(String note);

    public long getUserApproved();

    public void setUserApproved(long userApproved);

    public Date getDateApproved();

    public void setDateApproved(Date dateApproved);

    public long getMoveMcalId();

    public void setMoveMcalId(long moveMcalId);

    public boolean getRepeatWeek();

    public boolean isRepeatWeek();

    public void setRepeatWeek(boolean repeatWeek);

    public String getFilename();

    public void setFilename(String filename);

    public boolean getMorning();

    public boolean isMorning();

    public void setMorning(boolean morning);

    public boolean getAfternoon();

    public boolean isAfternoon();

    public void setAfternoon(boolean afternoon);

    public boolean getEvening();

    public boolean isEvening();

    public void setEvening(boolean evening);

    public int getStt();

    public void setStt(int stt);

    public boolean getPrior();

    public boolean isPrior();

    public void setPrior(boolean prior);

    public MeetingCalendar toEscapedModel();
}
