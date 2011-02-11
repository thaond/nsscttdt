package com.sgs.portlet.wardsmanagement.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="WardsSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.wardsmanagement.service.http.WardsServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.wardsmanagement.service.http.WardsServiceSoap
 *
 */
public class WardsSoap implements Serializable {
    private String _wardsId;
    private String _wardsCode;
    private String _wardsName;
    private String _districtId;
    private String _description;
    private String _active;

    public WardsSoap() {
    }

    public static WardsSoap toSoapModel(Wards model) {
        WardsSoap soapModel = new WardsSoap();

        soapModel.setWardsId(model.getWardsId());
        soapModel.setWardsCode(model.getWardsCode());
        soapModel.setWardsName(model.getWardsName());
        soapModel.setDistrictId(model.getDistrictId());
        soapModel.setDescription(model.getDescription());
        soapModel.setActive(model.getActive());

        return soapModel;
    }

    public static WardsSoap[] toSoapModels(List<Wards> models) {
        List<WardsSoap> soapModels = new ArrayList<WardsSoap>(models.size());

        for (Wards model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new WardsSoap[soapModels.size()]);
    }

    public String getPrimaryKey() {
        return _wardsId;
    }

    public void setPrimaryKey(String pk) {
        setWardsId(pk);
    }

    public String getWardsId() {
        return _wardsId;
    }

    public void setWardsId(String wardsId) {
        _wardsId = wardsId;
    }

    public String getWardsCode() {
        return _wardsCode;
    }

    public void setWardsCode(String wardsCode) {
        _wardsCode = wardsCode;
    }

    public String getWardsName() {
        return _wardsName;
    }

    public void setWardsName(String wardsName) {
        _wardsName = wardsName;
    }

    public String getDistrictId() {
        return _districtId;
    }

    public void setDistrictId(String districtId) {
        _districtId = districtId;
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
