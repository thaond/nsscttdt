package com.sgs.portlet.onedoorpccc.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.onedoorpccc.model.PmlTeamLeader;
import com.sgs.portlet.onedoorpccc.model.PmlTeamLeaderSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlTeamLeaderModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlTeamLeader</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.onedoorpccc.model.PmlTeamLeader
 * @see com.sgs.portlet.onedoorpccc.model.PmlTeamLeaderModel
 * @see com.sgs.portlet.onedoorpccc.model.impl.PmlTeamLeaderImpl
 *
 */
public class PmlTeamLeaderModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_teamleader";
    public static final Object[][] TABLE_COLUMNS = {
            { "teamid", new Integer(Types.BIGINT) },
            

            { "userid", new Integer(Types.BIGINT) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_teamleader (teamid LONG not null primary key,userid LONG)";
    public static final String TABLE_SQL_DROP = "drop table pml_teamleader";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.onedoorpccc.model.PmlTeamLeader"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.onedoorpccc.model.PmlTeamLeader"));
    private long _teamId;
    private long _userId;

    public PmlTeamLeaderModelImpl() {
    }

    public static PmlTeamLeader toModel(PmlTeamLeaderSoap soapModel) {
        PmlTeamLeader model = new PmlTeamLeaderImpl();

        model.setTeamId(soapModel.getTeamId());
        model.setUserId(soapModel.getUserId());

        return model;
    }

    public static List<PmlTeamLeader> toModels(PmlTeamLeaderSoap[] soapModels) {
        List<PmlTeamLeader> models = new ArrayList<PmlTeamLeader>(soapModels.length);

        for (PmlTeamLeaderSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _teamId;
    }

    public void setPrimaryKey(long pk) {
        setTeamId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_teamId);
    }

    public long getTeamId() {
        return _teamId;
    }

    public void setTeamId(long teamId) {
        if (teamId != _teamId) {
            _teamId = teamId;
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

    public PmlTeamLeader toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlTeamLeader) this;
        } else {
            PmlTeamLeader model = new PmlTeamLeaderImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setTeamId(getTeamId());
            model.setUserId(getUserId());

            model = (PmlTeamLeader) Proxy.newProxyInstance(PmlTeamLeader.class.getClassLoader(),
                    new Class[] { PmlTeamLeader.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlTeamLeaderImpl clone = new PmlTeamLeaderImpl();

        clone.setTeamId(getTeamId());
        clone.setUserId(getUserId());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlTeamLeaderImpl pmlTeamLeader = (PmlTeamLeaderImpl) obj;

        int value = 0;

        if (getTeamId() < pmlTeamLeader.getTeamId()) {
            value = -1;
        } else if (getTeamId() > pmlTeamLeader.getTeamId()) {
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

        PmlTeamLeaderImpl pmlTeamLeader = null;

        try {
            pmlTeamLeader = (PmlTeamLeaderImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = pmlTeamLeader.getPrimaryKey();

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
