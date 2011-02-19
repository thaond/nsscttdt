package com.sgs.portlet.citymanagement.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="CitySoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.citymanagement.service.http.CityServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.citymanagement.service.http.CityServiceSoap
 *
 */
public class CitySoap implements Serializable {
    private String _cityID;
    private String _cityCode;
    private String _cityName;
    private String _description;
    private String _active;
    private String _countryId;

    public CitySoap() {
    }

    public static CitySoap toSoapModel(City model) {
        CitySoap soapModel = new CitySoap();

        soapModel.setCityID(model.getCityID());
        soapModel.setCityCode(model.getCityCode());
        soapModel.setCityName(model.getCityName());
        soapModel.setDescription(model.getDescription());
        soapModel.setActive(model.getActive());
        soapModel.setCountryId(model.getCountryId());

        return soapModel;
    }

    public static CitySoap[] toSoapModels(List<City> models) {
        List<CitySoap> soapModels = new ArrayList<CitySoap>(models.size());

        for (City model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new CitySoap[soapModels.size()]);
    }

    public String getPrimaryKey() {
        return _cityID;
    }

    public void setPrimaryKey(String pk) {
        setCityID(pk);
    }

    public String getCityID() {
        return _cityID;
    }

    public void setCityID(String cityID) {
        _cityID = cityID;
    }

    public String getCityCode() {
        return _cityCode;
    }

    public void setCityCode(String cityCode) {
        _cityCode = cityCode;
    }

    public String getCityName() {
        return _cityName;
    }

    public void setCityName(String cityName) {
        _cityName = cityName;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public String getActive() {
        return _active;
    }

    public void setActive(String active) {
        _active = active;
    }

    public String getCountryId() {
        return _countryId;
    }

    public void setCountryId(String countryId) {
        _countryId = countryId;
    }
}
