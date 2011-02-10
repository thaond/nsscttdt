package com.ext.portlet.meetingcalendar.model.impl;

import com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight;
import com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeightSoap;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlScreenCalendarHeightModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlScreenCalendarHeight</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight
 * @see com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeightModel
 * @see com.ext.portlet.meetingcalendar.model.impl.PmlScreenCalendarHeightImpl
 *
 */
public class PmlScreenCalendarHeightModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_screencalendar_height";
    public static final Object[][] TABLE_COLUMNS = {
            { "screencalendarheightid", new Integer(Types.BIGINT) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_screencalendar_height (screencalendarheightid LONG not null primary key)";
    public static final String TABLE_SQL_DROP = "drop table pml_screencalendar_height";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight"));
    private long _screenCalendarHeightId;

    public PmlScreenCalendarHeightModelImpl() {
    }

    public static PmlScreenCalendarHeight toModel(
        PmlScreenCalendarHeightSoap soapModel) {
        PmlScreenCalendarHeight model = new PmlScreenCalendarHeightImpl();

        model.setScreenCalendarHeightId(soapModel.getScreenCalendarHeightId());

        return model;
    }

    public static List<PmlScreenCalendarHeight> toModels(
        PmlScreenCalendarHeightSoap[] soapModels) {
        List<PmlScreenCalendarHeight> models = new ArrayList<PmlScreenCalendarHeight>(soapModels.length);

        for (PmlScreenCalendarHeightSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _screenCalendarHeightId;
    }

    public void setPrimaryKey(long pk) {
        setScreenCalendarHeightId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_screenCalendarHeightId);
    }

    public long getScreenCalendarHeightId() {
        return _screenCalendarHeightId;
    }

    public void setScreenCalendarHeightId(long screenCalendarHeightId) {
        if (screenCalendarHeightId != _screenCalendarHeightId) {
            _screenCalendarHeightId = screenCalendarHeightId;
        }
    }

    public PmlScreenCalendarHeight toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlScreenCalendarHeight) this;
        } else {
            PmlScreenCalendarHeight model = new PmlScreenCalendarHeightImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setScreenCalendarHeightId(getScreenCalendarHeightId());

            model = (PmlScreenCalendarHeight) Proxy.newProxyInstance(PmlScreenCalendarHeight.class.getClassLoader(),
                    new Class[] { PmlScreenCalendarHeight.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlScreenCalendarHeightImpl clone = new PmlScreenCalendarHeightImpl();

        clone.setScreenCalendarHeightId(getScreenCalendarHeightId());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlScreenCalendarHeightImpl pmlScreenCalendarHeight = (PmlScreenCalendarHeightImpl) obj;

        long pk = pmlScreenCalendarHeight.getPrimaryKey();

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

        PmlScreenCalendarHeightImpl pmlScreenCalendarHeight = null;

        try {
            pmlScreenCalendarHeight = (PmlScreenCalendarHeightImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = pmlScreenCalendarHeight.getPrimaryKey();

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
