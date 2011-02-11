package com.sgs.portlet.signer.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.signer.model.Signer;
import com.sgs.portlet.signer.model.SignerSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="SignerModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>Signer</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.signer.model.Signer
 * @see com.sgs.portlet.signer.model.SignerModel
 * @see com.sgs.portlet.signer.model.impl.SignerImpl
 *
 */
public class SignerModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_signer";
    public static final Object[][] TABLE_COLUMNS = {
            { "signerId", new Integer(Types.BIGINT) },
            

            { "userId", new Integer(Types.BIGINT) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_signer (signerId LONG not null primary key,userId LONG)";
    public static final String TABLE_SQL_DROP = "drop table pml_signer";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.signer.model.Signer"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.signer.model.Signer"));
    private long _signerId;
    private long _userId;

    public SignerModelImpl() {
    }

    public static Signer toModel(SignerSoap soapModel) {
        Signer model = new SignerImpl();

        model.setSignerId(soapModel.getSignerId());
        model.setUserId(soapModel.getUserId());

        return model;
    }

    public static List<Signer> toModels(SignerSoap[] soapModels) {
        List<Signer> models = new ArrayList<Signer>(soapModels.length);

        for (SignerSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _signerId;
    }

    public void setPrimaryKey(long pk) {
        setSignerId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_signerId);
    }

    public long getSignerId() {
        return _signerId;
    }

    public void setSignerId(long signerId) {
        if (signerId != _signerId) {
            _signerId = signerId;
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

    public Signer toEscapedModel() {
        if (isEscapedModel()) {
            return (Signer) this;
        } else {
            Signer model = new SignerImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setSignerId(getSignerId());
            model.setUserId(getUserId());

            model = (Signer) Proxy.newProxyInstance(Signer.class.getClassLoader(),
                    new Class[] { Signer.class }, new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        SignerImpl clone = new SignerImpl();

        clone.setSignerId(getSignerId());
        clone.setUserId(getUserId());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        SignerImpl signer = (SignerImpl) obj;

        long pk = signer.getPrimaryKey();

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

        SignerImpl signer = null;

        try {
            signer = (SignerImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = signer.getPrimaryKey();

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
