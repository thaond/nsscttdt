package com.nss.portlet.agency.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="AgencySoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.agency.service.http.AgencyServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.agency.service.http.AgencyServiceSoap
 *
 */
public class AgencySoap implements Serializable {
    private String _agencyId;
    private String _agencyCode;
    private String _agencyName;
    private String _description;
    private String _active;

    public AgencySoap() {
    }

    public static AgencySoap toSoapModel(Agency model) {
        AgencySoap soapModel = new AgencySoap();

        soapModel.setAgencyId(model.getAgencyId());
        soapModel.setAgencyCode(model.getAgencyCode());
        soapModel.setAgencyName(model.getAgencyName());
        soapModel.setDescription(model.getDescription());
        soapModel.setActive(model.getActive());

        return soapModel;
    }

    public static AgencySoap[] toSoapModels(Agency[] models) {
        AgencySoap[] soapModels = new AgencySoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static AgencySoap[][] toSoapModels(Agency[][] models) {
        AgencySoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new AgencySoap[models.length][models[0].length];
        } else {
            soapModels = new AgencySoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static AgencySoap[] toSoapModels(List<Agency> models) {
        List<AgencySoap> soapModels = new ArrayList<AgencySoap>(models.size());

        for (Agency model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new AgencySoap[soapModels.size()]);
    }

    public String getPrimaryKey() {
        return _agencyId;
    }

    public void setPrimaryKey(String pk) {
        setAgencyId(pk);
    }

    public String getAgencyId() {
        return _agencyId;
    }

    public void setAgencyId(String agencyId) {
        _agencyId = agencyId;
    }

    public String getAgencyCode() {
        return _agencyCode;
    }

    public void setAgencyCode(String agencyCode) {
        _agencyCode = agencyCode;
    }

    public String getAgencyName() {
        return _agencyName;
    }

    public void setAgencyName(String agencyName) {
        _agencyName = agencyName;
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
