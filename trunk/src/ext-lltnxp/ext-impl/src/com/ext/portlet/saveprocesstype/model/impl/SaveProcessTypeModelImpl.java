package com.ext.portlet.saveprocesstype.model.impl;

import com.ext.portlet.saveprocesstype.model.SaveProcessType;
import com.ext.portlet.saveprocesstype.model.SaveProcessTypeSoap;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="SaveProcessTypeModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>SaveProcessType</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.ext.portlet.saveprocesstype.model.SaveProcessType
 * @see com.ext.portlet.saveprocesstype.model.SaveProcessTypeModel
 * @see com.ext.portlet.saveprocesstype.model.impl.SaveProcessTypeImpl
 *
 */
public class SaveProcessTypeModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_saveprocesstype";
    public static final Object[][] TABLE_COLUMNS = {
            { "sptid", new Integer(Types.BIGINT) },
            

            { "docId", new Integer(Types.BIGINT) },
            

            { "flagprocesstype", new Integer(Types.BIGINT) },
            

            { "flag", new Integer(Types.BOOLEAN) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_saveprocesstype (sptid LONG not null primary key,docId LONG,flagprocesstype LONG,flag BOOLEAN)";
    public static final String TABLE_SQL_DROP = "drop table pml_saveprocesstype";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.ext.portlet.saveprocesstype.model.SaveProcessType"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.ext.portlet.saveprocesstype.model.SaveProcessType"));
    private long _sptId;
    private long _docId;
    private long _flagProcessType;
    private boolean _flag;

    public SaveProcessTypeModelImpl() {
    }

    public static SaveProcessType toModel(SaveProcessTypeSoap soapModel) {
        SaveProcessType model = new SaveProcessTypeImpl();

        model.setSptId(soapModel.getSptId());
        model.setDocId(soapModel.getDocId());
        model.setFlagProcessType(soapModel.getFlagProcessType());
        model.setFlag(soapModel.getFlag());

        return model;
    }

    public static List<SaveProcessType> toModels(
        SaveProcessTypeSoap[] soapModels) {
        List<SaveProcessType> models = new ArrayList<SaveProcessType>(soapModels.length);

        for (SaveProcessTypeSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _sptId;
    }

    public void setPrimaryKey(long pk) {
        setSptId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_sptId);
    }

    public long getSptId() {
        return _sptId;
    }

    public void setSptId(long sptId) {
        if (sptId != _sptId) {
            _sptId = sptId;
        }
    }

    public long getDocId() {
        return _docId;
    }

    public void setDocId(long docId) {
        if (docId != _docId) {
            _docId = docId;
        }
    }

    public long getFlagProcessType() {
        return _flagProcessType;
    }

    public void setFlagProcessType(long flagProcessType) {
        if (flagProcessType != _flagProcessType) {
            _flagProcessType = flagProcessType;
        }
    }

    public boolean getFlag() {
        return _flag;
    }

    public boolean isFlag() {
        return _flag;
    }

    public void setFlag(boolean flag) {
        if (flag != _flag) {
            _flag = flag;
        }
    }

    public SaveProcessType toEscapedModel() {
        if (isEscapedModel()) {
            return (SaveProcessType) this;
        } else {
            SaveProcessType model = new SaveProcessTypeImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setSptId(getSptId());
            model.setDocId(getDocId());
            model.setFlagProcessType(getFlagProcessType());
            model.setFlag(getFlag());

            model = (SaveProcessType) Proxy.newProxyInstance(SaveProcessType.class.getClassLoader(),
                    new Class[] { SaveProcessType.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        SaveProcessTypeImpl clone = new SaveProcessTypeImpl();

        clone.setSptId(getSptId());
        clone.setDocId(getDocId());
        clone.setFlagProcessType(getFlagProcessType());
        clone.setFlag(getFlag());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        SaveProcessTypeImpl saveProcessType = (SaveProcessTypeImpl) obj;

        int value = 0;

        if (getDocId() < saveProcessType.getDocId()) {
            value = -1;
        } else if (getDocId() > saveProcessType.getDocId()) {
            value = 1;
        } else {
            value = 0;
        }

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        SaveProcessTypeImpl saveProcessType = null;

        try {
            saveProcessType = (SaveProcessTypeImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = saveProcessType.getPrimaryKey();

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
