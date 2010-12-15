package com.nss.portlet.generatetemplateid.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="IdGeneratedSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.generatetemplateid.service.http.IdGeneratedServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.generatetemplateid.service.http.IdGeneratedServiceSoap
 *
 */
public class IdGeneratedSoap implements Serializable {
    private long _id;
    private String _year;
    private long _curValue;

    public IdGeneratedSoap() {
    }

    public static IdGeneratedSoap toSoapModel(IdGenerated model) {
        IdGeneratedSoap soapModel = new IdGeneratedSoap();

        soapModel.setId(model.getId());
        soapModel.setYear(model.getYear());
        soapModel.setCurValue(model.getCurValue());

        return soapModel;
    }

    public static IdGeneratedSoap[] toSoapModels(IdGenerated[] models) {
        IdGeneratedSoap[] soapModels = new IdGeneratedSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static IdGeneratedSoap[][] toSoapModels(IdGenerated[][] models) {
        IdGeneratedSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new IdGeneratedSoap[models.length][models[0].length];
        } else {
            soapModels = new IdGeneratedSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static IdGeneratedSoap[] toSoapModels(List<IdGenerated> models) {
        List<IdGeneratedSoap> soapModels = new ArrayList<IdGeneratedSoap>(models.size());

        for (IdGenerated model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new IdGeneratedSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _id;
    }

    public void setPrimaryKey(long pk) {
        setId(pk);
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public String getYear() {
        return _year;
    }

    public void setYear(String year) {
        _year = year;
    }

    public long getCurValue() {
        return _curValue;
    }

    public void setCurValue(long curValue) {
        _curValue = curValue;
    }
}
