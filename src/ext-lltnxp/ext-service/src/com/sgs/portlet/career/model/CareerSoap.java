package com.sgs.portlet.career.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="CareerSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.career.service.http.CareerServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.career.service.http.CareerServiceSoap
 *
 */
public class CareerSoap implements Serializable {
    private String _careerId;
    private String _careerCode;
    private String _careerName;
    private String _description;
    private String _active;

    public CareerSoap() {
    }

    public static CareerSoap toSoapModel(Career model) {
        CareerSoap soapModel = new CareerSoap();

        soapModel.setCareerId(model.getCareerId());
        soapModel.setCareerCode(model.getCareerCode());
        soapModel.setCareerName(model.getCareerName());
        soapModel.setDescription(model.getDescription());
        soapModel.setActive(model.getActive());

        return soapModel;
    }

    public static CareerSoap[] toSoapModels(List<Career> models) {
        List<CareerSoap> soapModels = new ArrayList<CareerSoap>(models.size());

        for (Career model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new CareerSoap[soapModels.size()]);
    }

    public String getPrimaryKey() {
        return _careerId;
    }

    public void setPrimaryKey(String pk) {
        setCareerId(pk);
    }

    public String getCareerId() {
        return _careerId;
    }

    public void setCareerId(String careerId) {
        _careerId = careerId;
    }

    public String getCareerCode() {
        return _careerCode;
    }

    public void setCareerCode(String careerCode) {
        _careerCode = careerCode;
    }

    public String getCareerName() {
        return _careerName;
    }

    public void setCareerName(String careerName) {
        _careerName = careerName;
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
