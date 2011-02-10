package com.sgs.portlet.holiday_calendar.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.holiday_calendar.model.HolidayCalendar;
import com.sgs.portlet.holiday_calendar.model.HolidayCalendarSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="HolidayCalendarModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>HolidayCalendar</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.holiday_calendar.model.HolidayCalendar
 * @see com.sgs.portlet.holiday_calendar.model.HolidayCalendarModel
 * @see com.sgs.portlet.holiday_calendar.model.impl.HolidayCalendarImpl
 *
 */
public class HolidayCalendarModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "holiday_calendar";
    public static final Object[][] TABLE_COLUMNS = {
            { "holidayCalendarId", new Integer(Types.BIGINT) },
            

            { "holidayCalendarCode", new Integer(Types.VARCHAR) },
            

            { "holidayCalendarDateCreate", new Integer(Types.TIMESTAMP) },
            

            { "holidayCalendarTitle", new Integer(Types.VARCHAR) },
            

            { "userId", new Integer(Types.BIGINT) },
            

            { "groupId", new Integer(Types.BIGINT) },
            

            { "companyId", new Integer(Types.BIGINT) }
        };
    public static final String TABLE_SQL_CREATE = "create table holiday_calendar (holidayCalendarId LONG not null primary key,holidayCalendarCode VARCHAR(75) null,holidayCalendarDateCreate DATE null,holidayCalendarTitle VARCHAR(75) null,userId LONG,groupId LONG,companyId LONG)";
    public static final String TABLE_SQL_DROP = "drop table holiday_calendar";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.holiday_calendar.model.HolidayCalendar"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.holiday_calendar.model.HolidayCalendar"));
    private long _holidayCalendarId;
    private String _holidayCalendarCode;
    private Date _holidayCalendarDateCreate;
    private String _holidayCalendarTitle;
    private long _userId;
    private long _groupId;
    private long _companyId;

    public HolidayCalendarModelImpl() {
    }

    public static HolidayCalendar toModel(HolidayCalendarSoap soapModel) {
        HolidayCalendar model = new HolidayCalendarImpl();

        model.setHolidayCalendarId(soapModel.getHolidayCalendarId());
        model.setHolidayCalendarCode(soapModel.getHolidayCalendarCode());
        model.setHolidayCalendarDateCreate(soapModel.getHolidayCalendarDateCreate());
        model.setHolidayCalendarTitle(soapModel.getHolidayCalendarTitle());
        model.setUserId(soapModel.getUserId());
        model.setGroupId(soapModel.getGroupId());
        model.setCompanyId(soapModel.getCompanyId());

        return model;
    }

    public static List<HolidayCalendar> toModels(
        HolidayCalendarSoap[] soapModels) {
        List<HolidayCalendar> models = new ArrayList<HolidayCalendar>(soapModels.length);

        for (HolidayCalendarSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _holidayCalendarId;
    }

    public void setPrimaryKey(long pk) {
        setHolidayCalendarId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_holidayCalendarId);
    }

    public long getHolidayCalendarId() {
        return _holidayCalendarId;
    }

    public void setHolidayCalendarId(long holidayCalendarId) {
        if (holidayCalendarId != _holidayCalendarId) {
            _holidayCalendarId = holidayCalendarId;
        }
    }

    public String getHolidayCalendarCode() {
        return GetterUtil.getString(_holidayCalendarCode);
    }

    public void setHolidayCalendarCode(String holidayCalendarCode) {
        if (((holidayCalendarCode == null) && (_holidayCalendarCode != null)) ||
                ((holidayCalendarCode != null) &&
                (_holidayCalendarCode == null)) ||
                ((holidayCalendarCode != null) &&
                (_holidayCalendarCode != null) &&
                !holidayCalendarCode.equals(_holidayCalendarCode))) {
            _holidayCalendarCode = holidayCalendarCode;
        }
    }

    public Date getHolidayCalendarDateCreate() {
        return _holidayCalendarDateCreate;
    }

    public void setHolidayCalendarDateCreate(Date holidayCalendarDateCreate) {
        if (((holidayCalendarDateCreate == null) &&
                (_holidayCalendarDateCreate != null)) ||
                ((holidayCalendarDateCreate != null) &&
                (_holidayCalendarDateCreate == null)) ||
                ((holidayCalendarDateCreate != null) &&
                (_holidayCalendarDateCreate != null) &&
                !holidayCalendarDateCreate.equals(_holidayCalendarDateCreate))) {
            _holidayCalendarDateCreate = holidayCalendarDateCreate;
        }
    }

    public String getHolidayCalendarTitle() {
        return GetterUtil.getString(_holidayCalendarTitle);
    }

    public void setHolidayCalendarTitle(String holidayCalendarTitle) {
        if (((holidayCalendarTitle == null) && (_holidayCalendarTitle != null)) ||
                ((holidayCalendarTitle != null) &&
                (_holidayCalendarTitle == null)) ||
                ((holidayCalendarTitle != null) &&
                (_holidayCalendarTitle != null) &&
                !holidayCalendarTitle.equals(_holidayCalendarTitle))) {
            _holidayCalendarTitle = holidayCalendarTitle;
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

    public HolidayCalendar toEscapedModel() {
        if (isEscapedModel()) {
            return (HolidayCalendar) this;
        } else {
            HolidayCalendar model = new HolidayCalendarImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setHolidayCalendarId(getHolidayCalendarId());
            model.setHolidayCalendarCode(HtmlUtil.escape(
                    getHolidayCalendarCode()));
            model.setHolidayCalendarDateCreate(getHolidayCalendarDateCreate());
            model.setHolidayCalendarTitle(HtmlUtil.escape(
                    getHolidayCalendarTitle()));
            model.setUserId(getUserId());
            model.setGroupId(getGroupId());
            model.setCompanyId(getCompanyId());

            model = (HolidayCalendar) Proxy.newProxyInstance(HolidayCalendar.class.getClassLoader(),
                    new Class[] { HolidayCalendar.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        HolidayCalendarImpl clone = new HolidayCalendarImpl();

        clone.setHolidayCalendarId(getHolidayCalendarId());
        clone.setHolidayCalendarCode(getHolidayCalendarCode());
        clone.setHolidayCalendarDateCreate(getHolidayCalendarDateCreate());
        clone.setHolidayCalendarTitle(getHolidayCalendarTitle());
        clone.setUserId(getUserId());
        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        HolidayCalendarImpl holidayCalendar = (HolidayCalendarImpl) obj;

        long pk = holidayCalendar.getPrimaryKey();

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

        HolidayCalendarImpl holidayCalendar = null;

        try {
            holidayCalendar = (HolidayCalendarImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = holidayCalendar.getPrimaryKey();

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
