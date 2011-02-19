package com.ext.portlet.meetingcalendar.model.impl;

import com.ext.portlet.meetingcalendar.model.MeetingCalendar;
import com.ext.portlet.meetingcalendar.model.MeetingCalendarSoap;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="MeetingCalendarModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>MeetingCalendar</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.ext.portlet.meetingcalendar.model.MeetingCalendar
 * @see com.ext.portlet.meetingcalendar.model.MeetingCalendarModel
 * @see com.ext.portlet.meetingcalendar.model.impl.MeetingCalendarImpl
 *
 */
public class MeetingCalendarModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "MeetingCalendar";
    public static final Object[][] TABLE_COLUMNS = {
            { "uuid_", new Integer(Types.VARCHAR) },
            

            { "mcalId", new Integer(Types.BIGINT) },
            

            { "groupId", new Integer(Types.BIGINT) },
            

            { "companyId", new Integer(Types.BIGINT) },
            

            { "userId", new Integer(Types.BIGINT) },
            

            { "userName", new Integer(Types.VARCHAR) },
            

            { "state", new Integer(Types.INTEGER) },
            

            { "place", new Integer(Types.VARCHAR) },
            

            { "place_diff", new Integer(Types.VARCHAR) },
            

            { "sponsor", new Integer(Types.VARCHAR) },
            

            { "component", new Integer(Types.VARCHAR) },
            

            { "note", new Integer(Types.VARCHAR) },
            

            { "userApproved", new Integer(Types.BIGINT) },
            

            { "dateApproved", new Integer(Types.TIMESTAMP) },
            

            { "moveMcalId", new Integer(Types.BIGINT) },
            

            { "repeatWeek", new Integer(Types.BOOLEAN) },
            

            { "filename", new Integer(Types.VARCHAR) },
            

            { "morning", new Integer(Types.BOOLEAN) },
            

            { "afternoon", new Integer(Types.BOOLEAN) },
            

            { "evening", new Integer(Types.BOOLEAN) },
            

            { "stt", new Integer(Types.INTEGER) },
            

            { "prior", new Integer(Types.BOOLEAN) },
            

            { "deleted", new Integer(Types.BOOLEAN) }
        };
    public static final String TABLE_SQL_CREATE = "create table MeetingCalendar (uuid_ VARCHAR(75) null,mcalId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,state INTEGER,place VARCHAR(75) null,place_diff VARCHAR(75) null,sponsor VARCHAR(75) null,component VARCHAR(75) null,note VARCHAR(75) null,userApproved LONG,dateApproved DATE null,moveMcalId LONG,repeatWeek BOOLEAN,filename VARCHAR(75) null,morning BOOLEAN,afternoon BOOLEAN,evening BOOLEAN,stt INTEGER,prior BOOLEAN,deleted BOOLEAN)";
    public static final String TABLE_SQL_DROP = "drop table MeetingCalendar";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.ext.portlet.meetingcalendar.model.MeetingCalendar"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.ext.portlet.meetingcalendar.model.MeetingCalendar"));
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

    public MeetingCalendarModelImpl() {
    }

    public static MeetingCalendar toModel(MeetingCalendarSoap soapModel) {
        MeetingCalendar model = new MeetingCalendarImpl();

        model.setUuid(soapModel.getUuid());
        model.setMcalId(soapModel.getMcalId());
        model.setGroupId(soapModel.getGroupId());
        model.setCompanyId(soapModel.getCompanyId());
        model.setUserId(soapModel.getUserId());
        model.setUserName(soapModel.getUserName());
        model.setState(soapModel.getState());
        model.setPlace(soapModel.getPlace());
        model.setPlace_diff(soapModel.getPlace_diff());
        model.setSponsor(soapModel.getSponsor());
        model.setComponent(soapModel.getComponent());
        model.setNote(soapModel.getNote());
        model.setUserApproved(soapModel.getUserApproved());
        model.setDateApproved(soapModel.getDateApproved());
        model.setMoveMcalId(soapModel.getMoveMcalId());
        model.setRepeatWeek(soapModel.getRepeatWeek());
        model.setFilename(soapModel.getFilename());
        model.setMorning(soapModel.getMorning());
        model.setAfternoon(soapModel.getAfternoon());
        model.setEvening(soapModel.getEvening());
        model.setStt(soapModel.getStt());
        model.setPrior(soapModel.getPrior());
        model.setDeleted(soapModel.getDeleted());

        return model;
    }

    public static List<MeetingCalendar> toModels(
        MeetingCalendarSoap[] soapModels) {
        List<MeetingCalendar> models = new ArrayList<MeetingCalendar>(soapModels.length);

        for (MeetingCalendarSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _mcalId;
    }

    public void setPrimaryKey(long pk) {
        setMcalId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_mcalId);
    }

    public String getUuid() {
        return GetterUtil.getString(_uuid);
    }

    public void setUuid(String uuid) {
        if ((uuid != null) && (uuid != _uuid)) {
            _uuid = uuid;
        }
    }

    public long getMcalId() {
        return _mcalId;
    }

    public void setMcalId(long mcalId) {
        if (mcalId != _mcalId) {
            _mcalId = mcalId;
        }
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        if (groupId != _groupId) {
            _groupId = groupId;
        }
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        if (companyId != _companyId) {
            _companyId = companyId;
        }
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        if (userId != _userId) {
            _userId = userId;
        }
    }

    public String getUserName() {
        return GetterUtil.getString(_userName);
    }

    public void setUserName(String userName) {
        if (((userName == null) && (_userName != null)) ||
                ((userName != null) && (_userName == null)) ||
                ((userName != null) && (_userName != null) &&
                !userName.equals(_userName))) {
            _userName = userName;
        }
    }

    public int getState() {
        return _state;
    }

    public void setState(int state) {
        if (state != _state) {
            _state = state;
        }
    }

    public String getPlace() {
        return GetterUtil.getString(_place);
    }

    public void setPlace(String place) {
        if (((place == null) && (_place != null)) ||
                ((place != null) && (_place == null)) ||
                ((place != null) && (_place != null) && !place.equals(_place))) {
            _place = place;
        }
    }

    public String getPlace_diff() {
        return GetterUtil.getString(_place_diff);
    }

    public void setPlace_diff(String place_diff) {
        if (((place_diff == null) && (_place_diff != null)) ||
                ((place_diff != null) && (_place_diff == null)) ||
                ((place_diff != null) && (_place_diff != null) &&
                !place_diff.equals(_place_diff))) {
            _place_diff = place_diff;
        }
    }

    public String getSponsor() {
        return GetterUtil.getString(_sponsor);
    }

    public void setSponsor(String sponsor) {
        if (((sponsor == null) && (_sponsor != null)) ||
                ((sponsor != null) && (_sponsor == null)) ||
                ((sponsor != null) && (_sponsor != null) &&
                !sponsor.equals(_sponsor))) {
            _sponsor = sponsor;
        }
    }

    public String getComponent() {
        return GetterUtil.getString(_component);
    }

    public void setComponent(String component) {
        if (((component == null) && (_component != null)) ||
                ((component != null) && (_component == null)) ||
                ((component != null) && (_component != null) &&
                !component.equals(_component))) {
            _component = component;
        }
    }

    public String getNote() {
        return GetterUtil.getString(_note);
    }

    public void setNote(String note) {
        if (((note == null) && (_note != null)) ||
                ((note != null) && (_note == null)) ||
                ((note != null) && (_note != null) && !note.equals(_note))) {
            _note = note;
        }
    }

    public long getUserApproved() {
        return _userApproved;
    }

    public void setUserApproved(long userApproved) {
        if (userApproved != _userApproved) {
            _userApproved = userApproved;
        }
    }

    public Date getDateApproved() {
        return _dateApproved;
    }

    public void setDateApproved(Date dateApproved) {
        if (((dateApproved == null) && (_dateApproved != null)) ||
                ((dateApproved != null) && (_dateApproved == null)) ||
                ((dateApproved != null) && (_dateApproved != null) &&
                !dateApproved.equals(_dateApproved))) {
            _dateApproved = dateApproved;
        }
    }

    public long getMoveMcalId() {
        return _moveMcalId;
    }

    public void setMoveMcalId(long moveMcalId) {
        if (moveMcalId != _moveMcalId) {
            _moveMcalId = moveMcalId;
        }
    }

    public boolean getRepeatWeek() {
        return _repeatWeek;
    }

    public boolean isRepeatWeek() {
        return _repeatWeek;
    }

    public void setRepeatWeek(boolean repeatWeek) {
        if (repeatWeek != _repeatWeek) {
            _repeatWeek = repeatWeek;
        }
    }

    public String getFilename() {
        return GetterUtil.getString(_filename);
    }

    public void setFilename(String filename) {
        if (((filename == null) && (_filename != null)) ||
                ((filename != null) && (_filename == null)) ||
                ((filename != null) && (_filename != null) &&
                !filename.equals(_filename))) {
            _filename = filename;
        }
    }

    public boolean getMorning() {
        return _morning;
    }

    public boolean isMorning() {
        return _morning;
    }

    public void setMorning(boolean morning) {
        if (morning != _morning) {
            _morning = morning;
        }
    }

    public boolean getAfternoon() {
        return _afternoon;
    }

    public boolean isAfternoon() {
        return _afternoon;
    }

    public void setAfternoon(boolean afternoon) {
        if (afternoon != _afternoon) {
            _afternoon = afternoon;
        }
    }

    public boolean getEvening() {
        return _evening;
    }

    public boolean isEvening() {
        return _evening;
    }

    public void setEvening(boolean evening) {
        if (evening != _evening) {
            _evening = evening;
        }
    }

    public int getStt() {
        return _stt;
    }

    public void setStt(int stt) {
        if (stt != _stt) {
            _stt = stt;
        }
    }

    public boolean getPrior() {
        return _prior;
    }

    public boolean isPrior() {
        return _prior;
    }

    public void setPrior(boolean prior) {
        if (prior != _prior) {
            _prior = prior;
        }
    }

    public boolean getDeleted() {
        return _deleted;
    }

    public boolean isDeleted() {
        return _deleted;
    }

    public void setDeleted(boolean deleted) {
        if (deleted != _deleted) {
            _deleted = deleted;
        }
    }

    public MeetingCalendar toEscapedModel() {
        if (isEscapedModel()) {
            return (MeetingCalendar) this;
        } else {
            MeetingCalendar model = new MeetingCalendarImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setUuid(HtmlUtil.escape(getUuid()));
            model.setMcalId(getMcalId());
            model.setGroupId(getGroupId());
            model.setCompanyId(getCompanyId());
            model.setUserId(getUserId());
            model.setUserName(HtmlUtil.escape(getUserName()));
            model.setState(getState());
            model.setPlace(HtmlUtil.escape(getPlace()));
            model.setPlace_diff(HtmlUtil.escape(getPlace_diff()));
            model.setSponsor(HtmlUtil.escape(getSponsor()));
            model.setComponent(HtmlUtil.escape(getComponent()));
            model.setNote(HtmlUtil.escape(getNote()));
            model.setUserApproved(getUserApproved());
            model.setDateApproved(getDateApproved());
            model.setMoveMcalId(getMoveMcalId());
            model.setRepeatWeek(getRepeatWeek());
            model.setFilename(HtmlUtil.escape(getFilename()));
            model.setMorning(getMorning());
            model.setAfternoon(getAfternoon());
            model.setEvening(getEvening());
            model.setStt(getStt());
            model.setPrior(getPrior());
            model.setDeleted(getDeleted());

            model = (MeetingCalendar) Proxy.newProxyInstance(MeetingCalendar.class.getClassLoader(),
                    new Class[] { MeetingCalendar.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        MeetingCalendarImpl clone = new MeetingCalendarImpl();

        clone.setUuid(getUuid());
        clone.setMcalId(getMcalId());
        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());
        clone.setUserId(getUserId());
        clone.setUserName(getUserName());
        clone.setState(getState());
        clone.setPlace(getPlace());
        clone.setPlace_diff(getPlace_diff());
        clone.setSponsor(getSponsor());
        clone.setComponent(getComponent());
        clone.setNote(getNote());
        clone.setUserApproved(getUserApproved());
        clone.setDateApproved(getDateApproved());
        clone.setMoveMcalId(getMoveMcalId());
        clone.setRepeatWeek(getRepeatWeek());
        clone.setFilename(getFilename());
        clone.setMorning(getMorning());
        clone.setAfternoon(getAfternoon());
        clone.setEvening(getEvening());
        clone.setStt(getStt());
        clone.setPrior(getPrior());
        clone.setDeleted(getDeleted());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        MeetingCalendarImpl meetingCalendar = (MeetingCalendarImpl) obj;

        int value = 0;

        if (getMcalId() < meetingCalendar.getMcalId()) {
            value = -1;
        } else if (getMcalId() > meetingCalendar.getMcalId()) {
            value = 1;
        } else {
            value = 0;
        }

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        MeetingCalendarImpl meetingCalendar = null;

        try {
            meetingCalendar = (MeetingCalendarImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = meetingCalendar.getPrimaryKey();

        if (getPrimaryKey() == pk) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (int) getPrimaryKey();
    }
}
