package com.nss.portlet.department.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.impl.ExpandoBridgeImpl;

import com.nss.portlet.department.model.PmlUser;
import com.nss.portlet.department.model.PmlUserSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlUserModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlUser</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.department.model.PmlUser
 * @see com.nss.portlet.department.model.PmlUserModel
 * @see com.nss.portlet.department.model.impl.PmlUserImpl
 *
 */
public class PmlUserModelImpl extends BaseModelImpl<PmlUser> {
    public static final String TABLE_NAME = "pml_user";
    public static final Object[][] TABLE_COLUMNS = {
            { "userid", new Integer(Types.BIGINT) },
            

            { "departmentsid", new Integer(Types.VARCHAR) },
            

            { "positionid", new Integer(Types.VARCHAR) },
            

            { "active", new Integer(Types.BOOLEAN) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_user (userid LONG not null primary key,departmentsid VARCHAR(75) null,positionid VARCHAR(75) null,active BOOLEAN)";
    public static final String TABLE_SQL_DROP = "drop table pml_user";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.entity.cache.enabled.com.nss.portlet.department.model.PmlUser"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.nss.portlet.department.model.PmlUser"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.nss.portlet.department.model.PmlUser"));
    private long _userId;
    private String _departmentsId;
    private String _positionId;
    private Boolean _active;
    private transient ExpandoBridge _expandoBridge;

    public PmlUserModelImpl() {
    }

    public static PmlUser toModel(PmlUserSoap soapModel) {
        PmlUser model = new PmlUserImpl();

        model.setUserId(soapModel.getUserId());
        model.setDepartmentsId(soapModel.getDepartmentsId());
        model.setPositionId(soapModel.getPositionId());
        model.setActive(soapModel.getActive());

        return model;
    }

    public static List<PmlUser> toModels(PmlUserSoap[] soapModels) {
        List<PmlUser> models = new ArrayList<PmlUser>(soapModels.length);

        for (PmlUserSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _userId;
    }

    public void setPrimaryKey(long pk) {
        setUserId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_userId);
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public String getDepartmentsId() {
        return GetterUtil.getString(_departmentsId);
    }

    public void setDepartmentsId(String departmentsId) {
        _departmentsId = departmentsId;
    }

    public String getPositionId() {
        return GetterUtil.getString(_positionId);
    }

    public void setPositionId(String positionId) {
        _positionId = positionId;
    }

    public Boolean getActive() {
        return _active;
    }

    public void setActive(Boolean active) {
        _active = active;
    }

    public PmlUser toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlUser) this;
        } else {
            PmlUser model = new PmlUserImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setUserId(getUserId());
            model.setDepartmentsId(HtmlUtil.escape(getDepartmentsId()));
            model.setPositionId(HtmlUtil.escape(getPositionId()));
            model.setActive(getActive());

            model = (PmlUser) Proxy.newProxyInstance(PmlUser.class.getClassLoader(),
                    new Class[] { PmlUser.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public ExpandoBridge getExpandoBridge() {
        if (_expandoBridge == null) {
            _expandoBridge = new ExpandoBridgeImpl(PmlUser.class.getName(),
                    getPrimaryKey());
        }

        return _expandoBridge;
    }

    public Object clone() {
        PmlUserImpl clone = new PmlUserImpl();

        clone.setUserId(getUserId());
        clone.setDepartmentsId(getDepartmentsId());
        clone.setPositionId(getPositionId());
        clone.setActive(getActive());

        return clone;
    }

    public int compareTo(PmlUser pmlUser) {
        long pk = pmlUser.getPrimaryKey();

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

        PmlUser pmlUser = null;

        try {
            pmlUser = (PmlUser) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = pmlUser.getPrimaryKey();

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

        sb.append("{userId=");
        sb.append(getUserId());
        sb.append(", departmentsId=");
        sb.append(getDepartmentsId());
        sb.append(", positionId=");
        sb.append(getPositionId());
        sb.append(", active=");
        sb.append(getActive());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBuilder sb = new StringBuilder();

        sb.append("<model><model-name>");
        sb.append("com.nss.portlet.department.model.PmlUser");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>departmentsId</column-name><column-value><![CDATA[");
        sb.append(getDepartmentsId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>positionId</column-name><column-value><![CDATA[");
        sb.append(getPositionId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>active</column-name><column-value><![CDATA[");
        sb.append(getActive());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
