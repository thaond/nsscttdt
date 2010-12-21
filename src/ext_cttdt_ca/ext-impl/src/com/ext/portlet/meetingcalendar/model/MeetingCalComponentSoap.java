package com.ext.portlet.meetingcalendar.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="MeetingCalComponentSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.ext.portlet.meetingcalendar.service.http.MeetingCalComponentServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.ext.portlet.meetingcalendar.service.http.MeetingCalComponentServiceSoap
 *
 */
public class MeetingCalComponentSoap implements Serializable {
    private long _mcalId;
    private String _groupIds;
    private Date _startDate;

    public MeetingCalComponentSoap() {
    }

    public static MeetingCalComponentSoap toSoapModel(MeetingCalComponent model) {
        MeetingCalComponentSoap soapModel = new MeetingCalComponentSoap();

        soapModel.setMcalId(model.getMcalId());
        soapModel.setGroupIds(model.getGroupIds());
        soapModel.setStartDate(model.getStartDate());

        return soapModel;
    }

    public static MeetingCalComponentSoap[] toSoapModels(
        MeetingCalComponent[] models) {
        MeetingCalComponentSoap[] soapModels = new MeetingCalComponentSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static MeetingCalComponentSoap[][] toSoapModels(
        MeetingCalComponent[][] models) {
        MeetingCalComponentSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new MeetingCalComponentSoap[models.length][models[0].length];
        } else {
            soapModels = new MeetingCalComponentSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static MeetingCalComponentSoap[] toSoapModels(
        List<MeetingCalComponent> models) {
        List<MeetingCalComponentSoap> soapModels = new ArrayList<MeetingCalComponentSoap>(models.size());

        for (MeetingCalComponent model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new MeetingCalComponentSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _mcalId;
    }

    public void setPrimaryKey(long pk) {
        setMcalId(pk);
    }

    public long getMcalId() {
        return _mcalId;
    }

    public void setMcalId(long mcalId) {
        _mcalId = mcalId;
    }

    public String getGroupIds() {
        return _groupIds;
    }

    public void setGroupIds(String groupIds) {
        _groupIds = groupIds;
    }

    public Date getStartDate() {
        return _startDate;
    }

    public void setStartDate(Date startDate) {
        _startDate = startDate;
    }
}
