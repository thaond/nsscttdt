package com.sgs.portlet.holiday.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="PmlHolidaySoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.holiday.service.http.PmlHolidayServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.holiday.service.http.PmlHolidayServiceSoap
 *
 */
public class PmlHolidaySoap implements Serializable {
    private long _holidayId;
    private String _holiday_type;
    private String _holiday_value;
    private Date _from_date;
    private Date _to_date;

    public PmlHolidaySoap() {
    }

    public static PmlHolidaySoap toSoapModel(PmlHoliday model) {
        PmlHolidaySoap soapModel = new PmlHolidaySoap();

        soapModel.setHolidayId(model.getHolidayId());
        soapModel.setHoliday_type(model.getHoliday_type());
        soapModel.setHoliday_value(model.getHoliday_value());
        soapModel.setFrom_date(model.getFrom_date());
        soapModel.setTo_date(model.getTo_date());

        return soapModel;
    }

    public static PmlHolidaySoap[] toSoapModels(List<PmlHoliday> models) {
        List<PmlHolidaySoap> soapModels = new ArrayList<PmlHolidaySoap>(models.size());

        for (PmlHoliday model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlHolidaySoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _holidayId;
    }

    public void setPrimaryKey(long pk) {
        setHolidayId(pk);
    }

    public long getHolidayId() {
        return _holidayId;
    }

    public void setHolidayId(long holidayId) {
        _holidayId = holidayId;
    }

    public String getHoliday_type() {
        return _holiday_type;
    }

    public void setHoliday_type(String holiday_type) {
        _holiday_type = holiday_type;
    }

    public String getHoliday_value() {
        return _holiday_value;
    }

    public void setHoliday_value(String holiday_value) {
        _holiday_value = holiday_value;
    }

    public Date getFrom_date() {
        return _from_date;
    }

    public void setFrom_date(Date from_date) {
        _from_date = from_date;
    }

    public Date getTo_date() {
        return _to_date;
    }

    public void setTo_date(Date to_date) {
        _to_date = to_date;
    }
}
