package com.ext.portlet.meetingcalendar.model.impl;

import com.ext.portlet.meetingcalendar.model.MeetingDetailWeek;
import com.ext.portlet.meetingcalendar.model.MeetingDetailWeekSoap;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="MeetingDetailWeekModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>MeetingDetailWeek</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.ext.portlet.meetingcalendar.model.MeetingDetailWeek
 * @see com.ext.portlet.meetingcalendar.model.MeetingDetailWeekModel
 * @see com.ext.portlet.meetingcalendar.model.impl.MeetingDetailWeekImpl
 *
 */
public class MeetingDetailWeekModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "MeetingDetailWeek";
    public static final Object[][] TABLE_COLUMNS = {
            { "mdweekId", new Integer(Types.BIGINT) },
            

            { "groupId", new Integer(Types.BIGINT) },
            

            { "companyId", new Integer(Types.BIGINT) },
            

            { "userId", new Integer(Types.BIGINT) },
            

            { "userName", new Integer(Types.VARCHAR) },
            

            { "focus", new Integer(Types.VARCHAR) },
            

            { "note", new Integer(Types.VARCHAR) },
            

            { "receive", new Integer(Types.VARCHAR) },
            

            { "week", new Integer(Types.INTEGER) },
            

            { "year", new Integer(Types.INTEGER) }
        };
    public static final String TABLE_SQL_CREATE = "create table MeetingDetailWeek (mdweekId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,focus VARCHAR(75) null,note VARCHAR(75) null,receive VARCHAR(75) null,week INTEGER,year INTEGER)";
    public static final String TABLE_SQL_DROP = "drop table MeetingDetailWeek";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.ext.portlet.meetingcalendar.model.MeetingDetailWeek"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.ext.portlet.meetingcalendar.model.MeetingDetailWeek"));
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

    public MeetingDetailWeekModelImpl() {
    }

    public static MeetingDetailWeek toModel(MeetingDetailWeekSoap soapModel) {
        MeetingDetailWeek model = new MeetingDetailWeekImpl();

        model.setMdweekId(soapModel.getMdweekId());
        model.setGroupId(soapModel.getGroupId());
        model.setCompanyId(soapModel.getCompanyId());
        model.setUserId(soapModel.getUserId());
        model.setUserName(soapModel.getUserName());
        model.setFocus(soapModel.getFocus());
        model.setNote(soapModel.getNote());
        model.setReceive(soapModel.getReceive());
        model.setWeek(soapModel.getWeek());
        model.setYear(soapModel.getYear());

        return model;
    }

    public static List<MeetingDetailWeek> toModels(
        MeetingDetailWeekSoap[] soapModels) {
        List<MeetingDetailWeek> models = new ArrayList<MeetingDetailWeek>(soapModels.length);

        for (MeetingDetailWeekSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _mdweekId;
    }

    public void setPrimaryKey(long pk) {
        setMdweekId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_mdweekId);
    }

    public long getMdweekId() {
        return _mdweekId;
    }

    public void setMdweekId(long mdweekId) {
        if (mdweekId != _mdweekId) {
            _mdweekId = mdweekId;
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

    public String getFocus() {
        return GetterUtil.getString(_focus);
    }

    public void setFocus(String focus) {
        if (((focus == null) && (_focus != null)) ||
                ((focus != null) && (_focus == null)) ||
                ((focus != null) && (_focus != null) && !focus.equals(_focus))) {
            _focus = focus;
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

    public String getReceive() {
        return GetterUtil.getString(_receive);
    }

    public void setReceive(String receive) {
        if (((receive == null) && (_receive != null)) ||
                ((receive != null) && (_receive == null)) ||
                ((receive != null) && (_receive != null) &&
                !receive.equals(_receive))) {
            _receive = receive;
        }
    }

    public int getWeek() {
        return _week;
    }

    public void setWeek(int week) {
        if (week != _week) {
            _week = week;
        }
    }

    public int getYear() {
        return _year;
    }

    public void setYear(int year) {
        if (year != _year) {
            _year = year;
        }
    }

    public MeetingDetailWeek toEscapedModel() {
        if (isEscapedModel()) {
            return (MeetingDetailWeek) this;
        } else {
            MeetingDetailWeek model = new MeetingDetailWeekImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setMdweekId(getMdweekId());
            model.setGroupId(getGroupId());
            model.setCompanyId(getCompanyId());
            model.setUserId(getUserId());
            model.setUserName(HtmlUtil.escape(getUserName()));
            model.setFocus(HtmlUtil.escape(getFocus()));
            model.setNote(HtmlUtil.escape(getNote()));
            model.setReceive(HtmlUtil.escape(getReceive()));
            model.setWeek(getWeek());
            model.setYear(getYear());

            model = (MeetingDetailWeek) Proxy.newProxyInstance(MeetingDetailWeek.class.getClassLoader(),
                    new Class[] { MeetingDetailWeek.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        MeetingDetailWeekImpl clone = new MeetingDetailWeekImpl();

        clone.setMdweekId(getMdweekId());
        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());
        clone.setUserId(getUserId());
        clone.setUserName(getUserName());
        clone.setFocus(getFocus());
        clone.setNote(getNote());
        clone.setReceive(getReceive());
        clone.setWeek(getWeek());
        clone.setYear(getYear());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        MeetingDetailWeekImpl meetingDetailWeek = (MeetingDetailWeekImpl) obj;

        long pk = meetingDetailWeek.getPrimaryKey();

        if (getPrimaryKey() < pk) {
            return -1;
        } else if (getPrimaryKey() > pk) {
            return 1;
        } else {
            return 0;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        MeetingDetailWeekImpl meetingDetailWeek = null;

        try {
            meetingDetailWeek = (MeetingDetailWeekImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = meetingDetailWeek.getPrimaryKey();

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
