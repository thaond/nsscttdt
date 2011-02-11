package com.ext.portlet.meetingcalendar.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <a href="CarResourceSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.ext.portlet.meetingcalendar.service.http.CarResourceServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.ext.portlet.meetingcalendar.service.http.CarResourceServiceSoap
 *
 */
public class CarResourceSoap implements Serializable {
    private long _carId;
    private long _companyId;
    private long _userId;
    private Date _createDate;
    private Date _modifiedDate;
    private String _carName;
    private String _carCode;
    private String _description;

    public CarResourceSoap() {
    }

    public static CarResourceSoap toSoapModel(CarResource model) {
        CarResourceSoap soapModel = new CarResourceSoap();

        soapModel.setCarId(model.getCarId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setCarName(model.getCarName());
        soapModel.setCarCode(model.getCarCode());
        soapModel.setDescription(model.getDescription());

        return soapModel;
    }

    public static CarResourceSoap[] toSoapModels(List<CarResource> models) {
        List<CarResourceSoap> soapModels = new ArrayList<CarResourceSoap>(models.size());

        for (CarResource model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new CarResourceSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _carId;
    }

    public void setPrimaryKey(long pk) {
        setCarId(pk);
    }

    public long getCarId() {
        return _carId;
    }

    public void setCarId(long carId) {
        _carId = carId;
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public Date getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    public Date getModifiedDate() {
        return _modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;
    }

    public String getCarName() {
        return _carName;
    }

    public void setCarName(String carName) {
        _carName = carName;
    }

    public String getCarCode() {
        return _carCode;
    }

    public void setCarCode(String carCode) {
        _carCode = carCode;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }
}
