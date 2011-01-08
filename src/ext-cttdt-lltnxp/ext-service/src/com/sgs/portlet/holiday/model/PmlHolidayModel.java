package com.sgs.portlet.holiday.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;


/**
 * <a href="PmlHolidayModel.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>PmlHoliday</code>
 * table in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.holiday.model.PmlHoliday
 * @see com.sgs.portlet.holiday.model.impl.PmlHolidayImpl
 * @see com.sgs.portlet.holiday.model.impl.PmlHolidayModelImpl
 *
 */
public interface PmlHolidayModel extends BaseModel {
    public long getPrimaryKey();

    public void setPrimaryKey(long pk);

    public long getHolidayId();

    public void setHolidayId(long holidayId);

    public String getHoliday_type();

    public void setHoliday_type(String holiday_type);

    public String getHoliday_value();

    public void setHoliday_value(String holiday_value);

    public Date getFrom_date();

    public void setFrom_date(Date from_date);

    public Date getTo_date();

    public void setTo_date(Date to_date);

    public PmlHoliday toEscapedModel();
}
