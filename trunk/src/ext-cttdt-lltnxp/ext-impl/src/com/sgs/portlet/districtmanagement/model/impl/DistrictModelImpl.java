package com.sgs.portlet.districtmanagement.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sgs.portlet.districtmanagement.model.District;
import com.sgs.portlet.districtmanagement.model.DistrictSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="DistrictModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>District</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.districtmanagement.model.District
 * @see com.sgs.portlet.districtmanagement.model.DistrictModel
 * @see com.sgs.portlet.districtmanagement.model.impl.DistrictImpl
 *
 */
public class DistrictModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_district";
    public static final Object[][] TABLE_COLUMNS = {
            { "districtId", new Integer(Types.VARCHAR) },
            

            { "districtCode", new Integer(Types.VARCHAR) },
            

            { "districtName", new Integer(Types.VARCHAR) },
            

            { "cityID", new Integer(Types.VARCHAR) },
            

            { "description", new Integer(Types.VARCHAR) },
            

            { "active", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_district (districtId VARCHAR(75) not null primary key,districtCode VARCHAR(75) null,districtName VARCHAR(75) null,cityID VARCHAR(75) null,description VARCHAR(75) null,active VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table pml_district";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.sgs.portlet.districtmanagement.model.District"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.sgs.portlet.districtmanagement.model.District"));
    private String _districtId;
    private String _districtCode;
    private String _districtName;
    private String _cityID;
    private String _description;
    private String _active;

    public DistrictModelImpl() {
    }

    public static District toModel(DistrictSoap soapModel) {
        District model = new DistrictImpl();

        model.setDistrictId(soapModel.getDistrictId());
        model.setDistrictCode(soapModel.getDistrictCode());
        model.setDistrictName(soapModel.getDistrictName());
        model.setCityID(soapModel.getCityID());
        model.setDescription(soapModel.getDescription());
        model.setActive(soapModel.getActive());

        return model;
    }

    public static List<District> toModels(DistrictSoap[] soapModels) {
        List<District> models = new ArrayList<District>(soapModels.length);

        for (DistrictSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public String getPrimaryKey() {
        return _districtId;
    }

    public void setPrimaryKey(String pk) {
        setDistrictId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return _districtId;
    }

    public String getDistrictId() {
        return GetterUtil.getString(_districtId);
    }

    public void setDistrictId(String districtId) {
        if (((districtId == null) && (_districtId != null)) ||
                ((districtId != null) && (_districtId == null)) ||
                ((districtId != null) && (_districtId != null) &&
                !districtId.equals(_districtId))) {
            _districtId = districtId;
        }
    }

    public String getDistrictCode() {
        return GetterUtil.getString(_districtCode);
    }

    public void setDistrictCode(String districtCode) {
        if (((districtCode == null) && (_districtCode != null)) ||
                ((districtCode != null) && (_districtCode == null)) ||
                ((districtCode != null) && (_districtCode != null) &&
                !districtCode.equals(_districtCode))) {
            _districtCode = districtCode;
        }
    }

    public String getDistrictName() {
        return GetterUtil.getString(_districtName);
    }

    public void setDistrictName(String districtName) {
        if (((districtName == null) && (_districtName != null)) ||
                ((districtName != null) && (_districtName == null)) ||
                ((districtName != null) && (_districtName != null) &&
                !districtName.equals(_districtName))) {
            _districtName = districtName;
        }
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

    public District toEscapedModel() {
        if (isEscapedModel()) {
            return (District) this;
        } else {
            District model = new DistrictImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setDistrictId(HtmlUtil.escape(getDistrictId()));
            model.setDistrictCode(HtmlUtil.escape(getDistrictCode()));
            model.setDistrictName(HtmlUtil.escape(getDistrictName()));
            model.setCityID(HtmlUtil.escape(getCityID()));
            model.setDescription(HtmlUtil.escape(getDescription()));
            model.setActive(HtmlUtil.escape(getActive()));

            model = (District) Proxy.newProxyInstance(District.class.getClassLoader(),
                    new Class[] { District.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        DistrictImpl clone = new DistrictImpl();

        clone.setDistrictId(getDistrictId());
        clone.setDistrictCode(getDistrictCode());
        clone.setDistrictName(getDistrictName());
        clone.setCityID(getCityID());
        clone.setDescription(getDescription());
        clone.setActive(getActive());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        DistrictImpl district = (DistrictImpl) obj;

        int value = 0;

        value = getDistrictName().toLowerCase()
                    .compareTo(district.getDistrictName().toLowerCase());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        DistrictImpl district = null;

        try {
            district = (DistrictImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        String pk = district.getPrimaryKey();

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
