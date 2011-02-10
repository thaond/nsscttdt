package com.sgs.portlet.country.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.country.model.Country;
import com.sgs.portlet.country.model.CountrySoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="CountryModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>Country</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.country.model.Country
 * @see com.sgs.portlet.country.model.CountryModel
 * @see com.sgs.portlet.country.model.impl.CountryImpl
 *
 */
public class CountryModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "PML_Country";
    public static final Object[][] TABLE_COLUMNS = {
            { "countryId", new Integer(Types.VARCHAR) },
            

            { "countryCode", new Integer(Types.VARCHAR) },
            

            { "countryName", new Integer(Types.VARCHAR) },
            

            { "description", new Integer(Types.VARCHAR) },
            

            { "active", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table PML_Country (countryId VARCHAR(75) not null primary key,countryCode VARCHAR(75) null,countryName VARCHAR(75) null,description VARCHAR(75) null,active VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table PML_Country";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.country.model.Country"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.country.model.Country"));
    private String _countryId;
    private String _countryCode;
    private String _countryName;
    private String _description;
    private String _active;

    public CountryModelImpl() {
    }

    public static Country toModel(CountrySoap soapModel) {
        Country model = new CountryImpl();

        model.setCountryId(soapModel.getCountryId());
        model.setCountryCode(soapModel.getCountryCode());
        model.setCountryName(soapModel.getCountryName());
        model.setDescription(soapModel.getDescription());
        model.setActive(soapModel.getActive());

        return model;
    }

    public static List<Country> toModels(CountrySoap[] soapModels) {
        List<Country> models = new ArrayList<Country>(soapModels.length);

        for (CountrySoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public String getPrimaryKey() {
        return _countryId;
    }

    public void setPrimaryKey(String pk) {
        setCountryId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return _countryId;
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

    public String getCountryCode() {
        return GetterUtil.getString(_countryCode);
    }

    public void setCountryCode(String countryCode) {
        if (((countryCode == null) && (_countryCode != null)) ||
                ((countryCode != null) && (_countryCode == null)) ||
                ((countryCode != null) && (_countryCode != null) &&
                !countryCode.equals(_countryCode))) {
            _countryCode = countryCode;
        }
    }

    public String getCountryName() {
        return GetterUtil.getString(_countryName);
    }

    public void setCountryName(String countryName) {
        if (((countryName == null) && (_countryName != null)) ||
                ((countryName != null) && (_countryName == null)) ||
                ((countryName != null) && (_countryName != null) &&
                !countryName.equals(_countryName))) {
            _countryName = countryName;
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

    public Country toEscapedModel() {
        if (isEscapedModel()) {
            return (Country) this;
        } else {
            Country model = new CountryImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setCountryId(HtmlUtil.escape(getCountryId()));
            model.setCountryCode(HtmlUtil.escape(getCountryCode()));
            model.setCountryName(HtmlUtil.escape(getCountryName()));
            model.setDescription(HtmlUtil.escape(getDescription()));
            model.setActive(HtmlUtil.escape(getActive()));

            model = (Country) Proxy.newProxyInstance(Country.class.getClassLoader(),
                    new Class[] { Country.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        CountryImpl clone = new CountryImpl();

        clone.setCountryId(getCountryId());
        clone.setCountryCode(getCountryCode());
        clone.setCountryName(getCountryName());
        clone.setDescription(getDescription());
        clone.setActive(getActive());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        CountryImpl country = (CountryImpl) obj;

        int value = 0;

        value = getCountryName().toLowerCase()
                    .compareTo(country.getCountryName().toLowerCase());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        CountryImpl country = null;

        try {
            country = (CountryImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        String pk = country.getPrimaryKey();

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
