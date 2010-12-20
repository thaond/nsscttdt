package com.ext.portlet.meetingcalendar.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="MeetingDetailWeekSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.ext.portlet.meetingcalendar.service.http.MeetingDetailWeekServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.ext.portlet.meetingcalendar.service.http.MeetingDetailWeekServiceSoap
 *
 */
public class MeetingDetailWeekSoap implements Serializable {
    private long _mdweekId;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userName;
    private String _focus;
    private String _note;
    private String _receive;
    private int _week;
    private int _year;

    public MeetingDetailWeekSoap() {
    }

    public static MeetingDetailWeekSoap toSoapModel(MeetingDetailWeek model) {
        MeetingDetailWeekSoap soapModel = new MeetingDetailWeekSoap();

        soapModel.setMdweekId(model.getMdweekId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setFocus(model.getFocus());
        soapModel.setNote(model.getNote());
        soapModel.setReceive(model.getReceive());
        soapModel.setWeek(model.getWeek());
        soapModel.setYear(model.getYear());

        return soapModel;
    }

    public static MeetingDetailWeekSoap[] toSoapModels(
        MeetingDetailWeek[] models) {
        MeetingDetailWeekSoap[] soapModels = new MeetingDetailWeekSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static MeetingDetailWeekSoap[][] toSoapModels(
        MeetingDetailWeek[][] models) {
        MeetingDetailWeekSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new MeetingDetailWeekSoap[models.length][models[0].length];
        } else {
            soapModels = new MeetingDetailWeekSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static MeetingDetailWeekSoap[] toSoapModels(
        List<MeetingDetailWeek> models) {
        List<MeetingDetailWeekSoap> soapModels = new ArrayList<MeetingDetailWeekSoap>(models.size());

        for (MeetingDetailWeek model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new MeetingDetailWeekSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _mdweekId;
    }

    public void setPrimaryKey(long pk) {
        setMdweekId(pk);
    }

    public long getMdweekId() {
        return _mdweekId;
    }

    public void setMdweekId(long mdweekId) {
        _mdweekId = mdweekId;
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

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public String getUserName() {
        return _userName;
    }

    public void setUserName(String userName) {
        _userName = userName;
    }

    public String getFocus() {
        return _focus;
    }

    public void setFocus(String focus) {
        _focus = focus;
    }

    public String getNote() {
        return _note;
    }

    public void setNote(String note) {
        _note = note;
    }

    public String getReceive() {
        return _receive;
    }

    public void setReceive(String receive) {
        _receive = receive;
    }

    public int getWeek() {
        return _week;
    }

    public void setWeek(int week) {
        _week = week;
    }

    public int getYear() {
        return _year;
    }

    public void setYear(int year) {
        _year = year;
    }
}
