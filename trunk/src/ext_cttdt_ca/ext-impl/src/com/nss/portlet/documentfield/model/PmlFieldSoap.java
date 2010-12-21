package com.nss.portlet.documentfield.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="PmlFieldSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.documentfield.service.http.PmlFieldServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.documentfield.service.http.PmlFieldServiceSoap
 *
 */
public class PmlFieldSoap implements Serializable {
    private String _fieldId;
    private String _fieldCode;
    private String _fieldName;
    private String _description;
    private String _active;
    private String _departmentsId;

    public PmlFieldSoap() {
    }

    public static PmlFieldSoap toSoapModel(PmlField model) {
        PmlFieldSoap soapModel = new PmlFieldSoap();

        soapModel.setFieldId(model.getFieldId());
        soapModel.setFieldCode(model.getFieldCode());
        soapModel.setFieldName(model.getFieldName());
        soapModel.setDescription(model.getDescription());
        soapModel.setActive(model.getActive());
        soapModel.setDepartmentsId(model.getDepartmentsId());

        return soapModel;
    }

    public static PmlFieldSoap[] toSoapModels(PmlField[] models) {
        PmlFieldSoap[] soapModels = new PmlFieldSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static PmlFieldSoap[][] toSoapModels(PmlField[][] models) {
        PmlFieldSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new PmlFieldSoap[models.length][models[0].length];
        } else {
            soapModels = new PmlFieldSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static PmlFieldSoap[] toSoapModels(List<PmlField> models) {
        List<PmlFieldSoap> soapModels = new ArrayList<PmlFieldSoap>(models.size());

        for (PmlField model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PmlFieldSoap[soapModels.size()]);
    }

    public String getPrimaryKey() {
        return _fieldId;
    }

    public void setPrimaryKey(String pk) {
        setFieldId(pk);
    }

    public String getFieldId() {
        return _fieldId;
    }

    public void setFieldId(String fieldId) {
        _fieldId = fieldId;
    }

    public String getFieldCode() {
        return _fieldCode;
    }

    public void setFieldCode(String fieldCode) {
        _fieldCode = fieldCode;
    }

    public String getFieldName() {
        return _fieldName;
    }

    public void setFieldName(String fieldName) {
        _fieldName = fieldName;
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

    public String getDepartmentsId() {
        return _departmentsId;
    }

    public void setDepartmentsId(String departmentsId) {
        _departmentsId = departmentsId;
    }
}
