package com.sgs.portlet.holiday_calendar.model;

import com.liferay.portal.model.BaseModel;


/**
 * <a href="AttactFileHolidayModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>AttactFileHoliday</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.holiday_calendar.model.AttactFileHoliday
 * @see com.sgs.portlet.holiday_calendar.model.impl.AttactFileHolidayImpl
 * @see com.sgs.portlet.holiday_calendar.model.impl.AttactFileHolidayModelImpl
 *
 */
public interface AttactFileHolidayModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getAttactFileHolidayId();

    public void setAttactFileHolidayId(long attactFileHolidayId);

    public String getAttactFileHolidayTitle();

    public void setAttactFileHolidayTitle(String attactFileHolidayTitle);

    public String getAttactFileHolidayPath();

    public void setAttactFileHolidayPath(String attactFileHolidayPath);

    public long getHolidayCalendarId();

    public void setHolidayCalendarId(long holidayCalendarId);

    public long getUserId();

    public void setUserId(long userId);

    public long getGroupId();

    public void setGroupId(long groupId);

    public long getCompanyId();

    public void setCompanyId(long companyId);

    public AttactFileHoliday toEscapedModel();
}
