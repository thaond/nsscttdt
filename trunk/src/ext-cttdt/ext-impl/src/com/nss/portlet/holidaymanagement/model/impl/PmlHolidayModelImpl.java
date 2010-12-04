package com.nss.portlet.holidaymanagement.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.impl.ExpandoBridgeImpl;

import com.nss.portlet.holidaymanagement.model.PmlHoliday;
import com.nss.portlet.holidaymanagement.model.PmlHolidaySoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="PmlHolidayModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlHoliday</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.holidaymanagement.model.PmlHoliday
 * @see com.nss.portlet.holidaymanagement.model.PmlHolidayModel
 * @see com.nss.portlet.holidaymanagement.model.impl.PmlHolidayImpl
 *
 */
public class PmlHolidayModelImpl extends BaseModelImpl<PmlHoliday> {
    public static final String TABLE_NAME = "pml_holiday";
    public static final Object[][] TABLE_COLUMNS = {
            { "holidayid", new Integer(Types.BIGINT) },
            

            { "holiday_type", new Integer(Types.VARCHAR) },
            

            { "holiday_value", new Integer(Types.VARCHAR) },
            

            { "from_date", new Integer(Types.TIMESTAMP) },
            

            { "to_date", new Integer(Types.TIMESTAMP) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_holiday (holidayid LONG not null primary key,holiday_type VARCHAR(75) null,holiday_value VARCHAR(75) null,from_date DATE null,to_date DATE null)";
    public static final String TABLE_SQL_DROP = "drop table pml_holiday";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.entity.cache.enabled.com.nss.portlet.holidaymanagement.model.PmlHoliday"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.nss.portlet.holidaymanagement.model.PmlHoliday"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.nss.portlet.holidaymanagement.model.PmlHoliday"));
    private long _holidayId;
    private String _holiday_type;
    private String _holiday_value;
    private Date _from_date;
    private Date _to_date;
    private transient ExpandoBridge _expandoBridge;

    public PmlHolidayModelImpl() {
    }

    public static PmlHoliday toModel(PmlHolidaySoap soapModel) {
        PmlHoliday model = new PmlHolidayImpl();

        model.setHolidayId(soapModel.getHolidayId());
        model.setHoliday_type(soapModel.getHoliday_type());
        model.setHoliday_value(soapModel.getHoliday_value());
        model.setFrom_date(soapModel.getFrom_date());
        model.setTo_date(soapModel.getTo_date());

        return model;
    }

    public static List<PmlHoliday> toModels(PmlHolidaySoap[] soapModels) {
        List<PmlHoliday> models = new ArrayList<PmlHoliday>(soapModels.length);

        for (PmlHolidaySoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _holidayId;
    }

    public void setPrimaryKey(long pk) {
        setHolidayId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_holidayId);
    }

    public long getHolidayId() {
        return _holidayId;
    }

    public void setHolidayId(long holidayId) {
        _holidayId = holidayId;
    }

    public String getHoliday_type() {
        return GetterUtil.getString(_holiday_type);
    }

    public void setHoliday_type(String holiday_type) {
        _holiday_type = holiday_type;
    }

    public String getHoliday_value() {
        return GetterUtil.getString(_holiday_value);
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

    public PmlHoliday toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlHoliday) this;
        } else {
            PmlHoliday model = new PmlHolidayImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setHolidayId(getHolidayId());
            model.setHoliday_type(HtmlUtil.escape(getHoliday_type()));
            model.setHoliday_value(HtmlUtil.escape(getHoliday_value()));
            model.setFrom_date(getFrom_date());
            model.setTo_date(getTo_date());

            model = (PmlHoliday) Proxy.newProxyInstance(PmlHoliday.class.getClassLoader(),
                    new Class[] { PmlHoliday.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = new ExpandoBridgeImpl(PmlHoliday.class.getName(),
                    getPrimaryKey());
        }

        return _expandoBridge;
    }

    public Object clone() {
        PmlHolidayImpl clone = new PmlHolidayImpl();

        clone.setHolidayId(getHolidayId());
        clone.setHoliday_type(getHoliday_type());
        clone.setHoliday_value(getHoliday_value());
        clone.setFrom_date(getFrom_date());
        clone.setTo_date(getTo_date());

        return clone;
    }

    public int compareTo(PmlHoliday pmlHoliday) {
        int value = 0;

        if (getHolidayId() < pmlHoliday.getHolidayId()) {
            value = -1;
        } else if (getHolidayId() > pmlHoliday.getHolidayId()) {
            value = 1;
        } else {
            value = 0;
        }

        value = value * -1;

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        PmlHoliday pmlHoliday = null;

        try {
            pmlHoliday = (PmlHoliday) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = pmlHoliday.getPrimaryKey();

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

        sb.append("{holidayId=");
        sb.append(getHolidayId());
        sb.append(", holiday_type=");
        sb.append(getHoliday_type());
        sb.append(", holiday_value=");
        sb.append(getHoliday_value());
        sb.append(", from_date=");
        sb.append(getFrom_date());
        sb.append(", to_date=");
        sb.append(getTo_date());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBuilder sb = new StringBuilder();

        sb.append("<model><model-name>");
        sb.append("com.nss.portlet.holidaymanagement.model.PmlHoliday");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>holidayId</column-name><column-value><![CDATA[");
        sb.append(getHolidayId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>holiday_type</column-name><column-value><![CDATA[");
        sb.append(getHoliday_type());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>holiday_value</column-name><column-value><![CDATA[");
        sb.append(getHoliday_value());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>from_date</column-name><column-value><![CDATA[");
        sb.append(getFrom_date());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>to_date</column-name><column-value><![CDATA[");
        sb.append(getTo_date());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
