package com.sgs.portlet.onedoor.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.onedoor.model.PmlAgencyLeader;
import com.sgs.portlet.onedoor.model.PmlAgencyLeaderSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlAgencyLeaderModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>PmlAgencyLeader</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.onedoor.model.PmlAgencyLeader
 * @see com.sgs.portlet.onedoor.model.PmlAgencyLeaderModel
 * @see com.sgs.portlet.onedoor.model.impl.PmlAgencyLeaderImpl
 *
 */
public class PmlAgencyLeaderModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_agencyleader";
    public static final Object[][] TABLE_COLUMNS = {
            { "agencyId", new Integer(Types.VARCHAR) },
            

            { "userId", new Integer(Types.BIGINT) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_agencyleader (agencyId VARCHAR(75) not null primary key,userId LONG)";
    public static final String TABLE_SQL_DROP = "drop table pml_agencyleader";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.onedoor.model.PmlAgencyLeader"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.onedoor.model.PmlAgencyLeader"));
    private String _agencyId;
    private long _userId;

    public PmlAgencyLeaderModelImpl() {
    }

    public static PmlAgencyLeader toModel(PmlAgencyLeaderSoap soapModel) {
        PmlAgencyLeader model = new PmlAgencyLeaderImpl();

        model.setAgencyId(soapModel.getAgencyId());
        model.setUserId(soapModel.getUserId());

        return model;
    }

    public static List<PmlAgencyLeader> toModels(
        PmlAgencyLeaderSoap[] soapModels) {
        List<PmlAgencyLeader> models = new ArrayList<PmlAgencyLeader>(soapModels.length);

        for (PmlAgencyLeaderSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public String getPrimaryKey() {
        return _agencyId;
    }

    public void setPrimaryKey(String pk) {
        setAgencyId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return _agencyId;
    }

    public String getAgencyId() {
        return GetterUtil.getString(_agencyId);
    }

    public void setAgencyId(String agencyId) {
        if (((agencyId == null) && (_agencyId != null)) ||
                ((agencyId != null) && (_agencyId == null)) ||
                ((agencyId != null) && (_agencyId != null) &&
                !agencyId.equals(_agencyId))) {
            _agencyId = agencyId;
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

    public PmlAgencyLeader toEscapedModel() {
        if (isEscapedModel()) {
            return (PmlAgencyLeader) this;
        } else {
            PmlAgencyLeader model = new PmlAgencyLeaderImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setAgencyId(HtmlUtil.escape(getAgencyId()));
            model.setUserId(getUserId());

            model = (PmlAgencyLeader) Proxy.newProxyInstance(PmlAgencyLeader.class.getClassLoader(),
                    new Class[] { PmlAgencyLeader.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        PmlAgencyLeaderImpl clone = new PmlAgencyLeaderImpl();

        clone.setAgencyId(getAgencyId());
        clone.setUserId(getUserId());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        PmlAgencyLeaderImpl pmlAgencyLeader = (PmlAgencyLeaderImpl) obj;

        String pk = pmlAgencyLeader.getPrimaryKey();

        return getPrimaryKey().compareTo(pk);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        PmlAgencyLeaderImpl pmlAgencyLeader = null;

        try {
            pmlAgencyLeader = (PmlAgencyLeaderImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        String pk = pmlAgencyLeader.getPrimaryKey();

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
