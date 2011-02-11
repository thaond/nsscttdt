package com.sgs.portlet.holiday_calendar.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="AttactFileHolidaySoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.holiday_calendar.service.http.AttactFileHolidayServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.holiday_calendar.service.http.AttactFileHolidayServiceSoap
 *
 */
public class AttactFileHolidaySoap implements Serializable {
    private long _attactFileHolidayId;
    private String _attactFileHolidayTitle;
    private String _attactFileHolidayPath;
    private long _holidayCalendarId;
    private long _userId;
    private long _groupId;
    private long _companyId;

    public AttactFileHolidaySoap() {
    }

    public static AttactFileHolidaySoap toSoapModel(AttactFileHoliday model) {
        AttactFileHolidaySoap soapModel = new AttactFileHolidaySoap();

        soapModel.setAttactFileHolidayId(model.getAttactFileHolidayId());
        soapModel.setAttactFileHolidayTitle(model.getAttactFileHolidayTitle());
        soapModel.setAttactFileHolidayPath(model.getAttactFileHolidayPath());
        soapModel.setHolidayCalendarId(model.getHolidayCalendarId());
        soapModel.setUserId(model.getUserId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());

        return soapModel;
    }

    public static AttactFileHolidaySoap[] toSoapModels(
        List<AttactFileHoliday> models) {
        List<AttactFileHolidaySoap> soapModels = new ArrayList<AttactFileHolidaySoap>(models.size());

        for (AttactFileHoliday model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new AttactFileHolidaySoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _attactFileHolidayId;
    }

    public void setPrimaryKey(long pk) {
        setAttactFileHolidayId(pk);
    }

    public long getAttactFileHolidayId() {
        return _attactFileHolidayId;
    }

    public void setAttactFileHolidayId(long attactFileHolidayId) {
        _attactFileHolidayId = attactFileHolidayId;
    }

    public String getAttactFileHolidayTitle() {
        return _attactFileHolidayTitle;
    }

    public void setAttactFileHolidayTitle(String attactFileHolidayTitle) {
        _attactFileHolidayTitle = attactFileHolidayTitle;
    }

    public String getAttactFileHolidayPath() {
        return _attactFileHolidayPath;
    }

    public void setAttactFileHolidayPath(String attactFileHolidayPath) {
        _attactFileHolidayPath = attactFileHolidayPath;
    }

    public long getHolidayCalendarId() {
        return _holidayCalendarId;
    }

    public void setHolidayCalendarId(long holidayCalendarId) {
        _holidayCalendarId = holidayCalendarId;
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
