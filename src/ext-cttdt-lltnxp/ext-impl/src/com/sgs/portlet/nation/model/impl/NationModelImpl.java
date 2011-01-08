package com.sgs.portlet.nation.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.nation.model.Nation;
import com.sgs.portlet.nation.model.NationSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="NationModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>Nation</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.nation.model.Nation
 * @see com.sgs.portlet.nation.model.NationModel
 * @see com.sgs.portlet.nation.model.impl.NationImpl
 *
 */
public class NationModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_nation";
    public static final Object[][] TABLE_COLUMNS = {
            { "nationid", new Integer(Types.VARCHAR) },
            

            { "nationcode", new Integer(Types.VARCHAR) },
            

            { "nationname", new Integer(Types.VARCHAR) },
            

            { "countryid", new Integer(Types.VARCHAR) },
            

            { "description", new Integer(Types.VARCHAR) },
            

            { "active", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_nation (nationid VARCHAR(75) not null primary key,nationcode VARCHAR(75) null,nationname VARCHAR(75) null,countryid VARCHAR(75) null,description VARCHAR(75) null,active VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table pml_nation";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.nation.model.Nation"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.nation.model.Nation"));
    private String _nationId;
    private String _nationCode;
    private String _nationName;
    private String _countryId;
    private String _description;
    private String _active;

    public NationModelImpl() {
    }

    public static Nation toModel(NationSoap soapModel) {
        Nation model = new NationImpl();

        model.setNationId(soapModel.getNationId());
        model.setNationCode(soapModel.getNationCode());
        model.setNationName(soapModel.getNationName());
        model.setCountryId(soapModel.getCountryId());
        model.setDescription(soapModel.getDescription());
        model.setActive(soapModel.getActive());

        return model;
    }

    public static List<Nation> toModels(NationSoap[] soapModels) {
        List<Nation> models = new ArrayList<Nation>(soapModels.length);

        for (NationSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public String getPrimaryKey() {
        return _nationId;
    }

    public void setPrimaryKey(String pk) {
        setNationId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return _nationId;
    }

    public String getNationId() {
        return GetterUtil.getString(_nationId);
    }

    public void setNationId(String nationId) {
        if (((nationId == null) && (_nationId != null)) ||
                ((nationId != null) && (_nationId == null)) ||
                ((nationId != null) && (_nationId != null) &&
                !nationId.equals(_nationId))) {
            _nationId = nationId;
        }
    }

    public String getNationCode() {
        return GetterUtil.getString(_nationCode);
    }

    public void setNationCode(String nationCode) {
        if (((nationCode == null) && (_nationCode != null)) ||
                ((nationCode != null) && (_nationCode == null)) ||
                ((nationCode != null) && (_nationCode != null) &&
                !nationCode.equals(_nationCode))) {
            _nationCode = nationCode;
        }
    }

    public String getNationName() {
        return GetterUtil.getString(_nationName);
    }

    public void setNationName(String nationName) {
        if (((nationName == null) && (_nationName != null)) ||
                ((nationName != null) && (_nationName == null)) ||
                ((nationName != null) && (_nationName != null) &&
                !nationName.equals(_nationName))) {
            _nationName = nationName;
        }
    }

    public String getCountryId() {
        return GetterUtil.getString(_countryId);
    }

    public void setCountryId(String countryId) {
        if (((countryId == null) && (_countryId != null)) ||
                ((countryId != null) && (_countryId == null)) ||
                ((countryId != null) && (_countryId != null) &&
                !countryId.equals(_countryId))) {
            _countryId = countryId;
        }
    }

    public String getDescription() {
        return GetterUtil.getString(_description);
    }

    public void setDescription(String description) {
        if (((description == null) && (_description != null)) ||
                ((description != null) && (_description == null)) ||
                ((description != null) && (_description != null) &&
                !description.equals(_description))) {
            _description = description;
        }
    }

    public String getActive() {
        return GetterUtil.getString(_active);
    }

    public void setActive(String active) {
        if (((active == null) && (_active != null)) ||
                ((active != null) && (_active == null)) ||
                ((active != null) && (_active != null) &&
                !active.equals(_active))) {
            _active = active;
        }
    }

    public Nation toEscapedModel() {
        if (isEscapedModel()) {
            return (Nation) this;
        } else {
            Nation model = new NationImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setNationId(HtmlUtil.escape(getNationId()));
            model.setNationCode(HtmlUtil.escape(getNationCode()));
            model.setNationName(HtmlUtil.escape(getNationName()));
            model.setCountryId(HtmlUtil.escape(getCountryId()));
            model.setDescription(HtmlUtil.escape(getDescription()));
            model.setActive(HtmlUtil.escape(getActive()));

            model = (Nation) Proxy.newProxyInstance(Nation.class.getClassLoader(),
                    new Class[] { Nation.class }, new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        NationImpl clone = new NationImpl();

        clone.setNationId(getNationId());
        clone.setNationCode(getNationCode());
        clone.setNationName(getNationName());
        clone.setCountryId(getCountryId());
        clone.setDescription(getDescription());
        clone.setActive(getActive());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        NationImpl nation = (NationImpl) obj;

        int value = 0;

        value = getNationId().compareTo(nation.getNationId());

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

        NationImpl nation = null;

        try {
            nation = (NationImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        String pk = nation.getPrimaryKey();

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
