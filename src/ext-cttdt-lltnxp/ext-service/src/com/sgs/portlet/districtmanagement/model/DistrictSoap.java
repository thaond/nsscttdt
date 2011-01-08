package com.sgs.portlet.districtmanagement.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="DistrictSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.districtmanagement.service.http.DistrictServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.districtmanagement.service.http.DistrictServiceSoap
 *
 */
public class DistrictSoap implements Serializable {
    private String _districtId;
    private String _districtCode;
    private String _districtName;
    private String _cityID;
    private String _description;
    private String _active;

    public DistrictSoap() {
    }

    public static DistrictSoap toSoapModel(District model) {
        DistrictSoap soapModel = new DistrictSoap();

        soapModel.setDistrictId(model.getDistrictId());
        soapModel.setDistrictCode(model.getDistrictCode());
        soapModel.setDistrictName(model.getDistrictName());
        soapModel.setCityID(model.getCityID());
        soapModel.setDescription(model.getDescription());
        soapModel.setActive(model.getActive());

        return soapModel;
    }

    public static DistrictSoap[] toSoapModels(List<District> models) {
        List<DistrictSoap> soapModels = new ArrayList<DistrictSoap>(models.size());

        for (District model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new DistrictSoap[soapModels.size()]);
    }

    public String getPrimaryKey() {
        return _districtId;
    }

    public void setPrimaryKey(String pk) {
        setDistrictId(pk);
    }

    public String getDistrictId() {
        return _districtId;
    }

    public void setDistrictId(String districtId) {
        _districtId = districtId;
    }

    public String getDistrictCode() {
        return _districtCode;
    }

    public void setDistrictCode(String districtCode) {
        _districtCode = districtCode;
    }

    public String getDistrictName() {
        return _districtName;
    }

    public void setDistrictName(String districtName) {
        _districtName = districtName;
    }

    public String getCityID() {
        return _cityID;
    }

    public void setCityID(String cityID) {
        _cityID = cityID;
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
