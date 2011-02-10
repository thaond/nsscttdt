package com.ext.portlet.processtype.model.impl;

import com.ext.portlet.processtype.model.ProcessType;
import com.ext.portlet.processtype.model.ProcessTypeSoap;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="ProcessTypeModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>ProcessType</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.ext.portlet.processtype.model.ProcessType
 * @see com.ext.portlet.processtype.model.ProcessTypeModel
 * @see com.ext.portlet.processtype.model.impl.ProcessTypeImpl
 *
 */
public class ProcessTypeModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_processtype";
    public static final Object[][] TABLE_COLUMNS = {
            { "processtypeid", new Integer(Types.BIGINT) },
            

            { "name", new Integer(Types.VARCHAR) },
            

            { "flagprocesstype", new Integer(Types.INTEGER) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_processtype (processtypeid LONG not null primary key,name VARCHAR(75) null,flagprocesstype INTEGER)";
    public static final String TABLE_SQL_DROP = "drop table pml_processtype";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.ext.portlet.processtype.model.ProcessType"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.ext.portlet.processtype.model.ProcessType"));
    private long _processTypeId;
    private String _name;
    private int _flagProcessType;

    public ProcessTypeModelImpl() {
    }

    public static ProcessType toModel(ProcessTypeSoap soapModel) {
        ProcessType model = new ProcessTypeImpl();

        model.setProcessTypeId(soapModel.getProcessTypeId());
        model.setName(soapModel.getName());
        model.setFlagProcessType(soapModel.getFlagProcessType());

        return model;
    }

    public static List<ProcessType> toModels(ProcessTypeSoap[] soapModels) {
        List<ProcessType> models = new ArrayList<ProcessType>(soapModels.length);

        for (ProcessTypeSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _processTypeId;
    }

    public void setPrimaryKey(long pk) {
        setProcessTypeId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_processTypeId);
    }

    public long getProcessTypeId() {
        return _processTypeId;
    }

    public void setProcessTypeId(long processTypeId) {
        if (processTypeId != _processTypeId) {
            _processTypeId = processTypeId;
        }
    }

    public String getName() {
        return GetterUtil.getString(_name);
    }

    public void setName(String name) {
        if (((name == null) && (_name != null)) ||
                ((name != null) && (_name == null)) ||
                ((name != null) && (_name != null) && !name.equals(_name))) {
            _name = name;
        }
    }

    public int getFlagProcessType() {
        return _flagProcessType;
    }

    public void setFlagProcessType(int flagProcessType) {
        if (flagProcessType != _flagProcessType) {
            _flagProcessType = flagProcessType;
        }
    }

    public ProcessType toEscapedModel() {
        if (isEscapedModel()) {
            return (ProcessType) this;
        } else {
            ProcessType model = new ProcessTypeImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setProcessTypeId(getProcessTypeId());
            model.setName(HtmlUtil.escape(getName()));
            model.setFlagProcessType(getFlagProcessType());

            model = (ProcessType) Proxy.newProxyInstance(ProcessType.class.getClassLoader(),
                    new Class[] { ProcessType.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        ProcessTypeImpl clone = new ProcessTypeImpl();

        clone.setProcessTypeId(getProcessTypeId());
        clone.setName(getName());
        clone.setFlagProcessType(getFlagProcessType());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        ProcessTypeImpl processType = (ProcessTypeImpl) obj;

        int value = 0;

        value = getName().toLowerCase()
                    .compareTo(processType.getName().toLowerCase());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        ProcessTypeImpl processType = null;

        try {
            processType = (ProcessTypeImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = processType.getPrimaryKey();

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
