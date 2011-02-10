package com.sgs.portlet.generatetemplateid.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.generatetemplateid.model.IdGenerated;
import com.sgs.portlet.generatetemplateid.model.IdGeneratedSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="IdGeneratedModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>IdGenerated</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.generatetemplateid.model.IdGenerated
 * @see com.sgs.portlet.generatetemplateid.model.IdGeneratedModel
 * @see com.sgs.portlet.generatetemplateid.model.impl.IdGeneratedImpl
 *
 */
public class IdGeneratedModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "PML_IDGENERATED";
    public static final Object[][] TABLE_COLUMNS = {
            { "id", new Integer(Types.BIGINT) },
            

            { "year", new Integer(Types.VARCHAR) },
            

            { "curvalue", new Integer(Types.BIGINT) }
        };
    public static final String TABLE_SQL_CREATE = "create table PML_IDGENERATED (id LONG not null primary key,year VARCHAR(75) null,curvalue LONG)";
    public static final String TABLE_SQL_DROP = "drop table PML_IDGENERATED";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.generatetemplateid.model.IdGenerated"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.generatetemplateid.model.IdGenerated"));
    private long _id;
    private String _year;
    private long _curValue;

    public IdGeneratedModelImpl() {
    }

    public static IdGenerated toModel(IdGeneratedSoap soapModel) {
        IdGenerated model = new IdGeneratedImpl();

        model.setId(soapModel.getId());
        model.setYear(soapModel.getYear());
        model.setCurValue(soapModel.getCurValue());

        return model;
    }

    public static List<IdGenerated> toModels(IdGeneratedSoap[] soapModels) {
        List<IdGenerated> models = new ArrayList<IdGenerated>(soapModels.length);

        for (IdGeneratedSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _id;
    }

    public void setPrimaryKey(long pk) {
        setId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_id);
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        if (id != _id) {
            _id = id;
        }
    }

    public String getYear() {
        return GetterUtil.getString(_year);
    }

    public void setYear(String year) {
        if (((year == null) && (_year != null)) ||
                ((year != null) && (_year == null)) ||
                ((year != null) && (_year != null) && !year.equals(_year))) {
            _year = year;
        }
    }

    public long getCurValue() {
        return _curValue;
    }

    public void setCurValue(long curValue) {
        if (curValue != _curValue) {
            _curValue = curValue;
        }
    }

    public IdGenerated toEscapedModel() {
        if (isEscapedModel()) {
            return (IdGenerated) this;
        } else {
            IdGenerated model = new IdGeneratedImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setId(getId());
            model.setYear(HtmlUtil.escape(getYear()));
            model.setCurValue(getCurValue());

            model = (IdGenerated) Proxy.newProxyInstance(IdGenerated.class.getClassLoader(),
                    new Class[] { IdGenerated.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        IdGeneratedImpl clone = new IdGeneratedImpl();

        clone.setId(getId());
        clone.setYear(getYear());
        clone.setCurValue(getCurValue());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        IdGeneratedImpl idGenerated = (IdGeneratedImpl) obj;

        long pk = idGenerated.getPrimaryKey();

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

        IdGeneratedImpl idGenerated = null;

        try {
            idGenerated = (IdGeneratedImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = idGenerated.getPrimaryKey();

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
