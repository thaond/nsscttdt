package com.sgs.portlet.onedoor.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.onedoor.model.PmlDepartmentsLeader;
import com.sgs.portlet.onedoor.model.PmlDepartmentsLeaderSoap;
import com.sgs.portlet.onedoor.service.persistence.PmlDepartmentsLeaderPK;

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
 * @see com.sgs.portlet.onedoor.model.PmlDepartmentsLeader
 * @see com.sgs.portlet.onedoor.model.PmlDepartmentsLeaderModel
 * @see com.sgs.portlet.onedoor.model.impl.PmlDepartmentsLeaderImpl
 *
 */
public class PmlDepartmentsLeaderModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_departmentleader";
    public static final Object[][] TABLE_COLUMNS = {
            { "departmentsId", new Integer(Types.VARCHAR) },
            

            { "userId", new Integer(Types.BIGINT) },
            

            { "clericalid", new Integer(Types.BIGINT) },
            

            { "main", new Integer(Types.BOOLEAN) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_departmentleader (departmentsId VARCHAR(75) not null,userId LONG not null,clericalid LONG,main BOOLEAN,primary key (departmentsId, userId))";
    public static final String TABLE_SQL_DROP = "drop table pml_departmentleader";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.onedoor.model.PmlDepartmentsLeader"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.onedoor.model.PmlDepartmentsLeader"));
    private String _departmentsId;
    private long _userId;
    private long _clericalId;
    private boolean _main;

    public PmlDepartmentsLeaderModelImpl() {
    }

    public static PmlDepartmentsLeader toModel(
        PmlDepartmentsLeaderSoap soapModel) {
        PmlDepartmentsLeader model = new PmlDepartmentsLeaderImpl();

        model.setDepartmentsId(soapModel.getDepartmentsId());
        model.setUserId(soapModel.getUserId());
        model.setClericalId(soapModel.getClericalId());
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
        if (((departmentsId == null) && (_departmentsId != null)) ||
                ((departmentsId != null) && (_departmentsId == null)) ||
                ((departmentsId != null) && (_departmentsId != null) &&
                !departmentsId.equals(_departmentsId))) {
            _departmentsId = departmentsId;
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

    public long getClericalId() {
        return _clericalId;
    }

    public void setClericalId(long clericalId) {
        if (clericalId != _clericalId) {
            _clericalId = clericalId;
        }
    }

    public boolean getMain() {
        return _main;
    }

    public boolean isMain() {
        return _main;
    }

    public void setMain(boolean main) {
        if (main != _main) {
            _main = main;
        }
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
            model.setClericalId(getClericalId());
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
        clone.setClericalId(getClericalId());
        clone.setMain(getMain());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlDepartmentsLeaderImpl pmlDepartmentsLeader = (PmlDepartmentsLeaderImpl) obj;

        PmlDepartmentsLeaderPK pk = pmlDepartmentsLeader.getPrimaryKey();

        return getPrimaryKey().compareTo(pk);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        PmlDepartmentsLeaderImpl pmlDepartmentsLeader = null;

        try {
            pmlDepartmentsLeader = (PmlDepartmentsLeaderImpl) obj;
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
}
