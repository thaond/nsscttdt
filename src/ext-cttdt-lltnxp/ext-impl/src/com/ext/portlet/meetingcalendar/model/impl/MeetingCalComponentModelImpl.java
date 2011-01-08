package com.ext.portlet.meetingcalendar.model.impl;

import com.ext.portlet.meetingcalendar.model.MeetingCalComponent;
import com.ext.portlet.meetingcalendar.model.MeetingCalComponentSoap;

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
 * <a href="MeetingCalComponentModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>MeetingCalComponent</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.ext.portlet.meetingcalendar.model.MeetingCalComponent
 * @see com.ext.portlet.meetingcalendar.model.MeetingCalComponentModel
 * @see com.ext.portlet.meetingcalendar.model.impl.MeetingCalComponentImpl
 *
 */
public class MeetingCalComponentModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "MeetingCalComponent";
    public static final Object[][] TABLE_COLUMNS = {
            { "mcalId", new Integer(Types.BIGINT) },
            

            { "groupIds", new Integer(Types.VARCHAR) },
            

            { "startDate", new Integer(Types.TIMESTAMP) }
        };
    public static final String TABLE_SQL_CREATE = "create table MeetingCalComponent (mcalId LONG not null primary key,groupIds VARCHAR(75) null,startDate DATE null)";
    public static final String TABLE_SQL_DROP = "drop table MeetingCalComponent";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.ext.portlet.meetingcalendar.model.MeetingCalComponent"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.ext.portlet.meetingcalendar.model.MeetingCalComponent"));
    private long _mcalId;
    private String _groupIds;
    private Date _startDate;

    public MeetingCalComponentModelImpl() {
    }

    public static MeetingCalComponent toModel(MeetingCalComponentSoap soapModel) {
        MeetingCalComponent model = new MeetingCalComponentImpl();

        model.setMcalId(soapModel.getMcalId());
        model.setGroupIds(soapModel.getGroupIds());
        model.setStartDate(soapModel.getStartDate());

        return model;
    }

    public static List<MeetingCalComponent> toModels(
        MeetingCalComponentSoap[] soapModels) {
        List<MeetingCalComponent> models = new ArrayList<MeetingCalComponent>(soapModels.length);

        for (MeetingCalComponentSoap soapModel : soapModels) {
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

    public long getMcalId() {
        return _mcalId;
    }

    public void setMcalId(long mcalId) {
        if (mcalId != _mcalId) {
            _mcalId = mcalId;
        }
    }

    public String getGroupIds() {
        return GetterUtil.getString(_groupIds);
    }

    public void setGroupIds(String groupIds) {
        if (((groupIds == null) && (_groupIds != null)) ||
                ((groupIds != null) && (_groupIds == null)) ||
                ((groupIds != null) && (_groupIds != null) &&
                !groupIds.equals(_groupIds))) {
            _groupIds = groupIds;
        }
    }

    public Date getStartDate() {
        return _startDate;
    }

    public void setStartDate(Date startDate) {
        if (((startDate == null) && (_startDate != null)) ||
                ((startDate != null) && (_startDate == null)) ||
                ((startDate != null) && (_startDate != null) &&
                !startDate.equals(_startDate))) {
            _startDate = startDate;
        }
    }

    public MeetingCalComponent toEscapedModel() {
        if (isEscapedModel()) {
            return (MeetingCalComponent) this;
        } else {
            MeetingCalComponent model = new MeetingCalComponentImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setMcalId(getMcalId());
            model.setGroupIds(HtmlUtil.escape(getGroupIds()));
            model.setStartDate(getStartDate());

            model = (MeetingCalComponent) Proxy.newProxyInstance(MeetingCalComponent.class.getClassLoader(),
                    new Class[] { MeetingCalComponent.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        MeetingCalComponentImpl clone = new MeetingCalComponentImpl();

        clone.setMcalId(getMcalId());
        clone.setGroupIds(getGroupIds());
        clone.setStartDate(getStartDate());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        MeetingCalComponentImpl meetingCalComponent = (MeetingCalComponentImpl) obj;

        long pk = meetingCalComponent.getPrimaryKey();

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

        MeetingCalComponentImpl meetingCalComponent = null;

        try {
            meetingCalComponent = (MeetingCalComponentImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = meetingCalComponent.getPrimaryKey();

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
