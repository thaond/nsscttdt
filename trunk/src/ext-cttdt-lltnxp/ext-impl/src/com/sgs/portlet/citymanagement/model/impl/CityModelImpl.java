package com.sgs.portlet.citymanagement.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.citymanagement.model.City;
import com.sgs.portlet.citymanagement.model.CitySoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="CityModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>City</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.citymanagement.model.City
 * @see com.sgs.portlet.citymanagement.model.CityModel
 * @see com.sgs.portlet.citymanagement.model.impl.CityImpl
 *
 */
public class CityModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_city";
    public static final Object[][] TABLE_COLUMNS = {
            { "cityID", new Integer(Types.VARCHAR) },
            

            { "cityCode", new Integer(Types.VARCHAR) },
            

            { "cityName", new Integer(Types.VARCHAR) },
            

            { "description", new Integer(Types.VARCHAR) },
            

            { "active", new Integer(Types.VARCHAR) },
            

            { "countryid", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_city (cityID VARCHAR(75) not null primary key,cityCode VARCHAR(75) null,cityName VARCHAR(75) null,description VARCHAR(75) null,active VARCHAR(75) null,countryid VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table pml_city";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.citymanagement.model.City"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.citymanagement.model.City"));
    private String _cityID;
    private String _cityCode;
    private String _cityName;
    private String _description;
    private String _active;
    private String _countryId;

    public CityModelImpl() {
    }

    public static City toModel(CitySoap soapModel) {
        City model = new CityImpl();

        model.setCityID(soapModel.getCityID());
        model.setCityCode(soapModel.getCityCode());
        model.setCityName(soapModel.getCityName());
        model.setDescription(soapModel.getDescription());
        model.setActive(soapModel.getActive());
        model.setCountryId(soapModel.getCountryId());

        return model;
    }

    public static List<City> toModels(CitySoap[] soapModels) {
        List<City> models = new ArrayList<City>(soapModels.length);

        for (CitySoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public String getPrimaryKey() {
        return _cityID;
    }

    public void setPrimaryKey(String pk) {
        setCityID(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return _cityID;
    }

    public String getCityID() {
        return GetterUtil.getString(_cityID);
    }

    public void setCityID(String cityID) {
        if (((cityID == null) && (_cityID != null)) ||
                ((cityID != null) && (_cityID == null)) ||
                ((cityID != null) && (_cityID != null) &&
                !cityID.equals(_cityID))) {
            _cityID = cityID;
        }
    }

    public String getCityCode() {
        return GetterUtil.getString(_cityCode);
    }

    public void setCityCode(String cityCode) {
        if (((cityCode == null) && (_cityCode != null)) ||
                ((cityCode != null) && (_cityCode == null)) ||
                ((cityCode != null) && (_cityCode != null) &&
                !cityCode.equals(_cityCode))) {
            _cityCode = cityCode;
        }
    }

    public String getCityName() {
        return GetterUtil.getString(_cityName);
    }

    public void setCityName(String cityName) {
        if (((cityName == null) && (_cityName != null)) ||
                ((cityName != null) && (_cityName == null)) ||
                ((cityName != null) && (_cityName != null) &&
                !cityName.equals(_cityName))) {
            _cityName = cityName;
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

    public City toEscapedModel() {
        if (isEscapedModel()) {
            return (City) this;
        } else {
            City model = new CityImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setCityID(HtmlUtil.escape(getCityID()));
            model.setCityCode(HtmlUtil.escape(getCityCode()));
            model.setCityName(HtmlUtil.escape(getCityName()));
            model.setDescription(HtmlUtil.escape(getDescription()));
            model.setActive(HtmlUtil.escape(getActive()));
            model.setCountryId(HtmlUtil.escape(getCountryId()));

            model = (City) Proxy.newProxyInstance(City.class.getClassLoader(),
                    new Class[] { City.class }, new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        CityImpl clone = new CityImpl();

        clone.setCityID(getCityID());
        clone.setCityCode(getCityCode());
        clone.setCityName(getCityName());
        clone.setDescription(getDescription());
        clone.setActive(getActive());
        clone.setCountryId(getCountryId());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        CityImpl city = (CityImpl) obj;

        int value = 0;

        value = getCityName().toLowerCase()
                    .compareTo(city.getCityName().toLowerCase());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        CityImpl city = null;

        try {
            city = (CityImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        String pk = city.getPrimaryKey();

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
