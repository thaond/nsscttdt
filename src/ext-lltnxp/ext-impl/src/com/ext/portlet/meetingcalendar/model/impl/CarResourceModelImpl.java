package com.ext.portlet.meetingcalendar.model.impl;

import com.ext.portlet.meetingcalendar.model.CarResource;
import com.ext.portlet.meetingcalendar.model.CarResourceSoap;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="CarResourceModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>CarResource</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.ext.portlet.meetingcalendar.model.CarResource
 * @see com.ext.portlet.meetingcalendar.model.CarResourceModel
 * @see com.ext.portlet.meetingcalendar.model.impl.CarResourceImpl
 *
 */
public class CarResourceModelImpl extends BaseModelImpl {
    public static final String TABLE_NAME = "pml_car_resource";
    public static final Object[][] TABLE_COLUMNS = {
            { "carId", new Integer(Types.BIGINT) },
            

            { "companyId", new Integer(Types.BIGINT) },
            

            { "userId", new Integer(Types.BIGINT) },
            

            { "createDate", new Integer(Types.TIMESTAMP) },
            

            { "modifiedDate", new Integer(Types.TIMESTAMP) },
            

            { "carName", new Integer(Types.VARCHAR) },
            

            { "carCode", new Integer(Types.VARCHAR) },
            

            { "description", new Integer(Types.VARCHAR) }
        };
    public static final String TABLE_SQL_CREATE = "create table pml_car_resource (carId LONG not null primary key,companyId LONG,userId LONG,createDate DATE null,modifiedDate DATE null,carName VARCHAR(255) null,carCode VARCHAR(75) null,description STRING null)";
    public static final String TABLE_SQL_DROP = "drop table pml_car_resource";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
                "value.object.finder.cache.enabled.com.ext.portlet.meetingcalendar.model.CarResource"),
            true);
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
                "lock.expiration.time.com.ext.portlet.meetingcalendar.model.CarResource"));
    private long _carId;
    private long _companyId;
    private long _userId;
    private Date _createDate;
    private Date _modifiedDate;
    private String _carName;
    private String _carCode;
    private String _description;

    public CarResourceModelImpl() {
    }

    public static CarResource toModel(CarResourceSoap soapModel) {
        CarResource model = new CarResourceImpl();

        model.setCarId(soapModel.getCarId());
        model.setCompanyId(soapModel.getCompanyId());
        model.setUserId(soapModel.getUserId());
        model.setCreateDate(soapModel.getCreateDate());
        model.setModifiedDate(soapModel.getModifiedDate());
        model.setCarName(soapModel.getCarName());
        model.setCarCode(soapModel.getCarCode());
        model.setDescription(soapModel.getDescription());

        return model;
    }

    public static List<CarResource> toModels(CarResourceSoap[] soapModels) {
        List<CarResource> models = new ArrayList<CarResource>(soapModels.length);

        for (CarResourceSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _carId;
    }

    public void setPrimaryKey(long pk) {
        setCarId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_carId);
    }

    public long getCarId() {
        return _carId;
    }

    public void setCarId(long carId) {
        if (carId != _carId) {
            _carId = carId;
        }
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        if (companyId != _companyId) {
            _companyId = companyId;
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

    public Date getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(Date createDate) {
        if (((createDate == null) && (_createDate != null)) ||
                ((createDate != null) && (_createDate == null)) ||
                ((createDate != null) && (_createDate != null) &&
                !createDate.equals(_createDate))) {
            _createDate = createDate;
        }
    }

    public Date getModifiedDate() {
        return _modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        if (((modifiedDate == null) && (_modifiedDate != null)) ||
                ((modifiedDate != null) && (_modifiedDate == null)) ||
                ((modifiedDate != null) && (_modifiedDate != null) &&
                !modifiedDate.equals(_modifiedDate))) {
            _modifiedDate = modifiedDate;
        }
    }

    public String getCarName() {
        return GetterUtil.getString(_carName);
    }

    public void setCarName(String carName) {
        if (((carName == null) && (_carName != null)) ||
                ((carName != null) && (_carName == null)) ||
                ((carName != null) && (_carName != null) &&
                !carName.equals(_carName))) {
            _carName = carName;
        }
    }

    public String getCarCode() {
        return GetterUtil.getString(_carCode);
    }

    public void setCarCode(String carCode) {
        if (((carCode == null) && (_carCode != null)) ||
                ((carCode != null) && (_carCode == null)) ||
                ((carCode != null) && (_carCode != null) &&
                !carCode.equals(_carCode))) {
            _carCode = carCode;
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

    public CarResource toEscapedModel() {
        if (isEscapedModel()) {
            return (CarResource) this;
        } else {
            CarResource model = new CarResourceImpl();

            model.setNew(isNew());
            model.setEscapedModel(true);

            model.setCarId(getCarId());
            model.setCompanyId(getCompanyId());
            model.setUserId(getUserId());
            model.setCreateDate(getCreateDate());
            model.setModifiedDate(getModifiedDate());
            model.setCarName(HtmlUtil.escape(getCarName()));
            model.setCarCode(HtmlUtil.escape(getCarCode()));
            model.setDescription(HtmlUtil.escape(getDescription()));

            model = (CarResource) Proxy.newProxyInstance(CarResource.class.getClassLoader(),
                    new Class[] { CarResource.class },
                    new ReadOnlyBeanHandler(model));

            return model;
        }
    }

    public Object clone() {
        CarResourceImpl clone = new CarResourceImpl();

        clone.setCarId(getCarId());
        clone.setCompanyId(getCompanyId());
        clone.setUserId(getUserId());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());
        clone.setCarName(getCarName());
        clone.setCarCode(getCarCode());
        clone.setDescription(getDescription());

        return clone;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }

        CarResourceImpl carResource = (CarResourceImpl) obj;

        int value = 0;

        value = getCarName().compareTo(carResource.getCarName());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        CarResourceImpl carResource = null;

        try {
            carResource = (CarResourceImpl) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = carResource.getPrimaryKey();

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
