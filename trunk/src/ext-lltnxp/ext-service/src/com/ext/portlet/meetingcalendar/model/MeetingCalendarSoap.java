package com.ext.portlet.meetingcalendar.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="MeetingCalendarSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.ext.portlet.meetingcalendar.service.http.MeetingCalendarServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.ext.portlet.meetingcalendar.service.http.MeetingCalendarServiceSoap
 *
 */
public class MeetingCalendarSoap implements Serializable {
    private String _uuid;
    private long _mcalId;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userName;
    private int _state;
    private String _place;
    private String _place_diff;
    private String _sponsor;
    private String _component;
    private String _note;
    private long _userApproved;
    private Date _dateApproved;
    private long _moveMcalId;
    private boolean _repeatWeek;
    private String _filename;
    private boolean _morning;
    private boolean _afternoon;
    private boolean _evening;
    private int _stt;
    private boolean _prior;
    private boolean _deleted;

    public MeetingCalendarSoap() {
    }

    public static MeetingCalendarSoap toSoapModel(MeetingCalendar model) {
        MeetingCalendarSoap soapModel = new MeetingCalendarSoap();

        soapModel.setUuid(model.getUuid());
        soapModel.setMcalId(model.getMcalId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setState(model.getState());
        soapModel.setPlace(model.getPlace());
        soapModel.setPlace_diff(model.getPlace_diff());
        soapModel.setSponsor(model.getSponsor());
        soapModel.setComponent(model.getComponent());
        soapModel.setNote(model.getNote());
        soapModel.setUserApproved(model.getUserApproved());
        soapModel.setDateApproved(model.getDateApproved());
        soapModel.setMoveMcalId(model.getMoveMcalId());
        soapModel.setRepeatWeek(model.getRepeatWeek());
        soapModel.setFilename(model.getFilename());
        soapModel.setMorning(model.getMorning());
        soapModel.setAfternoon(model.getAfternoon());
        soapModel.setEvening(model.getEvening());
        soapModel.setStt(model.getStt());
        soapModel.setPrior(model.getPrior());
        soapModel.setDeleted(model.getDeleted());

        return soapModel;
    }

    public static MeetingCalendarSoap[] toSoapModels(
        List<MeetingCalendar> models) {
        List<MeetingCalendarSoap> soapModels = new ArrayList<MeetingCalendarSoap>(models.size());

        for (MeetingCalendar model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new MeetingCalendarSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _mcalId;
    }

    public void setPrimaryKey(long pk) {
        setMcalId(pk);
    }

    public String getUuid() {
        return _uuid;
    }

    public void setUuid(String uuid) {
        _uuid = uuid;
    }

    public long getMcalId() {
        return _mcalId;
    }

    public void setMcalId(long mcalId) {
        _mcalId = mcalId;
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

    public int getState() {
        return _state;
    }

    public void setState(int state) {
        _state = state;
    }

    public String getPlace() {
        return _place;
    }

    public void setPlace(String place) {
        _place = place;
    }

    public String getPlace_diff() {
        return _place_diff;
    }

    public void setPlace_diff(String place_diff) {
        _place_diff = place_diff;
    }

    public String getSponsor() {
        return _sponsor;
    }

    public void setSponsor(String sponsor) {
        _sponsor = sponsor;
    }

    public String getComponent() {
        return _component;
    }

    public void setComponent(String component) {
        _component = component;
    }

    public String getNote() {
        return _note;
    }

    public void setNote(String note) {
        _note = note;
    }

    public long getUserApproved() {
        return _userApproved;
    }

    public void setUserApproved(long userApproved) {
        _userApproved = userApproved;
    }

    public Date getDateApproved() {
        return _dateApproved;
    }

    public void setDateApproved(Date dateApproved) {
        _dateApproved = dateApproved;
    }

    public long getMoveMcalId() {
        return _moveMcalId;
    }

    public void setMoveMcalId(long moveMcalId) {
        _moveMcalId = moveMcalId;
    }

    public boolean getRepeatWeek() {
        return _repeatWeek;
    }

    public boolean isRepeatWeek() {
        return _repeatWeek;
    }

    public void setRepeatWeek(boolean repeatWeek) {
        _repeatWeek = repeatWeek;
    }

    public String getFilename() {
        return _filename;
    }

    public void setFilename(String filename) {
        _filename = filename;
    }

    public boolean getMorning() {
        return _morning;
    }

    public boolean isMorning() {
        return _morning;
    }

    public void setMorning(boolean morning) {
        _morning = morning;
    }

    public boolean getAfternoon() {
        return _afternoon;
    }

    public boolean isAfternoon() {
        return _afternoon;
    }

    public void setAfternoon(boolean afternoon) {
        _afternoon = afternoon;
    }

    public boolean getEvening() {
        return _evening;
    }

    public boolean isEvening() {
        return _evening;
    }

    public void setEvening(boolean evening) {
        _evening = evening;
    }

    public int getStt() {
        return _stt;
    }

    public void setStt(int stt) {
        _stt = stt;
    }

    public boolean getPrior() {
        return _prior;
    }

    public boolean isPrior() {
        return _prior;
    }

    public void setPrior(boolean prior) {
        _prior = prior;
    }

    public boolean getDeleted() {
        return _deleted;
    }

    public boolean isDeleted() {
        return _deleted;
    }

    public void setDeleted(boolean deleted) {
        _deleted = deleted;
    }
}
