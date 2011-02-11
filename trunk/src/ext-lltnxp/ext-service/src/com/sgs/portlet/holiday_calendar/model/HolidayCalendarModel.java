package com.sgs.portlet.holiday_calendar.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="HolidayCalendarModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>HolidayCalendar</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.holiday_calendar.model.HolidayCalendar
 * @see com.sgs.portlet.holiday_calendar.model.impl.HolidayCalendarImpl
 * @see com.sgs.portlet.holiday_calendar.model.impl.HolidayCalendarModelImpl
 *
 */
public interface HolidayCalendarModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getHolidayCalendarId();

    public void setHolidayCalendarId(long holidayCalendarId);

    public String getHolidayCalendarCode();

    public void setHolidayCalendarCode(String holidayCalendarCode);

    public Date getHolidayCalendarDateCreate();

    public void setHolidayCalendarDateCreate(Date holidayCalendarDateCreate);

    public String getHolidayCalendarTitle();

    public void setHolidayCalendarTitle(String holidayCalendarTitle);

    public long getUserId();

    public void setUserId(long userId);

    public long getGroupId();

    public void setGroupId(long groupId);

    public long getCompanyId();

    public void setCompanyId(long companyId);

    public HolidayCalendar toEscapedModel();
}
