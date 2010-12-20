package com.nss.portlet.department.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.nss.portlet.department.model.PmlDepartmentsLeader;
import com.nss.portlet.department.model.PmlDepartmentsLeaderSoap;
import com.nss.portlet.department.service.persistence.PmlDepartmentsLeaderPK;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlDepartmentsLeaderModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlDepartmentsLeader</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.department.model.PmlDepartmentsLeader
 * @see com.nss.portlet.department.model.PmlDepartmentsLeaderModel
 * @see com.nss.portlet.department.model.impl.PmlDepartmentsLeaderImpl
 *
 */
public class PmlDepartmentsLeaderModelImpl extends BaseModelImpl<PmlDepartmentsLeader> {
    public static final String TABLE_NAME = "pml_departmentleader";
    public static final Object[][] TABLE_COLUMNS = {
            { "departmentsId", new Integer(Types.VARCHAR) },
            

            { "userId", new Integer(Types.BIGINT) },
            

            { "main", new Integer(Types.BOOLEAN) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_departmentleader (departmentsId VARCHAR(75) not null,userId LONG not null,main BOOLEAN,primary key (departmentsId, userId))";
    public static final String TABLE_SQL_DROP = "drop table pml_departmentleader";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.entity.cache.enabled.com.nss.portlet.department.model.PmlDepartmentsLeader"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.nss.portlet.department.model.PmlDepartmentsLeader"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.nss.portlet.department.model.PmlDepartmentsLeader"));
    private String _departmentsId;
    private long _userId;
    private boolean _main;

    public PmlDepartmentsLeaderModelImpl() {
    }

    public static PmlDepartmentsLeader toModel(
        PmlDepartmentsLeaderSoap soapModel) {
        PmlDepartmentsLeader model = new PmlDepartmentsLeaderImpl();

        model.setDepartmentsId(soapModel.getDepartmentsId());
        model.setUserId(soapModel.getUserId());
        model.setMain(soapModel.getMain());

        return model;
    }

    public static List<PmlDepartmentsLeader> toModels(
        PmlDepartmentsLeaderSoap[] soapModels) {
        List<PmlDepartmentsLeader> models = new ArrayList<PmlDepartmentsLeader>(soapModels.length);

        for (PmlDepartmentsLeaderSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public PmlDepartmentsLeaderPK getPrimaryKey() {
        return new PmlDepartmentsLeaderPK(_departmentsId, _userId);
    }

    public void setPrimaryKey(PmlDepartmentsLeaderPK pk) {
        setDepartmentsId(pk.departmentsId);
        setUserId(pk.userId);
    }

    public Serializable getPrimaryKeyObj() {
        return new PmlDepartmentsLeaderPK(_departmentsId, _userId);
    }

    public String getDepartmentsId() {
        return GetterUtil.getString(_departmentsId);
    }

    public void setDepartmentsId(String departmentsId) {
        _departmentsId = departmentsId;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public boolean getMain() {
        return _main;
    }

    public boolean isMain() {
        return _main;
    }

    public void setMain(boolean main) {
        _main = main;
    }

    public PmlDepartmentsLeader toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlDepartmentsLeader) this;
        } else {
            PmlDepartmentsLeader model = new PmlDepartmentsLeaderImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setDepartmentsId(HtmlUtil.escape(getDepartmentsId()));
            model.setUserId(getUserId());
            model.setMain(getMain());

            model = (PmlDepartmentsLeader) Proxy.newProxyInstance(PmlDepartmentsLeader.class.getClassLoader(),
                    new Class[] { PmlDepartmentsLeader.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlDepartmentsLeaderImpl clone = new PmlDepartmentsLeaderImpl();

        clone.setDepartmentsId(getDepartmentsId());
        clone.setUserId(getUserId());
        clone.setMain(getMain());

        return clone;
    }

    public int compareTo(PmlDepartmentsLeader pmlDepartmentsLeader) {
        PmlDepartmentsLeaderPK pk = pmlDepartmentsLeader.getPrimaryKey();

        return getPrimaryKey().compareTo(pk);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        PmlDepartmentsLeader pmlDepartmentsLeader = null;

        try {
            pmlDepartmentsLeader = (PmlDepartmentsLeader) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        PmlDepartmentsLeaderPK pk = pmlDepartmentsLeader.getPrimaryKey();

        if (getPrimaryKey().equals(pk)) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return getPrimaryKey().hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("{departmentsId=");
        sb.append(getDepartmentsId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", main=");
        sb.append(getMain());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBuilder sb = new StringBuilder();

        sb.append("<model><model-name>");
        sb.append("com.nss.portlet.department.model.PmlDepartmentsLeader");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>departmentsId</column-name><column-value><![CDATA[");
        sb.append(getDepartmentsId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>main</column-name><column-value><![CDATA[");
        sb.append(getMain());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
