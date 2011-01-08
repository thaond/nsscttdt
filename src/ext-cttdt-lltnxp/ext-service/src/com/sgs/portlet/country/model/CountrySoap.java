package com.sgs.portlet.country.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="CountrySoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.country.service.http.CountryServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.country.service.http.CountryServiceSoap
 *
 */
public class CountrySoap implements Serializable {
    private String _countryId;
    private String _countryCode;
    private String _countryName;
    private String _description;
    private String _active;

    public CountrySoap() {
    }

    public static CountrySoap toSoapModel(Country model) {
        CountrySoap soapModel = new CountrySoap();

        soapModel.setCountryId(model.getCountryId());
        soapModel.setCountryCode(model.getCountryCode());
        soapModel.setCountryName(model.getCountryName());
        soapModel.setDescription(model.getDescription());
        soapModel.setActive(model.getActive());

        return soapModel;
    }

    public static CountrySoap[] toSoapModels(List<Country> models) {
        List<CountrySoap> soapModels = new ArrayList<CountrySoap>(models.size());

        for (Country model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new CountrySoap[soapModels.size()]);
    }

    public String getPrimaryKey() {
        return _countryId;
    }

    public void setPrimaryKey(String pk) {
        setCountryId(pk);
    }

    public String getCountryId() {
        return _countryId;
    }

    public void setCountryId(String countryId) {
        _countryId = countryId;
    }

    public String getCountryCode() {
        return _countryCode;
    }

    public void setCountryCode(String countryCode) {
        _countryCode = countryCode;
    }

    public String getCountryName() {
        return _countryName;
    }

    public void setCountryName(String countryName) {
        _countryName = countryName;
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
}
