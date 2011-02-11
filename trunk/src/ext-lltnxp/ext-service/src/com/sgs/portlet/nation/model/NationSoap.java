package com.sgs.portlet.nation.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="NationSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.nation.service.http.NationServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.nation.service.http.NationServiceSoap
 *
 */
public class NationSoap implements Serializable {
    private String _nationId;
    private String _nationCode;
    private String _nationName;
    private String _countryId;
    private String _description;
    private String _active;

    public NationSoap() {
    }

    public static NationSoap toSoapModel(Nation model) {
        NationSoap soapModel = new NationSoap();

        soapModel.setNationId(model.getNationId());
        soapModel.setNationCode(model.getNationCode());
        soapModel.setNationName(model.getNationName());
        soapModel.setCountryId(model.getCountryId());
        soapModel.setDescription(model.getDescription());
        soapModel.setActive(model.getActive());

        return soapModel;
    }

    public static NationSoap[] toSoapModels(List<Nation> models) {
        List<NationSoap> soapModels = new ArrayList<NationSoap>(models.size());

        for (Nation model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new NationSoap[soapModels.size()]);
    }

    public String getPrimaryKey() {
        return _nationId;
    }

    public void setPrimaryKey(String pk) {
        setNationId(pk);
    }

    public String getNationId() {
        return _nationId;
    }

    public void setNationId(String nationId) {
        _nationId = nationId;
    }

    public String getNationCode() {
        return _nationCode;
    }

    public void setNationCode(String nationCode) {
        _nationCode = nationCode;
    }

    public String getNationName() {
        return _nationName;
    }

    public void setNationName(String nationName) {
        _nationName = nationName;
    }

    public String getCountryId() {
        return _countryId;
    }

    public void setCountryId(String countryId) {
        _countryId = countryId;
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
