package com.ext.portlet.meetingcalendar.model.impl;

import com.ext.portlet.meetingcalendar.model.MeetingCalendar;
import com.ext.portlet.meetingcalendar.model.MeetingCalendarSoap;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.impl.ExpandoBridgeImpl;

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
public class MeetingCalendarModelImpl extends BaseModelImpl<MeetingCalendar> {
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
            

            { "prior", new Integer(Types.BOOLEAN) }
        };
    public static final String TABLE_SQL_CREATE = "create table MeetingCalendar (uuid_ VARCHAR(75) null,mcalId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,state INTEGER,place VARCHAR(75) null,place_diff VARCHAR(75) null,sponsor VARCHAR(75) null,component VARCHAR(75) null,note VARCHAR(75) null,userApproved LONG,dateApproved DATE null,moveMcalId LONG,repeatWeek BOOLEAN,filename VARCHAR(75) null,morning BOOLEAN,afternoon BOOLEAN,evening BOOLEAN,stt INTEGER,prior BOOLEAN)";
    public static final String TABLE_SQL_DROP = "drop table MeetingCalendar";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.entity.cache.enabled.com.ext.portlet.meetingcalendar.model.MeetingCalendar"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.ext.portlet.meetingcalendar.model.MeetingCalendar"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.ext.portlet.meetingcalendar.model.MeetingCalendar"));
    private String _uuid;
    private String _originalUuid;
    private long _mcalId;
    private long _groupId;
    private long _originalGroupId;
    private boolean _setOriginalGroupId;
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
    private transient ExpandoBridge _expandoBridge;

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
        _uuid = uuid;

        if (_originalUuid == null) {
            _originalUuid = uuid;
        }
    }

    public String getOriginalUuid() {
        return GetterUtil.getString(_originalUuid);
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

        if (!_setOriginalGroupId) {
            _setOriginalGroupId = true;

            _originalGroupId = groupId;
        }
    }

    public long getOriginalGroupId() {
        return _originalGroupId;
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
        return GetterUtil.getString(_userName);
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
        return GetterUtil.getString(_place);
    }

    public void setPlace(String place) {
        _place = place;
    }

    public String getPlace_diff() {
        return GetterUtil.getString(_place_diff);
    }

    public void setPlace_diff(String place_diff) {
        _place_diff = place_diff;
    }

    public String getSponsor() {
        return GetterUtil.getString(_sponsor);
    }

    public void setSponsor(String sponsor) {
        _sponsor = sponsor;
    }

    public String getComponent() {
        return GetterUtil.getString(_component);
    }

    public void setComponent(String component) {
        _component = component;
    }

    public String getNote() {
        return GetterUtil.getString(_note);
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
        return GetterUtil.getString(_filename);
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

            model = (MeetingCalendar) Proxy.newProxyInstance(MeetingCalendar.class.getClassLoader(),
                    new Class[] { MeetingCalendar.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = new ExpandoBridgeImpl(MeetingCalendar.class.getName(),
                    getPrimaryKey());
        }

        return _expandoBridge;
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

        return clone;
    }

    public int compareTo(MeetingCalendar meetingCalendar) {
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

        MeetingCalendar meetingCalendar = null;

        try {
            meetingCalendar = (MeetingCalendar) obj;
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

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("{uuid=");
        sb.append(getUuid());
        sb.append(", mcalId=");
        sb.append(getMcalId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", userName=");
        sb.append(getUserName());
        sb.append(", state=");
        sb.append(getState());
        sb.append(", place=");
        sb.append(getPlace());
        sb.append(", place_diff=");
        sb.append(getPlace_diff());
        sb.append(", sponsor=");
        sb.append(getSponsor());
        sb.append(", component=");
        sb.append(getComponent());
        sb.append(", note=");
        sb.append(getNote());
        sb.append(", userApproved=");
        sb.append(getUserApproved());
        sb.append(", dateApproved=");
        sb.append(getDateApproved());
        sb.append(", moveMcalId=");
        sb.append(getMoveMcalId());
        sb.append(", repeatWeek=");
        sb.append(getRepeatWeek());
        sb.append(", filename=");
        sb.append(getFilename());
        sb.append(", morning=");
        sb.append(getMorning());
        sb.append(", afternoon=");
        sb.append(getAfternoon());
        sb.append(", evening=");
        sb.append(getEvening());
        sb.append(", stt=");
        sb.append(getStt());
        sb.append(", prior=");
        sb.append(getPrior());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBuilder sb = new StringBuilder();

        sb.append("<model><model-name>");
        sb.append("com.ext.portlet.meetingcalendar.model.MeetingCalendar");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>uuid</column-name><column-value><![CDATA[");
        sb.append(getUuid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>mcalId</column-name><column-value><![CDATA[");
        sb.append(getMcalId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>groupId</column-name><column-value><![CDATA[");
        sb.append(getGroupId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>companyId</column-name><column-value><![CDATA[");
        sb.append(getCompanyId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userName</column-name><column-value><![CDATA[");
        sb.append(getUserName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>state</column-name><column-value><![CDATA[");
        sb.append(getState());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>place</column-name><column-value><![CDATA[");
        sb.append(getPlace());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>place_diff</column-name><column-value><![CDATA[");
        sb.append(getPlace_diff());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>sponsor</column-name><column-value><![CDATA[");
        sb.append(getSponsor());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>component</column-name><column-value><![CDATA[");
        sb.append(getComponent());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>note</column-name><column-value><![CDATA[");
        sb.append(getNote());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userApproved</column-name><column-value><![CDATA[");
        sb.append(getUserApproved());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>dateApproved</column-name><column-value><![CDATA[");
        sb.append(getDateApproved());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>moveMcalId</column-name><column-value><![CDATA[");
        sb.append(getMoveMcalId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>repeatWeek</column-name><column-value><![CDATA[");
        sb.append(getRepeatWeek());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>filename</column-name><column-value><![CDATA[");
        sb.append(getFilename());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>morning</column-name><column-value><![CDATA[");
        sb.append(getMorning());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>afternoon</column-name><column-value><![CDATA[");
        sb.append(getAfternoon());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>evening</column-name><column-value><![CDATA[");
        sb.append(getEvening());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>stt</column-name><column-value><![CDATA[");
        sb.append(getStt());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>prior</column-name><column-value><![CDATA[");
        sb.append(getPrior());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
