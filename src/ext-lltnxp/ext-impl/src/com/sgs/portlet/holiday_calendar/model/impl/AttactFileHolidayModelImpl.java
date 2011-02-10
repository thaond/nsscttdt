package com.sgs.portlet.holiday_calendar.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.holiday_calendar.model.AttactFileHoliday;
import com.sgs.portlet.holiday_calendar.model.AttactFileHolidaySoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="AttactFileHolidayModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>AttactFileHoliday</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.holiday_calendar.model.AttactFileHoliday
 * @see com.sgs.portlet.holiday_calendar.model.AttactFileHolidayModel
 * @see com.sgs.portlet.holiday_calendar.model.impl.AttactFileHolidayImpl
 *
 */
public class AttactFileHolidayModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "attact_file_holiday";
    public static final Object[][] TABLE_COLUMNS = {
            { "attactFileHolidayId", new Integer(Types.BIGINT) },
            

            { "attactFileHolidayTitle", new Integer(Types.VARCHAR) },
            

            { "attactFileHolidayPath", new Integer(Types.VARCHAR) },
            

            { "holidayCalendarId", new Integer(Types.BIGINT) },
            

            { "userId", new Integer(Types.BIGINT) },
            

            { "groupId", new Integer(Types.BIGINT) },
            

            { "companyId", new Integer(Types.BIGINT) }
        };
    public static final String TABLE_SQL_CREATE = "create table attact_file_holiday (attactFileHolidayId LONG not null primary key,attactFileHolidayTitle VARCHAR(75) null,attactFileHolidayPath VARCHAR(75) null,holidayCalendarId LONG,userId LONG,groupId LONG,companyId LONG)";
    public static final String TABLE_SQL_DROP = "drop table attact_file_holiday";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.holiday_calendar.model.AttactFileHoliday"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.holiday_calendar.model.AttactFileHoliday"));
    private long _attactFileHolidayId;
    private String _attactFileHolidayTitle;
    private String _attactFileHolidayPath;
    private long _holidayCalendarId;
    private long _userId;
    private long _groupId;
    private long _companyId;

    public AttactFileHolidayModelImpl() {
    }

    public static AttactFileHoliday toModel(AttactFileHolidaySoap soapModel) {
        AttactFileHoliday model = new AttactFileHolidayImpl();

        model.setAttactFileHolidayId(soapModel.getAttactFileHolidayId());
        model.setAttactFileHolidayTitle(soapModel.getAttactFileHolidayTitle());
        model.setAttactFileHolidayPath(soapModel.getAttactFileHolidayPath());
        model.setHolidayCalendarId(soapModel.getHolidayCalendarId());
        model.setUserId(soapModel.getUserId());
        model.setGroupId(soapModel.getGroupId());
        model.setCompanyId(soapModel.getCompanyId());

        return model;
    }

    public static List<AttactFileHoliday> toModels(
        AttactFileHolidaySoap[] soapModels) {
        List<AttactFileHoliday> models = new ArrayList<AttactFileHoliday>(soapModels.length);

        for (AttactFileHolidaySoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _attactFileHolidayId;
    }

    public void setPrimaryKey(long pk) {
        setAttactFileHolidayId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_attactFileHolidayId);
    }

    public long getAttactFileHolidayId() {
        return _attactFileHolidayId;
    }

    public void setAttactFileHolidayId(long attactFileHolidayId) {
        if (attactFileHolidayId != _attactFileHolidayId) {
            _attactFileHolidayId = attactFileHolidayId;
        }
    }

    public String getAttactFileHolidayTitle() {
        return GetterUtil.getString(_attactFileHolidayTitle);
    }

    public void setAttactFileHolidayTitle(String attactFileHolidayTitle) {
        if (((attactFileHolidayTitle == null) &&
                (_attactFileHolidayTitle != null)) ||
                ((attactFileHolidayTitle != null) &&
                (_attactFileHolidayTitle == null)) ||
                ((attactFileHolidayTitle != null) &&
                (_attactFileHolidayTitle != null) &&
                !attactFileHolidayTitle.equals(_attactFileHolidayTitle))) {
            _attactFileHolidayTitle = attactFileHolidayTitle;
        }
    }

    public String getAttactFileHolidayPath() {
        return GetterUtil.getString(_attactFileHolidayPath);
    }

    public void setAttactFileHolidayPath(String attactFileHolidayPath) {
        if (((attactFileHolidayPath == null) &&
                (_attactFileHolidayPath != null)) ||
                ((attactFileHolidayPath != null) &&
                (_attactFileHolidayPath == null)) ||
                ((attactFileHolidayPath != null) &&
                (_attactFileHolidayPath != null) &&
                !attactFileHolidayPath.equals(_attactFileHolidayPath))) {
            _attactFileHolidayPath = attactFileHolidayPath;
        }
    }

    public long getHolidayCalendarId() {
        return _holidayCalendarId;
    }

    public void setHolidayCalendarId(long holidayCalendarId) {
        if (holidayCalendarId != _holidayCalendarId) {
            _holidayCalendarId = holidayCalendarId;
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

    public AttactFileHoliday toEscapedModel() {
        if (isEscapedModel()) {
            return (AttactFileHoliday) this;
        } else {
            AttactFileHoliday model = new AttactFileHolidayImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setAttactFileHolidayId(getAttactFileHolidayId());
            model.setAttactFileHolidayTitle(HtmlUtil.escape(
                    getAttactFileHolidayTitle()));
            model.setAttactFileHolidayPath(HtmlUtil.escape(
                    getAttactFileHolidayPath()));
            model.setHolidayCalendarId(getHolidayCalendarId());
            model.setUserId(getUserId());
            model.setGroupId(getGroupId());
            model.setCompanyId(getCompanyId());

            model = (AttactFileHoliday) Proxy.newProxyInstance(AttactFileHoliday.class.getClassLoader(),
                    new Class[] { AttactFileHoliday.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        AttactFileHolidayImpl clone = new AttactFileHolidayImpl();

        clone.setAttactFileHolidayId(getAttactFileHolidayId());
        clone.setAttactFileHolidayTitle(getAttactFileHolidayTitle());
        clone.setAttactFileHolidayPath(getAttactFileHolidayPath());
        clone.setHolidayCalendarId(getHolidayCalendarId());
        clone.setUserId(getUserId());
        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        AttactFileHolidayImpl attactFileHoliday = (AttactFileHolidayImpl) obj;

        long pk = attactFileHoliday.getPrimaryKey();

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

        AttactFileHolidayImpl attactFileHoliday = null;

        try {
            attactFileHoliday = (AttactFileHolidayImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = attactFileHoliday.getPrimaryKey();

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
