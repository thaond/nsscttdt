package com.ext.portlet.meetingcalendar.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlScreenCalendarHeightSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.ext.portlet.meetingcalendar.service.http.PmlScreenCalendarHeightServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.ext.portlet.meetingcalendar.service.http.PmlScreenCalendarHeightServiceSoap
 *
 */
public class PmlScreenCalendarHeightSoap implements Serializable {
    private long _screenCalendarHeightId;

    public PmlScreenCalendarHeightSoap() {
    }

    public static PmlScreenCalendarHeightSoap toSoapModel(
        PmlScreenCalendarHeight model) {
        PmlScreenCalendarHeightSoap soapModel = new PmlScreenCalendarHeightSoap();

        soapModel.setScreenCalendarHeightId(model.getScreenCalendarHeightId());

        return soapModel;
    }

    public static PmlScreenCalendarHeightSoap[] toSoapModels(
        List<PmlScreenCalendarHeight> models) {
        List<PmlScreenCalendarHeightSoap> soapModels = new ArrayList<PmlScreenCalendarHeightSoap>(models.size());

        for (PmlScreenCalendarHeight model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlScreenCalendarHeightSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _screenCalendarHeightId;
    }

    public void setPrimaryKey(long pk) {
        setScreenCalendarHeightId(pk);
    }

    public long getScreenCalendarHeightId() {
        return _screenCalendarHeightId;
    }

    public void setScreenCalendarHeightId(long screenCalendarHeightId) {
        _screenCalendarHeightId = screenCalendarHeightId;
    }
}
