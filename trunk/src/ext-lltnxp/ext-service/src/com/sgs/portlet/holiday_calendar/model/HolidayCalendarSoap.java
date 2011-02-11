package com.sgs.portlet.holiday_calendar.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="HolidayCalendarSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.holiday_calendar.service.http.HolidayCalendarServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.holiday_calendar.service.http.HolidayCalendarServiceSoap
 *
 */
public class HolidayCalendarSoap implements Serializable {
    private long _holidayCalendarId;
    private String _holidayCalendarCode;
    private Date _holidayCalendarDateCreate;
    private String _holidayCalendarTitle;
    private long _userId;
    private long _groupId;
    private long _companyId;

    public HolidayCalendarSoap() {
    }

    public static HolidayCalendarSoap toSoapModel(HolidayCalendar model) {
        HolidayCalendarSoap soapModel = new HolidayCalendarSoap();

        soapModel.setHolidayCalendarId(model.getHolidayCalendarId());
        soapModel.setHolidayCalendarCode(model.getHolidayCalendarCode());
        soapModel.setHolidayCalendarDateCreate(model.getHolidayCalendarDateCreate());
        soapModel.setHolidayCalendarTitle(model.getHolidayCalendarTitle());
        soapModel.setUserId(model.getUserId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());

        return soapModel;
    }

    public static HolidayCalendarSoap[] toSoapModels(
        List<HolidayCalendar> models) {
        List<HolidayCalendarSoap> soapModels = new ArrayList<HolidayCalendarSoap>(models.size());

        for (HolidayCalendar model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new HolidayCalendarSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _holidayCalendarId;
    }

    public void setPrimaryKey(long pk) {
        setHolidayCalendarId(pk);
    }

    public long getHolidayCalendarId() {
        return _holidayCalendarId;
    }

    public void setHolidayCalendarId(long holidayCalendarId) {
        _holidayCalendarId = holidayCalendarId;
    }

    public String getHolidayCalendarCode() {
        return _holidayCalendarCode;
    }

    public void setHolidayCalendarCode(String holidayCalendarCode) {
        _holidayCalendarCode = holidayCalendarCode;
    }

    public Date getHolidayCalendarDateCreate() {
        return _holidayCalendarDateCreate;
    }

    public void setHolidayCalendarDateCreate(Date holidayCalendarDateCreate) {
        _holidayCalendarDateCreate = holidayCalendarDateCreate;
    }

    public String getHolidayCalendarTitle() {
        return _holidayCalendarTitle;
    }

    public void setHolidayCalendarTitle(String holidayCalendarTitle) {
        _holidayCalendarTitle = holidayCalendarTitle;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }
}
